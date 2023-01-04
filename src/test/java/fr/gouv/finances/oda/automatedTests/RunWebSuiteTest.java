/*
 * Copyright (c) 2022 DGFiP - Tous droits réservés
 * 
 */
/**
 * @author Zied-Hannachi
 * Date: 26 avr. 2022
 */
package fr.gouv.finances.oda.automatedTests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

/**
 * The Test Runner File uses the @RunWith() Annotation from JUnit for executing tests.
 */
@RunWith(Cucumber.class)

/**
 * The @CucumberOptions Annotation is used to define the location of feature files, step definitions, reporting
 * integration.
 */
@CucumberOptions(features = {"src/spec/features"}, 
plugin = {"pretty", "html:target/cucumber-report.html"}, 
monochrome = true, 
snippets = CAMELCASE, 
tags = (""), 
stepNotifications = true)

/**
 * This class is used to run the test, which is a JUnit Test Runner Class containing the Step Definition location and
 * the other primary metadata required to run the test.
 */
public class RunWebSuiteTest
{
}