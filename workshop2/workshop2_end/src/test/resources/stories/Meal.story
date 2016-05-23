Meal story

Narrative:
In order to use Foodorders site
As a user
I want to add/change meal
So that I have the meal in the menu
					 
Scenario:  Add a new active meal
Given user is logged into application for Meal scenario
And user is on Meal page
When user populates new active meal
Then active meal is added to the list
When user clicks Logs Off in Meal scenario
Then user is logged off successfully from Meal scenario

Scenario:  Add a new meal validate price
Given user is logged into application for Meal scenario
And user is on Meal page
When user populates all fields and for price types invalid value
Then the field price must be a number message is displayed
When user clicks Logs Off in Meal scenario
Then user is logged off successfully from Meal scenario