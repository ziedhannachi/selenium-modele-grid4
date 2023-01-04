/*
 * Copyright (c) 2022 DGFiP - Tous droits réservés
 */
package fr.gouv.finances.oda.automatedTests.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class is used to perform various kinds of validations in the test cases.
 */
public class Validations extends BasePage
{
   
   /** testCaseStatus the status of the test case. */
    boolean testCaseStatus = true;

    /** test status. */
    boolean testStatus;

    /** test screenshot dir. */
    private String testScreenshotDir;
    
    private WebDriver driver;

    /**
     * Instanciation de assertions.
     */
    public Validations()
    {
        super();
        this.driver = Setup.getDriver();
    }

    /**
     * method verify whether element is present on screen.
     *
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     */
    public Boolean isElementPresent(By targetElement)
    {
        return Setup.getDriver().findElements(targetElement).size() > 0;
    }

    /**
     * methode Checks if is element displayed.
     *
     * @param element element web
     * @return boolean
     */
    public Boolean isElementDisplayed(WebElement element)
    {
        return element.isDisplayed();
    }
    
    /**
     * methode Checks if is element selected
     *
     * @param element
     * @return boolean
     */
    public Boolean isElementSelected(WebElement element)
    {
        return element.isSelected();
    }

    /**
     * method verify whether element is not present on screen.
     *
     * @param targetElement element not to be present
     * @return true if element is not present else throws exception
     */
    public Boolean isElementNotPresent(By targetElement)
    {
        return Setup.getDriver().findElements(targetElement).size() == 0;
    }

    /**
     * method to take screenshot.
     *
     * @return path where screenshot has been saved
     */
    public String screenShot()
    {
        String screenshotPath = "screenshot" + new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss", Locale.FRANCE)
            .format(new GregorianCalendar().getTime())
            + ".png";

        log.info(screenshotPath);
        File scrFile = ((TakesScreenshot) driver)
            .getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(scrFile, new File(testScreenshotDir + screenshotPath));
        }
        catch (IOException e)
        {
            log.info("Exception: ", e);
            screenshotPath = "";
        }
        return screenshotPath;
    }
    
    /**
     * methode Verif PDF text file.
     *
     * @param text
     * @param pdfPath
     * @return true, si c'est vrai
     * @throws IOException Signal qu'une execption de type I/O s'est produite.
     */
    public boolean verifyTextInFile(String text, String pdfPath) throws IOException
    {

        boolean exist = false;
        File file = new File(pdfPath);
        FileInputStream fis = new FileInputStream(file);
        PDFParser parser = new PDFParser(fis);

        parser.parse();

        COSDocument cosDoc = parser.getDocument();
        PDDocument pdDoc = new PDDocument(cosDoc);
        PDFTextStripper strip = new PDFTextStripper();
        String data = strip.getText(pdDoc);

        exist = data.contains(text);

        cosDoc.close();
        pdDoc.close();

        log.info("Text Found on the pdf File...");
        return exist;

    }
    
    /**
     * methode Column contains value.
     *
     * @param pathToFile
     * @param columnIndex
     * @param targetValue
     * @return true, si c'est vrai
     * @throws IOException Signal qu'une execption de type I/O s'est produite.
     */
    public boolean columnContainsValue(String pathToFile, int columnIndex, String targetValue) throws IOException
    {

        Reader in = new FileReader(pathToFile);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

        for (CSVRecord record : records)
        {
            String rowValue = record.get(columnIndex);
            if (targetValue.equals(rowValue))
                return true;
        }
        return false;
    }

}
