INSERT INTO Movie(title, minutes, publishedYear, description)
VALUES
      ('Edge of Tomorrow', 113, 2014, 'In 2015, aliens called "Mimics" arrive in Germany via an asteroid and swiftly conquer most of continental Europe. By 2020, the United Defense Force (UDF), a global military alliance established to combat the alien threat, finally achieves a victory over the Mimics at Verdun using newly developed mech-suits.'),
      ('Dune', 156, 2021, 'In the far future, when faster-than-light travel is possible, and almost all the planets in the known universe are under the sway of a feudal aristocratic empire, Duke Leto of House Atreides, ruler of the ocean planet Caladan, is assigned by the Padishah Emperor Shaddam Corrino IV to replace House Harkonnen as fief rulers of Arrakis.');

INSERT INTO Customer(firstName, lastName, email, isVip)
VALUES ('Anuar', 'Borangaziyev', 'anuar@gmail.com', true),
       ('Elvira', 'Nugmanova', 'elvira@gmail.com', true),
       ('Aldiyar', 'Orazbek', 'aldik@gmail.com', false),
       ('Karim', 'Ilyasov', 'karim@gmail.com', false);

INSERT INTO Hall(name, capacity)
VALUES ('Blue', 100),
       ('Red', 120),
       ('Purple', 120),
       ('Black', 120);

INSERT INTO Seat(number, row, hallId)
VALUES --1 row
       (1, 1, 1),
       (2,1, 1),
       (3,1, 1),
       (4,1, 1),
       (5,1, 1),
       --2 row
       (1, 2, 1),
       (2,2, 1),
       (3,2, 1),
       (4,2, 1),
       (5,2, 1);
INSERT INTO MovieSession(movieId, hallId, sessionDate, startTime, endTime, price)
VALUES
       -- 1 Movie Session
       (1, 1, '20221010', '14:00', '16:00', 1400),
       (1, 2, '20221011', '17:30', '19:30', 800),
       (1, 3, '20220816', '09:15', '11:15', 650),
       (1, 4, '20220816', '14:00', '16:00', 1400),
       -- 2 Movie Session
       (2, 1, '20220607', '13:00', '15:30', 1300),
       (2, 2, '20220607', '16:00', '18:30', 1100),
       (2, 3, '20220607', '19:00', '21:30', 700),
       (2, 4, '20220608', '14:00', '16:30', 950);


INSERT INTO Booking(customerId, sessionId, seatId, bookingDate, isPaid)
VALUES (1, 1, 2, '20221009', true),
       (2, 2, 3, '20221008', true),
       (3, 5, 2, '20220605', false),
       (4, 5, 2, '20220606', false);





