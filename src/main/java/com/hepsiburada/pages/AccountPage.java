package com.hepsiburada.pages;

import com.hepsiburada.steps.StepDefinitions;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class AccountPage {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private StepDefinitions stepDefinitions;

    private final By mailPlc = By.xpath("//input[@name='username']");
    private final By mailClick = By.id("btnLogin");
    private final By passwordPlc = By.xpath("//input[@name='password']");

    private final By hesabimTxt = By.xpath("//a[@data-test-id=\"account\"]");

    private final By passwordClick = By.xpath("//button[@name='btnEmailSelect']");

    public AccountPage() {
        stepDefinitions = new StepDefinitions();
    }

    public void loginAccount (String mail, String password) {
        stepDefinitions.sendKeys(mailPlc,mail);
        Assert.assertEquals(
                stepDefinitions.getAttributeValue(mailPlc, "value"),
                mail,
                "Degerler eslesmedi, test fail verdi"
        );
        logger.info("Mail kismina " +mail+ " girildi");
        stepDefinitions.clickElement(mailClick);

        stepDefinitions.sendKeys(passwordPlc,password);
        Assert.assertEquals(
                stepDefinitions.getAttributeValue(passwordPlc, "value"),
                password,
                "Degerler eslesmedi, test fail verdi"
        );
        logger.info("Password kismina " +password+ " girildi");

        stepDefinitions.clickElement(passwordClick);
        logger.info("");
        stepDefinitions.waitUntilElementVisible(hesabimTxt);
        Assert.assertEquals(
                stepDefinitions.getAttributeValue(hesabimTxt,"title"),
                "Hesabım",
                "Hesaba giris basarısız oldu, Test Fail"
        );
        logger.info("Basarili bir sekilde giris yapildi");




    }

}
