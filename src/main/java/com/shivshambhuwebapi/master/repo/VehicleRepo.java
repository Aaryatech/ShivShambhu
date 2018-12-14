package com.shivshambhuwebapi.master.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

	List<Vehicle> findByDelStatusOrderByVehicleIdDesc(int i);

	List<Vehicle> findByVehicleTypeAndDelStatus(int vehicleType, int i);
	
	

	@Transactional
	@Modifying
	@Query("update Vehicle  set del_status=0  WHERE vehicle_id=:vehId")
	int deleteVehicle(@Param("vehId")int vehId);

	@Transactional
	@Modifying
	@Query("UPDATE Vehicle  SET delStatus=0  WHERE vehicle_id IN(:vehIds)")
	int deleteMultiVehicleDetail(@Param("vehIds") List<Integer> vehIds);
	

}
