package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/totalPriceOfTheCart.feature",
        glue = {"steps"}
)

public class Run extends AbstractTestNGCucumberTests {

}
