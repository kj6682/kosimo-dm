## Media Service
This business service deals with MEDIA items and the 
operations that can be done in this domain.


## Endpoints and Action Identification
Now that we defined the endpoints, 
we want to define the actions we can do on the entities through them.

<pre>media</pre>

| HTTP Method | Endpoint  | Input  | Success Response  | Error Response  | Description |
|---|---|---|---|---|---|
| GET     | /media  | Body:Empty  | Status:200 Body:Media list  | Status:500  | Retrieves all available media  |
| POST    | /media  | Body:New Media Data  | Status:201 Body:id  | Status:500  | Creates a new Media  |
| PUT     | /media  | NA  | NA  | Status:400  | Forbidden action  |
| DELETE  | /media  | NA  | NA  | Status:400  | Forbidden action  |
| GET     | /media/{id}  | Body:Empty  | Status:200 Body:Media data  | Status:404 or 500  | Retrieves an account |
| POST    | /media/{id}  | NA  | NA  | Status:400  | Forbidden action  |
| PUT     | /media/{id}  | Body:account data with updates  | Status:200 Body:Empty  | Status:404 or 500  | Updates an account  |
| DELETE  | /media/{id}  | Body:Empty  | Status:200  | Status:404 or 400  | Deletes an account  |
| GET     | /media/title/{title}  | Body:Empty  | Status:200 Body:List of Medias | Status:404 or 500  | Retrieves a list of account |
| POST    | /media/title/{title}  | NA  | NA  | Status:400  | Forbidden action  |
| PUT     | /media/title/{title}  | NA  | NA  | Status:400  | Forbidden action  |
| DELETE  | /media/title/{title}  | NA  | NA  | Status:400  | Forbidden action  |
| GET     | /media/author/{author}  | Body:Empty  | Status:200 Body:List of Medias | Status:404 or 500  | Retrieves a list of account |
| POST    | /media/author/{author}  | NA  | NA  | Status:400  | Forbidden action  |
| PUT     | /media/author/{author}  | NA  | NA  | Status:400  | Forbidden action  |
| DELETE  | /media/author/{author}  | NA  | NA  | Status:400  | Forbidden action  |
| GET     | /media/type/{type}  | Body:Empty  | Status:200 Body:List of Medias | Status:404 or 500  | Retrieves a list of account |
| POST    | /media/type/{type}  | NA  | NA  | Status:400  | Forbidden action  |
| PUT     | /media/type/{type}  | NA  | NA  | Status:400  | Forbidden action  |
| DELETE  | /media/type/{type}  | NA  | NA  | Status:400  | Forbidden action  |
|    |   |   |   |   |   ||

# Run
In order to run the service in dev mode and have some dummy data loaded type :

<pre>mvn spring-boot:run -Dspring.profiles.active=dev
</pre>