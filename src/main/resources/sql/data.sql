INSERT INTO cinema (name) VALUES ('Royal Cinema');

INSERT INTO room (number, name, cinema_id) VALUES (1, 'Toronto', 1);
INSERT INTO room (number, name, cinema_id) VALUES (2, 'Ontario', 1);
INSERT INTO room (number, name, cinema_id) VALUES (3, 'Canada', 1);

INSERT INTO row (row_index, number_of_seats, room_id) VALUES (1, 10, 1);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (2, 15, 1);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (3, 20, 1);

INSERT INTO row (row_index, number_of_seats, room_id) VALUES (1, 10, 2);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (2, 15, 2);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (3, 20, 2);

INSERT INTO row (row_index, number_of_seats, room_id) VALUES (1, 10, 3);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (2, 15, 3);
INSERT INTO row (row_index, number_of_seats, room_id) VALUES (3, 20, 3);

-- Seats - TBD

INSERT INTO movie (title, duration_time_in_minutes) VALUES ('Parasite', 132);
INSERT INTO movie (title, duration_time_in_minutes) VALUES ('Joker', 122);
INSERT INTO movie (title, duration_time_in_minutes) VALUES ('Once Upon a Time... in Hollywood', 161);

INSERT INTO screening (screening_date, screening_time, movie_id, room_id) VALUES ('2020-04-01', '18:00:00', 1, 1);
INSERT INTO screening (screening_date, screening_time, movie_id, room_id) VALUES ('2020-04-01', '20:30:00', 2, 1);
INSERT INTO screening (screening_date, screening_time, movie_id, room_id) VALUES ('2020-04-01', '15:00:00', 3, 2);
INSERT INTO screening (screening_date, screening_time, movie_id, room_id) VALUES ('2020-04-02', '15:30:00', 1, 2);
INSERT INTO screening (screening_date, screening_time, movie_id, room_id) VALUES ('2020-04-02', '16:00:00', 2, 3);
INSERT INTO screening (screening_date, screening_time, movie_id, room_id) VALUES ('2020-04-02', '18:30:00', 3, 3);

INSERT INTO customer (first_name, last_name, email_address) VALUES ('Jacqueline', 'Ashbe', 'jashbe0@oracle.com');
INSERT INTO customer (first_name, last_name, email_address) VALUES ('Kati', 'Deener', 'kdeener5@amazon.com');
INSERT INTO customer (first_name, last_name, email_address) VALUES ('Damon', 'Sharplin', 'dsharplin9@canalblog.com');

-- Bookings - TBD
