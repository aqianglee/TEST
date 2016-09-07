package com.aqiang.test.wicket.page;

import java.util.Iterator;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.aqiang.test.entities.Student;
import com.aqiang.test.service.StudentService;

public class StudentListPage extends MyPage {
	private static final long serialVersionUID = 1L;
	@SpringBean
	private StudentService studentService;

	public StudentListPage() {

		IDataProvider<Student> dataProvider = new IDataProvider<Student>() {
			private static final long serialVersionUID = 1L;

			@Override
			public void detach() {

			}

			@Override
			public Iterator<? extends Student> iterator(long first, long count) {
				return studentService.getStudentsBySpecialty(null).iterator();
			}

			@Override
			public long size() {
				return studentService.getStudentsBySpecialty(null).size();
			}

			@Override
			public IModel<Student> model(Student object) {
				return new CompoundPropertyModel<Student>(object);
			}
		};
		DataView<Student> students = new DataView<Student>("students", dataProvider) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(Item<Student> item) {
				item.add(new Label("name"));
				item.add(new Label("age"));
				item.add(new Label("specialty.name"));
			}
		};
		add(students);
	}
}
