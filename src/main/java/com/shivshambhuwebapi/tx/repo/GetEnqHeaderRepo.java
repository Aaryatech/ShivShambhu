package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetEnqHeader;

public interface GetEnqHeaderRepo extends JpaRepository<GetEnqHeader, Integer> {

	@Query(value = " SELECT h.*,c.cust_name,p.plant_name,e.enq_gen_by FROM  t_enq_header h ,m_customer c,m_plant p,enq_gen_fact "
			+ "e WHERE c.cust_id=h.cust_id AND p.plant_id=h.plant_id AND e.enq_gen_id=h.enq_gen_id  AND h.plant_id=:plantId", nativeQuery = true)

	List<GetEnqHeader> getEnqHeaderByPlantId(@Param("plantId") int plantId);

}
