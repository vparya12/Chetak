package com.vparya12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vparya12.bean.User;
import com.vparya12.dao.SignupDao;
@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	private SignupDao signupDao;
	
	public boolean processSignup(User user) throws Exception {
		return signupDao.processSignup(user);
	}

}
