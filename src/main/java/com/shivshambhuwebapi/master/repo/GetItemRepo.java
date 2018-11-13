package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetItem;

public interface GetItemRepo extends JpaRepository<GetItem, Integer> {

	@Query(value = "SELECT i.*,p.plant_name,t.tax_name,t.hsn_code,u.uom_name FROM m_item i,m_plant p ,m_tax t,m_uom u  WHERE "
			+ "i.del_status=1 AND p.plant_id=i.plant_id AND t.tax_id=i.tax_id AND u.uom_id=i.uom_id ORDER BY i.item_id DESC", nativeQuery = true)
	List<GetItem> getAllItemList();

	@Query(value = "SELECT i.*,p.plant_name,t.tax_name,t.hsn_code,u.uom_name FROM m_item i,m_plant p ,m_tax t,m_uom u  WHERE "
			+ "i.del_status=1 AND p.plant_id=i.plant_id AND t.tax_id=i.tax_id AND u.uom_id=i.uom_id AND i.item_id =:itemId", nativeQuery = true)
	GetItem getItemByItemId(@Param("itemId") int itemId);
}
