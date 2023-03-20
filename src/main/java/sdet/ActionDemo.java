package sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionDemo extends BaseTest{

    @Test
    public void testRadioButton() throws InterruptedException {
       driver.get("https://demoqa.com/radio-button");

        WebElement yesRadio = driver.findElement(By.xpath(".//label[@for='yesRadio']"));
        yesRadio.click();

        Thread.sleep(6000);

        Assert.assertTrue(yesRadio.isEnabled());


    }




}
