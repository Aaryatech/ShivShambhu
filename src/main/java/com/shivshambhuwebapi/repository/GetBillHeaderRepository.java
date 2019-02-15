package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shivshambhuwebapi.model.bill.GetBillHeader;

@Repository
public interface GetBillHeaderRepository extends JpaRepository<GetBillHeader, Integer> {

	@Query(value = "select t.*,m.comp_name,c.cust_name,p.plant_name from t_bill_header t,m_company m,m_customer c,m_plant p where p.plant_id=t.ex_int1 and c.cust_id=t.cust_id and t.ex_int1=:plantId and t.cust_id=:custId and m.company_id=t.company_id and t.del_status=1 and t.bill_date >=:fromDate and t.bill_date<=:toDate", nativeQuery = true)
	List<GetBillHeader> getBillHeadersByDate(@Param("plantId") int plantId, @Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "select t.*,m.comp_name,c.cust_name,p.plant_name  from t_bill_header t,m_company m,m_customer c,m_plant p where p.plant_id=t.ex_int1 and c.cust_id=t.cust_id  and m.company_id=t.company_id and t.del_status=1 and t.bill_head_id=:billHeadId", nativeQuery = true)
	GetBillHeader getBillHeaderById(@Param("billHeadId") int billHeadId);

	@Query(value = "select t.*,m.comp_name,c.cust_name,p.plant_name from t_bill_header t,m_company m,m_customer c,m_plant p where p.plant_id=t.ex_int1 and c.cust_id=t.cust_id and t.ex_int1=:plantId and t.cust_id=:custId and m.company_id=t.company_id and t.del_status=1 and t.bill_date >=:fromDate and t.bill_date<=:toDate ORDER BY t.bill_head_id DESC", nativeQuery = true)
	List<GetBillHeader> getBillHeadersByDateByCustByPlant(@Param("plantId") int plantId, @Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "select t.*,m.comp_name,c.cust_name,p.plant_name from t_bill_header t,m_company m,m_customer c,m_plant p where p.plant_id=t.ex_int1 and c.cust_id=t.cust_id and m.company_id=t.company_id and t.del_status=1 and t.bill_date >=:fromDate and t.bill_date<=:toDate ORDER BY t.bill_head_id DESC", nativeQuery = true)
	List<GetBillHeader> getBillHeadersByDateByAll(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "select t.*,m.comp_name,c.cust_name,p.plant_name from t_bill_header t,m_company m,m_customer c,m_plant p where p.plant_id=t.ex_int1 and c.cust_id=t.cust_id and t.cust_id=:custId and m.company_id=t.company_id and t.del_status=1 and t.bill_date >=:fromDate and t.bill_date<=:toDate ORDER BY t.bill_head_id DESC", nativeQuery = true)
	List<GetBillHeader> getBillHeadersByDateByCust(@Param("custId") int custId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "select t.*,m.comp_name,c.cust_name,p.plant_name from t_bill_header t,m_company m,m_customer c,m_plant p where p.plant_id=t.ex_int1 and c.cust_id=t.cust_id and t.ex_int1=:plantId and m.company_id=t.company_id and t.del_status=1 and t.bill_date >=:fromDate and t.bill_date<=:toDate ORDER BY t.bill_head_id DESC", nativeQuery = true)
	List<GetBillHeader> getBillHeadersByDateByPlant(@Param("plantId") int plantId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	// -----------

	@Query(value = "select t.*,m.comp_name,c.cust_name,p.plant_name from t_bill_header t,m_company m,m_customer c,m_plant p where p.plant_id=t.ex_int1 and c.cust_id=t.cust_id and m.company_id=t.company_id and t.del_status=1 and t.bill_date >=:fromDate and t.bill_date<=:toDate AND t.ex_int2=:tax ORDER BY t.bill_head_id DESC", nativeQuery = true)
	List<GetBillHeader> getBillHeadersByDateAndTax(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("tax") int tax);

	@Query(value = "select t.*,m.comp_name,c.cust_name,p.plant_name from t_bill_header t,m_company m,m_customer c,m_plant p where p.plant_id=t.ex_int1 and c.cust_id=t.cust_id and t.cust_id=:custId and m.company_id=t.company_id and t.del_status=1 and t.bill_date >=:fromDate and t.bill_date<=:toDate AND t.ex_int2=:tax ORDER BY t.bill_head_id DESC", nativeQuery = true)
	List<GetBillHeader> getBillHeadersByDateByCustAndTax(@Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("tax") int tax);

	@Query(value = "select t.*,m.comp_name,c.cust_name,p.plant_name from t_bill_header t,m_company m,m_customer c,m_plant p where p.plant_id=t.ex_int1 and c.cust_id=t.cust_id and t.ex_int1=:plantId and m.company_id=t.company_id and t.del_status=1 and t.bill_date >=:fromDate and t.bill_date<=:toDate AND t.ex_int2=:tax ORDER BY t.bill_head_id DESC", nativeQuery = true)
	List<GetBillHeader> getBillHeadersByDateByPlantAndTax(@Param("plantId") int plantId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("tax") int tax);

	@Query(value = "select t.*,m.comp_name,c.cust_name,p.plant_name from t_bill_header t,m_company m,m_customer c,m_plant p where p.plant_id=t.ex_int1 and c.cust_id=t.cust_id and t.ex_int1=:plantId and t.cust_id=:custId and m.company_id=t.company_id and t.del_status=1 and t.bill_date >=:fromDate and t.bill_date<=:toDate AND t.ex_int2=:tax ORDER BY t.bill_head_id DESC", nativeQuery = true)
	List<GetBillHeader> getBillHeadersByDateByCustByPlantAndTax(@Param("plantId") int plantId,
			@Param("custId") int custId, @Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("tax") int tax);

}
