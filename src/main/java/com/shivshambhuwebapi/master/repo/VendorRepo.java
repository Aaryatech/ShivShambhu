package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Vendor SET del_status=0  WHERE vend_id=:vendId")
	int deleteVendor(@Param("vendId") int vendId);

	Vendor findByVendIdAndDelStatus(int vendId, int i);

	List<Vendor> findByDelStatusOrderByVendIdDesc(int i);

}
