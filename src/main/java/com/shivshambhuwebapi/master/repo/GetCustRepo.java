package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetCust;

public interface GetCustRepo extends JpaRepository<GetCust, Integer> {

	@Query(value = "SELECT c.*,p.plant_name FROM m_customer c,m_plant p  WHERE c.del_status=1 AND p.plant_id=c.plant_id ORDER BY c.cust_id DESC", nativeQuery = true)
	List<GetCust> getAllCustList();

	@Query(value = "SELECT c.*,p.plant_name FROM m_customer c,m_plant p  WHERE c.del_status=1 AND p.plant_id=c.plant_id AND  c.cust_id=:custId", nativeQuery = true)
	GetCust getCustByCustId(@Param("custId") int custId);

}
