package com.spicejet.tests;

import com.spicejet.pages.FlightSearchPage;
import com.spicejet.utils.BrowserUtils;
import com.spicejet.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlightSearchTest {
    private WebDriver driver;
    private FlightSearchPage flightSearchPage;
    private ConfigReader configReader;

    // Sets up the WebDriver and navigates to the SpiceJet website.
    @BeforeClass
    public void setup() {
        configReader = new ConfigReader();
        driver = BrowserUtils.initBrowser();
        driver.get(configReader.getProperty("baseUrl"));
        flightSearchPage = new FlightSearchPage(driver);
    }

    // Tests searching for a one-way flight.
    @Test
    public void testOneWayFlightSearch() {
        flightSearchPage.selectTripType("one-way");
        flightSearchPage.enterOrigin("DEL");
        flightSearchPage.enterDestination("BLR");
        flightSearchPage.enterDepartureDate("27-06-2024");
        flightSearchPage.searchFlights();
        // Add assertions to verify the flight search process
        Assert.assertTrue(driver.getTitle().contains("SpiceJet"), "Flight search failed!");
    }

    // Tests searching for a round-trip flight.
    @Test
    public void testRoundTripFlightSearch() {
        flightSearchPage.selectTripType("round-trip");
        flightSearchPage.enterOrigin("DEL");
        flightSearchPage.enterDestination("BLR");
        flightSearchPage.enterDepartureDate("27-06-2024");
        flightSearchPage.enterReturnDate("30-06-2024");
        flightSearchPage.searchFlights();
        // Add assertions to verify the flight search process
        Assert.assertTrue(driver.getTitle().contains("SpiceJet"), "Flight search failed!");
    }

    // Quits the WebDriver after the tests are completed.
    @AfterClass
    public void tearDown() {
        BrowserUtils.quitBrowser(driver);
    }
}
