package com.spicejet.tests;

import com.spicejet.pages.BookingConfirmationPage;
import com.spicejet.pages.FlightBookingPage;
import com.spicejet.pages.FlightSearchPage;
import com.spicejet.utils.BrowserUtils;
import com.spicejet.utils.ConfigReader;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class BookingValidationTest {
    private WebDriver driver;
    private ConfigReader configReader;
    private FlightSearchPage flightSearchPage;
    private FlightBookingPage flightBookingPage;
    private BookingConfirmationPage bookingConfirmationPage;

     //Sets up the WebDriver and navigates to the SpiceJet website.
     
    @BeforeClass
    public void setup() {
    	configReader = new ConfigReader();
        driver = BrowserUtils.initBrowser();
        driver.get(configReader.getProperty("baseUrl"));
        flightSearchPage = new FlightSearchPage(driver);
        flightBookingPage = new FlightBookingPage(driver);
        bookingConfirmationPage = new BookingConfirmationPage(driver);
    }

     // Tests the flight booking and confirmation process.
    
    @Test
    public void testBookingValidation() {
        flightSearchPage.selectTripType("one-way");
        flightSearchPage.enterOrigin("DEL");
        flightSearchPage.enterDestination("BLR");
        flightSearchPage.searchFlights();
        flightBookingPage.selectFlight();
        flightBookingPage.continueToBooking();
        assertTrue(bookingConfirmationPage.isBookingConfirmed(), "Booking was not confirmed");
    }

    // Quits the WebDriver after the tests are completed.
    
    @AfterClass
    public void tearDown() {
        BrowserUtils.quitBrowser(driver);
    }
}
