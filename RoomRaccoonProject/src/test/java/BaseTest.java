import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //Set the path to the ChromeDriver executable H:\\Automation Projects\\IntelliJ Projects\\RoomRacoon\\ProjectRocketRacoon\\chromedriver.exe"
        System.setProperty("webdriver.chrome.driver", "chromeDriver\\chromedriver.exe");

        //Initialize the Webdriver
        driver = new ChromeDriver();

        //Maximize the browser window
        driver.manage().window().maximize();

        //Opens the site
        driver.get("https://beta.warrenroman.com/project-rocket-raccoon/home");
    }

    @AfterMethod
    public void tearDown() {
        //Closes the browser after each test method
        driver.quit();
    }
}
