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
	@Query("UPDATE Cust SET del_status=0  WHERE cust_id=:custId")
	int deleteCust(@Param("custId") int custId);

	List<Cust> findByDelStatusOrderByCustIdDesc(int i);

	List<Cust> findByDelStatusAndPlantIdOrderByCustIdDesc(int i, int plantId);

	@Transactional
	@Modifying
	@Query("UPDATE Cust SET delStatus=0  WHERE custId IN(:custIds)")
	int deleteMultiCust(@Param("custIds") List<Integer> custIds);

	Cust findByCustMobNoAndDelStatus(String custMobNo, int i);

	List<Cust> findByDelStatus(int i);

	List<Cust> findByPlantIdAndDelStatus(int plantId, int i);
	
	//Sachin 27 Dec 2018
		@Query(value = ""
				+ "SELECT m_customer.* FROM m_customer,t_quot_header WHERE m_customer.cust_id=t_quot_header.cust_id AND t_quot_header.quot_head_id=:quotIdList  ", nativeQuery = true)
	Cust getCustByQuotIdList(@Param("quotIdList") int quotIdList);
}
