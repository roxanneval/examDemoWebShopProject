package pageObjectsDemoWebShop;

import static io.restassured.RestAssured.given;

import java.util.List;

import demoWebShopClasses.BasePage;

public class apiCalls extends BasePage {
	
	//API Call to get Zip Code
		public String getzipCode() {
			String zipcode = 
			given().
			when().
			get("").
			then().
			extract().path("[2].ZipCode")
			;
				return zipcode;
		}
			
	//API Call to get Estimated Shipping cost value
		public String getEstimatedShippingCost() {
			 String shippingCost = 
			 given().
			 when().
			 get("").
			 then().
			 extract().path("[2][\"Expected Shipping Cost\"]");
			 	return shippingCost;
						
			
			
		   
		}

}
