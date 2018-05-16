package com.TAE.pages;

import com.TAE.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends TestBase {

    @FindBy(xpath = "//input[@id='forename']")
    WebElement forename;

    @FindBy(xpath = "//input[@id='surname']")
    WebElement surname;

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='telephone']")
    WebElement telephone;

    @FindBy(xpath = "//textarea[@id='address']")
    WebElement address;

    @FindBy(xpath = "//select[@id='cardType']")
    WebElement cardType;

    @FindBy(xpath = "//input[@id='card']")
    WebElement cardNumber;

    @FindBy(xpath = "//button[@id='checkout-submit-btn']")
    WebElement submitTab;


}
