package com.shivshambhuwebapi.tx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.tx.model.PoklenReading;

public interface PoklenReadingRepo extends JpaRepository<PoklenReading, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE PoklenReading SET del_status=0  WHERE readingId=:readingId")
	int deletePoklenReading(@Param("readingId") int readingId);

	@Transactional
	@Modifying
	@Query("UPDATE PoklenReading SET delStatus=0  WHERE readingId IN(:readingIds)")
	int deleteMultiPoklenReading(@Param("readingIds") List<Integer> readingIds);

	PoklenReading findByReadingIdAndDelStatus(int pokId, int i);

	List<PoklenReading> findByDelStatusOrderByReadingIdDesc(int i);

}
