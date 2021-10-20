package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FeedbackPage extends GenericSamplePage {
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameInput;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageInput;

    @FindBy(how = How.CSS, using = ".w3-check[type='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(how = How.CSS, using = ".w3-radio[type='radio']")
    private List<WebElement> radioButtons;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement selectDropdown;

    @FindBy(how = How.CLASS_NAME, using = "w3-input")
    private WebElement textArea;

    @FindBy(how = How.CSS, using = ".w3-btn-block")
    private WebElement buttonSend;

    @FindBy(how = How.CSS, using = ".w3-radio[value='female'][type='radio']")
    private WebElement femaleOption;
    @FindBy(how = How.CSS, using = ".w3-check[value='English'][type='checkbox']")
    private WebElement englishOption;

    @FindBy(how = How.XPATH, using = "//div[@class='description'][1]")
    private WebElement description1;
    @FindBy(how = How.XPATH, using = "//div[@class='description'][2]")
    private WebElement description2;
    @FindBy(how = How.XPATH, using = "//div[@class='description'][3]")
    private WebElement description3;
    @FindBy(how = How.XPATH, using = "//div[@class='description'][4]")
    private WebElement description4;
    @FindBy(how = How.XPATH, using = "//div[@class='description'][5]")
    private WebElement description5;
    @FindBy(how = How.XPATH, using = "//div[@class='description'][6]")
    private WebElement description6;

    @FindBy(how = How.CSS, using = ".w3-btn.w3-green.w3-xlarge")
    private WebElement yesButton;

    @FindBy(how = How.CSS, using = ".w3-btn.w3-red")
    private WebElement noButton;

    @FindBy(how = How.ID, using = "message")
    private WebElement message;


    // a method for checking all empty fields
    public String allFieldsEmpty() {
        assertFalse(nameInput.isSelected());
        assertFalse(ageInput.isSelected());

        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
            checkBox.click();
        }

        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected());
            radioButton.click();
        }

        assertFalse(selectDropdown.isSelected());
        assertFalse(textArea.isSelected());

        return null;
    }

    // a method for clicking on button SEND
    public String clickButtonSend() {
        buttonSend.click();
        return null;
    }

    public String genreOption2Selected() {
        femaleOption.click();
        assertTrue(femaleOption.isSelected());
        return null;
    }

    public String chooseYourOption() {
        selectDropdown.click();
        return null;
    }

    public String backgroundColor() {
        assertEquals("rgba(33, 150, 243, 1)", buttonSend.getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)", buttonSend.getCssValue("color"));
        return null;
    }

    public String fieldsEmptyOrNull() {
        assertEquals("Your name:", description1.getText());
        assertEquals("Your age:", description2.getText());
        assertEquals("Your language:", description3.getText());
        assertEquals("Your genre: null", description4.getText());
        assertEquals("Your option of us: null", description5.getText());
        assertEquals("Your comment:", description6.getText());
        return null;
    }

    public String yesNoButtonColor() {
        Assert.assertEquals("rgba(255, 255, 255, 1)", yesButton.getCssValue("color"));
        Assert.assertEquals("rgba(76, 175, 80, 1)", yesButton.getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)", noButton.getCssValue("color"));
        Assert.assertEquals("rgba(244, 67, 54, 1)", noButton.getCssValue("background-color"));
        return null;
    }

    public String fillTheWholeForm() throws InterruptedException {
        nameInput.sendKeys("Alla");
        ageInput.sendKeys("35");
        englishOption.click();
        femaleOption.click();
        selectDropdown.sendKeys("Good");

        return null;
    }

    public String correctFillForm() {
        assertEquals("Your name: Alla", description1.getText());
        assertEquals("Your age: 35", description2.getText());
        assertEquals("Your language: English", description3.getText());
        assertEquals("Your genre: female", description4.getText());
        assertEquals("Your option of us: Good", description5.getText());
        return null;
    }

    public String enterOnlyName()  {
        nameInput.sendKeys("Alla");
        return null;
    }

    public String clickYesButton()  {
        yesButton.click();
        return null;
    }
    public String clickNoButton()  {
        noButton.click();
        return null;
    }

    public String messageCheck() {
        assertEquals("Thank you, Alla, for your feedback!", message.getText());
        return null;
    }

    public String backgroundCheckMessageColor() {
        Assert.assertEquals("rgba(255, 255, 255, 1)", message.getCssValue("color"));
        Assert.assertEquals("rgba(0, 0, 0, 0)", message.getCssValue("background-color"));

        return null;
    }
    public String messageCheckNoInput() {
        assertEquals("Thank you for your feedback!", message.getText());
        return null;
    }

}
