package com.shivshambhuwebapi.master.repo;

import java.util.List;

import com.shivshambhuwebapi.controller.Info;
import com.shivshambhuwebapi.master.model.GetUserDetail;

public class GetUserDetailList {

	List<GetUserDetail> userDetail;

	Info info;

	public List<GetUserDetail> getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(List<GetUserDetail> userDetail) {
		this.userDetail = userDetail;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetUserDetailList [userDetail=" + userDetail + ", info=" + info + "]";
	}

}
