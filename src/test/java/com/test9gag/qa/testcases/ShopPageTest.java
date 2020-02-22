package com.test9gag.qa.testcases;

import com.test9gag.qa.base.TestBase;
import com.test9gag.qa.pages.HomePage;
import com.test9gag.qa.pages.LoginPage;
import com.test9gag.qa.pages.ShopPage;
import com.test9gag.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ShopPageTest extends TestBase {

    public ShopPageTest(){
        super();
    }

    LoginPage lPage;
    HomePage hPage;
    ShopPage shopPage;

    @BeforeMethod
    public void setUp(){
        initialization();
        lPage = new LoginPage();
        lPage.exitPopUp();
        hPage = lPage.login(prop.getProperty("username"), prop.getProperty("password"));
        shopPage = hPage.clickOnShop();
    }

    @Test
    public void addToCartTest(){
        shopPage.switchTabs(1);
        shopPage.AddShirtToCart();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
