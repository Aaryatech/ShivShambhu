package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetItemWithEnq;

public interface GetItemWithEnqRepo extends JpaRepository<GetItemWithEnq, Integer> {

	@Query(value = " SELECT i.*,p.plant_name,t.tax_name,t.hsn_code,u.uom_name,t.sgst,t.cgst,t.igst,t.cess,t.total_tax_per,"

			+ " COALESCE((SELECT t_enq_detail.item_qty FROM t_enq_detail,t_enq_header "
			+ " WHERE t_enq_detail.enq_head_id=t_enq_header.enq_head_id AND t_enq_header.plant_id=p.plant_id"
			+ " AND t_enq_header.enq_head_id=:enqHeadId AND t_enq_detail.item_id=i.item_id),0) AS enq_qty," +

			" COALESCE((SELECT t_quot_detail.other_cost_after_tax from t_quot_detail,t_quot_header "
			+ " WHERE t_quot_detail.quot_head_id=t_quot_header.quot_head_id AND t_quot_header.enq_head_id=:enqHeadId "
			+ " AND t_quot_detail.item_id=i.item_id AND t_quot_detail.del_status=1),0) AS other_cost_after_tax," +

			" COALESCE((SELECT t_quot_detail.trans_cost from t_quot_detail,t_quot_header "
			+ " WHERE t_quot_detail.quot_head_id=t_quot_header.quot_head_id AND t_quot_header.enq_head_id=:enqHeadId "
			+ " AND t_quot_detail.item_id=i.item_id AND t_quot_detail.del_status=1),0) AS trans_cost," +

			" COALESCE((SELECT t_quot_detail.other_cost from t_quot_detail,t_quot_header "
			+ " WHERE t_quot_detail.quot_head_id=t_quot_header.quot_head_id AND t_quot_header.enq_head_id=:enqHeadId "
			+ " AND t_quot_detail.item_id=i.item_id AND t_quot_detail.del_status=1),0) AS other_cost," +

			//

			" COALESCE((SELECT t_quot_detail.tax_value from t_quot_detail,t_quot_header "
			+ " WHERE t_quot_detail.quot_head_id=t_quot_header.quot_head_id AND t_quot_header.enq_head_id=:enqHeadId "
			+ " AND t_quot_detail.item_id=i.item_id AND t_quot_detail.del_status=1),0) AS tax_value," +

			" COALESCE((SELECT t_quot_detail.taxable_value from t_quot_detail,t_quot_header "
			+ " WHERE t_quot_detail.quot_head_id=t_quot_header.quot_head_id AND t_quot_header.enq_head_id=:enqHeadId "
			+ " AND t_quot_detail.item_id=i.item_id AND t_quot_detail.del_status=1),0) AS taxable_value," +

			" COALESCE((SELECT t_quot_detail.total from t_quot_detail,t_quot_header "
			+ " WHERE t_quot_detail.quot_head_id=t_quot_header.quot_head_id AND t_quot_header.enq_head_id=:enqHeadId "
			+ " AND t_quot_detail.item_id=i.item_id AND t_quot_detail.del_status=1),0) AS final_total," +

			//

			" COALESCE((SELECT t_quot_detail.quot_qty from t_quot_detail,t_quot_header "
			+ " WHERE t_quot_detail.quot_head_id=t_quot_header.quot_head_id AND t_quot_header.enq_head_id=:enqHeadId "
			+ " AND t_quot_detail.item_id=i.item_id AND t_quot_detail.del_status=1),0) AS quot_qty," +

			" COALESCE((SELECT t_enq_detail.enq_uom_id FROM t_enq_detail,t_enq_header "
			+ " WHERE t_enq_detail.enq_head_id=t_enq_header.enq_head_id AND t_enq_header.plant_id=p.plant_id "
			+ "AND t_enq_header.enq_head_id=:enqHeadId AND t_enq_detail.item_id=i.item_id),0) AS enq_uom_id," +

			" COALESCE((SELECT m_uom.uom_name FROM m_uom, t_enq_detail,t_enq_header "
			+ " WHERE t_enq_detail.enq_head_id=t_enq_header.enq_head_id AND t_enq_header.plant_id=p.plant_id "
			+ " AND t_enq_header.enq_head_id=:enqHeadId AND t_enq_detail.item_id=i.item_id AND t_enq_detail.enq_uom_id=m_uom.uom_id),'NA') AS enq_uom_name"

			+ " FROM m_item_fg i,m_plant p ,m_tax t,m_uom u "
			+ " WHERE i.del_status=1 AND p.plant_id=i.plant_id AND p.plant_id=:plantId AND t.tax_id=i.tax_id AND u.uom_id=i.uom_id"
			+ "  ", nativeQuery = true)

	List<GetItemWithEnq> getGetItemWithEnq(@Param("plantId") int plantId, @Param("enqHeadId") int enqHeadId);

}
