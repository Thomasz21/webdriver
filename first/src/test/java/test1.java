import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class test1 {

    private WebDriver driver;
    @Before
    public void setUP(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Tomasz\\IdeaProjects\\first\\src\\test\\java\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);}

    @Test
    public void UserRegistrationWithValidData() throws InterruptedException
    {
        WebElement singInButton = driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]"));
            singInButton.click();
        Thread.sleep(3000);
        WebElement emailInput = driver.findElement(By.id("email_create"));
        emailInput.sendKeys("testowymail@test.com");
        Thread.sleep(1000);
        WebElement createAccount = driver.findElement(By.id("SubmitCreate"));
                createAccount.click();
        Thread.sleep(3000);
        driver.findElement(By.id("id_gender1")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("customer_firstname")).sendKeys("XZY");
        driver.findElement(By.id("customer_lastname")).sendKeys("XY");
        driver.findElement(By.id("passwd")).sendKeys("abcd");
        Thread.sleep(3000);
        driver.findElement(By.id("submitAccount")).click();
        Thread.sleep(3000);
        boolean isAlertDisplayed = driver.findElement(By.className("alert")).isDisplayed();
        Assert.assertTrue(isAlertDisplayed);
    }
    @After
    public void tear_down(){driver.quit();}
}