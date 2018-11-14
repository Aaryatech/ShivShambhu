package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.DocTermDetail;

public interface DocTermDetailRepo extends JpaRepository<DocTermDetail, Integer> {

	List<DocTermDetail> findByTermIdAndDelStatus(int termId, int i);

	List<DocTermDetail> findByTermId(int termId);

}
