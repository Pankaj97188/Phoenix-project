#Author: Ali
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
@api @e2e @sanity
Feature: Create Job API Feature
  			I want to create an inwarranty job using the Create Job API

  Scenario: Inwarranty Job Creation
    Given the base url of the application is "http://139.59.91.96:9000/v1"
    And the Header of for the request is
      | Key           | Value            |
      | Content-Type  | application/json |
      | Authorization | randomToken      |
    And the request body is
      | CustomerName | CustomerLastName | IMEI         | ProductName | ModelNumber | DOP       |
      | Ali          | Ehab             | 132433435455 | Google      | Nexus2      | 13/1/2024 |
      
    When I make a post request to the endpoint "createjob"
    Then job number needs to created
    And job number should be int
    And customerid should created
    And customerid should be int
    And status code should be 200
