package sdet;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UploadAndDownloadDemo extends BaseTest{

    @Test
    public void test1() {
        driver.navigate().to("https://demoqa.com/upload-download");

        driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\User\\Pictures\\upload.jpg");
        Helper.pause(3000);





    }







}
