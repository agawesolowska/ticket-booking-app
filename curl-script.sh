#!/bin/bash

# The script that runs a business scenario (use case) by calling respective endpoints.

# 1. The user selects the day and the time when he/she would like to see the movie.
# 2. The system lists movies available in the given time interval - title and screening times.

curl --location --request GET 'localhost:8080/api/v1/screenings/search/findByScreeningDateTimeBetween?startDateTime=2020-04-23%2012:00:00&endDateTime=2020-04-24%2016:00:00&sort=movieTitle,durationTimeInMinutes'

# 3. The user chooses a particular screening.

curl --location --request GET 'http://localhost:8080/api/v1/screenings/1'

# 4. The system gives information regarding screening room and available seats.

curl --location --request GET 'http://localhost:8080/api/v1/screenings/1/room'

curl --location --request GET 'http://localhost:8080/api/v1/screenings/1/rows?sort=rowIndex'

curl --location --request GET 'http://localhost:8080/api/v1/rows/1/seats?sort=number'

# 5. The user chooses seats, and gives the name of the person doing the reservation (name and surname).

curl --location --request POST 'localhost:8080/api/v1/customerBooking' \
--header 'Content-Type: application/json' \
--data-raw '{"screening":{"id":1},"seatReservations":[{"id":1,"ticketType":"adult"},{"id":2,"ticketType":"student"},{"id":3,"ticketType":"child"}],"customer":{"firstName":"Anna","lastName":"Kowalska","emailAddress":"anna@kowalska.pl","voucher":"ASDF/1234"}}'

# 6. The system gives back the total amount to pay and reservation expiration time - as a JSON output.