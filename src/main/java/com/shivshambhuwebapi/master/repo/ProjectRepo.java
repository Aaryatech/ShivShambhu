package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.Cust;
import com.shivshambhuwebapi.master.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Project SET delStatus=0  WHERE proj_id=:projId")
	int deleteProject(@Param("projId") int projId);

	List<Project> findByDelStatusOrderByProjIdDesc(int i);

	Project findByProjIdAndDelStatus(int projId, int i);

	List<Project> findByCustIdAndDelStatus(int custId, int delStatus);

	@Transactional
	@Modifying
	@Query("UPDATE Project SET delStatus=0  WHERE projId IN(:projIds)")
	int deleteMultiProject(@Param("projIds") List<Integer> projIds);
	
	
	//Sachin 28 Dec 2018 for Quot Print
	
	//Sachin 27 Dec 2018
			@Query(value = ""
					+ "SELECT m_project.* from m_project,t_quot_header WHERE t_quot_header.proj_id=m_project.proj_id"
					+ " AND t_quot_header.quot_head_id=:quotIdList  ", nativeQuery = true)
		Project getProjectByQuotIdList(@Param("quotIdList") int quotIdList);
	
}
