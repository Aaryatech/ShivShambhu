package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetQuotReport;

public interface GetQuotReportRepo extends JpaRepository<GetQuotReport, Integer> {

	@Query(value = "SELECT h.* ,c.cust_name ,c.cust_mob_no,p.plant_name  FROM t_quot_header h,t_quot_header q,m_customer c ,"
			+ "m_plant p WHERE h.del_status=1 AND q.status=1 AND c.cust_id=h.cust_id AND h.quot_date BETWEEN :fromDate AND "
			+ ":toDate AND h.plant_ids=p.plant_id  AND  h.plant_ids IN(:plantIdList)  AND h.plant_id=p.plant_id", nativeQuery = true)

	List<GetQuotReport> getEnqPendingPoBetDateANdIdList(@Param("plantIdList") List<Integer> plantIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT h.* ,c.cust_name ,c.cust_mob_no,p.plant_name  FROM t_quot_header h,t_quot_header q,m_customer c ,"
			+ "m_plant p WHERE h.del_status=1 AND q.status=1 AND c.cust_id=h.cust_id AND h.quot_date BETWEEN :fromDate AND "
			+ ":toDate AND h.plant_ids=p.plant_id  ", nativeQuery = true)

	List<GetQuotReport> getEnqPendingPoListBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
