//package SDET;
//
//import com.github.javafaker.Faker;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class PageObject {
//    private WebDriver driver;
//    private Faker faker;
//
//    private WebElement fullName;
//    private WebElement email;
//    private WebElement currentAddress;
//    private WebElement permanentAddress;
//    private WebElement submitButton;
//
//    public PageObject(WebDriver driver) {
//        this.driver = driver;
//        this.faker = new Faker();
//
//        // Находим элементы на странице
//        this.fullName = driver.findElement(By.id("userName"));
//        this.email = driver.findElement(By.id("email"));
//        this.currentAddress = driver.findElement(By.id("currentAddress"));
//        this.permanentAddress = driver.findElement(By.id("permanentAddress"));
//        this.submitButton = driver.findElement(By.id("submit"));
//    }
//
//    public void generateFake() {
//        // Генерируем случайные данные
//
//        String fullNameValue = faker.name().fullName();
//        String emailValue = faker.internet().emailAddress();
//        String currentAddressValue = faker.address().fullAddress();
//        String permanentAddressValue = faker.address().fullAddress();
//
//        // Заполняем поля на странице
//        fullName.sendKeys(fullNameValue);
//        email.sendKeys(emailValue);
//        currentAddress.sendKeys(currentAddressValue);
//        permanentAddress.sendKeys(permanentAddressValue);
//    }
//
//    public void submitForm() {
//        // Нажимаем на кнопку Submit
//        submitButton.click();
//    }
//
//    public void checkResults() {
//        // Находим элементы на странице с результатами и проверяем, что они совпадают с веденными данными
//
//        WebElement nameResult = driver.findElement(By.id("name"));
//        WebElement emailResult = driver.findElement(By.id("email"));
//        WebElement currentAddressResult = driver.findElement(By.cssSelector("#output #currentAddress"));
//        WebElement permanentAddressResult = driver.findElement(By.cssSelector("#output #permanentAddress"));
//
//        String fullNameValue = fullName.getAttribute("value");
//        String emailValue = email.getAttribute("value");
//        String currentAddressValue = currentAddress.getAttribute("value");
//        String permanentAddressValue = permanentAddress.getAttribute("value");
//
//
//        assert nameResult.getText().equals("Name:" + fullNameValue);
//        assert emailResult.getText().equals(("Email:" + emailValue));
//        assert currentAddressResult.getText().equals("Current Address:" + currentAddressValue);
//        assert permanentAddressResult.getText().equals("Permanent Address:" + permanentAddressValue);
//    }
//
//
//
//
//
//}
