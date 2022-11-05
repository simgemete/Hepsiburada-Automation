package com.hepsiburada.steps;

import com.hepsiburada.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public class StepDefinitions extends BaseTest{
    private Logger logger = LoggerFactory.getLogger(getClass());
    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor;
    private WebDriverWait webDriverWait;
    private Actions actions;



    public StepDefinitions() {
        driver = BaseTest.getWebDriver();
        javascriptExecutor = (JavascriptExecutor) driver;
        webDriverWait = new WebDriverWait(driver, 30L, 100L);
        actions = new Actions(driver);
    }

    public void navigateToUrl(String url) {
        driver.get(url);
        logger.info(url + " adresine gidildi");
    }

    public WebElement findElement(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitUntilElementVisible(By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementClickable(By by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilTextToBePresentInElement(By by, String text) {
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(findElement(by), text));
    }

    public void windowHandle(String window){
        Set<String> winSet = driver.getWindowHandles();
        for (String each:winSet){
            if(!each.equalsIgnoreCase(window)){
                driver.switchTo().window(each);
                logger.info(window + " ekranina gecis yapildi");
            }
        }
    }



    public boolean isVisible(By by) {
        return findElement(by).isDisplayed();
    }

    public boolean isSelected(By by) {
        return findElement(by).isSelected();
    }

    public void clickElement(By by) {
        findElement(by).click();
        logger.info("Elemente tiklandi");
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void clear(By by) {
        findElement(by).clear();
    }

    public List<WebElement> findAll(By by){
        return  driver.findElements(by);
    }

    public void scrollToElement(By by) {
        actions.moveToElement(findElement(by)).build().perform();
    }

    public String getAttributeValue(By by, String attribute) {
        return findElement(by).getAttribute(attribute);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void clickByJavascript(By by) {
        javascriptExecutor.executeScript("arguments[0].click();", findElement(by));
    }
}
