package com.shivshambhuwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.tx.model.MatIssueDetail;
import com.shivshambhuwebapi.tx.model.MatIssueHeader;
import com.shivshambhuwebapi.tx.repo.MatIssueDetailRepo;
import com.shivshambhuwebapi.tx.repo.MatIssueHeaderRepo;

@RestController
public class MatIssueApiController {

	@Autowired
	MatIssueHeaderRepo matIssueHeaderRepo;

	@Autowired
	MatIssueDetailRepo matIssueDetailRepo;

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

}
