import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeFarmHRM {

    protected static WebDriver driver;

    public static void typeText(By by,String text){
        driver.findElement(by).sendKeys(text);}

    public static void clickOnElement (By by){
        driver.findElement(by).click();}

    public static void waitForClickable(int time,By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    public static void main (String [] args){

        System.setProperty("webdriver.chrome.driver" , "src/test/java/Drivers/chromedriver.exe");

        //open Web Browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //********************Logging on to Orange Farm Website****************************

        //Type your URL
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        //type your username
        typeText(By.name("txtUsername"),"Admin");

        //type your Password
        typeText(By.id("txtPassword"),"admin123");

        //Click on Login Button
        clickOnElement(By.className("button"));
        //***********************************************>>>>>>>>>>>>>>>>*************************

        //Stating to fill in Employee Details
        //Click on PIM
        clickOnElement(By.xpath("//li[2]/a[@class='firstLevelMenu']"));

        //Click on Add Employee
        clickOnElement(By.xpath("//a[starts-with(@id,'menu_pim_a')]"));

        //Type in username
        typeText(By.xpath("//li[1]/input[starts-with(@class,'for')]"),"Jackie");
        //type in Middle name (Optional)
        typeText(By.xpath("//input[starts-with(@id,'mid')]"),"CAT");
        //type in Surname
        typeText(By.xpath("//li[3]/input[starts-with(@maxlength,'30')]"),"Thompson");




        //driver.quit();






    }
}
