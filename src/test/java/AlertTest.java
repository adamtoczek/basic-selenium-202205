import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends TestBase{

    private String url="https://seleniumui.moderntester.pl/alerts.php";

    @BeforeMethod
    public void setUp() {
        driver.get(url);
    }
    @Test
    public void sholdAcceptAlert(){
        //klikamy button
        driver.findElement(By.id("simple-alert")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        //a potem asercja
        Assert.assertEquals(driver.findElement(By.id("simple-alert-label")).getText(),"OK button pressed");
    }

    @Test
    public void shouldFillPromptAlert(){
        driver.findElement(By.id("prompt-alert")).click();
        driver.switchTo().alert().sendKeys("Jan");
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        //a potem asercja
        Assert.assertEquals(driver.findElement(By.id("prompt-label")).getText(),"Hello Jan! How are you today?");
    }
    @Test
    public void shouldDismissAlert(){
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent();
        //a potem asercja
        Assert.assertEquals(driver.findElement(By.id("confirm-label")).getText(),"You pressed Cancel!");
    }
}
