package in.priya.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.priya.binding.Passenger;
import in.priya.binding.Ticket;

@Service
public class MakeMyTripService {
	
	 public Ticket bookTicket(Passenger p)
	 {
		 RestTemplate rt=new RestTemplate();
		 
		 String postUrl="http://43.205.144.253:8080/ticket";
		 
		 ResponseEntity<Ticket> entity= rt.postForEntity(postUrl, p,Ticket.class);
		 
		  Ticket t=entity.getBody();
		  
		 return t;
	 }

	 public List<Ticket> getAllTickets()
	 {
		 String getUrl="http://43.205.144.253:8080/tickets";
		 RestTemplate rt=new RestTemplate();
		 
		 ResponseEntity<Ticket[]> entity= rt.getForEntity(getUrl, Ticket[].class);
		 
		 List<Ticket> list=Arrays.asList(entity.getBody());
		 
		 return list;
	 }
}
