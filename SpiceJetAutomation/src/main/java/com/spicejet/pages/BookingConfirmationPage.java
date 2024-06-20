package com.spicejet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingConfirmationPage {
    private WebDriver driver;

    // Locator for booking confirmation message
    private By bookingConfirmationMessage = By.id("booking-confirmation");

    // Constructor to initialize WebDriver
    public BookingConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

      //Checks if the booking confirmation message is displayed.
     
    public boolean isBookingConfirmed() {
        return driver.findElement(bookingConfirmationMessage).isDisplayed();
    }
}
