package sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumExceptions extends BaseTest{

    @Test
    public void noSuchElementExceptionTest() {

        // NoSuchElementException -- Нет такого элемента
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.id("userName1")).sendKeys("Hello world");
    }

    @Test
    public void noSuchWindowExceptionTest() {

        // NoSuchWindowException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().window("id");
    }

    @Test
    public void noSuchFrameExceptionTest() {

        // noSuchFrameException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().frame(123);
    }

    @Test
    public void noSuchAlertExceptionTest() {

        // NoAlertPresentException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().alert();
    }

    @Test
    public void invalidSelectorExceptionTest() {

        // invalidSelectorException  -- Исключение выбрасывается если допущена синтаксическая ошибка в селекторе
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.xpath("//button[@type='button''][100]"));
    }

    @Test
    public void noSuchSessionException() {

        // NoSuchSessionException
        driver.quit();
        browserHelper.openURL("https://demoqa.com/text-box");
    }

    @Test
    public void staleElementReferenceExceptionTest() {

        // staleElementReferenceException
        browserHelper.openURL("https://www.amazon.com");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a/div/label/i" + "[" + count + "]")).click();
            }
        }
    }

    @Test
    public void timeOutExceptionTest() {

        // TimeOutException
        browserHelper.openURL("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();
    }

    // Нужно изучить
    // ElementNotIntractableException
    // WebDriverException
    // ElementNotSelectableException
    // ElementNotVisibleException
    // ElementClickInterceptedException
    // JavaScriptException
    // NoSuchAttributeException
    // NotFoundException
    // ScreenshotException







}
