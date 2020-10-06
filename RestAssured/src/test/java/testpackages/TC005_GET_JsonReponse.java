package testpackages;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_JsonReponse {
	
	
	@Test
	
	void getJsonResponseBody() {
		
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httprequest=RestAssured.given();
		
		
		Response response=httprequest.request(Method.GET, "/Delhi");
		
		String reponseBody= response.getBody().asString();
		System.out.println("The Response of the request is" +reponseBody);
		
		Assert.assertEquals(reponseBody.contains("Delhi"), true);
		Assert.assertEquals(reponseBody.contains("Temperature"), true);
		
		
		
		
		
		
				
				
	}

}
