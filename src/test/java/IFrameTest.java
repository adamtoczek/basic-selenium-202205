import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IFrameTest extends TestBase{
    @Test
    public void iFrameTest() {
        driver.get("https://seleniumui.moderntester.pl/iframes.php");

        driver.switchTo().frame("iframe1");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Adam");
        driver.switchTo().defaultContent();

        driver.switchTo().frame("iframe2");
        driver.findElement(By.id("inputLogin")).sendKeys("Adam");
        driver.switchTo().defaultContent();


    }

}
