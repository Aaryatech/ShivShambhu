package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.ChalanPrintItem;

public interface ChalanPrintItemRepo extends JpaRepository<ChalanPrintItem, Integer> {

	
	
	@Query(value = "SELECT \n" + 
			"         t_chalan_detail.*, t_chalan_header.chalan_no,\n" + 
			"        t_chalan_header.chalan_date,\n" + 
			"        t_chalan_header.vehicle_id,\n" + 
			"        t_chalan_header.plant_id,\n" + 
			"        t_chalan_header.veh_in_date,\n" + 
			"        t_chalan_header.cust_id,\n" + 
			"        t_chalan_header.proj_id,\n" + 
			"        t_chalan_header.driver_id,\n" + 
			"        t_chalan_header.veh_time_out,\n" + 
			"        t_chalan_header.out_km,\n" + 
			"        t_chalan_header.in_km,\n" + 
			"        t_chalan_header.veh_time_in,\n" + 
			"        t_chalan_header.site_person_name,\n" + 
			"        t_chalan_header.site_person_mob,\n" + 
			"        t_chalan_header.order_no,\n" + 
			"        t_chalan_header.order_id,\n" + 
			"        t_chalan_header.chalan_remark,\n" + 
			"        m_item_fg.item_name,\n" + 
			"        m_item_fg.item_code,\n" + 
			"        m_uom.uom_name as uom,\n" + 
			"        m_vehicle.vehicle_name,\n" + 
			"        m_vehicle.veh_no,\n" + 
			"        m_user.usr_name,\n" + 
			"        m_customer.cust_name,\n" + 
			"        m_customer.cust_mob_no,\n" + 
			"        m_project.proj_name,\n" + 
			"        m_project.address,\n" + 
			"        t_order_detail.order_qty as total_quan,\n" + 
			"        t_chalan_header.ex_date1 as batch_no     \n" + 
			"    FROM\n" + 
			"        t_chalan_header,\n" + 
			"        t_chalan_detail,\n" + 
			"        m_vehicle,\n" + 
			"        m_user,\n" + 
			"        m_customer,\n" + 
			"        m_project,\n" + 
			"        m_item_fg,\n" + 
			"        m_uom,\n" + 
			"        t_order_detail    \n" + 
			"    WHERE\n" + 
			"        t_chalan_header.chalan_id=t_chalan_detail.chalan_id           \n" + 
			"        AND t_chalan_detail.item_id=m_item_fg.item_id          \n" + 
			"        AND  m_uom.uom_id=t_chalan_detail.item_uom          \n" + 
			"        AND  t_chalan_header.vehicle_id=m_vehicle.vehicle_id          \n" + 
			"        AND  t_chalan_header.driver_id=m_user.user_id          \n" + 
			"        AND t_chalan_header.cust_id=m_customer.cust_id           \n" + 
			"        AND t_chalan_header.proj_id=m_project.proj_id          \n" + 
			"        and t_chalan_header.chalan_id=:chalanId\n" + 
			"        AND t_chalan_detail.order_detail_id=t_order_detail.order_det_id          ", nativeQuery = true)
	List<ChalanPrintItem> getChalanPrintItem(@Param("chalanId") int chalanId);
	

}
