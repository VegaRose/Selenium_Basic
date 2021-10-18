package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void assertEqualsTask() throws Exception {
//         TODO:
//         check how many element with class "test" there are on page (5)
        int expected = 5;
        int actual = driver.findElements(By.className("test")).size();
        assertEquals(expected, actual);
//         check that value of second button is "This is also a button"
        String expected1 = "This is also a button";
        String actual1 = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertEquals(expected1, actual1);

    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:

        String expected1 = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertTrue(expected1,true);
        fail("I want this test to fail, so will!");
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String expected1 = driver.findElement(By.name("randomButton2")).getAttribute("value");
        assertFalse(expected1.equals("This is a button"));
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190
        List<WebElement> allElementsWithClass = driver.findElements(By.className("test"));

        List<WebElement> actual1 = allElementsWithClass;
        assertFalse(actual1.equals("190"));
}}
