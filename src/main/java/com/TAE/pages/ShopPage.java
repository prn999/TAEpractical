package com.TAE.pages;

import com.TAE.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShopPage extends TestBase {

    // pageFactory - WebElements
    @FindBy(xpath = "//div/h4[text() = 'Teddy Bear']")
    WebElement teddyBearTitle;

    @FindBy(xpath = "//*[@id='product-1']//*[@class='btn btn-success']")
    WebElement buyTeddyBearTab;

    @FindBy(xpath = "//*[@id='nav-cart']/a/span")
    WebElement cartCount;

    // Method to click on start shopping tab
    public String verifyTeddyTitle() {
        String teddyBearTitleText = teddyBearTitle.getText();
        return teddyBearTitleText;

    }

    // Method to click on buy a teddy bear tab
    public void clickBuyTeddyBearTab() {
        buyTeddyBearTab.click();
    }

    //Method to verify no. of items in the cart
    public int numberOfItemsInTheCart() {
        String count = cartCount.getText();
        return Integer.parseInt(count);
    }
}
