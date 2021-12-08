# Java-backend

A Java backend using Spring Boot.

This project runs on Spring boot along side with MongoDB for its database.

Inside the "backend" folder there is a file named DatabaseData.json, this file contains generated records for 100 persons and can be added into MongoDB via MongoCompass.

## What does it do?

This is a simple backend allowing the user to create and manage persons and their balances based on HTTP requests.

## Routes

- localhost:8080/api/getall - returns a list of every person object in the database
- localhost:8080/api/createperson - creates a new person based on the request payload
- localhost:8080/api/deleteperson/{id} - deletes a person from the DB based on their ID.
- localhost:8080/api/setbalance/{id} - sets a person balance to a new balance.
- localhost:8080/api/addbalance/{id} - adds balance to the user based on their current amount.
- localhost:8080/api/getperson/{id} - return person object based on the ID
- localhost:8080/api/test - used to test random stuff.
