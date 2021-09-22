package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BasePage {
    @FindBy(xpath = "//div[@class='search-input']//input")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='search-button']//button")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@class = 'a-logo  ']")
    private WebElement logo;

    @FindBy(xpath = "//div[@class='nav-wrap']//a[@data-link-hierarchy = 'Сервіс']")
    private WebElement serviceButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    public void enterTextToSearchField(final String keyword) {
        waitVisibilityOfElement(60, searchButton);
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickLogo() {
        logo.click();
    }

    public void clickServiceButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", serviceButton);
    }
}
