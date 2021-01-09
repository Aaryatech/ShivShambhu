package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.States;

public interface StatesRepo extends JpaRepository<States, Integer> {

	@Query(value="SELECT * FROM m_state", nativeQuery=true)
	List<States> getAllStates();
	
	@Query(value="SELECT\n" + 
			"    s.*\n" + 
			"FROM\n" + 
			"    m_state s, \n" + 
			"    m_customer c\n" + 
			"WHERE\n" + 
			"    s.state_id=c.ex_int3 AND\n" + 
			"    c.cust_id=:custId",nativeQuery=true)
	States getStateByCustId(@Param("custId") int custId);
}
