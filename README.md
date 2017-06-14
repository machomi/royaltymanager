# Royalty Manager

*Challange description:*

Implement a system to record and calculate royalty payments owed to Rights Owners based on viewing activity of customers. Royalties will be calculated at the Rights Owner level, so each episode belonging to a specific Rights Owner will be worth the same amount. The system must meet the provided REST API specification and accept/return JSON.
Customer viewings will be tracked by a POST to the VIEWING endpoint. The system is not concerned about whether a given customer ID is valid, it assumes the consuming system is sending a valid customer ID. The episode ID must be valid and exist in the system for the viewing to be tracked.
Royalties owed will be listed by a GET to the PAYMENTS endpoint. This will return a list of the royalty payments owed to the studios in GBP£. 
Royalties owed to a specific Rights Owner will be returned by a GET to the PAYMENTS/{Rights Owner GUID} endpoint. This will return a single object representing the royalty payment owed to the studio in GBP£.
The Reset endpoint will reset the internal state of the system (setting everything back to 0).
Source information for Episodes and Rights Owners are in the JSON files provided.

## Starting application

To start your application in the deafult profile, simply run:

    ./gradlew
    
Gradlew command compiles source and starts default task which is *bootRun*.    
    
## Swagger UI

There is a swagger ui included. Please go to http://localhost:8080/swagger-ui.html to play with api from nice GUI.

## Packaging app into jar

In order to build complete jar package use command:

	./gradlew clean build
	
You will find result in *build/libs* folder.

To start app from jar file you can simply run:

	java -jar build/libs/royaltymanager-0.0.1-SNAPSHOT.jar	

## Docker
 
 Building docker image:
 
 	./gradlew dockerBuild

Run from docker container:

	docker run -p 8080:8080 royaltymanager

You can send docker to background adding option -d (daemon) at the end of prevoius command.

Once your container started you can access api through http://localhost:8080