package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetEnqHeader;

public interface GetEnqHeaderRepo extends JpaRepository<GetEnqHeader, Integer> {

	@Query(value = " SELECT h.*,c.cust_name,c.cust_mob_no,p.plant_name,e.enq_gen_by,r.quot_no,r.quot_date FROM  t_enq_header h ,t_quot_header r,m_customer c,m_plant p,enq_gen_fact e "
			+ " WHERE c.cust_id=h.cust_id AND p.plant_id=h.plant_id AND e.enq_gen_id=h.enq_gen_id AND  h.plant_id=:plantId  AND h.quot_id=r.quot_head_id "
			+ " AND h.enq_date BETWEEN :fromDate AND :toDate  AND h.ex_int1=1 ORDER BY h.enq_head_id DESC ", nativeQuery = true)
	List<GetEnqHeader> getEnqHeaderByPlantId(@Param("plantId") int plantId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = " SELECT h.*,c.cust_name,c.cust_mob_no,p.plant_name,e.enq_gen_by,r.quot_no,r.quot_date FROM  t_enq_header h ,t_quot_header r,m_customer c,m_plant p,enq_gen_fact e "
			+ "	 WHERE c.cust_id=h.cust_id AND p.plant_id=h.plant_id AND e.enq_gen_id=h.enq_gen_id AND  h.plant_id=:plantId  AND  h.cust_id=:custId AND h.quot_id=r.quot_head_id "
			+ "	 AND h.enq_date BETWEEN :fromDate AND :toDate " + " AND h.ex_int1=1 "
			+ "ORDER BY h.enq_head_id DESC ", nativeQuery = true)
	List<GetEnqHeader> getEnqHeaderByPlantIdAndCustId(@Param("plantId") int plantId, @Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " SELECT h.*,c.cust_name,c.cust_mob_no,p.plant_name,e.enq_gen_by,r.quot_no,r.quot_date FROM  t_enq_header h ,t_quot_header r,m_customer c,m_plant p,enq_gen_fact e "
			+ "	 WHERE c.cust_id=h.cust_id AND p.plant_id=h.plant_id AND e.enq_gen_id=h.enq_gen_id   AND  h.cust_id=:custId AND h.quot_id=r.quot_head_id "
			+ "	 AND h.enq_date BETWEEN :fromDate AND :toDate " + " AND h.ex_int1=1 "
			+ "ORDER BY h.enq_head_id DESC ", nativeQuery = true)
	List<GetEnqHeader> getEnqHeaderByCustId(@Param("custId") int custId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = " SELECT h.*,c.cust_name,c.cust_mob_no,p.plant_name,e.enq_gen_by,r.quot_no,r.quot_date FROM  t_enq_header h ,t_quot_header r,m_customer c,m_plant p,enq_gen_fact e "
			+ "	 WHERE c.cust_id=h.cust_id AND p.plant_id=h.plant_id AND e.enq_gen_id=h.enq_gen_id  AND h.quot_id=r.quot_head_id "
			+ "	 AND h.enq_date BETWEEN :fromDate AND :toDate " + " AND h.ex_int1=1 "
			+ "ORDER BY h.enq_head_id DESC ", nativeQuery = true)
	List<GetEnqHeader> getEnqHeaderBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	
	//Anmol 27-12-2018
	@Query(value = " SELECT h.*,c.cust_name,c.cust_mob_no,p.plant_name,e.enq_gen_by,1 quot_no,null quot_date FROM  t_enq_header h ,m_customer c,m_plant p,enq_gen_fact e "
			+ " WHERE c.cust_id=h.cust_id AND p.plant_id=h.plant_id AND e.enq_gen_id=h.enq_gen_id AND  h.plant_id=:plantId "
			+ " AND h.enq_date BETWEEN :fromDate AND :toDate  AND h.ex_int1=1 ORDER BY h.enq_head_id DESC ", nativeQuery = true)
	List<GetEnqHeader> getEnqHeaderByPlantIdForApp(@Param("plantId") int plantId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	//Anmol 27-12-2018
	@Query(value = " SELECT h.*,c.cust_name,c.cust_mob_no,p.plant_name,e.enq_gen_by,1 quot_no,null quot_date FROM  t_enq_header h , m_customer c,m_plant p,enq_gen_fact e "
			+ "	 WHERE c.cust_id=h.cust_id AND p.plant_id=h.plant_id AND e.enq_gen_id=h.enq_gen_id AND  h.plant_id=:plantId  AND  h.cust_id=:custId "
			+ "	 AND h.enq_date BETWEEN :fromDate AND :toDate " + " AND h.ex_int1=1 "
			+ "ORDER BY h.enq_head_id DESC ", nativeQuery = true)
	List<GetEnqHeader> getEnqHeaderByPlantIdAndCustIdForApp(@Param("plantId") int plantId, @Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	
	//28-12-2018
	@Query(value = " SELECT h.*,c.cust_name,c.cust_mob_no,p.plant_name,e.enq_gen_by,1 quot_no,null quot_date FROM  t_enq_header h ,m_customer c,m_plant p,enq_gen_fact e "
			+ " WHERE c.cust_id=h.cust_id AND p.plant_id=h.plant_id AND e.enq_gen_id=h.enq_gen_id AND  h.plant_id=:plantId "
			+ " AND h.enq_date BETWEEN :fromDate AND :toDate  AND h.enq_status=0 AND h.ex_int1=1 ORDER BY h.enq_head_id DESC ", nativeQuery = true)
	List<GetEnqHeader> getEnqHeaderByPlant(@Param("plantId") int plantId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	@Query(value = " SELECT h.*,c.cust_name,c.cust_mob_no,p.plant_name,e.enq_gen_by,1 quot_no,null quot_date FROM  t_enq_header h ,m_customer c,m_plant p,enq_gen_fact e "
			+ " WHERE c.cust_id=h.cust_id AND p.plant_id=h.plant_id AND e.enq_gen_id=h.enq_gen_id AND  h.cust_id=:custId "
			+ " AND h.enq_date BETWEEN :fromDate AND :toDate  AND h.enq_status=0 AND h.ex_int1=1 ORDER BY h.enq_head_id DESC ", nativeQuery = true)
	List<GetEnqHeader> getEnqHeaderByCust(@Param("custId") int custId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	@Query(value = " SELECT h.*,c.cust_name,c.cust_mob_no,p.plant_name,e.enq_gen_by,1 quot_no,null quot_date FROM  t_enq_header h ,m_customer c,m_plant p,enq_gen_fact e "
			+ " WHERE c.cust_id=h.cust_id AND p.plant_id=h.plant_id AND e.enq_gen_id=h.enq_gen_id AND  h.cust_id=:custId AND  h.plant_id=:plantId "
			+ " AND h.enq_date BETWEEN :fromDate AND :toDate  AND h.enq_status=0 AND h.ex_int1=1 ORDER BY h.enq_head_id DESC ", nativeQuery = true)
	List<GetEnqHeader> getEnqHeaderByCustAndPlant(@Param("plantId") int plantId,@Param("custId") int custId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	@Query(value = " SELECT h.*,c.cust_name,c.cust_mob_no,p.plant_name,e.enq_gen_by,1 quot_no,null quot_date FROM  t_enq_header h ,m_customer c,m_plant p,enq_gen_fact e "
			+ " WHERE c.cust_id=h.cust_id AND p.plant_id=h.plant_id AND e.enq_gen_id=h.enq_gen_id "
			+ " AND h.enq_date BETWEEN :fromDate AND :toDate  AND h.enq_status=0 AND h.ex_int1=1 ORDER BY h.enq_head_id DESC ", nativeQuery = true)
	List<GetEnqHeader> getEnqHeaderByDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
}
