package utility;

import drivers.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MasterPage extends ChromeDriverManager {
    public void navigateTo(String url){
        driver.manage().window().maximize();
        driver.get(url);
    }
    public int getNumber(By priceElement){
        WebElement priceWebElement = driver.findElement(priceElement);
        String priceText = priceWebElement.getText();
        // Definir la expresión regular para encontrar números
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(priceText);

        // Iterar sobre las coincidencias y concatenarlas en una cadena
        StringBuilder numbers = new StringBuilder();
        while (matcher.find()) {
            numbers.append(matcher.group());
        }
        return Integer.parseInt(numbers.toString());
    }
    public boolean isAlertPresent() {
        boolean presentFlag = false;
        try {
            Alert alert = driver.switchTo().alert();
            presentFlag = true;
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
        return presentFlag;
    }
    public void acceptAlert() throws InterruptedException {
        int i = 0;
        while(i++ < 5) {
            boolean flag = isAlertPresent();
            if(flag) {
                driver.switchTo().alert().accept();
                break;
            }
            if(i == 5) {
                throw new java.lang.Error("Alert isn't display");
            } else {
                Thread.sleep(500);
                continue;
            }
        }
    }
    public void implicitWait(int secondTime){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secondTime));
    }
    public void explicitWait(By locator, int secondTime){
        WebElement totalPriceWebElement = driver.findElement(locator);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(secondTime));
        wait.until(d -> totalPriceWebElement.isDisplayed());
    }
    public void selectWebElement(By locator){
        WebElement webElement = driver.findElement(locator);
        webElement.click();
    }
    public String textOfTheLocator(By locator){
        WebElement webLocator = driver.findElement(locator);
        return webLocator.getText();
    }

}
