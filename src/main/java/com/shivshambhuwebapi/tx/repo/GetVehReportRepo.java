package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetVehReport;

public interface GetVehReportRepo extends JpaRepository<GetVehReport, Integer> {

	@Query(value = "SELECT h.mat_veh_header_id,h.veh_no,h.veh_id,h.date,h.user_id,SUM(h.veh_total) AS veh_total,SUM(h.veh_qty_total) "
			+ "AS veh_qty_total,h.del_status,h.reading,h.ex_int1,h.ex_int2,h.ex_var1,h.ex_var2,h.ex_bool1,h.ex_date1,h.ex_int3,"
			+ "h.ex_var3,h.ex_date2,h.ex_bool2,v.vehicle_name,v.veh_comp_name ,coalesce((SELECT SUM(w.quantity) "
			+ "  FROM t_weighing w WHERE w.del_status=1  AND w.veh_id=h.veh_id GROUP BY w.veh_id),'0') as weigh_contr_qty  "
			+ "FROM t_issue_veh_header h,m_vehicle v ,t_weighing w WHERE h.del_status=1 AND h.veh_id=v.vehicle_id AND h.date "
			+ "BETWEEN :fromDate AND :toDate  GROUP BY h.veh_id", nativeQuery = true)
	List<GetVehReport> getVehicleBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
