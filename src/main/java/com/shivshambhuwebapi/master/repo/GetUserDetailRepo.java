package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shivshambhuwebapi.master.model.GetUserDetail;

public interface GetUserDetailRepo extends JpaRepository<GetUserDetail, Integer> {

	// usertype as ex_int1

	@Query(value = "SELECT u.*,d.dept_name,r.role_name, etype.type_name FROM m_user u,m_cm_dept d,m_assign_role r,m_emp_type etype "
			+ "WHERE u.role_id=r.role_id AND u.dept_id=d.dept_id AND u.del_status=1 AND u.ex_int1=etype.type_id  ", nativeQuery = true)
	List<GetUserDetail> getUserDetail();

}
