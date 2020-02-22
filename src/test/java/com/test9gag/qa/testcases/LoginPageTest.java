package com.test9gag.qa.testcases;

import com.test9gag.qa.base.TestBase;
import com.test9gag.qa.pages.HomePage;
import com.test9gag.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
     LoginPage lPage;
     HomePage hPage;

    public LoginPageTest(){
        super(); //testBase konstruktor
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        lPage = new LoginPage();
        lPage.exitPopUp();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = lPage.validateTitle();
        Assert.assertEquals(title, "9GAG: Go Fun The World");
    }

    @Test(priority = 2)
    public void loginPageLogoTest(){
        boolean logo = lPage.validateLogo();
        Assert.assertTrue(logo);
    }

    @Test(priority = 3)
    public void loginPageUpvoteTest(){
        lPage.upvote();
    }

    @Test(priority = 4)
    public void loginPageLoginTest(){
        hPage = lPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
