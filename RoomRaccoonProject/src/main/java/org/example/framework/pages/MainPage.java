package org.example.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class MainPage extends BasePage{

    public WebElement element;
    WebdriverUtils utils = new WebdriverUtils(driver);
    private By addBtn = By.xpath("//a[@class='ajaxModalLauncher btn btn-primary'][1]");
    private By titleField = By.xpath("//input[@id='staticEmail']");
    private By submitBtn = By.xpath("//input[@type='submit']");
    private By view = By.xpath("//div[contains(text(), 'My Test')]//..//a[contains(text(), 'view')]");
    public By viewButton;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void addButton() {
        element = utils.wait.until(ExpectedConditions.elementToBeClickable(addBtn));
        utils.takeScreenshot("Add button displays");
        driver.findElement(addBtn).click();
    }

    public void enterTitle(String title) {
        element = utils.wait.until(ExpectedConditions.visibilityOfElementLocated(titleField));
        driver.findElement(titleField).sendKeys(title);
        utils.takeScreenshot("Title entered");
    }

    public void submitButton() {
        element = utils.wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        driver.findElement(submitBtn).click();
        utils.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'My Test')]//..//a[contains(text(), 'view')]")));
        utils.takeScreenshot("My Test");
    }

    public void viewButton(String title){
        viewButton = By.xpath("//div[contains(text(), '"+title+"')]//..//a[contains(text(), 'view')]");
        element = utils.wait.until(ExpectedConditions.elementToBeClickable(viewButton));
        driver.findElement(viewButton).click();
        utils.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']//div[contains(text(), '"+title+"')]")));
        utils.takeScreenshot("Viewing the test");
    }

}
