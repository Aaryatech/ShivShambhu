package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetItemTax;

public interface GetItemTaxRepo extends JpaRepository<GetItemTax, Integer> {
	
	// change table name for item

	@Query(value = "SELECT i.*,p.plant_name,t.tax_name,t.hsn_code,u.uom_name,t.sgst,t.igst,t.cgst,t.cess FROM m_item_fg i,m_plant p ,"
			+ "m_tax t,m_uom u  WHERE i.del_status=1 AND p.plant_id=i.plant_id AND p.plant_id=:plantId AND t.tax_id=i.tax_id AND"
			+ " u.uom_id=i.uom_id ", nativeQuery = true)
	List<GetItemTax> getItemListByPlantId(@Param("plantId") int plantId);

}
