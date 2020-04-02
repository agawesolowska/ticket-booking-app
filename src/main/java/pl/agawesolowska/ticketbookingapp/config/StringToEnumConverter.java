package pl.agawesolowska.ticketbookingapp.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.agawesolowska.ticketbookingapp.entity.TicketType;

@Component
public class StringToEnumConverter implements Converter<String, TicketType> {

	@Override
	public TicketType convert(String source) {

		// remove the try-catch block in case of handling the exception globally in GlobalControllerExceptionHandler
		try {
			return TicketType.valueOf(source.toUpperCase());
		} catch (IllegalArgumentException e) {
			return null;
		}

	}

}
