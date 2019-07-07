package com.vparya12.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.vparya12.bean.Dth;
import com.vparya12.common.Constant;
import com.vparya12.common.TrackerException;
@Component
public class DthDaoImpl implements DthDao {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	//DTH Mapper
	private class DthMapper implements RowMapper<Dth> {
		public Dth mapRow(ResultSet rs, int rowNum) throws SQLException {
			Dth dth = new Dth();
			dth.setDthNumber(rs.getLong("DTHNUMBER"));
			dth.setMobileNumber(rs.getLong("MOBILENUMBER"));
			dth.setLastRechargedDate(rs.getDate("RECHARGEDATE"));
			dth.setNetwork(rs.getString("NETWORK"));
			dth.setBalance(rs.getInt("BALANCE"));
			dth.setUserName(rs.getString("USERNAME"));
			dth.setValidDays(rs.getInt("VALADITY"));
			dth.setRechargeAmount(rs.getInt("AMOUNT"));
			dth.setRemainingDays(rs.getInt("LEFTDAYS"));
			dth.setNextRechargeDate(rs.getDate("NEXTRECHARGEDATE"));
			dth.setId(rs.getInt("ID"));
			
			return dth;
    	}
	}
	//Get Dth Balance
	public Integer getDthBalance(Integer id) throws TrackerException{
		HashMap<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("ID", id);
		try {
			return namedParameterJdbcTemplate.queryForInt(Constant.GET_DTH_BALANCE, parameter);
		}catch(Exception ex) {
			throw new TrackerException("Error in fetching dth balance", ex.getMessage());
		}
	}
	
	//Get All DTH 
	public List<Dth> getDTHDetails() throws TrackerException {
		try{
			List<Dth> dthList = namedParameterJdbcTemplate.query(Constant.GET_ALL_DTH_NUMBER, new HashMap<String,Object>(), new DthMapper());
			return dthList;
		}catch(Exception ex) {
			throw new TrackerException("Please check databse connection!",ex.getMessage());
		}
		//Java 8 coding
		/*List<DTHDetails> dthList = namedParameterJdbcTemplate.query(Constant.GET_ALL_DTH_NUMBER, new HashMap<String,Object>(), rs -> {
			List<DTHDetails> dth_List = new ArrayList<>();
			if(rs!=null) {
				while(rs.next()) {
					DTHDetails dth = new DTHDetails();
					dth.setDthNumber(rs.getLong("DTHNUMBER"));
					dth.setMobileNumber(rs.getLong("MOBILENUMBER"));
					dth.setAlternativeNumber(rs.getLong("ALTNUMBER"));
					dth.setLastRechargedDate(rs.getDate("RECHARGEDATE"));
					dth.setNetwork(rs.getString("NETWORK"));
					dth.setPayment(rs.getBoolean("PAYMENT"));
					dth.setUserName(rs.getString("USERNAME"));
					dth.setValidDays(rs.getInt("VALADITY"));
					dth.setLastRechargedAmount(rs.getInt("AMOUNT"));
					dth.setRemainingDays(rs.getInt("LEFTDAYS"));
					dth.setNextRechargeDate(rs.getDate("NEXTRECHARGEDATE"));
					dth.setId(rs.getInt("ID"));
					
					dth_List.add(dth);
				}
			}
			return dth_List;
			
		});
		return dthList;*/
	}
	
	//Save New Dth
	public boolean newDthDetails(Dth dthVO)throws TrackerException {
		try {
			HashMap<String,Object> parameter = new HashMap<String,Object>();
			parameter.put("DTHNUMBER", dthVO.getDthNumber());
			parameter.put("MOBILENUMBER", dthVO.getMobileNumber());
			parameter.put("NETWORK", dthVO.getNetwork());
			parameter.put("USERNAME", dthVO.getUserName());
			parameter.put("ALTNUMBER", dthVO.getAlternativeNumber());
			parameter.put("VALADITY", dthVO.getValidDays());
			parameter.put("AMOUNT", dthVO.getRechargeAmount());
			parameter.put("ALTNUMBER", dthVO.getAlternativeNumber());
			parameter.put("BALANCE", dthVO.getBalance());
			int resultMobile = namedParameterJdbcTemplate.update(Constant.INSERT_NEW_MOBILE_FOR_DTH, parameter);
			if(resultMobile==1) {
				int result = namedParameterJdbcTemplate.update(Constant.INSERT_NEW_DTH, parameter);
				if(result==1) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}catch(Exception ex) {
			throw new TrackerException("Fail to create new record due to database failure!", ex.getMessage());
		}
	}
	
	//Update Dth
	public boolean updateDTHNumber(Dth dthVO)throws TrackerException {
		try{
			HashMap<String,Object> parameter = new HashMap<String,Object>();
			parameter.put("DTHNUMBER", dthVO.getDthNumber());
			parameter.put("MOBILENUMBER", dthVO.getMobileNumber());
			parameter.put("NETWORK", dthVO.getNetwork());
			//parameter.put("USERNAME", dthVO.getUserName());
			//parameter.put("ALTNUMBER", dthVO.getAlternativeNumber());
			parameter.put("VALADITY", dthVO.getValidDays());
			parameter.put("AMOUNT", dthVO.getRechargeAmount());
			parameter.put("BALANCE", dthVO.getBalance());
			//parameter.put("ID", dthVO.getId());
			
			int result = namedParameterJdbcTemplate.update(Constant.UPDATE_DTH, parameter);
			if(result==1) {
				return true;
			}else {
				return false;
			}
		}catch(Exception ex) {
			throw new TrackerException("Fail to update record due to database failure!", ex.getMessage());
		}
		
	}

	//Delete Dth
	public boolean deleteDTHNumber(Dth dth)throws TrackerException {
		try{
			return false;
		}catch(Exception ex) {
			throw new TrackerException("Fail to delete record due to database failure!", ex.getMessage());
		}
		
	}

	//Recharge Dth
	public boolean rechargeDTHNumber(Dth dthVO)throws TrackerException {
		try {
			HashMap<String,Object> parameter = new HashMap<String,Object>();
			parameter.put("VALADITY", dthVO.getValidDays());
			parameter.put("AMOUNT", dthVO.getRechargeAmount());
			parameter.put("BALANCE", dthVO.getBalance());
			parameter.put("ID", dthVO.getId());
			
			int result = namedParameterJdbcTemplate.update(Constant.RECHARGE_DTH, parameter);
			if(result==1) {
				return true;
			}else {
				return false;
			}
		}catch(Exception ex) {
			throw new TrackerException("Recharge failed due to database failure!", ex.getMessage());
		}
		
	}
}
