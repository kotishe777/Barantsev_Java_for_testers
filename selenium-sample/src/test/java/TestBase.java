import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public static WebDriverWait wait;

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

//        DesiredCapabilities caps = new DesiredCapabilities();
//        FirefoxProfile profile = new FirefoxProfile();
//        driver = new FirefoxDriver(caps);

//        driver = new ChromeDriver();
//        driver.manage().getCookies();

        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
        driver = new ChromeDriver();
        tlDriver.set(driver);
        wait = new WebDriverWait(driver, 10);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {driver.quit(); driver = null;}));
    }

    @After
    public void stop() {
//        driver.quit();
//        driver = null;
    }
}
