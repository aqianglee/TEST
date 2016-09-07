package com.aqiang.test.service.impl;

import org.testng.annotations.Test;

import com.aqiang.test.CoreTest;
import com.aqiang.test.entities.User;

public class UserServiceImplTest extends CoreTest {

	@Test
	public void test() {
		User user = new User();
		user.setName("kyo");
		userService.save(user);
	}

}
