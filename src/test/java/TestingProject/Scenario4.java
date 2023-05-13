package TestingProject;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Scenario4 extends BaseDriver {

    @Test
    public void Senaryo4(){
        driver.get("https://demowebshop.tricentis.com/");

        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.linkText("Log in"));
        Action action = actions.moveToElement(element).click().build();
        action.perform();

        WebElement login = driver.findElement(By.id("Email"));
        action=actions.moveToElement(login).sendKeys("kate456@gmail.com").build();
        action.perform();

        WebElement password = driver.findElement(By.id("Password"));
        action=actions.moveToElement(password).click().sendKeys("123456").build();
        action.perform();

        WebElement login2 = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        action=actions.moveToElement(login2).click().build();
        action.perform();

        WebElement loginFailed= driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));

        Assert.assertTrue("Failed", loginFailed.getText().contains("unsuccessful"));

        WaitClose();
    }

}
