package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FormPage {
    @FindBy(id="inputFirstName3")
    WebElement firstName;
    @FindBy(id="selectContinents")
    WebElement continents;
    @FindBy(name="gridCheckboxProfession")
    List<WebElement> proffesions;

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void selectContinent(String continent) {
        Select con = new Select(continents);
        con.selectByVisibleText(continent);
    }

    public void selectRandomProfession() {
        List<Integer> randoms = new ArrayList<>();
        //0-proffesions.size
        randoms.add(ThreadLocalRandom.current().nextInt(0, proffesions.size()));

        Integer k = ThreadLocalRandom.current().nextInt(0, proffesions.size());
        while (randoms.contains(k)) {
            k = ThreadLocalRandom.current().nextInt(0, proffesions.size());

        }
        randoms.add(k);
        for (Integer i : randoms)
            proffesions.get(i).click();


    }
}
