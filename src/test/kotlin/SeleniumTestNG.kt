import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test


class SeleniumTestNG {

    private var driver: WebDriver? = null

    @BeforeMethod
    fun setUp() {
        WebDriverManager.chromedriver().setup()
        val driver = ChromeDriver()
        driver.get("https://demoqa.com/automation-practice-form")
        driver.manage().window().maximize()
    }

    @Test
    fun demoUITest() {
        driver?.findElement(By.cssSelector("[id='firstName']"))?.sendKeys("Petr");
        driver?.findElement(By.cssSelector("[id='lastName']"))?.sendKeys("Petrov");
        driver?.findElement(By.cssSelector("[id='userNumber']"))?.sendKeys("1234567898");
        driver?.findElement(By.cssSelector("[for='gender-radio-1']"))?.click();
        driver?.findElement(By.cssSelector("[id='submit']"))?.click();

        driver?.findElement(By.cssSelector("[id='example-modal-sizes-title-lg']"))
            ?.let { Assert.assertTrue(it.isDisplayed()) };

        Thread.sleep(3000)
    }

    @AfterMethod
    fun tearDown() {
        driver?.quit()
    }
}