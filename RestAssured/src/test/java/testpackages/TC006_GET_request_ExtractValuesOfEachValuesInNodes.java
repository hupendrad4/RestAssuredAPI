package testpackages;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_request_ExtractValuesOfEachValuesInNodes {
	
	
	@Test
	void getWeatherDetailByNodes() {
		
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httprequest=RestAssured.given();
		
		
		Response response=httprequest.request(Method.GET,"/Dhule");
		
		JsonPath jsonpath=response.jsonPath();
		
		//		String responseBody=response.getBody().asString();
		//		System.out.println("The response Body is "+responseBody);
		
		
		//Extract Individual fields from json

		
		System.out.println(jsonpath.get("City"));
		System.out.println(jsonpath.get("Temperature"));
		System.out.println(jsonpath.get("Humidity"));
		System.out.println(jsonpath.get("WeatherDescription"));
		System.out.println(jsonpath.get("WindSpeed"));
		System.out.println(jsonpath.get("WindDirectionDegree"));
	
		
	
		
		
	}

}
