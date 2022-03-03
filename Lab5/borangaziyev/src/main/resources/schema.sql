DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS MovieSession;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Movie;
DROP TABLE IF EXISTS Seat;
DROP TABLE IF EXISTS Hall;



CREATE TABLE Hall (
    hallId serial primary key,
    name varchar(255),
    capacity int
);


CREATE TABLE Seat (
    seatId serial primary key,
    row int,
    number int,
    hallId int references Hall(hallId)

);

CREATE TABLE Movie (
    movieId serial primary key,
    title varchar(255),
    description text,
    minutes int,
    publishedYear int,
    poster bytea
);

CREATE TABLE Customer (
    customerId serial primary key,
    firstName varchar(255),
    lastName varchar(255),
    email varchar(255),
    isVip boolean,
    version int default 0
);

CREATE TABLE MovieSession (
    sessionId serial primary key,
    price int,
    sessionDate Date,
    startTime time,
    endTime time,
    movieId int references Movie(movieId),
    hallId int references Hall(hallId)
);

CREATE TABLE Booking (
    bookingId serial primary key,
    bookingDate Date,
    isPaid boolean,
    customerId int references Customer(customerId),
    sessionId int references MovieSession(sessionId),
    seatId int references Seat(seatId)
);