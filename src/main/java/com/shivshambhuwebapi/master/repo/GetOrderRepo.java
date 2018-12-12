package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetOrder;

public interface GetOrderRepo extends JpaRepository<GetOrder, Integer> {

	@Query(value = "SELECT t_order_header.*,"
			+ " m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_project.proj_name,m_project.address "
			+ " FROM t_order_header,m_plant,m_company,m_customer,m_project "
			+ " WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id AND t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id"
			+ " AND t_order_header.plant_id=:plantId AND t_order_header.cust_id=:custId AND "
			+ " t_order_header.order_date BETWEEN :fromDate AND :toDate    ORDER BY t_order_header.order_date DESC  ", nativeQuery = true)
	List<GetOrder> getOrderBetweenDate(@Param("plantId") int plantId, @Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	
	@Query(value = "SELECT t_order_header.*,"
			+ " m_plant.plant_name,m_company.comp_name,m_customer.cust_name,m_project.proj_name,m_project.address "
			+ " FROM t_order_header,m_plant,m_company,m_customer,m_project "
			+ " WHERE t_order_header.plant_id=m_plant.plant_id AND m_plant.company_id=m_company.company_id AND "
			+ "t_order_header.cust_id=m_customer.cust_id AND m_project.proj_id=t_order_header.proj_id AND "
			+ "t_order_header.order_id=:orderId   ", nativeQuery = true)
	GetOrder getOrderHeaderById(@Param("orderId") int orderId);

}
