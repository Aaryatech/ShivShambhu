package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shivshambhuwebapi.master.model.GetUser;

public interface GetUserRepo extends JpaRepository<GetUser, Integer> {

	@Query(value = "SELECT u.* ,c.comp_name FROM m_user u ,m_company c WHERE"
			+ " u.del_status=1  AND c.company_id=u.company_id  ORDER BY u.user_id DESC", nativeQuery = true)
	List<GetUser> getUserList();

}
