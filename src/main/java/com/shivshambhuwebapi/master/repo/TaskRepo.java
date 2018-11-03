package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer>
{

	List<Task> findByDelStatusOrderByTaskIdDesc(int i);

}
