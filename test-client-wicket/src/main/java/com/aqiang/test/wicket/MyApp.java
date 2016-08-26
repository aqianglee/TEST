package com.aqiang.test.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.IPackageResourceGuard;
import org.apache.wicket.markup.html.SecurePackageResourceGuard;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.aqiang.test.wicket.page.GetStudentsDataPage;
import com.aqiang.test.wicket.page.HomePage;
import com.aqiang.test.wicket.page.SaveStudentPage;

public class MyApp extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();
		enableUTF8Output();
		enableServerFontLoadable();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));

		mountPage("getStudentsData.do", GetStudentsDataPage.class);
		mountPage("saveStudent.do", SaveStudentPage.class);
	}

	private void enableUTF8Output() {
		getMarkupSettings().setDefaultMarkupEncoding("utf-8");
	}

	private void enableServerFontLoadable() {
		IPackageResourceGuard guard = getResourceSettings().getPackageResourceGuard();
		if (guard instanceof SecurePackageResourceGuard) {
			SecurePackageResourceGuard secureGuard = (SecurePackageResourceGuard) guard;
			secureGuard.addPattern("+**.ttf");
			secureGuard.addPattern("+**.eot");
			secureGuard.addPattern("+**.svg");
			secureGuard.addPattern("+**.woff");
		}
	}

}
