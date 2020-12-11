package Pages;

import com.peoplentech.thursdaymentoring.TestBase;
import com.peoplentech.thursdaymentoring.report.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SliderPage extends TestBase {

    @FindBy(linkText = "jQuery UI")
    private WebElement jQueryLogo;

    @FindBy(xpath = "(//a[contains(text(),'Support')])[1]")
    private WebElement hoverOverSupportLink;

    @FindBy(linkText = "Stack Overflow")
    private WebElement clickOnStackOverflowLink;

    @FindBy(xpath = "//input[@class='ds-input']")
    private WebElement enterTextInSearchBar;

    @FindBy(xpath = "(//div[@class='algolia-docsearch-suggestion--title'])[1]")
    private WebElement selectOptions;

    @FindBy(xpath = "//span[@class='ui-slider-handle ui-corner-all ui-state-default']")
    private WebElement sliderButton;

    @FindBy(css = "#slider > span")
    private WebElement validateSlider;




    public void validateJQueryLogoIsDisplayedOnSliderPage(){
        TestBase.sleepFor(2);
        Assert.assertTrue(jQueryLogo.isDisplayed());
        TestBase.sleepFor(2);
        ExtentTestManager.log("The jQuery logo is displayed on the Slider Page");
    }

    public void hoverOverSupportLinkOnSliderPage() {
        TestBase.sleepFor(2);
        Actions actions = new Actions(TestBase.driver);
        actions.moveToElement(hoverOverSupportLink).build().perform();
        sleepFor(2);
        ExtentTestManager.log("User hovers mouse over the Support link at the top right of the Slider Page");
    }

    public void clickOnStackOverflowLinkOnSliderPage() {
        TestBase.sleepFor(2);
        clickOnStackOverflowLink.click();
        TestBase.sleepFor(2);
        ExtentTestManager.log("User clicks on Stack Overflow link from the Support hover dropdown");
    }

    public void validateStackOverflowPageDisplays() {
        String actualURL = TestBase.driver.getCurrentUrl();
        String expectedURL = "https://stackoverflow.com/tags/jquery/info";

        Assert.assertTrue(actualURL.contains(expectedURL));
        ExtentTestManager.log("URL is validated"+actualURL);
    }

    public void enterTextInSearchBarOnSliderPage() {
        enterTextInSearchBar.sendKeys("iframe");
        TestBase.sleepFor(2);
        ExtentTestManager.log("User clicks on search bar and enters the text 'iframe'");
    }

    public void selectOptionsFromDropdownOnSliderPage() {
        selectOptions.click();
        TestBase.sleepFor(2);
        ExtentTestManager.log("User clicks on Options from the search bar dropdown");
    }

    public void validateDraggableWidgetPage() {
        String actualURL = TestBase.driver.getCurrentUrl();
        String expectedURL = "https://api.jqueryui.com/draggable/#option-iframeFix";

        Assert.assertTrue(actualURL.contains(expectedURL));
        ExtentTestManager.log("URL is validated"+actualURL);
    }

    public void dragAndDropOnSliderPage() {
        TestBase.sleepFor(2);
        TestBase.driver.switchTo().frame(0);
        ExtentTestManager.log("The iframe on the Slider Page is accessed");
        TestBase.sleepFor(2);
        Actions move = new Actions(TestBase.driver);
        Action action = (Action)move.dragAndDropBy(sliderButton,300,0).build();
        action.perform();
        TestBase.sleepFor(2);
        ExtentTestManager.log("The slider drags from left to right");
    }

    public void validateDragAndDropOnSliderPage() {
     String actual = validateSlider.getAttribute("style");
     String expected = "left: 53%;";
     Assert.assertEquals(actual, expected, "fail");
     ExtentTestManager.log("The slider drags and drops as expected");
    }


}
