package com.TAE.pages;

import com.TAE.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver,10);


    @FindBy(xpath = "//a[@class='btn-checkout btn btn-success  ng-scope']")
    WebElement checkoutTab;


    public void clickCheckoutTab() {
        checkoutTab = wait.until(ExpectedConditions.elementToBeClickable(checkoutTab));
        checkoutTab.click();
    }
}
