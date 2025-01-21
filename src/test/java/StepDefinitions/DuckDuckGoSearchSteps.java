package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DuckDuckGoSearchSteps {

	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		System.getProperty("webdriver.chrome.driver", "../../src/test/Resources/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@And("user is on the DuckDuckGo search page")
	public void user_is_on_the_duckduckgo_search_page() {
		driver.navigate().to("https://duckduckgo.com/");
	}

	@When("user searches current time in California")
	public void user_searches_current_time_in_California() {
		driver.findElement(By.id("searchbox_input")).sendKeys("current time in California");
	}

	@And("hits enter")
	public void hits_enter() {
		driver.findElement(By.id("searchbox_input")).sendKeys(Keys.ENTER);
	}

	@Then("user is shown the search results")
	public void user_is_shown_the_search_results() {
		WebElement searchResultsOl = driver.findElement(By.className("react-results--main"));

		// wait at most 10 seconds to see if search results are displayed
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> searchResultsOl.isDisplayed());

		// assert if "Time in California" is on the search results
		boolean isTextFound = driver.getPageSource().contains("Time in California");
		assertTrue("Unexpected search results", isTextFound);

		driver.close();
		driver.quit();
	}
}