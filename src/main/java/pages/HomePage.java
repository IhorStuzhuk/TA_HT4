package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@aria-label ='YOUTUBE']")
    private WebElement youtubeIcon;

    @FindBy(xpath = "//button[@aria-label='Прийняти']")
    private WebElement acceptCookiesButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickYoutubeIcon() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", youtubeIcon);
    }

    public void clickAcceptCookiesButton() {
        waitVisibilityOfElement(60, acceptCookiesButton);
        acceptCookiesButton.click();
        waitInvisibilityOfElement(60, acceptCookiesButton);
    }
}
