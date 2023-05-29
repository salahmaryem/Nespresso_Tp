package com.sqli.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/", glue = "com.sqli.steps", plugin = {"pretty", "html:target/htmlreports.html", "json:target/htmlreports.json"})
public class CucumberRunner {

}

