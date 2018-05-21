package com.TAE.pages;

import com.TAE.base.TestBase;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver,10);

// Pagefactory - WebElements
    @FindBy(xpath = "//a[@class='btn-checkout btn btn-success  ng-scope']")
    WebElement checkoutTab;

// Method to click on Checkout tab
    public void clickCheckoutTab() {
        // wait until checkout tab is clickable
        checkoutTab = wait.until(ExpectedConditions.elementToBeClickable(checkoutTab));
        checkoutTab.click();
    }
}
