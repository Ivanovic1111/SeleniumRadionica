# Jenkins #

**- Install Jenkins as a Windows service**

    java -jar jenkins.war

**- Check is it working http://localhost:8080/**


![](img\ManageJenkins.png)


**- Go to View Local Services and check if Jenkins is running**

**- Create new job "FoodOrders"**




1. Set root and goals

    `-s "${WORKSPACE}/settings.xml" clean install -Premote`

2. Add parameters

**- Schedule job to run every day at 21:13 pm**

    13 21 * * *


zadatak ranovati chrome i ff paralelno

ubaciti za remote profile u pom file