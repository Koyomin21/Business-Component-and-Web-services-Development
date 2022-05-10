INSERT INTO ROLES(roleName) VALUES ('customer'), ('admin');

INSERT INTO Users(username, password, firstName, lastName) VALUES
('anuario', 'kale', 'Anuar', 'Borangaziyev'),
('elvirus', 'pomidor', 'Elvira', 'Nugmanova'),
('aldos', 'cabbage', 'Aldiyar', 'Orazbek');

INSERT INTO USERROLES(userId, roleId) VALUES(1, 1), (1, 2);

INSERT INTO PROVIDER(name, description, contactNumber) VALUES
('AlmatyEnergo', 'We are the light you need', '87777777777'),
('AnuarLight', 'We bring the Sun to your life', '89999999999');

INSERT INTO RATE(pricePerUnit, rateDescription, rateTypeName, providerId) VALUES
(17, 'For those who use energy for a house or a flat', 'Non-Commercial', 1),
(28, 'For enterprises', 'Commercial', 2);

INSERT INTO BUILDINGTYPE(name, rateId) VALUES
('flat', 1), ('house', 1), ('business', 2);

INSERT INTO BUILDING(address, buildingTypeId, userId) VALUES
('ulitsa Pushkina dom Kolotushkina', 2, 2),
('Ghandi Park', 1, 3), ('Buckingham Palace', 1, 1);

INSERT INTO ELECTRICITYBILL(userId, unitsUsed, startPeriod, endPeriod, totalSum) VALUES
(1, 100, '02-03-2022', '01-04-2022', 1700),
(2, 50, '03-03-2022', '01-04-2022', 850),
(3, 45, '01-03-2022', '01-04-2022', 765);

INSERT INTO ELECTRICITYBILLDETAILS(electroBillId, providerId, paymentId, debtId) VALUES
(1,1, null, null),
(2,2, null, null),
(3,2, null, null);

INSERT INTO DEBTRATE(rateName, addedPricePerUnit) VALUES
('One-Time-Debt', 3), ('Regular-Debt', 5), ('Extra-Debt', 10);