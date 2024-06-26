Feature: Verifying Register Functionality

Scenario: Validation of new registration
Given user use given browser
When a user enters all required information
|FirstName   |shivappa |
|LastName    |somareddy|
|Telphone    |9876562314|
|Password    |Test1234|
|confirmPassword|Test1234|

And selects Privcy policy.
And click on continue button
Then the successful creation of an account



Scenario: Validation of new registration with existing details
Given user use given browser
When a user enters all required information with existing emailID
|FirstName   |shivappa |
|LastName    |somareddy|
|EmailId     |shiva@gmail.com|
|Telphone    |9876562314|
|Password    |Test1234|
|confirmPassword|Test1234|
And selects Privcy policy.
And click on continue button
Then verify waring message displayed