import org.testng.annotations.Test;
import pages.FormPage;

public class FormPOPTest extends TestBase{


    @Test
    public void checkRandoms() throws InterruptedException {
        driver.get("https://seleniumui.moderntester.pl/form.php");
        FormPage formPage = new FormPage(driver);
        formPage.selectRandomProfession();
        formPage.selectContinent("North America");
        formPage.setFirstName("Adam");

        Thread.sleep(5000);
    }
}
