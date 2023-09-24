package com.appium.amazon.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/AmazonShopping.Feature"
        ,glue={"com/appium/amazon/steps/"}

)

public class AmazonRunner {

}