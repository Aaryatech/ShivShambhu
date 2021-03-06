package com.shivshambhuwebapi.repository.prodrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.prodrm.RmReportDetail;

public interface RmReportDetailRepo extends JpaRepository<RmReportDetail, Integer> {

	@Query(value = " SELECT t_req_bom_detail.bom_req_detail_id,t_req_bom_detail.bom_req_id,"
			+ " t_req_bom_detail.rm_id,t_req_bom_detail.uom,t_req_bom_detail.auto_rm_req_qty,"
			+ " t_req_bom_detail.rm_req_qty,t_req_bom_detail.rm_issue_qty,t_req_bom_detail.rejected_qty,"
			+ " t_req_bom_detail.return_qty,t_req_bom_detail.mrn_batch,t_req_bom_detail.status,"
			+ " m_item.item_code,m_item.item_desc,m_uom.uom_name,t_req_bom.bom_req_date"
			+ " FROM t_req_bom_detail,m_item,m_uom,t_req_bom"
			+ " WHERE t_req_bom_detail.rm_id=:rmId AND t_req_bom_detail.bom_req_id=t_req_bom.bom_req_id AND"
			+ " t_req_bom.bom_req_date BETWEEN :fromDate and :toDate "
			+ " AND t_req_bom_detail.rm_id=m_item.item_id AND m_item.item_uom2=m_uom.uom_id "
			+ " AND t_req_bom.plant_id=:plantId "
			+ " AND t_req_bom_detail.del_status=1 AND t_req_bom.del_status=1 AND m_item.is_used=1 "
			+ " AND m_uom.del_status=1 ", nativeQuery = true)

	List<RmReportDetail> getRmReportDetail(@Param("plantId") int plantId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("rmId") int rmId);

}
