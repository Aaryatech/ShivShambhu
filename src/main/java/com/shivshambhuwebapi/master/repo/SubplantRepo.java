package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.Subplant;

public interface SubplantRepo extends JpaRepository<Subplant, Integer> {

	List<Subplant> findByDelStatusOrderBySubplantIdDesc(int i);

}
