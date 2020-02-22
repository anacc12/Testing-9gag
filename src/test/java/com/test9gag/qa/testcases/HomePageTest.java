package com.test9gag.qa.testcases;

import com.test9gag.qa.base.TestBase;
import com.test9gag.qa.pages.HomePage;
import com.test9gag.qa.pages.LoginPage;
import com.test9gag.qa.pages.SearchPage;
import com.test9gag.qa.pages.ShopPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage lPage;
    HomePage hPage;
    ShopPage shopPage;
    SearchPage searchPage;


    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        lPage = new LoginPage();
        lPage.exitPopUp();
        hPage = lPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void uploadImageTest(){
        hPage.uploadImage(prop.getProperty("imgUrl"), prop.getProperty("postDescription"));
    }

    @Test
    public void changeAvatarTest(){
        hPage.changeAvatar();
    }


    @Test
    public void clickOnShopButton(){
        shopPage = hPage.clickOnShop();
    }

    @Test
    public void clickOnSearchButton(){
        searchPage = hPage.clickOnSearch(prop.getProperty("search"));
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
