package pageObjectsDemoWebShop;

import org.openqa.selenium.By;

import demoWebShopClasses.BasePage;

public class LandingPage extends BasePage {
	
	
	public boolean checkLandingPage() {
		return false;
		
	}
	
	public void clickOnCategoryTopBar() {
		clickElement(By.xpath("//body/div[@class='master-wrapper-page']//ul[@class='top-menu']//a[@href='/computers']"));
	}
	
	public void clickOnSubCategory() {
		clickElement(By.cssSelector("a[title='Show products in category Desktops'] > img[alt='Picture for category Desktops']"));
	}
	
	public boolean checkURL() {
		return false;
	}

	public String checkTitleOfFirstItem() {
		String title = getElementText(By.cssSelector("div:nth-of-type(1) > .product-item  h2 > a"));
		return title;
		
	}
	
	public void clickCategoriesList() {
		clickElement(By.xpath
				("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[3]/a"));
	}
	
	public void clickSubCategoryList() {
		clickElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]"));
	}
	
	public String checkSubCategoryHeader() {
		String subCatHeading = getElementText(By.cssSelector
				("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.master-wrapper-main:nth-child(5) div.center-2 div.page.category-page div.page-title > h1:nth-child(1)"));
		return subCatHeading;
		
	}
	
}

