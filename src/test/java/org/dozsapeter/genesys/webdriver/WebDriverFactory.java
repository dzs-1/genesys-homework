package org.dozsapeter.genesys.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

        public static WebDriver getDriver() {

            WebDriver driver;
            String browserName = System.getProperty("browser", WebDriverType.SAFARI.toString()).toUpperCase();
            WebDriverType driverType = WebDriverType.valueOf(browserName);

            switch (driverType) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                default:
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }
            driver.manage().window().maximize();
            return driver;
        }
    }