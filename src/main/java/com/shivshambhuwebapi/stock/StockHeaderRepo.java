package com.shivshambhuwebapi.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockHeaderRepo extends JpaRepository<StockHeader, Integer> {

	StockHeader findByPlantIdAndStatusAndDelStatus(int plantId, int i, int j);

	StockHeader findByStockIdAndDelStatus(int stockId, int i);

}
