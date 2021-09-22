package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//span[@class='fragment std-header-6 ']")
    private WebElement articleProductText;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getArticleProductText() {
        waitVisibilityOfElement(60, articleProductText);
        return articleProductText.getText();
    }
}
