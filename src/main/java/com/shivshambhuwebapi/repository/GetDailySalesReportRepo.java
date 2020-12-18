package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.shivshambhuwebapi.model.bill.GetDailySalesReport;

public interface GetDailySalesReportRepo extends JpaRepository<GetDailySalesReport, Integer> {
	
	
	@Query(value="SELECT \n" + 
			"	t1.*,\n" + 
			"    t2.grand_total,\n" + 
			"    t2.tcs_amt\n" + 
			"    FROM\n" + 
			"(SELECT\n" + 
			"        UUID() as id,\n" + 
			"        cust.cust_name,\n" + 
			"        project.proj_name AS site_name,\n" + 
			"        item.item_desc,\n" + 
			"        SUM(dtl.qty) AS qty,\n" + 
			"        dtl.rate,\n" + 
			"        SUM(dtl.taxable_amt) AS taxable_amt,\n" + 
			"        SUM(dtl.cgst_amt) AS cgst_amt,\n" + 
			"        SUM(dtl.sgst_amt) AS sgst_amt,\n" + 
			"        SUM(dtl.total_amt) AS total_amt,\n" + 
			"        head.bill_head_id\n" + 
			"    FROM\n" + 
			"        m_item item,\n" + 
			"        t_bill_header head,\n" + 
			"        t_bill_detail dtl,\n" + 
			"        m_customer cust,\n" + 
			"        m_project project,\n" + 
			"        m_plant plant \n" + 
			"    WHERE\n" + 
			"        item.item_id=dtl.item_id \n" + 
			"        AND  cust.cust_id=head.cust_id \n" + 
			"        AND  project.proj_id=head.proj_id \n" + 
			"        AND dtl.bill_head_id=head.bill_head_id \n" + 
			"        AND head.bill_date BETWEEN :fromDate AND :toDate\n" + 
			"        AND plant.company_id=head.company_id \n" + 
			"        AND head.del_status=1 \n" + 
			"    GROUP BY\n" + 
			"        head.cust_id,\n" + 
			"        dtl.item_id \n" + 
			"    ORDER BY\n" + 
			"        head.bill_head_id DESC)t1\n" + 
			"        LEFT JOIN\n" + 
			"        (SELECT\n" + 
			" 	h.bill_head_id,\n" + 
			" 	SUM(h.total_amt) AS grand_total,\n" + 
			"    SUM(h.ex_float1) AS tcs_amt\n" + 
			" 	FROM\n" + 
			"        m_item i,\n" + 
			"        t_bill_header h,\n" + 
			"        t_bill_detail d,\n" + 
			"        m_customer c,\n" + 
			"        m_project p,\n" + 
			"        m_plant pl \n" + 
			"    WHERE\n" + 
			"        i.item_id=d.item_id \n" + 
			"        AND  c.cust_id=h.cust_id \n" + 
			"        AND  p.proj_id=h.proj_id \n" + 
			"        AND  d.bill_head_id=h.bill_head_id \n" + 
			"        AND  h.bill_date BETWEEN :fromDate AND :toDate\n" + 
			"        AND  pl.company_id=h.company_id \n" + 
			"        AND h.del_status=1 \n" + 
			"     GROUP BY\n" + 
			"        h.cust_id,\n" + 
			"        d.item_id \n" + 
			"    ORDER BY\n" + 
			"        h.bill_head_id DESC)t2\n" + 
			"        ON t1.bill_head_id=t2.bill_head_id",nativeQuery=true)
	List<GetDailySalesReport> getDailySalesBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
//	SELECT\n" + 
//	"	UUID() as id,\n" + 
//	"    cust.cust_name,\n" + 
//	"    project.proj_name AS site_name,\n" + 
//	"    item.item_desc,\n" + 
//	"    SUM(dtl.qty) AS qty,\n" + 
//	"    dtl.rate,\n" + 
//	"    SUM(dtl.taxable_amt) AS taxable_amt,\n" + 
//	"    SUM(dtl.cgst_amt) AS cgst_amt,\n" + 
//	"    SUM(dtl.sgst_amt) AS sgst_amt,\n" + 
//	"    SUM(dtl.total_amt) AS total_amt\n" + 
//	"  \n" + 
//	"    \n" + 
//	"FROM\n" + 
//	"     m_item item,\n" + 
//	"     t_bill_header head,\n" + 
//	"     t_bill_detail dtl,\n" + 
//	"     m_customer cust,\n" + 
//	"     m_project project,\n" + 
//	"     m_plant plant\n" + 
//	"WHERE\n" + 
//	"    item.item_id=dtl.item_id AND\n" + 
//	"    cust.cust_id=head.cust_id AND\n" + 
//	"    project.proj_id=head.proj_id AND\n" + 
//	"    dtl.bill_head_id=head.bill_head_id AND \n" + 
//	"    head.bill_date BETWEEN :fromDate AND :toDate AND\n" + 
//	"    plant.company_id=head.company_id AND head.del_status=1\n" + 
//	"GROUP BY head.cust_id, dtl.item_id\n" + 
//	"ORDER BY head.bill_head_id DESC
	/*---------------------------------------------------------------------------------------------------------------------------*/

