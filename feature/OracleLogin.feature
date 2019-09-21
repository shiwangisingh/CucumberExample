
Feature: Oracle Login

  Scenario Outline: To Check Login Functionality with valid Username and Valid Passowrd.
    Given Chrome is Opened & Login Page is displayed
    When User enters <username> & <password>
    And Click on Login button
    Then Home Page Should Display
    And Click on Logout button
    
    Examples:
    |username|password|
    |demo|demo|
    |hello|hello|
    |hr|hr|
    |xyz|xyz|