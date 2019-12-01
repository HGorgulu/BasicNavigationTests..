package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyStringEquality;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase_5 {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();

        driver.findElement(By.name("lastname")).sendKeys("123");
        String expectedErrorMessage = "The last name can only consist of alphabetical letters and dash";
        String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[3]")).getText();
        VerifyStringEquality.verifyStrings(expectedErrorMessage, actualErrorMessage);
        driver.close();
    }


}
