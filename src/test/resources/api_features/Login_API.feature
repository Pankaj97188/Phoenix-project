#Author: Bharat@gmail.com
#Keywords Summary : Login API Feature, Sanity , Smoke, e2e
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
@sanity @e2e @smoke @api
Feature: Verify Login API Feature for the User
 		As a user of Phoenix Application if I provide valid credentials to the login api token should be generated

  Scenario: Valid Creds for Login API
    Given the baseurl of the backend app is "http://139.59.91.96:9000/v1"
    And the header passed is "content-type"  "application/json"
    And the user credentials are "iamfd" "password"
    When I make a POST api request to the endpoint "login"
    Then the status code needs to be 200
    And the response time should be less 1500 ms
    And the response body should contain message as "Success"
    And a token should be generated
    And the response body should be a json body

