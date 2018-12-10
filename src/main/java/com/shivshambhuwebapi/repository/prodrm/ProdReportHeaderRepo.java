package com.shivshambhuwebapi.repository.prodrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.prodrm.ProdReportHeader;

public interface ProdReportHeaderRepo extends JpaRepository<ProdReportHeader,Integer>{
	
	@Query(value = " SELECT t_production_plan_detail.item_id,m_item_fg.item_name,m_item_fg.item_code,sum(t_production_plan_detail.plan_qty) "
			+ " AS plan_qty,sum(t_production_plan_detail.production_qty) as production_qty, t_production_plan_detail.status,m_uom.uom_name "
			+ " FROM t_production_plan_detail,t_production_plan_header,m_item_fg,m_uom "
			+ " WHERE t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id "
			+ " AND t_production_plan_detail.item_id=m_item_fg.item_id AND m_uom.uom_id=m_item_fg.uom_id " + 
			" AND t_production_plan_header.production_date BETWEEN :fromDate And :toDate AND t_production_plan_header.plant_id=:plantId AND " + 
			" t_production_plan_header.del_status=1 AND t_production_plan_detail.del_status=1 "
			+ " AND m_item_fg.del_status=1 AND m_uom.del_status=1 " + 
			" GROUP by t_production_plan_detail.item_id  ORDER BY  m_item_fg.plant_id DESC ", nativeQuery = true)
	List<ProdReportHeader> getProdReportHeader(@Param("plantId") int plantId,@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
