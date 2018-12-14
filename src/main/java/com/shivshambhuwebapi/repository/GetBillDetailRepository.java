package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shivshambhuwebapi.model.bill.GetBillDetail;

@Repository
public interface GetBillDetailRepository extends JpaRepository<GetBillDetail, Integer>{

	@Query(value="select d.*,i.item_name,u.uom_name from t_bill_detail d,m_item_fg i,m_uom u where u.uom_id=i.uom_id and d.del_status=1 and d.item_id=i.item_id and d.bill_head_id=:billHeadId",nativeQuery=true)
	List<GetBillDetail> getBillDetailsById(@Param("billHeadId")int billHeadId);

	@Query(value=" select distinct(chalan_id) from t_chalan_detail where chalan_detail_id in(:chalanDetailId)",nativeQuery=true)
	List<Integer> getDistinctChalanIds(@Param("chalanDetailId")List<Integer> chalanDetailId);

	@Query(value="select count(*) from t_chalan_detail where status<2 and chalan_id=:chalanId",nativeQuery=true)
	int getStatusCnt(@Param("chalanId")Integer integer);

}
