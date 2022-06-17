package pageObjectsDemoWebShop;

import org.openqa.selenium.By;

import demoWebShopClasses.BasePage;

public class ShippingPage extends BasePage{

	public void selectDropDownCountry(String Country) {
		selectDropdown(By.cssSelector("#CountryId"), Country);
	}
	
	public void selectDropDownState(String State) {
		selectDropdown(By.cssSelector("#StateProvinceId"), State);
	}	
	
	public void enterZipCode(String zipCode) {
		enterText(By.xpath("//input[@id='ZipPostalCode']"), zipCode);
	}
	
	public void estimateShipping() {
		clickElement(By.cssSelector
				("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-1 div.page.shopping-cart-page div.page-body div.order-summary-content div.cart-footer div.cart-collaterals div.shipping div.estimate-shipping:nth-child(2) div.shipping-options div.inputs:nth-child(4) > input.button-2.estimate-shipping-button"));
	}
	
	public String checkShippingDetails() {
		String shippingDetails = getElementText(By.cssSelector
				("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-1 div.page.shopping-cart-page div.page-body div.order-summary-content div.cart-footer div.cart-collaterals div.shipping div.estimate-shipping:nth-child(2) ul.shipping-results li.shipping-option-item:nth-child(1) > strong.option-name"));
			return shippingDetails;
	}
	
}

