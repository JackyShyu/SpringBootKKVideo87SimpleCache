package org.shyu.springboot.controller;

import org.shyu.springboot.model.Ticket;
import org.shyu.springboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value="/tickets/{ticketId}", method=RequestMethod.GET)
	public Ticket getTicketById(@PathVariable("ticketId") Integer id) {
		return ticketService.getTicketById(id);
	}
	
	@RequestMapping(value="/tickets/{ticketId}", method=RequestMethod.DELETE)
	public void deleteTicketById(@PathVariable("ticketId") Integer id) {
		ticketService.deleteTicketById(id);
	}
	
	@RequestMapping(value="/tickets/{ticketId}/{email:.+}", method=RequestMethod.PUT)
	public Ticket updateTicketEmail(@PathVariable("ticketId") Integer id, @PathVariable("email") String email) {
		return ticketService.updateTicketEmail(id, email);
	}
}
