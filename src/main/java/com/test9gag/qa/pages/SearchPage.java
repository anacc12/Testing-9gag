package com.test9gag.qa.pages;

import com.test9gag.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"search-hero\"]")
    WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[1]/div/a[2]")
    WebElement testingBtn;


    public SearchPage(){
        PageFactory.initElements(driver, this);
    }

    public void searchBarText(String text){
        String search = searchBar.getAttribute("value");
        Assert.assertEquals(text, search);
    }

    public boolean isSearchTagPresent(){
        return testingBtn.isDisplayed();
    }

}
