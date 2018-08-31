package cucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\test\\java\\cucumberTests\\sample.feature"},
glue = {"cucumberTests"},
plugin ={"pretty","html:reports/test-report"})

public class TestRun {

}
