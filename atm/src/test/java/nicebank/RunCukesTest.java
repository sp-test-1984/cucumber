package nicebank;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:nicebank",
glue = "classpath:nicebank",
plugin = { "pretty", "html:out" })
public class RunCukesTest{

}