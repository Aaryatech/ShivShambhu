package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetExistingItemDetail;

public interface GetItemExistingDetailRepo extends JpaRepository<GetExistingItemDetail, Integer> {

	@Query(value = "select d.*,u.uom_name,c.cat_desc FROM m_item_detail d,m_category c,"
			+ "m_uom u,m_item i WHERE d.item_id=:itemId and d.rm_uom_id=u.uom_id AND d.rm_id=i.item_id and "
			+ "c.cat_id=i.cat_id AND d.del_status=1", nativeQuery = true)

	List<GetExistingItemDetail> getItemDetailByItemId(@Param("itemId") int itemId);

}
