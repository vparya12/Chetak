package com.vparya12.service;

import java.util.List;

import com.vparya12.bean.Dth;
import com.vparya12.common.TrackerException;

public interface DthService {
	
	public boolean newDthDetails(Dth dthVO)throws TrackerException ;
	
	public List<Dth> getDTHDetails()throws TrackerException;
	
	public boolean updateDTHNumber(Dth dth)throws TrackerException ;
	
	public boolean rechargeDTHNumber(Dth dth)throws TrackerException ;
	
	public boolean deleteDTHNumber(Dth dth)throws TrackerException ;
}
