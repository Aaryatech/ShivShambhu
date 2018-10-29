package com.shivshambhuwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.tx.model.QuotDetail;
import com.shivshambhuwebapi.tx.model.QuotHeader;
import com.shivshambhuwebapi.tx.repo.QuotDetailRepo;
import com.shivshambhuwebapi.tx.repo.QuotHeaderRepo;

@RestController
public class QuotController {

	@Autowired
	QuotHeaderRepo quotHeaderRepo;

	@Autowired
	QuotDetailRepo quotDetailRepo;

	@RequestMapping(value = { "/saveQuotHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info saveQuotHeaderAndDetail(@RequestBody QuotHeader quotHeader) {

		Info errorMessage = new Info();
		QuotHeader quot = new QuotHeader();

		try {

			quot = quotHeaderRepo.save(quotHeader);

			for (int i = 0; i < quot.getQuotDetailList().size(); i++) {

				quotHeader.getQuotDetailList().get(i).setQuotHeadId(quotHeader.getQuotHeadId());
				List<QuotDetail> quotDetailsList = quotDetailRepo.saveAll(quotHeader.getQuotDetailList());
				quot.setQuotDetailList(quotDetailsList);

			}

			errorMessage.setError(false);
			errorMessage.setMessage("successfully Saved ");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/deleteQuotHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteQuotHeader(@RequestParam("quotHeadId") int quotHeadId) {

		Info info = new Info();

		try {
			int delete = quotHeaderRepo.deleteQuotHeader(quotHeadId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
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

	@RequestMapping(value = { "/deleteQuotDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteQuotDetail(@RequestParam("quotDetailId") int quotDetailId) {

		Info info = new Info();

		try {
			int delete = quotDetailRepo.deleteQuotDetail(quotDetailId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
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
	
	@RequestMapping(value = { "/getQuotHeaderByQuotHeadId" }, method = RequestMethod.POST)
	public @ResponseBody QuotHeader getQuotHeaderByQuotHeadId(@RequestParam("quotHeadId") int quotHeadId) {

		QuotHeader quotHeader = new QuotHeader();

		try {

			quotHeader = quotHeaderRepo.findByQuotHeadId(quotHeadId);
			List<QuotDetail> quotDetailList = quotDetailRepo.findByQuotHeadId(quotHeadId);
			quotHeader.setQuotDetailList(quotDetailList);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return quotHeader;

	}

}
