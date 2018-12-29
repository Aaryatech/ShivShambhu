package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shivshambhuwebapi.master.model.GetOtherExpenses;

public interface GetOtherExpRepo extends JpaRepository<GetOtherExpenses, Integer> {

	@Query(value = "SELECT o.*,p.plant_name,u.usr_name AS user_name FROM other_expenses o ,m_plant p ,m_user u WHERE o.del_status=1 AND p.plant_id=o.plant_id AND u.user_id=o.user_id ORDER BY o.other_exp_id DESC", nativeQuery = true)
	List<GetOtherExpenses> getAllOterExpList();

}
