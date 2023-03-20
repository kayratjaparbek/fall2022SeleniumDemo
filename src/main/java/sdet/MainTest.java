package sdet;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainTest {

        WebDriver driver;

        @BeforeClass
        public void setup() {

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                driver.get("https://demoqa.com/text-box");
        }

        @Test
        public void TextBoxTest() throws InterruptedException {

                Faker faker = new Faker();

                String name = faker.name().fullName();
                String email = faker.internet().emailAddress();
                String currentAddress = faker.address().fullAddress();
                String permanentAddress = faker.address().secondaryAddress();


                WebElement fullNameInput = driver.findElement(By.id("userName"));
                WebElement emailInput = driver.findElement(By.id("userEmail"));
                WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
                WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));


                fullNameInput.sendKeys(name);
                emailInput.sendKeys(email);
                currentAddressInput.sendKeys(currentAddress);
                permanentAddressInput.sendKeys(permanentAddress);



                /// Создание экземпляра объекта JavascriptExecutor
                JavascriptExecutor js = (JavascriptExecutor) driver;
                // Прокрутка страницы вниз на 500 пикселей
                js.executeScript("window.scrollBy(0,250)");



                WebElement submitButton = driver.findElement(By.id("submit"));
                submitButton.click();

                Thread.sleep(5000);


                WebElement actualName = driver.findElement(By.id("name"));
                WebElement actualEmail = driver.findElement(By.id("email"));
                WebElement actualCurrentAddress = driver.findElement(By.xpath("//p[@class='mb-1'][3]"));
                WebElement actualPermanentAddress = driver.findElement(By.xpath("//p[@class='mb-1'][4]"));


                String actualNameText = actualName.getText();
                String actualEmailText = actualEmail.getText();
                String actualCurrentAddressText = actualCurrentAddress.getText();
                String actualPermanentAddressText = actualPermanentAddress.getText();


                Assert.assertEquals(actualNameText, "Name:" + name);
                Assert.assertEquals(actualEmailText, "Email:" + email);
                Assert.assertEquals(actualCurrentAddressText, "Current Address :" + currentAddress);
                Assert.assertEquals(actualPermanentAddressText, "Permananet Address :" + permanentAddress);








        }

        @AfterClass
        public void close() {
                driver.close();
                driver.quit();
        }






}
