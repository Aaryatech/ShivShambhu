package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shivshambhuwebapi.master.model.GetDocTermHeader;

public interface GetDocTermHeaderRepo extends JpaRepository<GetDocTermHeader, Integer> {

	@Query(value = "SELECT h.*,d.doc_name FROM doc_term_header h,m_document d WHERE h.del_status=1 AND d.doc_id=h.doc_id  ORDER BY h.term_id DESC", nativeQuery = true)
	List<GetDocTermHeader> getDocHeaderList();

}
