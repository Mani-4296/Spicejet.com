package com.spicejet.tests;

import com.spicejet.pages.FlightBookingPage;
import com.spicejet.pages.FlightSearchPage;
import com.spicejet.utils.BrowserUtils;
import com.spicejet.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlightBookingTest {
    private WebDriver driver;
    private FlightSearchPage flightSearchPage;
    private FlightBookingPage flightBookingPage;
    private ConfigReader configReader;

    @BeforeClass
    public void setup() {
        configReader = new ConfigReader();
        driver = BrowserUtils.initBrowser();
        driver.get(configReader.getProperty("baseUrl"));
        flightSearchPage = new FlightSearchPage(driver);
        flightBookingPage = new FlightBookingPage(driver);
    }

    @Test
    public void testFlightBooking() {
        flightSearchPage.selectTripType("one-way");
        flightSearchPage.enterOrigin("DEL");
        flightSearchPage.enterDestination("BLR");
        flightSearchPage.searchFlights();
        flightBookingPage.selectFlight();
        flightBookingPage.continueToBooking();
        
        // Fill out the booking form with dummy information
        flightBookingPage.enterContactDetails("Mr", "MANI", "KANDAN", "manik787167@gmail.com", "+91", "8765432101", "India", "Chennai");
        flightBookingPage.enterPassengerDetails("Mr", "MANI", "KANDAN");
        flightBookingPage.enterPaymentDetails("4111111111111111", "12/25", "123", "MANI KANDAN");
        
        // Submit the booking form
        flightBookingPage.submitBookingForm();
        
        // Verify the booking confirmation
        String confirmationMessage = flightBookingPage.getBookingConfirmationMessage();
        Assert.assertTrue(confirmationMessage.contains("Booking Confirmed"), "Booking was not successful.");
    }

    @AfterClass
    public void tearDown() {
        BrowserUtils.quitBrowser(driver);
    }
}
