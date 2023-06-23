package tests.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pages.ElementsPage;
import pageObjects.pages.HomePage;
import tests.baseTest.BaseTest;

public class HomePageTests extends BaseTest {


    @Test
    public void titleVerification()
    {
        testCaseID = "1";
        HomePage homePage = new HomePage(driver);
        String actualTitle = homePage.getTitle();
        String expectedTitle = "DEMOQA.";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void textBoxes()
    {
        testCaseID = "2";
        ElementsPage elementsPage = new ElementsPage(driver);
        Boolean status = elementsPage.enterDetails("Anoop Joseph", "asd@gmail.com", "ABCDEF", "FGHIJK");
        Assert.assertTrue(status);
    }
}
