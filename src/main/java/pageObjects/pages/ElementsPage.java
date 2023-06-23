package pageObjects.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
    public WebDriver driver;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class=\"category-cards\"]/div[1]")
    public WebElement elements;
    @FindBy(xpath = "//span[text()='Text Box']")
    public WebElement textBox;

    @FindBy(id = "userName")
    public WebElement fullName;

    @FindBy(id = "userEmail")
    public WebElement email;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id ="permanentAddress")
    public WebElement permanentAddress;

    @FindBy(id ="submit")
    public WebElement submit;

    @FindBy(id = "name")
    public WebElement name;

    public boolean enterDetails(String FullName, String Email, String cAddress, String pAddress )
    {
        elements.click();
        textBox.click();
        fullName.sendKeys(FullName);
        email.sendKeys(Email);
        currentAddress.sendKeys(cAddress);
        permanentAddress.sendKeys(pAddress);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", submit);
        submit.click();
        return name.isDisplayed();
    }

}
