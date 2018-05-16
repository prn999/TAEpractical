package com.TAE.tests;

import com.TAE.base.TestBase;
import com.TAE.pages.HomePage;
import com.TAE.pages.ShopPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HomePageTest extends TestBase {

    HomePage homePage;
    ShopPage shopPage;

    public HomePageTest() {
        initializeBrowser();
        openUrl();
    }

    @BeforeTest
    public void setup() {
        homePage = new HomePage();
        shopPage = new ShopPage();
        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, shopPage);


    }

    @Test
    public void endToEndPurchaseTest() {
       // Assert.assertEquals(validatePageTitle(), prop.getProperty("homePageTitle"));
        homePage.openShoppingPage();
       // int items = shopPage.numberOfItemsInTheCart();
        shopPage.clickBuyTeddyBearTab();
       // Assert.assertEquals(shopPage.numberOfItemsInTheCart(),items++);


        //Assert.assertEquals(validatePageTitle(), prop.getProperty("homePageTitle"));
      //  Assert.assertEquals(shopPage.verifyTeddyTitle(),shopPage.verifyTeddyTitle().contains("Teddy Bear"));
    }


}
