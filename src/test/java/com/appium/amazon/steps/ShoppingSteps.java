package com.appium.amazon.steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class ShoppingSteps {

    public static WebDriver driver;
    @Given("^an Amazon application iOS$")
    public void an_Amazon_application_iOS() throws Throwable {
        System.out.println("Launching Applications");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.5");

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13");
        capabilities.setCapability(CapabilityType.BROWSER_NAME,"safari");
        URL url= new URL("http://127.0.0.1:4723/wd/hub");
        driver = new RemoteWebDriver(url, capabilities);

        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.get("https://www.amazon.in");
        System.out.println("Launched Amazon App Sucessfully");
        Thread.sleep(10000);
        System.out.println("Trying to hit Login");
    }

    @When("^user login to shopping application$")
    public void user_login_to_shopping_application() throws Throwable {
        WebElement signin = driver.findElement(By.xpath("//*[@id=\"nav-logobar-greeting\"]"));

        signin.click();

        WebElement username=driver.findElement(By.xpath("//*[@id=\"ap_email_login\"]"));
        WebElement continuesignbtn=driver.findElement(By.xpath("//*[@id=\"ap_login_form\"]/div[4]/div/span/span/input"));
        username.sendKeys("+91 8508113144");
        continuesignbtn.click();
        Thread.sleep(10000);
        WebElement continuesigninpasswordbtn=driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        continuesigninpasswordbtn.click();
        Thread.sleep(10000);
        WebElement optoutsignPassowrd=driver.findElement(By.xpath("//*[@id=\"auth-show-password-checkbox-container\"]/label/i"));
        optoutsignPassowrd.click();
        WebElement signwithpassword=driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
        signwithpassword.sendKeys("**********");
        WebElement signbtn= driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        signbtn.click();




    }

    @Then("^shopping application page should be displayed$")
    public void shopping_application_page_should_be_displayed() throws Throwable {

WebElement loginName= driver.findElement(By.xpath("//*[@id=\"nav-greeting-name\"]/b"));

        Assert.assertEquals("Verify Login name",loginName.getText(),"Rajalakshmi");

    }

    @When("^user select electronic category item$")
    public void user_select_electronic_category_item() throws Throwable {
WebElement addelectronicItem= driver.findElement(By.xpath("//*[@id=\"nav-search-keywords\"]"));
addelectronicItem.sendKeys("earpods");
WebElement selectsearch=driver.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div[2]/div/input"));
selectsearch.click();

        WebElement selectelectronicitem= driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/div[5]/div/div/div/div/div/div[1]/span/a/div/div/div[2]/span/span/div/img"));

WebElement addcart= driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
addcart.click();
    }

    @Then("^selected item should be added to cart$")
    public void selected_item_should_be_added_to_cart() throws Throwable {

WebElement verifycartvalue= driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]"));
Assert.assertEquals("Verify cart count",verifycartvalue.getText(),"1");
    }

    @When("^user select book category item$")
    public void user_select_book_category_item() throws Throwable {
        WebElement addelectronicItem= driver.findElement(By.xpath("//*[@id=\"nav-search-keywords\"]"));
        addelectronicItem.sendKeys("harrypotter");
        WebElement selectsearch=driver.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div[2]/div/input"));
        selectsearch.click();

        WebElement selectelectronicitem= driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/div[5]/div/div/div/div/div/div[1]/span/a/div/div/div[2]/span/span/div/img"));

        WebElement addcart= driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
        addcart.click();
    }

    @When("^user select item from Deals of day$")
    public void user_select_item_from_Deals_of_day() throws Throwable {

        WebElement verifycartvalue= driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]"));
        Assert.assertEquals("Verify cart count",verifycartvalue.getText(),"2");
    }

    @When("^user add new delivery address to shipping$")
    public void user_add_new_delivery_address_to_shipping() throws Throwable {
        WebElement proccedtocheckout= driver.findElement(By.xpath("//*[@id=\"a-autoid-0\"]/span/input"));
        proccedtocheckout.click();
    }

    @Then("^new address should be displayed$")
    public void new_address_should_be_displayed() throws Throwable {

WebElement selectaddress= driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]"));
selectaddress.click();
    }


}
