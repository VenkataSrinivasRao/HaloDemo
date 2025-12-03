package com.parabank.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * RunnerTest class is the TestNG runner for executing Cucumber BDD scenarios.
 *
 * Key Responsibilities:
 * - Links feature files to step definitions using the 'features' and 'glue' paths.
 * - Enables reporting plugins such as Allure through `plugin` configuration.
 * - Ensures clean console output using `monochrome = true`.
 * - Extends AbstractTestNGCucumberTests to allow running scenarios via TestNG.
 *
 * Note:
 * - The 'hooks' package in glue should contain Hook classes for setup/teardown.
 * - For parallel execution, override the DataProvider (optional enhancement).
 */


@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"com.parabank.steps", "hooks"},
	    plugin = {
	        "pretty",
	        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
	    },
	    monochrome = true
	)


public class RunnerTest extends AbstractTestNGCucumberTests{

}
