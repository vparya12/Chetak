package com.vparya12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vparya12.bean.Mobile;
import com.vparya12.common.TrackerException;
import com.vparya12.dao.MobileDao;

@Service
public class MobileServiceImpl implements MobileService{
	@Autowired
	private MobileDao mobileDao;

	
	//To Fetch All Active Mobiles
	public List<Mobile> getMobileDetails()throws TrackerException {
		List<Mobile> mobileList = mobileDao.getMobileDetails();
		return mobileList;
	}

	//To Save New Mobile Details
	public boolean newMobileDetails(Mobile mobile)throws TrackerException {
		
		Integer packAmount =(( mobile.getRechargeAmount() != null ) ? mobile.getRechargeAmount() : 0 );
		Integer paidAmount = (( mobile.getPaidBalance() != null ) ? mobile.getPaidBalance() : 0 );
		mobile.setBalance(paidAmount-packAmount);
		if(mobile.getAlternativeNumber() == null) {
			mobile.setAlternativeNumber(0L);
		}
		boolean flag = mobileDao.newMobileDetails(mobile);
		return flag;
	}
	
	//To update existing Mobile Details
	public boolean updateMobileNumber(Mobile mobile) throws TrackerException{
		//Integer oldBalance = mobileDao.getMobileBalance(mobile.getId());
		//need to impl if mobile is getting update all after creating with null 
		Integer packAmount =(( mobile.getRechargeAmount() != null ) ? mobile.getRechargeAmount() : 0 );
		Integer paidAmount = (( mobile.getPaidBalance() != null ) ? mobile.getPaidBalance() : 0 );
		Integer prevoiusBalance = (( mobile.getBalance() != null ) ? mobile.getBalance() : 0 );
		mobile.setBalance((paidAmount+prevoiusBalance)-packAmount);
		return mobileDao.updateMobileNumber(mobile);
	}

	//To Recharge The Registered Mobiles
	public boolean rechargeMobileNumber(Mobile mobile)throws TrackerException {
		return mobileDao.rechargeMobileNumber(mobile);
	}

	public boolean deleteMobileNumber(Mobile mobile)throws TrackerException {
		// TODO Auto-generated method stub
		return false;
	}
}
