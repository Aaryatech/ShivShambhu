package com.shivshambhuwebapi.stock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GetStockDetailRepo extends JpaRepository<GetStockDetail, Integer> {

	@Query(value = "SELECT d.*,i.item_name,i.item_code,u.uom_name  FROM t_stock_det d,m_item_fg i,m_uom u WHERE d.stock_id=:stockId AND d.item_id=i.item_id AND u.uom_id=i.uom_id", nativeQuery = true)
	List<GetStockDetail> getStockDetail(@Param("stockId") int stockId);

	@Query(value = "SELECT d.*,i.item_name,i.item_code,u.uom_name  FROM t_stock_det d,m_item_fg i,m_uom u ,t_stock_head h WHERE d.stock_id=h.stock_id AND d.item_id=i.item_id AND u.uom_id=i.uom_id AND h.plant_id=:plantId AND h.status=0", nativeQuery = true)
	List<GetStockDetail> getStockDetailByPlantId(@Param("plantId") int plantId);

/*	@Query(value = "SELECT d.*,i.item_name,i.item_code,u.uom_name  FROM t_stock_det d,m_item_fg i,m_uom u ,t_stock_head h WHERE d.stock_id=h.stock_id AND d.item_id=i.item_id AND u.uom_id=i.uom_id AND h.plant_id=:plantId AND h.status=0", nativeQuery = true)
	List<GetStockDetail> getStockDetailByPlantAndCurDate(@Param("plantId") int plantId,
			@Param("currDate") String currDate);

	@Query(value = "SELECT d.*,i.item_name,i.item_code,u.uom_name  FROM t_stock_det d,m_item_fg i,m_uom u ,t_stock_head h WHERE d.stock_id=h.stock_id AND d.item_id=i.item_id AND u.uom_id=i.uom_id AND h.plant_id=:plantId AND h.status=0", nativeQuery = true)
	List<GetStockDetail> getStockDetailByPlantAndBetDate(@Param("plantId") int plantId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);*/
}
