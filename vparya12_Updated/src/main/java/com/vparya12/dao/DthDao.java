package com.vparya12.dao;

import java.util.List;

import com.vparya12.bean.Dth;
import com.vparya12.common.TrackerException;

public interface DthDao {
	
	public Integer getDthBalance(Integer id) throws TrackerException;
	
	public boolean newDthDetails(Dth dthVO)throws TrackerException;
	
	public List<Dth> getDTHDetails() throws TrackerException;
	
	public boolean updateDTHNumber(Dth dth)throws TrackerException;
	
	public boolean rechargeDTHNumber(Dth dth)throws TrackerException;
	
	public boolean deleteDTHNumber(Dth dth)throws TrackerException;
	
}
