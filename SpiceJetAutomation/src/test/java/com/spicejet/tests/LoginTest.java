package com.spicejet.tests;

import com.spicejet.pages.LoginPage;
import com.spicejet.utils.BrowserUtils;
import com.spicejet.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ConfigReader configReader;

     // Sets up the WebDriver and navigates to the SpiceJet website.
     
    @BeforeClass
    public void setup() {
    	configReader = new ConfigReader();
        driver = BrowserUtils.initBrowser();
        driver.get(configReader.getProperty("baseUrl"));
        loginPage = new LoginPage(driver);
    }


     // Tests the login process by entering credentials and submitting the form.
    
    @Test
    public void testLogin() {
        loginPage.openLoginPage();
        loginPage.login("testusernew416@gmail.com", "Password@123");
        // Add assertions to verify the login process
    }


     // Quits the WebDriver after the tests are completed.

    @AfterClass
    public void tearDown() {
        BrowserUtils.quitBrowser(driver);
    }
}
