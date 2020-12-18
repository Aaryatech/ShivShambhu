package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetDateWiseDetailBill;


public interface GetDatewiseDetailReportRepo  extends JpaRepository<GetDateWiseDetailBill , Integer>{
	
	
	@Query(value = "SELECT\r\n" + 
			"        t1.*,\r\n" + 
			"       t2.grand_total, t2.tcs_amt  \r\n" + 
			"    FROM\r\n" + 
			"        (select\r\n" + 
			"        d.bill_detail_id,\r\n" + 
			"        h.bill_date,\r\n" + 
			"        h.bill_no,\r\n" + 
			"        h.cust_id,\r\n" + 
			"        c.cust_name,\r\n" + 
			"        c.cust_gst_no,\r\n" + 
			"        d.sgst_per,\r\n" + 
			"        d.cgst_per,\r\n" + 
			"        d.igst_per,\r\n" + 
			"        SUM(d.sgst_amt) as sgst_amt,\r\n" + 
			"        SUM(d.cgst_amt) as cgst_amt,\r\n" + 
			"        SUM(d.igst_amt) as igst_amt,\r\n" + 
			"        SUM(d.tax_amt)  as tax_amt,\r\n" + 
			"        SUM(d.disc_per) as disc_per,\r\n" + 
			"        SUM(d.disc_amt) as disc_amt,\r\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(d.total_amt) as total_amt,\r\n" + 
			"         h.bill_head_id\r\n" + 
			"    from\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        m_customer c       \r\n" + 
			"    where\r\n" + 
			"        h.bill_head_id=d.bill_head_id           \r\n" + 
			"        and c.cust_id=h.cust_id           \r\n" + 
			"        AND h.bill_date=:billDate  \r\n" + 
			"        and h.del_status=1 \r\n" + 
			"        and d.del_status=1          \r\n" + 
			"    GROUP BY\r\n" + 
			"        h.bill_head_id)t1         \r\n" + 
			"    LEFT JOIN\r\n" + 
			"        (\r\n" + 
			"            SELECT\r\n" + 
			"                head.bill_head_id,\r\n" + 
			"                SUM(head.total_amt) AS grand_total,\r\n" + 
			"                SUM(head.ex_float1) AS tcs_amt  \r\n" + 
			"            FROM\r\n" + 
			"                t_bill_header head   \r\n" + 
			"            WHERE\r\n" + 
			"                head.del_status=1   \r\n" + 
			"                AND head.bill_date=:billDate\r\n" + 
			"            GROUP by\r\n" + 
			"                head.bill_head_id \r\n" + 
			"        )t2 \r\n" + 
			"            ON t1.bill_head_id=t2.bill_head_id", nativeQuery = true)
//	select\r\n" + 
//	"		d.bill_detail_id,\r\n" + 
//	"        h.bill_date,\r\n" + 
//	"        h.bill_no,\r\n" + 
//	"        h.cust_id,\r\n" + 
//	"        c.cust_name,\r\n" + 
//	"        c.cust_gst_no,\r\n" + 
//	"        d.sgst_per,\r\n" + 
//	"        d.cgst_per,\r\n" + 
//	"        d.igst_per,\r\n" + 
//	"        SUM(d.sgst_amt) as sgst_amt,\r\n" + 
//	"        SUM(d.cgst_amt) as cgst_amt, \r\n" + 
//	"        SUM(d.igst_amt) as igst_amt,\r\n" + 
//	"        SUM(d.tax_amt)  as tax_amt,\r\n" + 
//	"        SUM(d.disc_per) as disc_per,\r\n" + 
//	"        SUM(d.disc_amt) as disc_amt,\r\n" + 
//	"        SUM(d.taxable_amt) as taxable_amt,\r\n" + 
//	"        SUM(d.total_amt) as total_amt  \r\n" + 
//	"    from\r\n" + 
//	"        t_bill_header h,\r\n" + 
//	"        t_bill_detail d,\r\n" + 
//	"        m_customer c \r\n" + 
//	"    where\r\n" + 
//	"        h.bill_head_id=d.bill_head_id \r\n" + 
//	"        and c.cust_id=h.cust_id \r\n" + 
//	"        AND h.bill_date=:billDate and h.del_status=1 and d.del_status=1\r\n" + 
//	"        GROUP BY h.bill_head_id
	List<GetDateWiseDetailBill> getBillByBillHeadId(@Param("billDate") String billDate);
	/*******************************************************************************************************************************/

