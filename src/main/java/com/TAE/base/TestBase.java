package com.TAE.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;


public class TestBase {

    //Global variables
    public static WebDriver driver;
    public static Properties objectRepoProp;
    public static Properties testDataProp;
    public static Properties log4jprops;

    /**
     *TestBase Constructor
     *Retrieves and reads contents from the objectRepo and testData file
     */
    public TestBase() {

        try {
            objectRepoProp = new Properties();
            testDataProp = new Properties();
            //log4jprops = new Properties();

            FileInputStream fis1 = null;
            FileInputStream fis2 = null;


            try {
                fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\resources\\objectRepo.properties");
                fis2 = new FileInputStream(System.getProperty("user.dir") + "\\src\\resources\\testData.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


           // log4jprops.load(new FileInputStream(System.getProperty("user.dir")+ "\\src\\resources\\log4j.properties"));
            //log4jprops.setProperty("log4j.appender.File.File", System.getProperty("user.dir")+"\\test-output\\Default Suite" + "logging.log");

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

        String OSName = System.getProperty("os.name");
        String browserName = objectRepoProp.getProperty("browser");

        //windows 32 bit chrome driver
        if (browserName.equalsIgnoreCase("chrome") && OSName.toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\browser drivers\\chromedriver.exe");
            driver = new ChromeDriver();

            //windows 64 bit firefox driver
        } else if (browserName.equalsIgnoreCase("firefox")&& OSName.toLowerCase().contains("win")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\browser drivers\\geckodriver.exe");
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

    /**
     * Capture screen shot
     */
        public static void captureScreen(WebDriver driver, String screenName) throws IOException{

            Date date = new Date();
            Timestamp time = new Timestamp(date.getTime());
            String timeStamp = time.toString();
            timeStamp = timeStamp.replace(',','_');
            timeStamp = timeStamp.replace(':','_');

            TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);

        String dest = System.getProperty("user.dir")+"//screenshots//"+ screenName +"_"+timeStamp+".png";

        File target = new File(dest);
        FileUtils.copyFile(src, target);

      //  return dest;
    }

}


