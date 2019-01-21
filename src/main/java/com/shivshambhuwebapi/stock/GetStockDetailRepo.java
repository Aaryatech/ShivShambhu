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

	@Query(value = "SELECT d.stock_det_id,d.stock_id,d.item_id,d.op_qty,i.item_name,i.item_code,u.uom_name,\n"
			+ "COALESCE((SELECT SUM(pd.production_qty) from t_production_plan_detail pd,\n"
			+ "t_production_plan_header ph WHERE pd.production_header_id=ph.production_header_id\n"
			+ " AND ph.del_status=1 AND ph.plant_id=:plantId AND ph.production_date=:currDate AND \n"
			+ "pd.item_id=d.item_id),0) as prod_qty,\n" + "COALESCE((SELECT SUM(cd.item_qty) from t_chalan_detail cd,\n"
			+ "t_chalan_header ch WHERE cd.chalan_id=ch.chalan_id  AND ch.plant_id=:plantId\n"
			+ " AND ch.chalan_date=:currDate AND cd.item_id=d.item_id),0) as chalan_qty,\n"
			+ "(d.op_qty+(COALESCE((SELECT SUM(pd.production_qty) from t_production_plan_detail pd, t_production_plan_header ph WHERE pd.production_header_id=ph.production_header_id AND ph.del_status=1 AND ph.plant_id=68 AND ph.production_date=:currDate AND pd.item_id=d.item_id),0))-(COALESCE((SELECT SUM(cd.item_qty) from t_chalan_detail cd, t_chalan_header ch WHERE cd.chalan_id=ch.chalan_id  AND ch.plant_id=68 AND ch.chalan_date=:currDate AND cd.item_id=d.item_id),0))) as closing_qty,d.del_status,d.user_id,d.detail_date,d.ex_int1,d.ex_int2,d.ex_float1,\n"
			+ "d.ex_float2,d.ex_date1,d.ex_bool1,d.ex_var1,d.ex_var2 FROM t_stock_head h, \n"
			+ "t_stock_det d ,m_item_fg i ,m_uom u WHERE h.stock_id=d.stock_id AND h.del_status=1 AND d.del_status=1\n"
			+ " AND h.plant_id=:plantId AND h.start_date=:currDate AND h.status=0 AND u.uom_id=i.uom_id AND i.item_id=d.item_id GROUP BY d.item_id  ", nativeQuery = true)
	List<GetStockDetail> getStockDetailByPlantAndCurDate(@Param("plantId") int plantId,
			@Param("currDate") String currDate);

	@Query(value = "SELECT d.stock_det_id,d.stock_id,d.item_id,d.op_qty,i.item_name,i.item_code,u.uom_name,\n"
			+ "COALESCE((SELECT SUM(pd.production_qty) from t_production_plan_detail pd,\n"
			+ "t_production_plan_header ph WHERE pd.production_header_id=ph.production_header_id\n"
			+ " AND ph.del_status=1 AND ph.plant_id=:plantId AND ph.production_date BETWEEN :fromDate AND :toDate AND \n"
			+ "pd.item_id=d.item_id),0) as prod_qty,\n" + "COALESCE((SELECT SUM(cd.item_qty) from t_chalan_detail cd,\n"
			+ "t_chalan_header ch WHERE cd.chalan_id=ch.chalan_id  AND ch.plant_id=:plantId\n"
			+ " AND ch.chalan_date BETWEEN :fromDate AND :toDate AND cd.item_id=d.item_id),0) as chalan_qty,\n"
			+ "(d.op_qty+(COALESCE((SELECT SUM(pd.production_qty) from t_production_plan_detail pd, t_production_plan_header ph WHERE pd.production_header_id=ph.production_header_id AND ph.del_status=1 AND ph.plant_id=68 AND ph.production_date BETWEEN :fromDate AND :toDate AND pd.item_id=d.item_id),0))-(COALESCE((SELECT SUM(cd.item_qty) from t_chalan_detail cd, t_chalan_header ch WHERE cd.chalan_id=ch.chalan_id  AND ch.plant_id=68 AND ch.chalan_date BETWEEN :fromDate AND :toDate AND cd.item_id=d.item_id),0))) as closing_qty"
			+ ",d.del_status,d.user_id,d.detail_date,d.ex_int1,d.ex_int2,d.ex_float1,\n"
			+ "d.ex_float2,d.ex_date1,d.ex_bool1,d.ex_var1,d.ex_var2 FROM t_stock_head h, \n"
			+ "t_stock_det d ,m_item_fg i ,m_uom u WHERE h.stock_id=d.stock_id AND h.del_status=1 AND d.del_status=1\n"
			+ " AND h.plant_id=:plantId AND h.start_date BETWEEN :fromDate AND :toDate AND h.status=0 AND u.uom_id=i.uom_id AND i.item_id=d.item_id GROUP BY d.item_id  ", nativeQuery = true)
	List<GetStockDetail> getStockDetailByPlantAndBetDate(@Param("plantId") int plantId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
