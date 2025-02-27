package old;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Ignore
public class AnastasiiaPTest extends BaseTest {

    private static final String URL = "https://shop.mango.com/us/women";
    private static final String SEARCH_ICON = "search_icon_button";

    @Test
    public void testCurrentAddressTextField() {
        String expectedResult = "Roses Delivery";
        getDriver().get("https://www.1800flowers.com/");

        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("SearchBox_desktop")));

        getDriver().findElement(By.id("SearchBox_desktop")).sendKeys("Roses");
        getDriver().findElement(By.id("btn-search")).click();

        WebElement actualResult = getDriver().findElement(By.xpath("//div/h1"));

        Assert.assertEquals(actualResult.getText(), expectedResult);
    }
    @Ignore
    @Test
    public void testSearchSubjectTextField() {
        String expectedResult = "SEARCH RESULTS FOR NY DRESS";

        getDriver().get(URL);
        getDriver().findElement(By.id(SEARCH_ICON)).click();
        getDriver().findElement(By.xpath("//div//input[@class='search-input']")).sendKeys("NY dress\n");

        WebElement actualResult = getDriver().findElement(By.xpath("//div[@id = 'title']"));

        Assert.assertEquals(actualResult.getText(), expectedResult);
    }

    @Ignore
    @Test
    public void testVerificationText() {
        getDriver().get(URL);
        getDriver().findElement(By.id(SEARCH_ICON)).click();

        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//input[@class='search-input']")));

        getDriver().findElement(By.xpath("//div//input[@class='search-input']")).sendKeys("dress\n");

        List<WebElement> itemList = getDriver().findElements(By.xpath("//span[contains(@class, 'product-name')]"));
        for (WebElement webElement : itemList) {
            Assert.assertTrue(webElement.getText().toLowerCase().contains("dress"));
        }
    }

    @Ignore
    @Test
    public void testAvailabilityMenuButtons() {
        String[] expectedArray = new String[]{
                "ABOUT OUR ICE CREAM",
                "ORDER ONLINE",
                "SIGNATURE CREATIONS",
                "CREATE YOUR OWN CREATIONS",
                "SUNDAES",
                "MIX & GO",
                "PRE-PACKED",
                "FAMILY PACKS",
                "ICE CREAM FAQ"};

        getDriver().get("https://www.coldstonecreamery.com/index.php");
        getDriver().findElement(By.xpath("//div[contains(@class,'close-button')]")).click();
        getDriver().findElement(By.xpath("//a[contains(@aria-controls,'icecream')]")).click();

        List<WebElement> menuList = getDriver().findElements(By.xpath("//ul[contains(@id,'icecream')]//li"));
        for (int i = 0; i < menuList.size(); i++) {
            Assert.assertEquals(menuList.get(i).getText(), expectedArray[i]);
        }
    }

    @Test
    public void testMenuItems() {
        final List<String> expectedList = Arrays.asList("Pizza",
                "Specialty Pizza",
                "Pizza by the Slice",
                "Soups",
                "Salads",
                "Side Orders",
                "Calzones",
                "Sandwiches",
                "Hot Subs");

        getDriver().get("https://www.familypizzainc.com/");
        getDriver().findElement(By.cssSelector("#navigation-link-menu")).click();

        List<WebElement> menuList = getDriver().findElements(By.xpath("//a[contains(@class,'_1tk5thq')]"));
        for (int i = 0; i < menuList.size(); i++) {
            Assert.assertEquals(menuList.get(i).getText(), expectedList.get(i));
        }
    }
}

