#Sample API test scenario
Feature: Swagger Feature
  @SmokeTest
  Scenario: Verify response status code for Sample API
    Given Uri should be ready
    When Send a sample get request
    Then Http status code should be "200"