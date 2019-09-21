Feature: Oracle Login

  Scenario: To Check Login Functionality with valid Username and Valid Passowrd.
    Given Chrome is Opened & Login Page is displayed
    When User enters "sys" & "Newuser123"
    And Click on Login button
    Then Home Page Should Display
    And Click on Administration link
    And Click on Database Users link
    And Click on Create user button
    When User enters following details 
   |Username|password|confirmPassword|
   |hello|hello|hello|
    And Click on Create button
    Then User Created Should Display