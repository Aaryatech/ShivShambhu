package com.shivshambhuwebapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivshambhuwebapi.controller.Info;
import com.shivshambhuwebapi.master.model.Dept;
import com.shivshambhuwebapi.master.model.ErrorMessage;
import com.shivshambhuwebapi.master.model.GetUserType;
import com.shivshambhuwebapi.master.model.LoginResponse;
import com.shivshambhuwebapi.master.model.User;
import com.shivshambhuwebapi.master.repo.DeptRepo;
import com.shivshambhuwebapi.master.repo.GetUserTypeRepository;
import com.shivshambhuwebapi.master.repo.UserRepo;
import com.shivshambhuwebapi.util.JsonUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepository;

	@Autowired
	DeptRepo departmentRepository;

	@Autowired
	GetUserTypeRepository getUserTypeRepository;

	String jsonUser = "{}";
	User user = null;
	ErrorMessage errorMessage;

	@Override
	public LoginResponse findUserByUsername(String username, String password) {

		String dbUsername = null;
		String dbPassword = null;
		LoginResponse loginResponse = null;
		try {
			user = userRepository.findByUsrNameAndDelStatus(username, 1);
			dbUsername = user.getUsrName();
			dbPassword = user.getUserPass();
		} catch (Exception e) {
			loginResponse = new LoginResponse();
			errorMessage = new ErrorMessage();
			errorMessage.setError(true);
			errorMessage.setMessage("User is not registered");

			loginResponse.setErrorMessage(errorMessage);
			loginResponse.setUser(user);

		}
		try {
			if (user == null || username == null || username.equalsIgnoreCase("")) {

				loginResponse = new LoginResponse();

				errorMessage = new ErrorMessage();
				errorMessage.setError(true);
				errorMessage.setMessage("User is not registered");

				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);

			} else if (password == null || password.equalsIgnoreCase("")) {

				loginResponse = new LoginResponse();
				errorMessage = new ErrorMessage();

				errorMessage.setError(true);
				errorMessage.setMessage("Please enter Password");
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);

			} else if (dbUsername.equals(username) && dbPassword.equals(password)) {

				loginResponse = new LoginResponse();
				errorMessage = new ErrorMessage();

				errorMessage.setError(false);
				errorMessage.setMessage("User Logged in Successfully");
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);

			} else if (dbUsername.equals(username) && dbPassword != password) {

				loginResponse = new LoginResponse();
				errorMessage = new ErrorMessage();

				errorMessage.setError(true);
				errorMessage.setMessage("Invalid Password");
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(user);

			}
		} catch (Exception e) {

			loginResponse = new LoginResponse();
			errorMessage = new ErrorMessage();

			errorMessage.setError(true);
			errorMessage.setMessage("User is not registered");
			loginResponse.setErrorMessage(errorMessage);
			loginResponse.setUser(user);

		}
		return loginResponse;

	}

	@Override
	public String save(User user) {
		try {
			User tempUser = null;
			try {
				if (user != null || user.getUsrName() == "" || user.getUserPass() == "") {
					tempUser = userRepository.findByUsrName(user.getUsrName());
				} else {
					errorMessage.setError(false);
					errorMessage.setMessage("UserForm fields are empty");
				}

			} catch (Exception e) {

				errorMessage.setError(true);
				errorMessage.setMessage("Exception occured while inserting NewUser");
				jsonUser = JsonUtil.javaToJson(errorMessage);

			}

			if (tempUser == null) {
				user = userRepository.save(user);
				errorMessage.setError(false);
				errorMessage.setMessage("Record Inserted Successfully");

				jsonUser = JsonUtil.javaToJson(errorMessage);
			} else {

				errorMessage.setError(true);
				errorMessage.setMessage("User with this username is already registered");

				jsonUser = JsonUtil.javaToJson(errorMessage);
			}
		} catch (Exception e) {
			errorMessage.setError(true);
			errorMessage.setMessage("Exception occured while inserting NewUser");
			jsonUser = JsonUtil.javaToJson(errorMessage);

		}
		return jsonUser;
	}

	@Override
	public Info insertUser(User user) {

		Info info = new Info();
		user = userRepository.save(user);
		if (user != null) {
			info.setError(false);
			info.setMessage("success");
		}
		{
			info.setError(true);
			info.setMessage("failed");
		}
		return info;
	}

	@Override
	public List<Dept> getAllDept() {

		return departmentRepository.findAll();
	}

	@Override
	public List<GetUserType> getAllUserType() {

		return getUserTypeRepository.getType();
	}

}
