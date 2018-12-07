package com.shivshambhuwebapi.repository.prodrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.prodrm.GetProdPlanHeader;

public interface GetProdPlanHeaderRepo extends JpaRepository<GetProdPlanHeader, Integer>{
	
	@Query(value = " SELECT t_production_plan_header.*, m_plant.plant_name,m_user.usr_name,m_subplant.subplant_name " + 
			" FROM t_production_plan_header,m_plant, m_user, m_subplant " + 
			" WHERE t_production_plan_header.del_status=1 AND m_plant.del_status=1 AND m_user.del_status=1 AND m_subplant.del_status=1 "
			+ " AND t_production_plan_header.plant_id=m_plant.plant_id AND t_production_plan_header.sub_plant_id=m_subplant.subplant_id "
			+ " AND m_plant.plant_id=m_subplant.plant_id " + 
			" AND t_production_plan_header.user_id=m_user.user_id " + 
			" AND t_production_plan_header.production_date BETWEEN :fromDate AND :toDate AND t_production_plan_header.plant_id=:plantId ", nativeQuery = true)

	List<GetProdPlanHeader> getGetProdPlanHeaderByProdDateBet(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("plantId") int plantId);
	
	
	@Query(value = " SELECT t_production_plan_header.*, m_plant.plant_name,m_user.usr_name,m_subplant.subplant_name " + 
			" FROM t_production_plan_header,m_plant, m_user, m_subplant " + 
			" WHERE t_production_plan_header.del_status=1 AND m_plant.del_status=1 AND m_user.del_status=1 AND m_subplant.del_status=1 "
			+ " AND t_production_plan_header.plant_id=m_plant.plant_id AND t_production_plan_header.sub_plant_id=m_subplant.subplant_id "
			+ " AND m_plant.plant_id=m_subplant.plant_id " + 
			" AND t_production_plan_header.user_id=m_user.user_id AND " + 
			" t_production_plan_header.production_header_id=:prodHeaderId ", nativeQuery = true)

	GetProdPlanHeader getGetProdPlanHeaderByProdId(
			@Param("prodHeaderId") int prodHeaderId);

}
