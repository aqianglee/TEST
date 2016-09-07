package com.aqiang.test.config;

import com.aqiang.test.controller.HelloController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;

public class MyConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

}
