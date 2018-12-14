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

}
