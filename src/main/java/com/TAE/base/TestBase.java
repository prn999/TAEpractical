package com.TAE.base;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class TestBase {

    //Global variables
    public static WebDriver driver;
    public static Properties objectRepoProp;
    public static Properties testDataProp;

    //Constructor
    public TestBase() {
        //Retrieve and read contents from objectRepo and testData file
        try {
            objectRepoProp = new Properties();
            testDataProp = new Properties();

            FileInputStream fis1 = null;
            FileInputStream fis2 = null;

            try {
                fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\resources\\objectRepo.properties");
                fis2 = new FileInputStream(System.getProperty("user.dir") + "\\src\\resources\\testData.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            objectRepoProp.load(fis1);
            testDataProp.load(fis2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    /**
     * Initialising the browser
     *
     * @return driver
     */
    public static WebDriver initializeBrowser() {

        String browserName = objectRepoProp.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", objectRepoProp.getProperty("chromeDriverPath"));
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", objectRepoProp.getProperty("firefoxDriverPath"));
            driver = new FirefoxDriver();
        }
        return driver;
    }

    /**
     * Opens URL and maximise the window
     */
    public static void openUrl() {
        driver.get(objectRepoProp.getProperty("url"));
        driver.manage().window().maximize();
    }

    /**
     * Getting the page title
     *
     * @return title
     */
    public static String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    /**
     * Quit the browser
     */
    public static void tearDown() {
        driver.quit();
    }


}


