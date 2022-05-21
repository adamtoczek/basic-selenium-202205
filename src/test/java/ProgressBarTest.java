import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBarTest extends TestBase{
    @Test
    public void shouldContainCompleteClass() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        driver.findElement(By.cssSelector("#progressbar>div.ui-progressbar-complete"));
    }

    @AfterMethod
    public void resetImplicitWaitTime() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME_SECONDS));
    }

    @Test
    public void progressBarShouldShowComplete() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        String text = "Complete!";
        WebElement label = driver.findElement(By.cssSelector("#progressbar>.progress-label"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.textToBePresentInElement(label, text));
        wait.until(c->label.getText().equals(text));
    }

    @Test
    public void progressBarClassShouldContainCompleted() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        String className = "ui-progressbar-complete";
        WebElement bar = driver.findElement(By.cssSelector("#progressbar>.ui-progressbar-value"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.attributeContains(bar, "class", className));

        wait.until(c -> bar.getAttribute("class").contains(className));
    }



}
