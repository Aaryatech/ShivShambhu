package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.OtherExpenses;

public interface OtherExpensesRepo extends JpaRepository<OtherExpenses, Integer> {

	List<OtherExpenses> findByDelStatusOrderByOtherExpIdDesc(int i);

	OtherExpenses findByOtherExpIdAndDelStatus(int otherExpId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE OtherExpenses SET delStatus=0  WHERE otherExpId=:otherExpId")
	int deleteOtherExpenses(@Param("bankDetId") int otherExpId);

	@Transactional
	@Modifying
	@Query("UPDATE OtherExpenses SET delStatus=0  WHERE otherExpId IN(:otherExpIds)")
	int deleteMultiOtherExpenses(@Param("otherExpIds") List<Integer> otherExpIds);

}
