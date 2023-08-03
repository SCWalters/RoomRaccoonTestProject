import org.example.framework.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testRunner extends BaseTest {
    @Test
    public void openWebPage() {

        //Proceeds to perform actions and verification
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Rocket Raccoon", "Title does not match");

    }

    MainPage mainPage;

    @Test
    public void addTest(){
        //Adds a new field to the list
        mainPage = new MainPage(driver);
        mainPage.addButton();
        mainPage.enterTitle("My Test");
        mainPage.submitButton();
    }

    @Test
    public void viewTest(){
        //Views the created field
        mainPage = new MainPage(driver);
        mainPage.viewButton("My Test");

    }

}