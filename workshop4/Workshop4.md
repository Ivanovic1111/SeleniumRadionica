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

There are two types of version control systems

![](https://homes.cs.washington.edu/~mernst/advice/version-control-fig2.png)

![](https://homes.cs.washington.edu/~mernst/advice/version-control-fig3.png)


**Advantages** over centralized systems:

- Performing actions other than pushing and pulling changesets is extremely fast because the tool only needs to access the hard drive, not a remote server.
- Committing new changesets can be done locally without anyone else seeing them. Once when a group of changesets is ready, it can pushed (all of them) at once.
- Everything but pushing and pulling can be done without an internet connection. 
- Since each programmer has a full copy of the project repository, they can share changes with one or two other people at a time if they want to get some feedback before showing the changes to everyone.

**Disadvantages** over centralized systems::

- If project contains many large files that cannot be easily compressed, the space needed to store all versions of these files can accumulate quickly.
- If project has a very long history, downloading the entire history can take an impractical amount of time and disk space.

**Git** is one of the most popular distributed version control systems. These systems do not necessarily rely on a central server to store all the versions of a project’s files. Instead, developers clone a copy of a repository and has the full history of the project on their own hard drive.


![](https://git-scm.com/images/about/index1@2x.png)

How to do it:
update

1. Create own repository on gitlab 
2. Push new code
3. Add new files, edit existing (work in pair)

###Continuous Delivery – automated tests as part of the deployment pipeline:

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