package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetQuotReport;

public interface GetQuotReportRepo extends JpaRepository<GetQuotReport, Integer> {

	@Query(value = "SELECT h.* ,c.cust_name ,c.cust_mob_no,p.plant_name ,e.enq_date,e.enq_no  FROM t_quot_header h,m_customer c ,"
			+ "m_plant p ,t_enq_header e WHERE h.del_status=1 AND h.status=1 AND c.cust_id=h.cust_id AND h.quot_date BETWEEN "
			+ ":fromDate AND :toDate AND h.plant_ids=p.plant_id AND e.enq_head_id=h.enq_head_id AND h.plant_ids IN(:plantIdList)", nativeQuery = true)

	List<GetQuotReport> getEnqPendingPoBetDateANdIdList(@Param("plantIdList") List<Integer> plantIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT h.* ,c.cust_name ,c.cust_mob_no,p.plant_name ,e.enq_date,e.enq_no  FROM t_quot_header h,m_customer c ,"
			+ "m_plant p ,t_enq_header e WHERE h.del_status=1 AND h.status=1 AND c.cust_id=h.cust_id AND h.quot_date BETWEEN "
			+ ":fromDate AND :toDate AND h.plant_ids=p.plant_id AND e.enq_head_id=h.enq_head_id ", nativeQuery = true)

	List<GetQuotReport> getEnqPendingPoListBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
