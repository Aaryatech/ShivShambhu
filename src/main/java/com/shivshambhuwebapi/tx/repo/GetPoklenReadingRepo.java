package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetPoklenReading;

public interface GetPoklenReadingRepo extends JpaRepository<GetPoklenReading, Integer> {

	@Query(value = "SELECT  p.*,v.veh_no,v.vehicle_name  FROM t_poklen_reading p , m_vehicle v  WHERE p.del_status=1 AND "
			+ "p.start_date BETWEEN :fromDate AND :toDate AND p.poklen_id=v.vehicle_id AND p.ex_int1=2", nativeQuery = true)
	List<GetPoklenReading> getPoklenReadingListBetDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT p.*,v.veh_no,v.vehicle_name FROM t_poklen_reading p , m_vehicle v\n"
			+ "	WHERE p.del_status=1 AND p.poklen_id=v.vehicle_id AND p.poklen_id=:poklenId ", nativeQuery = true)
	List<GetPoklenReading> getPoklenReadingListByPoklenId(@Param("poklenId") int poklenId);

	@Query(value = "SELECT p.*,v.veh_no,v.vehicle_name FROM t_poklen_reading p , m_vehicle v\n"
			+ "	WHERE p.del_status=1 AND p.poklen_id=v.vehicle_id AND p.ex_int1=:status ", nativeQuery = true)
	List<GetPoklenReading> getPoklenReadingListByStatus(@Param("status") int status);
	
	
	

	//
}
