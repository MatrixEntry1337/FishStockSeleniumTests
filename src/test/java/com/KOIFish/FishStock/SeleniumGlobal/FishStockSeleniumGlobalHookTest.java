package com.KOIFish.FishStock.SeleniumGlobal;

import org.junit.Ignore;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/login.feature"},
				glue={"com.KOIFish.FishStock.Login"})
public class FishStockSeleniumGlobalHookTest {


}
