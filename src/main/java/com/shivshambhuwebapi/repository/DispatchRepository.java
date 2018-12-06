package com.shivshambhuwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shivshambhuwebapi.model.DispatchItems;

@Repository
public interface DispatchRepository extends JpaRepository<DispatchItems, Integer>{

	@Query(value="select d.order_det_id,d.item_id,i.item_code,i.item_name,SUM(d.order_qty) as qty,SUM(d.rem_ord_qty) as rem_qty from t_order_detail d,t_order_header h,m_item_fg i where d.order_id=h.order_id and  h.delivery_date=:date and h.plant_id=:plantId and i.item_id=d.item_id and h.del_status=1 group by d.item_id order by d.item_id",nativeQuery=true)
	List<DispatchItems> getDispatchList(@Param("plantId")int plantId,@Param("date") String date);

}
