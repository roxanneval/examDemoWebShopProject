package pageObjectsDemoWebShop;

import org.openqa.selenium.By;

import demoWebShopClasses.BasePage;

public class BasePageDemoWebShop extends BasePage {
	
	// Method: Go to Home Page
		public void NavigateToHomePage() {
			String URL = getDataConfigPropeties("URL");
			driver.get(URL);
			waitForUrl(30, "demowebshop");
		}
		
	// Method: Cleanup i.e close the Driver
		public void cleanUp() {
			driver.quit();
		}

}
