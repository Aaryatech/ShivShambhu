package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shivshambhuwebapi.model.bill.GetBillDetail;

@Repository
public interface GetBillDetailRepository extends JpaRepository<GetBillDetail, Integer> {

	/*
	 * @Query(
	 * value="select d.*,i.item_name,u.uom_name,t_bill_header.company_id,t_bill_header.ex_var1 as ref_no,c.comp_name,"
	 * + "comp_office_add,c.contact_no1,c.email1 ,p.plant_name,o.order_no from " +
	 * "t_bill_detail d,m_item_fg i,m_uom u ,t_bill_header,m_company c,m_plant p,t_order_header o where"
	 * +
	 * " u.uom_id=i.uom_id and d.del_status=1 and d.item_id=i.item_id and d.bill_head_id=:billHeadId and "
	 * +
	 * "t_bill_header.company_id=c.company_id and t_bill_header.ex_int1=p.plant_id and "
	 * + "t_bill_header.order_id=o.order_id",nativeQuery=true) List<GetBillDetail>
	 * getBillDetailsById(@Param("billHeadId")int billHeadId);
	 */

	@Query(value = "select d.*,i.item_name,i.short_name,u.uom_name,t_bill_header.company_id,t_bill_header.ex_var1 as ref_no,c.comp_name,\n"
			+ "comp_office_add,c.contact_no1,c.email1 ,p.plant_name,coalesce((select o.order_no from t_order_header o where t_bill_header.order_id=o.order_id),0) as order_no from t_bill_detail d,m_item_fg i,m_uom u ,t_bill_header,m_company c,m_plant p where\n"
			+ "u.uom_id=i.uom_id and d.del_status=1 and d.item_id=i.item_id and t_bill_header.bill_head_id=d.bill_head_id And t_bill_header.bill_head_id=:billHeadId and\n"
			+ "d.qty>0 and t_bill_header.company_id=c.company_id and t_bill_header.ex_int1=p.plant_id", nativeQuery = true)
	List<GetBillDetail> getBillDetailsById(@Param("billHeadId") int billHeadId);

	@Query(value = " select distinct(chalan_id) from t_chalan_detail where chalan_detail_id in(:chalanDetailId)", nativeQuery = true)
	List<Integer> getDistinctChalanIds(@Param("chalanDetailId") List<Integer> chalanDetailId);

	@Query(value = "select count(*) from t_chalan_detail where status<2 and chalan_id=:chalanId", nativeQuery = true)
	int getStatusCnt(@Param("chalanId") Integer integer);

}
