package com.shivshambhuwebapi.stock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GetStockHeaderRepo extends JpaRepository<GetStockHeader, Integer> {

	@Query(value = "SELECT h.*,p.plant_name FROM t_stock_head h,m_plant p WHERE h.status In(:statusList) AND h.start_date=:currDate AND p.plant_id=h.plant_id", nativeQuery = true)
	List<GetStockHeader> getStockheader(@Param("currDate") String currDate,
			@Param("statusList") List<Integer> statusList);

}
