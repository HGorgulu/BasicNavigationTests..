package com.cbt.tests.BasicNavigation;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyStringEquality;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase_8 {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.name("phone")).sendKeys("5711234354");
        String expectedErrorMessage = "Phone format is not correct";
        String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/small[2]")).getText();
        VerifyStringEquality.verifyStrings(expectedErrorMessage, actualErrorMessage);
        driver.close();
    }
}

