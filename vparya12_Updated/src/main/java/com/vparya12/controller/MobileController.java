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

import com.vparya12.bean.Mobile;
import com.vparya12.common.AjaxResponseBody;
import com.vparya12.common.TrackerException;
import com.vparya12.service.MobileService;


@Controller
public class MobileController {

	@Autowired
	MobileService mobileService;
	
	@RequestMapping(value = "/mobiles", method = RequestMethod.GET)
	public ModelAndView getAllMobile() {
		ModelAndView model = new ModelAndView("mobileData");
		try {
			List<Mobile> mobileList = mobileService.getMobileDetails();
			model.addObject("mobileList", mobileList);
			return model;
		}catch(TrackerException ex) {
			model.addObject("msg", ex.getProperMsg());
			return model;
		}
	}
	
	@RequestMapping(value="/saveMobile", method=RequestMethod.POST)
	public @ResponseBody AjaxResponseBody saveMobileDetails(@RequestBody Mobile mobile) {
		AjaxResponseBody resp = new AjaxResponseBody();
		try {
			boolean saveFlag =	mobileService.newMobileDetails(mobile);
			if(saveFlag) {
				resp.setSuccess();
				resp.setData("Successfully saved Mobile number "+mobile.getMobileNumber());
			}
			else {
				resp.setFailure();
				resp.setData("Cant not able to save Mobile Number "+mobile.getMobileNumber()+". Please Try Again.");
			}
			return resp;
		}catch(TrackerException ex) {
			resp.setFailure();
			resp.setData("Cant not able to save Mobile Number "+mobile.getMobileNumber()+". Please Try Again.");
			return resp;
		}
	}
	
	@RequestMapping(value="/updateMobile", method=RequestMethod.POST)
	public @ResponseBody AjaxResponseBody updateMobileDetails(@RequestBody Mobile mobile,HttpServletRequest req) {
		AjaxResponseBody resp = new AjaxResponseBody();
		try {
			boolean saveFlag =	mobileService.updateMobileNumber(mobile);
			if(saveFlag) {
				resp.setSuccess();
				resp.setData("Successfully updated Mobile number "+mobile.getMobileNumber());
			}
			else {
				resp.setFailure();
				resp.setData("Cant not able to update Mobile Number "+mobile.getMobileNumber()+". Please Try Again.");
			}
			return resp;
		}catch(TrackerException ex) {
			resp.setFailure();
			resp.setData("Cant not able to update Mobile Number "+mobile.getMobileNumber()+". Please Try Again.");
			return resp;
		}
	}
	
	@RequestMapping(value="/rechargeMobile", method=RequestMethod.POST)
	public @ResponseBody AjaxResponseBody rechargeMobileDetails(@RequestBody Mobile mobile) {
		AjaxResponseBody resp = new AjaxResponseBody();
		try {
			boolean saveFlag =	mobileService.rechargeMobileNumber(mobile);
			if(saveFlag) {
				resp.setSuccess();
				resp.setData("Successfully rechrged Mobile number "+mobile.getMobileNumber());
			}
			else {
				resp.setFailure();
				resp.setData("Cant not able to recharge Mobile Number "+mobile.getMobileNumber()+". Please Try Again.");
			}
			return resp;
		}catch(TrackerException ex) {
			resp.setFailure();
			resp.setData("Cant not able to recharge Mobile Number "+mobile.getMobileNumber()+". Please Try Again.");
			return resp;
		}
	}
}
