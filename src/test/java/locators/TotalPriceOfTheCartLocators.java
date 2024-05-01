package locators;

import org.openqa.selenium.By;

public class TotalPriceOfTheCartLocators {
    // Aca le agrego "public static final para poder acceder a los By sin usar un metodo"
    public static final By samsungGalaxyS6Link = By.xpath("//a[normalize-space()='Samsung galaxy s6']");
    public static final By priceElement = By.xpath("//h3[@class='price-container']");
    public static final By addToCartButton = By.xpath("//a[contains(text(),'Add to cart')]");
    public static final By homeNavLink = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");
    public static final By nokiaLumia1520Link = By.linkText("Nokia lumia 1520");
    public static final By cartNavLink = By.id("cartur");
    public static final By totalPrice = By.cssSelector("h3[id='totalp']");
}
