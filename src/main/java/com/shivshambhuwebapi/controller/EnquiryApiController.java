package com.shivshambhuwebapi.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public @ResponseBody EnqHeader saveEnquiryHeaderAndDetail(@RequestBody EnqHeader enqHeader) {

		Info errorMessage = new Info();
		EnqHeader enquiryHeader = new EnqHeader();

		try {

			enquiryHeader = enqHeaderRepo.save(enqHeader);

			for (int i = 0; i < enqHeader.getEnqDetailList().size(); i++) {
				enqHeader.getEnqDetailList().get(i).setEnqHeadId(enquiryHeader.getEnqHeadId());

			}

			List<EnqDetail> enqDetailsList = enqDetailRepo.saveAll(enqHeader.getEnqDetailList());
			enquiryHeader.setEnqDetailList(enqDetailsList);

			errorMessage.setError(false);
			errorMessage.setMessage("successfully Saved ");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return enquiryHeader;

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

	@RequestMapping(value = { "/getEnqHeaderByEnqHeadId" }, method = RequestMethod.POST)
	public @ResponseBody EnqHeader getEnqHeaderByEnqHeadId(@RequestParam("enqHeadId") int enqHeadId) {

		EnqHeader enqHeader = new EnqHeader();

		try {

			enqHeader = enqHeaderRepo.findByEnqHeadId(enqHeadId);
			List<EnqDetail> enqDetailList = enqDetailRepo.findByEnqHeadId(enqHeadId);
			enqHeader.setEnqDetailList(enqDetailList);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return enqHeader;

	}

	@RequestMapping(value = { "/updateEnquiry" }, method = RequestMethod.POST)
	public @ResponseBody Info updateEnquiry(@RequestParam("enqHeadId") int enqHeadId,
			@RequestParam("enqHRemark") String enqHRemark, @RequestParam("enqDate") String enqDate) {

		Info info = new Info();

		try {
			int delete = enqHeaderRepo.updateEnquiry(enqHeadId, enqHRemark, enqDate);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Updated");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

}
