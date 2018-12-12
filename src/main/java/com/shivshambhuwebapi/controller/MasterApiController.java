package com.shivshambhuwebapi.controller;
 
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.common.DateConvertor;
import com.shivshambhuwebapi.master.model.BankDetail;
import com.shivshambhuwebapi.master.model.Company;
import com.shivshambhuwebapi.master.model.Cust;
import com.shivshambhuwebapi.master.model.CustType;
import com.shivshambhuwebapi.master.model.Dept;
import com.shivshambhuwebapi.master.model.Document;
import com.shivshambhuwebapi.master.model.EnqGenFact;
import com.shivshambhuwebapi.master.model.GetBankDetail;
import com.shivshambhuwebapi.master.model.GetCust;
import com.shivshambhuwebapi.master.model.GetItem;
import com.shivshambhuwebapi.master.model.GetPlant;
import com.shivshambhuwebapi.master.model.GetProject;
import com.shivshambhuwebapi.master.model.GetUser;
import com.shivshambhuwebapi.master.model.GetVendor;
import com.shivshambhuwebapi.master.model.Item;
import com.shivshambhuwebapi.master.model.ItemType;
import com.shivshambhuwebapi.master.model.LoginResUser;
import com.shivshambhuwebapi.master.model.MarketingUser;
import com.shivshambhuwebapi.master.model.PaymentTerm;
import com.shivshambhuwebapi.master.model.Plant;
import com.shivshambhuwebapi.master.model.Project;
import com.shivshambhuwebapi.master.model.QuotTracking;
import com.shivshambhuwebapi.master.model.Task;
import com.shivshambhuwebapi.master.model.Tax;
import com.shivshambhuwebapi.master.model.Uom;
import com.shivshambhuwebapi.master.model.User;
import com.shivshambhuwebapi.master.model.Vendor;
import com.shivshambhuwebapi.master.repo.BankDetailRepo;
import com.shivshambhuwebapi.master.repo.CompanyRepo;
import com.shivshambhuwebapi.master.repo.CustRepo;
import com.shivshambhuwebapi.master.repo.CustTypeRepo;
import com.shivshambhuwebapi.master.repo.DeptRepo;
import com.shivshambhuwebapi.master.repo.DocumentRepo;
import com.shivshambhuwebapi.master.repo.EnqGenFactRepo;
import com.shivshambhuwebapi.master.repo.GetBankDetailRepo;
import com.shivshambhuwebapi.master.repo.GetCustRepo;
import com.shivshambhuwebapi.master.repo.GetItemRepo;
import com.shivshambhuwebapi.master.repo.GetPlantRepo;
import com.shivshambhuwebapi.master.repo.GetProjectRepo;
import com.shivshambhuwebapi.master.repo.GetUserRepo;
import com.shivshambhuwebapi.master.repo.GetVendorRepo;
import com.shivshambhuwebapi.master.repo.ItemRepo;
import com.shivshambhuwebapi.master.repo.MarketingUserRepo;
import com.shivshambhuwebapi.master.repo.PaymentTermRepo;
import com.shivshambhuwebapi.master.repo.PlantRepo;
import com.shivshambhuwebapi.master.repo.ProjectRepo;
import com.shivshambhuwebapi.master.repo.QuotTrackingRepo;
import com.shivshambhuwebapi.master.repo.TaskRepo;
import com.shivshambhuwebapi.master.repo.TaxRepo;
import com.shivshambhuwebapi.master.repo.UomRepo;
import com.shivshambhuwebapi.master.repo.UserRepo;
import com.shivshambhuwebapi.master.repo.VendorRepo;

@RestController
public class MasterApiController {

	@Autowired
	EnqGenFactRepo enqGenFactRepo;

	@Autowired
	GetVendorRepo getVendorRepo;

	@Autowired
	GetBankDetailRepo getBankDetailRepo;

	@Autowired
	GetUserRepo getUserRepo;

	@Autowired
	GetPlantRepo getPlantRepo;

	@Autowired
	GetItemRepo getItemRepo;

	@Autowired
	GetCustRepo getCustRepo;

	@Autowired
	BankDetailRepo bankDetailRepo;

	@Autowired
	CustTypeRepo custTypeRepo;

	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	PaymentTermRepo paymentTermRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	CustRepo custRepo;

	@Autowired
	DeptRepo deptRepo;

	@Autowired
	PlantRepo plantRepo;

	@Autowired
	ProjectRepo projectRepo;

	@Autowired
	ItemRepo itemRepo;

	@Autowired
	MarketingUserRepo marketingUserRepo;

	@Autowired
	UomRepo uomRepo;

	@Autowired
	VendorRepo vendorRepo;

	@Autowired
	QuotTrackingRepo quotTrackingRepo;

	@Autowired
	DocumentRepo getDocumentRepo;

	@Autowired
	GetProjectRepo getProjectRepo;

	// --------------------------------------Document-------------------------

