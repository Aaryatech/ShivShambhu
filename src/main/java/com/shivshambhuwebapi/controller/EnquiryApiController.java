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
import com.shivshambhuwebapi.tx.model.GetEnqDetail;
import com.shivshambhuwebapi.tx.model.GetEnqHeader;
import com.shivshambhuwebapi.tx.repo.EnqDetailRepo;
import com.shivshambhuwebapi.tx.repo.EnqHeaderRepo;
import com.shivshambhuwebapi.tx.repo.GetEnqDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetEnqHeaderRepo;

@RestController

public class EnquiryApiController {

	@Autowired
	EnqHeaderRepo enqHeaderRepo;

	@Autowired
	EnqDetailRepo enqDetailRepo;

	@Autowired
	GetEnqHeaderRepo getEnqHeaderRepo;

	@Autowired
	GetEnqDetailRepo getEnqDetailRepo;

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

	@RequestMapping(value = { "/getEnqListByPlantId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEnqHeader> getEnqListByPlantId(@RequestParam("plantId") int plantId) {

		List<GetEnqHeader> enquiryHeaderList = new ArrayList<GetEnqHeader>();

		try {

			enquiryHeaderList = getEnqHeaderRepo.getEnqHeaderByPlantId(plantId);
			for (int i = 0; i < enquiryHeaderList.size(); i++) {
				List<GetEnqDetail> enqDetailList = getEnqDetailRepo
						.getEnqDetailByEnqHeadId(enquiryHeaderList.get(i).getEnqHeadId());
				enquiryHeaderList.get(i).setEnqDetailList(enqDetailList);
			}

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
			@RequestParam("enqHRemark") String enqHRemark, @RequestParam("enqDate") String enqDate,
			@RequestParam("enqGenId") int enqGenId, @RequestParam("enqPriority") int enqPriority) {

		Info info = new Info();

		try {
			int delete = enqHeaderRepo.updateEnquiry(enqHeadId, enqHRemark, enqDate, enqGenId, enqPriority);

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
