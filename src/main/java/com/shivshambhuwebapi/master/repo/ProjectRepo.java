package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Project SET delStatus=0  WHERE proj_id=:projId")
	int deleteProject(@Param("projId") int projId);

	List<Project> findByDelStatusOrderByProjIdDesc(int i);

	Project findByProjIdAndDelStatus(int projId, int i);

}
