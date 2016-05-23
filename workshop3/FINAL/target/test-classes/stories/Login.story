Login story

Narrative:
In order to use FoodOrders site
As a user
I want to login into Foodorders site
So that I can order food

Scenario:  Successful login
Given user is on Login page
When user types username and password
Then FoodOrders page opens
When user clicks Logs Off in Login scenario
Then user is logged off successfully from Login scenario

Scenario:  Unsuccessful login
Given user is on Login page
When user types empty credentials
Then user cannot order food

Scenario: Unsuccessful login - more cases
Given user is on Login page
When user populates <username> and <password>
Then user cannot order food

Examples:
|username|password|
|code9fo||
||foodcode9|