	@Query(value="SELECT \n" + 
			"	t1.*,\n" + 
			"    t2.grand_total,\n" + 
			"    t2.tcs_amt\n" + 
			"    FROM\n" + 
			"(SELECT\n" + 
			"        UUID() as id,\n" + 
			"        cust.cust_name,\n" + 
			"        project.proj_name AS site_name,\n" + 
			"        item.item_desc,\n" + 
			"        SUM(dtl.qty) AS qty,\n" + 
			"        dtl.rate,\n" + 
			"        SUM(dtl.taxable_amt) AS taxable_amt,\n" + 
			"        SUM(dtl.cgst_amt) AS cgst_amt,\n" + 
			"        SUM(dtl.sgst_amt) AS sgst_amt,\n" + 
			"        SUM(dtl.total_amt) AS total_amt,\n" + 
			" 		head.bill_head_id\n" + 
			"    FROM\n" + 
			"        m_item item,\n" + 
			"        t_bill_header head,\n" + 
			"        t_bill_detail dtl,\n" + 
			"        m_customer cust,\n" + 
			"        m_project project,\n" + 
			"        m_plant plant \n" + 
			"    WHERE\n" + 
			"        item.item_id=dtl.item_id \n" + 
			"        AND     cust.cust_id=head.cust_id \n" + 
			"        AND     project.proj_id=head.proj_id \n" + 
			"        AND     dtl.bill_head_id=head.bill_head_id \n" + 
			"        AND      head.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"        AND     plant.company_id=head.company_id \n" + 
			"        AND     plant.plant_id=:plantId \n" + 
			"        AND head.del_status=1 \n" + 
			"    GROUP BY\n" + 
			"        head.cust_id,\n" + 
			"        dtl.item_id \n" + 
			"    ORDER BY\n" + 
			"        head.bill_head_id DESC)t1\n" + 
			" LEFT JOIN\n" + 
			"        (SELECT\n" + 
			" 	h.bill_head_id,\n" + 
			" 	SUM(h.total_amt) AS grand_total,\n" + 
			"    SUM(h.ex_float1) AS tcs_amt\n" + 
			" 	FROM\n" + 
			"        m_item i,\n" + 
			"        t_bill_header h,\n" + 
			"        t_bill_detail d,\n" + 
			"        m_customer c,\n" + 
			"        m_project p,\n" + 
			"        m_plant pl \n" + 
			"    WHERE\n" + 
			"        i.item_id=d.item_id \n" + 
			"        AND     c.cust_id=h.cust_id \n" + 
			"        AND     p.proj_id=h.proj_id \n" + 
			"        AND     d.bill_head_id=h.bill_head_id \n" + 
			"        AND      h.bill_date BETWEEN :fromDate AND :toDate \n" + 
			"         AND	pl.plant_id=:plantId\n" + 
			"        AND     pl.company_id=h.company_id \n" + 
			"        AND h.del_status=1 \n" + 
			"     GROUP BY\n" + 
			"        h.cust_id,\n" + 
			"        d.item_id \n" + 
			"    ORDER BY\n" + 
			"        h.bill_head_id DESC)t2\n" + 
			"        ON t1.bill_head_id=t2.bill_head_id",nativeQuery=true)
	List<GetDailySalesReport> getDailySalesBetDateByPlantId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
    @Param("plantId") int plantId );
	
//	SELECT\n" + 
//	"	UUID() as id,\n" + 
//	"    cust.cust_name,\n" + 
//	"    project.proj_name AS site_name,\n" + 
//	"    item.item_desc,\n" + 
//	"    SUM(dtl.qty) AS qty,\n" + 
//	"    dtl.rate,\n" + 
//	"    SUM(dtl.taxable_amt) AS taxable_amt,\n" + 
//	"    SUM(dtl.cgst_amt) AS cgst_amt,\n" + 
//	"    SUM(dtl.sgst_amt) AS sgst_amt,\n" + 
//	"    SUM(dtl.total_amt) AS total_amt\n" + 
//	"  \n" + 
//	"    \n" + 
//	"FROM\n" + 
//	"     m_item item,\n" + 
//	"     t_bill_header head,\n" + 
//	"     t_bill_detail dtl,\n" + 
//	"     m_customer cust,\n" + 
//	"     m_project project,\n" + 
//	"     m_plant plant\n" + 
//	"WHERE\n" + 
//	"    item.item_id=dtl.item_id AND\n" + 
//	"    cust.cust_id=head.cust_id AND\n" + 
//	"    project.proj_id=head.proj_id AND\n" + 
//	"    dtl.bill_head_id=head.bill_head_id AND \n" + 
//	"    head.bill_date BETWEEN :fromDate AND :toDate AND\n" + 
//	"    plant.company_id=head.company_id AND\n" + 
//	"    plant.plant_id=:plantId AND head.del_status=1\n" + 
//	"GROUP BY head.cust_id, dtl.item_id\n" + 
//	"ORDER BY head.bill_head_id DESC

}
