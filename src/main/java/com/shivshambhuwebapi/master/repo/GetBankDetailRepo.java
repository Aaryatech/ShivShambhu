package com.shivshambhuwebapi.master.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.master.model.GetBankDetail;

public interface GetBankDetailRepo extends JpaRepository<GetBankDetail, Integer> {
	@Query(value = "SELECT b.* ,c.comp_name FROM bank_detail b ,m_company c WHERE b.del_status=1 AND c.company_id=b.company_id ORDER BY b.bank_det_id DESC", nativeQuery = true)
	List<GetBankDetail> getAllBankDetailList();

	@Query(value = "SELECT b.* ,c.comp_name FROM bank_detail b ,m_company c WHERE b.del_status=1 AND c.company_id=b.company_id AND b.company_id=:companyId ORDER BY b.bank_det_id DESC", nativeQuery = true)
	List<GetBankDetail> getAllBankDetailListByCompanyId(@Param("companyId") int companyId);

}
