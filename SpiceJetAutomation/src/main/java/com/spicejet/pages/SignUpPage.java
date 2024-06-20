package com.spicejet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
    private WebDriver driver;

    // Locators for sign-up page elements
    private By signUpLink = By.xpath("//a[contains(@class, 'signup-link')]");
    private By titleDropdown = By.id("ddlTitle");
    private By nameField = By.id("txtName");
    private By emailField = By.id("txtEmail");
    private By passwordField = By.id("txtPassword");
    private By confirmPasswordField = By.id("txtConfirmPassword");
    private By countryDropdown = By.id("ddlCountry");
    private By dobField = By.id("txtDob");
    private By mobileNumberField = By.id("txtMobile");
    private By agreeCheckbox = By.id("chkAgree");
    private By signUpButton = By.id("btnSignUp");

    // Constructor to initialize WebDriver
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigates to the Sign-Up page.
    public void navigateToSignUpPage() {
        driver.findElement(signUpLink).click();
    }

    // Fills out the sign-up form with the provided details.
    public void fillSignUpForm(String title, String name, String email, String password, String confirmPassword, String country, String dob, String mobile) {
        new Select(driver.findElement(titleDropdown)).selectByVisibleText(title);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
        driver.findElement(dobField).sendKeys(dob);
        driver.findElement(mobileNumberField).sendKeys(mobile);
        driver.findElement(agreeCheckbox).click();
    }

    // Submits the sign-up form
    public void submitForm() {
        driver.findElement(signUpButton).click();
    }
}
