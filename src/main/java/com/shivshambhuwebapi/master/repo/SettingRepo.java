package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivshambhuwebapi.master.model.Setting;

public interface SettingRepo extends JpaRepository<Setting, Integer> {

	List<Setting> findBySettingKeyIn(List<Integer> keyList);
	
	
	//List<Setting> findBySettingKeyIN(List<Integer> keyList);
	
	//List<Setting> findBySettingKeyIN(String keyList);
}
