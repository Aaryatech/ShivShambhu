package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.DocTermDetail;

public interface DocTermDetailRepo extends JpaRepository<DocTermDetail, Integer> {

	List<DocTermDetail> findByTermIdAndDelStatus(int termId, int i);

	List<DocTermDetail> findByTermId(int termId);
	
	//sachin 27-12-2018
	@Query(value = ""
			+ "SELECT doc_term_detail.* FROM doc_term_header,doc_term_detail,t_quot_header\n" + 
			"WHERE t_quot_header.quot_head_id=:quotIdList AND t_quot_header.quot_term_id=doc_term_header.term_id\n" + 
			"AND doc_term_detail.del_status=1\n" + 
			"AND doc_term_header.doc_id=2 AND doc_term_detail.term_id=doc_term_header.term_id ", nativeQuery = true)

List<DocTermDetail> getDocTermDetailForQuotPrint(@Param("quotIdList") int quotIdList);

}
