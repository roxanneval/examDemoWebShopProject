package testDemoWebShop;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestTest {
	
	@BeforeTest
	public void setUp() {
		//Specify the base URL to the RESTFUL web Service
		RestAssured.baseURI = "https://sheet.best/api/sheets/ec657bc8-0432-4459-9fd8-2b31bd15f8f3"; 
		
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
		given().
		when().
		get("/ID/3").
		then().
		statusCode(200).
		log().all()
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
		get("/Country/South Africa/").
		then().
		statusCode(200).
		log().all()
		;
	}
	
}
