package com.TAE.pages;

import com.TAE.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShopPage extends TestBase {

    // pageFactory - WebElements
    @FindBy(xpath = "//div/h4[text() = 'Teddy Bear']")
    WebElement teddyBearTitle;

    @FindBy(xpath = "//li[@id='product-1']//a[@class='btn btn-success']")
    WebElement buyTeddyBearTab;

    @FindBy(xpath = "//*[@id='nav-cart']/a/span")
    WebElement cartCount;

    @FindBy(xpath = "//*[@id='nav-cart']/a")
    WebElement cart;

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

    //Method to click open the cart page
    public void openCartPage() {
        cart.click();
    }
}
