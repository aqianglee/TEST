package com.aqiang.test.fileupload.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.aqiang.test.fileupload.request.State;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

public class StatusAction {

	public void execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		State state = (State) session.get("uploadState");
		System.out.println(state);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		response.setContentType("text/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		out.write(new Gson().toJson(state));
	}
}
