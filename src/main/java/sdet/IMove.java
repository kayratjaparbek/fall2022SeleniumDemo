package sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class IMove extends BaseTest{
    WebElement dresser;
    WebElement bed;
    WebElement tv;



    @Test
    public void test1() {
        driver.get("https://www.imoving.com/");

        // Находим и выбираем первого меню
        WebElement houseTypeMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeMenu);
        select.selectByIndex(1);
        Helper.pause(3000);

        // Находим и выбираем из второго меню
        WebElement moveSizeMenu = driver.findElement(By.xpath("(.//select[@tabindex='-98'])[2]"));
        Select select1 = new Select(moveSizeMenu);
        select1.selectByValue("9509");
        Helper.pause(3000);

        // Нажимаем на кнопку Submit
        WebElement submitClick = driver.findElement(By.xpath(".//button[text()='Compare Quotes']"));
        submitClick.click();
        Helper.pause(3000);

        driver.findElement(By.xpath(".//a[@ng-click='vm.ok()']")).click();
        Helper.pause(3000);

        driver.findElement(By.xpath(".//a[@ng-click='bx.close()']")).click();
        Helper.pause(3000);

        driver.findElement(By.xpath("//*[@id=\"nextInventoryTutorial\"]")).click();
        Helper.pause(3000);

        driver.findElement(By.xpath("//*[@id=\"nextNextRoomTutorial\"]")).click();
        Helper.pause(3000);

        driver.findElement(By.xpath("//*[@id=\"closeTutorial2\"]")).click();
        Helper.pause(3000);


        // Выбираем элементы в меню DRESSER
        Actions actions = new Actions(driver);
        dresser = driver.findElement(By.xpath("//*[@style=\"z-index: 15\"]"));
        actions.moveToElement(dresser).perform();
        driver.findElement(By.xpath("(.//div[@class='quantity-buttons'])[1]")).click();
        actions.doubleClick(driver.findElement(By.xpath("(.//button[@class='quantity-plus'])[2]"))).perform();
        Helper.pause(3000);











    }






}
