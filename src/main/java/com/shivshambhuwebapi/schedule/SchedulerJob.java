package com.shivshambhuwebapi.schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shivshambhuwebapi.master.repo.OrderHeaderRepo;

@Component
public class SchedulerJob {
	
	@Autowired
	OrderHeaderRepo orderHeaderRepo;
			
	@Scheduled(cron = "0 0 0 * * *")
	public void completePreviousOrder() {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.err.println("CRON ---------------- "+sdf.format(Calendar.getInstance().getTimeInMillis()));
		
		String date="2019-01-25";
		//String date=sdf.format(Calendar.getInstance().getTimeInMillis());
		int res=orderHeaderRepo.updateStatusDateLessThanCurrent(2, date);
		System.err.println("RESULT ---------------- "+res);
		
		
	}

}
