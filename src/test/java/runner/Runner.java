package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static Utils.ConfigFileReader.dashboardConfig;
import static core.BaseTest.setup;


@RunWith(Cucumber.class)
@CucumberOptions(
         strict = true
        ,features = {"./src/test/java/features"}
        ,snippets = SnippetType.CAMELCASE
        ,glue = {"steps"}
        ,monochrome = true
        ,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
        ,tags ={"@AllTest"}

        //Tags
        //@servicesAll, @consultaDoc, @DatumTest

        )


public class Runner{



    @BeforeClass
    public static void setupApi(){
            setup();
    }
    @AfterClass
    public static void report(){
            dashboardConfig();
    }


}

