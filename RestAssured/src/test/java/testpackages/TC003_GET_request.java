package testpackages;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_request {

	@Test
	void googleMapTest() {
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		
		RequestSpecification httprequest=RestAssured.given();
		
		
		Response response=httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		String responseBody= response.getBody().asString();
		
		System.out.println("The Response Body is " +responseBody);
		
		
		
	}

}
