package com.spicejet.tests;

import com.spicejet.pages.SignUpPage;
import com.spicejet.utils.BrowserUtils;
import com.spicejet.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpTest {
    private WebDriver driver;
    private SignUpPage signUpPage;
    private ConfigReader configReader;

    // Sets up the WebDriver and navigates to the SpiceJet website.
    @BeforeClass
    public void setup() {
        configReader = new ConfigReader();
        driver = BrowserUtils.initBrowser();
        driver.get(configReader.getProperty("baseUrl"));
        signUpPage = new SignUpPage(driver);
    }

    // Tests the sign-up process by filling and submitting the sign-up form.
    @Test
    public void testSignUp() {
        signUpPage.navigateToSignUpPage();
        signUpPage.fillSignUpForm(
            "Mr.",                         // Title
            "Manikandan",                  // Name
            "testusernew416@gmail.com",    // Email
            "Password@123",                // Password
            "Password@123",                // Confirm Password
            "India",                       // Country
            "04/02/1996",                  // Date of Birth
            "9876543210"                   // Mobile Number
        );
        signUpPage.submitForm();
        // Add assertions to verify the sign-up process
    }

    // Quits the WebDriver after the tests are completed.
    @AfterClass
    public void tearDown() {
        BrowserUtils.quitBrowser(driver);
    }
}
