package com.hepsiburada.pages;

import com.hepsiburada.steps.StepDefinitions;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private StepDefinitions stepDefinitions;
    private final By girisYapField = By.id("myAccount");
    private final By girisBtn = By.xpath("//a[@id='login']");
    private final By searchBtn = By.xpath("//div[@class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']");

    private final By cookieAccept = By.id("onetrust-accept-btn-handler");

    private final By searchInput =By.xpath("//input[@aria-autocomplete='list']");

    public MainPage() {
        stepDefinitions = new StepDefinitions();
    }

    public void login() {
        stepDefinitions.scrollToElement(girisYapField);
        logger.info("Elemente scroll edildi");
        stepDefinitions.waitUntilElementVisible(girisBtn);
        logger.info("Giris butonu elementi gorunene kadar beklendi");
        stepDefinitions.clickElement(girisBtn);
        logger.info("Giris butonuna tiklandi");
    }

    public void search(String txt) {
        try {
            stepDefinitions.clickElement(cookieAccept);
            logger.info("Cerezler kabul edildi");
            stepDefinitions.waitUntilElementVisible(searchInput);
            logger.info("Arama butonunun gorunur olmasi beklendi");
            stepDefinitions.sendKeys(searchInput, txt);
            logger.info("Arama butonuna nutella yazilir ");
            stepDefinitions.clickElement(searchBtn);
            logger.info("Arama butonuna tiklanir");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
