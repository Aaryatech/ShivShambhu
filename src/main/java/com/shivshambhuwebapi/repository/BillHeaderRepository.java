package com.shivshambhuwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shivshambhuwebapi.model.bill.BillHeader;
@Repository
public interface BillHeaderRepository extends JpaRepository<BillHeader, Integer>{

	BillHeader findByBillHeadIdAndDelStatus(int billHeadId, int i);

}
