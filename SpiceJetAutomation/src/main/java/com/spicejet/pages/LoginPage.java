package com.spicejet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators for login page elements
    private By loginButton = By.xpath("//div[contains(text(),'Login')]");
    private By emailOptionRadioButton = By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[@class='css-1dbjc4n r-1niwhzg r-1jgb5lz r-r0h9e2 r-13qz1uu']/div[@class='css-1dbjc4n r-1p0dtai r-18u37iz r-1d2f490 r-u8s1d r-zchlnj r-ipm5af']/div[@class='css-1dbjc4n r-14lw9ot r-1p0dtai r-1pcd2l5 r-wk8lta r-u8s1d r-zchlnj r-ipm5af r-1rttkqs']/div[@class='css-1dbjc4n r-156q2ks']/div[@class='css-1dbjc4n r-wk8lta r-1xcajam']/div[@class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-1d09ksm r-18u37iz']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-1qxgc49']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj r-p1pxzi']/div[2]/div[1]//*[name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='circle'][1]");
    private By emailField = By.xpath("//input[@data-testid='user-mobileno-input-box']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By submitButton = By.cssSelector(".css-1dbjc4n.r-1awozwy.r-184aecr.r-z2wwpe.r-1loqt21.r-18u37iz.r-tmtnm0.r-1777fci.r-1x0uki6.r-1w50u8q.r-ah5dr5.r-1otgn73");

    // Constructor to initialize WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Opens the login page.
    public void openLoginPage() {
        driver.findElement(loginButton).click();
    }

    // Selects the email option radio button
    public void selectEmailOption() {
        driver.findElement(emailOptionRadioButton).click();
    }

    // Logs in with the provided email and password.
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }
}
