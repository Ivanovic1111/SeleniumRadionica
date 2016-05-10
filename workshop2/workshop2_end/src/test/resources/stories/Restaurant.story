Restaurant story

Narrative:
In order to use FoodOrders site
As a user
I want to add/change restaurant
So that I have the restaurant in the list
					 
Scenario:  Add a new restaurant
Given user is logged into application for Restaurant story
And user is on Restaurant page
When user populates new restaurant details
Then restaurant is in the list
When user clicks Logs Off in Restaurant scenario
Then user is logged off successfully from Restaurant scenario

Scenario:  Edit the restaurant
Given user is logged into application for Restaurant story
And user is on Restaurant page
When user populates new restaurant details
Then restaurant is in the list
When user selects created restaurant
And user modifies the restaurant details
Then restaurant details are changed
When user clicks Logs Off in Restaurant scenario
Then user is logged off successfully from Restaurant scenario

Scenario:  Add a new restaurant check name is mandatory
Given user is logged into application for Restaurant story
And user is on Restaurant page
When user populates all new restaurant details except name field
Then the name field is required message is displayed
When user clicks Logs Off in Restaurant scenario
Then user is logged off successfully from Restaurant scenario

Scenario:  Add a new restaurant phone number is mandatory
Given user is logged into application for Restaurant story
And user is on Restaurant page
When user populates all new restaurant details except phone number field
Then the phone number field is required message is displayed
When user clicks Logs Off in Restaurant scenario
Then user is logged off successfully from Restaurant scenario
