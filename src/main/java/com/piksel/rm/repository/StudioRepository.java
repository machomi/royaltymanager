package com.piksel.rm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piksel.rm.domain.Studio;
import com.piksel.rm.service.dto.PaymentDTO;

/**
 * Spring Data JPA repository for the Studio entity.
 */
public interface StudioRepository extends JpaRepository<Studio, String> {

	@Query("select new com.piksel.rm.service.dto.PaymentDTO(s.id, s.name, s.payment, sum(e.viewsCounter)) FROM Studio s INNER JOIN s.episodes e GROUP BY s.id")
	public List<PaymentDTO> calculateAllPayments(Pageable page);

	@Query("select new com.piksel.rm.service.dto.PaymentDTO(s.id, s.name, s.payment, sum(e.viewsCounter)) FROM Studio s INNER JOIN s.episodes e WHERE s.id = :id GROUP BY s.id")
	public Optional<PaymentDTO> calculatePayment(@Param("id") String id);

}
