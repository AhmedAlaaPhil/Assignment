package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicTable {

private WebDriver driver;
String pageURL = "http://www.uitestingplayground.com/dynamictable";
String chromeCPUTableXpath = "//*/div[@role='row']/span[@role = 'cell' and text()='Chrome']/following-sibling::span[contains(text(),'%')]";
String chromeCPUXpath = "//*/p[contains(text(),'Chrome CPU')]";


public DynamicTable(WebDriver driver){
    this.driver = driver;

}

public void navigateToDynamicTablePage(){

    driver.get(pageURL);

}


public Boolean checkChromeCPUUsageFromTableDisplayed(){

    Boolean status = false ;

    status = driver.findElement(By.xpath(chromeCPUTableXpath)).isDisplayed();

    return  status;
}

public Boolean checkChromeCPUUsageFromYellowLineDisplayed(){

        Boolean status = false ;

        status = driver.findElement(By.xpath(chromeCPUXpath)).isDisplayed();

        return  status;
    }


public String getChromeCPUUsageFromTable(){
    String usage;

    usage = driver.findElement(By.xpath(chromeCPUTableXpath)).getText();
    return usage;

}

public String getChromeCPUUsageFromYellowLine(){
        String usage;

        usage = driver.findElement(By.xpath(chromeCPUXpath)).getText();
        return usage;

    }





}
