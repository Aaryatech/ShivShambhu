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

	@Query(value = "SELECT\n" + 
			"    d.stock_det_id," + 
			"    d.stock_id," + 
			"    d.item_id," + 
			"    d.op_qty," + 
			"    i.item_name," + 
			"    i.item_code," + 
			"    u.uom_name," + 
			"    COALESCE(" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            SUM(pd.production_qty)\n" + 
			"        FROM\n" + 
			"            t_production_plan_detail pd,\n" + 
			"            t_production_plan_header ph\n" + 
			"        WHERE\n" + 
			"            pd.production_header_id = ph.production_header_id AND ph.del_status = 1 AND ph.plant_id =:plantId AND pd.item_id = d.item_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS prod_qty,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            SUM(cd.item_qty)\n" + 
			"        FROM\n" + 
			"            t_chalan_detail cd,\n" + 
			"            t_chalan_header ch\n" + 
			"        WHERE\n" + 
			"            cd.chalan_id = ch.chalan_id AND ch.plant_id =:plantId  AND cd.item_id = d.item_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS chalan_qty,\n" + 
			"    (\n" + 
			"        d.op_qty +(\n" + 
			"            COALESCE(\n" + 
			"                (\n" + 
			"                SELECT\n" + 
			"                    SUM(pd.production_qty)\n" + 
			"                FROM\n" + 
			"                    t_production_plan_detail pd,\n" + 
			"                    t_production_plan_header ph\n" + 
			"                WHERE\n" + 
			"                    pd.production_header_id = ph.production_header_id AND ph.del_status = 1 AND ph.plant_id =:plantId  AND pd.item_id = d.item_id\n" + 
			"            ),\n" + 
			"            0\n" + 
			"            )\n" + 
			"        ) -(\n" + 
			"            COALESCE(\n" + 
			"                (\n" + 
			"                SELECT\n" + 
			"                    SUM(cd.item_qty)\n" + 
			"                FROM\n" + 
			"                    t_chalan_detail cd,\n" + 
			"                    t_chalan_header ch\n" + 
			"                WHERE\n" + 
			"                    cd.chalan_id = ch.chalan_id AND ch.plant_id =:plantId  AND cd.item_id = d.item_id\n" + 
			"            ),\n" + 
			"            0\n" + 
			"            )\n" + 
			"        )\n" + 
			"    ) AS closing_qty,\n" + 
			"    d.del_status,\n" + 
			"    d.user_id,\n" + 
			"    d.detail_date,\n" + 
			"    d.ex_int1,\n" + 
			"    d.ex_int2,\n" + 
			"    d.ex_float1,\n" + 
			"    d.ex_float2,\n" + 
			"    d.ex_date1,\n" + 
			"    d.ex_bool1,\n" + 
			"    d.ex_var1,\n" + 
			"    d.ex_var2\n" + 
			"FROM\n" + 
			"    t_stock_head h,\n" + 
			"    t_stock_det d,\n" + 
			"    m_item_fg i,\n" + 
			"    m_uom u\n" + 
			"WHERE\n" + 
			"    h.stock_id = d.stock_id AND h.del_status = 1 AND d.del_status = 1 AND h.plant_id =:plantId  AND h.status = 0 AND u.uom_id = i.uom_id AND i.item_id = d.item_id\n" + 
			"GROUP BY\n" + 
			"    d.item_id ", nativeQuery = true)
	List<GetStockDetail> getStockDetailByPlantAndCurDate(@Param("plantId") int plantId);

	@Query(value = "SELECT\n" + 
			"    d.stock_det_id,\n" + 
			"    d.stock_id,\n" + 
			"    d.item_id,\n" + 
			"    d.op_qty,\n" + 
			"    i.item_name,\n" + 
			"    i.item_code,\n" + 
			"    u.uom_name,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            SUM(pd.production_qty)\n" + 
			"        FROM\n" + 
			"            t_production_plan_detail pd,\n" + 
			"            t_production_plan_header ph\n" + 
			"        WHERE\n" + 
			"            pd.production_header_id = ph.production_header_id AND ph.del_status = 1 AND ph.plant_id = :plantId AND ph.production_date BETWEEN :fromDate AND :toDate AND pd.item_id = d.item_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS prod_qty,\n" + 
			"    COALESCE(\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            SUM(cd.item_qty)\n" + 
			"        FROM\n" + 
			"            t_chalan_detail cd,\n" + 
			"            t_chalan_header ch\n" + 
			"        WHERE\n" + 
			"            cd.chalan_id = ch.chalan_id AND ch.plant_id = :plantId AND ch.chalan_date BETWEEN :fromDate AND :toDate AND cd.item_id = d.item_id\n" + 
			"    ),\n" + 
			"    0\n" + 
			"    ) AS chalan_qty,\n" + 
			"    (\n" + 
			"        d.op_qty +(\n" + 
			"            COALESCE(\n" + 
			"                (\n" + 
			"                SELECT\n" + 
			"                    SUM(pd.production_qty)\n" + 
			"                FROM\n" + 
			"                    t_production_plan_detail pd,\n" + 
			"                    t_production_plan_header ph\n" + 
			"                WHERE\n" + 
			"                    pd.production_header_id = ph.production_header_id AND ph.del_status = 1 AND ph.plant_id = :plantId AND ph.production_date BETWEEN :fromDate AND :toDate \" + \" AND pd.item_id = d.item_id\n" + 
			"            ),\n" + 
			"            0\n" + 
			"            )\n" + 
			"        ) -(\n" + 
			"            COALESCE(\n" + 
			"                (\n" + 
			"                SELECT\n" + 
			"                    SUM(cd.item_qty)\n" + 
			"                FROM\n" + 
			"                    t_chalan_detail cd,\n" + 
			"                    t_chalan_header ch\n" + 
			"                WHERE\n" + 
			"                    cd.chalan_id = ch.chalan_id AND ch.plant_id = :plantId AND ch.chalan_date BETWEEN :fromDate AND :toDate AND cd.item_id = d.item_id\n" + 
			"            ),\n" + 
			"            0\n" + 
			"            )\n" + 
			"        )\n" + 
			"    ) AS closing_qty,\n" + 
			"    d.del_status,\n" + 
			"    d.user_id,\n" + 
			"    d.detail_date,\n" + 
			"    d.ex_int1,\n" + 
			"    d.ex_int2,\n" + 
			"    d.ex_float1,\n" + 
			"    d.ex_float2,\n" + 
			"    d.ex_date1,\n" + 
			"    d.ex_bool1,\n" + 
			"    d.ex_var1,\n" + 
			"    d.ex_var2\n" + 
			"FROM\n" + 
			"    t_stock_head h,\n" + 
			"    t_stock_det d,\n" + 
			"    m_item_fg i,\n" + 
			"    m_uom u\n" + 
			"WHERE\n" + 
			"    h.stock_id = d.stock_id AND h.del_status = 1 AND d.del_status = 1 AND h.plant_id = :plantId AND h.start_date = :fromDate AND h.status = 0 AND u.uom_id = i.uom_id AND i.item_id = d.item_id\n" + 
			"GROUP BY\n" + 
			"    d.item_id  ", nativeQuery = true)
	List<GetStockDetail> getStockDetailByPlantAndBetDate(@Param("plantId") int plantId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
