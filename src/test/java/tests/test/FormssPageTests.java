package tests.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.FormsPage;
import tests.baseTest.BaseTest;

public class FormssPageTests extends BaseTest {

    @Test
    public void visibilityofElementsTitle()
    {
        testCaseID = "3";
        FormsPage formsPage = new FormsPage(driver);
        String actualText = formsPage.getElementsText();
        String expectedText = "Elements";
        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void visibilityofWidgetsTitle()
    {
        testCaseID = "4";
        FormsPage formsPage = new FormsPage(driver);
        String actualText = formsPage.getWidgetsText();
        String expectedText = "Widgets";
        Assert.assertEquals(actualText,expectedText);
    }

}
