// src/main/java/com/spicejet/utils/BrowserUtils.java
package com.spicejet.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {

    private static WebDriver driver;
    private static ConfigReader configReader = new ConfigReader();


    public static WebDriver initBrowser() {
        String browserType = configReader.getProperty("browser");
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        // Maximize the browser window
        driver.manage().window().maximize();
        return driver;
    }
    
    public static void quitBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
