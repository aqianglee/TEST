package com.aqiang.test;

import com.jfinal.core.JFinal;

public class ManualTest {
	public static void main(String[] args) throws Exception {
		String[] strs = { "/WEB-INF", "8888", "/", "5" };
		JFinal.main(strs);
	}
}
