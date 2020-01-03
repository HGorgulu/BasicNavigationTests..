package com.cbt.tests.BasicNavigation;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyStringEquality;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase_7 {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();

        driver.findElement(By.name("email")).sendKeys("testers@email");
        String expectedErrorMessage = "email address is not a validEmail format is not correct";
        String actualErrorMessage1 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[2]")).getText();
        String actualErrorMessage2 = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[3]")).getText();
        String actualErrorMessage = actualErrorMessage1 + actualErrorMessage2;
        VerifyStringEquality.verifyStrings(expectedErrorMessage, actualErrorMessage);
        driver.close();
    }
}
