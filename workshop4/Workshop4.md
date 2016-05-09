###Basic concepts
- Running Tests via Selenium Grid
- Modern SW development

###Cross browser testing
Selenium supports cross browser testing. Cross browser testing is a type of functional test to check that application under test works as expected in different browsers.

![](http://i66.tinypic.com/2expi7b.png)

Using Selenium Web Driver we can automate test cases using all available browsers.

In order to achieve automatically execution tests on different browsers we are using **maven profiles**.

Task 1: Run your tests on Chrome or Firefox

Task 2: Setup Maven profile and running tests.

How to do it:

Change @BeforeMethod.

    @BeforeMethod
    @Parameters({"profile"})
    public void setUp(String profile) {
    super.setUp(profile);
    }

Add parameter in testng.xml file

    <parameter name="profile" value="${chrome.profile}" />

Run with tests with next command:

    mvn clean install

### Selenium Grid

Selenium-Grid allows you run your tests on different machines against different browsers in parallel.

![](http://image.slidesharecdn.com/seleniumcamp2015-andriisoldatenko-150301061521-conversion-gate01/95/seleniumcamp-2015-andrii-soldatenko-17-638.jpg?cb=1425190669)

Benefits:

- Test execution on different browsers and browser versions, operating systems, etc. in the same time
- Save time in execution

**Selenium Hub**

    java -jar selenium-server-standalone-ver.jar -role hub

**Selenium Node**

    java -jar selenium-server-standalone-ver.jar -role webdriver -hub http://servername:port/grid/register -port 5555 -Dwebdriver.chrome.driver=path\chromedriver.exe -Dwebdriver.ie.driver=path\IEDriverServer.exe

Task 3: Configure Selenium Grid on your machine.

How to do it:

1. Install Selenium hub using provided command
2. Register Selenium node using provided command
3. Check Selenium hub console (http://localhost:4444/grid/console)
4. Run tests on Selenium Grid (using selenium remote web driver)

`mvn clean install -Premote`

###Software Development Life Cycle

![](http://www.itsmonkie.co.uk/wp-content/uploads/2015/03/1.png)
 
###Version control software - Git

#todo

###Continuous Delivery – automated tests as part of the deployment pipeline.

#todo

**The benefits:**

- Often automatic deployments
- Fast feedback


###Jenkins

Jenkins is most popular continuous integration tool. It is highly extensible open source web based java tool.

####Where Jenkins fits in

Allow us to organize CI flow.

![](http://i66.tinypic.com/i4mo7p.png)

Prerequisites:

- Installed Java 1.5 or higher
- Java in path (optional but preferred)

Task 4: Install Jenkins, create job and execute tests via Jenkins

How to do it? 

###Team City

Commercial java based software for continuous integration. 

![](http://www.ranorex.com/blog/wp-content/uploads/2012/10/Integrate-In-TeamCity-2.png)

Task 5: Install TeamCity and create job.

Task 6: Trigger job in specific time (Jenkins or TeamCity)