CREATE DATABASE ticket_booking_app;

\c ticket_booking_app

CREATE TABLE customer (
id BIGSERIAL PRIMARY KEY,
first_name VARCHAR(65) NOT NULL,
last_name VARCHAR(65) NOT NULL,
email_address VARCHAR(65) NOT NULL UNIQUE,
voucher VARCHAR(15) DEFAULT NULL
);

CREATE TABLE booking (
id BIGSERIAL PRIMARY KEY,
creation_date_time TIMESTAMP DEFAULT NULL,
booking_code UUID DEFAULT NULL,
customer_id BIGINT REFERENCES customer (id)
);

CREATE TABLE cinema (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(65) NOT NULL
);

CREATE TABLE room (
id BIGSERIAL PRIMARY KEY,
number INTEGER NOT NULL,
name VARCHAR(65) NOT NULL,
cinema_id BIGINT REFERENCES cinema (id)
);

CREATE TABLE screening (
id BIGSERIAL PRIMARY KEY,
screening_date_time TIMESTAMP NOT NULL,
movie_title VARCHAR(65) NOT NULL,
duration_time_in_minutes INTEGER NOT NULL,
room_id BIGINT REFERENCES room (id)
);

CREATE TABLE row (
id BIGSERIAL PRIMARY KEY,
row_index INTEGER NOT NULL,
number_of_seats INTEGER NOT NULL,
screening_id BIGINT REFERENCES screening (id)
);

CREATE TABLE seat (
id BIGSERIAL PRIMARY KEY,
number INTEGER NOT NULL,
is_reserved BOOLEAN DEFAULT FALSE,
ticket_type VARCHAR(65) DEFAULT 'ADULT',
row_id BIGINT REFERENCES row (id),
booking_id BIGINT REFERENCES booking (id)
);

INSERT INTO cinema (name) VALUES ('Royal Cinema');

INSERT INTO room (number, name, cinema_id) VALUES (1, 'Toronto', 1);
INSERT INTO room (number, name, cinema_id) VALUES (2, 'Ontario', 1);
INSERT INTO room (number, name, cinema_id) VALUES (3, 'Canada', 1);

