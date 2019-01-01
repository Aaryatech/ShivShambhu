package com.shivshambhuwebapi.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.DashPlant;

public interface DashPlantRepo extends JpaRepository<DashPlant, Integer> {

	@Query(value = "  SELECT coalesce ((\n" + 
			"SELECT SUM(h.total_amt)  FROM t_bill_header h,m_company c,m_plant p,t_setting_shiv s  WHERE h. del_status=1 AND c.company_id=h.company_id AND c.company_id=p.company_id AND s.setting_key=6 AND s.setting_value=p.plant_id AND h.bill_date BETWEEN :fromDate AND :toDate),'0') AS total_bill_amount,\n" + 
			"coalesce ((\n" + 
			"SELECT SUM(qtytotal) as contr_exp FROM (SELECT (SUM(t.qty_total)*m.contr_rate) as qtytotal FROM t_mat_issue_contra_header as t,m_contractor as m WHERE t.date BETWEEN :fromDate AND :toDate AND t.del_status = 1 AND t.contr_id=m.contr_id GROUP BY t.contr_id)as qtytotal),0)as contr_expenses,\n" + 
			"COALESCE ((                \n" + 
			"SELECT SUM(veh) as veh_expenses FROM (\n" + 
			"SELECT SUM(veh_total)as veh FROM `t_issue_veh_header` WHERE `date` BETWEEN :fromDate AND :toDate AND `del_status` = 1 GROUP BY veh_id) as veh),0) as veh_expenses,\n" + 
			"coalesce ((\n" + 
			"SELECT SUM(h.total_amt)  FROM t_bill_header h,m_company c,m_plant p,t_setting_shiv s  WHERE h. del_status=1 AND c.company_id=h.company_id AND c.company_id=p.company_id AND s.setting_key=7 AND s.setting_value=p.plant_id AND h.bill_date BETWEEN :fromDate AND :toDate),'0') AS total_bill_amt_rubber,\n" + 
			"coalesce ((\n" + 
			"SELECT SUM(h.total_amt)  FROM t_bill_header h,m_company c,m_plant p,t_setting_shiv s  WHERE h. del_status=1 AND c.company_id=h.company_id AND c.company_id=p.company_id AND s.setting_key=8 AND s.setting_value=p.plant_id AND h.bill_date BETWEEN :fromDate AND :toDate),'0') AS total_bill_amt_rmc,\n" + 
			"coalesce (( \n" + 
			"SELECT SUM(id.item_issue_qty*pd.item_rate)AS total_issue_expenses FROM item_issue_header ih ,item_issue_detail id ,t_setting_shiv s ,t_mrn_detail md,po_detail pd WHERE id.del_status=1 AND id.dept_id=s.setting_value AND s.setting_id=8 AND md.mrn_detail_id=id.mrn_detail_id AND pd.po_detail_id=md.po_detail_id AND id.issue_id=ih.issue_id AND ih.issue_date BETWEEN :fromDate AND :toDate AND ih.delete_status=1 ),0)as total_issue_expenses,\n" + 
			"coalesce (( \n" + 
			"SELECT SUM(id.item_issue_qty*pd.item_rate)AS total_issue_expenses FROM item_issue_header ih ,item_issue_detail id ,t_setting_shiv s ,t_mrn_detail md,po_detail pd WHERE id.del_status=1 AND id.dept_id=s.setting_value AND s.setting_id=9 AND md.mrn_detail_id=id.mrn_detail_id AND pd.po_detail_id=md.po_detail_id AND id.issue_id=ih.issue_id AND ih.issue_date BETWEEN :fromDate AND :toDate AND ih.delete_status=1 ),0)as total_issue_exp_rmc,\n" + 
			"coalesce\n" + 
			"((SELECT SUM(pd.paid_amt) FROM t_pay_recovery_detail as pd WHERE pd.payment_date BETWEEN :fromDate AND :toDate AND pd.del_status = 1 ),'0') AS payment_rec_paid,\n" + 
			"coalesce (( SELECT SUM(ph.pending_amt) FROM t_pay_recovery_header as ph  WHERE ph.credit_date2 BETWEEN  :fromDate AND :toDate AND ph.del_status = 1 ),'0') AS payment_rec_outstanding_pending,\n" + 
			"coalesce ((\n" + 
			"SELECT SUM(o.amount) AS other_exp_total FROM other_expenses o,t_setting_shiv s WHERE o.del_status=1 AND s.setting_value=o.plant_id AND s.setting_id=6 AND o.date BETWEEN :fromDate AND :toDate),'0') AS other_exp_total,\n" + 
			"coalesce ((\n" + 
			"SELECT SUM(o.amount) AS other_exp_total FROM other_expenses o,t_setting_shiv s WHERE o.del_status=1 AND s.setting_value=o.plant_id AND s.setting_id=7 AND o.date BETWEEN :fromDate AND :toDate),'0') AS other_exp_total_rubber,\n" + 
			"coalesce ((\n" + 
			"SELECT SUM(o.amount) AS other_exp_total FROM other_expenses o,t_setting_shiv s WHERE o.del_status=1 AND s.setting_value=o.plant_id AND s.setting_id=8 AND o.date BETWEEN :fromDate AND :toDate),'0') AS other_exp_total_rmc", nativeQuery = true)
	DashPlant getDashPlantCount(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
