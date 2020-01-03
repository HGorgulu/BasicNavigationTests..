package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

/*
            in OOP we have design patterns:
                It's a proven for specific task
                One of the most popular design pattern for WebDriver in Selenium is SingleTon
                    SingleTon means single object of something for entire project
                           --> This Object will be static and we can ensure that all tests use same driver object
                                So we can create Test suits
                                Also whenever we need to use driver, we will just call it from Driver class.
                                The same driver will be used in every class
                                the alternative is to create a new driver for each class
 */
public class Driver {
    private  static RemoteWebDriver driver;


    private Driver(){

    }
    public synchronized static RemoteWebDriver get(){
        if(driver==null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chromeHeadless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefoxHeadless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "safari":
                    if(System.getProperty("os.name").toLowerCase().contains("windows")){
                        throw new WebDriverException("You are operating Windows OS which doesn't support Safari");
                    }
                    driver = new SafariDriver();
                    break;
                case "ie":
                    if(System.getProperty("os.name").toLowerCase().contains("mac")){
                        throw new WebDriverException("You are operating Mac OS which doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                default:
                    //If browser type is wrong, stop tests and throw exception
                    throw new RuntimeException("Illegal browser type");
            }

        }
        return driver;
    }


    public static void close(){
        if (driver != null) {
            //close all browsers
            driver.quit();
            //destroy driver object
            driver = null;
        }

    }
}