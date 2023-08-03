package org.example.framework.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class WebdriverUtils {
        private WebDriver driver;
        WebDriverWait wait;
        public WebdriverUtils(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        }

        public void takeScreenshot(String fileName) {
            // Cast WebDriver to TakesScreenshot
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

            // Take the screenshot as File
            File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

            // Save the file to the specified location
            String screenshotPath = "src\\Evidence\\" + fileName + ".png";
            try {
                FileUtils.copyFile(screenshotFile, new File(screenshotPath));
                System.out.println("Screenshot saved: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to save screenshot!");
            }
        }
//
//        public void waitForElementToBeClickable(By locator, int timeoutInSeconds) {
//            wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
//            wait.until(ExpectedConditions.elementToBeClickable(locator));
//        }
//
//        public void waitForElementToBeVisible(By locator) {
//            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        }
    }