	@RequestMapping(value = { "/saveDocument" }, method = RequestMethod.POST)
	public @ResponseBody Document saveDocument(@RequestBody Document document) {

		Document res = new Document();

		try {

			res = getDocumentRepo.saveAndFlush(document);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllDocList" }, method = RequestMethod.GET)
	public @ResponseBody List<Document> getAllDocList() {

		List<Document> docList = new ArrayList<Document>();

		try {

			docList = getDocumentRepo.findByDelStatusOrderByDocIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return docList;

	}

	@RequestMapping(value = { "/getDocument" }, method = RequestMethod.POST)
	public @ResponseBody Document getDocument(@RequestParam("docCode") int docCode) {

		Document doc = new Document();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = dateFormat.format(new Date());

		try {

			doc = getDocumentRepo.getDocuData(docCode, curDate);
			System.err.println("getting doc " + doc.toString());

		} catch (Exception e) {
			System.err.println("Exc in  /getDocument" + e.getMessage());
			e.printStackTrace();

		}

		return doc;

	}

	@RequestMapping(value = { "/updateDocSrNo" }, method = RequestMethod.POST)
	public @ResponseBody Info updateDocSrNo(@RequestParam("docCode") int docCode, @RequestParam("srNo") int srNo) {

		Info info = new Info();

		try {

			int update = getDocumentRepo.updateDocSrNo(srNo, docCode);

			if (update == 1) {
				info.setError(false);
				info.setMessage("successfully update");
			} else {
				info.setError(true);
				info.setMessage(" failed to update");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" failed to update");

		}
		return info;

	}

	// ---------------------------------------Bank Detail-------------------------

	@RequestMapping(value = { "/saveBankDetail" }, method = RequestMethod.POST)
	public @ResponseBody BankDetail saveBankDetail(@RequestBody BankDetail bankDetail) {

		BankDetail res = new BankDetail();

		try {

			res = bankDetailRepo.saveAndFlush(bankDetail);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/saveUniqueBankDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniqueBankDetail(@RequestParam("accNo") String accNo) {

		BankDetail res = new BankDetail();
		Info info = new Info();

		try {

			res = bankDetailRepo.findByAccNoAndDelStatus(accNo, 1);

			if (res == null) {

				info.setError(false);
				info.setMessage("New BankDetail");

			} else {
				info.setError(true);
				info.setMessage("Account No Already Exist");

			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getBankDetailByBankDetailId" }, method = RequestMethod.POST)
	public @ResponseBody BankDetail getBankDetailByBankDetailId(@RequestParam("bankDetId") int bankDetId) {

		BankDetail bankDetail = new BankDetail();

		try {
			bankDetail = bankDetailRepo.findByBankDetIdAndDelStatus(bankDetId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return bankDetail;

	}

	@RequestMapping(value = { "/getBankDetList" }, method = RequestMethod.GET)
	public @ResponseBody List<BankDetail> getBankDetList() {

		List<BankDetail> bankDetailList = new ArrayList<BankDetail>();

		try {

			bankDetailList = bankDetailRepo.findByDelStatusOrderByBankDetIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return bankDetailList;

	}

	@RequestMapping(value = { "/getAllBankDetList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetBankDetail> getAllBankDetList() {

		List<GetBankDetail> bankDetailList = new ArrayList<GetBankDetail>();

		try {

			bankDetailList = getBankDetailRepo.getAllBankDetailList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return bankDetailList;

	}

	@RequestMapping(value = { "/deleteBankDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteBankDetail(@RequestParam("bankDetId") int bankDetId) {

		Info info = new Info();

		try {
			int delete = bankDetailRepo.deleteBankDetail(bankDetId);

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

	@RequestMapping(value = { "/deleteMultiBankDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiBankDetail(@RequestParam("bankDetIds") List<Integer> bankDetIds) {

		Info info = new Info();

		try {
			int delete = bankDetailRepo.deleteMultiBankDetail(bankDetIds);

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

	// ----------------------------------------Cust Type-------------------------

	
	
	

	@RequestMapping(value = { "/saveCustType" }, method = RequestMethod.POST)
	public @ResponseBody Info saveCustType(@RequestBody CustType cust) {

		Info res = new Info();
		try {
			
			if ( cust.getCustTypeId()== 0) {
				// new dept insert
				System.err.println("a");
				List<CustType> custList =  custTypeRepo.findByDelStatusAndCustTypeNameContains(1, cust.getCustTypeName());
				if (custList.size() < 1) {
					 CustType custRes = custTypeRepo.saveAndFlush(cust);
					res.setError(false);
					res.setMessage("customer Saved Successfully");
				} else {
					System.err.println("c");
					// save dept
					res.setError(true);
					res.setMessage("cust name already exist");
					System.err.println("b");
					
				}

			} else if (cust.getCustTypeId() > 0) {
				System.err.println("d");
				// its edit call
				List<CustType> custList = custTypeRepo.findBydelStatusAndCustTypeIdNotInAndCustTypeNameContains(1,cust.getCustTypeId() ,
						cust.getCustTypeName());

				if (!custList.isEmpty()) {
					// dont save some other dept have same name

					res.setError(true);
					res.setMessage("Duplicate Customer Type");
					System.err.println("e");
				} else {

					 CustType custRes = custTypeRepo.saveAndFlush(cust);
						res.setError(false);
						res.setMessage("customer Saved Successfully");

					// save dept..
					System.err.println("f");
				}

			}

		} catch (Exception e) {
			res.setError(true);
			res.setMessage("Customer type Failed to Save");
			e.printStackTrace();

		}
		return res;

	}


	@RequestMapping(value = { "/saveUniqueCustType" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniqueCustType(@RequestParam("custTypeName") String custTypeName) {

		CustType res = new CustType();
		Info info = new Info();

		try {

			res = custTypeRepo.findByCustTypeNameAndDelStatus(custTypeName, 1);

			if (res == null) {

				info.setError(false);
				info.setMessage("New CustType");
				System.out.println("In If");
			} else {
				info.setError(true);
				info.setMessage("Measurement Unit Name Already Exist");
				System.out.println("In else");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getCustTypeByCustTypeId" }, method = RequestMethod.POST)
	public @ResponseBody CustType getCustTypeByCustTypeId(@RequestParam("custTypeId") int custTypeId) {

		CustType custType = new CustType();

		try {
			custType = custTypeRepo.findByCustTypeIdAndDelStatus(custTypeId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return custType;

	}

	@RequestMapping(value = { "/getAllCustTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<CustType> getAllCustTypeList() {

		List<CustType> custTypeList = new ArrayList<CustType>();

		try {

			custTypeList = custTypeRepo.findByDelStatusOrderByCustTypeIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return custTypeList;

	}

	@RequestMapping(value = { "/deleteCustType" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCustType(@RequestParam("custTypeId") int custTypeId) {

		Info info = new Info();

		try {
			int delete = custTypeRepo.deleteCustType(custTypeId);

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

	@RequestMapping(value = { "/deleteMultiCustType" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiCustType(@RequestParam("custTypeIds") List<Integer> custTypeIds) {

		Info info = new Info();

		try {
			int delete = custTypeRepo.deleteMultiCustType(custTypeIds);

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

	// ----------------------------------------Enq Gen Fact-------------------------

	@RequestMapping(value = { "/saveEnqGenFact" }, method = RequestMethod.POST)
	public @ResponseBody EnqGenFact saveEnqGenFact(@RequestBody EnqGenFact enqGenFact) {

		EnqGenFact res = new EnqGenFact();

		try {

			res = enqGenFactRepo.saveAndFlush(enqGenFact);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}
	
	
	/*@RequestMapping(value = { "/saveEnqGenFact" }, method = RequestMethod.POST)
	public @ResponseBody Info saveDept(@RequestBody EnqGenFact enqGenFact) {

		Info res = new Info();
		try {
			
			if (enqGenFact.getEnqGenId()==0) {
				// new dept insert
				System.err.println("a");
				List<EnqGenFact> genList =  enqGenFactRepo.findByDelStatusAndEnqGenByContains(1, enqGenFact.getEnqGenBy());

				if (genList.size() < 1) {
					EnqGenFact  deptRes = enqGenFactRepo.saveAndFlush(enqGenFact);
					res.setError(false);
					res.setMessage("enq src Saved Successfully");
				} else {
					System.err.println("c");
					// save dept
					res.setError(true);
					res.setMessage("enq src already exist");
					System.err.println("b");
					
				}

			} else if (enqGenFact.getEnqGenId() > 0) {
				System.err.println("d");
				// its edit call
				List<EnqGenFact> enqList =  enqGenFactRepo.findByDelStatusAndEnqGenIdNotInAndEnqGenByContains(1,  enqGenFact.getEnqGenId());
						enqGenFact.getEnqGenBy();

				if (!enqList .isEmpty()) {
					// dont save some other dept have same name

					res.setError(true);
					res.setMessage("Duplicate Enquiry Source");
					System.err.println("e");
				} else {

					EnqGenFact deptRes = enqGenFactRepo.saveAndFlush(enqGenFact);
					res.setError(false);
					res.setMessage("Enquiry source Saved Successfully");

					// save dept..
					System.err.println("f");
				}

			}

		} catch (Exception e) {
			res.setError(true);
			res.setMessage(" Failed to Save");
			e.printStackTrace();

		}
		return res;

	}
*/
	
	
	

	@RequestMapping(value = { "/saveUniqueEnqGenFact" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniqueEnqGenFact(@RequestParam("enqGenBy") String enqGenBy) {

		EnqGenFact res = new EnqGenFact();
		Info info = new Info();

		try {

			res = enqGenFactRepo.findByEnqGenByAndDelStatus(enqGenBy, 1);

			if (res == null) {

				info.setError(false);
				info.setMessage("New Enquiry Source");
				System.out.println("In If");
			} else {
				info.setError(true);
				info.setMessage("Measurement Unit Name Already Exist");
				System.out.println("In else");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getAllEGFList" }, method = RequestMethod.GET)
	public @ResponseBody List<EnqGenFact> getAllEGFList() {

		List<EnqGenFact> egfList = new ArrayList<EnqGenFact>();

		try {

			egfList = enqGenFactRepo.findByDelStatusOrderByEnqGenIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return egfList;

	}

	@RequestMapping(value = { "/getEnqGenFactByEnqGenFactId" }, method = RequestMethod.POST)
	public @ResponseBody EnqGenFact getEnqGenFactByEnqGenFactId(@RequestParam("enqGenId") int enqGenId) {

		EnqGenFact egf = new EnqGenFact();

		try {
			egf = enqGenFactRepo.findByEnqGenIdAndDelStatus(enqGenId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return egf;

	}

	@RequestMapping(value = { "/deleteEnqGenFact" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteEnqGenFact(@RequestParam("enqGenId") int enqGenId) {

		Info info = new Info();

		try {
			int delete = enqGenFactRepo.deleteEnqGenFact(enqGenId);

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

	@RequestMapping(value = { "/deleteMultiEnqGenFact" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiEnqGenFact(@RequestParam("enqGenIds") List<Integer> enqGenIds) {

		Info info = new Info();

		try {
			int delete = enqGenFactRepo.deleteMultiEnqGenFact(enqGenIds);

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
	// ----------------------------------------Payment Term-------------------------

	@RequestMapping(value = { "/savePaymentTerm" }, method = RequestMethod.POST)
	public @ResponseBody PaymentTerm savePaymentTerm(@RequestBody PaymentTerm paymentTerm) {

		PaymentTerm res = new PaymentTerm();

		try {

			res = paymentTermRepo.saveAndFlush(paymentTerm);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/saveUniquePaymentTerm" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniquePaymentTerm(@RequestParam("payTerm") String payTerm) {
		PaymentTerm res = new PaymentTerm();

		Info info = new Info();

		try {

			res = paymentTermRepo.findByPayTermAndDelStatus(payTerm, 1);

			if (res == null) {

				info.setError(false);
				info.setMessage("New Payment term");

			} else {
				info.setError(true);
				info.setMessage("Payment Term Already Exist");

			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getPTByPaymentTermId" }, method = RequestMethod.POST)
	public @ResponseBody PaymentTerm getPTByPaymentTermId(@RequestParam("payTermId") int payTermId) {

		PaymentTerm Pt = new PaymentTerm();

		try {
			Pt = paymentTermRepo.findByPayTermIdAndDelStatus(payTermId, 1);
			Pt.setDate(DateConvertor.convertToDMY(Pt.getDate()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return Pt;

	}

	@RequestMapping(value = { "/getAllPaymentTermList" }, method = RequestMethod.GET)
	public @ResponseBody List<PaymentTerm> getAllPaymentTermList() {

		List<PaymentTerm> ptList = new ArrayList<PaymentTerm>();

		try {

			ptList = paymentTermRepo.findByDelStatusOrderByPayTermIdDesc(1);
			for (int i = 0; i < ptList.size(); i++) {
				ptList.get(i).setDate(DateConvertor.convertToDMY(ptList.get(i).getDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return ptList;

	}

	@RequestMapping(value = { "/deletePaymentTerm" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePaymentTerm(@RequestParam("payTermId") int payTermId) {

		Info info = new Info();

		try {
			int delete = paymentTermRepo.deletePaymentTerm(payTermId);

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

	@RequestMapping(value = { "/deleteMultiPaymentTerm" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiPaymentTerm(@RequestParam("payTermIds") List<Integer> payTermIds) {

		Info info = new Info();

		try {
			int delete = paymentTermRepo.deleteMultiPaymentTerm(payTermIds);

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

	// ----------------------------------------QuotTracking----------------------------------------------------

	@RequestMapping(value = { "/saveQuotTracking" }, method = RequestMethod.POST)
	public @ResponseBody QuotTracking saveQuotTracking(@RequestBody QuotTracking quotTracking) {

		QuotTracking res = new QuotTracking();

		try {

			res = quotTrackingRepo.saveAndFlush(quotTracking);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getQuotByQuotTrackId" }, method = RequestMethod.POST)
	public @ResponseBody QuotTracking getQuotByQuotTrackId(@RequestParam("quotTrackId") int quotTrackId) {

		QuotTracking quotTracking = new QuotTracking();

		try {
			quotTracking = quotTrackingRepo.findByQuotTrackIdAndDelStatus(quotTrackId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return quotTracking;

	}

	@RequestMapping(value = { "/getAllQuotTrackList" }, method = RequestMethod.GET)
	public @ResponseBody List<QuotTracking> getAllQuotTrackList() {

		List<QuotTracking> quotTrackList = new ArrayList<QuotTracking>();

		try {

			quotTrackList = quotTrackingRepo.findByDelStatusOrderByQuotTrackIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return quotTrackList;

	}

	@RequestMapping(value = { "/deleteQuotTracking" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteQuotTracking(@RequestParam("quotTrackId") int quotTrackId) {

		Info info = new Info();

		try {
			int delete = quotTrackingRepo.deleteQuotTracking(quotTrackId);

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

	// ----------------------------------------Vendor----------------------------------------------------

	@RequestMapping(value = { "/saveVendor" }, method = RequestMethod.POST)
	public @ResponseBody Vendor saveVendor(@RequestBody Vendor vendor) {

		Vendor res = new Vendor();

		try {

			res = vendorRepo.saveAndFlush(vendor);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/saveUniqueVendor" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniqueVendor(@RequestParam("vendGst") String vendGst,
			@RequestParam("vendContact1") String vendContact1) {
		Vendor res = new Vendor();
		Info info = new Info();

		try {

			res = vendorRepo.findByVendGstAndVendContact1AndDelStatus(vendGst, vendContact1, 1);

			if (res == null) {

				info.setError(false);
				info.setMessage("New Vendor");

			} else {
				info.setError(true);
				info.setMessage("Vendor Already Exist");

			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getVendorByVendorId" }, method = RequestMethod.POST)
	public @ResponseBody Vendor getVendorByVendorId(@RequestParam("vendId") int vendId) {

		Vendor vendor = new Vendor();

		try {
			vendor = vendorRepo.findByVendIdAndDelStatus(vendId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vendor;

	}

	@RequestMapping(value = { "/getAllVendList" }, method = RequestMethod.GET)
	public @ResponseBody List<Vendor> getAllVendList() {

		List<Vendor> vendList = new ArrayList<Vendor>();

		try {

			vendList = vendorRepo.findByDelStatusOrderByVendIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vendList;

	}

	@RequestMapping(value = { "/getAllVendorList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetVendor> getAllVendorList() {

		List<GetVendor> vendList = new ArrayList<GetVendor>();

		try {

			vendList = getVendorRepo.getVendorList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return vendList;

	}

	@RequestMapping(value = { "/deleteVendor" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteVendor(@RequestParam("vendId") int vendId) {

		Info info = new Info();

		try {
			int delete = vendorRepo.deleteVendor(vendId);

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

	@RequestMapping(value = { "/deleteMultiVendor" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiVendor(@RequestParam("vendIds") List<Integer> vendIds) {

		Info info = new Info();

		try {
			int delete = vendorRepo.deleteMultiVendor(vendIds);

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

	// ----------------------------------------Uom----------------------------------------------------

	@RequestMapping(value = { "/saveUom" }, method = RequestMethod.POST)
	public @ResponseBody Uom saveUom(@RequestBody Uom uom) {

		Uom res = new Uom();

		try {

			res = uomRepo.saveAndFlush(uom);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/saveUniqueUom" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniqueUom(@RequestParam("uomName") String uomName) {

		Uom res = new Uom();
		Info info = new Info();

		try {

			res = uomRepo.findByUomNameAndDelStatus(uomName, 1);

			if (res == null) {

				info.setError(false);
				info.setMessage("New UOM");
				System.out.println("In If");
			} else {
				info.setError(true);
				info.setMessage("Measurement Unit Name Already Exist");
				System.out.println("In else");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getUomByUomId" }, method = RequestMethod.POST)
	public @ResponseBody Uom getUomByUomId(@RequestParam("uomId") int uomId) {

		Uom uom = new Uom();

		try {
			uom = uomRepo.findByUomIdAndDelStatus(uomId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return uom;

	}

	@RequestMapping(value = { "/getAllUomList" }, method = RequestMethod.GET)
	public @ResponseBody List<Uom> getAllUomList() {

		List<Uom> uomList = new ArrayList<Uom>();

		try {

			uomList = uomRepo.findByDelStatusOrderByUomIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return uomList;

	}

	@RequestMapping(value = { "/deleteUom" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteUom(@RequestParam("uomId") int uomId) {

		Info info = new Info();

		try {
			int delete = uomRepo.deleteUom(uomId);

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

	@RequestMapping(value = { "/deleteMultiUom" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiUom(@RequestParam("uomIds") List<Integer> uomIds) {

		Info info = new Info();

		try {
			int delete = uomRepo.deleteMultiUom(uomIds);

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

	// ----------------------------------------User----------------------------------------------------

	@RequestMapping(value = { "/saveUser" }, method = RequestMethod.POST)
	public @ResponseBody User saveUser(@RequestBody User user) {

		User res = new User();

		try {

			res = userRepo.saveAndFlush(user);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/saveUniqueUser" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniqueUser(@RequestParam("usrMob") String usrMob) {

		User res = new User();
		Info info = new Info();

		try {
			res = userRepo.findByUsrMobAndDelStatus(usrMob, 1);
			if (res == null) {

				info.setError(false);
				info.setMessage("New User");
				System.out.println("In If");
			} else {
				info.setError(true);
				info.setMessage("User Mobile No Already Exist");
				System.out.println("In else");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getUserByUserId" }, method = RequestMethod.POST)
	public @ResponseBody User getUserByUserId(@RequestParam("userId") int userId) {

		User user = new User();

		try {
			user = userRepo.findByUserIdAndDelStatus(userId, 1);
			user.setUsrDob(DateConvertor.convertToDMY(user.getUsrDob()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return user;

	}

	@RequestMapping(value = { "/getAllUserList" }, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUserList() {

		List<User> userList = new ArrayList<User>();

		try {

			userList = userRepo.findByDelStatusOrderByUserIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userList;

	}

	@RequestMapping(value = { "/getUserList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetUser> getUserList() {

		List<GetUser> userList = new ArrayList<GetUser>();

		try {

			userList = getUserRepo.getUserList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userList;

	}

	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteUser(@RequestParam("userId") int userId) {

		Info info = new Info();

		try {
			int delete = userRepo.deleteUser(userId);

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

	@RequestMapping(value = { "/updateUserToken" }, method = RequestMethod.POST)
	public @ResponseBody Info updateUserToken(@RequestParam("userId") int userId, @RequestParam("token") String token) {

		Info info = new Info();

		try {
			int delete = userRepo.updatetoken(userId, token);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Updated");
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

	@RequestMapping(value = { "/deleteMultiUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiUser(@RequestParam("userIds") List<Integer> userIds) {

		Info info = new Info();

		try {
			int delete = userRepo.deleteMultiUser(userIds);

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

	// ----------------------------------------Customer----------------------------------------------------

	@RequestMapping(value = { "/saveCust" }, method = RequestMethod.POST)
	public @ResponseBody Cust saveCust(@RequestBody Cust cust) {

		Cust res = new Cust();

		try {

			res = custRepo.saveAndFlush(cust);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/saveUniqueCustomer" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniqueCustomer(@RequestParam("custMobNo") String custMobNo) {

		Cust res = new Cust();
		Info info = new Info();

		try {

			res = custRepo.findByCustMobNoAndDelStatus(custMobNo, 1);

			if (res == null) {

				info.setError(false);
				info.setMessage("save Successfully");
				System.out.println("In If");
			} else {
				info.setError(true);
				info.setMessage("Customer Mobiile no Already Exist");
				System.out.println("In else");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getCustByCustId" }, method = RequestMethod.POST)
	public @ResponseBody Cust getCustByCustId(@RequestParam("custId") int custId) {

		Cust cust = new Cust();

		try {
			cust = custRepo.findByCustIdAndDelStatus(custId, 1);
			cust.setDateOfReg(DateConvertor.convertToDMY(cust.getDateOfReg()));
			cust.setCustDob(DateConvertor.convertToDMY(cust.getCustDob()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return cust;

	}

	@RequestMapping(value = { "/getCustomerByCustId" }, method = RequestMethod.POST)
	public @ResponseBody GetCust getCustomerByCustId(@RequestParam("custId") int custId) {

		GetCust cust = new GetCust();

		try {
			cust = getCustRepo.getCustByCustId(custId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return cust;

	}

	@RequestMapping(value = { "/getAllCustList" }, method = RequestMethod.GET)
	public @ResponseBody List<Cust> getAllCustList() {

		List<Cust> custList = new ArrayList<Cust>();

		try {

			custList = custRepo.findByDelStatusOrderByCustIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return custList;

	}

	@RequestMapping(value = { "/getAllCustomerList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetCust> getAllCustomerList() {

		List<GetCust> custList = new ArrayList<GetCust>();

		try {

			custList = getCustRepo.getAllCustList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return custList;

	}

	// Sachin 3 nov
	@RequestMapping(value = { "/getCustListByPlant" }, method = RequestMethod.POST)
	public @ResponseBody List<Cust> getCustListByPlant(@RequestParam("plantId") int plantId) {

		List<Cust> custList = new ArrayList<Cust>();

		try {

			custList = custRepo.findByDelStatusAndPlantIdOrderByCustIdDesc(1, plantId);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return custList;

	}

	@RequestMapping(value = { "/deleteCust" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCust(@RequestParam("custId") int custId) {

		Info info = new Info();

		try {
			int delete = custRepo.deleteCust(custId);

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

	@RequestMapping(value = { "/deleteMultiCust" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiCust(@RequestParam("custIds") List<Integer> custIds) {

		Info info = new Info();

		try {
			int delete = custRepo.deleteMultiCust(custIds);

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

	// ----------------------------------------Company----------------------------------------------------

	@RequestMapping(value = { "/saveCompany" }, method = RequestMethod.POST)
	public @ResponseBody Company saveCompany(@RequestBody Company company) {
		System.err.println("Inside saveCompany");
		Company res = new Company();

		try {

			res = companyRepo.saveAndFlush(company);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/saveUniqueCompany" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniqueCompany(@RequestParam("compGstNo") String compGstNo) {

		Company res = new Company();

		Info info = new Info();

		try {

			res = companyRepo.findByCompGstNoAndDelStatus(compGstNo, 1);

			if (res == null) {

				info.setError(false);
				info.setMessage("New Company");

			} else {
				info.setError(true);
				info.setMessage("GST No Already Exist");

			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getCompByCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody Company getCompByCompanyId(@RequestParam("companyId") int companyId) {

		Company comp = new Company();

		try {
			comp = companyRepo.findByCompanyIdAndDelStatus(companyId, 1);
			comp.setFromDate(DateConvertor.convertToDMY(comp.getFromDate()));
			comp.setToDate(DateConvertor.convertToDMY(comp.getToDate()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return comp;

	}

	@RequestMapping(value = { "/getAllCompList" }, method = RequestMethod.GET)
	public @ResponseBody List<Company> getAllCompList() {

		List<Company> compList = new ArrayList<Company>();

		try {

			compList = companyRepo.findByDelStatusOrderByCompanyIdDesc(1);
			for (int i = 0; i < compList.size(); i++) {
				compList.get(i).setFromDate(DateConvertor.convertToDMY(compList.get(i).getFromDate()));
				compList.get(i).setToDate(DateConvertor.convertToDMY(compList.get(i).getToDate()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return compList;

	}

	@RequestMapping(value = { "/deleteCompany" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCompany(@RequestParam("companyId") int companyId) {

		Info info = new Info();

		try {
			int delete = companyRepo.deleteCompany(companyId);

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

	@RequestMapping(value = { "/deleteMultiCompany" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiCompany(@RequestParam("companyIds") List<Integer> companyIds) {

		Info info = new Info();

		try {
			int delete = companyRepo.deleteMultiCompany(companyIds);

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
	// ----------------------------------------Dept----------------------------------------------------

	@RequestMapping(value = { "/saveDept" }, method = RequestMethod.POST)
	public @ResponseBody Info saveDept(@RequestBody Dept dept) {

		Info res = new Info();
		try {
			/*
			 * Dept isDeptPresent=null;
			 * 
			 * if(dept.getDeptId()==0) {
			 * isDeptPresent=deptRepo.findByDeptNameAndDelStatus(dept.getDeptName(),1); }
			 * if(isDeptPresent!=null) { res.setError(true);
			 * res.setMessage("Duplicate Department Name"); }else { Dept deptRes=
			 * deptRepo.saveAndFlush(dept); res.setError(false);
			 * res.setMessage("Department Saved Successfully"); }
			 */

			if (dept.getDeptId() == 0) {
				// new dept insert
				System.err.println("a");
				List<Dept> deptList = deptRepo.findByDelStatusAndDeptNameContains(1, dept.getDeptName());

				if (deptList.size() < 1) {
					Dept deptRes = deptRepo.saveAndFlush(dept);
					res.setError(false);
					res.setMessage("Department Saved Successfully");
				} else {
					System.err.println("c");
					// save dept
					res.setError(true);
					res.setMessage("dept name already exist");
					System.err.println("b");
					
				}

			} else if (dept.getDeptId() > 0) {
				System.err.println("d");
				// its edit call
				List<Dept> deptList = deptRepo.findBydelStatusAndDeptIdNotInAndDeptNameContains(1, dept.getDeptId(),
						dept.getDeptName());

				if (!deptList.isEmpty()) {
					// dont save some other dept have same name

					res.setError(true);
					res.setMessage("Duplicate Department Name");
					System.err.println("e");
				} else {

					Dept deptRes = deptRepo.saveAndFlush(dept);
					res.setError(false);
					res.setMessage("Department Saved Successfully");

					// save dept..
					System.err.println("f");
				}

			}

		} catch (Exception e) {
			res.setError(true);
			res.setMessage("Department Failed to Save");
			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/saveUniqueDept" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniqueDept(@RequestParam("deptName") String deptName) {

		Dept res = new Dept();
		Info info = new Info();

		try {

			res = deptRepo.findByDeptNameAndDelStatus(deptName, 1);

			if (res == null) {

				info.setError(false);
				info.setMessage("New Department");
				System.out.println("In If");
			} else {
				info.setError(true);
				info.setMessage("Department Name Already Exist");
				System.out.println("In else");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getDeptByDeptId" }, method = RequestMethod.POST)
	public @ResponseBody Dept getDeptByDeptId(@RequestParam("deptId") int deptId) {

		Dept dept = new Dept();

		try {
			dept = deptRepo.findByDeptIdAndDelStatus(deptId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return dept;

	}

	@RequestMapping(value = { "/getAllDeptList" }, method = RequestMethod.GET)
	public @ResponseBody List<Dept> getAllDeptList() {

		List<Dept> deptList = new ArrayList<Dept>();

		try {

			deptList = deptRepo.findByDelStatusOrderByDeptIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return deptList;

	}

	@RequestMapping(value = { "/deleteDept" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDept(@RequestParam("deptId") int deptId) {

		Info info = new Info();

		try {
			int delete = deptRepo.deleteDept(deptId);

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

	@RequestMapping(value = { "/deleteMultiDept" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiDept(@RequestParam("deptIds") List<Integer> deptIds) {

		Info info = new Info();

		try {
			int delete = deptRepo.deleteMultiDept(deptIds);

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

	// ----------------------------------------Plant----------------------------------------------------

	@RequestMapping(value = { "/savePlant" }, method = RequestMethod.POST)
	public @ResponseBody Plant savePlant(@RequestBody Plant plant) {

		Plant res = new Plant();

		try {

			res = plantRepo.saveAndFlush(plant);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/saveUniquePlant" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniquePlant(@RequestParam("plantName") String plantName) {
		Plant res = new Plant();
		Info info = new Info();

		try {

			res = plantRepo.findByPlantNameAndDelStatus(plantName, 1);

			if (res == null) {

				info.setError(false);
				info.setMessage("New Plant");

			} else {
				info.setError(true);
				info.setMessage("Plant Already Exist");

			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getAllPlantList" }, method = RequestMethod.GET)
	public @ResponseBody List<Plant> getAllPlantList() {

		List<Plant> plantList = new ArrayList<Plant>();

		try {

			plantList = plantRepo.findByDelStatusOrderByPlantIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return plantList;

	}

	@RequestMapping(value = { "/getAllCompanyPlantList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetPlant> getAllCompanyPlantList() {

		List<GetPlant> plantList = new ArrayList<GetPlant>();

		try {

			plantList = getPlantRepo.getAllPlantList();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return plantList;

	}

	@RequestMapping(value = { "/getPlantByPlantId" }, method = RequestMethod.POST)
	public @ResponseBody Plant getPlantByPlantId(@RequestParam("plantId") int plantId) {

		Plant plant = new Plant();

		try {
			plant = plantRepo.findByPlantIdAndDelStatus(plantId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return plant;

	}

	@RequestMapping(value = { "/getPlantListByCompanyId" }, method = RequestMethod.POST)
	public @ResponseBody List<Plant> getPlantListByCompanyId(@RequestParam("companyId") int companyId) {

		List<Plant> plantList = new ArrayList<>();

		try {
			plantList = plantRepo.findByCompanyIdAndDelStatus(companyId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return plantList;

	}

	@RequestMapping(value = { "/getPlantCompanyByPlantId" }, method = RequestMethod.POST)
	public @ResponseBody GetPlant getPlantCompanyByPlantId(@RequestParam("plantId") int plantId) {

		GetPlant plant = new GetPlant();

		try {
			plant = getPlantRepo.getPlantByPlantId(plantId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return plant;

	}

	@RequestMapping(value = { "/deletePlant" }, method = RequestMethod.POST)
	public @ResponseBody Info deletePlant(@RequestParam("plantId") int plantId) {

		Info info = new Info();

		try {
			int delete = plantRepo.deletePlant(plantId);

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

	@RequestMapping(value = { "/deleteMultiPlant" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiPlant(@RequestParam("plantIds") List<Integer> plantIds) {

		Info info = new Info();

		try {
			int delete = plantRepo.deleteMultiPlant(plantIds);

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
	// ----------------------------------------Project----------------------------------------------------

	@RequestMapping(value = { "/saveProject" }, method = RequestMethod.POST)
	public @ResponseBody Project saveProject(@RequestBody Project project) {

		Project res = new Project();

		try {

			res = projectRepo.saveAndFlush(project);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllProjectList" }, method = RequestMethod.GET)
	public @ResponseBody List<Project> getAllProjectList() {

		List<Project> proList = new ArrayList<Project>();

		try {

			proList = projectRepo.findByDelStatusOrderByProjIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return proList;

	}

	@RequestMapping(value = { "/getAllProList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetProject> getAllProList() {

		List<GetProject> proList = new ArrayList<GetProject>();

		try {

			proList = getProjectRepo.getAllProList();
			for (int i = 0; i < proList.size(); i++) {
				proList.get(i).setStartDate(DateConvertor.convertToDMY(proList.get(i).getStartDate()));
				proList.get(i).setEndDate(DateConvertor.convertToDMY(proList.get(i).getEndDate()));
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return proList;

	}

	@RequestMapping(value = { "/getProjectByProjId" }, method = RequestMethod.POST)
	public @ResponseBody Project getProjectByProjId(@RequestParam("projId") int projId) {

		Project project = new Project();

		try {
			project = projectRepo.findByProjIdAndDelStatus(projId, 1);
			project.setStartDate(DateConvertor.convertToDMY(project.getStartDate()));
			project.setEndDate(DateConvertor.convertToDMY(project.getEndDate()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return project;

	}

	@RequestMapping(value = { "/getProjectByCustId" }, method = RequestMethod.POST)
	public @ResponseBody List<Project> getProjectByCustId(@RequestParam("custId") int custId) {

		List<Project> projList = new ArrayList<>();

		try {
			projList = projectRepo.findByCustIdAndDelStatus(custId, 1);

		} catch (Exception e) {
			System.err.println(" Exce in getting project by /getProjectByCustId " + e.getMessage());

			e.printStackTrace();

		}
		return projList;

	}

	@RequestMapping(value = { "/deleteProject" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteProject(@RequestParam("projId") int projId) {

		Info info = new Info();

		try {
			int delete = projectRepo.deleteProject(projId);

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

	@RequestMapping(value = { "/deleteMultiProject" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiProject(@RequestParam("projIds") List<Integer> projIds) {

		Info info = new Info();

		try {
			int delete = projectRepo.deleteMultiProject(projIds);

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

	// ----------------------------------------Item----------------------------------------------------

	@RequestMapping(value = { "/saveItem" }, method = RequestMethod.POST)
	public @ResponseBody Item saveItem(@RequestBody Item item) {

		Item res = new Item();

		try {

			res = itemRepo.saveAndFlush(item);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getItemList" }, method = RequestMethod.GET)
	public @ResponseBody List<Item> getItemList() {

		List<Item> itemList = new ArrayList<Item>();

		try {

			itemList = itemRepo.findByDelStatusOrderByItemIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/getItemByItemId" }, method = RequestMethod.POST)
	public @ResponseBody Item getItemByItemId(@RequestParam("itemId") int itemId) {

		Item item = new Item();

		try {
			item = itemRepo.findByItemIdAndDelStatus(itemId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return item;

	}

	// sachin 3 nov
	@RequestMapping(value = { "/getItemsByPlantId" }, method = RequestMethod.POST)
	public @ResponseBody List<Item> getItemByPlantId(@RequestParam("plantId") int plantId) {

		List<Item> itemList = new ArrayList<>();

		try {

			itemList = itemRepo.findByPlantIdAndDelStatusOrderByItemIdDesc(plantId, 1);

		} catch (Exception e) {

			System.err.println("exe in getting  getItemsByPlantId " + e.getMessage());

			e.printStackTrace();

		}

		return itemList;

	}

	@RequestMapping(value = { "/getAllItemList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetItem> getAllItemList() {

		List<GetItem> itemList = new ArrayList<GetItem>();

		try {

			itemList = getItemRepo.getAllItemList();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/getItemByItemIdWithName" }, method = RequestMethod.POST)
	public @ResponseBody GetItem getItemByItemIdWithName(@RequestParam("itemId") int itemId) {

		GetItem item = new GetItem();

		try {
			item = getItemRepo.getItemByItemId(itemId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return item;

	}

	@RequestMapping(value = { "/getGetItemsByPlantId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetItem> getGetItemByPlantId(@RequestParam("plantId") int plantId) {

		List<GetItem> itemList = new ArrayList<>();

		try {
			itemList = getItemRepo.getItemByPlantId(plantId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return itemList;

	}

	@RequestMapping(value = { "/deleteItem" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteItem(@RequestParam("itemId") int itemId) {

		Info info = new Info();

		try {
			int delete = itemRepo.deleteItem(itemId);

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

	@RequestMapping(value = { "/deleteMultiItem" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiItem(@RequestParam("itemIds") List<Integer> itemIds) {

		Info info = new Info();

		try {
			int delete = itemRepo.deleteMultiItem(itemIds);

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

	// -------------------------------------MarketingUser----------------------------

	@RequestMapping(value = { "/saveMarketingUser" }, method = RequestMethod.POST)
	public @ResponseBody MarketingUser saveMarketingUser(@RequestBody MarketingUser marketingUser) {

		MarketingUser res = new MarketingUser();

		try {

			res = marketingUserRepo.saveAndFlush(marketingUser);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getMarketingUserByMUserId" }, method = RequestMethod.POST)
	public @ResponseBody MarketingUser getMarketingUserByMUserId(@RequestParam("markUsrId") int markUsrId) {

		MarketingUser mu = new MarketingUser();

		try {
			mu = marketingUserRepo.findByMarkUsrIdAndDelStatus(markUsrId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return mu;

	}

	@RequestMapping(value = { "/getAllMUList" }, method = RequestMethod.GET)
	public @ResponseBody List<MarketingUser> getAllMUList() {

		List<MarketingUser> muList = new ArrayList<MarketingUser>();

		try {

			muList = marketingUserRepo.findByDelStatusOrderByMarkUsrIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return muList;

	}

	@RequestMapping(value = { "/deleteMarketingUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMarketingUser(@RequestParam("markUsrId") int markUsrId) {

		Info info = new Info();

		try {
			int delete = marketingUserRepo.deleteMarketingUser(markUsrId);

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

	@RequestMapping(value = { "/deleteMultiMarketingUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiMarketingUser(@RequestParam("itemIds") List<Integer> itemIds) {

		Info info = new Info();

		try {
			int delete = marketingUserRepo.deleteMultiMarketingUser(itemIds);

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

	@Autowired
	TaskRepo objTaskrepo;

	@Autowired
	TaxRepo objTaxrepo;

	// sumit 1
	// ----------------------------------------Tax----------------------------------------------------

	@RequestMapping(value = { "/saveTax" }, method = RequestMethod.POST)
	public @ResponseBody Tax saveTax(@RequestBody Tax objTaxParam) {

		Tax objTAx = new Tax();

		try {

			objTAx = objTaxrepo.saveAndFlush(objTaxParam);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return objTAx;

	}

	@RequestMapping(value = { "/saveUniqueTax" }, method = RequestMethod.POST)
	public @ResponseBody Info saveUniqueTax(@RequestParam("hsnCode") String hsnCode) {
		Tax res = new Tax();

		Info info = new Info();

		try {

			res = objTaxrepo.findByHsnCodeAndDelStatus(hsnCode, 1);

			if (res == null) {

				info.setError(false);
				info.setMessage("New Tax");

			} else {
				info.setError(true);
				info.setMessage("Tax Already Exist");

			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" In Exception");

		}
		return info;

	}

	@RequestMapping(value = { "/getTaxByTaxId" }, method = RequestMethod.POST)
	public @ResponseBody Tax getTaxByTaxId(@RequestParam("taxId") int taxId) {

		Tax tax = new Tax();

		try {
			tax = objTaxrepo.findByTaxIdAndDelStatus(taxId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return tax;

	}

	// sumit 2
	@RequestMapping(value = { "/getTaxList" }, method = RequestMethod.GET)
	public @ResponseBody List<Tax> getTAxList() {

		List<Tax> taxList = new ArrayList<Tax>();

		try {

			taxList = objTaxrepo.findByDelStatusOrderByTaxIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return taxList;

	}

	// sumit 3
	@RequestMapping(value = { "/deleteTax" }, method = RequestMethod.POST)
	public @ResponseBody void deleteTax(@RequestParam("taxId") int taxId) {

		Info info = new Info();

		try {
			int delete = objTaxrepo.deleteTax(taxId);

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

	}

	@RequestMapping(value = { "/deleteMultiTax" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiTax(@RequestParam("taxIds") List<Integer> taxIds) {

		Info info = new Info();

		try {
			int delete = objTaxrepo.deleteMultiTax(taxIds);

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

	// ----------------------------------------Task----------------------------------------------------
	// sumit 4
	@RequestMapping(value = { "/saveTask" }, method = RequestMethod.POST)
	public @ResponseBody Task saveTask(@RequestBody Task objTaskParam) {

		Task objTask = new Task();

		try {

			objTask = objTaskrepo.saveAndFlush(objTaskParam);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return objTask;

	}

	// sumit 5
	@RequestMapping(value = { "/getTaskList" }, method = RequestMethod.GET)
	public @ResponseBody List<Task> getTaskList() {

		List<Task> taskList = new ArrayList<Task>();

		try {

			taskList = objTaskrepo.findByDelStatusOrderByTaskIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return taskList;

	}
	// sumit 6

	@RequestMapping(value = { "/deleteTask" }, method = RequestMethod.POST)
	public @ResponseBody void deleteTask(@RequestParam("TaskId") int taskId) {

		Info info = new Info();

		try {
			// int delete = objTaxrepo.deleteTax(taxId);
			objTaskrepo.deleteById(taskId);

			// if (delete == 1) {
			// info.setError(false);
			// info.setMessage("successfully Deleted");
			// } else {
			// info.setError(true);
			// info.setMessage(" Deleted to Delete");
			// }

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}

	}

	// ---------- User Login--------------------

	@RequestMapping(value = { "/loginUser" }, method = RequestMethod.POST)
	public @ResponseBody LoginResUser loginUser(@RequestParam("usrMob") String usrMob,
			@RequestParam("userPass") String userPass) {

		LoginResUser loginResponse = new LoginResUser();
		try {

			User mu = userRepo.findByUsrMobAndUserPassAndDelStatus(usrMob, userPass, 1);
			if (mu == null) {
				loginResponse.setError(true);
				loginResponse.setMsg("login Failed");
			} else {
				loginResponse.setError(false);
				loginResponse.setMsg("login successfully");
				loginResponse.setUser(mu);
			}

		} catch (Exception e) {

			e.printStackTrace();
			loginResponse.setError(true);
			loginResponse.setMsg("login Failed");
		}

		return loginResponse;
	}

	
	


}
