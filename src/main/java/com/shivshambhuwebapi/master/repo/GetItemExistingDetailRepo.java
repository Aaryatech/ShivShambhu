package com.shivshambhuwebapi.master.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetExistingItemDetail;



public interface GetItemExistingDetailRepo extends JpaRepository<GetExistingItemDetail , Integer>  {

	
	
	
	@Query(value = "SELECT d.rm_name,d. ,n.contr_mob  FROM t_mat_issue_contra_header c,m_contractor n WHERE c.del_status=1 AND c.contr_id=n.contr_id AND c.mat_header_id=:matHeaderId ORDER BY c.mat_header_id DESC", nativeQuery = true)

	List<GetExistingItemDetail> getItemDetailByItemId(@Param("itemId") int itemId);
	
	

}
