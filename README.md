# TECH
CRUD, New Springboot with springinitializer, Basic Spring Authentication, JPA, H2


## Gradle Install
brew install gradle

## Gradle Build
./gradlew bootRun

## Maven Build
./mvnw clean install <br/>
./mvnw package && java -jar target/spring-todo-app.jar ./mvnw clean install

# run maven and start in host os default port 8080
./mvnw spring-boot:run

## Test Server status
http://localhost:8080/outlaws/test

## Postman : POST (To Save)
URL - http://localhost:8080/outlaws/ideas
```

{
  "ideaSummary": "Summary-3",
  "ideaDescription": "Desc-3"
}
```

curl -X POST -H "Content-Type: application/json" -d "{\"ideaSummary\":\"XBox 360\",\"ideaDescription\":"299.99"}" http://localhost:8080/outlaws/ideas


## Postman : GET 
http://localhost:8080/outlaws/ideas/

## Postman : GET BY ID
http://localhost:8080/outlaws/ideas/2

## Postman : PUT (To Update given primary key)
URL - http://localhost:8080/outlaws/ideas/1
```

{
  "ideaSummary": "Summary-333333",
  "ideaDescription": "Desc-333333"
}
```

## Postman : DELETE (delete the given Primary key record)
http://localhost:8080/outlaws/ideas/2




## CREATE MAVEN DOCKER IMAGE
docker build -t springio/spring-todo-app .

## MAVEN RUN ON PORT
docker run -p 8080:8080 springio/spring-todo-app



### URL to access H2 DB locally
http://localhost:8080/h2-console - for H2 console



## OTHER USEFUL COMMANDS
docker stop $(docker ps -aq)   <br/>
docker rm $(docker ps -aq) 		<br/>
docker rmi -f $(docker images -aq)		<br/>
	
### Kill Port
sudo lsof -i :portNumber		<br/>
kill PID

### Push to new Repo
git init		<br/>
git add README.md		<br/>
git commit -m "first commit"		<br/>
git remote add origin https://github.com/anoop-git/spring-todo-app.git		<br/>
git push -u origin master		<br/>


### Referance
https://spring.io/guides/gs/accessing-data-jpa/