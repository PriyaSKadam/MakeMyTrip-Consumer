package in.priya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.priya.binding.Passenger;
import in.priya.binding.Ticket;
import in.priya.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService MMTService;
	
	@GetMapping("/bookTicket")
	public String getPassenger(Model model)
	{
	       model.addAttribute("p",new Passenger())	;
		
		return "bookTicket";
	}
	
	@PostMapping("/book")
	public String book(@ModelAttribute("p") Passenger p,Model model)
	{
		Ticket t=MMTService.bookTicket(p);
		model.addAttribute("msg","Ticked Confirmed ... Ticket Number : "+t.getTicketNum());
		
		return "bookTicket";
	}
	
	@GetMapping("index")
	public String getTickets( Model model)
	{
		 List<Ticket> list=MMTService.getAllTickets();
		 model.addAttribute("tickets", list);
		return "index";
	}

}
