package com.shivshambhuwebapi.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.shivshambhuwebapi.model.PoDetail;
import com.shivshambhuwebapi.model.PoHeader;
import com.shivshambhuwebapi.repository.PoDetailRepository;
import com.shivshambhuwebapi.repository.PoHeaderRepository; 
import com.shivshambhuwebapi.tx.repo.QuotHeaderRepo; 

@RestController
public class PurchaseOrderApiController {
	
	@Autowired
	PoHeaderRepository poHeaderRepository;
	
	@Autowired
	PoDetailRepository poDetailRepository;
	
	@Autowired
	QuotHeaderRepo quotHeaderRepo;
	
	@RequestMapping(value = { "/savePurchaseOrder" }, method = RequestMethod.POST)
	public @ResponseBody PoHeader savePurchaseOrder(@RequestBody PoHeader poHeader) {

		PoHeader save = new PoHeader();

		try {

			save = poHeaderRepository.save(poHeader);
			
			for(int i=0 ; i<poHeader.getPoDetailList().size() ; i++) {
				
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

}
