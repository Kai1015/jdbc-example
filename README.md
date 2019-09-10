

*****************************************
*************  Requirements *************
*****************************************

	- Java 8
	- Postman
	- docker-compose 
        - If Windows:
            - Docker Quickstart Terminal https://docs.docker.com/toolbox/toolbox_install_windows/#targetText=To%20run%20Docker%2C%20your%20machine,is%20enabled%20on%20your%20machine.
        - If Linux:
            - Install docker-compose https://docs.docker.com/compose/install/
        - If MacOS:
            - docker-compose comes with the Docker install on MacOS


*****************************************
**********  To Develop Locally **********
*****************************************

1. Check if you have docker compose by running "docker-compose --version" in your terminal
    An example of a returned message looks like "docker-compose version 1.23.2, build 1110ad01"

2. Make sure Java is defined in your PATH. Entering "java -version" in your command line should return a result similar to "java version "1.8.0_221""

3. Go to the root directory of the project, where docker-compose.yml exists, and run "docker-compose up". This will start the MySQL server that
	the Hibernate application will be connecting to.

4. In a different terminal, go to the hibernate directory of the project, and run "mvn clean test spring-boot:run". This will start the Java server to begin
	local development with live reload. 

5. To determine if you are successfully able to get a response, open Postman and put "http://localhost:8080/api/students" in the URL, and select "GET" as
	your request type. The response should return "[]" with a 200 status on your initial connection to the database.

6. Change "GET" to "POST", and send a request body like the one below. Remember, this JSON body is defined based on the annotations in your model (no fields are
	explicitly required in this case). This should yield a 201 response, along with the body that was sent.

		{
			"firstName": "Jane",
			"lastName": "Doe",
			"email": "jd@gmail.com",
			"gpa": 3.95
		}

7. Change "POST" back to "GET", and you should now be receiving the Jane Doe object in your response.

8. Now add in the functionality for UPDATE, GET by ID, and DELETE by ID, and test results using Docker. Don't forget to test your code.


*****************************************
***********  Potential Errors ***********
*****************************************

	IF THE DATABASE ISN'T MAKING A CONNECTION, YOU MUST UPDATE "src/main/resources/application.properties" FILE WITH CORRECT SERVER IP
		LINUX: 
			jdbc:mysql://localhost:3306/STUDENT
		
		WINDOWS PROFESSIONAL and USING DOCKER CLI IN WINDOWS TERMINAL:
			jdbc:mysql://localhost:3306/STUDENT

		WINDOWS HOME and/or USING DOCKER TERMINAL QUICKSTART:
			- run following command in console:
				$ docker-machine ip
			- spring.datasource.url would be similar to:
				jdbc:mysql://192.168.99.100:3306/STUDENT
			



*****************************************
***********  Helpful Commands ***********
*****************************************

	$ docker-machine ip
		Used to configure the database ip in application.properties 
	
	$ docker-compose up 
		Used to run the docker-compose cluster (spins up all applications in docker-compose.yml) 
	
	$ docker-compose down -v 
		Used to shut down the docker-compose cluster and remove volumes
		
	$ docker system prune --all
		Removes all data docker stores on your machine (good to maintain storage)
		
	$ mvn clean test spring-boot:run
		Used to run the Spring application

    $ docker exec -it java_persistence_hibernate_1 /bin/sh
        Used to ssh into the server machine and view the filesystem


