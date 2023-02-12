package org.dozsapeter.genesys.ui_testing.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
                 features = "src/test/resources/features",
                 glue = {"org.dozsapeter.genesys.ui_testing.step_definitions"})
public class TestRunner {}