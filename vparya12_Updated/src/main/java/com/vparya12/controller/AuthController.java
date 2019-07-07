package com.vparya12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vparya12.bean.*;
import com.vparya12.common.AjaxResponseBody;
import com.vparya12.common.TrackerException;
import com.vparya12.service.*;

@Controller
public class AuthController {

	@Autowired
	MobileService mobileService;
	
	@Autowired
	DthService dthService;
	
	@Autowired
	SignupService signupService;
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage()throws TrackerException {
		ModelAndView model = new ModelAndView("welcome");
		try {
			List<Dth> dthList = dthService.getDTHDetails();
			List<Mobile> mobileList = mobileService.getMobileDetails();
			model.addObject("mobileList", mobileList);
			model.addObject("dthList", dthList);
			return model;
		}catch(TrackerException ex) {
			model.addObject("err", ex.getProperMsg());
			return model;
		}

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout){
		ModelAndView model = new ModelAndView("welcome");
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		if(logout==null || logout=="") {
			model.addObject("login", "login");
		}
		try {
			List<Dth> dthList = dthService.getDTHDetails();
			List<Mobile> mobileList = mobileService.getMobileDetails();
			model.addObject("mobileList", mobileList);
			model.addObject("dthList", dthList);
			return model;
		}catch(TrackerException ex) {
			model.addObject("msg", ex.getProperMsg());
			return model;
		}
	}
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public @ResponseBody AjaxResponseBody login(@RequestParam(value = "error", required = false) String error,
//			@RequestParam(value = "logout", required = false) String logout) {
//		AjaxResponseBody ajaxResp = new AjaxResponseBody();
//		if (error != null) {
//			ajaxResp.setData("Invalid username and password!");
//			ajaxResp.setSession(false);
//		}
//		if (logout != null) {
//			ajaxResp.setData("You've been logged out successfully.");
//			ajaxResp.setSession(true);
//		}
//		ajaxResp.setSuccess();
//		return ajaxResp;
//
//	}
	
	/*
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView lougout() {
		List<Mobile> mobileList = mobileService.getMobileDetails();
		List<Dth> dthList = dthService.getDTHDetails();
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("mobileList", mobileList);
		model.addObject("dthList", dthList);
		model.addObject("msg", "You've been logged out successfully.");
		return model;
	}*/
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("403");
		return model;

	}
	/*
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("signup", "signup");
		return model;
	}
	*/
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public @ResponseBody AjaxResponseBody processSignupRequest(@RequestBody User user) {
		AjaxResponseBody resp = new AjaxResponseBody();
		try {
			boolean result = signupService.processSignup(user);
			if(result) {
				resp.setSuccess();
				resp.setData("You've been registered successfully!");
			}else {
				resp.setFailure();
				resp.setData("Unable to signup!");
			}
			return resp;
			
		}catch(Exception ex) {
			resp.setFailure();
			resp.setData("Unable to signup!");
			return resp;
		}
	}
	
	
}
