package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicID {
    // web driver instants
    WebDriver driver;
    // page URL as string
    String pageURL = "http://www.uitestingplayground.com/dynamicid";
    // Xpath for the element to be tested
    String buttonWithDynamicIDXpath= "//*/button[text() = 'Button with Dynamic ID']";

    // constructor for the class that take web driver
    public DynamicID (WebDriver driver){
        this.driver = driver;
    }

    // Function to navigate to the page
    public void navigateToDynamicIDPage(){

        driver.get(pageURL);

    }

    // Function to refresh the page as part of the test
    public void refreshDynamicIDPage (){
        driver.navigate().refresh();
    }


    // Function ot check if the element we need to test is displayed
    public Boolean checkButtonWithDynamicIDDisplayed(){

        Boolean status = false ;

        status = driver.findElement(By.xpath(buttonWithDynamicIDXpath)).isDisplayed();

        return  status;
    }

    // Function to get ID of the element to text
    public String getButtonDynamicIDText(){
        String id ;
        id = driver.findElement(By.xpath(buttonWithDynamicIDXpath)).getAttribute("ID");

        return id;

    }



}
