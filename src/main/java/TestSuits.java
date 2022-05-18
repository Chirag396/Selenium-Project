import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class TestSuits {

    protected static WebDriver driver;


//code for entering Text
    public static void typeText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
//code for clicking on button
    public static void ClickOnElements(By by){
        driver.findElement(by).click();
    }
//time stamp for random date email generate
    public static String randomDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }

// time waited for URL to be opened
    public static void driverWaitUntilOpenUrl(int time,String url){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }

//time waited for time to clickable
    public static void waitForClickable(int time,By by){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }
    public static void driverWaitUntilInvisibilityOf(WebElement element, int time){
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait2.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void driverWaitUntilPresenseOfElement(By by, int time){
        WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    public static void driverWaitUntilElementTitleContains(By by, int time, String TitleContains){
        WebDriverWait wait4 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait4.until(ExpectedConditions.titleContains(TitleContains));

    }
    public static void driverWaitUntilFrameToBeAvaliableAndSwitchToIt(By by,int time){
        WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait5.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }
    public static void driverWaitUntilAttributeContains(int time,By by, String attribute,String value){
        WebDriverWait wait6 = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait6.until(ExpectedConditions.attributeContains(by,attribute,value));
    }







    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver" , "src/test/java/Drivers/chromedriver.exe");

        // Open Chrome Browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //type URL
        driver.get("https://demo.nopcommerce.com/");


        //Click on Register Button
        ClickOnElements(By.className("ico-register"));
        //driver.findElement(By.className("ico-register")).click();
        //driverWaitUntilOpenUrl(10,"https://demo.nopcommerce.com/register?returnUrl=%2F");


        //user should input first name
        typeText(By.id("FirstName"),"Jack");
        //driver.findElement(By.id("FirstName")).sendKeys("Jack");

        //user should input surname
        typeText(By.id("LastName"),"Smith");
        //driver.findElement(By.id("LastName")).sendKeys("Smith");

        //user should input Email
        typeText(By.name("Email"),"jacksmith"+randomDate()+"@gmail.com");
        //driver.findElement(By.name("Email")).sendKeys("jacksmith3987@gmail.com");
        System.out.println(randomDate());

        //user should input password (Jacks12345)
        typeText(By.xpath("//input[@type='password']"),"Jacks12345");
        //driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Jacks12345");

        //user should Confirm the password (Jacks12345)
        typeText(By.name("ConfirmPassword"),"Jacks12345");
        //driver.findElement(By.name("ConfirmPassword")).sendKeys("Jacks12345");

        //user should click on Register Button
        ClickOnElements(By.id("register-button"));
        //driver.findElement(By.id("register-button")).click();

        // user should be successfully Registered
        String expectedMessage = "Your registration completed";

        String actualMessage = driver.findElement(By.className("result")).getText();
        System.out.println(actualMessage);
        if (actualMessage.equals(expectedMessage)){
            System.out.println("you have sucessfully Registered");;
        }
        else{
            System.out.println("you have NOT sucessfully Registered");;
        }

        //user should click on Continue Button
        ClickOnElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));

        //close web page
        //driver.quit();





    }
}
