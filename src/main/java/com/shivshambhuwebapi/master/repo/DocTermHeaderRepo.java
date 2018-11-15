package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.DocTermHeader;

public interface DocTermHeaderRepo extends JpaRepository<DocTermHeader, Integer> {

	DocTermHeader findByTermIdAndDelStatus(int termId, int i);

	List<DocTermHeader> findByDocIdAndDelStatus(int docId, int i);

	List<DocTermHeader> findByDelStatus(int i);

	@Transactional
	@Modifying
	@Query("UPDATE DocTermHeader SET delStatus=0  WHERE term_id=:termId")
	int deleteDocHeader(@Param("termId") int termId);

}
