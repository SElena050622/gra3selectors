import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CallBankTest {
    private WebDriver driver;
    //ChromeOptions options = new ChromeOptions();
//options.addArguments("--disable-dev-shm-usage");
//options.addArguments("--no-sandbox");
//options.addArguments("--headless");
    //driver = new ChromeDriver(options);

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "/drivers/win/chromedriver.exe");
    }
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }
    @Test
    void shouldTestV1() IntrruptedException {
        driver.get("http://localhost:9999/");
        List<WebElement> input = driver.findElements(By.tagName("input"));
        input.get(0).sendKeys("Ив Иван");
        input.get(1).sendKeys("+79998888888");
        driver.findElement(By.className("checkbox__control")).click();
        driver.findElement(By.className("button__content")).click();
        //driver.findElement(By.cssSelector("[data-test-id=phone]. input")).sendKeys("+79998888888");
        String text = driver.findElement(By.className("[data-test-id=order-success]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.");
    }

}
