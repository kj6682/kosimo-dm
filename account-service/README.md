## Account Service
This business service deals with ACCOUNTS and the operations that can be done in this domain.


## Endpoints and Action Identification
Now that we defined the endpoints, we want to define the actions we can do on the entities through them.

<pre>user</pre>

| HTTP Method | Endpoint  | Input  | Success Response  | Error Response  | Description |
|---|---|---|---|---|---|
| GET     | /accounts  | Body:Empty  | Status:200 Body:Account list  | Status:500  | Retrieves all available accounts  |
| POST    | /accounts  | Body:New Account Data  | Status:201 Body:id  | Status:500  | Creates a new Account  |
| PUT     | /accounts  | NA  | NA  | Status:400  | Forbidden action  |
| DELETE  | /accounts  | NA  | NA  | Status:400  | Forbidden action  |
| GET     | /accounts/{id}  | Body:Empty  | Status:200 Body:Account data  | Status:404 or 500  | Retrieves an account |
| POST    | /accounts/{id}  | NA  | NA  | Status:400  | Forbidden action  |
| PUT     | /accounts/{id}  | Body:account data with updates  | Status:200 Body:Empty  | Status:404 or 500  | Updates an account  |
| DELETE  | /accounts/{id}  | Body:Empty  | Status:200  | Status:404 or 400  | Deletes an account  |
| GET     | /accounts/findByOwner/{id}  | Body:Empty  | Status:200 Body:List of Accounts | Status:404 or 500  | Retrieves a list of account |
| POST    | /accounts/findByOwner/{id}  | NA  | NA  | Status:400  | Forbidden action  |
| PUT     | /accounts/findByOwner/{id}  | NA  | NA  | Status:400  | Forbidden action  |
| DELETE  | /accounts/findByOwner/{id}  | NA  | NA  | Status:400  | Forbidden action  |
| GET     | /accounts/transfer/  | NA | NA | Status:400  | Forbidden action |
| POST    | /accounts/transfer/  | Body: debit(id), credit(id), amount, currency  | Status:201 Body:message(id)  | Status:404 or 500  | Execites transfer  |
| PUT     | /accounts/transfer/  | NA  | NA  | Status:400  | Forbidden action  |
| DELETE  | /accounts/transfer/  | NA  | NA  | Status:400  | Forbidden action  |
|    |   |   |   |   |   ||
