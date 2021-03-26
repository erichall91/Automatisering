Feature: Create account

@test1
Scenario Outline: Create account - everything goes as expected
Given I have entered <email> + randomInt + <gmail> into the e-mail text field
And I have also entered <username> + randomInt into the username text field
And I have also entered <password> into the password text field
When I press sign up
Then I continue to <verify> for verification
Examples:
|email|gmail|username|password|verify|
|email|gmail|Jaghetereric|Jaghetereric123|check your email|