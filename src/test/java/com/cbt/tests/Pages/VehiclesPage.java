package com.cbt.tests.Pages;

import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class VehiclesPage extends BasePage {

    @FindBy(css="[title='Create Car']")
    public WebElement createACarElement;

    public void clickToCreateACar(){
        BrowserUtils.waitForVisibility(createACarElement,10);
        BrowserUtils.waitForClickablility(createACarElement,10);
        createACarElement.click();
    }
}
