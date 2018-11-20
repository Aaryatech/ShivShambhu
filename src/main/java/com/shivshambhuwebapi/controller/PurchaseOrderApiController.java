package com.shivshambhuwebapi.controller;
 
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
	
	/*select ph.*,c.cust_name,pl.plant_name,pt.pay_term,pr.proj_name from t_cust_po_header ph,m_customer c,m_plant pl,m_payment_term pt,m_project pr
where ph.del_status=1 and c.cust_id=ph.cust_id and pl.plant_id=ph.plant_id and pt.pay_term_id=ph.po_term_id and pr.proj_id=ph.cust_project_id*/

	
	/*select pd.*,i.item_name from t_cust_po_detail pd,m_item i  where pd.po_id=3 and i.item_id=pd.item_id*/
}
