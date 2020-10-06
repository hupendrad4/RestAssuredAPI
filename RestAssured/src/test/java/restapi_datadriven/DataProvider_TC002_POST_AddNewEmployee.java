package restapi_datadriven;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.XMLUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataProvider_TC002_POST_AddNewEmployee {

	private static final String String = null;

	@Test(dataProvider = "empDataProvider_excel")
	void createNewEmployee(String ename, String eage, String esal) {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		// Creating Request Object =as body is Json data

		// Request Payload sending along with Post Request

		// Here We created Data which we send along with the request

		JSONObject requestParams = new JSONObject();

		requestParams.put("name", ename);
		requestParams.put("salary", esal);
		requestParams.put("age", eage);

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestParams.toJSONString()); // Attach data To the request

		Response response = httpRequest.request(Method.POST, "/create");

		// Validation Part=

		// Print Response on console
		String responseBody = response.getBody().asString();
		System.out.println("The Response Body is " + responseBody);

		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esal),true);
		Assert.assertEquals(responseBody.contains(eage),true);

		// Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("The Status code is " + statusCode);

		Assert.assertEquals(statusCode, 200);

		// Success code Validations

		/*
		 * String successCode = response.jsonPath().get("SuccessCode");
		 * System.out.println("The Success code " + successCode);
		 * Assert.assertEquals(successCode, "OPERATION_SUCCESS");s
		 */

	}

	

	/// Passing parameter from Dataset created by string array
	@DataProvider(name = "empDataProvider1")

	String[][] getEmpData() {
		String empData[][] = { { "test4", "10000", "25" }, { "test5", "15000", "25" }, { "test4", "20000", "25" } };
		return (empData);

	}

	/// getting Paramerter from excel sheet
	@DataProvider(name = "empDataProvider_excel")

	String[][] getEmpDataFromExcel() throws IOException {

		String path = System.getProperty("user.dir") + "/Utilities/testdata.xlsx";

		int RowCount = xlutils.getRowCount(path, "EmpRecords1");
		int CellCount = xlutils.getCellCount(path, "EmpRecords1", 1);
		System.out.println(RowCount);
		System.out.println(CellCount);
		
		String empData[][] = new String[RowCount][CellCount];

		for (int i=1; i<=RowCount; i++) {

			for (int j = 0;j<CellCount; j++) {

				
				empData[i - 1][j] = xlutils.getCellData(path, "EmpRecords1", i, j);
				System.out.println(empData[i-1][j]);
			}
		}

		// String[][] empData = { { "test4", "10000", "25" }, { "test5", "15000", "25"
		// }, { "test4", "20000", "25" } };
		return (empData);

	}
}