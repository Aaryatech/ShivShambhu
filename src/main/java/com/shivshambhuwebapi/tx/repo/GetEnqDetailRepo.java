package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetEnqDetail;

public interface GetEnqDetailRepo extends JpaRepository<GetEnqDetail, Integer> {
	
	
	// change table name for item

	@Query(value = " SELECT d.*,i.item_name,i.item_code,u.uom_name  FROM t_enq_detail d,m_item_fg i,m_uom u WHERE d.del_status=1 "
			+ " AND d.enq_head_id=:enqHeadId AND i.item_id=d.item_id AND d.enq_uom_id=u.uom_id", nativeQuery = true)

	List<GetEnqDetail> getEnqDetailByEnqHeadId(@Param("enqHeadId") int enqHeadId);

}
