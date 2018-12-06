package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetVehHeader;

public interface GetVehHeaderRepo extends JpaRepository<GetVehHeader, Integer> {

	@Query(value = "SELECT h.*,v.vehicle_name,v.veh_comp_name  FROM t_issue_veh_header h,m_vehicle v WHERE h.del_status=1 AND h.veh_id=v.vehicle_id", nativeQuery = true)
	List<GetVehHeader> getMatIssueHeadeList();

	@Query(value = "SELECT h.*,v.vehicle_name,v.veh_comp_name  FROM t_issue_veh_header h,m_vehicle v WHERE h.del_status=1 AND h.veh_id=v.vehicle_id AND h.mat_veh_header_id=:matVehHeaderId", nativeQuery = true)
	GetVehHeader getMatIssueByHeaderId(@Param("matVehHeaderId") int matVehHeaderId);

}
