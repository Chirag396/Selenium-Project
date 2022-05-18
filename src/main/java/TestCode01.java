import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCode01 {

    public static void driverWaitUntil(WebElement element, int time){
        WebDriverWait wait2 = new WebDriverWait(TestSuits.driver, Duration.ofSeconds(time));
        wait2.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void driverWaitUntilPresenseOfElement(By by, int time){
        WebDriverWait wait3 = new WebDriverWait(TestSuits.driver,Duration.ofSeconds(time));
        wait3.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void driverWaitUntilElementTitleContains(By by, int time, String TitleContains){
        WebDriverWait wait4 = new WebDriverWait(TestSuits.driver,Duration.ofSeconds(time));
        wait4.until(ExpectedConditions.titleContains(TitleContains));

    }





}
