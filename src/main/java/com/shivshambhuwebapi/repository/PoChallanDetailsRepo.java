package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.PoChallanDetails;

public interface PoChallanDetailsRepo extends JpaRepository<PoChallanDetails, Integer> {

	@Query(value="SELECT\n" + 
			"	UUID() AS id,\n" + 
			"    t_chalan_header.chalan_no,\n" + 
			"    t_chalan_header.chalan_date,\n" + 
			"    t_chalan_detail.item_qty\n" + 
			"FROM\n" + 
			"   	 t_chalan_header,\n" + 
			"     t_chalan_detail\n" + 
			"WHERE\n" + 
			"	t_chalan_detail.order_detail_id=:challanId AND\n" + 
			"    t_chalan_detail.chalan_id=t_chalan_header.chalan_id",nativeQuery=true)
	public List<PoChallanDetails> getChallanDetails(@Param("challanId") int challanId);
}
