package com.vparya12.common;

import org.springframework.util.StringUtils;

import com.vparya12.bean.*;

public class ValidateObject {
	/*
	public static boolean verifySignupData(User user) {
		boolean valid = true;
		if(user.getUserName()==null || user.getUserName()=="" || StringUtils.isEmpty(user.getUserName())) {
			valid=false;
		}
		if(StringUtils.isEmpty(user.getMobileNumber())) {
			valid=false;
		}
		if(StringUtils.isEmpty(user.getEmailId()) || user.getEmailId()==null) {
			valid=false;
		}
		if(StringUtils.isEmpty(user.getPassword()) || user.getPassword()=="" || user.getPassword()==null || user.getPassword().length()<8) {
			valid=false;
		}
		if(!"Male".equalsIgnoreCase(user.getGender()) || !"Female".equalsIgnoreCase(user.getGender())) {
			valid=false;
		}
		return valid;
	}
	
	public static boolean verifyLoginData(User user) {
		boolean valid = true;
		if(StringUtils.isEmpty(user.getEmailId()) || user.getEmailId()==null) {
			valid=false;
		}
		if(StringUtils.isEmpty(user.getPassword()) || user.getPassword()=="" || user.getPassword()==null || user.getPassword().length()<8) {
			valid=false;
		}
		return valid;
	}
*/
}
