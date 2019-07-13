package com.shivshambhuwebapi.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetChalanHeader2;

public interface GetChalanHeaderRepo2 extends JpaRepository<GetChalanHeader2, Integer> {
	

	@Query(value = "   SELECT\n" + 
			"        t_chalan_header.*,\n" + 
			"        m_vehicle.veh_no,\n" + 
			"        m_vehicle.vehicle_name,\n" + 
			"        m_plant.plant_name,\n" + 
			"        m_company.comp_name,\n" + 
			"        m_company.company_id,\n" + 
			"        m_customer.cust_name,\n" + 
			"        m_customer.cust_mob_no,\n" + 
			"        m_project.proj_name,\n" + 
			"        m_project.address as proj_address,\n" + 
			"        t_cust_po_header.po_no,\n" + 
			"        \n" + 
			"        COALESCE((SELECT\n" + 
			"            m_user.usr_name \n" + 
			"        from\n" + 
			"            m_user \n" + 
			"        WHERE\n" + 
			"            m_user.user_id=t_chalan_header.driver_id),\n" + 
			"        'NA')AS driver_name,\n" + 
			"        COALESCE((SELECT\n" + 
			"            m_user.usr_name \n" + 
			"        from\n" + 
			"            m_user \n" + 
			"        WHERE\n" + 
			"            m_user.user_id=t_chalan_header.ex_var1),\n" + 
			"        'NA')AS user_name  \n" + 
			"    FROM\n" + 
			"        m_vehicle,\n" + 
			"        m_plant,\n" + 
			"        m_company,\n" + 
			"        m_customer,\n" + 
			"        m_project,\n" + 
			"        t_chalan_header,\n" + 
			"        t_cust_po_header,t_order_header\n" + 
			"    WHERE\n" + 
			"        m_vehicle.vehicle_id=t_chalan_header.vehicle_id \n" + 
			"        AND t_chalan_header.plant_id=m_plant.plant_id  \n" + 
			"        AND m_company.company_id=m_plant.company_id \n" + 
			"        AND m_customer.cust_id=t_chalan_header.cust_id \n" + 
			"        AND m_project.proj_id=t_chalan_header.proj_id  \n" + 
			"        AND t_chalan_header.chalan_id=:chalanId \n" + 
			"        AND t_chalan_header.ex_int1=1 \n" + 
			"        AND t_chalan_header.order_id=t_order_header.order_id\n" + 
			"                AND t_cust_po_header.po_id=t_order_header.po_id", nativeQuery = true)

	GetChalanHeader2 getGetChalanHeaderByChalanId(@Param("chalanId") int chalanId);

}
