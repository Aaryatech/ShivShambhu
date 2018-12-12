package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.PoklenReport;

public interface PoklenReportRepo extends JpaRepository<PoklenReport, Integer> {

	@Query(value = "select m_vehicle.vehicle_id,m_vehicle.veh_no,m_vehicle.vehicle_name,coalesce((select\n" + 
			"           sum(t_issue_veh_header.veh_total) \n" + 
			"        from\n" + 
			"            t_issue_veh_header \n" + 
			"        where\n" + 
			"            m_vehicle.vehicle_id=t_issue_veh_header.veh_id AND t_issue_veh_header.date BETWEEN :fromDate AND :toDate\n" + 
			"            ),\n" + 
			"        0) as total_consumption,\n" + 
			"        coalesce((select\n" + 
			"           SEC_TO_TIME(SUM(TIME_TO_SEC(timediff(t_poklen_reading.end_time,t_poklen_reading.start_time)))) \n" + 
			"        from\n" + 
			"            t_poklen_reading \n" + 
			"        where\n" + 
			"            m_vehicle.vehicle_id=t_poklen_reading.poklen_id and t_poklen_reading.pok_type=1 AND t_poklen_reading.start_date BETWEEN :fromDate AND :toDate\n" + 
			"            ),\n" + 
			"        0) as total_loading_hr,\n" + 
			"        coalesce((select\n" + 
			"           SEC_TO_TIME(SUM(TIME_TO_SEC(timediff(t_poklen_reading.end_time,t_poklen_reading.start_time)))) \n" + 
			"        from\n" + 
			"            t_poklen_reading \n" + 
			"        where\n" + 
			"            m_vehicle.vehicle_id=t_poklen_reading.poklen_id and t_poklen_reading.pok_type=0 AND t_poklen_reading.start_date BETWEEN :fromDate AND :toDate\n" + 
			"            ),\n" + 
			"        0) as total_breaking_hr,\n" + 
			"coalesce((select\n" + 
			"           sum(t_weighing.quantity) \n" + 
			"        from\n" + 
			"            t_weighing \n" + 
			"        where\n" + 
			"            m_vehicle.vehicle_id=t_weighing.poklen_id \n" + 
			"            ),\n" + 
			"        0) as total_qty_load \n" + 
			"        FROM m_vehicle WHERE m_vehicle.vehicle_type=3", nativeQuery = true)
	List<PoklenReport> getPoklenReportBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
