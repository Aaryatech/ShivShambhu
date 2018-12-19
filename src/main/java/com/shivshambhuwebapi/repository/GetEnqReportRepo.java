package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetEnqReport;

public interface GetEnqReportRepo extends JpaRepository<GetEnqReport, Integer> {

	@Query(value = "SELECT h.* ,c.cust_name ,c.cust_mob_no,p.plant_name FROM t_enq_header h,m_customer c,m_plant p  WHERE  h.ex_int1=1"
			+ " AND h.enq_status=0 AND c.cust_id=h.cust_id AND enq_status=0 AND h.enq_date BETWEEN :fromDate AND :toDate AND "
			+ "p.plant_id=h.plant_id AND h.plant_id IN(:plantIdList) ", nativeQuery = true)

	List<GetEnqReport> getEnqBetDateANdIdList(@Param("plantIdList") List<Integer> plantIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT h.* ,c.cust_name ,c.cust_mob_no,p.plant_name FROM t_enq_header h,m_customer c,m_plant p  WHERE  h.ex_int1=1 "
			+ "AND h.enq_status=0 AND c.cust_id=h.cust_id AND enq_status=0 AND h.enq_date BETWEEN :fromDate AND :toDate "
			+ "AND p.plant_id=h.plant_id  ", nativeQuery = true)

	List<GetEnqReport> getEnqListBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
