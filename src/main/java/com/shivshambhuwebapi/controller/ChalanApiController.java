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

import com.shivshambhuwebapi.master.model.OrderDetail;
import com.shivshambhuwebapi.master.model.OrderHeader;
import com.shivshambhuwebapi.master.repo.OrderDetailRepo;
import com.shivshambhuwebapi.master.repo.OrderHeaderRepo;
import com.shivshambhuwebapi.model.PoDetail;
import com.shivshambhuwebapi.model.PoHeader;
import com.shivshambhuwebapi.repository.PoDetailRepository;
import com.shivshambhuwebapi.repository.PoHeaderRepository;
import com.shivshambhuwebapi.tx.model.ChalanDetail;
import com.shivshambhuwebapi.tx.model.ChalanHeader;
import com.shivshambhuwebapi.tx.model.GetChalanDetail;
import com.shivshambhuwebapi.tx.model.GetChalanHeader;
import com.shivshambhuwebapi.tx.repo.ChalanDetailRepo;
import com.shivshambhuwebapi.tx.repo.ChalanHeaderRepo;
import com.shivshambhuwebapi.tx.repo.GetChalanDetailRepo;
import com.shivshambhuwebapi.tx.repo.GetChalanHeaderRepo;

@RestController
public class ChalanApiController {

	@Autowired
	ChalanHeaderRepo chalanHeaderRepo;
	@Autowired
	ChalanDetailRepo chalanDetailRepo;

	@Autowired
	OrderHeaderRepo orderHeaderRepo;

	@Autowired
	OrderDetailRepo orderDetailRepo;

	@Autowired
	PoHeaderRepository poHeaderRepository;

	@Autowired
	PoDetailRepository poDetailRepository;

