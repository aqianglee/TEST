package com.aqiang.test.fileupload.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class FileUploadListener implements ProgressListener {

	private HttpSession session;

	public FileUploadListener(HttpServletRequest request) {
		session = request.getSession();
		State state = new State();
		session.setAttribute("uploadState", state);
	}

	@Override
	public void update(long pBytesRead, long pContentLength, int pItems) {
		if (pContentLength == -1) {
			System.out.println("上传文件结束！");
		} else {
			State state = (State) session.getAttribute("uploadState");
			state.setState(pBytesRead, pContentLength, (pItems - 1));
		}
	}

}
