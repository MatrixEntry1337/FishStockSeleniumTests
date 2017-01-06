#feature file - user can login
Feature: login
  As a user
  I can login
  So that I can look at my data

  Scenario Outline: login with correct login and password combinations
    Given I am on the main page
    And login and password fields exist
    And login button exists
    When I input "<correctlogin>" and "<correctpassword>"
    And and click the login button
    Then I gain access to the main page

    Examples: 
      | correctlogin   | correctpassword |
      | thanks         | thanks          |
      | jfisher        | jfisher         |

      
  Scenario Outline: login with incorrect login and/or password combinations
    Given I am on the main page
    And login and password fields exist
    And login button exists
    When I input "<wronglogin>" and/or "<wrongpassword>" 
    And click the login button
    Then I get an error message

    Examples: 
      | wronglogin      | wrongpassword   |
      | thanks          | thanksss        |
      | jfisherrsz      | jfisher         |
      | kuku            | kuku            |