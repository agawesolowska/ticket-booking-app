# Ticket Booking App - REST API
> Seat reservation system for a cinema - recruitment task.

## Table of contents
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
TBA

## Features
* The system covers a single cinema with multiple rooms.
* There are three types of tickets: adult (25 PLN), student (18 PLN) and child (12.50 PLN), but during the weekend (from Friday to the end of Sunday) the price is 4 PLN higher.
* Customer can select a time interval in which he/she would like to see the movie.
* Seats (at least one) can be booked at the latest 15 minutes before the screening begins and there are must be next to each other.
* To book tickets customer chooses a particular screening, seats, ticket types and also has to provide personal information (name, e-mail address and optionally voucher code which gives a 50% discount).
* Provided name and surname should be at least three characters long and start with a capital letter. The surname could also consist of two parts separated with a single dash. Keep in mind the second part should also start with a capital letter.
* The system gives back the total amount to pay and reservation expiration time.
* The application contains test data as a psql script.
* @PostMapping in the REST controller is the only way to book tickets, as a valid request body.
* HTTP methods such as POST, PUT and DELETE are disabling for the particular entities - but of course, the GET method is available to get information about screenings, seats, etc.

## Contact
Created by [@agawesolowska](https://www.linkedin.com/in/agawesolowska/) - feel free to contact me!
