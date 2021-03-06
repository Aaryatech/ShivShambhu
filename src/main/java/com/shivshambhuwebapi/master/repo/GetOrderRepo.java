package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetOrder;

public interface GetOrderRepo extends JpaRepository<GetOrder, Integer> {

	@Query(value = "SELECT t_order_header.*,"
			+ " m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_customer.cust_mob_no,m_project.proj_name,m_project.address,t_cust_po_header.varchar1 as delivery,t_cust_po_header.po_no "
			+ " FROM t_order_header,m_plant,m_company,m_customer,m_project,t_cust_po_header "
			+ " WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id AND t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id"
			+ " AND t_order_header.plant_id=:plantId AND t_order_header.cust_id=:custId AND "
			+ " t_order_header.order_date BETWEEN :fromDate AND :toDate   AND t_order_header.po_id=t_cust_po_header.po_id AND t_order_header.del_status=1    ORDER BY t_order_header.order_date DESC  ", nativeQuery = true)
	List<GetOrder> getOrderBetweenDate(@Param("plantId") int plantId, @Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT t_order_header.*,t_cust_po_header.varchar1 as delivery,t_cust_po_header.po_no,"
			+ " m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_customer.cust_mob_no,m_project.proj_name,m_project.address "
			+ " FROM t_order_header,m_plant,m_company,m_customer,m_project,t_cust_po_header  "
			+ " WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id AND t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id"
			+ " AND t_order_header.plant_id=:plantId   AND t_order_header.po_id=t_cust_po_header.po_id AND  "
			+ " t_order_header.order_date BETWEEN :fromDate AND :toDate AND t_order_header.del_status=1    ORDER BY t_order_header.order_date DESC  ", nativeQuery = true)
	List<GetOrder> getOrderBetweenDateCust(@Param("plantId") int plantId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT t_order_header.*,t_cust_po_header.varchar1 as delivery,t_cust_po_header.po_no,"
			+ " m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_customer.cust_mob_no,m_project.proj_name,m_project.address "
			+ " FROM t_order_header,m_plant,m_company,m_customer,m_project,t_cust_po_header "
			+ " WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id AND "
			+ "t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id AND t_order_header.po_id=t_cust_po_header.po_id AND "
			+ "t_order_header.order_id=:orderId   ", nativeQuery = true)
	GetOrder getOrderHeaderById(@Param("orderId") int orderId);

	// 1

	@Query(value = "SELECT t_order_header.*,t_cust_po_header.po_no,"
			+ " m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_customer.cust_mob_no,m_project.proj_name,m_project.address,t_cust_po_header.varchar1 as delivery "
			+ " FROM t_order_header,m_plant,m_company,m_customer,m_project,t_cust_po_header "
			+ " WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id  AND  t_order_header.status IN (0,1) AND t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id"
			+ " AND t_order_header.plant_id=:plantId AND t_order_header.cust_id=:custId AND "
			+ " t_order_header.order_date BETWEEN :fromDate AND :toDate AND t_order_header.del_status=1 AND t_order_header.po_id=t_cust_po_header.po_id    ORDER BY t_order_header.order_id DESC  ", nativeQuery = true)
	List<GetOrder> getPendingOrderBetweenDateCust(@Param("plantId") int plantId, @Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

//2
	@Query(value = "SELECT t_order_header.*,t_cust_po_header.po_no,"
			+ " m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_customer.cust_mob_no,m_project.proj_name,m_project.address,t_cust_po_header.varchar1 as delivery "
			+ " FROM t_order_header,m_plant,m_company,m_customer,m_project ,t_cust_po_header"
			+ " WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id  AND  t_order_header.status IN (0,1) AND t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id"
			+ " AND t_order_header.plant_id=:plantId AND  "
			+ " t_order_header.order_date BETWEEN :fromDate AND :toDate AND t_order_header.del_status=1 AND  t_order_header.po_id=t_cust_po_header.po_id   ORDER BY t_order_header.order_id DESC  ", nativeQuery = true)
	List<GetOrder> getPendingOrderBetweenDate(@Param("plantId") int plantId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT t_order_header.*,t_cust_po_header.po_no,"
			+ " m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_customer.cust_mob_no,m_project.proj_name,m_project.address,t_cust_po_header.varchar1 as delivery "
			+ " FROM t_order_header,m_plant,m_company,m_customer,m_project,t_cust_po_header "
			+ " WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id AND t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id"
			+ " AND t_order_header.order_date BETWEEN :fromDate AND :toDate AND t_order_header.del_status=1 AND t_order_header.status IN (:statusList) AND t_order_header.po_id=t_cust_po_header.po_id  ORDER BY t_order_header.order_id DESC  ", nativeQuery = true)
	List<GetOrder> getOrderBetweenDateAll(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("statusList") List<Integer> statusList);

	@Query(value = "SELECT t_order_header.*,t_cust_po_header.po_no,"
			+ " m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_customer.cust_mob_no,m_project.proj_name,m_project.address,t_cust_po_header.varchar1 as delivery "
			+ " FROM t_order_header,m_plant,m_company,m_customer,m_project,t_cust_po_header "
			+ " WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id AND t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id"
			+ " AND t_order_header.order_date BETWEEN :fromDate AND :toDate AND t_order_header.del_status=1 AND t_order_header.cust_id=:custId AND t_order_header.status IN (:statusList) AND t_order_header.po_id=t_cust_po_header.po_id  ORDER BY t_order_header.order_id DESC  ", nativeQuery = true)
	List<GetOrder> getOrderBetweenDateAndCust(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("custId") int custId, @Param("statusList") List<Integer> statusList);

	@Query(value = "SELECT t_order_header.*,t_cust_po_header.po_no,"
			+ " m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_customer.cust_mob_no,m_project.proj_name,m_project.address,t_cust_po_header.varchar1 as delivery "
			+ " FROM t_order_header,m_plant,m_company,m_customer,m_project,t_cust_po_header "
			+ " WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id AND t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id"
			+ " AND t_order_header.order_date BETWEEN :fromDate AND :toDate AND t_order_header.del_status=1 AND t_order_header.plant_id=:plantId AND t_order_header.status IN (:statusList) AND t_order_header.po_id=t_cust_po_header.po_id  ORDER BY t_order_header.order_id DESC  ", nativeQuery = true)
	List<GetOrder> getOrderBetweenDateAndPlant(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("plantId") int plantId, @Param("statusList") List<Integer> statusList);

	@Query(value = "SELECT t_order_header.*,t_cust_po_header.po_no,"
			+ " m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_customer.cust_mob_no,m_project.proj_name,m_project.address,t_cust_po_header.varchar1 as delivery "
			+ " FROM t_order_header,m_plant,m_company,m_customer,m_project,t_cust_po_header "
			+ " WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id AND t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id"
			+ " AND t_order_header.order_date BETWEEN :fromDate AND :toDate AND t_order_header.del_status=1 AND t_order_header.plant_id=:plantId AND t_order_header.cust_id=:custId AND t_order_header.status IN (:statusList) AND t_order_header.po_id=t_cust_po_header.po_id  ORDER BY t_order_header.order_id DESC  ", nativeQuery = true)
	List<GetOrder> getOrderBetweenDateAndPlantAndCust(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("plantId") int plantId, @Param("custId") int custId,
			@Param("statusList") List<Integer> statusList);

}