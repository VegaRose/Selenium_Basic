package selenium.tasks;
// KARINA PIZOVA
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.pages.FeedbackPage;
import org.openqa.selenium.support.PageFactory;
import selenium.pages.GenericSamplePage;


import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Task2 extends FeedbackPage {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
        FeedbackPage feedback = PageFactory.initElements(driver, FeedbackPage.class);
//         TODO:
//         check that all field are empty and no tick are clicked
        feedback.allFieldsEmpty();
//         "Female" is selected in "Genre"
        feedback.genreOption2Selected();
//         "Choose your option" in "How do you like us?"
        feedback.chooseYourOption();
//         check that the button send is blue with white letters
        feedback.backgroundColor();
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
        FeedbackPage feedback = PageFactory.initElements(driver, FeedbackPage.class);
//         TODO:
//         click "Send" without entering any data
        feedback.clickButtonSend();
//         check fields are empty or null
        feedback.fieldsEmptyOrNull();
//         check button colors
        feedback.yesNoButtonColor();
//         (green with white letter and red with white letters)
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
        FeedbackPage feedback = PageFactory.initElements(driver, FeedbackPage.class);
//         TODO:
//         fill the whole form, click "Send"
        feedback.fillTheWholeForm();
        feedback.clickButtonSend();
//         check fields are filled correctly
        feedback.correctFillForm();
//         check button colors
//         (green with white letter and red with white letters)
        feedback.yesNoButtonColor();
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
        FeedbackPage feedback = PageFactory.initElements(driver, FeedbackPage.class);
//         TODO:
//         enter only name
        feedback.enterOnlyName();
//         click "Send"
        feedback.clickButtonSend();
//         click "Yes"
        feedback.clickYesButton();
//         check message text: "Thank you, NAME, for your feedback!"
        feedback.messageCheck();
//         color of text is white with green on the background
        feedback.backgroundCheckMessageColor();
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
        FeedbackPage feedback = PageFactory.initElements(driver, FeedbackPage.class);
//         TODO:
//         click "Send" (without entering anything
        feedback.clickButtonSend();
//         click "Yes"
        feedback.clickYesButton();
//         check message text: "Thank you for your feedback!"
        feedback.messageCheckNoInput();
//         color of text is white with green on the background
        feedback.backgroundCheckMessageColor();
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
        FeedbackPage feedback = PageFactory.initElements(driver, FeedbackPage.class);
//         TODO:
//         fill the whole form
        feedback.fillTheWholeForm();
//         click "Send"
        feedback.clickButtonSend();
//         click "No"
        feedback.clickNoButton();
    }
}
