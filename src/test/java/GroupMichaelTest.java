import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelTest {

    private WebDriver driverChr;

    @BeforeMethod

    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olga\\IdeaProjects\\driver\\chromedriver.exe");
        driverChr = new ChromeDriver();

        driverChr.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driverChr.manage().window().maximize();


    }

    @AfterMethod

    public void setDown () {
        driverChr.quit();
    }

    @Test

    public void test1_Olga_Anisimova () {

        driverChr.get("http://automationpractice.com/index.php");
        WebElement singIn = driverChr.findElement(By.xpath("//div[@class='header_user_info']"));
        singIn.click();

        String title = "Login - My Store";
        Assert.assertEquals(driverChr.getTitle(), title);


        WebElement email = driverChr.findElement(By.id("email"));

        WebElement singIn1 = driverChr.findElement(By.id("SubmitLogin"));


        email.sendKeys("123");
        singIn1.click();

        WebElement error1 = driverChr.findElement(By.xpath("//div[@class='alert alert-danger']/ol"));

        String err1 = "Invalid email address.";
        Assert.assertEquals(error1.getText(), err1);



        WebElement email2 = driverChr.findElement(By.id("email"));
        WebElement singIn2 = driverChr.findElement(By.id("SubmitLogin"));
        email2.clear();

        email2.sendKeys("123@gmail.com");
        singIn2.click();

        WebElement error2 = driverChr.findElement(By.xpath("//div[@class='alert alert-danger']/ol"));

        String err2 = "Password is required.";
        Assert.assertEquals(error2.getText(), err2);


        WebElement pass = driverChr.findElement(By.id("passwd"));
        WebElement singIn3 = driverChr.findElement(By.id("SubmitLogin"));
        pass.sendKeys("12345");
        singIn3.click();

        WebElement error3 = driverChr.findElement(By.xpath("//div[@class='alert alert-danger']/ol"));
        String err3 = "Authentication failed.";
        Assert.assertEquals(error3.getText(), err3);
    }

    @Test

    public void test2_Olga_Anisimova () throws InterruptedException {

        driverChr.get("https://demoqa.com/automation-practice-form");

        WebElement firstname = driverChr.findElement(By.id("firstName"));
        firstname.sendKeys("123");

        WebElement lastname = driverChr.findElement(By.id("lastName"));
        lastname.sendKeys("5678");
//Thread.sleep(5000);
//lastname.clear();
        WebElement genderF = driverChr.findElement(By.xpath("//input[@name='gender'][@value='Female']"));
        driverChr.findElement(By.xpath("//label[contains(text(),'Female')]")).click();

    }

}
