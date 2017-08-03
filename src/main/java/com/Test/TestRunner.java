package com.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by olu on 25/05/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"~@wip", "@test"},
        features = "src/test/java/com/Test/Feature",
        plugin = {"pretty", "html:target/cucumber-html-report/", "pretty:target/cucumber-pretty.txt"}
)
public class TestRunner {
}
