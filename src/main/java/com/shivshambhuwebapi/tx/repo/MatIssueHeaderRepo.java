package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.tx.model.MatIssueHeader;

public interface MatIssueHeaderRepo extends JpaRepository<MatIssueHeader, Integer>{

	List<MatIssueHeader> findByDelStatus(int i);

}
