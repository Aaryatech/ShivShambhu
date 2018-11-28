package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.Dept;

public interface DeptRepo extends JpaRepository<Dept, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Dept SET delStatus=0  WHERE dept_id=:deptId")
	int deleteDept(@Param("deptId") int deptId);

	@Transactional
	@Modifying
	@Query("UPDATE Dept SET delStatus=0  WHERE dept_id IN(:deptIds)")
	int deleteMultiDept(@Param("deptIds") List<Integer> deptIds);

	Dept findByDeptIdAndDelStatus(int deptId, int i);

	List<Dept> findByDelStatusOrderByDeptIdDesc(int i);

	Dept findByDeptNameAndDelStatus(String deptName, int i);


}
