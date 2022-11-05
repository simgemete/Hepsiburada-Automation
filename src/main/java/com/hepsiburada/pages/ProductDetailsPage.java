package com.hepsiburada.pages;

import com.hepsiburada.base.BaseTest;
import com.hepsiburada.steps.StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.hepsiburada.base.BaseTest.getWebDriver;


public class ProductDetailsPage  {
    private Logger logger = LoggerFactory.getLogger(getClass());


    private StepDefinitions stepDefinitions;

    private final By addToCardButton = By.xpath("//button[@id=\"addToCart\"]");
    private final By closeButton = By.xpath("//a[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']");

    private final By addToCardButtonLocater2 = By.xpath("//button[@class='add-to-basket button small']");

    private final By goToCart = By.xpath("//button[text()='Sepete git']");

    private final By sellerName = By.xpath("//span[@class='seller']//a");

    private final By secondSellerName = By.xpath("(//div[@class='merchant-info']//a)[1]");

    private final By productTitle = By.cssSelector(".product-name.best-price-trick");


    public ProductDetailsPage() {
        stepDefinitions = new StepDefinitions();
    }



    public void AddToCart() {

        stepDefinitions.clickElement(addToCardButton);
        logger.info("Sepete urun eklenir");
        stepDefinitions.waitUntilElementVisible(closeButton);
        logger.info("Carpi butonu gorunur olana kadar beklenir");
        stepDefinitions.clickElement(closeButton);
        logger.info("Carpi butonuna tiklanir");
        stepDefinitions.clickElement(addToCardButtonLocater2);
        logger.info("Ikinci ürüne tiklanir");
        stepDefinitions.waitUntilElementVisible(goToCart);
        logger.info("Sepete ekle butonu gorunene kadar bekle");
        stepDefinitions.clickElement(goToCart);
        logger.info("Sepete ekle butonuna tiklanir");



    }
    public List<String> getSellerName(){
        List<String> sellers = new ArrayList<>();
        stepDefinitions.waitUntilElementVisible(sellerName);
        sellers.add(stepDefinitions.getText(sellerName).toLowerCase());
        sellers.add(stepDefinitions.getText(secondSellerName).toLowerCase());
        logger.info("Satici adi listelendi");
        return sellers;

    }

    public String getProductName(){
        logger.info("Urun adi getirildi");
        return stepDefinitions.getText(productTitle).trim().toLowerCase();
    }

}
