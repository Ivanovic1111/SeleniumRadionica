# BEHAVIOR DRIVEN DEVELOPMENT/TESTING  (JBEHAVE )  

# 1. Testing and testing types #
Software testing is a process, or a series of processes, designed to make sure computer code does what it was designed to do and that it does not do anything unintended.

Testing is the process of executing a program with the intent of finding errors.

There are many different classifications of testing.

## Functional and non-functional testing ##
1. Functional testing -  as this type of testing verifies the compliance of developed functions with requirements and specifications, other project documents and simply user's expectations.

2. Non-functional testing - is testing of a software application for its non-functional requirements: how a system operates. For example: security testing, performance testing...

## Manual and Automated testing ##
**Manual testing** requires that a tester performs manual test operations on the tester software in order to assure that software meet requirements.

While manual software testing is performed by a human, **automated testing** is performed by automation scripts/tests written by test automation developer using a test automation framework or testing tool.

Automated testing is typically used in functional testing but also in performance and security testing.

The best way to optimize testing effort and achieve the desired quality is to keep balance between automated and manual testing. 

TEST CASE is a set of steps (actions + expected results) under which a tester will determine whether an application is working correctly or not.

#### Advantages of Automated testing : ####
1. Reliable – automation test executes with the same precision every time
1. Reusable + Fast + Efficient – Action steps which are common for more tests are automated just once and reused from more tests, while manual tester has to perform these actions step by step in every mentioned test
1. It gives you the ability to run regressions on a code that is continuously changing
1. Helps performing compatibility testing – simultaneously test execution on different configurations
1. Can be run simultaneously different set of tests on different machines (with the same configuration) thus decreasing testing time
1. Long term costs are reduced, pays off late

#### Advantages of Manual testing : ####
1. If Test Cases have to be run a small number of times it's more likely to perform manual testing
1. It allows the tester to perform more ad-hoc (random testing)
1. It is an initial process of every software activities
1. Short term costs are reduced

#### Disadvantages of Automated testing : ####
1. It's more expensive to automate   
1. Initial investments are bigger than manual testing
1. You cannot automate everything, some tests still have to be done manually

#### Disadvantages of Manual testing : ####
1. Manual tests can be very time consuming
1. For every release you must rerun the same set of tests which can be tiresome

Test automation is a partial solution and not a complete solution.


# 2. Test Automation (TA tools, when and what to automate)  #

Not all tests can be automated so we need to decide what to automate and what to manually test. 

Candidates for automation:

- Tests that need to be run against every build/release of the application
- Tests that utilize the same workflow but different data for its inputs for each test run 
- Tests that take a long time to perform and may need to be run during breaks or overnight
- Tests that involve inputting large volumes of data
- Tests that need to run against multiple configurations — different OS & Browser combinations

No candidates for automation:

- Tests that you will only run one-time
- Test that need to run ASAP
- Tests that require ad hoc/random testing based on domain knowledge/expertise
- Tests without predictable results

**Test Management Tools:**

- to store testcases, to plan testing activities and report the status of testing
- to maintain and plan manual testing, run or gather execution data from automated tests, manage multiple environments and to enter information about found defects.

**Bug Tracking Tools** keeps track of reported software bugs in software development projects.

**Test Automation Tools/Framework** - FitNesse, TestComplete, QTP, JBehave, Cucumber, Telerik Test Studio...

JBehave is a framework for Behaviour Driven Development. 


# 3. Behaviour Driven Development #
Behavior Driven Development is an extension/revision of Test Driven Development. Both, BDD and TDD are software development metodologies:

**TDD = tests drive your software development   
BDD = behaviour and specification drive your software development**

