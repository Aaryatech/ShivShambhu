package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.tx.model.GetQuotHeader;

public interface GetQuotHeaderRepo extends JpaRepository<GetQuotHeader, Integer> {

	@Query(value = " SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,p.proj_name,t.pay_term,pn.plant_name FROM t_quot_header h,"
			+ "m_customer c ,m_user u,m_company o ,m_project p ,m_payment_term t ,m_plant pn WHERE h.del_status=1 AND"
			+ " h.cust_id=c.cust_id AND u.user_id=h.user_id AND h.company_id=o.company_id AND p.proj_id=h.proj_id AND "
			+ "t.pay_term_id=h.pay_term_id AND h.quot_head_id=:quotHeadId AND pn.plant_id=h.plant_ids", nativeQuery = true)
	GetQuotHeader getQuotHeaderByQuotHeadId(@Param("quotHeadId") int quotHeadId);

	@Query(value = "SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,p.proj_name,t.pay_term FROM t_quot_header h,m_customer c ,"
			+ "m_user u,m_company o ,m_project p ,m_payment_term t WHERE h.del_status=1 AND h.cust_id=c.cust_id AND "
			+ "u.user_id=h.user_id AND h.company_id=o.company_id AND p.proj_id=h.proj_id AND t.pay_term_id=h.pay_term_id "
			+ " ORDER BY h.quot_head_id DESC ", nativeQuery = true)

	List<GetQuotHeader> getQuotHeaderList();

