package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

public class BasePage {

  protected static WebDriver driver;
  private static WebDriverWait wait;

     public static void openBrowser() {
      String browser = "";
      File path = new File(".");
      switch (browser) {
          case "chrome":
              ChromeOptions chromeOptions = new ChromeOptions();
              driver = new ChromeDriver(chromeOptions);
              break;
          case "firefox":
              try {
                  System.setProperty("webdriver.gecko.driver",
                          path.getCanonicalPath() + "\\src\\test\\resource\\drivers\\geckodriver.exe");
              } catch (IOException e) {
                  e.printStackTrace();
              }
              driver = new FirefoxDriver();
              break;
          default:
              try {
                  System.setProperty("webdriver.chrome.driver",
                          path.getCanonicalPath() + "\\src\\test\\resource\\drivers\\chromedriver.exe");
              } catch (IOException e) {
                  e.printStackTrace();
              }
              chromeOptions = new ChromeOptions();
              driver = new ChromeDriver(chromeOptions);
              break;
      }
      driver.manage().window().maximize();
      wait = new WebDriverWait(driver, Duration.ofSeconds(30));
  }

    public static void closeBrower() {
        driver.close();
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static String getUrl() {
        return driver.getCurrentUrl();
    }

    public static String getTitle() {
        return driver.getTitle();
    }

    public static WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public static void fill(String locator, String value) {
        find(locator).sendKeys(value);
    }

    public static void click(String locator) {
        find(locator).click();
    }

    public static void selectByVisibleText(String locator, String text) {
        Select list = new Select(find(locator));
        list.selectByVisibleText(text);
    }

    public static void selectByIndex(String locator, int index) {
        Select list = new Select(find(locator));
        list.selectByIndex(index);
    }

    public static int getElementSize(String locator) {
        return driver.findElements(By.xpath(locator)).size();
    }

    public static String getInnerText(String locator) {
        return find(locator).getAttribute("innerText");
    }

    public static String getText(String locator) {
      return find(locator).getText();
    }

    public static String getInnerHTML(String locator) {
        return find(locator).getAttribute("innerHTML");
    }

    // Assertions

    public static boolean toBeVisible(String locator) {
        return find(locator).isDisplayed();
    }

    public static boolean toBeEnabled(String locator) {
        return find(locator).isEnabled();
    }

    public static boolean toBeSelected(String locator) {
        return find(locator).isSelected();
    }

    public static boolean toContainText(String locator, String value) {
        String text = find(locator).getText();
        if (text.contains(value)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean toContain(String text, String value) {
        if (text.contains(value)) {
            return true;
        } else {
            return false;
        }
    }

    
    public static void takeScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
        
    }

    public static void waiting() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
}
