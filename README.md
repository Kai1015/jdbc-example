
# Requirements for the lab #

	- Java 8 or higher
	- Postman
	- EITHER
		- docker
			- https://docs.docker.com/install/
	- OR
		- docker-compose 
			- If Windows:
				- Docker Quickstart Terminal https://docs.docker.com/toolbox/toolbox_install_windows/#targetText=To%20run%20Docker%2C%20your%20machine,is%20enabled%20on%20your%20machine.
			- If Linux:
				- Install docker-compose https://docs.docker.com/compose/install/
			- If MacOS:
				- docker-compose comes with the Docker install on MacOS


# To live reload app on local machine with Docker #

1. Make sure you have requirements; running the following commands should return a version message for the required packages:
	- `docker --version` 
	- `java -version` 
	- Open Postman

2. Pull the MySQL 5.7 docker image from dockerhub `docker pull mysql:5.7`. This allows you to build a MySQL container on your machine.
	- You can see your docker images by typing `docker image ls`
	- If you receive a *permission denied* message, try using `sudo docker pull mysql:5.7` and `sudo docker image ls`

3. Run a MySQL container using `docker run --name mysql-server --restart unless-stopped -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=STUDENT -p 3306:3306 -d mysql:5.7`
	- This creates and runs a docker instance named mysql-sever. '-e' is an environment variable that configures database named STUDENT, and assigns a password.
	- You can connect to this database using SQL Server, Toad, or pulling Adminer from dockerhub and running an Adminer instance.
	- Make sure the docker instance is running by executing `docker ps`. This displays all servers that are running.

4. Navigate to the project directory **jdbc-example/hibernate** and run `mvn clean test spring-boot:run`. 
	- **Check to make sure your application.properties file is using the username "root" and the pass "pass". Otherwise the database will not connect.**

5. You should be able to successfully get a response. Open Postman and put "http://localhost:8080/api/students" in the URL, and select "GET" as
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



# To live reload app on local machine with docker-compose #

1. Check if you have docker compose by running `docker-compose --version` in your terminal
    An example of a returned message looks like `docker-compose version 1.23.2, build 1110ad01`

2. Make sure Java is defined in your PATH. Entering "java -version" in your command line should return a result similar to "java version "1.8.0_221""

3. Go to the root directory of the project, where docker-compose.yml exists, and run `docker-compose up`. This will start the MySQL server that
	the Hibernate application will be connecting to.
	- Sometimes an error occurs related to the version in the docker-compose.yml, however the error message should contain a compatible version. Change the version to the latest version you see in the error message. This can be replicated by changing your version to a random number.

4. In a different terminal, go to the hibernate directory of the project, and run `mvn clean test spring-boot:run`. This will start the Java server to begin local development with live reload. 
	- **Check to make sure your application.properties file is using the username "user" and the pass "pass". Otherwise the database will not connect.**

5. You should be able to successfully get a response., open Postman and put "http://localhost:8080/api/students" in the URL, and select "GET" as
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



# Potential Errors #

- If the database isn't making a connection, you must update "src/main/resources/application.properties" file with the correct server ip

		Possible server addresses:
			jdbc:mysql://localhost:3306/STUDENT
			jdbc:mysql://0.0.0.0:3306/STUDENT

		WINDOWS HOME and/or USING DOCKER TERMINAL QUICKSTART:
			- run following command in console:
				$ docker-machine ip
			- spring.datasource.url would be similar to:
				jdbc:mysql://192.168.99.100:3306/STUDENT
		


# Helpful Commands #

	$ docker-machine ip
		Used to configure the database ip in application.properties 
	
	$ docker-compose up 
		Used to run the docker-compose cluster (spins up all applications in docker-compose.yml) 
	
	$ docker-compose down -v 
		Used to shut down the docker-compose cluster and remove volumes
		
	$ docker system prune --all
		Removes all data docker stores on your machine (good to maintain storage)
		
	$ mvn clean test spring-boot:run
		Used to run the Spring application. Cleans previously existing source and property files for a fresh project. Test then runs a mock application context to test against. spring-boot:run packages the application into an archive and runs the file on a Tomcat server.

    $ docker exec -it java_persistence_hibernate_1 /bin/sh
        Used to ssh into the server machine and view the filesystem


