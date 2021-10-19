package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen
        String inputText = "Da";
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        WebElement submit = driver.findElement(By.className("w3-btn"));
        inputField.sendKeys(inputText);
        submit.click();

        assertEquals("Please enter a number", error.getText());

    }

    @Test
    public void errorOnNumberTooSmall() throws InterruptedException {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        String smallNumber = "40";
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        WebElement submit = driver.findElement(By.className("w3-btn"));
        inputField.sendKeys(smallNumber);
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(2000);
        assertEquals("Number is too small", error.getText());
    }

    @Test
    public void errorOnNumberTooBig() throws InterruptedException {

//        BUG: if I enter number 666 no errors where seen
        String excNumber = "666";
        WebElement inputField1 = driver.findElement(By.id("numb"));
        WebElement error1 = driver.findElement(By.id("ch1_error"));
        WebElement submit1 = driver.findElement(By.className("w3-btn"));
        inputField1.sendKeys(excNumber);
        Thread.sleep(2000);
        submit1.click();
        Thread.sleep(2000);
        assertEquals("", error1.getText());
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        String bigNumber = "120";
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        WebElement submit = driver.findElement(By.className("w3-btn"));
        inputField.sendKeys(bigNumber);
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(2000);
        assertEquals("Number is too big", error.getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() throws InterruptedException {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        String validNumber = "100";
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        WebElement submit = driver.findElement(By.className("w3-btn"));
        inputField.sendKeys(validNumber);
        submit.click();

        Alert alert = driver.switchTo().alert();

        assertEquals("Square root of 100 is 10.00", alert.getText());

        alert.accept();

        assertEquals("", error.getText());





    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        String validNumber = "53";
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        WebElement submit = driver.findElement(By.className("w3-btn"));
        inputField.sendKeys(validNumber);
        submit.click();


        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 53 is 7.28", alert.getText());

        alert.accept();

        assertEquals("", error.getText());

    }
}
