package com.aqiang.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = { "classpath:beans.xml",
		"classpath:beans-jpa-h2.xml" })
public class CoreTest extends AbstractTransactionalTestNGSpringContextTests {

	@Test
	public void test() {

	}
}
