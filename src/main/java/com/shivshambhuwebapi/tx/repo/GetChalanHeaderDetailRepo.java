package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetChalanHeaderDetail;

public interface GetChalanHeaderDetailRepo extends JpaRepository<GetChalanHeaderDetail, Integer> {

	@Query(value = " SELECT\n" + 
			"        t_chalan_header.*,\n" + 
			"        m_vehicle.veh_no,\n" + 
			"        m_vehicle.vehicle_name,\n" + 
			"        m_plant.plant_name,\n" + 
			"        m_company.comp_name,\n" + 
			"        m_company.company_id,\n" + 
			"        m_customer.cust_name,\n" + 
			"        m_customer.cust_mob_no,\n" + 
			"        m_project.proj_name,\n" + 
			"        m_project.address as proj_address        ,\n" + 
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
			"        'NA')AS user_name,\n" + 
			"        t_chalan_detail.chalan_detail_id,\n" + 
			"         t_chalan_detail.item_id,\n" + 
			"          t_chalan_detail.item_uom,\n" + 
			"           t_chalan_detail.item_qty,\n" + 
			"             \n" + 
			"        m_item_fg.item_name,\n" + 
			"        m_item_fg.item_code,\n" + 
			"          t_cust_po_detail.po_rate as item_rate1,\n" + 
			"        m_uom.uom_name, \n" + 
			"        m_uom.uom_short_name\n" + 
			"         \n" + 
			"    FROM\n" + 
			"        m_vehicle,\n" + 
			"        m_plant,\n" + 
			"        m_company,\n" + 
			"        m_customer,\n" + 
			"        m_project,\n" + 
			"        t_chalan_header,\n" + 
			"        t_chalan_detail,\n" + 
			"        m_item_fg,m_uom  ,\n" + 
			"        t_cust_po_detail,\n" + 
			"        t_order_detail\n" + 
			"    WHERE\n" + 
			"        m_vehicle.vehicle_id=t_chalan_header.vehicle_id         \n" + 
			"        AND t_chalan_header.plant_id=m_plant.plant_id          \n" + 
			"        AND m_company.company_id=m_plant.company_id         \n" + 
			"        AND m_customer.cust_id=t_chalan_header.cust_id          \n" + 
			"        AND m_project.proj_id=t_chalan_header.proj_id         \n" + 
			"        AND t_chalan_header.plant_id=:plantId       AND t_chalan_header.cust_id=:custId\n" + 
			
			"        AND t_chalan_header.chalan_date BETWEEN  :fromDate AND :toDate\n" + 
			"        AND t_chalan_header.ex_int1=1  \n" + 
			"        AND t_chalan_header.status!=2 \n" + 
			"        AND  t_chalan_detail.item_id=m_item_fg.item_id \n" + 
			"        AND m_item_fg.uom_id=m_uom.uom_id\n" + 
			"        AND t_chalan_detail.chalan_id=t_chalan_header.chalan_id \n" + 
			"        AND t_order_detail.order_det_id=t_chalan_detail.order_detail_id\n" + 
			"        AND t_order_detail.po_detail_id=t_cust_po_detail.po_detail_id\n" + 
			"    ORDER BY\n" + 
			"        t_chalan_header.chalan_id DESC  \n" + 
			"  \n" + "", nativeQuery = true)

