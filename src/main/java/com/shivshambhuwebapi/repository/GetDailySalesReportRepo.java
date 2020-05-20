package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.shivshambhuwebapi.model.bill.GetDailySalesReport;

public interface GetDailySalesReportRepo extends JpaRepository<GetDailySalesReport, Integer> {
	
	
	@Query(value="SELECT\n" + 
			"	UUID() as id,\n" + 
			"    cust.cust_name,\n" + 
			"    project.proj_name AS site_name,\n" + 
			"    item.item_desc,\n" + 
			"    SUM(dtl.qty) AS qty,\n" + 
			"    dtl.rate,\n" + 
			"    SUM(dtl.taxable_amt) AS taxable_amt,\n" + 
			"    SUM(dtl.cgst_amt) AS cgst_amt,\n" + 
			"    SUM(dtl.sgst_amt) AS sgst_amt,\n" + 
			"    SUM(dtl.total_amt) AS total_amt\n" + 
			"  \n" + 
			"    \n" + 
			"FROM\n" + 
			"     m_item item,\n" + 
			"     t_bill_header head,\n" + 
			"     t_bill_detail dtl,\n" + 
			"     m_customer cust,\n" + 
			"     m_project project,\n" + 
			"     m_plant plant\n" + 
			"WHERE\n" + 
			"    item.item_id=dtl.item_id AND\n" + 
			"    cust.cust_id=head.cust_id AND\n" + 
			"    project.proj_id=head.proj_id AND\n" + 
			"    dtl.bill_head_id=head.bill_head_id AND \n" + 
			"    head.bill_date BETWEEN :fromDate AND :toDate AND\n" + 
			"    plant.company_id=head.company_id AND head.del_status=1\n" + 
			"GROUP BY head.cust_id, dtl.item_id\n" + 
			"ORDER BY head.bill_head_id DESC",nativeQuery=true)
	List<GetDailySalesReport> getDailySalesBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value="SELECT\n" + 
			"	UUID() as id,\n" + 
			"    cust.cust_name,\n" + 
			"    project.proj_name AS site_name,\n" + 
			"    item.item_desc,\n" + 
			"    SUM(dtl.qty) AS qty,\n" + 
			"    dtl.rate,\n" + 
			"    SUM(dtl.taxable_amt) AS taxable_amt,\n" + 
			"    SUM(dtl.cgst_amt) AS cgst_amt,\n" + 
			"    SUM(dtl.sgst_amt) AS sgst_amt,\n" + 
			"    SUM(dtl.total_amt) AS total_amt\n" + 
			"  \n" + 
			"    \n" + 
			"FROM\n" + 
			"     m_item item,\n" + 
			"     t_bill_header head,\n" + 
			"     t_bill_detail dtl,\n" + 
			"     m_customer cust,\n" + 
			"     m_project project,\n" + 
			"     m_plant plant\n" + 
			"WHERE\n" + 
			"    item.item_id=dtl.item_id AND\n" + 
			"    cust.cust_id=head.cust_id AND\n" + 
			"    project.proj_id=head.proj_id AND\n" + 
			"    dtl.bill_head_id=head.bill_head_id AND \n" + 
			"    head.bill_date BETWEEN :fromDate AND :toDate AND\n" + 
			"    plant.company_id=head.company_id AND\n" + 
			"    plant.plant_id=:plantId AND head.del_status=1\n" + 
			"GROUP BY head.cust_id, dtl.item_id\n" + 
			"ORDER BY head.bill_head_id DESC",nativeQuery=true)
	List<GetDailySalesReport> getDailySalesBetDateByPlantId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
    @Param("plantId") int plantId );

}
