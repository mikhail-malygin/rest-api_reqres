# rest-api_reqresIn
> <a target="_blank" href="https://miro.com/">Link to reqresIn api web page</a>

![This is an image](images/picture/reqresIn.jpg)

## :page_with_curl: Table of contents:
- [Technology stack](#computer-technology-stack)
- [Test cases](#bookmark_tabs-test-cases)
- [Deployment in Jenkins](#-deployment-in-Jenkins)
- [Running tests using terminal](#desktop_computer-running-tests-using-terminal)
- [Allure reports](#-allure-reports)
- [Allure TestOps integration](#-allure-TestOps-integration)
- [Jira integration](#-jira-integration)
- [Notification in telegram](#-notification-in-telegram)

## :computer: Technology stack
<p align="center">
<a href="https://www.java.com/"><img src="images/logo/java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://gradle.org/"><img src="images/logo/gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://rest-assured.io/"><img src="images/logo/restAssured.svg" width="50" height="50"  alt="Rest-assured"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/allureReport.svg" width="50" height="50"  alt="Allure Reports"/></a>
<a href="https://qameta.io/"><img src="images/logo/allureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a href="https://www.atlassian.com/software/jira"><img src="images/logo/jira.svg" width="50" height="50"  alt="Jira"/></a>
<a href="https://telegram.org/"><img src="images/logo/telegram.svg" width="50" height="50"  alt="Telegram"/></a>
</p>

## :bookmark_tabs: Test cases
- :heavy_check_mark: Getting a user list test
- :heavy_check_mark: Creation a new user test
- :heavy_check_mark: Updating user data test
- :heavy_check_mark: Registration a known user test
- :heavy_check_mark: Registration an unknown user test

## <img width="4%" title="Jenkins" src="images/logo/jenkins.svg"> Deployment in Jenkins
> <a target="_blank" href="https://jenkins.autotests.cloud/job/13-malyginms-unit24_rest-api_diplom/">Build in Jenkins</a>

![This is an image](images/picture/build_jenkins.jpg)

## :desktop_computer: Running tests using terminal

#### Command for local run:
```bash
gradle clean test
```

#### Command for remote run:
```bash
clean reqres_tests
-DselenoidStand=${SELENOID_STAND}
```

## <img width="4%" title="Allure" src="images/logo/allureReport.svg"> Allure reports
> <a target="_blank" href="https://jenkins.autotests.cloud/job/13-malyginms-unit24_rest-api_diplom/allure/">Link to Allure reports</a>

![This is an image](images/picture/allure_reports_jenkins.jpg)

#### Overview dashboard

<p align="center">
<img title="Allure Overview Dashboard" src="images/picture/allure_reports_overview.jpg">
</p>

#### Suites dashboard
You can find detailed description of tests and attachments(screenshots, request, response) which will be useful for debugging, test documentations, etc

<p align="center">
<img title="Allure Suites Dashboard" src="images/picture/allure_reports_suits.jpg">
</p>

#### Graphs dashboard

<p align="center">
<img title="Allure Suites Dashboard" src="images/picture/allure_reports_graphs.jpg">
</p>

## <img width="4%" title="AllureTestOps" src="images/logo/allureTestOps.svg"> Allure TestOps integration
> <a target="_blank" href="https://allure.autotests.cloud/launch/16392">Link to Allure TestOps</a>

![This is an image](images/picture/allure_testops_jenkins.jpg)

#### Launches dashboard

<p align="center">
<img title="Allure TestOps Launches Dashboard" src="images/picture/allure_testops_launches.jpg">
</p>

#### Test cases dashboard

<p align="center">
<img title="Allure TestOps Test Cases Dashboard" src="images/picture/allure_testops_testcases.jpg">
</p>

## <img width="4%" title="Jira" src="images/logo/jira.svg"> Jira integration
> <a target="_blank" href="https://jira.autotests.cloud/browse/AUTO-1416">Link to Jira task</a>

![This is an image](images/picture/jira_task.jpg)

## <img width="4%" title="Telegram" src="images/logo/telegram.svg"> Notification in telegram

![This is an image](images/picture/telegram_notifications.jpg)