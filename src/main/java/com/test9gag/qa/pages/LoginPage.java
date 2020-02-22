package com.test9gag.qa.pages;

import com.test9gag.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy (xpath = "/html/body/div[7]/div[1]/div[2]/div/span")
    WebElement popUp;

    @FindBy(xpath = "//*[@id=\"jsid-login-button\"]")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login-email-name\"]")
    WebElement username;

    @FindBy(xpath = "//*[@id=\"login-email-password\"]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"login-email\"]/div[3]/input")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"top-nav\"]/div/a")
    WebElement logo;


    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void exitPopUp(){
        popUp.click();
    }

    public String validateTitle(){
        return driver.getTitle();
    }

    public boolean validateLogo(){
        return logo.isDisplayed();
    }


    public HomePage login(String uname, String pass){
        loginButton.click();
        username.sendKeys(uname);
        password.sendKeys(pass);
        loginBtn.click();
        return new HomePage();
    }
}
