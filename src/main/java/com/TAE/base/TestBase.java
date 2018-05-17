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
    public static Properties objectRepoProp;
    public static Properties testDataProp;

    //Constructor
    public TestBase() {
        //Retrieve and read contents from objectRepo file
        try {
            objectRepoProp = new Properties();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("C:\\Users\\prn99\\eclipse-workspace\\TAEpractical\\src\\resources\\objectRepo.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            objectRepoProp.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        //Retrieve and read contents from testData file
        try {
            testDataProp = new Properties();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("C:\\Users\\prn99\\eclipse-workspace\\TAEpractical\\src\\resources\\testData.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            testDataProp.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    //Initialising the browser
    public static WebDriver initializeBrowser() {

        String browserName = objectRepoProp.getProperty("browser");
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
//Opens URL and maximise the window
    public static void openUrl() {
        driver.get(objectRepoProp.getProperty("url"));
        driver.manage().window().maximize();

    }

    public static String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

   // public static boolean assertPageTitle(String expectedTitle){
    //    return
   // }

    public static void tearDown() {
        driver.quit();
    }


}


