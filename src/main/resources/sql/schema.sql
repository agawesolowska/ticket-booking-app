CREATE DATABASE ticket_booking_app;

CREATE TABLE customer (
id BIGSERIAL PRIMARY KEY,
first_name VARCHAR(65) NOT NULL,
last_name VARCHAR(65) NOT NULL,
email_address VARCHAR(65) NOT NULL,
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