	@RequestMapping(value = { "/saveChalanHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody ChalanHeader saveChalanHeaderDetail(@RequestBody ChalanHeader chHead) {

		ChalanHeader chHeaderRes = new ChalanHeader();

		try {
			
			chHead.setExInt1(1);

			chHeaderRes = chalanHeaderRepo.save(chHead);

			for (int i = 0; i < chHead.getChalanDetailList().size(); i++) {

				chHead.getChalanDetailList().get(i).setChalanId(chHeaderRes.getChalanId());

			}

			List<ChalanDetail> chalanDetList = chalanDetailRepo.saveAll(chHead.getChalanDetailList());
			chHeaderRes.setChalanDetailList(chalanDetList);

			/*List<OrderDetail> ordDetailList = new ArrayList<>();

			ordDetailList = orderDetailRepo.findByOrOrderIdAndDelStatus(chHeaderRes.getOrderId(), 1);

			List<PoDetail> poDetList = new ArrayList<>();

			poDetList = poDetailRepository.findByPoId(ordDetailList.get(0).getPoId());

			for (int i = 0; i < chalanDetList.size(); i++) {

				for (int j = 0; j < ordDetailList.size(); j++) {

					if (chalanDetList.get(i).getOrderDetailId() == ordDetailList.get(j).getOrderDetId()) {

						float remOrdQty = ordDetailList.get(j).getRemOrdQty() - chalanDetList.get(i).getItemQty();

						int status = 1;

						if (remOrdQty <= 0) {
							status = 2;
						}

						ordDetailList.get(j).setRemOrdQty(remOrdQty);
						ordDetailList.get(j).setStatus(status);

						orderDetailRepo.save(ordDetailList.get(j));

					}

				}

				for (int k = 0; k < poDetList.size(); k++) {

					if (chalanDetList.get(i).getItemId() == poDetList.get(k).getItemId()) {

						float remOrdQty = poDetList.get(k).getPoRemainingQty() - chalanDetList.get(i).getItemQty();

						int status = 1;

						if (remOrdQty == 0) {
							status = 2;
						}

						poDetList.get(k).setPoRemainingQty(remOrdQty);
						poDetList.get(k).setStatus(status);

						poDetailRepository.save(poDetList.get(k));

					}

				}
			} // end of chalan detail for Loop

			ordDetailList = new ArrayList<>();

			ordDetailList = orderDetailRepo.findByOrOrderIdAndDelStatus(chHeaderRes.getOrderId(), 1);

			poDetList = new ArrayList<>();

			poDetList = poDetailRepository.findByPoId(ordDetailList.get(0).getPoId());
			try {
				int statusOne = 0;
				int statusTwo = 0;
				int statusZero = 0;
				for (int a = 0; a < ordDetailList.size(); a++) {

					if (ordDetailList.get(a).getStatus() == 0) {
						statusZero = statusZero + 1;
					} else if (ordDetailList.get(a).getStatus() == 1) {
						statusOne = statusOne + 1;
					} else if (ordDetailList.get(a).getStatus() == 2) {
						statusTwo = statusTwo + 1;
					}
				}

				if (ordDetailList.size() == statusTwo) {
					// order Header =2

					OrderHeader header = orderHeaderRepo.findByOrderId(chHeaderRes.getOrderId());
					header.setStatus(2);
					orderHeaderRepo.save(header);

				} else if (ordDetailList.size() == statusOne) {

					// order Header =1

					OrderHeader header = orderHeaderRepo.findByOrderId(chHeaderRes.getOrderId());
					header.setStatus(1);
					orderHeaderRepo.save(header);
				}

				else if (ordDetailList.size() == statusZero) {

					// order Header =0

					OrderHeader header = orderHeaderRepo.findByOrderId(chHeaderRes.getOrderId());
					header.setStatus(0);
					orderHeaderRepo.save(header);
				} else if (statusOne > 0) {
					// order Header =1
					OrderHeader header = orderHeaderRepo.findByOrderId(chHeaderRes.getOrderId());
					header.setStatus(1);
					orderHeaderRepo.save(header);

				}

				statusOne = 0;
				statusTwo = 0;
				statusZero = 0;

				for (int a = 0; a < poDetList.size(); a++) {

					if (poDetList.get(a).getStatus() == 0) {
						statusZero = statusZero + 1;
					} else if (poDetList.get(a).getStatus() == 1) {
						statusOne = statusOne + 1;
					} else if (poDetList.get(a).getStatus() == 2) {
						statusTwo = statusTwo + 1;
					}
				}

				if (poDetList.size() == statusTwo) {
					// PO Header =2
					PoHeader header = poHeaderRepository.getOne(poDetList.get(0).getPoId());
					header.setStatus(2);
					poHeaderRepository.save(header);

				} else if (poDetList.size() == statusOne) {
					// PO Header =1
					PoHeader header = poHeaderRepository.getOne(poDetList.get(0).getPoId());
					header.setStatus(1);
					poHeaderRepository.save(header);
				}

				else if (poDetList.size() == statusZero) {
					// PO Header =0
					PoHeader header = poHeaderRepository.getOne(poDetList.get(0).getPoId());
					header.setStatus(0);
					poHeaderRepository.save(header);
				} else if (statusOne > 0) {
					// PO Header =1
					PoHeader header = poHeaderRepository.getOne(poDetList.get(0).getPoId());
					header.setStatus(1);
					poHeaderRepository.save(header);
				}
			} catch (Exception e) {

				System.err.println("Exce in updating Order and PO Headers  " + e.getMessage());

				e.printStackTrace();
			}*/
		} catch (Exception e) {

			System.err.println("Exce in saving chalan " + e.getMessage());
			e.printStackTrace();
		}

		return chHeaderRes;

	}

	@Autowired
	GetChalanHeaderRepo getGetChalanHeaderRepo;

	@RequestMapping(value = { "/getChalanHeadersByPlantAndStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetChalanHeader> getGetChalanHeaderByPlantAndStatus(@RequestParam("plantId") int plantId,
			@RequestParam("chalanStatus") int chalanStatus) {

		List<GetChalanHeader> chList = new ArrayList<>();

		try {

			chList = getGetChalanHeaderRepo.getGetChalanHeaderByPlantId(plantId, chalanStatus);

		} catch (Exception e) {

			System.err.println("exce in  getChalanHeadersByPlantAndStatus " + e.getMessage());
			e.printStackTrace();

		}

		return chList;
	}

	@RequestMapping(value = { "/getChalanHeadersByChalanId" }, method = RequestMethod.POST)
	public @ResponseBody GetChalanHeader getChalanHeadersByChalanId(@RequestParam("chalanId") int chalanId) {

		GetChalanHeader chHeader = new GetChalanHeader();

		try {

			chHeader = getGetChalanHeaderRepo.getGetChalanHeaderByChalanId(chalanId);

		} catch (Exception e) {

			System.err.println("exce in  getChalanHeadersByChalanId " + e.getMessage());
			e.printStackTrace();

		}

		return chHeader;
	}
	
	@Autowired GetChalanDetailRepo getGetChalanDetailRepo;
	
	@RequestMapping(value = { "/getGetChalanDetailByChalanId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetChalanDetail> getGetChalanDetail(@RequestParam("chalanId") int chalanId) {

		List<GetChalanDetail> chDetailList = new ArrayList<>();
		
		try {

			chDetailList = getGetChalanDetailRepo.getGetChalanDetail(chalanId);

		} catch (Exception e) {

			System.err.println("exce in  getGetChalanDetailByChalanId " + e.getMessage());
			e.printStackTrace();

		}

		return chDetailList;
	}

	@RequestMapping(value = { "/closeChalanApi" }, method = RequestMethod.POST)
	public @ResponseBody Info closeChalanApi(@RequestBody ChalanHeader chHeader) {
		
		Info info = new Info();

		try {
			
			int headClose=chalanHeaderRepo.closeChalanHeader(chHeader.getChalanId(), chHeader.getStatus(), chHeader.getInKm(), chHeader.getVehTimeIn(), chHeader.getChalanRemark(), chHeader.getCostSegment(), chHeader.getSitePersonName(), chHeader.getSitePersonMob());
			
			if(headClose>0) {
				// if header updated successfully //update chalan detail
				
				info.setError(false);
				
				List<ChalanDetail> chDetailList=new ArrayList<>();
				
				chDetailList=chHeader.getChalanDetailList();
				int response=0;
				for(int i=0;i<chDetailList.size();i++) {
					 response=0;
					ChalanDetail det=chDetailList.get(i);
					
					response=chalanDetailRepo.closeChalanDetail(det.getChalanDetailId(), det.getStatus(), det.getItemQty(), det.getItemLengthSite(), det.getItemWidthSite()
							, det.getItemHeightSite(), det.getItemTotalSite());
					
					if(response>0) {
						
						info.setError(false);
					}else {
						
						info.setError(true);
					}
				}//end of for
			}

			//int headClose=chalanHeaderRepo.closeChalanHeader(chalanId, status, inKm, inTime, chalanRemark, costSegment, sitePersonName, sitePersonMob)
			
			
			if(info.isError()==false) {
				
				//chHeader 
				
				List<ChalanDetail> chalanDetList=new ArrayList<>();
				
				
				chalanDetList=chHeader.getChalanDetailList();
				
				
				List<OrderDetail> ordDetailList = new ArrayList<>();

				ordDetailList = orderDetailRepo.findByOrOrderIdAndDelStatus(chHeader.getOrderId(), 1);

				List<PoDetail> poDetList = new ArrayList<>();

				poDetList = poDetailRepository.findByPoId(ordDetailList.get(0).getPoId());

				for (int i = 0; i < chalanDetList.size(); i++) {

					for (int j = 0; j < ordDetailList.size(); j++) {

						if (chalanDetList.get(i).getOrderDetailId() == ordDetailList.get(j).getOrderDetId()) {

							float remOrdQty = ordDetailList.get(j).getRemOrdQty() - chalanDetList.get(i).getItemQty();

							int status = 1;

							if (remOrdQty <= 0) {
								status = 2;
							}

							ordDetailList.get(j).setRemOrdQty(remOrdQty);
							ordDetailList.get(j).setStatus(status);

							orderDetailRepo.save(ordDetailList.get(j));
							System.err.println("order detail saved ");

						}

					}

					for (int k = 0; k < poDetList.size(); k++) {

						if (chalanDetList.get(i).getItemId() == poDetList.get(k).getItemId()) {

							float remOrdQty = poDetList.get(k).getPoRemainingQty() - chalanDetList.get(i).getItemQty();

							int status = 1;

							if (remOrdQty == 0) {
								status = 2;
							}

							poDetList.get(k).setPoRemainingQty(remOrdQty);
							poDetList.get(k).setStatus(status);

							poDetailRepository.save(poDetList.get(k));
							System.err.println("Po Detail Saved ");
							

						}

					}
				} // end of chalan detail for Loop

				ordDetailList = new ArrayList<>();

				ordDetailList = orderDetailRepo.findByOrOrderIdAndDelStatus(chHeader.getOrderId(), 1);

				poDetList = new ArrayList<>();

				poDetList = poDetailRepository.findByPoId(ordDetailList.get(0).getPoId());
				try {
					int statusOne = 0;
					int statusTwo = 0;
					int statusZero = 0;
					for (int a = 0; a < ordDetailList.size(); a++) {

						if (ordDetailList.get(a).getStatus() == 0) {
							statusZero = statusZero + 1;
						} else if (ordDetailList.get(a).getStatus() == 1) {
							statusOne = statusOne + 1;
						} else if (ordDetailList.get(a).getStatus() == 2) {
							statusTwo = statusTwo + 1;
						}
					}

					if (ordDetailList.size() == statusTwo) {
						// order Header =2

						OrderHeader header = orderHeaderRepo.findByOrderId(chHeader.getOrderId());
						header.setStatus(2);
						orderHeaderRepo.save(header);

					} else if (ordDetailList.size() == statusOne) {

						// order Header =1

						OrderHeader header = orderHeaderRepo.findByOrderId(chHeader.getOrderId());
						header.setStatus(1);
						orderHeaderRepo.save(header);
					}

					else if (ordDetailList.size() == statusZero) {

						// order Header =0

						OrderHeader header = orderHeaderRepo.findByOrderId(chHeader.getOrderId());
						header.setStatus(0);
						orderHeaderRepo.save(header);
					} else if (statusOne > 0) {
						// order Header =1
						OrderHeader header = orderHeaderRepo.findByOrderId(chHeader.getOrderId());
						header.setStatus(1);
						orderHeaderRepo.save(header);

					}

					statusOne = 0;
					statusTwo = 0;
					statusZero = 0;

					for (int a = 0; a < poDetList.size(); a++) {

						if (poDetList.get(a).getStatus() == 0) {
							statusZero = statusZero + 1;
						} else if (poDetList.get(a).getStatus() == 1) {
							statusOne = statusOne + 1;
						} else if (poDetList.get(a).getStatus() == 2) {
							statusTwo = statusTwo + 1;
						}
					}

					if (poDetList.size() == statusTwo) {
						// PO Header =2
						PoHeader header = poHeaderRepository.getOne(poDetList.get(0).getPoId());
						header.setStatus(2);
						poHeaderRepository.save(header);

					} else if (poDetList.size() == statusOne) {
						// PO Header =1
						PoHeader header = poHeaderRepository.getOne(poDetList.get(0).getPoId());
						header.setStatus(1);
						poHeaderRepository.save(header);
					}

					else if (poDetList.size() == statusZero) {
						// PO Header =0
						PoHeader header = poHeaderRepository.getOne(poDetList.get(0).getPoId());
						header.setStatus(0);
						poHeaderRepository.save(header);
					} else if (statusOne > 0) {
						// PO Header =1
						PoHeader header = poHeaderRepository.getOne(poDetList.get(0).getPoId());
						header.setStatus(1);
						poHeaderRepository.save(header);
					}
				} catch (Exception e) {

					System.err.println("Exce in updating Order and PO Headers  " + e.getMessage());

					e.printStackTrace();
				}
				
				
				
			}

		} catch (Exception e) {

			System.err.println("exce in  closeChalanApi " + e.getMessage());
			e.printStackTrace();

		}

		return info;
	}
	
	
	@RequestMapping(value = { "/deleteMultiChalan" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiQuot(@RequestParam("chalanIds") List<Integer> chalanIds) {

		Info info = new Info();

		try {
			int delete = chalanHeaderRepo. deleteMultiChalanDetail(chalanIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMessage(" failed to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Failed to Delete");

		}
		return info;

	}
	
} 
