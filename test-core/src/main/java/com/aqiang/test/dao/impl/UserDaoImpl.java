package com.aqiang.test.dao.impl;

import org.springframework.stereotype.Repository;

import com.aqiang.test.dao.UserDao;
import com.aqiang.test.entities.User;

@Repository("userDao")
public class UserDaoImpl extends DaoImpl<User> implements UserDao {

}
