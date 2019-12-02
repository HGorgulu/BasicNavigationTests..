package com.cbt.tests.TestCases1_12;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases_HW {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();

    }

    @Test(description = "Verify that DOB error message is displayed")
    public void testCase1() {
        String expectedResult = "The date of birth is not valid";
        driver.findElement(By.name("birthday")).sendKeys("wrong_dub");
        BrowserUtils.wait(1);
        String actualResult = driver.findElement(By.xpath("//small[@style='display: block;']")).getText();
        WebElement errorMessage = driver.findElement(By.xpath("//small[@style='display: block;']"));
        Assert.assertTrue("Error message is not displayed", errorMessage.isDisplayed());
        Assert.assertEquals(actualResult, expectedResult, "Warning Message is not correct");
    }

    @Test(description = "Verify that c++,java,JavaScript is displayed")
    public void test2() {
        WebElement cPlusPlus = driver.findElement(By.cssSelector("label[for='inlineCheckbox1']"));
        WebElement java = driver.findElement(By.cssSelector("label[for='inlineCheckbox2']"));
        WebElement JavaScript = driver.findElement(By.cssSelector("label[for='inlineCheckbox3']"));

        Assert.assertTrue(cPlusPlus.isDisplayed());
        Assert.assertTrue(java.isDisplayed());
        Assert.assertTrue(JavaScript.isDisplayed());

    }

    @Test(description = "Verify that invalid input for the first name box gives warning message")
    public void test3() {
        String expectedResult = "first name must be more than 2 and less than 64 characters long";
        driver.findElement(By.name("firstname")).sendKeys("abc");
        BrowserUtils.wait(2);
        String actualResult = driver.findElement(By.xpath("/small[text( )='first name must be more than 2 and less than 64 characters long']")).getText();
        WebElement warningMessage = driver.findElement(By.xpath("/small[text( )='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue("Warning message is not displayed!", warningMessage.isDisplayed());
        Assert.assertEquals(actualResult, expectedResult, "Warning message is not correct");

    }

    @Test(description = "Verify that invalid input to last name box gives error message ")
    public void test4() {
        String expectedResult = "The last name must be more than 2 and less than 64 characters long";
        driver.findElement(By.name("lastname")).sendKeys("abc");
        BrowserUtils.wait(2);
        String actualResult = driver.findElement(By.xpath("//small[text( )='The last name must be more than 2 and less than 64 characters long']")).getText();
        WebElement errorMessage = driver.findElement(By.xpath("//small[text( )='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue("Error message is not displayed", errorMessage.isDisplayed());
        Assert.assertEquals(actualResult, expectedResult, "Warning Message is not correct");
    }


    @Test(description = "Verify that after successful sign up verification message is displayed")
    public void testCase5() {
        String expectedResult = "You've successfully completed registration!";
        driver.findElement(By.name("firstname")).sendKeys("Yavuz");
        driver.findElement(By.name("lastname")).sendKeys("Can");
        driver.findElement(By.name("username")).sendKeys("yacan");
        driver.findElement(By.name("email")).sendKeys("yacan@email.com");
        driver.findElement(By.name("password")).sendKeys("Yav123");
        driver.findElement(By.name("phone")).sendKeys("469-123-34-34");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("11/11/1991");
        driver.findElement(By.cssSelector("[id='inlineCheckbox2']")).click();
        Select jobTitle = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        jobTitle.selectByVisibleText("SDET");
        Select department = new Select(driver.findElement(By.cssSelector("[name='department']")));
        department.selectByVisibleText("MCR");
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(3);
        String actualResult = driver.findElement(By.xpath("//p[contains(text(),'You')]")).getText();
        WebElement verificationMessage = driver.findElement(By.xpath("//p[contains(text(),'You')]"));
        Assert.assertTrue("Message is not displayed", verificationMessage.isDisplayed());
        Assert.assertEquals(actualResult, expectedResult, "Verification message is not displayed properly");
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}


