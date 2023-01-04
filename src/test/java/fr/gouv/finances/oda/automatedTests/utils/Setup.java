/*
 * Copyright (c) 2022 DGFiP - Tous droits réservés
 */
package fr.gouv.finances.oda.automatedTests.utils;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.cucumber.java.Before;

/**
 * This class is used to start your browser session before running your test
 */
public class Setup extends BasePage
{

    private static WebDriver driver;

    final ConfigFileReader configFileReader = new ConfigFileReader();

    /**
     * This method is used to open browser. This method is called before the invocation of each test method in the given
     * class. In this method we need to pass browser name which will invoke the respective driver.
     *
     * @throws IOException Signal qu'une execption de type I/O s'est produite.
     * @Before Methods annotated with @Before will execute before every scenario.
     */
    @Before
    public void setWebDriver() throws IOException
    {

        String browser = System.getProperty("browser");
        if (browser == null)
        {
            browser = "firefox";
        }
        switch (browser)
        {
            case "chrome":
                /**
                 * Starting a session with Chrome.
                 */
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("['start-maximized']");
                chromeOptions.addArguments("--start-fullscreen");
                chromeOptions.setBrowserVersion("101.0");
                chromeOptions.setPlatformName("Linux");
                chromeOptions.addArguments("--headless");
                /**
                 * RemoteWebDriver is used to execute the browser automation suite on a remote machine. home.local open the application
                 * on selenium grid 4
                 */
                System.out.println("------------------------------- Browser CHROME -------------------------------");
                setDriver(new RemoteWebDriver(new URL(configFileReader.getProperty("grid.selenium4")), chromeOptions));
                break;
            case "firefox":
                /**
                 * Starting a session with Firefox.
                 */
                FirefoxProfile profile = new FirefoxProfile();
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                firefoxOptions.addPreference("browser.download.folderList", 2);
                firefoxOptions.addPreference("browser.download.dir", configFileReader.getProperty("download.path"));
                firefoxOptions.addPreference("browser.download.useDownloadDir", true);
                firefoxOptions.addPreference("browser.download.viewableInternally.enabledTypes", "");
                firefoxOptions.addPreference("browser.download.manager.showWhenStarting", false);
                firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
                    "application/pdf;text/plain;application/text;text/xml;application/xml");
                firefoxOptions.addPreference("pdfjs.disabled", true);

                firefoxOptions.setCapability("platform", Platform.LINUX);
                firefoxOptions.setProfile(profile);
                /**
                 * RemoteWebDriver is used to execute the browser automation suite on a remote machine. home.local open the application
                 * on selenium grid 4
                 */
                System.out.println("-------------------------------Browser FIREFOX---------------------------------");
                setDriver(new RemoteWebDriver(new URL(configFileReader.getProperty("grid.selenium4")), firefoxOptions));
                getDriver().manage().window().maximize();
                break;
            case "edge":
                /**
                 * Starting a session with Edge.
                 */
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setBrowserVersion("101.0");
                edgeOptions.setPlatformName("Linux");
                edgeOptions.addArguments("--headless");
                /**
                 * RemoteWebDriver is used to execute the browser automation suite on a remote machine. home.local open the application
                 * on selenium grid 4
                 */
                System.out.println("-------------------------------Browser EDGE---------------------------------");
                setDriver(new RemoteWebDriver(new URL(configFileReader.getProperty("grid.selenium4")), edgeOptions));
                getDriver().manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void setDriver(WebDriver driver)
    {
        Setup.driver = driver;
    }
}
