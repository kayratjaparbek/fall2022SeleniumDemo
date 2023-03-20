package sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonTest extends BaseTest{


    @Test
    public void amazonDemo() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        /// Создание экземпляра объекта JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Прокрутка страницы вниз на 500 пикселей
        js.executeScript("window.scrollBy(0,500)");

        WebElement seeMore = driver.findElement(By.xpath("//*[@id=\"brandsRefinements\"]/ul/li[8]/span/div/a/span"));
        seeMore.click();

        List<WebElement> allBrands = driver.findElements(By.xpath("//li[contains(@id,'p_89/')]"));

        for (WebElement e : allBrands) {
            if (e.getText().equals("SAMSUNG")) {
                e.findElement(By.tagName("i")).click();
                break;
            }
        }


        Thread.sleep(10000);
    }






}
