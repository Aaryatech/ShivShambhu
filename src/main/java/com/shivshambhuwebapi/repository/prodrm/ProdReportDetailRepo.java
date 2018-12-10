package com.shivshambhuwebapi.repository.prodrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.prodrm.ProdReportDetail;

public interface ProdReportDetailRepo extends JpaRepository<ProdReportDetail, Integer>{
	
	
	@Query(value = " SELECT " + 
			"t_production_plan_detail.production_detail_id," + 
			"t_production_plan_header.production_date," + 
			"        t_production_plan_detail.item_id," + 
			"        m_item_fg.item_name," + 
			"        m_item_fg.item_code," + 
			"        t_production_plan_detail.plan_qty, " + 
			"        t_production_plan_detail.production_qty," + 
			"        t_production_plan_detail.status," + 
			"        t_production_plan_detail.production_batch," + 
			"        m_uom.uom_name  " + 
			"    FROM" + 
			"        t_production_plan_detail," + 
			"        t_production_plan_header," + 
			"        m_item_fg," + 
			"        m_uom  " + 
			"    WHERE" + 
			"        t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id  " + 
			"        AND t_production_plan_detail.item_id=m_item_fg.item_id " + 
			"        AND m_uom.uom_id=m_item_fg.uom_id  " + 
			"        AND t_production_plan_header.production_date BETWEEN :fromDate AND :toDate " + 
			"        AND t_production_plan_header.plant_id=:plantId " + 
			"        AND  t_production_plan_header.del_status=1 " + 
			"        AND t_production_plan_detail.del_status=1  " + 
			"        AND m_item_fg.del_status=1 " + 
			"        AND m_uom.del_status=1  " + 
			"        AND t_production_plan_detail.item_id=:itemId " + 
			"    ORDER BY" + 
			"        t_production_plan_header.production_date ", nativeQuery = true)
	
	List<ProdReportDetail>  getProdReportDetail(@Param("plantId") int plantId,@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("itemId") int itemId);
	
	

}
