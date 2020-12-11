package com.test;

import Pages.SliderPage;
import com.peoplentech.thursdaymentoring.TestBase;
import com.peoplentech.thursdaymentoring.report.ExtentManager;
import com.peoplentech.thursdaymentoring.report.ExtentTestManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SliderPageTest extends TestBase {

    @Test(enabled = true)
    public void validateUserIsAbleToSeeJQueryLogoDisplayedOnSliderPage(){
        SliderPage sliderPage = PageFactory.initElements(driver, SliderPage.class);
        sliderPage.validateJQueryLogoIsDisplayedOnSliderPage();
    }

    @Test(enabled = false)
    public void validateUserIsAbleToHoverOverSupportLinkOnSliderPage() {
        SliderPage sliderPage = PageFactory.initElements(driver, SliderPage.class);
        sliderPage.hoverOverSupportLinkOnSliderPage();
        sliderPage.clickOnStackOverflowLinkOnSliderPage();
        sliderPage.validateStackOverflowPageDisplays();
    }

    @Test(enabled = false)
    public void validateUserIsAbleTypeOnSearchBarAndSelectFromDropdownOnSliderPage() {
        SliderPage sliderPage = PageFactory.initElements(driver, SliderPage.class);
        sliderPage.enterTextInSearchBarOnSliderPage();
        sliderPage.selectOptionsFromDropdownOnSliderPage();
        sliderPage.validateDraggableWidgetPage();
    }

    @Test(enabled = false)
    public void validateUserIsAbleDragAndDropOnSliderPage() {
        SliderPage sliderPage = PageFactory.initElements(driver, SliderPage.class);
        sliderPage.dragAndDropOnSliderPage();
        sliderPage.validateDragAndDropOnSliderPage();
    }


}
