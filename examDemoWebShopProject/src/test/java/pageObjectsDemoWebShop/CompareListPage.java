package pageObjectsDemoWebShop;

import org.openqa.selenium.By;

import demoWebShopClasses.BasePage;

public class CompareListPage extends BasePage{
	
	//This is not working
	/*public int getUnitPriceFirstItem() {
		String unitPriceString = 
				getElementText(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-2 div.page.compare-products-page div.page-body table.compare-products-table tbody:nth-child(1) tr.product-price > td.a-center:nth-child(2)"));
		String unitPrice = unitPriceString.replaceAll("\\D", "");--> This is removing the . and making the value incorrect
		int unitPriceInt = Integer.parseInt(unitPrice);
		return unitPriceInt;
	}*/
	
	public String getUnitPriceFirstItem() {
		String price = getElementText(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-2 div.page.compare-products-page div.page-body table.compare-products-table tbody:nth-child(1) tr.product-price > td.a-center:nth-child(2)"));
		return price;
	}
	
	public String getUnitPriceSecondItem() {
		String price = getElementText(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-2 div.page.compare-products-page div.page-body table.compare-products-table tbody:nth-child(1) tr.product-price > td.a-center:nth-child(3)"));
		return price;
	}

}
