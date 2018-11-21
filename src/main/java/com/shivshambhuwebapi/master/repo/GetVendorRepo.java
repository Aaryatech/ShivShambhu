package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shivshambhuwebapi.master.model.GetVendor;

public interface GetVendorRepo extends JpaRepository<GetVendor, Integer> {

	@Query(value = "SELECT v.* ,p.plant_name   FROM m_vendor v,m_plant p WHERE"
			+ " v.del_status=1  AND  p.plant_id=v.plant_id  ORDER BY v.vend_id DESC", nativeQuery = true)
	List<GetVendor> getVendorList();

}
