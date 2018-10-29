package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.tx.model.EnqDetail;

public interface EnqDetailRepo extends JpaRepository<EnqDetail, Integer> {

	List<EnqDetail> findByEnqHeadId(int enqHeadId);

}
