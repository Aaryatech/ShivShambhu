package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetWeighing;

public interface GetWeighingRepo extends JpaRepository<GetWeighing, Integer> {

	@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name from m_vehicle WHERE"
			+ " t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,\n"
			+ "coalesce((SELECT m_vehicle.vehicle_name from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'Na')"
			+ " as poke_name from t_weighing,m_contractor c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id ", nativeQuery = true)

	List<GetWeighing> getWeighingList();

	@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name from m_vehicle WHERE "
			+ "t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,\n"
			+ "coalesce((SELECT m_vehicle.vehicle_name from m_vehicle WHERE"
			+ " t_weighing.poklen_id=m_vehicle.vehicle_id),'Na') as poke_name from t_weighing,m_contractor "
			+ "c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id AND t_weighing.weigh_id=:weighId", nativeQuery = true)

	List<GetWeighing> getWeighingByWeighId(@Param("weighId") int weighId);

}
