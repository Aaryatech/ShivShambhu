package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetProject;

public interface GetProjectRepo extends JpaRepository<GetProject, Integer> {

	@Query(value = "SELECT p.*,c.cust_name,n.plant_name FROM m_project p,m_customer c ,m_plant n WHERE p.del_status=1 AND c.cust_id=p.cust_id AND c.plant_id=n.plant_id ORDER BY p.proj_id DESC", nativeQuery = true)
	List<GetProject> getAllProList();

	@Query(value = "SELECT p.*,c.cust_name,n.plant_name FROM m_project p,m_customer c ,m_plant n WHERE p.del_status=1 AND c.cust_id=p.cust_id AND c.plant_id=n.plant_id AND n.plant_id=c.plant_id AND c.plant_id=:plantId ORDER BY p.proj_id DESC", nativeQuery = true)
	List<GetProject> getAllProListByPlantId(@Param("plantId") int plantId);

	/*
	 * @Query(value =
	 * "SELECT p.*,c.comp_name FROM m_plant p,m_company c  WHERE p.del_status=1 AND p.company_id=c.company_id AND p.plant_id=:plantId"
	 * , nativeQuery = true) GetPlant getPlantByPlantId(@Param("plantId") int
	 * plantId);
	 */

}
