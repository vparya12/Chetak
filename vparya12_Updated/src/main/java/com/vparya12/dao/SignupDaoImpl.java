package com.vparya12.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.vparya12.bean.User;
import com.vparya12.common.Constant;

@Component
public class SignupDaoImpl implements SignupDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public SignupDaoImpl(DataSource dataSource) {
		namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	
	public boolean processSignup(User user) throws Exception {
		Map<String,Object> signupMap = new HashMap<String,Object>();
		signupMap.put("USERNAME", user.getUserName());
		signupMap.put("EMAIL", user.getEmailId());
		signupMap.put("PASSWORD", user.getPassword());
		signupMap.put("MOBILENUMBER", user.getMobileNumber());
		signupMap.put("GENDER", user.getGender());
		int result = namedParameterJdbcTemplate.update(Constant.SIGNUP_USER,signupMap);
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

}
