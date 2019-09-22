package runner;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Feature_Files"}, glue = {"step.definitions"},
plugin = {"pretty", "html:target/cucumber-reports"}, monochrome = true, tags = {"@Login_And_Book_Tickets"})
public class Runner {
}