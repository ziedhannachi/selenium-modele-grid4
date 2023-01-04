#language:fr

#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Fonctionnalité: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scénario: Title of your scenario
    Etant donné I want to write a step with precondition
    Et some other precondition
    Quand I complete action
    Et some other action
    Et yet another action
    Alors I validate the outcomes
    Et check more outcomes

  @tag2
  Plan du scénario: Title of your scenario outline
    Etant donné I want to write a step with <name>
    Quand I check for the <value> in step
    Alors I verify the <status> in step

    Exemples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
