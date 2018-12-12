package com.shivshambhuwebapi.repository.prodrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.prodrm.RmReportHeader;

public interface RmReportHeaderRepo extends JpaRepository<RmReportHeader, Integer> {

	@Query(value = " SELECT t_req_bom_detail.rm_id,SUM(t_req_bom_detail.rm_req_qty) as rm_req_qty,"
			+ "SUM(t_req_bom_detail.auto_rm_req_qty)AS auto_rm_req_qty,SUM(t_req_bom_detail.rm_issue_qty) "
			+ "as rm_issue_qty,SUM(t_req_bom_detail.rejected_qty) as rejected_qty,"
			+ "SUM(t_req_bom_detail.return_qty) AS return_qty,"
			+ "m_item.item_code,m_item.item_desc,m_uom.uom_name " + 
			" FROM t_req_bom_detail,t_req_bom,m_item,m_uom "
			+ " WHERE t_req_bom.bom_req_id=t_req_bom_detail.bom_req_id AND "
			+ " t_req_bom.bom_req_date BETWEEN :fromDate AND :toDate AND t_req_bom_detail.rm_id=m_item.item_id "
			+ "AND m_item.item_uom2=m_uom.uom_id AND "
			+ " m_item.is_used=1 AND m_uom.del_status=1 AND t_req_bom_detail.del_status=1 "
			+ "AND t_req_bom.del_status=1 "
			+ " and t_req_bom.plant_id=:plantId GROUP BY t_req_bom_detail.rm_id ", nativeQuery = true)

	List<RmReportHeader> getRmReportHeader(@Param("plantId") int plantId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

}
