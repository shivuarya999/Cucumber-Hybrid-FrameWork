Feature: Login function verifying

  Scenario Outline: Verify login function with valid credentials
    Given user navigate and lunch browser
    When user enter username <username> into username field
    And user enter password <password> into password field
    And user clicks on login button
    Then user sucessfull log in
    Examples:
    |username          |password|
    |shiva431@gmail.com|test1234|
    |shiva431@gmail.com|test1234|
    |shiva431@gmail.com|test1234|
  Scenario: Verify login function with invalid credentials
    Given user navigate and lunch browser
    When user enter invalid username "shiva@gmail.com" into username field
    And user enter password "test1234" into password field
    And user clicks on login button
    Then user verify warning meassage

  Scenario: Verify login function with invalid credentials
    Given user navigate and lunch browser
    When user enter username "shiva431@gmail.com" into username field
    And user enter invalidpassword "test12343" into password field
    And user clicks on login button
    Then user verify warning meassage
