import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;

public class orangeFarmHRM {

    protected static WebDriver driver;

    public static void typeText(By by,String text){
        driver.findElement(by).sendKeys(text);}

    public static void clickOnElement (By by){
        driver.findElement(by).click();}

    public static void main (String [] args){

        System.setProperty("webdriver.chrome.driver" , "src/test/java/Drivers/chromedriver.exe");

        //open Web Browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Type your URL
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        //type your username
        typeText(By.name("txtUsername"),"Admin");

        //type your Password
        typeText(By.id("txtPassword"),"admin123");

        //Click on Login Button
        clickOnElement(By.className("button"));

        //driver.quit();






    }
}
