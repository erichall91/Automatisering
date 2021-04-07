Feature: Create account

@test1
Scenario Outline: Create account
Given I have entered "<email>" into the e-mail text field
And I have also entered "<username>" into the username text field
And I have also entered "<password>" into the password text field
When I press sign up
Then I continue to "<verify>" for verification
Examples:
|email|username|password|verify|
|email|workingusername|Jaghetereric123%|Check your email|
|email|longusername|Jaghetereric123%|Enter a value less than 100 characters long|
|email|username|Jaghetereric123%|Another user with this username already exists. Maybe it's your evil twin. Spooky.|
|     |workingusername|Jaghetereric123%|Please enter a value|