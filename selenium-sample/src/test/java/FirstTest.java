
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("unexpectedAlertBehaviour", "dismiss");
//        driver = new ChromeDriver(caps);
//        System.out.println(((HasCapabilities) driver).getCapabilities());

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-fullscreen");
//        driver = new ChromeDriver(options);
//        OR
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability(ChromeOptions.CAPABILITY, options);
//        driver = new ChromeDriver(caps);

//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        driver = new InternetExplorerDriver(caps);
//        System.out.println(((HasCapabilities) driver).getCapabilities());

        DesiredCapabilities caps = new DesiredCapabilities();
        FirefoxProfile profile = new FirefoxProfile();
        driver = new FirefoxDriver(caps);

        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        Thread.sleep(1000);
        driver.findElement(By.name("btnK")).click();

        String s = null;
        try {
            String priwet = new String(
                    "\u041F" + "\u043E" + "\u0448" + "\u0443" + "\u043A");
            byte[] utf8Bytes = priwet.getBytes("UTF8");
            s = new String(utf8Bytes, "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        wait.until(titleIs("webdriver - " + s + " Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
