package com.shivshambhuwebapi.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.DashPlant;

public interface DashPlantRepo extends JpaRepository<DashPlant, Integer> {

	@Query(value = "SELECT\n" + "coalesce ((\n"
			+ "SELECT SUM(h.total_amt)  FROM t_bill_header h,m_plant p,t_setting_shiv s  WHERE h. del_status=1 AND "
			+ "h.ex_int1=p.plant_id AND s.setting_key=6 AND s.setting_value=p.plant_id AND h.bill_date BETWEEN "
			+ ":fromDate AND :toDate),'0') AS total_bill_amount,\n" + "coalesce ((\n"
			+ "SELECT SUM(qtytotal) as contr_exp FROM (\n"
			+ "SELECT (SUM(t.qty_total)*m.contr_rate) as qtytotal FROM t_mat_issue_contra_header as t,m_contractor "
			+ "as m WHERE t.date BETWEEN :fromDate AND :toDate AND t.del_status = 1 AND t.contr_id=m.contr_id "
			+ "GROUP BY t.contr_id)\n" + "                 as qtytotal),0)as contr_expenses,\n"
			+ "COALESCE ((                \n" + "SELECT SUM(veh) as veh_expenses FROM (\n"
			+ "SELECT SUM(veh_total)as veh FROM `t_issue_veh_header` WHERE `date` BETWEEN :fromDate AND :toDate "
			+ "AND `del_status` = 1 GROUP BY veh_id) as veh),0) as veh_expenses,\n" + "coalesce ((\n"
			+ "SELECT SUM(h.total_amt)  FROM t_bill_header h,m_plant p,t_setting_shiv s  WHERE h. del_status=1 AND "
			+ "h.ex_int1=p.plant_id AND s.setting_key=7 AND s.setting_value=p.plant_id AND h.bill_date BETWEEN :fromDate"
			+ " AND :toDate),'0') AS total_bill_amt_rubber", nativeQuery = true)
	DashPlant getDashPlantCount(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
