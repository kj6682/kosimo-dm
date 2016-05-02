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
| GET     | /media/findByTitle/{title}  | Body:Empty  | Status:200 Body:List of Medias | Status:404 or 500  | Retrieves a list of account |
| POST    | /media/findByTitle/{title}  | NA  | NA  | Status:400  | Forbidden action  |
| PUT     | /media/findByTitle/{title}  | NA  | NA  | Status:400  | Forbidden action  |
| DELETE  | /media/findByTitle/{title}  | NA  | NA  | Status:400  | Forbidden action  |
| GET     | /media/findByAuthor/{author}  | Body:Empty  | Status:200 Body:List of Medias | Status:404 or 500  | Retrieves a list of account |
| POST    | /media/findByAuthor/{author}  | NA  | NA  | Status:400  | Forbidden action  |
| PUT     | /media/findByAuthor/{author}  | NA  | NA  | Status:400  | Forbidden action  |
| DELETE  | /media/findByAuthor/{author}  | NA  | NA  | Status:400  | Forbidden action  |
| GET     | /media/findByType/{type}  | Body:Empty  | Status:200 Body:List of Medias | Status:404 or 500  | Retrieves a list of account |
| POST    | /media/findByType/{type}  | NA  | NA  | Status:400  | Forbidden action  |
| PUT     | /media/findByType/{type}  | NA  | NA  | Status:400  | Forbidden action  |
| DELETE  | /media/findByType/{type}  | NA  | NA  | Status:400  | Forbidden action  |
|    |   |   |   |   |   ||
