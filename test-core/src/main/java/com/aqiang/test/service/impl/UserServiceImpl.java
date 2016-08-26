package com.aqiang.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aqiang.test.dao.Dao;
import com.aqiang.test.entities.User;
import com.aqiang.test.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<User> implements UserService {

	@Resource(name = "userDao")
	@Override
	public void setDao(Dao<User> dao) {
		this.dao = dao;
	}

}
