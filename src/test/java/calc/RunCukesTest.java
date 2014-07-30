package calc;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "src/test/resources/calc",
		format = {"html:target/test-reports/cucumber",
				"junit:target/test-reports/TEST-cukes.xml",
				"json:target/TEST-cukes.json"})
public class RunCukesTest {
}
