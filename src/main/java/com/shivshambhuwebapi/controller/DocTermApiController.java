package com.shivshambhuwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.master.model.DocTermDetail;
import com.shivshambhuwebapi.master.model.DocTermHeader;
import com.shivshambhuwebapi.master.repo.DocTermDetailRepo;
import com.shivshambhuwebapi.master.repo.DocTermHeaderRepo;

@RestController
public class DocTermApiController {

	@Autowired
	DocTermHeaderRepo docTermHeaderRepo;

	@Autowired
	DocTermDetailRepo docTermDetailRepo;

	@RequestMapping(value = { "/saveDocTermHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody DocTermHeader saveDocTermHeaderAndDetail(@RequestBody DocTermHeader docTerm) {

		Info errorMessage = new Info();
		DocTermHeader docTermHeader = new DocTermHeader();
		try {

			docTermHeader = docTermHeaderRepo.save(docTerm);

			for (int i = 0; i < docTermHeader.getDetailList().size(); i++) {

				docTerm.getDetailList().get(i).setTermId(docTermHeader.getTermId());

			}

			List<DocTermDetail> docTermDetailsList = docTermDetailRepo.saveAll(docTerm.getDetailList());
			docTermHeader.setDetailList(docTermDetailsList);

			errorMessage.setError(false);
			errorMessage.setMessage("successfully Saved ");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return docTermHeader;

	}

}
