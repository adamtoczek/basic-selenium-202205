import org.testng.Assert;
import org.testng.annotations.*;

public class KalkulatorTests {

    @BeforeClass
    public void beforeClass() {
        System.out.println("run once before all tests");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("run before each test method");
    }

    @Test
    public void verifyAdd() {
        Assert.assertEquals(Kalkulator.add(2, 3), 5);
    }

    @Test
    public void verifyMultiply() {
        int wynik = Kalkulator.multiply(2,3);
//        Assert.assertTrue(wynik == 10);
        Assert.assertEquals(wynik, 10, "Wynik mnozenia jest inny niz spodziewany");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("run after each test method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("run after all test methods");
    }
}
