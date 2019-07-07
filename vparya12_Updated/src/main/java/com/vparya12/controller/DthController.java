package com.vparya12.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vparya12.bean.Dth;
import com.vparya12.common.AjaxResponseBody;
import com.vparya12.common.TrackerException;
import com.vparya12.service.DthService;
@Controller
public class DthController {
	
	@Autowired
	DthService dthService;
	
	@RequestMapping(value = "/dths", method = RequestMethod.GET)
	public ModelAndView getAllMobile(HttpServletRequest req){
		ModelAndView model = new ModelAndView("dthData");
		try {
			List<Dth> dthList = dthService.getDTHDetails();
			model.addObject("dthList", dthList);
			return model;
		}catch(TrackerException ex) {
			model.addObject("msg", ex.getProperMsg());
			return model;
		}
	}

	@RequestMapping(value = "/saveDth", method = RequestMethod.POST)
	public @ResponseBody AjaxResponseBody saveMobileDetails(@RequestBody Dth dth) {
		AjaxResponseBody resp = new AjaxResponseBody();
		try {
			boolean saveFlag = dthService.newDthDetails(dth);
			if (saveFlag) {
				resp.setSuccess();
				resp.setData("Successfully saved Dth number " + dth.getDthNumber());
			} else {
				resp.setFailure();
				resp.setData("Cant not able to save Dth Number " + dth.getDthNumber() + ". Please Try Again.");
			}
			return resp;
		}catch(TrackerException ex) {
			resp.setFailure();
			resp.setData("Cant not able to save Dth Number " + dth.getDthNumber() + ". Please Try Again.");
			return resp;
		}
	}
	@RequestMapping(value="/updateDth", method=RequestMethod.POST)
	public @ResponseBody AjaxResponseBody updateMobileDetails(@RequestBody Dth dth) {
		AjaxResponseBody resp = new AjaxResponseBody();
		try {
			boolean saveFlag =	dthService.updateDTHNumber(dth);
			if(saveFlag) {
				resp.setSuccess();
				resp.setData("Successfully updated DTH number "+dth.getDthNumber());
			}
			else {
				resp.setFailure();
				resp.setData("Cant not able to update DTH Number "+dth.getDthNumber()+". Please Try Again.");
			}
			return resp;
		}catch(TrackerException ex) {
			resp.setFailure();
			resp.setData("Cant not able to update DTH Number "+dth.getDthNumber()+". Please Try Again.");
			return resp;
		}
	}
	
	@RequestMapping(value="/rechargeDth", method=RequestMethod.POST)
	public @ResponseBody AjaxResponseBody rechargeMobileDetails(@RequestBody Dth dth) {
		AjaxResponseBody resp = new AjaxResponseBody();
		try {
			boolean saveFlag =	dthService.rechargeDTHNumber(dth);
			if(saveFlag) {
				resp.setSuccess();
				resp.setData("Successfully recharged DTH number "+dth.getDthNumber());
			}
			else {
				resp.setFailure();
				resp.setData("Cant not able to rechare DTH Number "+dth.getDthNumber()+". Please Try Again.");
			}
			return resp;
		}catch(TrackerException ex) {
			resp.setFailure();
			resp.setData("Cant not able to rechare DTH Number "+dth.getDthNumber()+". Please Try Again.");
			return resp;
		}
	}
	
}
