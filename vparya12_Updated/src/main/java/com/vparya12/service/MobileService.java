package com.vparya12.service;

import java.util.List;

import com.vparya12.bean.Mobile;
import com.vparya12.common.TrackerException;

public interface MobileService {
	public boolean newMobileDetails(Mobile mobile)throws TrackerException;
	
	public List<Mobile> getMobileDetails()throws TrackerException;
	
	public boolean updateMobileNumber(Mobile mobile)throws TrackerException;
	
	public boolean rechargeMobileNumber(Mobile mobile)throws TrackerException;
	
	public boolean deleteMobileNumber(Mobile mobile)throws TrackerException;
}