INSERT INTO screening (screening_date_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-23 15:00:00', 'Parasite', 132, 1);
INSERT INTO screening (screening_date_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-23 18:00:00', 'Joker', 122, 1);
INSERT INTO screening (screening_date_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-23 20:30:00', 'Ad Astra', 124, 2);
INSERT INTO screening (screening_date_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-24 15:30:00', 'Green Book', 130, 2);
INSERT INTO screening (screening_date_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-24 16:30:00', 'Once Upon a Time... in Hollywood', 161, 3);
INSERT INTO screening (screening_date_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-24 21:00:00', 'Contagion', 105, 3);

INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (1, 10, 1);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (2, 10, 1);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (3, 10, 1);

INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (1, 10, 2);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (2, 10, 2);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (3, 10, 2);

INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (1, 10, 3);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (2, 10, 3);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (3, 10, 3);

INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (1, 10, 4);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (2, 10, 4);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (3, 10, 4);

INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (1, 10, 5);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (2, 10, 5);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (3, 10, 5);

INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (1, 10, 6);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (2, 10, 6);
INSERT INTO row (row_index, number_of_seats, screening_id) VALUES (3, 10, 6);

INSERT INTO seat (number, row_id) VALUES (1, 1);
INSERT INTO seat (number, row_id) VALUES (2, 1);
INSERT INTO seat (number, row_id) VALUES (3, 1);
INSERT INTO seat (number, row_id) VALUES (4, 1);
INSERT INTO seat (number, row_id) VALUES (5, 1);
INSERT INTO seat (number, row_id) VALUES (6, 1);
INSERT INTO seat (number, row_id) VALUES (7, 1);
INSERT INTO seat (number, row_id) VALUES (8, 1);
INSERT INTO seat (number, row_id) VALUES (9, 1);
INSERT INTO seat (number, row_id) VALUES (10, 1);

INSERT INTO seat (number, row_id) VALUES (1, 2);
INSERT INTO seat (number, row_id) VALUES (2, 2);
INSERT INTO seat (number, row_id) VALUES (3, 2);
INSERT INTO seat (number, row_id) VALUES (4, 2);
INSERT INTO seat (number, row_id) VALUES (5, 2);
INSERT INTO seat (number, row_id) VALUES (6, 2);
INSERT INTO seat (number, row_id) VALUES (7, 2);
INSERT INTO seat (number, row_id) VALUES (8, 2);
INSERT INTO seat (number, row_id) VALUES (9, 2);
INSERT INTO seat (number, row_id) VALUES (10, 2);

INSERT INTO seat (number, row_id) VALUES (1, 3);
INSERT INTO seat (number, row_id) VALUES (2, 3);
INSERT INTO seat (number, row_id) VALUES (3, 3);
INSERT INTO seat (number, row_id) VALUES (4, 3);
INSERT INTO seat (number, row_id) VALUES (5, 3);
INSERT INTO seat (number, row_id) VALUES (6, 3);
INSERT INTO seat (number, row_id) VALUES (7, 3);
INSERT INTO seat (number, row_id) VALUES (8, 3);
INSERT INTO seat (number, row_id) VALUES (9, 3);
INSERT INTO seat (number, row_id) VALUES (10, 3);

INSERT INTO seat (number, row_id) VALUES (1, 4);
INSERT INTO seat (number, row_id) VALUES (2, 4);
INSERT INTO seat (number, row_id) VALUES (3, 4);
INSERT INTO seat (number, row_id) VALUES (4, 4);
INSERT INTO seat (number, row_id) VALUES (5, 4);
INSERT INTO seat (number, row_id) VALUES (6, 4);
INSERT INTO seat (number, row_id) VALUES (7, 4);
INSERT INTO seat (number, row_id) VALUES (8, 4);
INSERT INTO seat (number, row_id) VALUES (9, 4);
INSERT INTO seat (number, row_id) VALUES (10, 4);

INSERT INTO seat (number, row_id) VALUES (1, 5);
INSERT INTO seat (number, row_id) VALUES (2, 5);
INSERT INTO seat (number, row_id) VALUES (3, 5);
INSERT INTO seat (number, row_id) VALUES (4, 5);
INSERT INTO seat (number, row_id) VALUES (5, 5);
INSERT INTO seat (number, row_id) VALUES (6, 5);
INSERT INTO seat (number, row_id) VALUES (7, 5);
INSERT INTO seat (number, row_id) VALUES (8, 5);
INSERT INTO seat (number, row_id) VALUES (9, 5);
INSERT INTO seat (number, row_id) VALUES (10, 5);

INSERT INTO seat (number, row_id) VALUES (1, 6);
INSERT INTO seat (number, row_id) VALUES (2, 6);
INSERT INTO seat (number, row_id) VALUES (3, 6);
INSERT INTO seat (number, row_id) VALUES (4, 6);
INSERT INTO seat (number, row_id) VALUES (5, 6);
INSERT INTO seat (number, row_id) VALUES (6, 6);
INSERT INTO seat (number, row_id) VALUES (7, 6);
INSERT INTO seat (number, row_id) VALUES (8, 6);
INSERT INTO seat (number, row_id) VALUES (9, 6);
INSERT INTO seat (number, row_id) VALUES (10, 6);

INSERT INTO seat (number, row_id) VALUES (1, 7);
INSERT INTO seat (number, row_id) VALUES (2, 7);
INSERT INTO seat (number, row_id) VALUES (3, 7);
INSERT INTO seat (number, row_id) VALUES (4, 7);
INSERT INTO seat (number, row_id) VALUES (5, 7);
INSERT INTO seat (number, row_id) VALUES (6, 7);
INSERT INTO seat (number, row_id) VALUES (7, 7);
INSERT INTO seat (number, row_id) VALUES (8, 7);
INSERT INTO seat (number, row_id) VALUES (9, 7);
INSERT INTO seat (number, row_id) VALUES (10, 7);

INSERT INTO seat (number, row_id) VALUES (1, 8);
INSERT INTO seat (number, row_id) VALUES (2, 8);
INSERT INTO seat (number, row_id) VALUES (3, 8);
INSERT INTO seat (number, row_id) VALUES (4, 8);
INSERT INTO seat (number, row_id) VALUES (5, 8);
INSERT INTO seat (number, row_id) VALUES (6, 8);
INSERT INTO seat (number, row_id) VALUES (7, 8);
INSERT INTO seat (number, row_id) VALUES (8, 8);
INSERT INTO seat (number, row_id) VALUES (9, 8);
INSERT INTO seat (number, row_id) VALUES (10, 8);

INSERT INTO seat (number, row_id) VALUES (1, 9);
INSERT INTO seat (number, row_id) VALUES (2, 9);
INSERT INTO seat (number, row_id) VALUES (3, 9);
INSERT INTO seat (number, row_id) VALUES (4, 9);
INSERT INTO seat (number, row_id) VALUES (5, 9);
INSERT INTO seat (number, row_id) VALUES (6, 9);
INSERT INTO seat (number, row_id) VALUES (7, 9);
INSERT INTO seat (number, row_id) VALUES (8, 9);
INSERT INTO seat (number, row_id) VALUES (9, 9);
INSERT INTO seat (number, row_id) VALUES (10, 9);

INSERT INTO seat (number, row_id) VALUES (1, 10);
INSERT INTO seat (number, row_id) VALUES (2, 10);
INSERT INTO seat (number, row_id) VALUES (3, 10);
INSERT INTO seat (number, row_id) VALUES (4, 10);
INSERT INTO seat (number, row_id) VALUES (5, 10);
INSERT INTO seat (number, row_id) VALUES (6, 10);
INSERT INTO seat (number, row_id) VALUES (7, 10);
INSERT INTO seat (number, row_id) VALUES (8, 10);
INSERT INTO seat (number, row_id) VALUES (9, 10);
INSERT INTO seat (number, row_id) VALUES (10, 10);

INSERT INTO seat (number, row_id) VALUES (1, 11);
INSERT INTO seat (number, row_id) VALUES (2, 11);
INSERT INTO seat (number, row_id) VALUES (3, 11);
INSERT INTO seat (number, row_id) VALUES (4, 11);
INSERT INTO seat (number, row_id) VALUES (5, 11);
INSERT INTO seat (number, row_id) VALUES (6, 11);
INSERT INTO seat (number, row_id) VALUES (7, 11);
INSERT INTO seat (number, row_id) VALUES (8, 11);
INSERT INTO seat (number, row_id) VALUES (9, 11);
INSERT INTO seat (number, row_id) VALUES (10, 11);

INSERT INTO seat (number, row_id) VALUES (1, 12);
INSERT INTO seat (number, row_id) VALUES (2, 12);
INSERT INTO seat (number, row_id) VALUES (3, 12);
INSERT INTO seat (number, row_id) VALUES (4, 12);
INSERT INTO seat (number, row_id) VALUES (5, 12);
INSERT INTO seat (number, row_id) VALUES (6, 12);
INSERT INTO seat (number, row_id) VALUES (7, 12);
INSERT INTO seat (number, row_id) VALUES (8, 12);
INSERT INTO seat (number, row_id) VALUES (9, 12);
INSERT INTO seat (number, row_id) VALUES (10, 12);

INSERT INTO seat (number, row_id) VALUES (1, 13);
INSERT INTO seat (number, row_id) VALUES (2, 13);
INSERT INTO seat (number, row_id) VALUES (3, 13);
INSERT INTO seat (number, row_id) VALUES (4, 13);
INSERT INTO seat (number, row_id) VALUES (5, 13);
INSERT INTO seat (number, row_id) VALUES (6, 13);
INSERT INTO seat (number, row_id) VALUES (7, 13);
INSERT INTO seat (number, row_id) VALUES (8, 13);
INSERT INTO seat (number, row_id) VALUES (9, 13);
INSERT INTO seat (number, row_id) VALUES (10, 13);

INSERT INTO seat (number, row_id) VALUES (1, 14);
INSERT INTO seat (number, row_id) VALUES (2, 14);
INSERT INTO seat (number, row_id) VALUES (3, 14);
INSERT INTO seat (number, row_id) VALUES (4, 14);
INSERT INTO seat (number, row_id) VALUES (5, 14);
INSERT INTO seat (number, row_id) VALUES (6, 14);
INSERT INTO seat (number, row_id) VALUES (7, 14);
INSERT INTO seat (number, row_id) VALUES (8, 14);
INSERT INTO seat (number, row_id) VALUES (9, 14);
INSERT INTO seat (number, row_id) VALUES (10, 14);

INSERT INTO seat (number, row_id) VALUES (1, 15);
INSERT INTO seat (number, row_id) VALUES (2, 15);
INSERT INTO seat (number, row_id) VALUES (3, 15);
INSERT INTO seat (number, row_id) VALUES (4, 15);
INSERT INTO seat (number, row_id) VALUES (5, 15);
INSERT INTO seat (number, row_id) VALUES (6, 15);
INSERT INTO seat (number, row_id) VALUES (7, 15);
INSERT INTO seat (number, row_id) VALUES (8, 15);
INSERT INTO seat (number, row_id) VALUES (9, 15);
INSERT INTO seat (number, row_id) VALUES (10, 15);

INSERT INTO seat (number, row_id) VALUES (1, 16);
INSERT INTO seat (number, row_id) VALUES (2, 16);
INSERT INTO seat (number, row_id) VALUES (3, 16);
INSERT INTO seat (number, row_id) VALUES (4, 16);
INSERT INTO seat (number, row_id) VALUES (5, 16);
INSERT INTO seat (number, row_id) VALUES (6, 16);
INSERT INTO seat (number, row_id) VALUES (7, 16);
INSERT INTO seat (number, row_id) VALUES (8, 16);
INSERT INTO seat (number, row_id) VALUES (9, 16);
INSERT INTO seat (number, row_id) VALUES (10, 16);

INSERT INTO seat (number, row_id) VALUES (1, 17);
INSERT INTO seat (number, row_id) VALUES (2, 17);
INSERT INTO seat (number, row_id) VALUES (3, 17);
INSERT INTO seat (number, row_id) VALUES (4, 17);
INSERT INTO seat (number, row_id) VALUES (5, 17);
INSERT INTO seat (number, row_id) VALUES (6, 17);
INSERT INTO seat (number, row_id) VALUES (7, 17);
INSERT INTO seat (number, row_id) VALUES (8, 17);
INSERT INTO seat (number, row_id) VALUES (9, 17);
INSERT INTO seat (number, row_id) VALUES (10, 17);

INSERT INTO seat (number, row_id) VALUES (1, 18);
INSERT INTO seat (number, row_id) VALUES (2, 18);
INSERT INTO seat (number, row_id) VALUES (3, 18);
INSERT INTO seat (number, row_id) VALUES (4, 18);
INSERT INTO seat (number, row_id) VALUES (5, 18);
INSERT INTO seat (number, row_id) VALUES (6, 18);
INSERT INTO seat (number, row_id) VALUES (7, 18);
INSERT INTO seat (number, row_id) VALUES (8, 18);
INSERT INTO seat (number, row_id) VALUES (9, 18);
INSERT INTO seat (number, row_id) VALUES (10, 18);
