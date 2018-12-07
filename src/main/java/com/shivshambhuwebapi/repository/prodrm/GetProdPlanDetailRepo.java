package com.shivshambhuwebapi.repository.prodrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.prodrm.GetProdPlanDetail;

public interface GetProdPlanDetailRepo extends JpaRepository<GetProdPlanDetail, Integer> {
	
	@Query(value = " SELECT t_production_plan_detail.* ,m_item_fg.item_name,m_item_fg.item_code,m_uom.uom_name " + 
			" FROM t_production_plan_detail,m_item_fg,m_uom " + 
			" WHERE t_production_plan_detail.del_status=1 AND m_item_fg.del_status=1 AND m_uom.del_status=1 " + 
			" AND t_production_plan_detail.item_id=m_item_fg.item_id AND m_item_fg.uom_id=m_uom.uom_id " + 
			" AND t_production_plan_detail.production_header_id=:prodHeaderId ", nativeQuery = true)

	
	List<GetProdPlanDetail> getGetProdPlanDetailNByProdHeadId(@Param("prodHeaderId") int prodHeaderId);

}
