package com.shivshambhuwebapi.repository.prodrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.prodrm.FgItemWiseRMReport;

public interface FgItemWiseRMReportRepo extends JpaRepository<FgItemWiseRMReport, Integer>{
	

	@Query(value = " SELECT t_req_bom_detail.rm_id, SUM(t_req_bom_detail.rm_req_qty)as rm_req_qty,"
			+ " SUM(t_req_bom_detail.rm_issue_qty) as rm_issue_qty, SUM(t_req_bom_detail.rejected_qty) "
			+ " as rejected_qty, m_item.item_code,m_item.item_desc,m_uom.uom_name from t_req_bom_detail,"
			+ " t_req_bom,m_item,m_uom,t_production_plan_header,t_production_plan_detail,m_item_detail "
			+ " WHERE t_production_plan_detail.item_id=m_item_detail.item_id AND "
			+ " t_production_plan_detail.production_header_id=t_production_plan_header.production_header_id"
			+ " AND t_production_plan_header.production_header_id=t_req_bom.production_id AND"
			+ " t_production_plan_header.production_date BETWEEN :fromDate AND :toDate "
			+ " AND t_req_bom_detail.rm_id=m_item.item_id AND m_item_detail.item_id=:itemId AND "
			+" t_req_bom.plant_id=:plantId AND "
			+ " t_req_bom_detail.bom_req_id=t_req_bom.bom_req_id AND m_item_detail.rm_id=t_req_bom_detail.rm_id "
			+ " AND m_item.item_uom2=m_uom.uom_id GROUP BY m_item_detail.rm_id ", nativeQuery = true)
	
	List<FgItemWiseRMReport> getFgItemWiseRMReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("plantId") int plantId,@Param("itemId") int itemId);

}
