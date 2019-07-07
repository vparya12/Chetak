package com.vparya12.dao;

import com.vparya12.bean.User;

public interface SignupDao {
	public boolean processSignup(User user)throws Exception;
}
