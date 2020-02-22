package com.test9gag.qa.pages;

import com.test9gag.qa.base.TestBase;
import com.test9gag.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.ArrayList;

public class HomePage extends TestBase {


    @FindBy(xpath = "//*[@id=\"jsid-avatar\"]")
    WebElement imgSettingsBtn;

    @FindBy(xpath = "//*[@id=\"jsid-header-user-menu-items\"]/ul/li[2]/a")
    WebElement settingsBtn;

    @FindBy(xpath = "//*[@id=\"settings\"]/ul/li[3]/a")
    WebElement profileBtn;

    @FindBy(xpath = "//*[@id=\"jsid-random-avatar-btn\"]")
    WebElement randomAvatarBtn;

    @FindBy(xpath = "//*[@id=\"setting\"]/div[9]/input")
    WebElement saveAvatarBtn;

    @FindBy(xpath = "//*[@id=\"jsid-header-search-btn\"]")
    WebElement searchIconBtn;

    @FindBy(xpath = "//*[@id=\"jsid-search-input\"]")
    WebElement searchInputField;

    @FindBy(xpath = "//*[@id=\"top-nav\"]/div/nav/ul/li[2]/a")
    WebElement shopBtn;

    @FindBy(xpath = "//*[@id=\"jsid-upload-btn\"]")
    WebElement uploadBtn;

    @FindBy(xpath = "//*[@id=\"jsid-upload-url-btn\"]")
    WebElement pasteImageUrlBtn;

    @FindBy(xpath = "//*[@id=\"jsid-upload-url-input\"]")
    WebElement urlInputField;

    @FindBy(xpath = "//*[@id=\"modal-upload\"]/div[2]/div/a[1]")
    WebElement nextBtn;

    @FindBy(xpath = "//*[@id=\"modal-upload\"]/div[3]/div/a[1]")
    WebElement uploadNextBtn;


    @FindBy(xpath = "//*[@id=\"upload-info\"]/div[2]/div/div/div/iframe")
    WebElement iFrameCheckbox;

    @FindBy(xpath = "/html/body/div[8]/div[4]/iframe")
    WebElement iFrameChallenge;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    WebElement iFrame_checkbox;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]")
    WebElement checkBoxSpan;

    @FindBy(xpath = "//*[@id=\"rc-imageselect\"]/div[2]/div[1]/div[1]/div")
    WebElement challengeTitle;

    @FindBy(xpath = "//*[@id=\"jsid-upload-title\"]")
    WebElement descriptionInputField;



    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body")
    WebElement recaptchaChallengeBody;

    public void changeAvatar(){
        imgSettingsBtn.click();
        settingsBtn.click();
        profileBtn.click();
        randomAvatarBtn.click();
        saveAvatarBtn.click();
    }

    public void uploadImage(String imgUrl, String desc) {
        WebDriverWait wait = new WebDriverWait(driver,150);

        uploadBtn.click();
        pasteImageUrlBtn.click();
        urlInputField.sendKeys(imgUrl);
        nextBtn.click();
        descriptionInputField.sendKeys(desc);

        driver.switchTo().frame(iFrameCheckbox);
        iFrame_checkbox.click();

        //driver.switchTo().frame(iFrameChallenge);
        //wait.until(ExpectedConditions.stalenessOf(recaptchaChallengeBody));
        //wait.until(ExpectedConditions.invisibilityOf(recaptchaChallengeBody));

        wait.until(ExpectedConditions.attributeToBe(checkBoxSpan, "aria-checked", "true"));

        driver.switchTo().defaultContent();
        uploadNextBtn.click();
    }

    public ShopPage clickOnShop(){
        shopBtn.click();
        return new ShopPage();
    }

    public SearchPage clickOnSearch(String srch){
        searchIconBtn.click();
        searchInputField.sendKeys(srch, Keys.ENTER);
        return new SearchPage();
    }





}
