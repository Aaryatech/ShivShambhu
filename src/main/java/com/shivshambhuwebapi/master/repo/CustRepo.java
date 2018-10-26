package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.Cust;

public interface CustRepo extends JpaRepository<Cust, Integer> {

	Cust findByCustIdAndDelStatus(int custId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE Cust SET isUsed=0  WHERE cust_id=:custId")
	int deleteCust(@Param("custId") int custId);

	List<Cust> findByDelStatusOrderByCustIdDesc(int i);

}
