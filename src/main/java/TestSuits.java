import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class TestSuits {

    protected static WebDriver driver;


    @Test
    public void UserShouldBeAbleToRegisterAndAddProductToShoppingCart(){
        //Click on Register Button
        ClickOnElements(By.className("ico-register"));

        //user select male or female
        ClickOnElements(By.id("gender-male"));

        //user should input first name
        typeText(By.id("FirstName"), "Jack");

        //user should input surname
        typeText(By.id("LastName"), "Smith");

        //user should enter your day of birth
        Select birthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        birthDay.selectByIndex(12);

        //user should enter your Month of birth
        Select birthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        birthMonth.selectByValue("4");

        //user should enter your Year of birth
        Select birthYear = new Select((driver.findElement(By.name("DateOfBirthYear"))));
        birthYear.selectByValue("1988");

        //user should input Email
        typeText(By.name("Email"), "jacksmith" + randomDate() + "@gmail.com");

        //user should input password (Jacks12345)
        typeText(By.xpath("//input[@type='password']"), "Jacks12345");

        //user should Confirm the password (Jacks12345)
        typeText(By.name("ConfirmPassword"), "Jacks12345");

        //user should click on Register Button
        ClickOnElements(By.id("register-button"));

        // user should be successfully Registered
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(expectedMessage,actualMessage,"Registration not Completed");

        //************************************Registration Process Completed*************************************************//

        //user should click on Computer
        ClickOnElements(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[contains(text(),'Computers ')]"));

        //user should click on Desktops Icon
        ClickOnElements(By.xpath("//h2/a[@title=\"Show products in category Desktops\"]"));

        //user should click on Build your own Computer
        ClickOnElements(By.xpath("//h2/a[@href=\"/build-your-own-computer\"]"));

        //user should select 2.2 GHz Intel Core-Dual
        Select GHzIntel = new Select(driver.findElement(By.name("product_attribute_1")));
        GHzIntel.selectByIndex(1);

        //user should select 2GB RAM
        Select HddRam = new Select(driver.findElement(By.name("product_attribute_2")));
        HddRam.selectByIndex(1);

        //user should select HDD 320GB
        ClickOnElements(By.name("product_attribute_3"));

        //User should select Vista Premium
        ClickOnElements(By.id("product_attribute_4_9"));

        //user should unselect  Microsoft Office
        ClickOnElements(By.id("product_attribute_5_10"));

        //user should select  Microsoft Office again
        ClickOnElements(By.id("product_attribute_5_10"));

        //user should select Acrobat Reader
        ClickOnElements(By.xpath("//input[@id=\"product_attribute_5_11\"]"));

        //user should select Total Commander
        ClickOnElements(By.id("product_attribute_5_12"));

        //User should click on Add to Cart click Homepage
        ClickOnElements(By.xpath("//button[@id=\"add-to-cart-button-1\"]"));

        //User should click on  Homepage
        ClickOnElements(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));

        //user should be on add to cart page
        ClickOnElements(By.xpath("//span[@class=\"cart-label\"]"));

        //Verify user is on end Shopping Cart Page
        String ExpectedResults = "Shopping cart";
        String ActualResults = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(ExpectedResults,ActualResults,"You have NOT Successfully Added Product to Cart");
        System.out.println("You have Successfully Added Product to "+ ActualResults);

        //User should click on Terms and conditions
        ClickOnElements(By.id("termsofservice"));

        //user should click on Checkout button
        ClickOnElements(By.name("checkout"));

        //***************************************Successfully Added Product To Cart *********************************//

        //User should select the Country "United Kingdom"
        Select Country = new Select( driver.findElement(By.id("BillingNewAddress_CountryId")));
        Country.selectByIndex(233);

        //user should enter his City
        typeText(By.id("BillingNewAddress_City"),"London");

        //User should enter his Address "123 Downing Street"
        typeText(By.name("BillingNewAddress.Address1"),"123 Downing Street");

       //User should enter his Postal Code "LO98SW"
        typeText(By.id("BillingNewAddress_ZipPostalCode"),"LO98SW");

        //user should enter his Phone Number "0987654321"
        typeText(By.id("BillingNewAddress_PhoneNumber"),"0987654321");

        //user should click on Continue
        ClickOnElements(By.xpath("//button[@name=\"save\"]"));

        //User should click on 'Next Day Air'
        ClickOnElements(By.xpath("//input[@id=\"shippingoption_1\"]"));

        //User should click on Continue
        ClickOnElements(By.xpath("//button[@class=\"button-1 shipping-method-next-step-button\"]"));

        //User should click on Check/Money Order
        ClickOnElements(By.id("paymentmethod_0"));

        //User should click on Continue
        ClickOnElements(By.xpath("//button[@class=\"button-1 payment-method-next-step-button\"]"));

        //User should check Address to send Money order
        String ExpectedResult = "NOP SOLUTIONS\n" +
                "your address here,\n" +
                "New York, NY 10001\n" +
                "USA";
        String ActualResult = driver.findElement(By.xpath("//table/tbody/tr/td/p[2]")).getText();
        System.out.println("Address to send Check to "+ ActualResult);
        Assert.assertEquals(ActualResult,ExpectedResult,"You are not on correct page Please check and try again");

        //User should click on continue
        ClickOnElements(By.xpath("//button[@class=\"button-1 payment-info-next-step-button\"]"));

        //**************************************Successfully Completed Address*********************************************************??///

        //user should Confirm and Check Order
        String BillingAddress = driver.findElement(By.xpath("//div/div/div[1]/div[1]/ul[@class=\"info-list\"]")).getText();

        //System.out.println(BillingAddress);
        String ShippingAddress = driver.findElement(By.xpath("//div/div[2]/div[1]/ul[@class=\"info-list\"]")).getText();

        //System.out.println(ShippingAddress);
        Assert.assertEquals(BillingAddress,ShippingAddress,"Your Billing Address dose not Match Shipping Address");

        //User should check Total Price
        String TotalPrice = driver.findElement(By.xpath("//tr[1]/td/span[@class=\"value-summary\"]")).getText();
        System.out.println("This is Total Price to be paid for your new computer - "+TotalPrice);

        //user should click on continue
        ClickOnElements(By.xpath("//button[@class=\"button-1 confirm-order-next-step-button\"]"));

        //user should check order has Successfully Processed
        String Expected = "Your order has been successfully processed!";
        String Actual = driver.findElement(By.xpath("//strong[.='Your order has been successfully processed!']")).getText();
        Assert.assertEquals(Actual,Expected,"You have Not Successfully Completed Process please check and trying again");

        //User should click on continue Button
        ClickOnElements(By.xpath("//button[@class=\"button-1 order-completed-continue-button\"]"));

        System.out.println("You have Successfully Completed Add To Cart Process!!!!");

        //************************Completed Registration To Add To Cart & Confirming Process****************************//
























    }

    @Test
    public void UserShouldBeAbleToRegistrationSuccessfully()  {


        //Click on Register Button
        ClickOnElements(By.className("ico-register"));
        //driver.findElement(By.className("ico-register")).click();
        //driverWaitUntilOpenUrl(10,"https://demo.nopcommerce.com/register?returnUrl=%2F");

        //user select male or female
        ClickOnElements(By.id("gender-male"));

        //user should input first name
        typeText(By.id("FirstName"), "Jack");
        //driver.findElement(By.id("FirstName")).sendKeys("Jack");

        //user should input surname
        typeText(By.id("LastName"), "Smith");
        //driver.findElement(By.id("LastName")).sendKeys("Smith");

        //user should enter your day of birth
        Select birthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        birthDay.selectByIndex(12);

        //user should enter your Month of birth
        Select birthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        birthMonth.selectByValue("4");

        //user should enter your Year of birth
        Select birthYear = new Select((driver.findElement(By.name("DateOfBirthYear"))));
        birthYear.selectByValue("1988");

        //user should input Email
        typeText(By.name("Email"), "jacksmith" + randomDate() + "@gmail.com");
        //driver.findElement(By.name("Email")).sendKeys("jacksmith3987@gmail.com");
        //System.out.println(randomDate());

        //user should input password (Jacks12345)
        typeText(By.xpath("//input[@type='password']"), "Jacks12345");
        //driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Jacks12345");

        //user should Confirm the password (Jacks12345)
        typeText(By.name("ConfirmPassword"), "Jacks12345");
        //driver.findElement(By.name("ConfirmPassword")).sendKeys("Jacks12345");

        //user should click on Register Button
        ClickOnElements(By.id("register-button"));
        //driver.findElement(By.id("register-button")).click();

        // user should be successfully Registered
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();


        Assert.assertEquals(expectedMessage,actualMessage,"Registration not Completed");

//        System.out.println(actualMessage);
//        if (actualMessage.equals(expectedMessage)) {
//            System.out.println("you have successfully Registered");
//            ;
//        } else {
//            System.out.println("you have NOT successfully Registered");
//            ;
//        }

        //user should click on Continue Button
        ClickOnElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));

        //close web page
        //driver.quit();

    }

    @Test
    public void UserShouldBeAbleToChangeCurrency(){



        //user should click on Computer
        ClickOnElements(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[contains(text(),'Computers ')]"));

        //user should click on Desktops Icon
        ClickOnElements(By.xpath("//h2/a[@title=\"Show products in category Desktops\"]"));

        //user Should check the price for build your own computer
        String ActualResults = driver.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/span")).getText();
        String ExpectedResults = "$1,200.00";
        Assert.assertEquals(ActualResults,ExpectedResults,"Your Price in US Dollar for 'Build your own Computer' is Wrong");
        System.out.println(" Your price for Build your own computer in US Dollar - "+ActualResults);

        //User should change the Currency From US Dollar to Euro
        Select Euro = new Select(driver.findElement(By.id("customerCurrency")));
        Euro.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2Fdesktops");

        //user should check the price in Euro
        String ActualResult = driver.findElement(By.xpath("//div[1]/div/div[2]/div[3]/div[1]/span")).getText();
        String ExpectedResult = "€1032.00";
        Assert.assertEquals(ActualResult,ExpectedResult,"Your Price in Euro for 'Build your own Computer' is Wrong");

        System.out.println("Your price for Build your own computer in Euro - "+ActualResult);

        //printing both price together to compare
        System.out.println(" US Dollar = " + ActualResults + " Euro = "+ ActualResult);






    }

    @Test
    public void UserShouldBeAbleToSendEmailToFriend(){

        //Click on Register Button
        ClickOnElements(By.className("ico-register"));
        //user select male or female
        ClickOnElements(By.id("gender-male"));
        //user should input first name
        typeText(By.id("FirstName"), "Jack");
        //user should input surname
        typeText(By.id("LastName"), "Smith");
        //user should input Email
        typeText(By.name("Email"), "jacksmith" + randomDate() + "@gmail.com");
        //user should input password (Jacks12345)
        typeText(By.xpath("//input[@type='password']"), "Jacks12345");
        //user should Confirm the password (Jacks12345)
        typeText(By.name("ConfirmPassword"), "Jacks12345");
        //user should click on Register Button
        ClickOnElements(By.id("register-button"));
        // user should be successfully Registered
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(expectedMessage,actualMessage,"Registration not Completed");

       //***************************************************************************************************************//
        //user should click on Computer
        ClickOnElements(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[contains(text(),'Computers ')]"));
        //user should click on Desktops Icon
        ClickOnElements(By.xpath("//h2/a[@title=\"Show products in category Desktops\"]"));
        //user should click on Build your own Computer
        ClickOnElements(By.xpath("//h2/a[@href=\"/build-your-own-computer\"]"));
        //user should click on Email a Friend
        ClickOnElements(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]"));
        //user should input Friends Email
        typeText(By.name("FriendEmail"),"Raj" + randomDate() + "@hotmail.co.uk");

        //User should enter his Email
        //typeText(By.name("YourEmailAddress"), "Jack" + randomDate() + "@gmail.com");

        //User should enter there message
        typeText(By.name("PersonalMessage"),    "Hi Raj, " +
                                                    "I am sending this link to  'Build your Own Computer' " +
                                                    "Let me know what you Think." +
                                                    "Thanks Jack ");

        ClickOnElements(By.name("send-email"));

        String ActualResults = driver.findElement(By.className("result")).getText();
        String ExpectedResults = "Your message has been sent.";
        Assert.assertEquals(ExpectedResults,ActualResults,"Your Email has not been send TRY Again");
        System.out.println("Checking you Message is a match Expected Resuults = " + ExpectedResults + " Actual Results =  " + ActualResults);



    }






    //code for Closing Browser
    @AfterMethod
    public void CloseBrowser (){
     driver.quit();}
    //Code for Opening Browser
    @BeforeMethod
    public void openBrowser (){
        System.setProperty("webdriver.chrome.driver" , "src/test/java/Drivers/chromedriver.exe");

        // Open Chrome Browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //type URL
        driver.get("https://demo.nopcommerce.com/");
    }
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

    //Codes below for waiting time needed for the Compiler
    public static void driverWaitUntilOpenUrl(int time,String url){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }
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

}
