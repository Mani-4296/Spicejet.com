package com.spicejet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightBookingPage {
    private WebDriver driver;

    // Locators for flight booking page elements
    private By selectFlightButton = By.xpath("//button[contains(text(), 'Continue')]");
    private By continueButton = By.xpath("//button[contains(text(), 'Continue')]");
    private By titleDropdown = By.name("title");
    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");
    private By emailInput = By.name("email");
    private By countryDropdown = By.name("country");
    private By cityInput = By.name("city");
    private By contactNumberInput = By.name("contactNumber");
    private By paymentCardNumberInput = By.name("cardNumber");
    private By paymentExpiryDateInput = By.name("expiryDate");
    private By paymentCVVInput = By.name("cvv");
    private By paymentCardHolderNameInput = By.name("cardHolderName");
    private By submitButton = By.id("payment-submit");
    private By bookingConfirmationMessage = By.xpath("//h1[contains(text(), 'Booking Confirmed')]");

    public FlightBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFlight() {
        driver.findElement(selectFlightButton).click();
    }

    public void continueToBooking() {
        driver.findElement(continueButton).click();
    }

    public void enterContactDetails(String title, String firstName, String lastName, String email, String countryCode, String contactNumber, String country, String city) {
        driver.findElement(titleDropdown).sendKeys(title);
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(contactNumberInput).sendKeys(contactNumber);
        driver.findElement(countryDropdown).sendKeys(country);
        driver.findElement(cityInput).sendKeys(city);
    }

    public void enterPassengerDetails(String title, String firstName, String lastName) {
        driver.findElement(titleDropdown).sendKeys(title);
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterPaymentDetails(String cardNumber, String expiryDate, String cvv, String cardHolderName) {
        driver.findElement(paymentCardNumberInput).sendKeys(cardNumber);
        driver.findElement(paymentExpiryDateInput).sendKeys(expiryDate);
        driver.findElement(paymentCVVInput).sendKeys(cvv);
        driver.findElement(paymentCardHolderNameInput).sendKeys(cardHolderName);
    }

    public void submitBookingForm() {
        driver.findElement(submitButton).click();
    }

    public String getBookingConfirmationMessage() {
        return driver.findElement(bookingConfirmationMessage).getText();
    }
}
