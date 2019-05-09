package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shivshambhuwebapi.master.model.GetUser;

public interface GetUserRepo extends JpaRepository<GetUser, Integer> {

	@Query(value = "SELECT u.* ,c.comp_name ,d.dept_name FROM m_user u ,m_company c ,m_dept_shiv d WHERE  u.del_status=1  "
			+ "AND c.company_id=u.company_id AND u.dept_id=d.dept_id ORDER BY u.user_id DESC", nativeQuery = true)
	List<GetUser> getUserList();

}
