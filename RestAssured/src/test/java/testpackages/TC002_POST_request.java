package testpackages;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC002_POST_request {
	
	@Test
	void registerSuccessful() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		RequestSpecification httpRequest = RestAssured.given();

		// Creating Request Object =as body is Json data

		// Request Payload sending along with Post Request

		JSONObject requestParams = new JSONObject();

		requestParams.put("FirstName", "abcdf65");
		requestParams.put("LastName", "abcdf25");
		requestParams.put("UserName", "abdfc35");
		requestParams.put("Password", "abcdfdep5645");
		requestParams.put("Email", "abc545dfs@gmail.com");

		httpRequest.header("Content-Type","application/json");

		httpRequest.body(requestParams.toJSONString()); // Attach data To the request

		Response response = httpRequest.request(Method.POST, "/register");

		// Validation Part=
		// Print Response on console
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is " + responseBody);

		// Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("The Status code is " + statusCode);

		Assert.assertEquals(statusCode, 201);

		// Success code Validations

		String successCode = response.jsonPath().get("SuccessCode");
		System.out.println("The Success code " +successCode);
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");

	}

}
