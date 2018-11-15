package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shivshambhuwebapi.master.model.GetUser;

public interface GetUserRepo extends JpaRepository<GetUser, Integer> {

	@Query(value = "SELECT u.* ,c.comp_name,d.dept_name ,p.plant_name   FROM m_user u,m_dept d,m_company c ,m_plant p WHERE"
			+ " u.del_status=1  AND c.company_id=u.company_id  AND p.plant_id=u.plant_id AND d.dept_id=u.dept_id ORDER BY u.user_id DESC", nativeQuery = true)
	List<GetUser> getUserList();

}
