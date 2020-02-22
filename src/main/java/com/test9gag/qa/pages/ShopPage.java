package com.test9gag.qa.pages;

import com.test9gag.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class ShopPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"SiteNav\"]/li[4]/a")
    WebElement teesBtn;

    @FindBy(xpath = "//*[@id=\"Collection\"]/ul/li[2]/div/a")
    WebElement blackTee;

    @FindBy(xpath = "//*[@id=\"SingleOptionSelector-0\"]")
    WebElement sizeBtn;

    @FindBy(xpath = "//*[@id=\"SingleOptionSelector-0\"]/option[1]")
    WebElement sizeS;

    @FindBy(xpath = "//*[@id=\"AddToCart-product-template\"]")
    WebElement addToCartBtn;

    public ShopPage(){
        PageFactory.initElements(driver, this);
    }

    public void switchTabs(int i){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(i));
    }

    public void AddShirtToCart(){
        teesBtn.click();
        blackTee.click();
        sizeBtn.click();
        sizeS.click();
        addToCartBtn.click();
    }

}
