package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServicePage extends BasePage {

    @FindBy(xpath = "//button[@class ='next a-paginationarrows slick-arrow']")
    private WebElement nextArrowButton;

    @FindBy(xpath = "//div[contains(@class, 'bottom')]//span[@class='a-paginationnumber js-paginationnumber highlight']")
    private WebElement paginationNumber;

    public ServicePage(WebDriver driver) {
        super(driver);
    }

    public void clickNextArrowButton() {
        nextArrowButton.click();
    }

    public String getPaginationNumber() {
        waitVisibilityOfElement(60, paginationNumber);
        String number = paginationNumber.getText();
        return number.substring(0, number.indexOf("/"));
    }
}
