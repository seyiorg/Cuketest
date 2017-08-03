package com.Test.Utility;

import cucumber.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import static com.Test.Utility.Hooks.driver;
import static java.lang.Thread.sleep;

/**
 * Created by olu on 25/05/2017.
 */
public class Support {

    static Properties prop = new Properties();

    private By selector;
    private String text;

    public By getSelector() {
        return selector;
    }

    public void setSelector(By selector) {
        this.selector = selector;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private static Properties readConfigFile() throws IOException {
        FileInputStream fis = new FileInputStream("Config.properties");
        prop.load(fis);
        return prop;
    }

    static String getConfigDataFileData(String data) throws IOException {
        prop = readConfigFile();
        data = prop.getProperty(data);
        return data;
    }

    /*Random string generator*/
    static String generateRandomString(String generateString) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randIndex = random.nextInt(generateString.length());
            sb.append(generateString.charAt(randIndex));
        }
        return sb.toString();
    }

    /*Captures a screen shot of the page where a failure occurs*/
    static void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) Hooks.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public WebElement getElementWhenReady(By by) throws InterruptedException {
        int i = 0;
        while (!isElementPresent(by)) {
            sleep(500);
            if (++i >= 10) {
                throw new NoSuchElementException("Element not available");
            }
        }
        return driver.findElement(by);
    }

    protected void gotoPage(String pageURL) throws IOException {
        pageURL = getConfigDataFileData(pageURL);
        driver.get(pageURL);
    }

    protected void completeTextField(By by, String text) throws InterruptedException {
        System.out.println("Trying to complete " + by);
        getElementWhenReady(by).sendKeys(text);
    }

    public void assertElementEnabled(By username) {
    }

    /*Method to verify an element has got an expected text*/
    protected void assertDisplayedText(By selector, String text) throws InterruptedException {
        Assert.assertEquals(getElementWhenReady(selector).getText(), text);
    }

    /*Clicks on an element using a 'By' locator to locate the element*/
    protected void clickOnElement(By by) throws Exception {
        driver.findElement(by).click();
        System.out.println("Just clicked on " + by);
    }

    /*Verifies an element contains the specified text*/
    protected void elementContainsText(By by, String data) throws Exception {
        Assert.assertTrue(getElementWhenReady(by).getText().contains(data));
    }
}
