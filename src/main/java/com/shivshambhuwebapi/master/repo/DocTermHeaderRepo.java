package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.DocTermHeader;

public interface DocTermHeaderRepo extends JpaRepository<DocTermHeader, Integer> {

	DocTermHeader findByTermIdAndDelStatus(int termId, int i);

	List<DocTermHeader> findByDocIdAndDelStatus(int docId, int i);

}
