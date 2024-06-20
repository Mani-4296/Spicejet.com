package com.spicejet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSearchPage {
    private WebDriver driver;

    // Locators for flight search page elements
    private By oneWayRadio = By.cssSelector("input[value='Oneway']");
    private By roundTripRadio = By.cssSelector("input[value='RoundTrip']");
    private By originField = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By destinationField = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By departureDateField = By.id("ctl00_mainContent_view_date1");
    private By returnDateField = By.id("ctl00_mainContent_view_date2");
    private By searchButton = By.id("ctl00_mainContent_btn_FindFlights");

    // Constructor to initialize WebDriver
    public FlightSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Selects the trip type (one-way or round-trip).
    public void selectTripType(String tripType) {
        if (tripType.equalsIgnoreCase("one-way")) {
            driver.findElement(oneWayRadio).click();
        } else if (tripType.equalsIgnoreCase("round-trip")) {
            driver.findElement(roundTripRadio).click();
        }
    }

    // Enters the origin for the flight search.
    public void enterOrigin(String origin) {
        driver.findElement(originField).clear();
        driver.findElement(originField).sendKeys(origin);
    }

    // Enters the destination for the flight search.
    public void enterDestination(String destination) {
        driver.findElement(destinationField).clear();
        driver.findElement(destinationField).sendKeys(destination);
    }

    // Enters the departure date for the flight search.
    public void enterDepartureDate(String date) {
        driver.findElement(departureDateField).clear();
        driver.findElement(departureDateField).sendKeys(date);
    }

    // Enters the return date for the flight search.
    public void enterReturnDate(String date) {
        driver.findElement(returnDateField).clear();
        driver.findElement(returnDateField).sendKeys(date);
    }

    // Clicks the search button to search for flights.
    public void searchFlights() {
        driver.findElement(searchButton).click();
    }
}
