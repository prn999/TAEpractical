package com.TAE.tests;

import com.TAE.base.TestBase;
import com.TAE.pages.CartPage;
import com.TAE.pages.CheckoutPage;
import com.TAE.pages.HomePage;
import com.TAE.pages.ShopPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HomePageTest extends TestBase {
//Instances of classes used in this class
    HomePage homePage;
    ShopPage shopPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

//Constructor - calling methods from Testbase class initialising browser and open URL
    public HomePageTest() {
        initializeBrowser();
        openUrl();
    }
//Initializing classes and pagefactory elements of those classes
    @BeforeTest
    public void setup() {
        homePage = new HomePage();
        shopPage = new ShopPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();

        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, shopPage);
        PageFactory.initElements(driver, cartPage);
        PageFactory.initElements(driver, checkoutPage);


    }
//Complete end to end scenario navigating from home page to checkout completion
    @Test
    public void endToEndPurchaseTest() {
        Assert.assertEquals(getPageTitle(), objectRepoProp.getProperty("homePageTitle"));
        homePage.openShoppingPage();

        int items = shopPage.numberOfItemsInTheCart();
        shopPage.clickBuyTeddyBearTab();
        Assert.assertEquals(shopPage.numberOfItemsInTheCart(), items + 1);
        shopPage.openCartPage();

        cartPage.clickCheckoutTab();

        checkoutPage.fillDeliveryDetails(testDataProp.getProperty("ForenameTestData"),
                testDataProp.getProperty("SurnameTestData"), testDataProp.getProperty("EmailTestData"),
                testDataProp.getProperty("TelephoneTestData"), testDataProp.getProperty("AddressTestData"));
        checkoutPage.fillPaymentDetails(testDataProp.getProperty("CardTypeTestData"),
                testDataProp.getProperty("CardNumberTestData"));
        checkoutPage.clickSubmit();

        TestBase.tearDown();


        //Assert.assertEquals(validatePageTitle(), prop.getProperty("homePageTitle"));
        //  Assert.assertEquals(shopPage.verifyTeddyTitle(),shopPage.verifyTeddyTitle().contains("Teddy Bear"));
    }


}
