/*
 * Copyright (c) 2022 DGFiP - Tous droits réservés
 */
package fr.gouv.finances.oda.automatedTests.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

/**
 *  This class is used to cleanly exit it when the test has completed.
 */
public class TearDown
{
    
    
    /** log. */
    private Logger log = LogManager.getLogger();

    /**
     * This method is used to close browser. This method is called after the invocation of each test method in given class.
     *
     * @param scenario 
     * @After Methods annotated with @After execute after every scenario.
     */
    @After
    public void quitDriver(Scenario scenario)
    {
        
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Setup.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        
        log.info("Goodbye!");
        Setup.getDriver().quit();
    }
}