	@Query(value = "SELECT\r\n" + 
			"        t1.*,\r\n" + 
			"        t2.grand_total, t2.tcs_amt  \r\n" + 
			"    FROM\r\n" + 
			"        ( select\r\n" + 
			"        d.bill_detail_id,\r\n" + 
			"        h.bill_date,\r\n" + 
			"        h.bill_no,\r\n" + 
			"        h.cust_id,\r\n" + 
			"        c.cust_name,\r\n" + 
			"        c.cust_gst_no,\r\n" + 
			"        d.sgst_per,\r\n" + 
			"        d.cgst_per,\r\n" + 
			"        d.igst_per,\r\n" + 
			"        SUM(d.sgst_amt) as sgst_amt,\r\n" + 
			"        SUM(d.cgst_amt) as cgst_amt,\r\n" + 
			"        SUM(d.igst_amt) as igst_amt,\r\n" + 
			"        SUM(d.tax_amt)  as tax_amt,\r\n" + 
			"        SUM(d.disc_per) as disc_per,\r\n" + 
			"        SUM(d.disc_amt) as disc_amt,\r\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(d.total_amt) as total_amt,\r\n" + 
			"        h.bill_head_id\r\n" + 
			"    from\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        m_customer c       \r\n" + 
			"    where\r\n" + 
			"        h.bill_head_id=d.bill_head_id           \r\n" + 
			"        and c.cust_id=h.cust_id           \r\n" + 
			"        AND h.bill_date=:billDate \r\n" + 
			"        and h.del_status=1 \r\n" + 
			"        and d.del_status=1 \r\n" + 
			"        AND h.ex_int1 in (:plantIdList)   \r\n" + 
			"        AND h.cust_id in(:custIdList) \r\n" + 
			"    GROUP BY\r\n" + 
			"        h.bill_head_id)t1         \r\n" + 
			"    LEFT JOIN\r\n" + 
			"        (\r\n" + 
			"            SELECT\r\n" + 
			"                head.bill_head_id,\r\n" + 
			"                SUM(head.total_amt) AS grand_total,\r\n" + 
			"                SUM(head.ex_float1) AS tcs_amt  \r\n" + 
			"            FROM\r\n" + 
			"                t_bill_header head   \r\n" + 
			"            WHERE\r\n" + 
			"                head.del_status=1   \r\n" + 
			"                AND head.bill_date=:billDate\r\n" + 
			"            	AND head.ex_int1 in (:plantIdList)   \r\n" + 
			"       		 AND head.cust_id in(:custIdList) \r\n" + 
			"            GROUP by\r\n" + 
			"                head.bill_head_id \r\n" + 
			"        )t2 \r\n" + 
			"            ON t1.bill_head_id=t2.bill_head_id", nativeQuery = true)
	List<GetDateWiseDetailBill> getBillByBillHeadId(@Param("billDate")String billDate,@Param("plantIdList") List<Integer> plantIdList,
			@Param("custIdList") List<Integer> custIdList);
//	select\r\n" + 
//	"		d.bill_detail_id,\r\n" + 
//	"        h.bill_date,\r\n" + 
//	"        h.bill_no,\r\n" + 
//	"        h.cust_id,\r\n" + 
//	"        c.cust_name,\r\n" + 
//	"        c.cust_gst_no,\r\n" + 
//	"        d.sgst_per,\r\n" + 
//	"        d.cgst_per,\r\n" + 
//	"        d.igst_per,\r\n" + 
//	"        SUM(d.sgst_amt) as sgst_amt,\r\n" + 
//	"        SUM(d.cgst_amt) as cgst_amt, \r\n" + 
//	"        SUM(d.igst_amt) as igst_amt,\r\n" + 
//	"        SUM(d.tax_amt)  as tax_amt,\r\n" + 
//	"        SUM(d.disc_per) as disc_per,\r\n" + 
//	"        SUM(d.disc_amt) as disc_amt,\r\n" + 
//	"        SUM(d.taxable_amt) as taxable_amt,\r\n" + 
//	"        SUM(d.total_amt) as total_amt  \r\n" + 
//	"    from\r\n" + 
//	"        t_bill_header h,\r\n" + 
//	"        t_bill_detail d,\r\n" + 
//	"        m_customer c \r\n" + 
//	"    where\r\n" + 
//	"        h.bill_head_id=d.bill_head_id \r\n" + 
//	"        and c.cust_id=h.cust_id \r\n" + 
//	"        AND h.bill_date=:billDate and h.del_status=1 and d.del_status=1 AND  h.ex_int1 in (:plantIdList) "
//	+ "  AND h.cust_id in(:custIdList) GROUP BY h.bill_head_id
	/*************************************************************************************************************/
	@Query(value = "SELECT\r\n" + 
			"        t1.*,\r\n" + 
			"        t2.grand_total,\r\n" + 
			"        t2.tcs_amt\r\n" + 
			"    FROM\r\n" + 
			"        ( select\r\n" + 
			"        d.bill_detail_id,\r\n" + 
			"        h.bill_date,\r\n" + 
			"        h.bill_no,\r\n" + 
			"        h.cust_id,\r\n" + 
			"        c.cust_name,\r\n" + 
			"        c.cust_gst_no,\r\n" + 
			"        d.sgst_per,\r\n" + 
			"        d.cgst_per,\r\n" + 
			"        d.igst_per,\r\n" + 
			"        SUM(d.sgst_amt) as sgst_amt,\r\n" + 
			"        SUM(d.cgst_amt) as cgst_amt,\r\n" + 
			"        SUM(d.igst_amt) as igst_amt,\r\n" + 
			"        SUM(d.tax_amt)  as tax_amt,\r\n" + 
			"        SUM(d.disc_per) as disc_per,\r\n" + 
			"        SUM(d.disc_amt) as disc_amt,\r\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(d.total_amt) as total_amt,\r\n" + 
			"        h.bill_head_id\r\n" + 
			"    from\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        m_customer c       \r\n" + 
			"    where\r\n" + 
			"        h.bill_head_id=d.bill_head_id           \r\n" + 
			"        and c.cust_id=h.cust_id           \r\n" + 
			"        AND h.bill_date=:billDate \r\n" + 
			"        and h.del_status=1 \r\n" + 
			"        and d.del_status=1 \r\n" + 
			"        AND  h.ex_int1 in (:plantIdList)  \r\n" + 
			"    GROUP BY\r\n" + 
			"        h.bill_head_id)t1         \r\n" + 
			"    LEFT JOIN\r\n" + 
			"        (\r\n" + 
			"            SELECT\r\n" + 
			"                head.bill_head_id,\r\n" + 
			"                SUM(head.total_amt) AS grand_total,\r\n" + 
			"                SUM(head.ex_float1) AS tcs_amt  \r\n" + 
			"            FROM\r\n" + 
			"                t_bill_header head   \r\n" + 
			"            WHERE\r\n" + 
			"                head.del_status=1   \r\n" + 
			"                AND head.bill_date=:billDate \r\n" + 
			"            	AND head.ex_int1 in (:plantIdList)\r\n" + 
			"            GROUP by\r\n" + 
			"                head.bill_head_id \r\n" + 
			"        )t2 \r\n" + 
			"            ON t1.bill_head_id=t2.bill_head_id", nativeQuery = true)
	List<GetDateWiseDetailBill> getBillByBillHeadIdpalnt(@Param("billDate")String billDate,@Param("plantIdList") List<Integer> plantIdList);
//	select\r\n" + 
//	"		d.bill_detail_id,\r\n" + 
//	"        h.bill_date,\r\n" + 
//	"        h.bill_no,\r\n" + 
//	"        h.cust_id,\r\n" + 
//	"        c.cust_name,\r\n" + 
//	"        c.cust_gst_no,\r\n" + 
//	"        d.sgst_per,\r\n" + 
//	"        d.cgst_per,\r\n" + 
//	"        d.igst_per,\r\n" + 
//	"        SUM(d.sgst_amt) as sgst_amt,\r\n" + 
//	"        SUM(d.cgst_amt) as cgst_amt, \r\n" + 
//	"        SUM(d.igst_amt) as igst_amt,\r\n" + 
//	"        SUM(d.tax_amt)  as tax_amt,\r\n" + 
//	"        SUM(d.disc_per) as disc_per,\r\n" + 
//	"        SUM(d.disc_amt) as disc_amt,\r\n" + 
//	"        SUM(d.taxable_amt) as taxable_amt,\r\n" + 
//	"        SUM(d.total_amt) as total_amt  \r\n" + 
//	"    from\r\n" + 
//	"        t_bill_header h,\r\n" + 
//	"        t_bill_detail d,\r\n" + 
//	"        m_customer c \r\n" + 
//	"    where\r\n" + 
//	"        h.bill_head_id=d.bill_head_id \r\n" + 
//	"        and c.cust_id=h.cust_id \r\n" + 
//	"        AND h.bill_date=:billDate and h.del_status=1 and d.del_status=1 AND  h.ex_int1 in (:plantIdList) "
//	+ " GROUP BY h.bill_head_id
/***************************************************************************************************************/
	@Query(value = "SELECT\r\n" + 
			"        t1.*,\r\n" + 
			"        t2.grand_total, t2.tcs_amt  \r\n" + 
			"    FROM\r\n" + 
			"        ( select\r\n" + 
			"        d.bill_detail_id,\r\n" + 
			"        h.bill_date,\r\n" + 
			"        h.bill_no,\r\n" + 
			"        h.cust_id,\r\n" + 
			"        c.cust_name,\r\n" + 
			"        c.cust_gst_no,\r\n" + 
			"        d.sgst_per,\r\n" + 
			"        d.cgst_per,\r\n" + 
			"        d.igst_per,\r\n" + 
			"        SUM(d.sgst_amt) as sgst_amt,\r\n" + 
			"        SUM(d.cgst_amt) as cgst_amt,\r\n" + 
			"        SUM(d.igst_amt) as igst_amt,\r\n" + 
			"        SUM(d.tax_amt)  as tax_amt,\r\n" + 
			"        SUM(d.disc_per) as disc_per,\r\n" + 
			"        SUM(d.disc_amt) as disc_amt,\r\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(d.total_amt) as total_amt,\r\n" + 
			"        h.bill_head_id\r\n" + 
			"    from\r\n" + 
			"        t_bill_header h,\r\n" + 
			"        t_bill_detail d,\r\n" + 
			"        m_customer c       \r\n" + 
			"    where\r\n" + 
			"        h.bill_head_id=d.bill_head_id           \r\n" + 
			"        and c.cust_id=h.cust_id           \r\n" + 
			"        AND h.bill_date=:billDate \r\n" + 
			"        and h.del_status=1 \r\n" + 
			"        and d.del_status=1 \r\n" + 
			"        AND h.cust_id IN (:custIdList)\r\n" + 
			"    GROUP BY\r\n" + 
			"        h.bill_head_id)t1         \r\n" + 
			"    LEFT JOIN\r\n" + 
			"        (\r\n" + 
			"            SELECT\r\n" + 
			"                head.bill_head_id,\r\n" + 
			"                SUM(head.total_amt) AS grand_total,\r\n" + 
			"                SUM(head.ex_float1) AS tcs_amt  \r\n" + 
			"            FROM\r\n" + 
			"                t_bill_header head   \r\n" + 
			"            WHERE\r\n" + 
			"                head.del_status=1   \r\n" + 
			"                AND head.bill_date=:billDate       \r\n" + 
			"                AND head.cust_id IN (:custIdList)  \r\n" + 
			"            GROUP by\r\n" + 
			"                head.bill_head_id \r\n" + 
			"        )t2 \r\n" + 
			"            ON t1.bill_head_id=t2.bill_head_id", nativeQuery = true)
	List<GetDateWiseDetailBill> getBillByBillHeadId(@Param("billDate")String billDate,@Param("custIdList") List<Integer> custIdList);
//	select\r\n" + 
//	"		d.bill_detail_id,\r\n" + 
//	"        h.bill_date,\r\n" + 
//	"        h.bill_no,\r\n" + 
//	"        h.cust_id,\r\n" + 
//	"        c.cust_name,\r\n" + 
//	"        c.cust_gst_no,\r\n" + 
//	"        d.sgst_per,\r\n" + 
//	"        d.cgst_per,\r\n" + 
//	"        d.igst_per,\r\n" + 
//	"        SUM(d.sgst_amt) as sgst_amt,\r\n" + 
//	"        SUM(d.cgst_amt) as cgst_amt, \r\n" + 
//	"        SUM(d.igst_amt) as igst_amt,\r\n" + 
//	"        SUM(d.tax_amt)  as tax_amt,\r\n" + 
//	"        SUM(d.disc_per) as disc_per,\r\n" + 
//	"        SUM(d.disc_amt) as disc_amt,\r\n" + 
//	"        SUM(d.taxable_amt) as taxable_amt,\r\n" + 
//	"        SUM(d.total_amt) as total_amt  \r\n" + 
//	"    from\r\n" + 
//	"        t_bill_header h,\r\n" + 
//	"        t_bill_detail d,\r\n" + 
//	"        m_customer c \r\n" + 
//	"    where\r\n" + 
//	"        h.bill_head_id=d.bill_head_id \r\n" + 
//	"        and c.cust_id=h.cust_id \r\n" + 
//	"        AND h.bill_date=:billDate and h.del_status=1 and d.del_status=1 AND"
//	+ " h.cust_id in(:custIdList) GROUP BY h.bill_head_id
	
}
