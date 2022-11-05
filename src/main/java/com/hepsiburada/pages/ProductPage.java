package com.hepsiburada.pages;

import com.hepsiburada.steps.StepDefinitions;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ProductPage {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private StepDefinitions stepDefinitions;

    private By productSelect= By.id("i0");
    private By productFields= By.xpath("(//div[@class=\"product-list\"]//div[@class=\"voltran-fragment\"])[5]");


    public ProductPage() {
        stepDefinitions = new StepDefinitions();
    }

    public void Addproduct() {

        stepDefinitions.waitUntilElementVisible(productFields);
        Assert.assertTrue(
                stepDefinitions.isVisible(productFields),
                "Istenilen element görünur degıl, test hata verdı"
        );
        logger.info("Element gorunene kadar beklenir");
        stepDefinitions.scrollToElement(productFields);
        logger.info("Elemete scroll edilir");
        stepDefinitions.clickElement(productSelect);
        logger.info("Elemente tiklanir");

        stepDefinitions.windowHandle("nutella - Hepsiburada");
        logger.info("Diger sayfaya basariyla gecirildi");



    }
}
