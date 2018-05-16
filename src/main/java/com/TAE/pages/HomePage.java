package com.TAE.pages;

import com.TAE.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends TestBase {


    // pageFactory - WebElements
    @FindBy(xpath = "//a[@class = 'btn btn-success btn-large']")
    WebElement startShoppingTab;

    // Method to click on start shopping tab
    public void openShoppingPage() {
        startShoppingTab.click();
    }

}
