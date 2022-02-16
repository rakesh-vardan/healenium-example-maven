package com.epam.healenium.tests;

import com.epam.healenium.FrameworkPage;
import com.epam.healenium.constants.PagesType;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Button click with FindBy annotation")
    public void testButtonClickWithFindByAnnotationPage() {
        FrameworkPage mainPage = pages.get(String.valueOf(PagesType.MARKUP_FIND_BY));

        //find test button
        mainPage.openPage().clickTestButton();
        //confirm Alert
        mainPage.confirmAlert();

        mainPage
                .generateMarkup() //regenerate Markup
                .clickTestButton(); //find test button again
        mainPage.confirmAlert();  //confirm Alert again

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Select checkboxes with findElements annotation")
    public void testSelectCheckboxes() {
        FrameworkPage mainPage = pages.get(String.valueOf(PagesType.MARKUP));

        mainPage.openPage();

        while (!mainPage.displayedText())
            mainPage.generateMarkup();

        int selectCount = mainPage.selectAllCheckboxes(); //find via findElements

        int verifiedCount = mainPage.verifyAllCheckboxesChecked();
        Assertions.assertEquals(selectCount, verifiedCount,
                "All checkboxes were checked");

        selectCount = mainPage.selectAllCheckboxes(); // should be healed and unchecked
        verifiedCount = mainPage.verifyAllCheckboxesUnchecked();
        Assertions.assertEquals(selectCount, verifiedCount,
                "The same number of locator for checkbox with findElements has been healed");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Button click with disable healing")
    public void testButtonClickWithDisableHealing() {
        FrameworkPage mainPage = pages.get(String.valueOf(PagesType.MARKUP_FIND_BY));

        mainPage.openPage()
                .clickTestButton()
                .confirmAlert();
        boolean result = mainPage
                .generateMarkup() //regenerate Markup
                .checkLocatorTestButtonDontHealing(); //find test button again
        assertTrue(result, "The locator was not healed");
    }
}
