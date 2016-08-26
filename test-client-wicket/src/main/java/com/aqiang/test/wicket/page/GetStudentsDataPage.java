package com.aqiang.test.wicket.page;

import org.apache.wicket.spring.injection.annot.SpringBean;

import com.aqiang.test.service.SpecialtyService;
import com.aqiang.test.service.StudentService;
import com.aqiang.test.wicket.request.JSONRequestHandler;

public class GetStudentsDataPage extends MyPage {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private StudentService studentService;
	@SpringBean
	private SpecialtyService specialtyService;

	public GetStudentsDataPage() {
		String specialtyName = getRequest().getRequestParameters().getParameterValue("specialtyName").toString();
		getRequestCycle().scheduleRequestHandlerAfterCurrent(new JSONRequestHandler(
				studentService.getStudentsBySpecialtyJSONData(specialtyService.getSpecialtyByName(specialtyName))));
	}

}
