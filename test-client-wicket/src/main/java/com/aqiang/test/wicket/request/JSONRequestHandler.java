package com.aqiang.test.wicket.request;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.wicket.request.IRequestCycle;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.http.WebResponse;
import org.apache.wicket.util.string.Strings;

public class JSONRequestHandler implements IRequestHandler {

	private String jsonData;
	private String encoding;

	public JSONRequestHandler(String jsonData) {
		this.jsonData = jsonData;
	}

	public JSONRequestHandler(String jsonData, String encoding) {
		this.jsonData = jsonData;
		this.encoding = encoding;
	}

	private String getEncoding(final IRequestCycle requestCycle) {
		String encoding = this.encoding;
		if (Strings.isEmpty(encoding)) {
			Charset charset = requestCycle.getRequest().getCharset();
			if (charset != null) {
				encoding = charset.name();
			}
		}
		return encoding;
	}

	@Override
	public void respond(IRequestCycle requestCycle) {
		if (encoding == null) {
			encoding = getEncoding(requestCycle);
		}
		
		final WebResponse response = (WebResponse) requestCycle.getResponse();
		response.setContentType("application/json" + ";charset=" + encoding);
		try {
			byte[] bytes = jsonData.getBytes(encoding);
			response.setContentLength(bytes.length);
			response.write(bytes);
		} catch (IOException e) {
			throw new RuntimeException("Unable to render json data: " + e.getMessage(), e);
		}
	}

	@Override
	public void detach(IRequestCycle requestCycle) {

	}

}
