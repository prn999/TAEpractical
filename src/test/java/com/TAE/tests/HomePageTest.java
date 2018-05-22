package com.TAE.tests;

import com.TAE.base.TestBase;
import com.TAE.pages.CartPage;
import com.TAE.pages.CheckoutPage;
import com.TAE.pages.HomePage;
import com.TAE.pages.ShopPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;


public class HomePageTest extends TestBase {
    //Instances of classes used in this class
    HomePage homePage;
    ShopPage shopPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    Logger logger = Logger.getLogger(HomePageTest.class);

    //Initializing classes and pagefactory elements of those classes
    @BeforeMethod
    public void setup() {

        initializeBrowser();
        openUrl();

        homePage = new HomePage();
        shopPage = new ShopPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();

        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, shopPage);
        PageFactory.initElements(driver, cartPage);
        PageFactory.initElements(driver, checkoutPage);


    }

    /**
     * Complete end to end scenario navigating from home page to checkout completion
     */
    @Test(priority = 1)
    public void endToEndPurchaseTest() {
        logger.info("*Starting***********endToEndPurchaseTest***************");
        Assert.assertEquals(getPageTitle(), objectRepoProp.getProperty("homePageTitle"));
        homePage.openShoppingPage();
        logger.info("Clicked shopping page tab");


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

    }

    @Test(priority = 2)
    public void emptyCheckout() {
        Assert.assertEquals(getPageTitle(), objectRepoProp.getProperty("homePageTitle"));

        homePage.openShoppingPage();
        logger.info("Clicked shopping page tab");


        int items = shopPage.numberOfItemsInTheCart();
        shopPage.clickBuyTeddyBearTab();
        Assert.assertEquals(shopPage.numberOfItemsInTheCart(), items + 1);
        shopPage.openCartPage();

        cartPage.clickEmptyCartTabYes();

    }

    @AfterMethod
    public void closeBrowser() {
        tearDown();
    }

}
