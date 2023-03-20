package sdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



public class checkBox extends BaseTest{

    WebElement home;
    WebElement desktop;
    WebElement commands;
    String actual;

    @Test
    public void checkBoxTest() throws InterruptedException {
        driver.get("https://demoqa.com/checkbox");

        home = driver.findElement(By.xpath(".//button[@title='Toggle']"));
        home.click();

        desktop = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button"));
        desktop.click();

        commands = driver.findElement(By.xpath("(.//span[@class='rct-checkbox'])[4]"));
        commands.click();

        actual = driver.findElement(By.xpath(".//span[@class='text-success']")).getText();
    }

    @Test
    public void testHome() throws InterruptedException {
        Assert.assertTrue(home.isEnabled());
        Thread.sleep(1000);
    }

    @Test
    public void testDesktop() throws InterruptedException {
        Assert.assertTrue(desktop.isEnabled());
        Thread.sleep(1000);
    }

    @Test
    public void testCommands() throws InterruptedException {
        Assert.assertTrue(commands.isEnabled());
        Thread.sleep(1000);
    }

    @Test
    public void testChecking() throws InterruptedException {
        Assert.assertEquals(actual, "commands");

        Thread.sleep(4000);
    }

    @Test
    public void rightClickTest() {

        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(), "You have done a double click");
        Helper.pause(3000);

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();
        Assert.assertEquals(driver.findElement(By.id("rightClickMessage")).getText(), "You have done a right click");
        Helper.pause(3000);

        WebElement oneClick = driver.findElement(By.xpath(".//button[text()='Click Me']"));
        actions.click(oneClick).perform();
        Assert.assertEquals(driver.findElement(By.id("dynamicClickMessage")).getText(), "You have done a dynamic click");
        Helper.pause(3000);
    }


    @Test
    public void testMoveToElementAndSelect() {
        driver.get("https://www.imoving.com/");
        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        select.selectByValue("1080");
        Helper.pause(3000);
        select.selectByVisibleText("My Apartment");
        Helper.pause(3000);
        select.selectByIndex(3);
        Helper.pause(3000);

















    }
}
