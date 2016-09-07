package com.aqiang.test;

import com.aqiang.test.service.SpecialtyService;
import com.aqiang.test.service.StudentService;
import com.aqiang.test.service.UserService;

@ContextConfiguration(locations = { "classpath:beans.xml", "classpath:beans-jpa-h2.xml" })
public class CoreTest extends AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	protected UserService userService;
	@Autowired
	protected StudentService studentService;
	@Autowired
	protected SpecialtyService specialtyService;
}
