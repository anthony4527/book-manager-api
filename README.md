# 📖 Minimalist Book Manager API

## Introduction
This is the starter repository for the Further APIs session. It provides a start to creating a Minimalist Book Manager API
using a Test-Driven Development approach.

### Pre-Requisites
- Java SE Development Kit 17
- Maven

### Technologies & Dependencies
- Spring Boot
- Spring Web
- H2 Database
- Lombok
- Spring Data JPA

### Main Entry Point
- The Main Entry Point for the application is: [BookmanagerApplication.java](src/main/java/com/techreturners/bookmanager/BookmanagerApplication.java)

### Running the Unit Tests
- You can run the unit tests in IntelliJ, or you can go to your terminal and inside the root of this directory, run:

`mvn test`

### Tasks

The features are:
- Get All Books
- Get a Book by ID
- Add a Book
- Update a Book

📘 Task 1: Implement the following User Story with tests.

`User Story: As a user, I want to use the Book Manager API to delete a book using its ID`

Task Completed:
--------------
A Test case "TestPostAndDeleteABook" is added to the ControllerTest Case Class for TDD. The Controller has been updated with @DeleteMapping to implement a delete-by-Id action to fulfull the above User Story. in the Book Manager API. 


📘 Extension Task: Oh no! 😭 We've only covered the happy paths in the solution, can you figure out a way to add in exception handling to the project? 

What if someone wants to add a book with an ID for a book that already exists? How do we handle this gracefully?

** Extension Task Completed:
I have created a DuplicateBookException class, and use the ResponseExceptionHandler to throw error message. The service class check if a book alredy exist, and if yes will throw the error message and return a Conflict status code (409) in the JSON response..

What if someone wants to find a book by an ID that doesn't yet exist? 
  How can we improve the API by handling errors gracefully and show a helpful message to the client?
  
**  Extension Task Completed:
  A Test case of "TestGetErrorCheck" is added to the ControllerTest Case Class for TDD.
The GetById API is enhanced to perform a check using ID of the book for request. If the book ID does not exist in the Model class/backend, the Controller will send back a Response with Http status code - 404 (Not_Found). The error message description is returned by the REsponseEntity using a Httpheader entry of {"Error","Book does not exist"}. The client application can read this error message to inform the user.
