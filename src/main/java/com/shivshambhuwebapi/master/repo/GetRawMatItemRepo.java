package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shivshambhuwebapi.master.model.GetRawMatItem;

public interface GetRawMatItemRepo extends JpaRepository<GetRawMatItem, Integer> {

	@Query(value = "select m.*, c.cat_desc, g.grp_code, sg.subgrp_desc from m_item m, m_category c, m_item_group g, m_item_subgroup sg "
			+ " where  c.cat_id = m.cat_id and g.grp_id = m.grp_id and sg.subgrp_id = m.sub_grp_id and m.is_used = 1 order by m.item_code asc", nativeQuery = true)
	List<GetRawMatItem> getAllItems();

}
