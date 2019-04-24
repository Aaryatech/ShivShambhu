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

import com.shivshambhuwebapi.master.model.DocTermDetail;
import com.shivshambhuwebapi.master.model.DocTermHeader;
import com.shivshambhuwebapi.master.model.GetDocTermHeader;
import com.shivshambhuwebapi.master.repo.DocTermDetailRepo;
import com.shivshambhuwebapi.master.repo.DocTermHeaderRepo;
import com.shivshambhuwebapi.master.repo.GetDocTermDetailRepo;
import com.shivshambhuwebapi.master.repo.GetDocTermHeaderRepo;
import com.shivshambhuwebapi.tx.model.EnqDetail;
import com.shivshambhuwebapi.tx.model.EnqHeader;

@RestController
public class DocTermApiController {

	@Autowired
	DocTermHeaderRepo docTermHeaderRepo;

	@Autowired
	GetDocTermHeaderRepo getDocTermHeaderRepo;

	@Autowired
	GetDocTermDetailRepo getDocTermDetailRepo;

	@Autowired
	DocTermDetailRepo docTermDetailRepo;

	@RequestMapping(value = { "/saveDocTermHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody DocTermHeader saveDocTermHeaderAndDetail(@RequestBody DocTermHeader docTerm) {

		Info errorMessage = new Info();
		DocTermHeader docTermHeader = new DocTermHeader();
		try {

			docTermHeader = docTermHeaderRepo.save(docTerm);

			for (int i = 0; i < docTerm.getDetailList().size(); i++) {

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

	@RequestMapping(value = { "/getDocHeaderList" }, method = RequestMethod.GET)
	public @ResponseBody List<DocTermHeader> getDocHeaderList() {

		List<DocTermHeader> docHeaderList = new ArrayList<DocTermHeader>();

		try {

			docHeaderList = docTermHeaderRepo.findByDelStatus(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return docHeaderList;

	}

	@RequestMapping(value = { "/getAllDocHeaderList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetDocTermHeader> getAllDocHeaderList(@RequestParam("plantId") int plantId) {

		List<GetDocTermHeader> docHeaderList = new ArrayList<GetDocTermHeader>();

		try {
			if (plantId == 0) {

				docHeaderList = getDocTermHeaderRepo.getDocHeaderList();
			} else {

				docHeaderList = getDocTermHeaderRepo.getDocHeaderListByPlantId(plantId);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return docHeaderList;

	}

	@RequestMapping(value = { "/getDocHeaderByDocId" }, method = RequestMethod.POST)
	public @ResponseBody List<DocTermHeader> getDocHeaderByDocId(@RequestParam("docId") int docId) {

		List<DocTermHeader> docHeaderList = new ArrayList<DocTermHeader>();

		try {

			docHeaderList = docTermHeaderRepo.findByDocIdAndDelStatus(docId, 1);

			for (int i = 0; i < docHeaderList.size(); i++) {
				List<DocTermDetail> detailList = docTermDetailRepo.findByTermId(docHeaderList.get(i).getTermId());
				docHeaderList.get(i).setDetailList(detailList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return docHeaderList;

	}

	@RequestMapping(value = { "/getDocHeaderByDocIdAndPlantId" }, method = RequestMethod.POST)
	public @ResponseBody List<DocTermHeader> getDocHeaderByDocIdAndPlantId(@RequestParam("docId") int docId,
			@RequestParam("plantId") int plantId) {

		List<DocTermHeader> docHeaderList = new ArrayList<DocTermHeader>();

		try {

			docHeaderList = docTermHeaderRepo.findByDocIdAndExInt1AndDelStatus(docId, plantId, 1);

			for (int i = 0; i < docHeaderList.size(); i++) {
				List<DocTermDetail> detailList = docTermDetailRepo.findByTermId(docHeaderList.get(i).getTermId());
				docHeaderList.get(i).setDetailList(detailList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return docHeaderList;

	}
	
	@RequestMapping(value = { "/getDocHeaderByDocIdAndPlantIdForAll" }, method = RequestMethod.POST)
	public @ResponseBody List<DocTermHeader> getDocHeaderByDocIdAndPlantIdForAll(@RequestParam("docId") int docId,
			@RequestParam("plantId") int plantId) {

		List<DocTermHeader> docHeaderList = new ArrayList<DocTermHeader>();

		try {
			if(plantId==0)
			{

			docHeaderList = docTermHeaderRepo.findByDocIdAndDelStatus(docId, 1);
			}
			else
			{
				docHeaderList = docTermHeaderRepo.findByDocIdAndExInt1AndDelStatus(docId, plantId, 1);
			}

			for (int i = 0; i < docHeaderList.size(); i++) {
				List<DocTermDetail> detailList = docTermDetailRepo.findByTermId(docHeaderList.get(i).getTermId());
				docHeaderList.get(i).setDetailList(detailList);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return docHeaderList;

	}


	@RequestMapping(value = { "/getDocHeaderByTermId" }, method = RequestMethod.POST)
	public @ResponseBody DocTermHeader getDocHeaderByTermId(@RequestParam("termId") int termId) {

		DocTermHeader termHeader = new DocTermHeader();

		try {

			termHeader = docTermHeaderRepo.findByTermIdAndDelStatus(termId, 1);
			List<DocTermDetail> detailList = docTermDetailRepo.findByTermIdAndDelStatus(termId, 1);
			termHeader.setDetailList(detailList);
		} catch (Exception e) {

			e.printStackTrace();

		}
		return termHeader;

	}

	@RequestMapping(value = { "/deleteDocHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDocHeader(@RequestParam("termId") int termId) {

		Info info = new Info();

		try {
			int delete = docTermHeaderRepo.deleteDocHeader(termId);

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

	@RequestMapping(value = { "/deleteMultiDocHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiDocHeader(@RequestParam("termIds") List<Integer> termIds) {

		Info info = new Info();

		try {
			int delete = docTermHeaderRepo.deleteMultiDocHeader(termIds);

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
