package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.GetPoReport;

public interface GetPoReportRepo extends JpaRepository<GetPoReport, Integer> {

/*	@Query(value = "", nativeQuery = true)
	List<GetPoReport> getPoBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "", nativeQuery = true)
	List<GetPoReport> getPoBetweenDateAndPlantId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("plantId") int plantId);

	@Query(value = "", nativeQuery = true)
	List<GetPoReport> getPoReport();

	@Query(value = "", nativeQuery = true)
	List<GetPoReport> getPoByPlantId(@Param("plantId") int plantId);*/

}
