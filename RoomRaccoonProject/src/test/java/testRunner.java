import org.example.framework.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testRunner extends BaseTest {
    @Test
    public void openWebPage() {

        //Proceeds to perform actions and verification
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Rocket Raccoon", "Title does not match");

    }

    @Test
    public void addTest(){
        //Adds a new field to the list
        HomePage homePage = new HomePage(driver);
        homePage.addButton();
        homePage.enterTitle("My Test");
        homePage.submitButton();

    }

    @Test
    public void viewTest(){
        //Views the created field
        HomePage homePage = new HomePage(driver);
        homePage.viewButton("My Test");
    }

}