	// 1
	@Query(value = " SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ " p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,m_user u,"
			+ "m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id AND "
			+ "h.company_id=o.company_id AND h.plant_ids=:plantId AND h.quot_date BETWEEN :fromDate AND :toDate "
			+ "AND pn.plant_id=h.plant_ids" + "	ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByPlantId(@Param("plantId") int plantId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = "SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ " p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,"
			+ "m_user u,m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id"
			+ " AND h.company_id=o.company_id AND h.plant_ids=:plantId AND h.quot_date BETWEEN :fromDate AND :toDate"
			+ " AND pn.plant_id=h.plant_ids AND h.cust_id=:custId "
			+ " ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByPlantIdAndCustId(@Param("plantId") int plantId, @Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	// 2
	@Query(value = "SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ " p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,"
			+ "m_user u,m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id"
			+ " AND h.company_id=o.company_id AND h.plant_ids=:plantId AND h.quot_date BETWEEN :fromDate AND :toDate"
			+ " AND pn.plant_id=h.plant_ids AND h.status=:status "
			+ " ORDER BY h.quot_head_id DESC ", nativeQuery = true)

	List<GetQuotHeader> getQuotHeaderByPlantIdAndCustId(@Param("plantId") int plantId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") int status);

	// 4
	@Query(value = "SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ " p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,"
			+ "m_user u,m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id"
			+ " AND h.company_id=o.company_id AND h.plant_ids=:plantId AND h.quot_date BETWEEN :fromDate AND :toDate"
			+ " AND pn.plant_id=h.plant_ids AND h.status=:status " + " AND h.cust_id=:custId "
			+ " ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByPlantId(@Param("plantId") int plantId, @Param("custId") int custId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("status") int status);

	// 3

	// Android-26-12-2018 -> 1
	@Query(value = " SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ "p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM "
			+ "t_quot_header h,m_customer c ,m_user u,m_company o  ,m_plant pn WHERE h.status IN (:statusList) "
			+ "AND h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id AND h.company_id=o.company_id "
			+ "AND h.plant_ids=:plantId AND pn.plant_id=h.plant_ids ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByPlantIdAndStatusAndAllCust(@Param("plantId") int plantId,
			@Param("statusList") List<String> statusList);

	// Android-26-12-2018 -> 2
	@Query(value = " SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ "p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM "
			+ "t_quot_header h,m_customer c ,m_user u,m_company o  ,m_plant pn WHERE h.status IN (:statusList) "
			+ "AND h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id AND h.company_id=o.company_id "
			+ "AND h.plant_ids=:plantId AND pn.plant_id=h.plant_ids AND h.cust_id=:custId ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByPlantIdAndStatusAndCust(@Param("plantId") int plantId,
			@Param("statusList") List<String> statusList, @Param("custId") int custId);

	// neha

	@Query(value = " SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ " p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,m_user u,"
			+ "m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id AND "
			+ "h.company_id=o.company_id AND h.plant_ids=:plantId AND h.quot_date BETWEEN :fromDate AND :toDate "
			+ "AND pn.plant_id=h.plant_ids AND h.status IN (:statusList)"
			+ "	ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByPlantIdAndStatus(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("plantId") int plantId,
			@Param("statusList") List<Integer> statusList);

	@Query(value = " SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ " p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,m_user u,"
			+ "m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id AND "
			+ "h.company_id=o.company_id AND h.cust_id=:custId AND h.quot_date BETWEEN :fromDate AND :toDate "
			+ "AND pn.plant_id=h.plant_ids AND h.status IN (:statusList)"
			+ "	ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByCustIdAndStatus(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("custId") int custId, @Param("statusList") List<Integer> statusList);

	@Query(value = " SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ " p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,m_user u,"
			+ "m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id AND "
			+ "h.company_id=o.company_id AND h.quot_date BETWEEN :fromDate AND :toDate "
			+ "AND pn.plant_id=h.plant_ids " + "	ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByStatus(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ " p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,m_user u,"
			+ "m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id AND "
			+ "h.company_id=o.company_id AND h.cust_id=:custId AND h.plant_ids=:plantId AND h.quot_date BETWEEN :fromDate AND :toDate "
			+ "AND pn.plant_id=h.plant_ids AND h.status IN (:statusList)"
			+ "	ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByCustIdAndCustIdStatus(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("custId") int custId, @Param("plantId") int plantId,

			@Param("statusList") List<Integer> statusList);

	@Query(value = " SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ " p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,m_user u,"
			+ "m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id AND "
			+ "h.company_id=o.company_id AND h.status=0 AND h.quot_date BETWEEN :fromDate AND :toDate "
			+ "AND pn.plant_id=h.plant_ids" + "	ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeader(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ " p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,m_user u,"
			+ "m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id AND "
			+ "h.company_id=o.company_id AND h.status=0 AND h.plant_ids=:plantId AND h.quot_date BETWEEN :fromDate AND :toDate "
			+ "AND pn.plant_id=h.plant_ids" + "	ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByPlantIdAndStatus0(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("plantId") int plantId);

	@Query(value = "SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE "
			+ "p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,"
			+ "m_user u,m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id "
			+ "AND h.company_id=o.company_id AND h.status=1 AND h.plant_ids=51 AND h.quot_date BETWEEN :fromDate AND "
			+ ":toDate AND pn.plant_id=h.plant_ids ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByStatus1(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " SELECT h.*, c.cust_name ,u.usr_name,o.comp_name,COALESCE((SELECT p.proj_name FROM m_project p WHERE"
			+ " p.proj_id=h.proj_id ),'NULL') as proj_name,COALESCE((SELECT t.pay_term FROM  m_payment_term t WHERE "
			+ "t.pay_term_id=h.pay_term_id ),'NULL') as pay_term,pn.plant_name FROM t_quot_header h,m_customer c ,"
			+ "m_user u,m_company o  ,m_plant pn WHERE h.del_status=1 AND h.cust_id=c.cust_id AND u.user_id=h.user_id"
			+ " AND h.company_id=o.company_id AND h.status=1 AND h.plant_ids=:plantId AND h.quot_date BETWEEN :fromDate "
			+ "AND :toDate AND pn.plant_id=h.plant_ids ORDER BY h.quot_head_id DESC ", nativeQuery = true)
	List<GetQuotHeader> getQuotHeaderByPlantIdByStatus1(@Param("plantId") int plantId,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
