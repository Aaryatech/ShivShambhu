package com.shivshambhuwebapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivshambhuwebapi.accessright.AccessRightModule;
import com.shivshambhuwebapi.accessright.AssignRoleDetailList;
import com.shivshambhuwebapi.controller.Info;
import com.shivshambhuwebapi.master.model.User;

@Service
public interface AccessRightService {

	List<AccessRightModule> getAllModulAndSubModule();

	Info saveAssignRole(AssignRoleDetailList assignRoleDetailList);

	List<AssignRoleDetailList> getAllAccessRole();

	Info updateRoleIdByEmpId(int id, int roleId);

	List<User> getAllUser();

	String getRoleJson(int userId);

}
