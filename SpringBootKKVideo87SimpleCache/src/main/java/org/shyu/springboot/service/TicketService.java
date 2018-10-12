package org.shyu.springboot.service;

import org.shyu.springboot.model.Ticket;
import org.shyu.springboot.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	
	@Cacheable(value="ticketsCache", key="#ticketId", unless="#result==null")
	public Ticket getTicketById(Integer ticketId) {
		return ticketRepository.findById(ticketId).get();
	}
	
	@CacheEvict(value="ticketsCache", key="#ticketId")
	public void deleteTicketById(Integer ticketId) {
		ticketRepository.deleteById(ticketId);
	}
	
	@CachePut(value="ticketsCache", key="#ticketId")
	public Ticket updateTicketEmail(Integer ticketId, String email) {
		Ticket ticketFromDB = ticketRepository.findById(ticketId).get();
		ticketFromDB.setEmail(email);
		Ticket ticket = ticketRepository.save(ticketFromDB);
		return ticket;
	}
}
