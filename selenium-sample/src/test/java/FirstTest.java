
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest extends TestBase {

    @Test
    public void myFirstTest() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");
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

        System.out.println(driver.manage().getCookies());
    }

    @Test
    public void mySecondTest() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");
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

        System.out.println(driver.manage().getCookies());
    }

    @Test
    public void myThirdTest() throws InterruptedException {
        driver.navigate().to("https://www.google.com/");
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

        System.out.println(driver.manage().getCookies());
    }
}
