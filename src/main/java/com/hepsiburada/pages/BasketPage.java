package com.hepsiburada.pages;

import com.hepsiburada.steps.StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {
    private Logger logger = LoggerFactory.getLogger(getClass());


    private StepDefinitions stepDefinitions;

    private final By sellerName = By.xpath("//div[@class='merchantText_3iHjm']//a");

    private final By productTitle = By.xpath("//div[@class='product_name_3Lh3t']//a");


    public BasketPage() {stepDefinitions = new StepDefinitions();




    }
    public List<String> getSellerName(){
        List<String> sellers = new ArrayList<>();
        stepDefinitions.waitUntilElementVisible(sellerName);
        for (WebElement element : stepDefinitions.findAll(sellerName)
                ) {
            sellers.add(element.getText().toLowerCase());


        }
        logger.info("Satıcı adı listesi getirildi");
        return sellers;

    }

    public List<String> getProductTitles(){
        List<String> titles = new ArrayList<>();
        for (WebElement element: stepDefinitions.findAll(productTitle)
             ) {
            titles.add(element.getText().trim().toLowerCase());
        }
        logger.info("Urun adının listesi getirildi");
        return titles;
    }
}
