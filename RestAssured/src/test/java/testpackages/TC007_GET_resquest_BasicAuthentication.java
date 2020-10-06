package testpackages;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC007_GET_resquest_BasicAuthentication {
	
	
@Test
	void validationForBasicAuthentication() {

		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//For BAsic Authentication -Object
		
		PreemptiveBasicAuthScheme  authScheme =new PreemptiveBasicAuthScheme();
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");

		RestAssured.authentication =authScheme;
		
		RequestSpecification httprequest = RestAssured.given();

		Response response = httprequest.request(Method.GET, "/");

		String responseBody = response.getBody().asString();

		System.out.println("The Response Body is " + responseBody);
		
		
		// Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("The Status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);

	}
}
