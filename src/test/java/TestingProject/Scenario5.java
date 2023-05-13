package TestingProject;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scenario5 extends BaseDriver {
    @Test

    public void Test() {
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

        WebElement computers = driver.findElement(By.xpath("(//a[contains(text(),'Computers')])[1]"));
        action=actions.moveToElement(computers).build();
        action.perform();

        WebElement notebooks = driver.findElement(By.xpath("(//a[contains(text(),'Notebooks')])[1]"));
        action=actions.moveToElement(notebooks).click().build();
        action.perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Add to cart']")));

        WebElement addToCard = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        action=actions.moveToElement(addToCard).click().build();
        action.perform();

        WebElement added = driver.findElement(By.xpath("//p[@class='content']"));
        Assert.assertTrue("fail", added.getText().contains("has been added"));

        WebElement shoppingCard = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        action=actions.moveToElement(shoppingCard).click().build();
        action.perform();

        WebElement confirmation = driver.findElement(By.className("product-name"));
        Assert.assertTrue("fail",confirmation.getText().equals("14.1-inch Laptop"));

        WebElement checkBox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        action=actions.moveToElement(checkBox).click().build();
        action.perform();

        WebElement checkBoxBtn = driver.findElement(By.xpath("//button[@id='checkout']"));
        action=actions.moveToElement(checkBoxBtn).click().build();
        action.perform();

        WebElement country= driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));

        Select slc=new Select(country);
        slc.selectByIndex(2);

        WebElement city= driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        city.sendKeys("Salt Lake City");

        WebElement adress= driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']"));
        adress.sendKeys("Bla Bla Bla");

        WebElement zipcode= driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
        zipcode.sendKeys("34250");

        WebElement phone= driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
        phone.sendKeys("555865999");

        WebElement continueBtn= driver.findElement(By.xpath("//input[@onclick='Billing.save()']"));
        action=actions.moveToElement(continueBtn).click().build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='Shipping.save()']")));

        WebElement continueSave= driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
        action=actions.moveToElement(continueSave).click().build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='ShippingMethod.save()']")));

        WebElement continueMethod= driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']"));
        action=actions.moveToElement(continueMethod).click().build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='PaymentMethod.save()']")));

        WebElement continuePayment= driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        action=actions.moveToElement(continuePayment).click().build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='PaymentInfo.save()']")));

        WebElement continueInfo= driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']"));
        action=actions.moveToElement(continueInfo).click().build();
        action.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='ConfirmOrder.save()']")));

        WebElement confirmOrder= driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        action=actions.moveToElement(confirmOrder).click().build();
        action.perform();

        WebElement textConfirm=driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));

        Assert.assertTrue("Failed", textConfirm.getText().contains("successfully processed!"));

        WaitClose();
    }
}