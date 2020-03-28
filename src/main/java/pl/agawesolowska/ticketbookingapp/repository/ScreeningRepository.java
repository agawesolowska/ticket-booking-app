package pl.agawesolowska.ticketbookingapp.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import pl.agawesolowska.ticketbookingapp.entity.Screening;

/**
 * @author Aga Wesołowska
 *
 */
public interface ScreeningRepository extends JpaRepository<Screening, Long> {

	Page<Screening> findByScreeningDateAndScreeningTimeBetween(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestParam("startTime") @DateTimeFormat(pattern = "HH:mm:ss") LocalTime startTime,
			@RequestParam("endTime") @DateTimeFormat(pattern = "HH:mm:ss") LocalTime endTime, Pageable pageable);

}
