import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class hamsters {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium Driver/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }

    @Test

    public void NadezhdaDekhand() {
        driver.get("https://gb.ru/");

        WebElement link = driver.findElement(By.className("mn-header__logo-link"));
        link.click();
        assertEquals(driver.getCurrentUrl(), "https://gb.ru/");
    }

    @Test
    public void Nadezhda_Dekhand() {
        driver.get("https://gb.ru/");

        WebElement userPlan = driver.findElement(By.xpath("//div[contains(@class,'mn-header__left')]//a[text()='Мероприятия']"));
        userPlan.click();
        WebElement privat = driver.findElement(By.linkText("Личные консультации"));
        privat.click();
        WebElement form = driver.findElement(By.linkText("Записаться"));
        form.click();
        WebElement name1User = driver.findElement(By.id("full_name-3"));
        WebElement name2User = driver.findElement(By.id("full_name-4"));
        WebElement emailUser = driver.findElement(By.id("email-2"));
        WebElement phoneUser = driver.findElement(By.id("phone-2"));
        WebElement login = driver.findElement(By.cssSelector("#wf-form-email-form > input.submit-button.w-button"));
        name1User.sendKeys("gdhghd");
        name2User.sendKeys("fgdrgtr");
        emailUser.sendKeys("abc@gmail.com");
        phoneUser.sendKeys("9999999999");


        login.click();
        assertEquals(driver.getCurrentUrl(), "https://gb.ru/a/a1?to=https://gb.ru/posts&success_claim=");
    }
}
