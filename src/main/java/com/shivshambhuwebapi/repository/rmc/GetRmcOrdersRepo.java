package com.shivshambhuwebapi.repository.rmc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.rmc.GetRmcOrders;

public interface GetRmcOrdersRepo extends JpaRepository<GetRmcOrders, Integer> {

	
	@Query(value = " SELECT t_order_detail.*,m_company.company_id,m_company.comp_name,\n" + 
			"t_order_header.plant_id,t_order_header.cust_id,t_order_header.po_id,t_order_header.delivery_date,t_order_header.prod_date,t_order_header.proj_id,\n" + 
			"t_order_header.order_no,t_order_header.order_date,t_order_header.ex_var1 as dispatch_time,\n" + 
			"m_customer.cust_name,m_customer.contact_per_name,m_customer.contact_per_mob,m_customer.cust_mob_no,\n" + 
			"m_item_fg.item_name,m_item_fg.item_code,\n" + 
			"m_plant.plant_name,t_cust_po_header.po_no,\n" + 
			"m_project.proj_name,m_project.contact_per_mob as proj_per_mob,m_project.contact_per_name as proj_per_name,m_uom.uom_name,m_user.usr_name\n" + 
			"\n ,m_uom.uom_name,m_uom.uom_id " + 
			" FROM m_company, t_order_detail,t_order_header,m_customer,m_item_fg,m_plant,m_project,t_cust_po_header,m_uom,m_user\n" + 
			"WHERE m_user.user_id=t_order_header.ex_int1 AND t_order_header.order_date BETWEEN :fromDate AND :toDate AND \n" + 
			"t_order_header.order_id=t_order_detail.order_id AND t_order_header.plant_id=m_plant.plant_id AND t_order_header.cust_id=m_customer.cust_id AND \n" + 
			"t_order_header.po_id=t_cust_po_header.po_id AND t_order_header.proj_id=m_project.proj_id AND t_order_header.status IN(0,1) AND \n" + 
			"t_order_header.plant_id=:plantId AND t_order_detail.item_id=m_item_fg.item_id AND \n" + 
			"m_item_fg.uom_id=m_uom.uom_id AND m_company.company_id=m_plant.company_id", nativeQuery = true)
	
	 List<GetRmcOrders> getGetRmcOrders(@Param("fromDate") String fromDate,@Param("toDate") String toDate,
			@Param("plantId") int plantId);

	                                                                                                                                                                                                                                                                                                                                                                                                                                                                              

}
