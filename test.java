package seleniumgluecode;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class test {
    public static WebDriver driver;
    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {     
    	System.setProperty("webdriver.chrome.driver","C:/Users/Sri/eclipse-workspace/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.sixty.no/");
        driver.manage().window().maximize();
    }
    
    @When("^user clicks Ease Live Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
    	driver.findElement(By.xpath("//*[@id=\"hs-eu-confirmation-button\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"main-header-content\"]/nav/ul/li[1]/a")).click();
    }
    
    @Then("^verify url$")
    public void success_message_is_displayed() throws Throwable {
    	String exp_message = "https://www.sixty.no/ease-live/";
    	String url1 = driver.getCurrentUrl();
        Assert.assertEquals(exp_message, url1);
        driver.quit();  
    }      
}

