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
	@Query("UPDATE PoklenReading SET del_status=0  WHERE pokId=:pokId")
	int deletePoklenReading(@Param("pokId") int pokId);

	@Transactional
	@Modifying
	@Query("UPDATE PoklenReading SET delStatus=0  WHERE pokId IN(:pokIds)")
	int deleteMultiPoklenReading(@Param("pokIds") List<Integer> pokIds);

	PoklenReading findByPokIdAndDelStatus(int pokId, int i);

	List<PoklenReading> findByDelStatusOrderByPokIdDesc(int i);

}
