Feature: Log into account with correct and incorrect credentials
	User should be able to login to account using correct credentials
	User should not be able to login to account with incorrect credentials

	Background:
	Given A User navigates to webdriveruniversity website
#	And A User clicks on the login button on homepage

Scenario: Login into account with correct credentials
	And User enters a "webdriver" username
	And User enters a "webdriver123" password
	When A User clicks on the login button
	Then A User should be taken to the successful login page

Scenario: Login into account with incorrect credentials
	And User enters a "invalid" username
	And User enters a "invalid" password
	When A User clicks on the login button
	Then A User should be taken to the unsuccessful login page

	#Parametryzacja