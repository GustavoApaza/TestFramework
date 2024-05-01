package pages;

import utility.MasterPage;
import java.util.ArrayList;
import static locators.TotalPriceOfTheCartLocators.*;

public class TotalPriceOfTheCartPage {
    ArrayList<Integer> listNumbers = new ArrayList<>();
    MasterPage masterPage = new MasterPage();
    public void addProductToTheCart() throws InterruptedException {
        masterPage.implicitWait(5);
        listNumbers.add(masterPage.getNumber(priceElement));
        masterPage.selectWebElement(addToCartButton);
        masterPage.acceptAlert();
        System.out.println(listNumbers);
    }
    public String totalSum(){
        return String.valueOf(listNumbers.stream().mapToInt(Integer::intValue).sum());
    }
}
