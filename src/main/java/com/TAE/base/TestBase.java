package com.TAE.base;

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
    public static Properties prop;

    //Constructor
    public TestBase() {
        //Retrieve and read contents from properties file
        try {
            prop = new Properties();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("C:\\Users\\prn99\\eclipse-workspace\\TAEpractical\\src\\resources\\config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    //Initialising the browser
    public static WebDriver initializeBrowser() {

        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\prn99\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "firefoxDriverPath");
            driver = new FirefoxDriver();
        }
        // driver.get(prop.getProperty("url"));
        return driver;
    }

    public static void openUrl() {
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();

    }

    public static String validatePageTitle() {
        String title = driver.getTitle();
        return title;
    }


}


