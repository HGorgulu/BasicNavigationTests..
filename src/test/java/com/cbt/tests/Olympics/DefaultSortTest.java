package com.cbt.tests.Olympics;

import com.cbt.utilities.Driver2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.*;

public class DefaultSortTest {
    String tableXpath ="//*[@class='wikitable sortable plainrowheaders jquery-tablesorter']";

    @BeforeMethod
    public void setUp() {
        Driver2.intiDriver();
        //Step 1: Go to Website
        Driver2.getDriver2().get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
    }
    @AfterMethod()
    public void tearDown(){
        Driver2.closeDriver2();
    }

    @Test
    public void testCase1(){

        List<Integer> ranksSorted = new ArrayList<>();
        WebElement rank;
        for(int i =1;i<=10;i++){
            rank= Driver2.getDriver2().findElement(By.xpath(tableXpath+"/tbody/tr["+i+"]/td"));
            Integer rankNumber = Integer.parseInt(rank.getText().trim());
            ranksSorted.add(rankNumber);
        }

        //Step 2: Verify that by default the Medal table is sorted by rank
        Assert.assertTrue(isListSorted(ranksSorted),"List is not sorted");

        //Step 3: Click NOC tab link
        Driver2.getDriver2().findElement(By.xpath(tableXpath+"/thead/tr/th[2]")).click();
        List<WebElement> countryNamesElements = Driver2.getDriver2().findElements(By.cssSelector("th[style='background-color:#f8f9fa;text-align:left'] a"));
        List<String> countryNames = new ArrayList<>();
        for(int i=0;i<10;i++){
            countryNames.add(countryNamesElements.get(i).getText());
        }

        //Step 4: Verify that the table is now sorted by the country names
        Assert.assertTrue(isListSorted(countryNames),"Country Names are not sorted");

        List<Integer> ranksUnsorted = new ArrayList<>();
        WebElement NewRank;
        for(int i =1;i<=11;i++){
            NewRank= Driver2.getDriver2().findElement(By.xpath(tableXpath+"/tbody/tr["+i+"]/td"));
            if(NewRank.getText().equals("11–86")){continue;}
            Integer rankNumber = Integer.parseInt(NewRank.getText().trim());
            ranksUnsorted.add(rankNumber);
        }
        //Step 5: Verify that the Rank Column is not in ascending order anymore
        Assert.assertFalse(isListSorted(ranksUnsorted),"List is still sorted");

    }




    @Test
    public void testCase2(){
        Assert.assertEquals(getCountryWithLeastGold(),"Italy");
        Assert.assertEquals(getCountryWithLeastSilver(),"South Korea");
        Assert.assertEquals(getCountryWithLeastBronze(),"Italy");

    }

    private boolean isListSorted(List list){
        List copy = new ArrayList(list);
        System.out.println("Original: " + list);
        Collections.sort(copy);
        System.out.println("Copy: "+ copy);
        return copy.equals(list);

    }
    private String getCountryWithLeastGold(){
        WebElement header = Driver2.getDriver2().findElement(By.xpath(tableXpath+"/thead/tr/th[3]"));
        header.click();
        WebElement country = Driver2.getDriver2().findElement(By.cssSelector("th[style='background-color:#f8f9fa;text-align:left'] a"));
        return country.getText();
    }
    private String getCountryWithLeastSilver(){
        WebElement header = Driver2.getDriver2().findElement(By.xpath(tableXpath+"/thead/tr/th[4]"));
        header.click();
        WebElement country = Driver2.getDriver2().findElement(By.cssSelector("th[style='background-color:#f8f9fa;text-align:left'] a"));
        return country.getText();
    }
    private String getCountryWithLeastBronze(){
        WebElement header = Driver2.getDriver2().findElement(By.xpath(tableXpath+"/thead/tr/th[5]"));
        header.click();
        WebElement country = Driver2.getDriver2().findElement(By.cssSelector("th[style='background-color:#f8f9fa;text-align:left'] a"));
        return country.getText();
    }

}
