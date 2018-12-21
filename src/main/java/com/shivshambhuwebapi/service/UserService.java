package com.shivshambhuwebapi.service;

import java.util.List;


import com.shivshambhuwebapi.controller.Info;
import com.shivshambhuwebapi.master.model.Dept;
import com.shivshambhuwebapi.master.model.GetUserType;
import com.shivshambhuwebapi.master.model.LoginResponse;
import com.shivshambhuwebapi.master.model.User;

public interface UserService {

	public LoginResponse findUserByUsername(String username, String password);

	public String save(User user);

	public Info insertUser(User user);

	public List<Dept> getAllDept();

	public List<GetUserType> getAllUserType();
}
