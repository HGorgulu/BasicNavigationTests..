package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) {
        ChromeTest();
        fireFoxTest();
        EdgeTest();
    }

    public static void ChromeTest() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        String actualTitleOfGoogle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String actualTitleOfEtsy = driver.getTitle();
        driver.navigate().back();
        System.out.println("Previous and Current title of Google page test: ");
        StringUtility.verifyEquals(actualTitleOfGoogle, driver.getTitle());
        driver.navigate().forward();
        System.out.println("Previous and Current title of Etsy page test: ");
        StringUtility.verifyEquals(actualTitleOfEtsy, driver.getTitle());
        driver.quit();

    }

    public static void fireFoxTest() {
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        String actualTitleOfGoogle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String actualTitleOfEtsy = driver.getTitle();
        driver.navigate().back();
        System.out.println("Previous and Current title of Google page test: ");
        StringUtility.verifyEquals(actualTitleOfGoogle, driver.getTitle());
        driver.navigate().forward();
        System.out.println("Previous and Current title of Etsy page test: ");
        StringUtility.verifyEquals(actualTitleOfEtsy, driver.getTitle());
        driver.quit();

    }

    public static void EdgeTest() {
        WebDriver driver = BrowserFactory.getDriver("edge");
        driver.get("https://google.com");
        String actualTitleOfGoogle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String actualTitleOfEtsy = driver.getTitle();
        driver.navigate().back();
        System.out.println("Previous and Current title of Google page test: ");
        StringUtility.verifyEquals(actualTitleOfGoogle, driver.getTitle());
        driver.navigate().forward();
        System.out.println("Previous and Current title of Etsy page test: ");
        StringUtility.verifyEquals(actualTitleOfEtsy, driver.getTitle());
        driver.quit();

    }
}
