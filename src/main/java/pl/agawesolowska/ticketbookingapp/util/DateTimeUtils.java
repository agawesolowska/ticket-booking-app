package pl.agawesolowska.ticketbookingapp.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * @author Aga Wesołowska
 *
 */
public class DateTimeUtils {

	public static boolean isWeekend(LocalDateTime dateTime) {
		DayOfWeek dayOfWeek = DayOfWeek.of(dateTime.get(ChronoField.DAY_OF_WEEK));
		switch (dayOfWeek) {
		case FRIDAY:
		case SATURDAY:
		case SUNDAY:
			return true;
		default:
			return false;
		}
	}

}
