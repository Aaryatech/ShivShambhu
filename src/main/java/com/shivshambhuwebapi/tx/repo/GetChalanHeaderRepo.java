package com.shivshambhuwebapi.tx.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetChalanHeader;

public interface GetChalanHeaderRepo extends JpaRepository<GetChalanHeader, Integer> {
	@Query(value = " SELECT\n" + 
			"        t_chalan_header.*,\n" + 
			"        m_vehicle.veh_no,\n" + 
			"        m_vehicle.vehicle_name,\n" + 
			"        m_plant.plant_name,\n" + 
			"        m_company.comp_name,\n" + 
			"        m_customer.cust_name,\n" + 
			"        m_customer.cust_mob_no,\n" + 
			"        m_project.proj_name,\n" + 
			"        m_project.address as proj_address\n" + 
			"        ,COALESCE((SELECT m_user.usr_name from m_user WHERE m_user.user_id=t_chalan_header.driver_id),'NA')AS driver_name,\n" + 
			"        COALESCE((SELECT m_user.usr_name from m_user WHERE m_user.user_id=t_chalan_header.ex_var1),'NA')AS user_name\n" + 
			"        \n" + 
			"    FROM\n" + 
			"        m_vehicle,\n" + 
			"        m_plant,\n" + 
			"        m_company,\n" + 
			"        m_customer,\n" + 
			"        m_project,\n" + 
			"        t_chalan_header   \n" + 
			"    WHERE\n" + 
			"        m_vehicle.vehicle_id=t_chalan_header.vehicle_id \n" + 
			"        AND t_chalan_header.plant_id=m_plant.plant_id  \n" + 
			"        AND m_company.company_id=m_plant.company_id \n" + 
			"        AND m_customer.cust_id=t_chalan_header.cust_id  \n" + 
			"        AND m_project.proj_id=t_chalan_header.proj_id \n" + 
			"        AND t_chalan_header.plant_id=:plantId \n" + 
			"        AND t_chalan_header.ex_int1=1  ORDER BY t_chalan_header.status ,t_chalan_header.chalan_date ", nativeQuery = true)

	List<GetChalanHeader> getGetChalanHeaderByPlantId(@Param("plantId") int plantId);
	
	
	
	@Query(value = " SELECT\n" + 
			"        t_chalan_header.*,\n" + 
			"        m_vehicle.veh_no,\n" + 
			"        m_vehicle.vehicle_name,\n" + 
			"        m_plant.plant_name,\n" + 
			"        m_company.comp_name,\n" + 
			"        m_customer.cust_name,\n" + 
			"        m_customer.cust_mob_no,\n" + 
			"        m_project.proj_name,\n" + 
			"        m_project.address as proj_address\n" + 
			"        ,COALESCE((SELECT m_user.usr_name from m_user WHERE m_user.user_id=t_chalan_header.driver_id),'NA')AS driver_name,\n" + 
			"        COALESCE((SELECT m_user.usr_name from m_user WHERE m_user.user_id=t_chalan_header.ex_var1),'NA')AS user_name\n" + 
			"        \n" + 
			"    FROM\n" + 
			"        m_vehicle,\n" + 
			"        m_plant,\n" + 
			"        m_company,\n" + 
			"        m_customer,\n" + 
			"        m_project,\n" + 
			"        t_chalan_header   \n" + 
			"    WHERE\n" + 
			"        m_vehicle.vehicle_id=t_chalan_header.vehicle_id \n" + 
			"        AND t_chalan_header.plant_id=m_plant.plant_id  \n" + 
			"        AND m_company.company_id=m_plant.company_id \n" + 
			"        AND m_customer.cust_id=t_chalan_header.cust_id  \n" + 
			"        AND m_project.proj_id=t_chalan_header.proj_id \n" + 
			"        AND t_chalan_header.plant_id=:plantId \n" +	
			"        AND t_chalan_header.ex_float1=0 \n" +	
			"        AND t_chalan_header.ex_int1=1  ORDER BY t_chalan_header.status ,t_chalan_header.chalan_date ", nativeQuery = true)

	List<GetChalanHeader> getGetOpenChalanHeaderByPlantId(@Param("plantId") int plantId);
	
	
	
	@Query(value = " SELECT t_chalan_header.*,m_vehicle.veh_no,m_vehicle.vehicle_name,m_plant.plant_name,m_company.comp_name," + 
			" m_customer.cust_name,m_customer.cust_mob_no," + 
			" m_project.proj_name,m_project.address as proj_address,"
			+ " COALESCE((SELECT m_user.usr_name from m_user WHERE m_user.user_id=t_chalan_header.driver_id),'NA')AS driver_name," + 
			" COALESCE((SELECT m_user.usr_name from m_user WHERE m_user.user_id=t_chalan_header.ex_var1),'NA')AS user_name " + 
			" FROM m_vehicle,m_plant,m_company,m_customer,m_project,t_chalan_header" + 
			"  WHERE m_vehicle.vehicle_id=t_chalan_header.vehicle_id AND t_chalan_header.plant_id=m_plant.plant_id "
			+  " AND m_company.company_id=m_plant.company_id AND m_customer.cust_id=t_chalan_header.cust_id"
			+ " AND m_project.proj_id=t_chalan_header.proj_id"
			+ "  AND t_chalan_header.chalan_id=:chalanId  AND t_chalan_header.ex_int1=1 ", nativeQuery = true)

	GetChalanHeader getGetChalanHeaderByChalanId(@Param("chalanId") int chalanId);

	@Query(value = " SELECT t_chalan_header.*,m_vehicle.veh_no,m_vehicle.vehicle_name,m_plant.plant_name,m_company.comp_name, m_customer.cust_name,m_customer.cust_mob_no,m_project.proj_name,m_project.address as proj_address,COALESCE((SELECT m_user.usr_name from m_user WHERE m_user.user_id=t_chalan_header.driver_id),'NA')AS driver_name," + 
			"  COALESCE((SELECT m_user.usr_name from m_user WHERE m_user.user_id=t_chalan_header.ex_var1),'NA')AS user_name  FROM m_vehicle,m_plant,m_company,m_customer,m_project,t_chalan_header  WHERE m_vehicle.vehicle_id=t_chalan_header.vehicle_id AND t_chalan_header.plant_id=m_plant.plant_id  AND m_company.company_id=m_plant.company_id AND m_customer.cust_id=t_chalan_header.cust_id AND m_project.proj_id=t_chalan_header.proj_id  AND  t_chalan_header.order_id In(select order_id from t_order_header where po_id=:po_id and status IN(:chalan_status)) and t_chalan_header.status IN(:bill_status)  AND t_chalan_header.ex_int1=1 ", nativeQuery = true)
	List<GetChalanHeader> getGetChalanHeaderByCustId(@Param("po_id")int poId,@Param("chalan_status") List<Integer> chalanStatus,@Param("bill_status") List<Integer> billStatus);


}
