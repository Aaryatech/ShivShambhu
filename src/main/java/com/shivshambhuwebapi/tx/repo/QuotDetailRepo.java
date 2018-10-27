package com.shivshambhuwebapi.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.tx.model.QuotDetail;

public interface QuotDetailRepo extends JpaRepository<QuotDetail, Integer> {

}
