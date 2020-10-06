package testpackages;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_request_AllHeaders {

	@Test

	void getUsersHeaderDetails() {

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification httprequest = RestAssured.given();

		Response response = httprequest.request(Method.GET, "/api/users?delay=3");

		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is" +responseBody);
		
		System.out.println("**************Singel Header Validation**********************************");
		
		// Verify Single header
		String date=response.header("Date");
		System.out.println("The Date is " +date);
		
		String contentType=response.header("Content-Type");
		System.out.println("The Content type is " +contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		
		String contentEncoding=response.header("Content-Encoding");
		System.out.println("The Content Encoding is " +contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
		System.out.println("**************Get All Headers********************************************");
		
		//It returns all headers from response
		
		Headers allHeaders =response.headers(); 
		
		for(Header header:allHeaders) {
			System.out.println(header.getName()  + "  " +header.getValue());
			
		}

	}

}
