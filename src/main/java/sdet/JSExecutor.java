package sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutor extends BaseTest{



    @Test
    public void test1() {
        browserHelper.openURL("https://www.etsy.com/");
        WebElement careersLink = driver.findElement(By.xpath("//a[@href='https://www.etsy.com/careers?ref=ftr']"));
        Helper.jsClick(driver, careersLink);
        Helper.pause(4000);

        Helper.jsScrollDownThePage(driver, "600");
        Helper.jsScrollDownThePage(driver, "600");
        Helper.pause(4000);
    }





}
