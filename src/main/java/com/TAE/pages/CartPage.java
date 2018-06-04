package com.TAE.pages;

import com.TAE.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    // Pagefactory - WebElements
    @FindBy(xpath = "//a[@class='btn-checkout btn btn-success  ng-scope']")
    WebElement checkoutTab;

    @FindBy(xpath = "//a[@class='btn btn-danger ng-scope']")
    WebElement emptyCartTab;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement emptyCartYesTab;

    @FindBy(className = "btn btn-cancel btn-danger" )
    WebElement emptyCartNoTab;


    // Method to click on Checkout tab
    public void clickCheckoutTab() {
        // wait until checkout tab is clickable
        wait.until(ExpectedConditions.elementToBeClickable(checkoutTab));
        checkoutTab.click();
    }

    //method to click empty cart tab
    public void clickEmptyCartTabYes() {
        wait.until(ExpectedConditions.elementToBeClickable(emptyCartTab));
        emptyCartTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(emptyCartYesTab));
        emptyCartYesTab.click();
    }
}
