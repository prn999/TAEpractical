package com.TAE.tests;

import com.TAE.base.TestBase;
import com.TAE.pages.CartPage;
import com.TAE.pages.CheckoutPage;
import com.TAE.pages.HomePage;
import com.TAE.pages.ShopPage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HomePageTest extends TestBase {

    HomePage homePage;
    ShopPage shopPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    public HomePageTest() {
        initializeBrowser();
        openUrl();
    }

    @BeforeTest
    public void setup() {
        homePage = new HomePage();
        shopPage = new ShopPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();

        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, shopPage);
        PageFactory.initElements(driver, cartPage);
        PageFactory.initElements(driver,checkoutPage);


    }

    @Test
    public void endToEndPurchaseTest()  {
       Assert.assertEquals(validatePageTitle(), prop.getProperty("homePageTitle"));
        homePage.openShoppingPage();
       int items = shopPage.numberOfItemsInTheCart();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        shopPage.clickBuyTeddyBearTab();
       Assert.assertEquals(shopPage.numberOfItemsInTheCart(),items + 1);
       shopPage.openCartPage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       cartPage.clickCheckoutTab();


        //Assert.assertEquals(validatePageTitle(), prop.getProperty("homePageTitle"));
      //  Assert.assertEquals(shopPage.verifyTeddyTitle(),shopPage.verifyTeddyTitle().contains("Teddy Bear"));
    }


}
