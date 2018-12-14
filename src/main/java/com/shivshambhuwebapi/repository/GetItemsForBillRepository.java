package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivshambhuwebapi.model.bill.GetItemsForBill;

public interface GetItemsForBillRepository extends JpaRepository<GetItemsForBill, Integer>{

	
	@Query(value="select d.chalan_detail_id,\n" + 
			"			h.chalan_id,\n" + 
			"			h.chalan_no,\n" + 
			"			h.chalan_date,\n" + 
			"			d.item_id,\n" + 
			"			i.item_code,\n" + 
			"			i.item_name,\n" + 
			"			d.item_uom,\n" + 
			"			i.uom_id,\n" + 
			"			t.hsn_code,\n" + 
			"			d.item_qty,\n" + 
			"			od.order_rate,od.order_id,\n" + 
			"			t.cgst as cgst_per,\n" + 
			"			t.sgst as sgst_per,\n" + 
			"			t.igst as igst_per,\n" + 
			"			p.po_term_id,\n" + 
			"			p.varchar1 as delivery_term,\n" + 
			"			oh.is_tax_including\n" + 
			"			from t_chalan_detail d,t_chalan_header h,m_uom u,m_tax t,m_item_fg i,t_order_header oh,t_order_detail od,t_cust_po_header p  \n" + 
			"			where d.item_id=i.item_id and d.chalan_id=h.chalan_id and i.tax_id=t.tax_id and oh.order_id=h.order_id and oh.order_id=od.order_id and d.item_id=od.item_id and p.po_id=oh.po_id\n" + 
			"			and h.chalan_id IN (:chalanId) and d.status=1 and d.del_status=1 group by  d.chalan_detail_id ",nativeQuery=true)
	List<GetItemsForBill> getItemsForBill(@Param("chalanId")List<Integer> chalanId);

}
