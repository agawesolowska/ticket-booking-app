package pl.agawesolowska.ticketbookingapp.dao;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import pl.agawesolowska.ticketbookingapp.model.entity.Screening;

/**
 * @author Aga Wesołowska
 *
 */
public interface ScreeningRepository extends JpaRepository<Screening, Long> {

	Page<Screening> findByScreeningDateTimeBetween(
			@RequestParam("startDateTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDateTime,
			@RequestParam("endDateTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDateTime,
			Pageable pageable);

}
