package tests;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {

    private static final String EXPECTED_SEARCH_QUERY = "https://www.youtube.com/user/boschhomeua";
    private static final String keyword = "GSN36VL30U";
    private static final long DEFAULT_WAITING_TIME = 160;
    private static final String PRODUCT_PAGE = "https://www.bosch-home.com.ua/uk/productlist/holodylnyky-ta-morozylni-kamery/morozylni-kamery/okremostoiacha-vertykalna-morozylna-kamera/GSN36VL30U?search=GSN36VL30U";
    private static final String HOME_PAGE = "https://www.bosch-home.com.ua/uk/";
    private static final String EXPECTED_HOME_PAGE = "https://www.bosch-home.com.ua/ru/";
    private static final String EXPECTED_PAGINATION_NUMBER = "2";

    @Test
    public void checkMovingToYouTubeChannel() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().clickAcceptCookiesButton();
        getHomePage().clickYoutubeIcon();
        ArrayList<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandles.get(1));
        assertEquals(getDriver().getCurrentUrl(), EXPECTED_SEARCH_QUERY);
    }

    @Test
    public void findProductByArticle() {
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().clickAcceptCookiesButton();
        getHeader().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHeader().enterTextToSearchField(keyword);
        getHeader().clickSearchButton();
        getProductPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        assertTrue(getProductPage().getArticleProductText().equals(keyword));
    }

    @Test
    public void checkLogoMovesToTheHomePage() {
        openPage(PRODUCT_PAGE);
        getHeader().clickLogo();
        assertTrue(getDriver().getCurrentUrl().equals(HOME_PAGE));
    }

    @Test
    public void checkThatNavigationArrowLeafsNextSliderPage(){
        getHomePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getHomePage().clickAcceptCookiesButton();
        getHeader().clickServiceButton();
        getServicePage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getServicePage().clickNextArrowButton();
        getServicePage().waitForAjaxToComplete(DEFAULT_WAITING_TIME);
        assertEquals(getServicePage().getPaginationNumber(),EXPECTED_PAGINATION_NUMBER);
    }
}
