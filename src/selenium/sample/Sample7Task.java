package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void selectCheckBox() throws Exception {
//         TODO:
//        check that none of the checkboxes are ticked
//        tick  "Option 2"
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
//        click result
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
        assertFalse(checkBox.isSelected());
       }

        WebElement Option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox']"));
        WebElement Option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        WebElement Option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        WebElement result = driver.findElement(By.cssSelector("#result_button_checkbox"));

            assertFalse(Option1.isSelected());
            assertFalse(Option2.isSelected());
            assertFalse(Option3.isSelected());
        Thread.sleep(2000);
        Option2.click();
        assertTrue(Option2.isSelected());
        Thread.sleep(2000);
        Option3.click();
        assertTrue(Option3.isSelected());
        result.click();
        Thread.sleep(2000);
        assertEquals("You selected value(s): Option 2, Option 3",driver.findElement(By.cssSelector("#result_checkbox")).getText());



    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected());
        }
            WebElement Option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio'"));
            WebElement Option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio'"));
            WebElement Option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio'"));
            WebElement result = driver.findElement(By.cssSelector("#result_button_ratio"));

            assertFalse(Option1.isSelected());
            assertFalse(Option2.isSelected());
            assertFalse(Option3.isSelected());

            Thread.sleep(2000);
            Option3.click();
            assertTrue(Option3.isSelected());
            result.click();
            Thread.sleep(2000);
            assertEquals("You selected option: Option 3",driver.findElement(By.cssSelector("#result_radio")).getText());
    }

    @Test
    public void selectOption() throws Exception {
//        select "Option 3" in Select
//        check that selected option is "Option 3"
//        select "Option 2" in Select
//        check that selected option is "Option 2"
//        click result
//        check that 'You selected option: Option 2' text is being displayed
        WebElement result = driver.findElement(By.cssSelector("#result_button_select"));
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        assertEquals("Choose your option", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("value3");
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("Option 2");
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());

        result.click();
        assertEquals("You selected option: Option 2",driver.findElement(By.cssSelector("#result_select")).getText());
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added
    }
}
