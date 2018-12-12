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
import com.shivshambhuwebapi.tx.model.GetVehDetail;
import com.shivshambhuwebapi.tx.model.GetVehHeader;
import com.shivshambhuwebapi.tx.model.MatIssueDetail;
import com.shivshambhuwebapi.tx.model.MatIssueHeader;
import com.shivshambhuwebapi.tx.model.MatIssueVehDetail;
import com.shivshambhuwebapi.tx.model.MatIssueVehHeader;
import com.shivshambhuwebapi.tx.repo.GetMatIssueDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetMatIssueHeaderRepo;
import com.shivshambhuwebapi.tx.repo.GetVehDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetVehHeaderRepo;
import com.shivshambhuwebapi.tx.repo.MatIssueDetailRepo;
import com.shivshambhuwebapi.tx.repo.MatIssueHeaderRepo;
import com.shivshambhuwebapi.tx.repo.MatIssueVehDetailRepo;
import com.shivshambhuwebapi.tx.repo.MatIssueVehHeaderRepo;

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

	@Autowired
	MatIssueVehHeaderRepo matIssueVehHeaderRepo;

	@Autowired
	MatIssueVehDetailRepo matIssueVehDetailRepo;

	@Autowired
	GetVehHeaderRepo getVehHeaderRepo;

	@Autowired
	GetVehDetailRepo getVehDetailRepo;

	@RequestMapping(value = { "/deleteMatVehHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMatVehHeader(@RequestParam("matVehHeaderId") int matVehHeaderId) {

		Info info = new Info();

		try {
			int delete = matIssueVehHeaderRepo.deleteMatVehHeader(matVehHeaderId);

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

	@RequestMapping(value = { "/deleteMatVehDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMatVehDetail(@RequestParam("matVehDetailId") int matVehDetailId) {

		Info info = new Info();

		try {
			int delete = matIssueVehDetailRepo.deleteMatVehDetail(matVehDetailId);

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

	@RequestMapping(value = { "/deleteMultiMatVehHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiMatVehHeader(@RequestParam("matVehHeaderIds") List<Integer> matVehHeaderIds) {

		Info info = new Info();

		try {
			int delete = matIssueVehHeaderRepo.deleteMultiMatVehHeader(matVehHeaderIds);

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

	@RequestMapping(value = { "/saveMatIssueVehicle" }, method = RequestMethod.POST)
	public @ResponseBody MatIssueVehHeader saveMatIssueVehicle(@RequestBody MatIssueVehHeader matHeader) {

		Info errorMessage = new Info();
		MatIssueVehHeader matIssueHeader = new MatIssueVehHeader();

		try {

			matIssueHeader = matIssueVehHeaderRepo.save(matHeader);

			for (int i = 0; i < matHeader.getVehDetailList().size(); i++) {
				matHeader.getVehDetailList().get(i).setMatVehHeaderId(matIssueHeader.getMatVehHeaderId());

			}

			List<MatIssueVehDetail> matDetailsList = matIssueVehDetailRepo.saveAll(matHeader.getVehDetailList());
			matIssueHeader.setVehDetailList(matDetailsList);
			errorMessage.setError(false);
			errorMessage.setMessage("successfully Saved ");

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return matIssueHeader;

	}

	@RequestMapping(value = { "/getMatIssueVehHeaderList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetVehHeader> getMatIssueVehHeaderList() {

		List<GetVehHeader> headerList = new ArrayList<GetVehHeader>();

		try {

			headerList = getVehHeaderRepo.getMatIssueHeadeList();

			for (int i = 0; i < headerList.size(); i++) {
				headerList.get(i).setDate(DateConvertor.convertToDMY(headerList.get(i).getDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;

	}

	@RequestMapping(value = { "/getMatIssueVehicleByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody GetVehHeader getMatIssueVehicleByHeaderId(@RequestParam("matVehHeaderId") int matVehHeaderId) {

		GetVehHeader header = new GetVehHeader();

		try {

			header = getVehHeaderRepo.getMatIssueByHeaderId(matVehHeaderId);
			header.setDate(DateConvertor.convertToDMY(header.getDate()));
			List<GetVehDetail> vehDetailList = getVehDetailRepo.getMatIssueByHeaderId(header.getMatVehHeaderId());
			header.setVehDetailList(vehDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return header;

	}

	@RequestMapping(value = { "/saveMatIssueHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody MatIssueHeader saveMatIssueHeaderAndDetail(@RequestBody MatIssueHeader matHeader) {

		Info errorMessage = new Info();
		MatIssueHeader matIssueHeader = new MatIssueHeader();

		try {

			matIssueHeader = matIssueHeaderRepo.save(matHeader);

			for (int i = 0; i < matHeader.getMatIssueDetailList().size(); i++) {
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

	@RequestMapping(value = { "/getMatIssueByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody MatIssueHeader getMatIssueByHeaderId(@RequestParam("matHeaderId") int matHeaderId) {

		MatIssueHeader header = new MatIssueHeader();

		try {

			header = matIssueHeaderRepo.findByMatHeaderIdAndDelStatus(matHeaderId, 1);
			header.setDate(DateConvertor.convertToDMY(header.getDate()));
			List<MatIssueDetail> matDetailList = matIssueDetailRepo
					.findByMatHeaderIdAndDelStatus(header.getMatHeaderId(), 1);
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

	@RequestMapping(value = { "/deleteMatContraDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMatContraDetail(@RequestParam("matDetailId") int matDetailId) {

		Info info = new Info();

		try {
			int delete = matIssueDetailRepo.deleteMatIssueDetail(matDetailId);

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

	@RequestMapping(value = { "/getMatIssueVehicleByVehicleId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetVehDetail> getMatIssueVehicleByVehicleId(@RequestParam("vehicleId") int vehicleId) {

		List<GetVehDetail> detail = new ArrayList<GetVehDetail>();

		try {

			detail = getVehDetailRepo.getMatIssueByVehicleId(vehicleId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return detail;

	}

}
