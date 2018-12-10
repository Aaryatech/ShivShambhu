package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetPoklenReading;

public interface GetPoklenReadingRepo extends JpaRepository<GetPoklenReading, Integer> {

	@Query(value = "SELECT  p.*,v.veh_no,v.vehicle_name  FROM t_poklen_reading p , m_vehicle v  WHERE p.del_status=1 AND "
			+ "p.start_date BETWEEN :fromDate AND :toDate AND p.pok_id=v.vehicle_id ", nativeQuery = true)
	List<GetPoklenReading> getPoklenReadingListBetDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

}