	List<GetChalanHeaderDetail> getGetChalanHeaderByPlantIdAndCustId(@Param("plantId") int plantId,
			@Param("custId") int custId, @Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "  SELECT\n" + 
			"        t_chalan_header.*,\n" + 
			"        m_vehicle.veh_no,\n" + 
			"        m_vehicle.vehicle_name,\n" + 
			"        m_plant.plant_name,\n" + 
			"        m_company.comp_name,\n" + 
			"        m_company.company_id,\n" + 
			"        m_customer.cust_name,\n" + 
			"        m_customer.cust_mob_no,\n" + 
			"        m_project.proj_name,\n" + 
			"        m_project.address as proj_address        ,\n" + 
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
			"        'NA')AS user_name,\n" + 
			"        t_chalan_detail.chalan_detail_id,\n" + 
			"         t_chalan_detail.item_id,\n" + 
			"          t_chalan_detail.item_uom,\n" + 
			"           t_chalan_detail.item_qty,\n" + 
			"             \n" + 
			"        m_item_fg.item_name,\n" + 
			"        m_item_fg.item_code,\n" + 
			"          t_cust_po_detail.po_rate as item_rate1,\n" + 
			"        m_uom.uom_name, \n" + 
			"        m_uom.uom_short_name\n" + 
			"         \n" + 
			"    FROM\n" + 
			"        m_vehicle,\n" + 
			"        m_plant,\n" + 
			"        m_company,\n" + 
			"        m_customer,\n" + 
			"        m_project,\n" + 
			"        t_chalan_header,\n" + 
			"        t_chalan_detail,\n" + 
			"        m_item_fg,m_uom  ,\n" + 
			"        t_cust_po_detail,\n" + 
			"        t_order_detail\n" + 
			"    WHERE\n" + 
			"        m_vehicle.vehicle_id=t_chalan_header.vehicle_id         \n" + 
			"        AND t_chalan_header.plant_id=m_plant.plant_id          \n" + 
			"        AND m_company.company_id=m_plant.company_id         \n" + 
			"        AND m_customer.cust_id=t_chalan_header.cust_id          \n" + 
			"        AND m_project.proj_id=t_chalan_header.proj_id         \n" + 
			"        AND t_chalan_header.plant_id=:plantId \n" + 
			"        \n" + 
			"        AND t_chalan_header.chalan_date BETWEEN  :fromDate AND :toDate\n" + 
			"        AND t_chalan_header.ex_int1=1  \n" + 
			"        AND t_chalan_header.status!=2 \n" + 
			"        AND  t_chalan_detail.item_id=m_item_fg.item_id \n" + 
			"        AND m_item_fg.uom_id=m_uom.uom_id\n" + 
			"        AND t_chalan_detail.chalan_id=t_chalan_header.chalan_id \n" + 
			"        AND t_order_detail.order_det_id=t_chalan_detail.order_detail_id\n" + 
			"        AND t_order_detail.po_detail_id=t_cust_po_detail.po_detail_id\n" + 
			"    ORDER BY\n" + 
			"        t_chalan_header.chalan_id DESC  \n" + 
			"" + 
			"  \n" + "", nativeQuery = true)

	List<GetChalanHeaderDetail> getGetChalanHeaderByPlantId(@Param("plantId") int plantId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

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
			"        m_project.address as proj_address        ,\n" + 
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
			"        'NA')AS user_name,\n" + 
			"        t_chalan_detail.chalan_detail_id,\n" + 
			"         t_chalan_detail.item_id,\n" + 
			"          t_chalan_detail.item_uom,\n" + 
			"           t_chalan_detail.item_qty,\n" + 
			"             \n" + 
			"        m_item_fg.item_name,\n" + 
			"        m_item_fg.item_code,\n" + 
			"          t_cust_po_detail.po_rate as item_rate1,\n" + 
			"        m_uom.uom_name, \n" + 
			"        m_uom.uom_short_name\n" + 
			"         \n" + 
			"    FROM\n" + 
			"        m_vehicle,\n" + 
			"        m_plant,\n" + 
			"        m_company,\n" + 
			"        m_customer,\n" + 
			"        m_project,\n" + 
			"        t_chalan_header,\n" + 
			"        t_chalan_detail,\n" + 
			"        m_item_fg,m_uom  ,\n" + 
			"        t_cust_po_detail,\n" + 
			"        t_order_detail\n" + 
			"    WHERE\n" + 
			"        m_vehicle.vehicle_id=t_chalan_header.vehicle_id         \n" + 
			"        AND t_chalan_header.plant_id=m_plant.plant_id          \n" + 
			"        AND m_company.company_id=m_plant.company_id         \n" + 
			"        AND m_customer.cust_id=t_chalan_header.cust_id          \n" + 
			"        AND m_project.proj_id=t_chalan_header.proj_id         \n" + 
			"        AND t_chalan_header.plant_id=:plantId \n" + 
			"        \n" + 
			"        AND t_chalan_header.ex_int1=1  \n" + 
			
			"        AND t_chalan_header.status!=2 \n" + 
			"        AND  t_chalan_detail.item_id=m_item_fg.item_id \n" + 
			"        AND m_item_fg.uom_id=m_uom.uom_id\n" + 
			"        AND t_chalan_detail.chalan_id=t_chalan_header.chalan_id \n" + 
			"        AND t_order_detail.order_det_id=t_chalan_detail.order_detail_id\n" + 
			"        AND t_order_detail.po_detail_id=t_cust_po_detail.po_detail_id\n" + 
			"         AND  t_chalan_header.ex_float1=0 \n" + 
			"    ORDER BY\n" + 
			"        t_chalan_header.chalan_id DESC  \n" + 
			"\n" + 
			"" + "", nativeQuery = true)

	List<GetChalanHeaderDetail> getGetChalanByPlantId(@Param("plantId") int plantId);

}
