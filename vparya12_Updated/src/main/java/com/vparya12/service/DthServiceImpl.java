package com.vparya12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vparya12.bean.Dth;
import com.vparya12.common.TrackerException;
import com.vparya12.dao.DthDao;

@Service
public class DthServiceImpl implements DthService {

	@Autowired
	DthDao dthDao;

	//To Fetch All active Dth Details
	public List<Dth> getDTHDetails() throws TrackerException {
		List<Dth> dthList = dthDao.getDTHDetails();
		return dthList;
	}
	
	//To save a new DTH Details
	public boolean newDthDetails(Dth dth) throws TrackerException {
		Integer packAmount =(( dth.getRechargeAmount() != null ) ? dth.getRechargeAmount() : 0 );
		Integer paidAmount = (( dth.getPaidBalance() != null ) ? dth.getPaidBalance() : 0 );
		dth.setBalance(paidAmount-packAmount);
		if(dth.getAlternativeNumber() == null) {
			dth.setAlternativeNumber(0L);
		}
		boolean flag = dthDao.newDthDetails(dth);
		return flag;
	}

	//To Update Registered Dth Details
	public boolean updateDTHNumber(Dth dth)throws TrackerException  {
		//Integer oldBalance = dthDao.getDthBalance(dth.getId());
		Integer packAmount =(( dth.getRechargeAmount() != null ) ? dth.getRechargeAmount() : 0 );
		Integer paidAmount = (( dth.getPaidBalance() != null ) ? dth.getPaidBalance() : 0 );
		Integer prevoiusBalance = (( dth.getBalance() != null ) ? dth.getBalance() : 0 );
		dth.setBalance((paidAmount+prevoiusBalance)-packAmount);
		return dthDao.updateDTHNumber(dth);
		
	}

	//To Delete 
	public boolean deleteDTHNumber(Dth dthDetails)throws TrackerException  {
		return false;
	}

	//To Recharge Dth Number
	public boolean rechargeDTHNumber(Dth dth)throws TrackerException  {
		return dthDao.rechargeDTHNumber(dth);
	}


}
