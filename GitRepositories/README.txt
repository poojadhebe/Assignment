In order to run this application, you have to follow following steps on cmd.
Steps:
1) Go to project directory and run foll command
mvn clean install -U
2) Next command to be executed is 
java -jar target/gs-rest-service-0.1.0.jar
3) Go to browser and write 
http://localhost:8080/projects?name=poojadhebe&owned=true

Note:The name attribute denotes the username of whom you want to view the projects. The owned attribute is optional.


Prerequisites:
1. JDK 1.8
2. Maven 3.6.1
