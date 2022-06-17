package testDemoWebShop;

import pageObjectsDemoWebShop.BasePageDemoWebShop;
import pageObjectsDemoWebShop.CartPage;
import pageObjectsDemoWebShop.CompareListPage;
import pageObjectsDemoWebShop.ItemPage;
import pageObjectsDemoWebShop.LandingPage;
import pageObjectsDemoWebShop.ShippingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Tests {
	
	//Instantiate Pages
	LandingPage lndPg = new LandingPage();
	CartPage cartPg = new CartPage();
	ShippingPage shipPg = new ShippingPage();
	BasePageDemoWebShop basePgDemo = new BasePageDemoWebShop();
	ItemPage itemPg = new ItemPage();
	CompareListPage compLstPg = new CompareListPage();
	
	
	@AfterTest
	public void cleanUp() {
		basePgDemo.cleanUp();
	}
	
	@Test
	public void GIVEN_UserIsOnLandingPage_When_UserClicksComputerCategory_AND_UserClicksDesktops_THEN_UserWillBeDirectedToDesktopProducts() 
			throws InterruptedException{
		/* User Story 1.1
		 * GIVEN user is on the landing page 
		 * WHEN user clicks on 'Computer' category
		 * AND user clicks 'Desktops' sub-category
		 * THEN is directed to to a list of desktop product
		 * GIVEN_UserOnLandingPage_When_UserClicksComputerCategory_AND_UserClicksDesktops_THEN_UserWillBeDirectedToDesktopProducts
		 */
		String expectedTitle ="Build your own cheap computer";
		String actualTitle;
		basePgDemo.NavigateToHomePage();
		lndPg.clickOnCategoryTopBar();
		lndPg.clickOnSubCategory();
		lndPg.checkTitleOfFirstItem();
		actualTitle = lndPg.checkTitleOfFirstItem();
		System.out.println("The title of the first item is: " + " " + actualTitle );
		Reporter.log("Expected result is:" + " " + expectedTitle);
		Reporter.log("Actual result is:" + " " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);	
	}	
	
	@Test
	public void 
	GIVEN_The_UserOnDesktopPage_WHEN_TheUserClicksFirstItem_THEN_TheUserDirectedToProductDetailPage_AND_TheUserClicksAddToCart_AND_TheUserNavigatestoCart_THEN_TheCartQty1() 
			throws InterruptedException {
		/* User Story 1.2
		 * GIVEN user is on desktop page
		 * WHEN user clicks on the first item 'Build your own cheap computer'
		 * AND user clicks on 'Add to cart'
		 * AND user navigates to the cart
		 * THEN cart qty is 1
		 * GIVEN_The_UserOnDesktopPage_WHEN_TheUserClicksFirstItem_THEN_TheUserDirectedToProductDetailPage_AND_TheUserClicksAddToCart_AND_TheUserNavigatestoCart_THEN_TheCartQty1
		 */
		int actualCartQty;
		int expectedCartQty = 1;
		basePgDemo.NavigateToHomePage();
		lndPg.clickOnCategoryTopBar();
		lndPg.clickOnSubCategory();
		lndPg.checkTitleOfFirstItem();
		itemPg.clickOnFirstItem();
		itemPg.clickOnAddToCart();		
		itemPg.goToShoppingCart(); 
		cartPg.cartQtyCheck();
		actualCartQty = cartPg.cartQtyCheck();
		Reporter.log("Expected result is:" + " " + expectedCartQty);
		Reporter.log("Actual result is:" + " " + actualCartQty);
		Assert.assertEquals(actualCartQty, expectedCartQty);	
	}
	
	@Test
	public void GIVEN_TheUserIsOnTheLandingPage_WHEN_TheUserClicksFromTheCategoriesList_THEN_TheUserWillBeDirectedToProductList() 
			throws InterruptedException{
		/*User Story 2.1
		 * GIVEN user is on the landing page
		 * WHEN user clicks 'Electronics' from the categories list
		 * AND user clicks on the 'Camera, Photo' sub-category list
		 * THEN user will be directed to product list 
		 * GIVEN_TheUserIsOnTheLandingPage_WHEN_TheUserClicksFromTheCategoriesList_AND_TheUserClicksFromTheSubCategoryList_THEN_TheUserWillBeDirectedToProductList
		 */	
		String actualSubCatHeader;
		String expectedSubCatHeader = "Cell phones";
		basePgDemo.NavigateToHomePage();
		lndPg.clickCategoriesList();
		lndPg.clickSubCategoryList();
		actualSubCatHeader = lndPg.checkSubCategoryHeader();
		Reporter.log("Expected Heading:" + " " + expectedSubCatHeader);
		Reporter.log("Actual Heading:" + " " + actualSubCatHeader);
		Assert.assertEquals(actualSubCatHeader, expectedSubCatHeader);
	}
	
	@Test
	public void GIVEN_UserOnProductListPage_WHEN_UserClicksFirstItem_AND_UserAddsItemToCart_THEN_ItemIsAddedToCart() 
		throws InterruptedException {
	/* User Story 2.2
	 * GIVEN user is on product list page
	 * WHEN user clicks on the first item
	 * AND user adds item to cart
	 * THEN item is added to cart
	 * GIVEN_UserOnProductListPage_WHEN_UserClicksFirstItem_AND_UserAddsItemToCart_THEN_ItemIsAddedToCart
	 */
		int actualCartQty;
		int expectedCartQty = 1;
		basePgDemo.NavigateToHomePage();
		lndPg.clickCategoriesList();
		lndPg.clickSubCategoryList();
		itemPg.clickOnFirstItem();
		itemPg.clickOnAddToCart();
		itemPg.clickOnAddToCart();		
		itemPg.goToShoppingCart(); 
		cartPg.cartQtyCheck();
		actualCartQty = cartPg.cartQtyCheck();
		Reporter.log("Expected result is:" + " " + expectedCartQty);
		Reporter.log("Actual result is:" + " " + actualCartQty);
		Assert.assertEquals(actualCartQty, expectedCartQty);
	}
	
	@Test 
	public void GIVEN_TheUserOnCartPage_WHEN_UserClicksOnQty_THEN_UserIsAbleToUpdateQty()
			throws InterruptedException {
	/* User Story 3
	 * GIVEN user is on the Cart Page
	 * WHEN user clicks on Qty
	 * THEN user is able to update the Qty
	 * GIVEN_TheUserOnCartPage_WHEN_UserClicksOnQty_THEN_UserIsAbleToUpdateQty
	 */
		int actualCartQty;
		int expectedCartQty = 3;
		basePgDemo.NavigateToHomePage();
		lndPg.clickCategoriesList();
		lndPg.clickSubCategoryList();
		itemPg.clickOnFirstItem();
		itemPg.clickOnAddToCart();
		itemPg.clickOnAddToCart();		
		itemPg.goToShoppingCart(); 	
		cartPg.clearCartQty();
		cartPg.enterQtyIntoCartQty("3");
		cartPg.updateShoppingCart();
		cartPg.cartQtyCheck();
		actualCartQty = cartPg.cartQtyCheck();
		System.out.println("My cart qty has been updated to: " + actualCartQty);
		Reporter.log("Expected result is:" + " " + expectedCartQty);
		Reporter.log("Actual result is:" + " " + actualCartQty);
		Assert.assertEquals(actualCartQty, expectedCartQty);
	}
	
	@Test
	public void GIVEN_UserOnCartPage_WHEN_UserSelectsItemToRemove_AND_UserUpdatesShoppingCart_THEN_TheItemWillBeRemoved() 
		throws InterruptedException {
	/* User Story 4
	 * GIVEN user is on cart page
	 * WHEN users selects item to 'Remove'
	 * AND user updates shopping cart
	 * THEN the item will be removed from Cart
	 * GIVEN_UserOnCartPage_WHEN_UserSelectsItemToRemove_AND_UserUpdatesShoppingCart_THEN_TheItemWillBeRemoved
	 */
		basePgDemo.NavigateToHomePage();
		lndPg.clickCategoriesList();
		lndPg.clickSubCategoryList();
		itemPg.clickOnFirstItem();
		itemPg.clickOnAddToCart();
		itemPg.clickOnAddToCart();		
		itemPg.goToShoppingCart(); 
		cartPg.checkButtonRemoveFromCart();
		cartPg.updateShoppingCart();
		cartPg.checkShoppingCartIsEmpty();
		String cartIsEmpty = cartPg.checkShoppingCartIsEmpty();
		System.out.println(cartIsEmpty);
		Reporter.log("Item removed: " + " " + cartIsEmpty);
		Assert.assertEquals(cartIsEmpty.contains("Cart is empty!"),true);
	}
	
	@Test
	public void GIVEN_UserOnShippingPage_WHEN_UserUpdatesShippingDetails_THEN_UserIsAbleToEstimateShipping()
			throws InterruptedException {
	/* User Story 5
	 * GIVEN user is on cart Page
	 * WHEN user updates shipping details 
	 * THEN user is able to estimate shipping 
	 * GIVEN_UserOnShippingPage_WHEN_UserUpdatesShippingDetails_THEN_UserIsAbleToEstimateShipping
	 */
		String actualShippingDetails;
		String expectedShippingDetails = "Ground (0.00)";
		basePgDemo.NavigateToHomePage();
		lndPg.clickCategoriesList();
		lndPg.clickSubCategoryList();
		itemPg.clickOnFirstItem();
		itemPg.clickOnAddToCart();
		itemPg.clickOnAddToCart();		
		itemPg.goToShoppingCart(); 
		shipPg.selectDropDownCountry("United States");
		shipPg.selectDropDownState("New York");
		shipPg.enterZipCode("7560");
		shipPg.estimateShipping();
		shipPg.checkShippingDetails();
		actualShippingDetails = shipPg.checkShippingDetails();
		Reporter.log("Your Shipping estimates are: " + actualShippingDetails);
		Assert.assertEquals(actualShippingDetails,expectedShippingDetails);
	}
	
	@Test
	public void GIVEN_UseronLandingPage_WHEN_UserAddsItemsToCompareList_THEN_UserCanCompareProducts()
			throws InterruptedException {
	/* User Story 6
	 * GIVEN user is on landing page
	 * WHEN user adds items to compare list
	 * THEN the user is can compare products
	 * GIVEN_UseronLandingPage_WHEN_UserAddsItemsToCompareList_THEN_UserCanCompareProducts
	 */
		String compareFirstItem;
		String compareSecondItem;
		basePgDemo.NavigateToHomePage();
		lndPg.clickOnCategoryTopBar();
		lndPg.clickOnSubCategory();
		itemPg.clickOnFirstItem();
		itemPg.addItemToCompareList();
		basePgDemo.NavigateToHomePage();
		lndPg.clickOnCategoryTopBar();
		lndPg.clickOnSubCategory();
		itemPg.clickOnSecondItem();
		itemPg.addItemToCompareList();
		compLstPg.getUnitPriceFirstItem();
		compLstPg.getUnitPriceSecondItem();
		compareFirstItem = compLstPg.getUnitPriceFirstItem();
		compareSecondItem = compLstPg.getUnitPriceSecondItem();
		System.out.println("The Price of my first item is: " + compareFirstItem);
		System.out.println("The Price of my second item is: " + compareSecondItem);
		Reporter.log("The Price of my first item is: " + compareFirstItem);
		Reporter.log("The Price of my second item is: " + compareSecondItem);
	}
}
