package com.test9gag.qa.testcases;

import com.test9gag.qa.base.TestBase;
import com.test9gag.qa.pages.HomePage;
import com.test9gag.qa.pages.LoginPage;
import com.test9gag.qa.pages.SearchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchPageTest extends TestBase {

    LoginPage lPage;
    HomePage hPage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp() {
        initialization();
        lPage = new LoginPage();
        lPage.exitPopUp();
        hPage = lPage.login(prop.getProperty("username"), prop.getProperty("password"));
        searchPage = hPage.clickOnSearch(prop.getProperty("search"));
    }

    @Test
    public void searchBarTextTest(){
        searchPage.searchBarText(prop.getProperty("search"));
    }

    @Test
    public void isSearchTagPresentTest(){
        searchPage.isSearchTagPresent();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
