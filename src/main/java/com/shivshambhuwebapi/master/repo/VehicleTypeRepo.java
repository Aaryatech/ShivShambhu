package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.VehicleType;

public interface VehicleTypeRepo extends JpaRepository<VehicleType, Integer> {

	List<VehicleType> findByDelStatusOrderByVehTypeIdDesc(int i);

}
