package com.nokia.oss.nidd.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.nokia.oss.nidd.pojo.NIDDPojo;

public class Main {

	static HttpClient cli = new DefaultHttpClient();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {

		HttpPost post = new HttpPost("http://localhost:8080/rest/nidd/cm");
		post.addHeader("content-type", "application/json; charset=utf-8");

		NIDDPojo pojo = new NIDDPojo();

		pojo.setAdaId("NOKLTE");
		pojo.setAdaRel("FL16A");
		pojo.setTimestamp(System.currentTimeMillis());

		Gson gson = new Gson();

		post.setEntity(new StringEntity(gson.toJson(pojo)));

		HttpResponse response = cli.execute(post);

		System.out.print(convertInputStreamToString(response.getEntity()
				.getContent()));

	}

	private static String convertInputStreamToString(InputStream inputStream)
			throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		String line;

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line).append("\n");
			}
		} finally {
			inputStream.close();
		}

		return stringBuilder.toString();
	}

}
