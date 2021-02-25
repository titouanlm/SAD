package com.example.transactionscript.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.money.MonetaryAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.transactionscript.helper.DollarHelper;
import com.example.transactionscript.script.RevenueRecognitionScript;

@Controller
public class ScriptController {

	@Autowired
	RevenueRecognitionScript script;
	
	@Autowired
	DollarHelper dollarHelper;

	@RequestMapping(path = "/addContract", method = RequestMethod.GET)
	public String addContract(@RequestParam int pid, @RequestParam int price, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateSigned ) {

		MonetaryAmount priceConverted = dollarHelper.dollars(price);
		
		int contractId = script.insertContractInformation(pid, priceConverted, dateSigned);
	
		script.calculateRevenueRecognitions(contractId);
		
		return "redirect:/check";
	}
	
	@RequestMapping(path = "/checkRecognizedRevenue", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView checkRecognizedRevenue(@RequestParam int cid, @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate asOf ) {

		MonetaryAmount recognizedRevenue = script.recognizedRevenue(cid, asOf);
		BigDecimal revenue = recognizedRevenue.getNumber().numberValue(BigDecimal.class)
		.setScale(recognizedRevenue.getCurrency().getDefaultFractionDigits());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("revenue", revenue);
		map.put("date", asOf);
		ModelAndView mv = new ModelAndView("showrr.jsp", "data", map);
		
		return mv;
	}
	
}