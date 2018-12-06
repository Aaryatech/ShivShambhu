package com.shivshambhuwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivshambhuwebapi.master.model.GetOrder;
import com.shivshambhuwebapi.model.DispatchItems;
import com.shivshambhuwebapi.repository.DispatchRepository;

@RestController
public class DispatchController {

	@Autowired
	DispatchRepository dispatchRepository;
	

	@RequestMapping(value = { "/getDispatchList" }, method = RequestMethod.POST)
	public @ResponseBody List<DispatchItems> getDispatchList(@RequestParam("plantId") int plantId,
			@RequestParam("date") String date) {

		List<DispatchItems> getDispatchList = new ArrayList<DispatchItems>();

		try {
			System.err.println(plantId+" "+date);
			getDispatchList = dispatchRepository.getDispatchList(plantId, date);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return getDispatchList;

	}
}
