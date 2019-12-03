package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetItem;

public interface GetItemRepo extends JpaRepository<GetItem, Integer> {

	// chgange table name for item

	/*@Query(value = "SELECT i.*,p.plant_name,t.tax_name,t.hsn_code,t.cgst,t.sgst,t.igst,u.uom_name FROM m_item_fg i,m_plant p ,m_tax t,m_uom u  WHERE "
			+ "i.del_status=1 AND p.plant_id=i.plant_id AND t.tax_id=i.tax_id AND u.uom_id=i.uom_id ORDER BY i.item_id DESC", nativeQuery = true)
	List<GetItem> getAllItemList();*/
	
	
	@Query(value = "SELECT\n" + 
			"    i.item_id,\n" + 
			"    i.item_name,\n" + 
			"    i.item_code,\n" + 
			"    i.item_image,\n" + 
			"    i.item_type,\n" + 
			"    i.plant_id,\n" + 
			"    i.item_rate1,\n" + 
			"    i.item_rate2,\n" + 
			"    i.item_rate3,\n" + 
			"    i.item_rate4,\n" + 
			"    i.tax_id,\n" + 
			"    i.uom_id,\n" + 
			"    i.actual_weight,\n" + 
			"    i.base_weight,\n" + 
			"    i.short_name,\n" + 
			"    i.dispatch_limit,\n" + 
			"    i.is_critical,\n" + 
			"    i.item_is_used,\n" + 
			"    i.del_status,\n" + 
			"    i.min_stock,\n" + 
			"    i.max_stock,\n" + 
			"    i.rol_stock,\n" + 
			"    i.plant_min_stock,\n" + 
			"    i.plant_max_stock,\n" + 
			"    i.plant_rol_stock,\n" + 
			"    i.vendor_ids,\n" + 
			"    i.ex_int1,\n" + 
			"    i.ex_int2,\n" + 
			"    i.ex_int3,\n" + 
			"    i.ex_var1,\n" + 
			"    i.ex_var2,\n" + 
			"    i.ex_date1,\n" + 
			"    i.ex_date2,\n" + 
			"    i.ex_bool1,\n" + 
			"    i.ex_bool2,\n" + 
			"    i.ex_bool3,\n" + 
			"    i.sort_no,\n" + 
			"    i.length,\n" + 
			"    i.width,\n" + 
			"    i.height,\n" + 
			"    i.item_location,\n" + 
			"    i.royalty_rate,\n" + 
			"    i.freight_rate,\n" + 
			"    p.plant_name,\n" + 
			"    t.tax_name,\n" + 
			"    t.hsn_code,\n" + 
			"    t.cgst,\n" + 
			"    t.sgst,\n" + 
			"    t.igst,\n" + 
			"    u.uom_name,\n" + 
			"    ty.item_type_name AS ex_var3\n" + 
			"FROM\n" + 
			"    m_item_fg i,\n" + 
			"    m_plant p,\n" + 
			"    m_tax t,\n" + 
			"    m_uom u,\n" + 
			"    m_item_type ty\n" + 
			"WHERE\n" + 
			"    i.del_status = 1 AND p.plant_id = i.plant_id AND t.tax_id = i.tax_id AND u.uom_id = i.uom_id AND i.item_type = ty.item_type_id\n" + 
			"ORDER BY\n" + 
			"    i.item_id\n" + 
			"DESC\n" + 
			"    ", nativeQuery = true)
	List<GetItem> getAllItemList();

	/*@Query(value = "SELECT i.*,p.plant_name,t.tax_name,t.hsn_code,t.cgst,t.sgst,t.igst,u.uom_name FROM m_item_fg i,m_plant p ,m_tax t,m_uom u  WHERE "
			+ "i.del_status=1 AND p.plant_id=i.plant_id AND t.tax_id=i.tax_id AND u.uom_id=i.uom_id AND i.item_id =:itemId", nativeQuery = true)
	GetItem getItemByItemId(@Param("itemId") int itemId);
*/
	
