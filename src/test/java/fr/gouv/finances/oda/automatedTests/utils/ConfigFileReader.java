/*
 * Copyright (c) 2022 DGFiP - Tous droits réservés
 */
package fr.gouv.finances.oda.automatedTests.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader extends BasePage
{

    /** properties. */
    private Properties properties;

    /** property file path. */
    private final String propertyFilePath = "src/test/resources/configs/Config.properties";

    /**
     * Instanciation de config file reader.
     */
    public ConfigFileReader()
    {
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try
            {
                properties.load(reader);
                reader.close();
            }
            catch (IOException e)
            {
                log.info("Exception: ", e);
            }
        }
        catch (FileNotFoundException e)
        {
            log.info("Exception: ", e);
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
        finally
        {
            // this block will be executed in every case, success or caught exception
            if (reader != null)
            {
                // again, a resource is involved, so try-catch another time
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    log.info("Exception: ", e);
                }
            }
        }
    }

    /**
     * Accesseur de l attribut driver path. 
     * @return driver path
     */
    public String getDriverPath()
    {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null)
            return driverPath;
        else
            throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }
    
    /**
     * Accesseur de l attribut property.
     *
     * @param property DOCUMENTEZ_MOI
     * @return property
     */
    public String getProperty(String property)
    {
        String prop = properties.getProperty(property);
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("prop not specified in the Configuration.properties file.");
    }

}