package com.aqiang.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.xml.sax.SAXException;

public class ManualTest {
	public static void main(String[] args) {
		try {
			Server server = new Server(8888);
			WebAppContext context = new WebAppContext();
			context.setResourceBase("src/main/webapp");
			context.setContextPath("/app");
			context.setParentLoaderPriority(true);
			server.setHandler(context);
			server.start();
			server.join();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
