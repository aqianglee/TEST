package com.aqiang.test.wicket.page;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.aqiang.test.service.StudentService;

public class HomePage extends MyPage {
	private static final long serialVersionUID = 1L;
	@SpringBean
	private StudentService studentService;
	
	public HomePage() {
		
		add(new Link<Void>("testRefrashForm") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				setResponsePage(new RefrashFormPage());
			}
		});
		
		Link<Void> prepareData = new Link<Void>("prepareData") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				studentService.prepareData();
			}
		};
		add(prepareData);
		Link<Void> listStudent = new Link<Void>("listStudents") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(StudentListPage.class);
			}
		};
		add(listStudent);
	}
}
