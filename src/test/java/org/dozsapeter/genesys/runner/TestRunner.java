package org.dozsapeter.genesys.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
                 features = "src/test/resources/features",
                 glue = {"org.dozsapeter.genesys.step_defintions"})
public class TestRunner {}