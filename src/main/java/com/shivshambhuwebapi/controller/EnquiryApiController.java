package com.shivshambhuwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.tx.model.EnqDetail;
import com.shivshambhuwebapi.tx.model.EnqHeader;
import com.shivshambhuwebapi.tx.repo.EnqDetailRepo;
import com.shivshambhuwebapi.tx.repo.EnqHeaderRepo;

@RestController

public class EnquiryApiController {

	@Autowired
	EnqHeaderRepo enqHeaderRepo;

	@Autowired
	EnqDetailRepo enqDetailRepo;

	@RequestMapping(value = { "/saveEnqHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info saveEnquiryHeaderAndDetail(@RequestBody EnqHeader enqHeader) {

		Info errorMessage = new Info();
		EnqHeader enquiryHeader = new EnqHeader();

		try {

			enquiryHeader = enqHeaderRepo.save(enqHeader);

			List<EnqDetail> enquiryDetailsList = enqDetailRepo.saveAll(enqHeader.getEnqDetailList());
			enquiryHeader.setEnqDetailList(enquiryDetailsList);

			errorMessage.setError(false);
			errorMessage.setMessage("successfully Saved ");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getEnqHeaderList" }, method = RequestMethod.GET)
	public @ResponseBody List<EnqHeader> getEnqHeaderList() {

		List<EnqHeader> enquiryHeaderList = new ArrayList<EnqHeader>();

		try {

			enquiryHeaderList = enqHeaderRepo.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return enquiryHeaderList;

	}

}
