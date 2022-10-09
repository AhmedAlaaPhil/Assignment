package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HomePage {

    // web driver instants
    private WebDriver driver;
    // page URL
    String pageURL = "http://www.uitestingplayground.com/home";
    // xpath for the testing element
    String automationLinksXpath = "//*/div[@class = 'row']/div[@class ='col-sm']/h3/a[@href]";
    // xpath for the ancor element
    String ancorElementXpath = "//*/img[@src='/static/cube.png']";

    // constructor for the class that take web driver
    public  HomePage (WebDriver driver){
        this.driver = driver;

    }
    // Function to navigate to the page
    public void navigateToHomePage(){

        driver.get(pageURL);

    }
    // Function to get the ancor element
    public Boolean getAncorElement (){
        Boolean statues = false;
        statues = driver.findElement(By.xpath(ancorElementXpath)).isDisplayed();
        return  statues;
    }

    // Function to get the list of links in the page
    public   List<WebElement> getListOfLinks(){
        List<WebElement> elements;
        elements = driver.findElements(By.xpath(automationLinksXpath));
        return elements;
    }

    // Function to change elements to string
    public String[] getStringAllAutomationLinks(){
        List<WebElement> elements = getListOfLinks();
        int i = 0;
        String links[] = new String[elements.size()];
        for (WebElement element: elements
             ) {

            links[i] = element.getAttribute("href");
            i++;
            
        }
        
        return links;
    }

  // Function to return ok message to assert against
public String getAllLinksAreValidString(){

        return "All Links Are OK";
}
    // Function to check for broken links by making API head HTTP method and check for statues code
public String getAllLinkStatues(){
        String statues = "All Links Are OK";
        HttpURLConnection connection = null;
        int respCode ;
        String[] links = getStringAllAutomationLinks();
        int i ;
        for(i = 0 ; i < links.length ;i++){
            try {
                connection = (HttpURLConnection)(new URL(links[i]).openConnection());

                connection.setRequestMethod("HEAD");

                connection.connect();

                respCode = connection.getResponseCode();

                if(respCode != 200){

                    if (statues.equals("All Links Are OK") ){
                        statues = "Brkoen Links Are : \n" + "Link "+ links[i]+" is broken \n";
                    } else {
                        statues = statues + "Link " + links[i] + " is broken \n";
                    }
                }
                else{

                }

            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    return  statues;
}



}
