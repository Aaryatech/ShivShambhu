package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.tx.model.MatIssueDetail;

public interface MatIssueDetailRepo extends JpaRepository<MatIssueDetail, Integer> {

	List<MatIssueDetail> findByMatHeaderIdAndDelStatus(int matHeaderId, int i);

}
