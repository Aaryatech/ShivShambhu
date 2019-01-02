package com.shivshambhuwebapi.repo.rec;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.rec.GetPayRecoveryHeadCustWise;

public interface GetPayRecoveryHeadCustwiseRepo extends JpaRepository<GetPayRecoveryHeadCustWise, Integer> {

	@Query(value = "SELECT SUM(t_pay_recovery_header.bill_total) as bill_total, "
			+ " SUM(t_pay_recovery_header.paid_amt) as paid_amt,t_pay_recovery_header.bill_date,"
			+ " SUM(t_pay_recovery_header.pending_amt) as pending_amt,"
			+ " m_customer.cust_id,m_customer.cust_name,m_customer.cust_mob_no"
			+ " FROM m_customer,t_pay_recovery_header "
			+ " WHERE t_pay_recovery_header.cust_id=:custId AND t_pay_recovery_header.del_status=1 AND t_pay_recovery_header.status=1 AND t_pay_recovery_header.bill_date BETWEEN :fromDate AND "
			+ " :toDate AND m_customer.cust_id=t_pay_recovery_header.cust_id GROUP by t_pay_recovery_header.cust_id", nativeQuery = true)
	List<GetPayRecoveryHeadCustWise> getPayRecDoneBetDateCustId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("custId") int custId);

	@Query(value = "SELECT SUM(t_pay_recovery_header.bill_total) as bill_total, SUM(t_pay_recovery_header.paid_amt) "
			+ "as paid_amt,SUM(t_pay_recovery_header.pending_amt) as pending_amt,t_pay_recovery_header.bill_date,m_customer.cust_id,m_customer.cust_name,"
			+ "m_customer.cust_mob_no FROM m_customer,t_pay_recovery_header WHERE  t_pay_recovery_header.del_status=1 AND"
			+ " t_pay_recovery_header.status=1 AND t_pay_recovery_header.bill_date BETWEEN :fromDate AND :toDate "
			+ " AND m_customer.cust_id=t_pay_recovery_header.cust_id GROUP by t_pay_recovery_header.cust_id", nativeQuery = true)
	List<GetPayRecoveryHeadCustWise> getPayRecDoneBetDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = " SELECT SUM(t_pay_recovery_header.bill_total) as bill_total, "
			+ " SUM(t_pay_recovery_header.paid_amt) as paid_amt,"
			+ " SUM(t_pay_recovery_header.pending_amt) as pending_amt,t_pay_recovery_header.bill_date,"
			+ " m_customer.cust_id,m_customer.cust_name,m_customer.cust_mob_no "
			+ " FROM m_customer,t_pay_recovery_header,t_bill_header,m_plant "
			+ " WHERE t_pay_recovery_header.bill_date BETWEEN :fromDate AND :toDate AND m_customer.cust_id=t_pay_recovery_header.cust_id AND t_bill_header.ex_int1=:plantId "
			+ " AND t_bill_header.ex_int1=m_plant.plant_id AND t_bill_header.bill_head_id=t_pay_recovery_header.bill_head_id "
			+ " GROUP by t_pay_recovery_header.cust_id", nativeQuery = true)
	List<GetPayRecoveryHeadCustWise> getPayRecDoneBetDatePlantId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("plantId") int plantId);
	
	
	@Query(value = " SELECT SUM(t_pay_recovery_header.bill_total) as bill_total, "
			+ " SUM(t_pay_recovery_header.paid_amt) as paid_amt,"
			+ " SUM(t_pay_recovery_header.pending_amt) as pending_amt,t_pay_recovery_header.bill_date,"
			+ " m_customer.cust_id,m_customer.cust_name,m_customer.cust_mob_no "
			+ " FROM m_customer,t_pay_recovery_header,t_bill_header,m_plant "
			+ " WHERE t_pay_recovery_header.cust_id=:custId AND t_pay_recovery_header.bill_date BETWEEN :fromDate AND :toDate AND m_customer.cust_id=t_pay_recovery_header.cust_id AND t_bill_header.ex_int1=:plantId "
			+ " AND t_bill_header.ex_int1=m_plant.plant_id AND t_bill_header.bill_head_id=t_pay_recovery_header.bill_head_id "
			+ " GROUP by t_pay_recovery_header.cust_id", nativeQuery = true)
	List<GetPayRecoveryHeadCustWise> getPayRecDoneBetDatePlantIdCustId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("plantId") int plantId, @Param("custId") int custId);

}
