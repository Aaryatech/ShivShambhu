package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.PaymentTerm;

public interface PaymentTermRepo extends JpaRepository<PaymentTerm, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE PaymentTerm SET delStatus=0  WHERE pay_term_id=:payTermId")
	int deletePaymentTerm(@Param("payTermId") int payTermId);

	PaymentTerm findByPayTermIdAndDelStatus(int payTermId, int i);

	List<PaymentTerm> findByDelStatusOrderByPayTermIdDesc(int i);

}
