package http.client;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class HttpRequester {

	public String getData() throws Exception {
		StringBuilder getDataResult = new StringBuilder();

		URL url = new URL(Constants.URL);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			getDataResult.append(line);
		}
		reader.close();
		return getDataResult.toString();
	}

	public void postData(String urlParameters) throws Exception {
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
		
		URL url = new URL(Constants.URL);
		HttpURLConnection connector = (HttpURLConnection) url.openConnection();
		connector.setRequestMethod("POST");
		connector.setRequestProperty("Content-Type", "application/json");
		connector.setRequestProperty("charset", "utf-8");
		connector.setRequestProperty("Content-Length", Integer.toString(postDataLength));
		connector.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		connector.setUseCaches(false);
		connector.setDoInput(true);
		connector.setDoOutput(true);
		connector.setInstanceFollowRedirects(false);

		DataOutputStream writer = new DataOutputStream(connector.getOutputStream());
		writer.writeBytes(urlParameters);
		writer.flush();
		writer.close();

		int responseCode = connector.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + Constants.URL);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader inputStream = new BufferedReader(new InputStreamReader(connector.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = inputStream.readLine()) != null) {
			response.append(inputLine);
		}
		inputStream.close();

		System.out.println("Response Message : " + response.toString());
	}
}
