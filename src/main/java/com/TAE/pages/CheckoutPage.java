package com.TAE.pages;

import com.TAE.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver,10);


    @FindBy(id = "forename")
    WebElement forename;

    @FindBy(id="surname")
    WebElement surname;

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="telephone")
    WebElement telephone;

    @FindBy(id="address")
    WebElement address;

    @FindBy(id="cardType")
    WebElement cardType;

    @FindBy(id="card")
    WebElement cardNumber;

    @FindBy(id="checkout-submit-btn")
    WebElement submitTab;

    public void fillDeliveryDetails(String custForename, String custSurname,
                                 String custEmail, String custTelNumber, String custAddress) {
        forename = wait.until(ExpectedConditions.visibilityOf(forename));
        forename.sendKeys(custForename);
        surname.sendKeys(custSurname);
        email.sendKeys(custEmail);
        telephone.sendKeys(custTelNumber);
        address.sendKeys(custAddress);

    }
    public void fillPaymentDetails(String selectCardType,String custCardNum){
        cardType = wait.until(ExpectedConditions.elementToBeClickable(cardType));
        Select  selCardType = new Select(cardType);
        selCardType.selectByVisibleText(selectCardType);
        cardNumber.sendKeys(custCardNum);
    }
    public void clickSubmit(){
        submitTab.click();
    }


}
