package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.CustType;

public interface CustTypeRepo extends JpaRepository<CustType, Integer> {
	@Transactional
	@Modifying
	@Query("UPDATE CustType SET delStatus=0  WHERE cust_type_id=:custTypeId")
	int deleteCustType(@Param("custTypeId") int custTypeId);

	CustType findByCustTypeIdAndDelStatus(int custTypeId, int i);

	List<CustType> findByDelStatusOrderByCustTypeIdDesc(int i);

	@Transactional
	@Modifying
	@Query("UPDATE CustType SET delStatus=0  WHERE custTypeId IN(:custTypeIds)")
	int deleteMultiCustType(@Param("custTypeIds") List<Integer> custTypeIds);

	CustType findByCustTypeNameAndDelStatus(String custTypeName, int i);

}
