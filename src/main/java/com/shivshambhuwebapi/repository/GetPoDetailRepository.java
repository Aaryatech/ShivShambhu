package com.shivshambhuwebapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.GetPoDetail;

public interface GetPoDetailRepository extends JpaRepository<GetPoDetail, Integer>{
	
	
	// change table name for item

	@Query(value = "select pd.*,i.item_name from t_cust_po_detail pd,m_item_fg i  where pd.po_id=:poId and i.item_id=pd.item_id", nativeQuery = true)
	List<GetPoDetail> getDetail(@Param("poId") int poId);

}
