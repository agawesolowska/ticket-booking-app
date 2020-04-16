# Ticket Booking App - REST API
> Seat reservation system for a cinema - recruitment task.

## Table of Contents
* [General Info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Contact](#contact)

## General Info
The purpose of the project was to build a seat reservation system for a cinema as a REST service.

## Technologies
* JavaSE-11, Spring (Boot, Data, REST), JPA & Hibernate, PostgreSQL

## Setup
To run this application you need to have [PostgreSQL](https://www.postgresql.org/download/) installed - apart from JVM of course!
* Clone or download this repo to your computer. Notice a path of the project directory.
* Open a terminal and execute command below:
`psql -h localhost -p 5432 -U postgres -f C:\your-own-path-to-the-project-directory\ticket-booking-app\src\main\resources\sql\sql-script.sql` - it builds the PostgreSQL database with all test data.
* Then go to the project directory in a command line and run the application:
`C:\your-own-path-to-the-project-directory\ticket-booking-app> .\mvnw spring-boot:run`
* Now you can run the project in a browser or as a [Postman client](https://www.postman.com/).

## Features
* The system covers a single cinema with multiple rooms.
* There are three types of tickets: adult (25 PLN), student (18 PLN) and child (12.50 PLN), but during the weekend (from Friday to the end of Sunday) the price is 4 PLN higher.
* Customer can select a time interval in which he/she would like to see the movie.
* Seats (at least one) can be booked at the latest 15 minutes before the screening begins and there are must be next to each other.
- To book tickets customer chooses a particular screening, seats, ticket types and also has to provide personal information (name, e-mail address and optionally voucher code which gives a 50% discount).
* Provided name and surname should be at least three characters long and start with a capital letter. The surname could also consist of two parts separated with a single dash. Keep in mind the second part should also start with a capital letter.
* The system gives back the total amount to pay and reservation expiration time as a JSON.
* @PostMapping in the REST controller is the only way to book tickets, as a valid request body.
* HTTP methods such as POST, PUT and DELETE are disabling for the particular entities - but of course, the GET method is available to get information about screenings, seats, etc.

## Contact
Created by [@agawesolowska](https://www.linkedin.com/in/agawesolowska/) - feel free to contact me!
