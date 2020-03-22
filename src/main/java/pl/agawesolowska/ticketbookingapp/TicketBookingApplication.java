package pl.agawesolowska.ticketbookingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Seat reservation system for a multiplex - REST service.
 * 
 * @author Aga Wesołowska
 *
 */
@SpringBootApplication
public class TicketBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApplication.class, args);
	}

}
