package com.TAE.tests;

import com.TAE.base.TestBase;
import com.TAE.pages.CartPage;
import com.TAE.pages.CheckoutPage;
import com.TAE.pages.HomePage;
import com.TAE.pages.ShopPage;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class HomePageTest extends TestBase {
    //Instances of classes used in this class
    HomePage homePage;
    ShopPage shopPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

     Logger logger = LoggerFactory.getLogger(HomePageTest.class);
    //Initializing classes and pagefactory elements of those classes
    @BeforeMethod
    public void setup() {

        initializeBrowser();
        logger.info("............Browser Initialised");

        openUrl();
        logger.info("............Opened URL");


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
    @Test
    public void endToEndPurchaseTest() {

        logger.info("...........Starting Test - endToEndPurchaseTest");

        Assert.assertEquals(getPageTitle(), objectRepoProp.getProperty("homePageTitle"));
        logger.info("............Home Page title verified");

        homePage.openShoppingPage();
        logger.info("............Clicked shopping page button");

        int items = shopPage.numberOfItemsInTheCart();
        logger.info("............Counted number of items in the cart (default = 0)");

        shopPage.clickBuyTeddyBearTab();
        logger.info("............Clicked buy teddy bear");

        Assert.assertEquals(shopPage.numberOfItemsInTheCart(), items + 1);
        logger.info("............Asserted cart count incremented");

        shopPage.openCartPage();
        logger.info("............Clicked on cart page link");

        cartPage.clickCheckoutTab();
        logger.info("............Clicked checkout button in cart page");

        checkoutPage.fillDeliveryDetails(testDataProp.getProperty("ForenameTestData"),
                testDataProp.getProperty("SurnameTestData"), testDataProp.getProperty("EmailTestData"),
                testDataProp.getProperty("TelephoneTestData"), testDataProp.getProperty("AddressTestData"));
        logger.info("............Filled delivery details fields");

        checkoutPage.fillPaymentDetails(testDataProp.getProperty("CardTypeTestData"),
                testDataProp.getProperty("CardNumberTestData"));
        logger.info("............Filled payment details fields");

        checkoutPage.clickSubmit();
        logger.info("............Clicked submit");

        logger.info("............End of Test");

    }
    /**
     * Scenario to verify user can empty the contents in the cart
     */
    @Test(priority = 2)
    public void emptyCheckout() {

        logger.info("...........Starting Test - emptyCheckout");

        Assert.assertEquals(getPageTitle(), objectRepoProp.getProperty("homePageTitle"));
        logger.info("............Home Page title verified");

        homePage.openShoppingPage();
        logger.info("............Clicked shopping page button");

        int items = shopPage.numberOfItemsInTheCart();
        logger.info("............Counted number of items in the cart (default = 0)");

        shopPage.clickBuyTeddyBearTab();
        logger.info("............Clicked buy teddy bear");

        Assert.assertEquals(shopPage.numberOfItemsInTheCart(), items + 1);
        logger.info("............Asserted cart count incremented");

        shopPage.openCartPage();
        logger.info("............Clicked on cart page link");

        cartPage.clickEmptyCartTabYes();
        logger.info("............Clicked emptycart button and selected 'yes'");

        Assert.assertEquals(getPageTitle(), objectRepoProp.getProperty("homePageTitle"));
        logger.info("............Asserted user been navigated back to the Home Page");

        logger.info("............End of Test");

    }

    @AfterMethod
    public void closeBrowser(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {

            System.out.println(result.getName());
            captureScreen(driver, result.getName());
        }
        tearDown();
        logger.info("............Browser closed");

    }
}
