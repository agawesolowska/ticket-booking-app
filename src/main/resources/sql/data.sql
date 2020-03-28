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

INSERT INTO screening (screening_date, screening_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-01', '18:00:00', 'Joker', 122, 1);
INSERT INTO screening (screening_date, screening_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-01', '20:30:00', 'Ad Astra', 124, 1);
INSERT INTO screening (screening_date, screening_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-02', '16:30:00', 'Once Upon a Time... in Hollywood', 161, 1);

INSERT INTO screening (screening_date, screening_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-01', '15:00:00', 'Parasite', 132, 2);
INSERT INTO screening (screening_date, screening_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-02', '15:30:00', 'Green Book', 130, 2);
INSERT INTO screening (screening_date, screening_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-02', '18:30:00', 'Contagion', 105, 2);

INSERT INTO screening (screening_date, screening_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-02', '16:00:00', 'Parasite', 132, 3);
INSERT INTO screening (screening_date, screening_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-03', '18:30:00', 'Joker', 122, 3);
INSERT INTO screening (screening_date, screening_time, movie_title, duration_time_in_minutes, room_id) VALUES ('2020-04-04', '18:30:00', 'Ad Astra', 124, 3);

INSERT INTO customer (first_name, last_name, email_address) VALUES ('Jacqueline', 'Ashbe', 'jashbe0@oracle.com');
INSERT INTO customer (first_name, last_name, email_address) VALUES ('Kati', 'Deener', 'kdeener5@amazon.com');
INSERT INTO customer (first_name, last_name, email_address) VALUES ('Damon', 'Sharplin', 'dsharplin9@canalblog.com');

-- Bookings - TBD
