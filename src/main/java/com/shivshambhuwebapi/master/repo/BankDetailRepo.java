package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.BankDetail;

public interface BankDetailRepo extends JpaRepository<BankDetail, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE BankDetail SET delStatus=0  WHERE bank_det_id=:bankDetId")
	int deleteBankDetail(@Param("bankDetId") int bankDetId);

	BankDetail findByBankDetIdAndDelStatus(int bankDetId, int i);

	List<BankDetail> findByDelStatusOrderByBankDetIdDesc(int i);

}
