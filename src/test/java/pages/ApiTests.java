package test.java.pages;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;

import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

public class ApiTests {	
	
	CloseableHttpResponse httpResponse;
	
	public void makeGetRequest () throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://reqres.in/api/users?page=2");
		
		httpResponse = httpClient.execute(httpGet);
	}	
	
	public void validateResponseStatusCode () throws Throwable, IOException {		
		Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());		
	}
	
	public void validateFirstName (String user_id, String first_name) throws Throwable, IOException {		
		String responseString = EntityUtils.toString(httpResponse.getEntity());
		JSONObject responseJson = new JSONObject(responseString);
		
		int total_users = responseJson.getJSONArray("data").length();
		
		for (int i=0;i<total_users;i++) {
			if (responseJson.query("#/data/"+i+"/id") == user_id) {
				Assert.assertEquals(first_name, responseJson.query("#/data/"+i+"/first_name"));
			}			
		}	
	}	
}