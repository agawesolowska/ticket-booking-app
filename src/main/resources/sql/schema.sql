CREATE DATABASE ticket_booking_app;

CREATE TYPE ticket_type AS ENUM ('adult', 'student', 'child');

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

CREATE TABLE row (
id BIGSERIAL PRIMARY KEY,
row_index INTEGER NOT NULL,
number_of_seats INTEGER NOT NULL,
room_id BIGINT REFERENCES room (id)
);

-- TBD
CREATE TABLE seat (
id BIGSERIAL PRIMARY KEY,
number INTEGER NOT NULL,
is_reserved BOOLEAN DEFAULT FALSE,
type_of_ticket ticket_type DEFAULT 'adult',
row_id BIGINT REFERENCES row (id)
);

CREATE TABLE screening (
id BIGSERIAL PRIMARY KEY,
screening_date DATE NOT NULL,
screening_time TIME NOT NULL,
movie_title VARCHAR(65) NOT NULL,
duration_time_in_minutes INTEGER NOT NULL,
room_id BIGINT REFERENCES room (id)
);

CREATE TABLE customer (
id BIGSERIAL PRIMARY KEY,
first_name VARCHAR(65) NOT NULL,
last_name VARCHAR(65) NOT NULL,
email_address VARCHAR(65) NOT NULL UNIQUE
);

-- TBD
CREATE TABLE booking (
id BIGSERIAL PRIMARY KEY,
booking_timestamp TIMESTAMP DEFAULT NULL,
is_confirmed BOOLEAN DEFAULT FALSE,
confirmation_code UUID DEFAULT NULL,
screening_id BIGINT REFERENCES screening (id),
customer_id BIGINT REFERENCES customer (id)
);