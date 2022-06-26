package testDemoWebShop;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestTest {
	
	@BeforeTest
	public void setUp() {
		//Specify the base URL to the RESTFUL web Service
		RestAssured.baseURI = "https://sheet.best/api/sheets/dd36da4e-2ea6-4d93-8698-e9ac6085aa97";			
	}

	@Test
	public void getAllShippingDetails() {
		given().
		when().
		get("").
		then().
		statusCode(200).
		log().all()
		;
	}
	
	@Test
	public void getShippingdDetailsByID() {
		given().param("ID").
		when().
		get("/ID/3").
		then().
		statusCode(200).
		log().all().
		body("ID",equalTo(3));//Provides actual & Expected results and passes
		;
	}
	
	@Test
	public void getShippingState() {
		given().
		when().
		get("/State/Other (Non US)").
		then().
		statusCode(200).
		log().all()
		;
	}
	
	
	@Test
	public void getShippingCountry () {
		given().
		when().
		get("/Country/Australia/").
		then().
		statusCode(200).
		log().all()
		;
	}

	@Test
	public static void getShippingCountryDesc(){

		List<String> zip = given().when().get("/ID/3").then().extract().path("/ZipCode/") ;{
			System.out.println(zip);
	
		   }
		}
	
	
	@Test
	public void testCase() {
	List<String> zip =
				given().when().get("/ID/3").then().extract().response().path("/ZipCode/");
		for (String zipCode : zip) {
			System.out.println("My zipCode = " + zipCode);
		}
	}
}
	
	
	


	

