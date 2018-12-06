package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.Weighing;

public interface WeighingRepo extends JpaRepository<Weighing, Integer> {

	Weighing findByWeighIdAndDelStatus(int weighId, int i);

	List<Weighing> findByDelStatusOrderByWeighIdDesc(int i);

	@Transactional
	@Modifying
	@Query("UPDATE Weighing SET del_status=0  WHERE weigh_id=:weighId")
	int deleteWeighing(@Param("weighId") int weighId);

	@Transactional
	@Modifying
	@Query("UPDATE Weighing SET delStatus=0  WHERE weighId IN(:weighIds)")
	int deleteMultiWeighing(@Param("weighIds") List<Integer> weighIds);

}
