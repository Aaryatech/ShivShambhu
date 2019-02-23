package com.shivshambhuwebapi.repo.rec;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.rec.GetPayRecoveryHeadData;

public interface GetPayRecoveryHeadDataRepo extends JpaRepository<GetPayRecoveryHeadData, Integer> {

	//From Date - To Date
	@Query(value = "SELECT c.cust_name,s.setting_value as cust_class,p.*, DATEDIFF(p.credit_date2,p.bill_date) as days"
			+ " FROM m_customer c,t_pay_recovery_header p, t_setting_shiv s, t_bill_header b WHERE p.cust_id=c.cust_id "
			+ "AND c.cust_cat=s.setting_id AND b.bill_head_id=p.bill_head_id "
			+ "AND  p.bill_date BETWEEN :fromDate AND :toDate AND p.status=0", nativeQuery = true)
	List<GetPayRecoveryHeadData> getPayRecBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	//Date , Plant
	@Query(value = "SELECT c.cust_name,s.setting_value as cust_class,p.*, DATEDIFF(p.credit_date2,p.bill_date) as days"
			+ " FROM m_customer c,t_pay_recovery_header p, t_setting_shiv s, t_bill_header b WHERE p.cust_id=c.cust_id "
			+ "AND c.cust_cat=s.setting_id AND b.bill_head_id=p.bill_head_id "
			+ "AND b.ex_int1=:plantId AND  p.bill_date BETWEEN :fromDate AND :toDate AND p.status=0", nativeQuery = true)
	List<GetPayRecoveryHeadData> getPayRecBetDateAndPlant(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("plantId") int plantId);

	//Date , Customer
	@Query(value = "SELECT c.cust_name,s.setting_value as cust_class,p.*, DATEDIFF(p.credit_date2,p.bill_date) as days"
			+ " FROM m_customer c,t_pay_recovery_header p, t_setting_shiv s, t_bill_header b WHERE p.cust_id=c.cust_id "
			+ "AND c.cust_cat=s.setting_id AND b.bill_head_id=p.bill_head_id "
			+ "AND  p.bill_date BETWEEN :fromDate AND :toDate AND p.cust_id=:custId AND p.status=0", nativeQuery = true)
	List<GetPayRecoveryHeadData> getPayRecBetDateAndCust(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("custId") int custId);

	//Date , Customer Category
	@Query(value = "SELECT c.cust_name,s.setting_value as cust_class,p.*, DATEDIFF(p.credit_date2,p.bill_date) as days"
			+ " FROM m_customer c,t_pay_recovery_header p, t_setting_shiv s, t_bill_header b WHERE p.cust_id=c.cust_id "
			+ "AND c.cust_cat=s.setting_id AND b.bill_head_id=p.bill_head_id "
			+ "AND  p.bill_date BETWEEN :fromDate AND :toDate AND s.setting_id=:custCatId AND p.status=0", nativeQuery = true)
	List<GetPayRecoveryHeadData> getPayRecBetDateAndCustCat(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("custCatId") int custCatId);

	//Date , Customer, Plant
	@Query(value = "SELECT c.cust_name,s.setting_value as cust_class,p.*, DATEDIFF(p.credit_date2,p.bill_date) as days"
			+ " FROM m_customer c,t_pay_recovery_header p, t_setting_shiv s, t_bill_header b WHERE p.cust_id=c.cust_id "
			+ "AND c.cust_cat=s.setting_id AND b.bill_head_id=p.bill_head_id AND b.ex_int1=:plantId "
			+ "AND  p.bill_date BETWEEN :fromDate AND :toDate AND p.cust_id=:custId AND p.status=0", nativeQuery = true)
	List<GetPayRecoveryHeadData> getPayRecBetDateCustPlant(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("plantId") int plantId,@Param("custId") int custId);

	//Date , Customer, Customer Category
	@Query(value = "SELECT c.cust_name,s.setting_value as cust_class,p.*, DATEDIFF(p.credit_date2,p.bill_date) as days"
			+ " FROM m_customer c,t_pay_recovery_header p, t_setting_shiv s, t_bill_header b WHERE p.cust_id=c.cust_id "
			+ "AND c.cust_cat=s.setting_id AND b.bill_head_id=p.bill_head_id AND  p.bill_date BETWEEN :fromDate AND :toDate "
			+ "AND p.cust_id=:custId AND s.setting_id=:custCatId AND p.status=0", nativeQuery = true)
	List<GetPayRecoveryHeadData> getPayRecBetDateCustAndCustCat(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("custId") int custId,@Param("custCatId") int custCatId);

	//Date , Plant, Customer Category
		@Query(value = "SELECT c.cust_name,s.setting_value as cust_class,p.*, DATEDIFF(p.credit_date2,p.bill_date) as days"
				+ " FROM m_customer c,t_pay_recovery_header p, t_setting_shiv s, t_bill_header b WHERE p.cust_id=c.cust_id "
				+ "AND c.cust_cat=s.setting_id AND b.bill_head_id=p.bill_head_id AND  p.bill_date BETWEEN :fromDate AND :toDate "
				+ "AND s.setting_id=:custCatId AND b.ex_int1=:plantId AND p.status=0", nativeQuery = true)
		List<GetPayRecoveryHeadData> getPayRecBetDatePlantAndCustCat(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("plantId") int plantId,@Param("custCatId") int custCatId);

	//Date , Customer, Plant, Customer Category
	@Query(value = "SELECT c.cust_name,s.setting_value as cust_class,p.*, DATEDIFF(p.credit_date2,p.bill_date) as days"
			+ " FROM m_customer c,t_pay_recovery_header p, t_setting_shiv s, t_bill_header b WHERE p.cust_id=c.cust_id "
			+ "AND c.cust_cat=s.setting_id AND b.bill_head_id=p.bill_head_id AND b.ex_int1=:plantId AND  p.bill_date BETWEEN :fromDate AND :toDate "
			+ "AND p.cust_id=:custId AND s.setting_id=:custCatId AND p.status=0", nativeQuery = true)
	List<GetPayRecoveryHeadData> getPayRecBetDateCustPlantCustCat(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("plantId") int plantId,@Param("custId") int custId,@Param("custCatId") int custCatId);

	
	
	
	
}
