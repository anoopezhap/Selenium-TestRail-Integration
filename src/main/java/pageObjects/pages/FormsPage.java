package pageObjects.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage {

    public WebDriver driver;

    public FormsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div/h5[text()='Forms']")
    public WebElement forms;

    @FindBy(xpath = "//div[text()='Elements']")
    public WebElement elements;

    @FindBy(xpath = "//div[text()='Widgets']")
    public WebElement widgets;

    public String getElementsText()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", forms);
        forms.click();
        return elements.getText();
    }

    public String getWidgetsText()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", forms);
        forms.click();
        return widgets.getText();
    }

}
