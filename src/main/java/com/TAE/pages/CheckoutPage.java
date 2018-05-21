package com.TAE.pages;

import com.TAE.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver,10);

//PageFactory - WebElements
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

    // Method to fill delivery details form
    public void fillDeliveryDetails(String custForename, String custSurname,
                                 String custEmail, String custTelNumber, String custAddress) {
        // wait until forename field is visible
        forename = wait.until(ExpectedConditions.visibilityOf(forename));
        forename.sendKeys(custForename);
        surname.sendKeys(custSurname);
        email.sendKeys(custEmail);
        telephone.sendKeys(custTelNumber);
        address.sendKeys(custAddress);

    }
    // Method to fill payment details form
    public void fillPaymentDetails(String selectCardType,String custCardNum){
        //wait until cardType dropdown box is clickable
        cardType = wait.until(ExpectedConditions.elementToBeClickable(cardType));
        Select  selCardType = new Select(cardType);
        selCardType.selectByVisibleText(selectCardType);
        cardNumber.sendKeys(custCardNum);
    }
    // Method to click on submit tab
    public void clickSubmit(){
        submitTab.click();
    }


}
