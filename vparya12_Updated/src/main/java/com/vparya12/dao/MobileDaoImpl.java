package com.vparya12.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.vparya12.bean.Mobile;
import com.vparya12.common.Constant;
import com.vparya12.common.TrackerException;

@Component
public class MobileDaoImpl implements MobileDao{
	
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public MobileDaoImpl(DataSource dataSource) {
		namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	//Mobile Row Mapper
	private class MobileMapper implements RowMapper<Mobile> {
		public Mobile mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	Mobile mobile = new Mobile();
			
			mobile.setMobileNumber(rs.getLong("MOBILENUMBER"));
			mobile.setAlternativeNumber(rs.getLong("ALTNUMBER"));
			mobile.setNetwork(rs.getString("NETWORK"));
			mobile.setUserName(rs.getString("USERNAME"));
			mobile.setLastRechargedDate(rs.getDate("RECHARGEDATE"));
			mobile.setRechargeAmount(rs.getInt("AMOUNT"));
			mobile.setBalance(rs.getInt("BALANCE"));
			mobile.setValidDays(rs.getInt("VALADITY"));
			mobile.setRemainingDays(rs.getInt("LEFTDAYS"));
			mobile.setNextRechargeDate(rs.getDate("NEXTRECHARGEDATE"));
			mobile.setId(rs.getInt("ID"));
			
			return mobile;
    	}
	}

	//Get Mobile Balance
	public Integer getMobileBalance(Integer id) throws TrackerException{
		HashMap<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("ID", id);
		try {
			return namedParameterJdbcTemplate.queryForInt(Constant.GET_MOBILE_BALANCE, parameter);
		}catch(Exception ex) {
			throw new TrackerException("Error in fetching mobile balance", ex.getMessage());
		}
	}
	
	//Get Mobile Details
	public List<Mobile> getMobileDetails() throws TrackerException{
		
		List<Mobile> mobileList = namedParameterJdbcTemplate.query(Constant.GET_ALL_MOBILE_NUMBER, new HashMap<String,Object>(), new MobileMapper());
		return mobileList;
		/*List<Mobile> mobileList = null;namedParameterJdbcTemplate.query(Constant.GET_ALL_MOBILE_NUMBER, new HashMap<String,Object>(), rs -> {
			List<MobileDetails> mobileLists = new ArrayList<MobileDetails>();
			if(rs!=null) {
				while(rs.next()) {
					MobileDetails mobile = new MobileDetails();
					
					mobile.setMobileNumber(rs.getLong("MOBILENUMBER"));
					mobile.setAlternativeNumber(rs.getLong("ALTNUMBER"));
					mobile.setNetwork(rs.getString("NETWORK"));
					mobile.setUserName(rs.getString("USERNAME"));
					mobile.setLastRechargedDate(rs.getDate("RECHARGEDATE"));
					mobile.setLastRechargedAmount(rs.getInt("AMOUNT"));
					mobile.setPayment(rs.getBoolean("PAYMENT"));
					mobile.setValidDays(rs.getInt("VALADITY"));
					mobile.setRemainingDays(rs.getInt("LEFTDAYS"));
					mobile.setNextRechargeDate(rs.getDate("NEXTRECHARGEDATE"));
					mobile.setId(rs.getInt("ID"));
					
					mobileLists.add(mobile);
				}
			}
			return mobileLists;
		});
		return mobileList;*/
	}

	//Save New Mobile Details
	public boolean newMobileDetails(Mobile mobileVo) throws TrackerException{
		try {
			HashMap<String,Object> parameter = new HashMap<String,Object>();
			parameter.put("MOBILENUMBER", mobileVo.getMobileNumber());
			parameter.put("NETWORK", mobileVo.getNetwork());
			parameter.put("USERNAME", mobileVo.getUserName());
			parameter.put("VALADITY", mobileVo.getValidDays());
			parameter.put("ALTNUMBER", mobileVo.getAlternativeNumber());
			parameter.put("AMOUNT", mobileVo.getRechargeAmount());
			parameter.put("BALANCE", mobileVo.getBalance());
			
			int result = namedParameterJdbcTemplate.update(Constant.INSERT_NEW_MOBILE, parameter);
			if(result==1) {
				return true;
			}else {
				return false;
			}
		}catch(Exception ex) {
			throw new TrackerException("Fail to create new record due to database failure!", ex.getMessage());
		}
	}
	
	//Update Mobile Details
	public boolean updateMobileNumber(Mobile mobileVo) throws TrackerException{
		try {
			HashMap<String,Object> parameter = new HashMap<String,Object>();
			//parameter.put("MOBILENUMBER", mobileVo.getMobileNumber());
			parameter.put("NETWORK", mobileVo.getNetwork());
			//parameter.put("USERNAME", mobileVo.getUserName());
			parameter.put("ALTNUMBER", mobileVo.getAlternativeNumber());
			parameter.put("VALADITY", mobileVo.getValidDays());
			parameter.put("AMOUNT", mobileVo.getRechargeAmount());
			parameter.put("BALANCE", mobileVo.getBalance());
			parameter.put("ID", mobileVo.getId());
			
			int result = namedParameterJdbcTemplate.update(Constant.UPDATE_MOBILE, parameter);
			if(result==1) {
				return true;
			}else {
				return false;
			}
		}catch(Exception ex) {
			throw new TrackerException("Fail to update record due to database failure!", ex.getMessage());
		}
	}

	//Delete Mobile Details
	public boolean deleteMobileNumber(Mobile mobileDetails)throws TrackerException {
		try {
			return false;
		}catch(Exception ex) {
			throw new TrackerException("Fail to delete record due to database failure!", ex.getMessage());
		}
		
	}

	//Rechare Mobile
	public boolean rechargeMobileNumber(Mobile mobileVo) throws TrackerException{
		try {
			HashMap<String,Object> parameter = new HashMap<String,Object>();
			parameter.put("VALADITY", mobileVo.getValidDays());
			parameter.put("AMOUNT", mobileVo.getRechargeAmount());
			parameter.put("PAYMENT", mobileVo.getBalance());
			parameter.put("ID", mobileVo.getId());
			
			int result = namedParameterJdbcTemplate.update(Constant.RECHARGE_MOBILE, parameter);
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
