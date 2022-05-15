import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FormTest extends TestBase{
    String url = "https://seleniumui.moderntester.pl/form.php";


    @Test
    public void shouldFillFormWithSuccess() {
        driver.get(url);
        WebElement fname = driver.findElement(By.id("inputFirstName3"));
        fname.sendKeys("Adam");

        List<WebElement> radioSex = driver.findElements(By.name("gridRadiosSex"));
        logger.info("Imie wypelnione");
        for(WebElement element : radioSex) {
            if (element.getAttribute("value").equals("other")) {
                element.click();
                break;
            }
        }
        driver.findElement(By.id("inputLastName3")).sendKeys("Toczek");
        driver.findElement(By.id("inputEmail3")).sendKeys("adam@sii.pl");
        driver.findElement(By.id("inputAge3")).sendKeys("32");
        driver.findElement(By.cssSelector("*[name=\"gridRadiosExperience\"][value=\"7\"]")).click();
        driver.findElement(By.id("gridCheckAutomationTester")).click();
        driver.findElement(By.id("gridCheckOther")).click();
        Assert.assertEquals(driver.findElement(By.id("gridCheckOther")).isSelected(), true);


        //select dropdown jednokrotnego wyboru
        Select continent = new Select(driver.findElement(By.id("selectContinents")));
        continent.selectByValue("europe");

        Select comands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        comands.selectByValue("browser-commands");
        comands.selectByValue("switch-commands");
        comands.selectByValue("wait-commands");

        driver.findElement(By.id("chooseFile")).sendKeys("C:\\Test\\test.txt");
        driver.findElement(By.id("additionalInformations")).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        //submit
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//        driver.findElement(By.tagName("form")).submit();
//        driver.findElement(By.id("inputFirstName3")).submit();

        //asercje
        WebElement message = driver.findElement(By.id("validator-message"));
        Assert.assertEquals(message.getText(), "Form send with success");


    }


}
