Feature: Download Page

Scenario: Verification of Download Page Link
	Given User is on home Page of Selenium
	When user clicks on Download link
	Then title should be "Downloads | Selenium"