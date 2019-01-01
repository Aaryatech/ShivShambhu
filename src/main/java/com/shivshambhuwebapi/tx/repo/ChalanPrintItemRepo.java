package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.ChalanPrintItem;

public interface ChalanPrintItemRepo extends JpaRepository<ChalanPrintItem, Integer> {

	
	
	@Query(value = ""
			+ " SELECT t_chalan_header.chalan_no,t_chalan_header.chalan_date,t_chalan_header.vehicle_id,"
			+ " t_chalan_header.plant_id,t_chalan_header.veh_in_date, " + 
			" t_chalan_header.cust_id,t_chalan_header.proj_id,t_chalan_header.driver_id,"
			+ " t_chalan_header.veh_time_out,t_chalan_header.out_km,\n" + 
			" t_chalan_header.in_km,t_chalan_header.veh_time_in,t_chalan_header.site_person_name,"
			+ " t_chalan_header.site_person_mob,t_chalan_header.order_no,t_chalan_header.order_id,"
			+ " t_chalan_header.chalan_remark,\n" + 
			" t_chalan_detail.*,m_item_fg.item_name,m_item_fg.item_code,m_uom_store.uom,\n" + 
			" m_vehicle.vehicle_name,m_vehicle.veh_no,m_user.usr_name,m_customer.cust_name,"
			+ " m_customer.cust_mob_no,m_project.proj_name,m_project.address\n" + 
			" FROM t_chalan_header,t_chalan_detail,m_vehicle,m_user,m_customer,m_project,"
			+ " m_item_fg,m_uom_store " + 
			" WHERE t_chalan_header.chalan_id=t_chalan_detail.chalan_id "
			+ " AND t_chalan_detail.item_id=m_item_fg.item_id AND "
			+ " m_uom_store.uom_id=t_chalan_detail.item_uom AND "
			+ " t_chalan_header.vehicle_id=m_vehicle.vehicle_id AND "
			+ " t_chalan_header.driver_id=m_user.user_id AND t_chalan_header.cust_id=m_customer.cust_id "
			+ " AND t_chalan_header.proj_id=m_project.proj_id and t_chalan_header.chalan_id=:chalanId ", nativeQuery = true)
	List<ChalanPrintItem> getChalanPrintItem(@Param("chalanId") int chalanId);
	

}
