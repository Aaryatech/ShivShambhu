package com.shivshambhuwebapi.tx.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.tx.model.QuotHeader;

public interface QuotHeaderRepo extends JpaRepository<QuotHeader, Integer> {

}
