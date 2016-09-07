package com.aqiang.test.wicket.page;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

public class RefrashFormPage extends WebPage {

	private String name;
	
	private static final long serialVersionUID = 1L;

	private Form<RefrashFormPage> form;
	public RefrashFormPage() {
		form = new Form<RefrashFormPage>("form", new CompoundPropertyModel<RefrashFormPage>(this)){
			private static final long serialVersionUID = 1L;
			@Override
			protected void onSubmit() {
				System.out.println("Hello form " + name);
			}
		};
		form.setOutputMarkupId(true);
		add(form);
		form.add(new TextField<String>("name"));
		form.add(new SubmitLink("submit"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				System.out.println("Hello " + name);
			}
		});
		
		add(new AjaxLink<Void>("refrash") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				System.out.println("refash form");
				target.add(form);
			}
		});
	}
}
