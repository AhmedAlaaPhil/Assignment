import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import pages.DynamicID;
import pages.DynamicTable;
import pages.HomePage;

public class WebUITest {
    // Instants
   WebDriver driver;
   DynamicTable dynamicTable;
   HomePage homePage;
   DynamicID dynamicID;
   //run before class
    @BeforeClass
    public void Init (){
        // set up the web driver manger
        WebDriverManager.firefoxdriver().setup();
        // set up options for chrome driver
        FirefoxOptions options = new FirefoxOptions();
        // set options to headless mode
        options.addArguments("--headless");
        // init web driver
        driver = new FirefoxDriver(options);
        dynamicTable = new DynamicTable(driver);
        homePage = new HomePage(driver);
        dynamicID = new DynamicID(driver);

    }
    /*
     * Test case 1 : check if all the links in home page are working
     * Priority : very High
     * asserts there is no broken links
     * */
    @Test
    public void TC01_HomePageTest(){

    // Boolean to  check if we navigated to the page
      Boolean statues = false;
      // String to assert against
      String  linkStatues ;
      // navigate to the home page
       homePage.navigateToHomePage();
       // check if navigated to the right page by checking unique element in that page
       statues = homePage.getAncorElement();
       Assert.assertTrue(statues);
       // get link statues
       linkStatues = homePage.getAllLinkStatues();
       // assert on link statues
       Assert.assertEquals(linkStatues , homePage.getAllLinksAreValidString());

    }
    /*
     * Test case 2 : check dynamicID test
     * Priority : High
     * It is the first link the website it should be working as expected
     * asserts there is a dynamicID
     * */
    @Test
    public void TC02_DynamicIDTest(){
        // String for first ID
        String previousID;
        // String for new ID after refreshing the page
        String currentID;
        // navigate to page
        dynamicID.navigateToDynamicIDPage();
        // check if navigated to the right page by checking unique element in that page
        Assert.assertTrue(dynamicID.checkButtonWithDynamicIDDisplayed());
        // get the ID for the First time
        previousID = dynamicID.getButtonDynamicIDText();
        // refresh page
        dynamicID.refreshDynamicIDPage();
        //get the ID for the second time
        currentID = dynamicID.getButtonDynamicIDText();
        // assert the ID is different
        Assert.assertNotEquals(previousID,currentID);
    }

    /*
     * Test case 3 : check dynamic Table test
     * Priority : medium
     * check one test from the middle of the list
     * asserts chrome CPU usage is the same as the table
     * */
    @Test
    public void TC03_DynamicTableTest(){
        // String to append the data from the table to make an exact match for the data in the Yellow like
        String chromeCPUUsage = "Chrome CPU: ";
        // String to hold CPU data in the yellow line
        String chromeCPUYellowLineDisplayed;
        // navigate to page
        dynamicTable.navigateToDynamicTablePage();
        // check if navigated to the right page by checking unique element in that page
        Assert.assertTrue(dynamicTable.checkChromeCPUUsageFromTableDisplayed());
       // get and append cpu data from the table
        chromeCPUUsage = chromeCPUUsage +dynamicTable.getChromeCPUUsageFromTable();
        // get the cpu data from yellow line
        chromeCPUYellowLineDisplayed = dynamicTable.getChromeCPUUsageFromYellowLine();
        // assert equal
        Assert.assertEquals(chromeCPUYellowLineDisplayed , chromeCPUUsage);


    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
