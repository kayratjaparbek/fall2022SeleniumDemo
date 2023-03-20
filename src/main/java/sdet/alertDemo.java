package sdet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class alertDemo extends BaseTest{

    @Test
    public void alertTest1() {
        driver.get("https://demoqa.com/alerts");

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Helper.pause(6000);

    }


    @Test
    public void testExplicitWaitAndAlert() {
        driver.get("https://demoqa.com/alerts");

        WebElement alertButton = driver.findElement(By.id("timerAlertButton"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Test
    public void thirdButton() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        WebElement thirdBtn = driver.findElement(By.id("confirmButton"));
        thirdBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);

        WebElement actualText = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(actualText.getText(), "You selected Cancel");

    }

    @Test
    public void alertTest3() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        WebElement promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Kayrat");
        alert.accept();
        Thread.sleep(3000);

        WebElement promptResult = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(promptResult.getText(), "You entered Kayrat");

    }
}
