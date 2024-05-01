package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager {
    //  Using static in Block ++++++++++++++++++++++++++++++++++++++++++++
    protected static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    //  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void closeNavigator(){
        driver.quit();
    }
}
