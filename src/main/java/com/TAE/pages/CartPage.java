package com.TAE.pages;

import com.TAE.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends TestBase {

    @FindBy(xpath = "//a[@class='btn-checkout btn btn-success  ng-scope']")
    WebElement checkoutTab;


    public void clickCheckoutTab() {
        checkoutTab.click();
    }
}
