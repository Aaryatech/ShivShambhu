package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.repo.GetQuotDetailPrint;

public interface GetQuotDetailPrintRepo extends JpaRepository<GetQuotDetailPrint, Integer> {
	
	//Sachin 27 Dec 2018
			@Query(value = ""
					+ " SELECT t_quot_detail.quot_detail_id,t_quot_detail.quot_qty, t_quot_detail.total,"
					+ "t_quot_detail.rate, (t_quot_detail.sgst_per+t_quot_detail.cgst_per) as tax_per, "
					+ "t_quot_detail.taxable_value,t_quot_detail.tax_value,"
					+ " t_quot_header.tax_value as is_tax_inc,t_quot_header.quot_date, m_uom.uom_name,m_item_fg.item_name,"
					+ "m_item_fg.item_code, t_quot_detail.quot_uom_id,t_quot_detail.quot_head_id, "
					+ "t_quot_detail.item_id,t_quot_header.quot_no FROM t_quot_detail,m_uom,m_item_fg,"
					+ "t_quot_header WHERE t_quot_detail.item_id=m_item_fg.item_id AND "
					+ "t_quot_detail.quot_uom_id=m_uom.uom_id AND t_quot_detail.del_status=1 "
					+ "AND t_quot_detail.quot_head_id=t_quot_header.quot_head_id AND "
					+ "t_quot_header.quot_head_id =:quotIdList  ", nativeQuery = true)
	
	List<GetQuotDetailPrint> getGetQuotDetailPrint(@Param("quotIdList") int quotIdList);

}
