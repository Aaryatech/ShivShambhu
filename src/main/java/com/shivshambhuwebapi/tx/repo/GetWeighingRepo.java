package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetWeighing;

public interface GetWeighingRepo extends JpaRepository<GetWeighing, Integer> {

	@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name  from m_vehicle WHERE"
			+ " t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,coalesce((SELECT m_vehicle.veh_no  "
			+ "from m_vehicle WHERE t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_no,coalesce((SELECT "
			+ "m_vehicle.vehicle_name from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'Na') as "
			+ "poke_name,coalesce((SELECT m_vehicle.veh_no  from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'NA') "
			+ "as poke_no from t_weighing,m_contractor c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id  ORDER BY t_weighing.weigh_id DESC ", nativeQuery = true)

	List<GetWeighing> getWeighingList();

	@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name  from m_vehicle WHERE t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,coalesce((SELECT m_vehicle.veh_no  from m_vehicle WHERE t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_no,coalesce((SELECT m_vehicle.vehicle_name from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'Na') as poke_name,coalesce((SELECT m_vehicle.veh_no  from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'NA') as poke_no from t_weighing,m_contractor c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id  AND t_weighing.weigh_id=2", nativeQuery = true)

	List<GetWeighing> getWeighingByWeighId(@Param("weighId") int weighId);

	@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name  from m_vehicle WHERE"
			+ " t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,coalesce((SELECT m_vehicle.veh_no  "
			+ "from m_vehicle WHERE t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_no,coalesce((SELECT"
			+ " m_vehicle.vehicle_name from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'Na') "
			+ "as poke_name,coalesce((SELECT m_vehicle.veh_no  from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'NA') "
			+ "as poke_no from t_weighing,m_contractor c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id "
			+ " AND t_weighing.contra_id=:contrId", nativeQuery = true)

	List<GetWeighing> getWeighingByContrId(@Param("contrId") int contrId);

	/*@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name  from m_vehicle WHERE"
			+ " t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,coalesce((SELECT m_vehicle.veh_no  "
			+ "from m_vehicle WHERE t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_no,coalesce((SELECT"
			+ " m_vehicle.vehicle_name from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'Na') "
			+ "as poke_name,coalesce((SELECT m_vehicle.veh_no  from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'NA') "
			+ "as poke_no from t_weighing,m_contractor c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id "
			+ " AND t_weighing.veh_id=:vehicleId", nativeQuery = true)

	List<GetWeighing> getWeighingByVehicleId(@Param("vehicleId") int vehicleId);
	
	*/

	//7-1-2019 for poklen
	@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name  from m_vehicle WHERE"
			+ " t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,coalesce((SELECT m_vehicle.veh_no  "
			+ "from m_vehicle WHERE t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_no,coalesce((SELECT"
			+ " m_vehicle.vehicle_name from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'Na') "
			+ "as poke_name,coalesce((SELECT m_vehicle.veh_no  from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'NA') "
			+ "as poke_no from t_weighing,m_contractor c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id "
			+ " AND t_weighing.poklen_id=:vehicleId AND t_weighing.date BETWEEN :fromDate AND :toDate", nativeQuery = true)

	List<GetWeighing> getWeighingByVehicleId(@Param("vehicleId") int vehicleId,@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	//7-1-2019 for vehicle
	@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name  from m_vehicle WHERE"
			+ " t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,coalesce((SELECT m_vehicle.veh_no  "
			+ "from m_vehicle WHERE t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_no,coalesce((SELECT"
			+ " m_vehicle.vehicle_name from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'Na') "
			+ "as poke_name,coalesce((SELECT m_vehicle.veh_no  from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'NA') "
			+ "as poke_no from t_weighing,m_contractor c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id "
			+ " AND t_weighing.veh_id=:vehicleId AND t_weighing.date BETWEEN :fromDate AND :toDate", nativeQuery = true)

	List<GetWeighing> getWeighingByVehId(@Param("vehicleId") int vehicleId,@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	
	
	
	@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name  from m_vehicle WHERE "
			+ "t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,coalesce((SELECT m_vehicle.veh_no  from"
			+ " m_vehicle WHERE t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_no,coalesce("
			+ "(SELECT m_vehicle.vehicle_name from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'Na') "
			+ "as poke_name,coalesce((SELECT m_vehicle.veh_no  from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'NA') "
			+ "as poke_no from t_weighing,m_contractor c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id  AND "
			+ "t_weighing.date between :fromDate AND :toDate AND t_weighing.contra_id=:contrId AND t_weighing.veh_id=:vehicleId ", nativeQuery = true)

	List<GetWeighing> getWeighingBetDateAndById(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("contrId") int contrId, @Param("vehicleId") int vehicleId);

	@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name  from m_vehicle WHERE "
			+ "t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,coalesce((SELECT m_vehicle.veh_no  from"
			+ " m_vehicle WHERE t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_no,coalesce("
			+ "(SELECT m_vehicle.vehicle_name from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'Na') "
			+ "as poke_name,coalesce((SELECT m_vehicle.veh_no  from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'NA') "
			+ "as poke_no from t_weighing,m_contractor c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id  AND "
			+ "t_weighing.date between :fromDate AND :toDate  AND t_weighing.veh_id=:vehicleId ", nativeQuery = true)

	List<GetWeighing> getWeighingBetDateAndByVehicleId(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("vehicleId") int vehicleId);

	@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name  from m_vehicle WHERE "
			+ "t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,coalesce((SELECT m_vehicle.veh_no  from"
			+ " m_vehicle WHERE t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_no,coalesce("
			+ "(SELECT m_vehicle.vehicle_name from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'Na') "
			+ "as poke_name,coalesce((SELECT m_vehicle.veh_no  from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'NA') "
			+ "as poke_no from t_weighing,m_contractor c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id  AND "
			+ "t_weighing.date between :fromDate AND :toDate AND t_weighing.contra_id=:contrId ", nativeQuery = true)

	List<GetWeighing> getWeighingBetDateAndByContrd(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("contrId") int contrId);

	@Query(value = " SELECT t_weighing.*,c.contr_name, coalesce((SELECT m_vehicle.vehicle_name  from m_vehicle WHERE "
			+ "t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_name,coalesce((SELECT m_vehicle.veh_no  from"
			+ " m_vehicle WHERE t_weighing.veh_id=m_vehicle.vehicle_id),'NA') as vehicle_no,coalesce("
			+ "(SELECT m_vehicle.vehicle_name from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'Na') "
			+ "as poke_name,coalesce((SELECT m_vehicle.veh_no  from m_vehicle WHERE t_weighing.poklen_id=m_vehicle.vehicle_id),'NA') "
			+ "as poke_no from t_weighing,m_contractor c WHERE  t_weighing.del_status=1 AND c.contr_id=t_weighing.contra_id  AND "
			+ "t_weighing.date between :fromDate AND :toDate  ", nativeQuery = true)

	List<GetWeighing> getWeighingBetDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
