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

import com.shivshambhuwebapi.common.DateConvertor;
import com.shivshambhuwebapi.tx.model.EnqDetail;
import com.shivshambhuwebapi.tx.model.EnqHeader;
import com.shivshambhuwebapi.tx.model.GetMatIssueDetail;
import com.shivshambhuwebapi.tx.model.GetMatIssueHeader;
import com.shivshambhuwebapi.tx.model.MatIssueDetail;
import com.shivshambhuwebapi.tx.model.MatIssueHeader;
import com.shivshambhuwebapi.tx.repo.GetMatIssueDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetMatIssueHeaderRepo;
import com.shivshambhuwebapi.tx.repo.MatIssueDetailRepo;
import com.shivshambhuwebapi.tx.repo.MatIssueHeaderRepo;

@RestController
public class MatIssueApiController {

	@Autowired
	MatIssueHeaderRepo matIssueHeaderRepo;

	@Autowired
	MatIssueDetailRepo matIssueDetailRepo;

	@Autowired
	GetMatIssueHeaderRepo getMatIssueHeaderRepo;

	@Autowired
	GetMatIssueDetailRepo getMatIssueDetailRepo;

	@RequestMapping(value = { "/saveMatIssueHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody MatIssueHeader saveMatIssueHeaderAndDetail(@RequestBody MatIssueHeader matHeader) {

		Info errorMessage = new Info();
		MatIssueHeader matIssueHeader = new MatIssueHeader();

		try {

			matIssueHeader = matIssueHeaderRepo.save(matHeader);

			for (int i = 0; i < matIssueHeader.getMatIssueDetailList().size(); i++) {
				matHeader.getMatIssueDetailList().get(i).setMatHeaderId(matIssueHeader.getMatHeaderId());

			}

			List<MatIssueDetail> matDetailsList = matIssueDetailRepo.saveAll(matHeader.getMatIssueDetailList());
			matIssueHeader.setMatIssueDetailList(matDetailsList);
			errorMessage.setError(false);
			errorMessage.setMessage("successfully Saved ");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return matIssueHeader;

	}

	@RequestMapping(value = { "/getMatIssueContrHeaderList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetMatIssueHeader> getMatIssueContrHeaderList() {

		List<GetMatIssueHeader> headerList = new ArrayList<GetMatIssueHeader>();

		try {

			headerList = getMatIssueHeaderRepo.getMatIssueHeadeList();

			for (int i = 0; i < headerList.size(); i++) {
				headerList.get(i).setDate(DateConvertor.convertToDMY(headerList.get(i).getDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

	@RequestMapping(value = { "/getMatIssueContrByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody GetMatIssueHeader getMatIssueContrByHeaderId(@RequestParam("matHeaderId") int matHeaderId) {

		GetMatIssueHeader header = new GetMatIssueHeader();

		try {

			header = getMatIssueHeaderRepo.getMatIssueHeaderByHeaderId(matHeaderId);
			header.setDate(DateConvertor.convertToDMY(header.getDate()));
			List<GetMatIssueDetail> matDetailList = getMatIssueDetailRepo
					.getMatIssueHeaderByHeaderId(header.getMatHeaderId());
			header.setMatIssueDetailList(matDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return header;

	}

	@RequestMapping(value = { "/deleteMatIssueHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMatIssueHeader(@RequestParam("matHeaderId") int matHeaderId) {

		Info info = new Info();

		try {
			int delete = matIssueHeaderRepo.deleteMatIssueHeader(matHeaderId);

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

	@RequestMapping(value = { "/deleteMultiMatIssueHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiMatIssueHeader(@RequestParam("matHeaderIds") List<Integer> matHeaderIds) {

		Info info = new Info();

		try {
			int delete = matIssueHeaderRepo.deleteMultiMatIssueHeader(matHeaderIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
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
