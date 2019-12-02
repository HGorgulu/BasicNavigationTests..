package com.cbt.tests.TestCases1_12;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoCompleteTest {

    @Test
    public void AutoComplete() {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Autocomplete")).click();
        WebElement autoComplete = driver.findElement(By.id("myCountry"));
        autoComplete.sendKeys("United States of America");
        driver.findElement(By.cssSelector("[type='button']")).click();
        WebElement result = driver.findElement(By.id("result"));
        String actualResult = result.getText();
        String expectedResult = "You selected: United States of America";
        Assert.assertEquals(actualResult, expectedResult, "Message is wrong");
        driver.quit();
    }
}
