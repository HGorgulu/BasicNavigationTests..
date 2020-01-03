package com.cbt.tests.BasicNavigation;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestCase_2 {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement list = driver.findElement(By.className("list-group"));
        List<WebElement> links = list.findElements(By.tagName("li"));
        if(links.size() == 48){
            System.out.println("Number of listed examples is 48... \nTEST PASSED");
        }else {
            System.out.println("Number of listed examples is not 48... \nTEST FAILED");
        }
        driver.close();
    }


}
