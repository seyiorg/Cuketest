package com.Test.Utility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by olu on 25/05/2017.
 */
public class Hooks extends Support{

    static WebDriver driver;
    private static WebDriverWait wait;
    public static String randomString;


    /*Starts up an instance of webdriver for every test run*/
    @Before
    public static WebDriver getDriver() throws IOException {

        String browser = getConfigDataFileData("browser");

        switch (browser){

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Cannot Identify which browser to call");
        }
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait = new WebDriverWait(driver, 10);
        return driver;
    }

    @Before
    public static String setRandomString(){
        String strings = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        randomString = generateRandomString(strings);
        return randomString;
    }


    /*Closes a session of webdrive instance after a test run*/
    @After
    public static void tearDown(Scenario scenario){
        embedScreenshot(scenario);
        driver.quit();
    }
}
