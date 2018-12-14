package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetBillReport;

public interface GetBillReportRepo extends JpaRepository<GetBillReport, Integer> {

	@Query(value = "SELECT  h.*,c.cust_name,c.cust_mob_no,p.proj_name,l.plant_name  FROM t_bill_header h,m_project p ,m_customer c,"
			+ "m_plant l WHERE h.del_status=1 AND p.proj_id=h.proj_id AND c.cust_id=h.cust_id AND l.plant_id=h.ex_int1 AND h.bill_date"
			+ " BETWEEN :fromDate AND :toDate AND h.company_id IN(:companyIdList) AND h.ex_int1 IN(:plantIdList)", nativeQuery = true)

	List<GetBillReport> getBillHeadersBetDateANdIdList(@Param("plantIdList") List<Integer> plantIdList,
			@Param("companyIdList") List<Integer> companyIdList, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT  h.*,c.cust_name,c.cust_mob_no,p.proj_name,l.plant_name  FROM t_bill_header h,m_project p ,m_customer c,"
			+ "m_plant l WHERE h.del_status=1 AND p.proj_id=h.proj_id AND c.cust_id=h.cust_id AND l.plant_id=h.ex_int1 AND h.bill_date"
			+ " BETWEEN :fromDate AND :toDate  AND h.ex_int1 IN(:plantIdList)", nativeQuery = true)

	List<GetBillReport> getBillHeadersBetDateANdPlantIdList(@Param("plantIdList") List<Integer> plantIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT  h.*,c.cust_name,c.cust_mob_no,p.proj_name,l.plant_name  FROM t_bill_header h,m_project p ,m_customer c,"
			+ "m_plant l WHERE h.del_status=1 AND p.proj_id=h.proj_id AND c.cust_id=h.cust_id AND l.plant_id=h.ex_int1 AND h.bill_date"
			+ " BETWEEN :fromDate AND :toDate AND h.company_id IN(:companyIdList)", nativeQuery = true)

	List<GetBillReport> getBillHeadersBetDateANdCompIdList(@Param("companyIdList") List<Integer> companyIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT  h.*,c.cust_name,c.cust_mob_no,p.proj_name,l.plant_name  FROM t_bill_header h,m_project p ,m_customer c,"
			+ "m_plant l WHERE h.del_status=1 AND p.proj_id=h.proj_id AND c.cust_id=h.cust_id AND l.plant_id=h.ex_int1 AND h.bill_date "
			+ "BETWEEN :fromDate AND :toDate ", nativeQuery = true)

	List<GetBillReport> getBillHeadersBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT  h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,h.proj_id,h.cost_segment,h.payment_term_id,h.company_id,"
			+ "h.challan_id,h.delivery_term,h.po_id,SUM(h.taxable_amt)as taxable_amt,SUM(h.tax_amt) as tax_amt ,SUM(h.total_amt) "
			+ "as total_amt,h.acc_id,h.order_id,h.del_status,h.ex_int1,h.ex_int2,h.ex_int3,h.ex_var1,h.ex_var2,h.ex_var3,h.ex_float1,"
			+ "h.ex_float2,c.cust_name,c.cust_mob_no,p.proj_name,l.plant_name  FROM t_bill_header h,m_project p ,m_customer c,m_plant "
			+ "l WHERE h.del_status=1 AND p.proj_id=h.proj_id AND c.cust_id=h.cust_id AND l.plant_id=h.ex_int1 AND h.bill_date BETWEEN "
			+ ":fromDate AND :toDate GROUP BY h.cust_id\n", nativeQuery = true)

	List<GetBillReport> getBillCustBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT  h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,h.proj_id,h.cost_segment,h.payment_term_id,h.company_id,"
			+ "h.challan_id,h.delivery_term,h.po_id,SUM(h.taxable_amt)as taxable_amt,SUM(h.tax_amt) as tax_amt ,SUM(h.total_amt) "
			+ "as total_amt,h.acc_id,h.order_id,h.del_status,h.ex_int1,h.ex_int2,h.ex_int3,h.ex_var1,h.ex_var2,h.ex_var3,h.ex_float1,"
			+ "h.ex_float2,c.cust_name,c.cust_mob_no,p.proj_name,l.plant_name  FROM t_bill_header h,m_project p ,m_customer c,m_plant "
			+ "l WHERE h.del_status=1 AND p.proj_id=h.proj_id AND c.cust_id=h.cust_id AND l.plant_id=h.ex_int1 AND h.bill_date BETWEEN "
			+ ":fromDate AND :toDate AND h.ex_int1 IN(:plantIdList) GROUP BY h.cust_id", nativeQuery = true)

	List<GetBillReport> getBillCustBetDateAndPlantIdList(@Param("plantIdList") List<Integer> plantIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT  h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,h.proj_id,h.cost_segment,h.payment_term_id,h.company_id,"
			+ "h.challan_id,h.delivery_term,h.po_id,SUM(h.taxable_amt)as taxable_amt,SUM(h.tax_amt) as tax_amt ,SUM(h.total_amt) as"
			+ " total_amt,h.acc_id,h.order_id,h.del_status,h.ex_int1,h.ex_int2,h.ex_int3,h.ex_var1,h.ex_var2,h.ex_var3,h.ex_float1,"
			+ "h.ex_float2,c.cust_name,c.cust_mob_no,p.proj_name,l.plant_name  FROM t_bill_header h,m_project p ,m_customer c,m_plant "
			+ "l WHERE h.del_status=1 AND p.proj_id=h.proj_id AND c.cust_id=h.cust_id AND l.plant_id=h.ex_int1 AND h.bill_date "
			+ "BETWEEN :fromDate AND :toDate AND h.cust_id IN(:custIdList) GROUP BY h.cust_id", nativeQuery = true)

	List<GetBillReport> getBillCustBetDateANdCustIdList(@Param("custIdList") List<Integer> custIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT  h.bill_head_id,h.bill_no,h.bill_date,h.cust_id,h.proj_id,h.cost_segment,h.payment_term_id,"
			+ "h.company_id,h.challan_id,h.delivery_term,h.po_id,SUM(h.taxable_amt)as taxable_amt,SUM(h.tax_amt) as tax_amt ,"
			+ "SUM(h.total_amt) as total_amt,h.acc_id,h.order_id,h.del_status,h.ex_int1,h.ex_int2,h.ex_int3,h.ex_var1,h.ex_var2,"
			+ "h.ex_var3,h.ex_float1,h.ex_float2,c.cust_name,c.cust_mob_no,p.proj_name,l.plant_name  FROM t_bill_header h,m_project "
			+ "p ,m_customer c,m_plant l WHERE h.del_status=1 AND p.proj_id=h.proj_id AND c.cust_id=h.cust_id AND l.plant_id=h.ex_int1 "
			+ "AND h.bill_date BETWEEN :fromDate AND :toDate AND h.cust_id IN(:custIdList) AND h.ex_int1 IN(:plantIdList) GROUP BY h.cust_id", nativeQuery = true)

	List<GetBillReport> getBillHeadersBetDateANdCustIdList(@Param("plantIdList") List<Integer> plantIdList,
			@Param("custIdList") List<Integer> custIdList, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT  h.*,c.cust_name,c.cust_mob_no,p.proj_name,l.plant_name  FROM t_bill_header h,m_project p ,m_customer c"
			+ ",m_plant l WHERE h.del_status=1 AND p.proj_id=h.proj_id AND c.cust_id=h.cust_id AND l.plant_id=h.ex_int1  AND h.cust_id=:custId", nativeQuery = true)

	List<GetBillReport> getBillHeaderByCustId(@Param("custId") int custId);

}
