# **This repo contains tests for UI and API**
### UI website :  http://www.uitestingplayground.com/  
### API swagger : https://petstore.swagger.io/
 
 
My test approach : is experience based for both UI and API.
 
## **UI test cases** :
 
### **Test case 1** : check if all the links in home page are working.
 
**Priority** : very High
 
**description** : this test case gets all the links in the home page and checks if there are broken links.
This is done by using java.net lib and making HEAD HTTP requests to each link and getting the status code.
if the status of any link is not 200 the function returns a string with all the broken links instead of the ok message.
 
### **Test case 2** : check dynamicID test
 
**Priority** :  High
 
**description** : This test case tests the dynamic ID exercise which is the first link on the exercise list.
The first exercise has to be fully functional as it may be the easiest and first exercise the user may try.
 
### **Test case 3** : check dynamic Table test
 
**Priority** :  medium
 
**description** : This test case tests the dynamic Table exercise a random exercise from the exercise list as a type of
smoke testing for the exercise list.
 
 
## **API test cases** :
 
petshop website first launch can be only a static homepage and list of pets in the shop.
The list is made by first using POST /pet endpoints and GET /store/inventory endpoints.
 
 
### **Test case 1** : create an item /pet endpoint.
 
**Priority** :  High
 
**description** : check if the HTTP POST method is working as it can be used to fill the DB before the GUI is ready.
 
### **Test case 2** : get inventory /store/inventory endpoint.
 
**Priority** :  High
 
**description** : check if the HTTP GET method for /store/inventory is working as expected.
the assertion is that get does not return an empty list. as we created an pet using /pet before calling get /store/inventory
 
 
### **Test case 3** : login GET /user/login.
 
**Priority** :  medium
 
**description** : check if the HTTP get /user/login is working fine and assert that assert that body contains a logged-in user.
 
 
## **RUN and CI/CD** :
 
## **Locally :**
 
**prerequisite**
1. JAVA jdk 11 or above installed in the system
2. Maven 3.8.0 or above installed in the system (used maven 3.8.6)
3. optional intellij ID
 
**Run from command line**
1. navigate to project directory
2. open cmd in the project directory
3. write **mvn test** and press enter
 
**Run from intellij ID**
1. open project in intellij ID
2. run testng.xml file
 
 
## **CI/CD :**
 
I used jenkins on an AWS EC2 instance
 
 
1. navigate to the  [Jenkins](http://ec2-52-87-171-224.compute-1.amazonaws.com:8080/)
2. user the test credentials to login :
username :  testuser
password :  abc123
3. run by pressing run button on TechnicalAssignment project
 
 
## **Calliope:**
 
I used Calliopes TestNG POST API to update the test report after the testsuite run.
 
Report LINK : [Calliope](https://app.calliope.pro/profiles/4528/reports)
 
### *Calliopes Improvement*
1. when uploading an testNG.xml  test suite with more than one class the report shows only the first class.
 
### *Calliopes new feature*
1. ready made scripts for java selenuim and restassured in the decumentaions section.
 
 
 
## *TODO*
1. add more helper class to cover timeout and wait for selenuim.
2. Improve jenkins reporting and layout.
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
