package pageObjectsDemoWebShop;

import org.openqa.selenium.By;

import demoWebShopClasses.BasePage;

public class ItemPage extends BasePage{
	
	
	public void clickOnFirstItem() {
		clickElement(By.cssSelector
				("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-2 div.page.category-page div.page-body div.product-grid div.item-box:nth-child(1) div.product-item div.details h2.product-title > a:nth-child(1)"));
	}
	
	public void clickOnThirdItem() {
		clickElement(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-2 div.page.category-page div.page-body div.product-grid div.item-box:nth-child(3) div.product-item div.details h2.product-title > a:nth-child(1)"));
	}
	
	public void clickOnAddToCart() {
		clickElement(By.cssSelector("input[class ='button-1 add-to-cart-button']"));
	}
	
	public void goToShoppingCart() {
		clickElement(By.cssSelector("div#bar-notification  a"));
	}

	public void addItemToCompareList() {
		clickElement(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-2 div.page.product-details-page div.page-body div:nth-child(1) div.product-essential div.overview div.compare-products:nth-child(11) > input.button-2.add-to-compare-list-button"));
	}
}
