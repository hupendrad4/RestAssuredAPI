package testpackages;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_request {

	@Test
	void getWeatherDetails() {

		// Specify BaseURI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Create Request Object
		RequestSpecification httprequest = RestAssured.given();

		// Create Response object to save response

		Response response = httprequest.request(Method.GET, "/Hyderabad");
		
		//Print Response on console
		String responseBody=response.getBody().asString();
		System.out.println("The Response Body is " +responseBody);
		
		
		/// VErify StatusCOde and Status Line are correct
		
		//Status Code Validation
	     int statusCode=response.getStatusCode();
	     System.out.println("The Status code is " +statusCode);
	     
	     Assert.assertEquals(statusCode, 200);
	     
	     // Verify Status Line
	     String statusLine = response.getStatusLine();
	     System.out.println("The Actual Status Line is " +statusLine);
	     Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

}
