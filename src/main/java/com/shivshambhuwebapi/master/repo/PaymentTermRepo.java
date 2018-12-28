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

	@Transactional
	@Modifying
	@Query("UPDATE PaymentTerm SET delStatus=0  WHERE payTermId IN(:payTermIds)")
	int deleteMultiPaymentTerm(@Param("payTermIds") List<Integer> payTermIds);

	PaymentTerm findByPayTermAndDelStatus(String payTerm, int i);
	
	//sachin 27-12-2018
	@Query(value = ""
			+ " SELECT m_payment_term.* FROM m_payment_term,t_quot_header "
			+ " WHERE m_payment_term.pay_term_id=t_quot_header.pay_term_id "
			+ " AND t_quot_header.quot_head_id IN (:quotIdList)   ", nativeQuery = true)

PaymentTerm getPayTermDetailForQuotPrint(@Param("quotIdList") int quotIdList);


}
