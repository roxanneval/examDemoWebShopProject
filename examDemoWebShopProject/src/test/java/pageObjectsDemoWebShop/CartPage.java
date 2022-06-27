package pageObjectsDemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import demoWebShopClasses.BasePage;

public class CartPage extends BasePage{
	
	public int cartQtyCheck() {
		String cartQty = 
				getElementText(By.xpath("//*[@id=\"topcartlink\"]/a/span[2]"));
		String qty = cartQty.replaceAll("\\D", "");
		int qtyInt = Integer.parseInt(qty);
		return qtyInt;
	}
	
	public void clickCartQty() {
		clickElement(By.xpath("//tbody/tr[1]/td[5]/input[1]"));
	}
	
	public void enterQtyIntoCartQty(String CartQty) {
		enterText(By.xpath("//tbody/tr[1]/td[5]/input[1]"), CartQty);
	}
	
	public void checkButtonRemoveFromCart() {
		clickElement(By.cssSelector
				("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-1 div.page.shopping-cart-page div.page-body div.order-summary-content table.cart tbody:nth-child(3) tr.cart-item-row td.remove-from-cart > input:nth-child(2)"));
	}
	
	public void updateShoppingCart() {
		clickElement(By.cssSelector
				("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-1 div.page.shopping-cart-page div.page-body div.order-summary-content form:nth-child(1) div.buttons div.common-buttons > input.button-2.update-cart-button:nth-child(1)"));
	}
	
	public void clearCartQty() {
		clearText(By.xpath
				("//tbody/tr[1]/td[5]/input[1]"));
	}
	
	public String checkShoppingCartIsEmpty() {
		String cartIsEmpty = getElementText(By.cssSelector
				("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-1 div.page.shopping-cart-page div.page-body > div.order-summary-content"));
			return cartIsEmpty;
	}
	
}


