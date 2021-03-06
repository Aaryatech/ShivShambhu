package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.GetPoHeader;

public interface GetPoHeaderRepository extends JpaRepository<GetPoHeader, Integer> {

	@Query(value = "select ph.*,c.cust_name,pl.plant_name,pt.pay_term,pr.proj_name from t_cust_po_header ph,m_customer c,m_plant pl,m_payment_term pt,m_project pr\r\n"
			+ "where ph.del_status=1 and c.cust_id=ph.cust_id and pl.plant_id=ph.plant_id and pt.pay_term_id=ph.po_term_id and pr.proj_id=ph.cust_project_id and ph.po_id=:poId", nativeQuery = true)
	GetPoHeader getPoHeader(@Param("poId") int poId);

	@Query(value = "select ph.*,c.cust_name,pl.plant_name,pt.pay_term,pr.proj_name from t_cust_po_header ph,m_customer c,m_plant pl,"
			+ "m_payment_term pt,m_project pr where ph.del_status=1 and c.cust_id=ph.cust_id and pl.plant_id=ph.plant_id and "
			+ "pt.pay_term_id=ph.po_term_id and pr.proj_id=ph.cust_project_id and ph.po_date between :fromDate and :toDate", nativeQuery = true)
	List<GetPoHeader> getPoListByDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "select ph.*,c.cust_name,pl.plant_name,pt.pay_term,pr.proj_name from t_cust_po_header ph,m_customer c,m_plant pl,"
			+ "m_payment_term pt,m_project pr where ph.del_status=1 and c.cust_id=ph.cust_id and pl.plant_id=ph.plant_id and "
			+ "pt.pay_term_id=ph.po_term_id and pr.proj_id=ph.cust_project_id and ph.po_date between :fromDate and :toDate AND ph.status IN (:statusList) ORDER BY ph.po_id DESC", nativeQuery = true)
	List<GetPoHeader> getPoListByDateAndStatusList(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("statusList") List<Integer> statusList);

	@Query(value = "select ph.*,c.cust_name,pl.plant_name,pt.pay_term,pr.proj_name from t_cust_po_header ph,m_customer c,m_plant pl, m_payment_term pt,m_project pr where ph.del_status=1 and c.cust_id=ph.cust_id and pl.plant_id=ph.plant_id and pt.pay_term_id=ph.po_term_id and pr.proj_id=ph.cust_project_id and ph.po_date between :fromDate and :toDate AND ph.cust_id=:custId AND ph.status IN (:statusList) ORDER BY ph.po_id DESC", nativeQuery = true)
	List<GetPoHeader> getPoListByDateAndCustId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("custId") int custId, @Param("statusList") List<Integer> statusList);

	@Query(value = "select ph.*,c.cust_name,pl.plant_name,pt.pay_term,pr.proj_name from t_cust_po_header ph,m_customer c,m_plant pl, m_payment_term pt,m_project pr where ph.del_status=1 and c.cust_id=ph.cust_id and pl.plant_id=ph.plant_id and pt.pay_term_id=ph.po_term_id and pr.proj_id=ph.cust_project_id and ph.po_date between :fromDate and :toDate AND ph.plant_id=:plantId AND ph.status IN (:statusList) ORDER BY ph.po_id DESC", nativeQuery = true)
	List<GetPoHeader> getPoListByDateAndPlantId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("plantId") int plantId, @Param("statusList") List<Integer> statusList);

	@Query(value = "select ph.*,c.cust_name,pl.plant_name,pt.pay_term,pr.proj_name from t_cust_po_header ph,m_customer c,m_plant pl, m_payment_term pt,m_project pr where ph.del_status=1 and c.cust_id=ph.cust_id and pl.plant_id=ph.plant_id and pt.pay_term_id=ph.po_term_id and pr.proj_id=ph.cust_project_id and ph.po_date between :fromDate and :toDate AND ph.plant_id=:plantId AND ph.cust_id=:custId AND ph.status IN (:statusList) ORDER BY ph.po_id DESC", nativeQuery = true)
	List<GetPoHeader> getPoListByDateAndPlantAndCust(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("custId") int custId, @Param("plantId") int plantId, @Param("statusList") List<Integer> statusList);

}
