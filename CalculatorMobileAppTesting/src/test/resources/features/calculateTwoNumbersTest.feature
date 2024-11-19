Feature: Two Numbers Calculation Test

Scenario: calculation using 2 numbers

Given the user is on Calculator home page
When the user select first number "<FirstNumber>" and operator "<Operator>" and second number "<SecondNumber>"
And the user clicks on equals button
Then the user should see the calculation result

Examples:
|FirstNumber|Operator|SecondNumber|
|1|add|2|
|5|sub|3|
|6|mul|2|
|8|div|4|


