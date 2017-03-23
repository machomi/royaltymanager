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