package CustomStep;


import Selenium.ExtendTesboDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import reportAPI.Reporter;


public class code extends ExtendTesboDriver{
    public code(WebDriver driver) {
        super(driver);
    }
    Reporter reporter=new Reporter();

    @Step("Select pending option from order status dropdown")
    public void SelectPendingOptionFromOrderStatusDropdown() {
       WebElement element= driver.findElement(By.id("OrderStatusId"));
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText("Pending");
        reporter.printStep("Pending option is selected from dropdown!!!");
    }

    @Step("Click on run report button")
    public void clickOnRunReportBtn() {
        driver.findElement(By.id("search-countryreport")).click();
        reporter.printStep("Click on run report button!!!");
    }

    @Step("verify country name and number of pending orders")
    public void verifyCountryNameAndNumberOfPendingOrders(String countryName, String pendingOrders) {
        WebElement nameOfCountry=driver.findElement(By.xpath("//tbody/tr/td[1]"));
        WebElement numberOfPendingOrders=driver.findElement(By.xpath("//tbody/tr/td[2]"));

        Assert.assertEquals(nameOfCountry.getText(),countryName);
        reporter.printStep("Country name is verified!!!");
        Assert.assertEquals(numberOfPendingOrders.getText(),pendingOrders);
        reporter.printStep("Number of pending orders is verified!!!");
    }

}