	@Query(value = "SELECT\n" + 
			"   i.item_id,\n" + 
			"    i.item_name,\n" + 
			"    i.item_code,\n" + 
			"    i.item_image,\n" + 
			"    i.item_type,\n" + 
			"    i.plant_id,\n" + 
			"    i.item_rate1,\n" + 
			"    i.item_rate2,\n" + 
			"    i.item_rate3,\n" + 
			"    i.item_rate4,\n" + 
			"    i.tax_id,\n" + 
			"    i.uom_id,\n" + 
			"    i.actual_weight,\n" + 
			"    i.base_weight,\n" + 
			"    i.short_name,\n" + 
			"    i.dispatch_limit,\n" + 
			"    i.is_critical,\n" + 
			"    i.item_is_used,\n" + 
			"    i.del_status,\n" + 
			"    i.min_stock,\n" + 
			"    i.max_stock,\n" + 
			"    i.rol_stock,\n" + 
			"    i.plant_min_stock,\n" + 
			"    i.plant_max_stock,\n" + 
			"    i.plant_rol_stock,\n" + 
			"    i.vendor_ids,\n" + 
			"    i.ex_int1,\n" + 
			"    i.ex_int2,\n" + 
			"    i.ex_int3,\n" + 
			"    i.ex_var1,\n" + 
			"    i.ex_var2,\n" + 
			"    i.ex_date1,\n" + 
			"    i.ex_date2,\n" + 
			"    i.ex_bool1,\n" + 
			"    i.ex_bool2,\n" + 
			"    i.ex_bool3,\n" + 
			"    i.sort_no,\n" + 
			"    i.length,\n" + 
			"    i.width,\n" + 
			"    i.height,\n" + 
			"    i.item_location,\n" + 
			"    i.royalty_rate,\n" + 
			"    i.freight_rate,\n" + 
			"    p.plant_name,\n" + 
			"    t.tax_name,\n" + 
			"    t.hsn_code,\n" + 
			"    t.cgst,\n" + 
			"    t.sgst,\n" + 
			"    t.igst,\n" + 
			"    u.uom_name,\n" + 
			"    ty.item_type_name AS ex_var3\n" + 
			"FROM\n" + 
			"    m_item_fg i,\n" + 
			"    m_plant p,\n" + 
			"    m_tax t,\n" + 
			"    m_uom u,\n" + 
			"    m_item_type ty\n" + 
			"WHERE\n" + 
			"    i.del_status = 1 AND p.plant_id = i.plant_id AND t.tax_id = i.tax_id AND u.uom_id = i.uom_id  AND i.item_type=ty.item_type_id AND i.item_id =:itemId", nativeQuery = true)
	GetItem getItemByItemId(@Param("itemId") int itemId);
	
	
	
	/*@Query(value = "SELECT i.*,p.plant_name,t.tax_name,t.cgst,t.sgst,t.igst,t.hsn_code,u.uom_name FROM m_item_fg i,m_plant p ,m_tax t,m_uom u  WHERE "
			+ "i.del_status=1 AND p.plant_id=i.plant_id AND p.plant_id=:plantId AND t.tax_id=i.tax_id AND u.uom_id=i.uom_id ", nativeQuery = true)
	List<GetItem> getItemByPlantId(@Param("plantId") int plantId);*/
	
	
	
	@Query(value = "SELECT\n" + 
			"    i.item_id,\n" + 
			"    i.item_name,\n" + 
			"    i.item_code,\n" + 
			"    i.item_image,\n" + 
			"    i.item_type,\n" + 
			"    i.plant_id,\n" + 
			"    i.item_rate1,\n" + 
			"    i.item_rate2,\n" + 
			"    i.item_rate3,\n" + 
			"    i.item_rate4,\n" + 
			"    i.tax_id,\n" + 
			"    i.uom_id,\n" + 
			"    i.actual_weight,\n" + 
			"    i.base_weight,\n" + 
			"    i.short_name,\n" + 
			"    i.dispatch_limit,\n" + 
			"    i.is_critical,\n" + 
			"    i.item_is_used,\n" + 
			"    i.del_status,\n" + 
			"    i.min_stock,\n" + 
			"    i.max_stock,\n" + 
			"    i.rol_stock,\n" + 
			"    i.plant_min_stock,\n" + 
			"    i.plant_max_stock,\n" + 
			"    i.plant_rol_stock,\n" + 
			"    i.vendor_ids,\n" + 
			"    i.ex_int1,\n" + 
			"    i.ex_int2,\n" + 
			"    i.ex_int3,\n" + 
			"    i.ex_var1,\n" + 
			"    i.ex_var2,\n" + 
			"    i.ex_date1,\n" + 
			"    i.ex_date2,\n" + 
			"    i.ex_bool1,\n" + 
			"    i.ex_bool2,\n" + 
			"    i.ex_bool3,\n" + 
			"    i.sort_no,\n" + 
			"    i.length,\n" + 
			"    i.width,\n" + 
			"    i.height,\n" + 
			"    i.item_location,\n" + 
			"    i.royalty_rate,\n" + 
			"    i.freight_rate,\n" + 
			"    p.plant_name,\n" + 
			"    t.tax_name,\n" + 
			"    t.cgst,\n" + 
			"    t.sgst,\n" + 
			"    t.igst,\n" + 
			"    t.hsn_code,\n" + 
			"    u.uom_name,\n" + 
			"      ty.item_type_name AS ex_var3\n" + 
			"FROM\n" + 
			"    m_item_fg i,\n" + 
			"    m_plant p,\n" + 
			"    m_tax t,\n" + 
			"    m_uom u,\n" + 
			"     m_item_type ty\n" + 
			"WHERE\n" + 
			"    i.del_status = 1 AND p.plant_id = i.plant_id AND p.plant_id = :plantId AND t.tax_id = i.tax_id AND u.uom_id = i.uom_id AND i.item_type = ty.item_type_id ", nativeQuery = true)
	List<GetItem> getItemByPlantId(@Param("plantId") int plantId);
}
