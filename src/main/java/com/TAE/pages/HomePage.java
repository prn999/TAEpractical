package com.TAE.pages;

import com.TAE.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {
 WebDriverWait wait = new WebDriverWait(driver,20);

    // pageFactory - WebElements
    @FindBy(xpath = "//a[@class = 'btn btn-success btn-large']")
    WebElement startShoppingTab;

    // Method to click on start shopping tab
    public void openShoppingPage() {
wait.until(ExpectedConditions.elementToBeClickable(startShoppingTab));
        startShoppingTab.click();
    }

}
