package com.aqiang.test.http.impl.client;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonResponseHandler<T> implements ResponseHandler<T> {

	@SuppressWarnings("unchecked")
	@Override
	public T handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		String result = new BasicResponseHandler().handleResponse(response);
		return result == null ? null : (T) new Gson().fromJson(result, new TypeToken<T>() {
		}.getType());
	}

}
