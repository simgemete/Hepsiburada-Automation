package com.hepsiburada.tests;

import com.hepsiburada.base.BaseTest;
import com.hepsiburada.pages.*;
import com.hepsiburada.steps.StepDefinitions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hepsiburada extends BaseTest {
    private final String url = "https://www.hepsiburada.com/";
    private final String mail = "testuser578@hotmail.com";
    private final String password = "Testuser57";

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void AddProductToCartWithLogin() throws InterruptedException {
        final StepDefinitions stepDefinitions = new StepDefinitions();
        final MainPage mainPage = new MainPage();
        final AccountPage accountPage = new AccountPage();
        final ProductPage productPage = new ProductPage();
        final ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        final BasketPage basketPage = new BasketPage();
        stepDefinitions.navigateToUrl(url); // sıteye gıder
        mainPage.login();// login sayfasına gider
        accountPage.loginAccount(mail, password); // logın olunur
        mainPage.search("nutella");// urun aratılır
        productPage.Addproduct();

        List<String> sellersName = new ArrayList<>();
        sellersName.addAll(productDetailsPage.getSellerName());
        Collections.sort(sellersName);

        String title = productDetailsPage.getProductName();

        productDetailsPage.AddToCart();//urun sepete eklenir.


        List<String> sellersNameSecond = new ArrayList<>();
        sellersNameSecond.addAll(basketPage.getSellerName());
        Collections.sort(sellersNameSecond);

        System.out.println("list1 " + sellersName);
        System.out.println("List2 " + sellersNameSecond);
        for (int i=0;i<sellersName.size();i++){
            Assert.assertEquals(sellersName.get(i), sellersNameSecond.get(i), "Satıcılar farklı geliyor !!!");
        }
        logger.info("Farkli saticilardan urun eklendiği dogrulandi");

        for (String name: basketPage.getProductTitles()
        ) {
            Assert.assertEquals(name,title,"ürün adı aynı değil !!!");
        }
        logger.info("Dogru urun eklendigi dogrulandı");
    }

    @Test
    public void AddProductToCart() throws InterruptedException {
        final StepDefinitions stepDefinitions = new StepDefinitions();
        final MainPage mainPage = new MainPage();
        final ProductPage productPage = new ProductPage();
        final ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        final BasketPage basketPage = new BasketPage();
        stepDefinitions.navigateToUrl(url); // sıteye gıder
        mainPage.search("nutella");// urun aratılır
        productPage.Addproduct();// urune tıklanır.
        List<String> sellersName = new ArrayList<>();
        sellersName.addAll(productDetailsPage.getSellerName());
        Collections.sort(sellersName);
        String title = productDetailsPage.getProductName();
        productDetailsPage.AddToCart();//urun sepete eklenir.
        List<String> sellersNameSecond = new ArrayList<>();
        sellersNameSecond.addAll(basketPage.getSellerName());
        Collections.sort(sellersNameSecond);
        System.out.println("list1 " + sellersName);
        System.out.println("List2 " + sellersNameSecond);
        for (int i=0;i<sellersName.size();i++){
            Assert.assertEquals(sellersName.get(i), sellersNameSecond.get(i), "Satıcılar farklı geliyor !!!");
        }
        logger.info("Farkli saticilardan urun eklendiği dogrulandi");

        for (String name: basketPage.getProductTitles()
             ) {
            Assert.assertEquals(name,title,"ürün adı aynı değil !!!");
            System.out.println(name);
        }
        logger.info("Dogru urun eklendigi dogrulandı");


    }
}
