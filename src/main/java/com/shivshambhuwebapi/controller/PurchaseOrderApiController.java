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

import com.shivshambhuwebapi.model.GetPoDetail;
import com.shivshambhuwebapi.model.GetPoHeader;
import com.shivshambhuwebapi.model.PoDetail;
import com.shivshambhuwebapi.model.PoHeader;
import com.shivshambhuwebapi.repository.GetPoDetailRepository;
import com.shivshambhuwebapi.repository.GetPoHeaderRepository;
import com.shivshambhuwebapi.repository.PoDetailRepository;
import com.shivshambhuwebapi.repository.PoHeaderRepository;
import com.shivshambhuwebapi.tx.model.GetPoForOrder;
import com.shivshambhuwebapi.tx.repo.GetPoForOrderRepo;
import com.shivshambhuwebapi.tx.repo.QuotHeaderRepo;

@RestController
public class PurchaseOrderApiController {

	@Autowired
	PoHeaderRepository poHeaderRepository;

	@Autowired
	PoDetailRepository poDetailRepository;

	@Autowired
	QuotHeaderRepo quotHeaderRepo;

	@Autowired
	GetPoHeaderRepository getPoHeaderRepository;

	@Autowired
	GetPoDetailRepository getPoDetailRepository;

	@RequestMapping(value = { "/savePurchaseOrder" }, method = RequestMethod.POST)
	public @ResponseBody PoHeader savePurchaseOrder(@RequestBody PoHeader poHeader) {

		PoHeader save = new PoHeader();

		try {

			save = poHeaderRepository.save(poHeader);

			for (int i = 0; i < poHeader.getPoDetailList().size(); i++) {

				poHeader.getPoDetailList().get(i).setPoId(save.getPoId());

			}

			List<PoDetail> saveList = poDetailRepository.saveAll(poHeader.getPoDetailList());

			save.setPoDetailList(saveList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return save;

	}

	@RequestMapping(value = { "/updateQuatationStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateQuatationStatus(@RequestParam("quotHeadId") int quotHeadId) {

		Info info = new Info();

		try {
			int delete = quotHeaderRepo.updateQuatationStatus(quotHeadId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("updatated");
			} else {
				info.setError(true);
				info.setMessage(" failed to updatated");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" failed to updatated");

		}
		return info;

	}

	@RequestMapping(value = { "/getPoHeaderWithDetail" }, method = RequestMethod.POST)
	public @ResponseBody GetPoHeader getPoHeaderWithDetail(@RequestParam("poId") int poId) {

		GetPoHeader getPoHeader = new GetPoHeader();

		try {
			getPoHeader = getPoHeaderRepository.getPoHeader(poId);
			List<GetPoDetail> detailList = getPoDetailRepository.getDetail(getPoHeader.getPoId());
			getPoHeader.setGetPoDetailList(detailList);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getPoHeader;

	}

	@RequestMapping(value = { "/getPoListByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoHeader> getPoListByDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetPoHeader> getPoListByDate = new ArrayList<GetPoHeader>();

		try {
			getPoListByDate = getPoHeaderRepository.getPoListByDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getPoListByDate;

	}

	// 27-12-2018
	@RequestMapping(value = { "/getPoListByDateAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoHeader> getPoListByDateAndStatus(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("custId") int custId,
			@RequestParam("plantId") int plantId, @RequestParam("statusList") List<Integer> statusList) {

		List<GetPoHeader> getPoListByDate = new ArrayList<GetPoHeader>();

		if (statusList.contains(-1)) {
			statusList.clear();
			statusList.add(0);
			statusList.add(1);
			statusList.add(2);
		}

		try {

			if (custId == 0 && plantId == 0) {
				getPoListByDate = getPoHeaderRepository.getPoListByDateAndStatusList(fromDate, toDate, statusList);

			} else if (custId == 0 && plantId != 0) {
				getPoListByDate = getPoHeaderRepository.getPoListByDateAndPlantId(fromDate, toDate, plantId,
						statusList);

			} else if (custId != 0 && plantId == 0) {
				getPoListByDate = getPoHeaderRepository.getPoListByDateAndCustId(fromDate, toDate, custId, statusList);

			} else if (custId != 0 && plantId != 0) {
				getPoListByDate = getPoHeaderRepository.getPoListByDateAndPlantAndCust(fromDate, toDate, custId,
						plantId, statusList);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getPoListByDate;

	}

	@RequestMapping(value = { "/deletePurchaseOrder" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePurchaseOrder(@RequestParam("poId") int poId) {

		Info info = new Info();

		try {
			int delete = poHeaderRepository.deletePurchaseOrder(poId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("updatated");
			} else {
				info.setError(true);
				info.setMessage(" failed to updatated");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" failed to updatated");

		}
		return info;

	}

	// sachin
	@RequestMapping(value = { "/getPoHeaderByCustIdAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<PoHeader> getPoHeaderByCustIdAndStatus(@RequestParam("custId") int custId,
			@RequestParam("statusList") List<Integer> statusList) {

		List<PoHeader> poHeadResList = new ArrayList<>();

		try {

			poHeadResList = poHeaderRepository.findByDelStatusAndCustIdAndStatusIn(1, custId, statusList);

		} catch (Exception e) {
			System.err.println("Exce in getting /getPoHeaderByCustIdAndStatus" + e.getMessage());
			e.printStackTrace();

		}

		return poHeadResList;

	}

	// sachin
	@Autowired
	GetPoForOrderRepo getPoForOrderRepo;

	@RequestMapping(value = { "/getPoDetailForOrderByPoId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPoForOrder> getPoForOrderByPoId(@RequestParam("poId") int poId) {

		List<GetPoForOrder> poDetailList = new ArrayList<>();

		try {

			poDetailList = getPoForOrderRepo.getGetPoForOrderByPoId(poId);

		} catch (Exception e) {
			System.err.println("Exce in getting /getPoDetailForOrderByPoId" + e.getMessage());
			e.printStackTrace();

		}

		return poDetailList;

	}

}
