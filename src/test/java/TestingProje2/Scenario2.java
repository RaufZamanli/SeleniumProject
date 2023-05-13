package TestingProje2;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario2 extends BaseDriver {

    @Test

    public void Test() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement register = driver.findElement(By.linkText("Register"));

        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(register).click().build();
        action.perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gender-male")));

        WebElement element = driver.findElement(By.id("gender-male"));
        action=actions.moveToElement(element).click().build();
        action.perform();

        WebElement firstname= driver.findElement(By.id("FirstName"));
        firstname.sendKeys("Kate");

        WebElement lastname= driver.findElement(By.id("LastName"));
        lastname.sendKeys("Johnson");

        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("kate456@gmail.com");

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("123456");

        WebElement confirmPassword= driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("123456");

        WebElement registerButton= driver.findElement(By.id("register-button"));

        action=actions.moveToElement(registerButton).click().build();
        action.perform();

        WebElement confirmation= driver.findElement(By.xpath("//div[@class='validation-summary-errors']//li"));


        Assert.assertEquals("The specified email already exists", confirmation.getText());

        WaitClose();

    }
}