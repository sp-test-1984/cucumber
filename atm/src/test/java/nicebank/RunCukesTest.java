package nicebank;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:nicebank",
glue = "classpath:nicebank")
public class RunCukesTest{

}