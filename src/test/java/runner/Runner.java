package test.java.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Feature_Files"}, glue = {"test.java.step.definitions"},
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true, tags = "@Validate_Irctc_Site")
public class Runner {
}