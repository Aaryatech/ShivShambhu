package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.EnqGenFact;

public interface EnqGenFactRepo extends JpaRepository<EnqGenFact, Integer> {
	@Transactional
	@Modifying
	@Query("UPDATE EnqGenFact SET delStatus=0  WHERE enqGenId=:enqGenId")
	int deleteEnqGenFact(@Param("enqGenId") int enqGenId);

	EnqGenFact findByEnqGenIdAndDelStatus(int enqGenId, int i);

	List<EnqGenFact> findByDelStatusOrderByEnqGenIdDesc(int i);

	@Transactional
	@Modifying
	@Query("UPDATE EnqGenFact SET delStatus=0  WHERE enqGenId IN(:enqGenIds)")
	int deleteMultiEnqGenFact(@Param("enqGenIds") List<Integer> enqGenIds);

	EnqGenFact findByEnqGenByAndDelStatus(String enqGenBy, int i);

}
