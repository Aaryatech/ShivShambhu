package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shivshambhuwebapi.master.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE User SET del_status=0  WHERE user_id=:userId")
	int deleteUser(@Param("userId") int userId);

	User findByUserIdAndDelStatus(int userId, int i);

	List<User> findByDelStatusOrderByUserIdDesc(int i);
}