## TDD Cycle ##
![](https://gitlab.levi9.com/qa/Code9-2015/raw/master/workshop1/img/TDD%20Cycle.png)

    1.	First the developer writes some tests.
    2.	The developer then runs those tests and (obviously) they fail because none of those features are actually implemented.
    3.	The developer implements unit tests in code.
    4.	If the developer writes his code well, then in the next stage he will see his tests pass.
        The developer can refactor code, clean it up, add new test units... 
        The cycle can just continue as long as the developer has more features to add.
        In the end, the implementation of the unit should make the tests succeed.

Unit tests are used as a means to express the business requirements. For developers who are writing these tests, there is always a chance of missing out something of business importance or misinterpreting a business requirements. The unit tests are good for many things (specially in refactoring phase) but they hardly make an attempt to bridge the gap between the business needs and the code development.

TDD demands a change in developers mindset, it requires that the developer thinks the business needs first.

Dan North suggested that instead of writing tests, the developer should think about behaviour. Behaviour is how the user wants the application to behave. He came out with idea of BDD.


## BDD Cycle ##

The idea of BDD is to provide a common tool and guideline to both, the business and development. This tool would allow the business analysts to write the business requirements using english-like language. They write scenarios around the requirements so the scenarios define the 'Behaviour' of the system. The developers implement these scenarios. The result is: business requirement translated into a working code.  

![](https://gitlab.levi9.com/qa/Code9-2015/raw/master/workshop1/img/BDD%20Cycle.png)

BDD cycle:
    
    1.	One of many scenarios which describes a feature 
    2.	Run the scenario and it fails because none of scenarios are implemented
    3.	Define the first step from the scenario. It fails because none of steps are implemented
    4.	Write down the application code getting the step to pass
    5.	Refactor the code and repeat steps 4 & 5 for each step until…
    6.	The scenario passes – go green
    7.	Continue refactoring the application code and move to the next feature

## TDD/BDD focus ##

- Developer's opinion on how parts of software should work (TDD)
- Users' opinion on how they want your application to behave (BDD)

'TEST' is replaced with word 'SPEC'. 
BDD allows the developers to focus on 'Does my code do what it's supposed to do?' in addition to 'Does my code work?'

## 4. Feature, Story, Scenario, Steps (Given-When-Then)  ##

FEATURE is described with USER STORIES. User Story is usually in the following format:

    As a [Role]
    I want [Feature]   
    So that I receive [Value]

SCENARIO describes how the user expects the system to behave using the steps in **GWT** format:

    Given [Precondition]
    When [Action]   
    Then [Outcome]   
It works like this:

- To specify a feature
- The feature contains a set of scenarios
- Each scenario consists of steps
- The steps are then executed

Example: 

    Story: Login
    
    As an user
    I want to login into the website
    So that I can view the exclusive contents

    Scenario: Invalid username
    
    Given the user is on the login page 
    When the user types username wrong!  
    And the user types password 123456  
    And clicks the login button 
    Then the page should display Invalid Authentication message


# 5. JBehave #

BDD frameworks:    
- JBehave http://jbehave.org/   
- Cucumber http://cukes.info/   
- JDave http://jdave.org/    
- Concordion http://www.concordion.org     
- Easyb http://easyb.org/     

**JBehave** is one of the largest frameworks for BDD written for Java. Writing tests process consists of writing stories, mapping them to Java, configuring them and finally – running and viewing reports. Configuration step is done only once. There are many ways of running stories.     

JBehave is a very flexible and expendable framework. It integrates with numbers of different programming languages (Groovy, JRuby, Java), technologies and frameworks. Stories are clear for business world and mapping files allows translating them into Java easily. Reporting functionality is really great.

**Pros/Cons:**   
+Highly configurable    
+Customizable report templates     
+Support for many languages and technologies   
+Excellent separation of story files from code   
-Configuration is a bit overwhelming   

JBehave
![](https://gitlab.levi9.com/qa/Code9-2015/raw/master/workshop1/img/jbehave.jpg)

    1.Write a story  
    2.Configure Embedded and story mapper - links stories, steps and reports together  
    3.Implements steps using the BDD cycle - annotations associate steps with methods   
    4.Run the story   
    5.View generated reports 

Selenium WebDriver accepts commands and sends them to a browser. This is implemented through a browser-specific browser driver, which sends commands to a browser, and retrieves results. Most browser drivers actually launch and access a browser application (such as Firefox or Internet Explorer); there is also an HtmlUnit browser driver, which simulates a browser using HtmlUnit.
## 6. JBehave annotations ##

**Story annotations**

JBehave supports the following method story annotations:

    @BeforeStory
    @AfterStory

The @BeforeStory and @AfterStory annotations allow the corresponding methods to be executed before and after each story, either a GivenStory or not.


**Story** related good practices:

- Stories may be dependent of each other. If so, they must declare their dependencies in a machine executable way. When writing a story, always assume that it will run against the system in a default, blank state.
- Stories should be repeatable, without having to clean up data manually before it can be repeated for instance.
- A story typically has somewhere between five and twenty scenarios, each describing different examples of how that feature should behave in different circumstances.
- Prioritize your stories using meta information so that only high priority stories can be executed if required.
- Categorize your stories by using meta information. A category could be a group of features or a subsystem for instance.

**Scenario annotations**

JBehave supports the following method scenario annotations:

    @BeforeScenario
    @AfterScenario

The @BeforeScenario and @AfterScenario annotations allow the corresponding methods to be executed before and after each scenario.

**Scenario** related good practices:

- Each scenario may be dependent by a previous scenario of the same story.
- Each scenario typically has somewhere between 5 and 15 steps (not considering step multiplication by example tables).
- A scenario should consist of steps of both types: action ("Given" or "When") and verification ("Then").
- Each scenario, including example table, should not take too much time to finish on a fast environment.


JBehave supports the following method **step annotations**:


    @Given -The purpose of givens is to put the system in a known state before the user (or external system) starts interacting with the system (in the When steps). 
    @When - The purpose of When steps is to describe the key action the user performs
    @Then -The purpose of Then steps is to observe outcomes. The observations should also be on some kind of output – that is something that comes out of the system (report, user interface, message)
    @Alias - if we want to express the same underlying step functionality in slightly different ways, or to support multiple syntaxes.
    @Aliases
    @Pending - The intention of the @Pending annotation is to tell JBehave that the step has yet to be implemented. It is then by conscious choice that the Steps developer should remove the annotation when the step has been implemented. 


**Steps** related good practices:

- Simple Steps (not composed ones) of type "Given" and "When" should not perform a verification and steps of type "Then" should not perform actions.
- Step names should not contain GUI information but be expressed in a client-neutral way wherever possible. Instead of "Then a popup window appears where a user can sign in" it would be better to use "Then the user can sign in". 
- Only use GUI words in step names if you intend to specifically test the GUI layer.
- Step names should not contain technical details but be written in business language terms.
- Avoid too detailed steps like "When user enters street name" if you don’t intend to test the UI interaction.
- Don't use step aliases for different languages. Instead choose just one language for all your stories.


## 7. Parameter Injection ##

JBehave supports multiple mechanisms for parameter injection.

Ordered Parameters

This is the default behaviour. The arguments extracted from the step candidate are simply matched following natural order to the parameters in the annotated Java method. For example:

`Given a stock of symbol STK1 and a threshold of 10.0`

Arguments "STK1" and "10.0" are matched to the first and second method parameters of the Java method:

`@Given("a stock of symbol $symbol and a threshold of $threshold")
public void aStock(String symbol, double threshold) {
    // ...
}`

Annotated Named Parameters

If we want to have named parameters, one mechanism is to use annotations:

`@Given("a stock of symbol $symbol and a threshold of $threshold")
public void aStock(@Named("symbol") String aSymbol, @Named("threshold") double aThreshold) {
    // ...
}`

## 8. Story reporting ##

At the heart of JBehave's reporting is the StoryReporter, to which events are reported as they occur.

Main formats that story reporter support:

    ConsoleOutput: a text-based console output
    TxtOutput: a text-based file output
    HtmlOutput: an HTML file output
    XmlOutput: an XML file output


## 9. JBehave and Behavior Driven Testing ##

BDT = testing perspective on BDD.  
JBehave framework can integrate with Selenium WebDriver using Page Object pattern in order to be able to interact with browser.

**Selenium WebDriver** aims to mimic the behaviour of a real user and as such interacts with HTML of an application.  
**Page Object Pattern** - to increase maintainability.

**Maven** - build tool. 

**TestNG**  is a testing framework designed to simplify a broad range of testing needs, from unit testing (testing a class in isolation of the others) to integration testing (testing an entire systems made of several classes, several packages and even several external frameworks, such as an application servers).


## 10. Exercise on JBehave scenarios: ##

1. Write Login story   
*Goal*: learn how to create a story using JBehave  
Notes: - New/JBehave/Story   
FoodOrders application: http://foodorderscode9.levi9.com  
credentials: code9fo/foodcode9     

        Scenario:  Successful login
  
        Given user is on Login page  
        When user types username and password   
        Then FoodOrders page opens  
        When user clicks Logs Off in Login scenario   
        Then user is logged off successfully from Login scenario    

2. Write Login successful scenario  
  *Goals:*
 - learn how to map steps to Java annotations   
 - learn how to execute story    
 - learn how to read report  

>      
>     @Given("user is on Login page") 
>     public void openLoginPage() { 
>     }
>     
>     @When("user types username and password")
>     public void typeCredentials() throws Exception {
>     }		}
>      
>     @Then("FoodOrders page opens")
>     public void openFoodOrdersPage() throws Exception {
>     }
>     	
>     @When ("user clicks Logs Off in Login scenario")
>     public void userLogOff(){
>     }
>     	
>     @Then ("user is logged off successfully from Login scenario")
>     public void verifyUserLoggedOff (){
>     }  

   
3. Write Unsuccessful Login scenario   
      
  
4. Write Unsuccessful Login scenario - more cases   
*Goal:* learn how to use Parametar

5. Write Restaurant story
6. Write Meal story