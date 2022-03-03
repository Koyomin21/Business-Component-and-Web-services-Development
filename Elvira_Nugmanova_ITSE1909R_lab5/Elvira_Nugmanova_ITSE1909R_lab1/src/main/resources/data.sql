INSERT INTO author(awarded, dob, name, surname)
VALUES
       (true, '1913-11-07', 'Alber', 'Camus'),
       (true, '1892-01-03', 'John Ronald Reuel', 'Tolkien'),
       (false, '1948-04-28', 'Terry', 'Pratchett');


INSERT INTO book(description, genre, name, price, rank, year, authorId)
VALUES
       ('The Fall consists of a series of dramatic monologues by the self-proclaimed judge-penitent Jean-Baptiste Clamence', 'Philosophical novel', 'The Fall', 3000, 4.9, 1956, 1),
       ('It tells the story from the point of view of a narrator of a plague sweeping the French Algerian city of Oran', 'Philosophical Novel', 'The Plague', 3500, 4.8, 1947, 1),
       ('The story is told in the form of an episodic quest, and most chapters introduce a specific creature or type of creature of Tolkien geography.', 'Epic Fantasy', 'The Hobbit', 4000, 4.6, 1937, 2),
       ('the story ranges across Middle-earth, following the quest to destroy the One Ring mainly through the eyes of the hobbits', 'Epic Fantasy', 'The Lord of the Rings', 5500, 4.9, 1949, 2),
       ('The story takes place on the Discworld, a planet-sized flat disc carried through space on the backs of four gargantuan elephants', 'Fantasy', 'The Colour of Magic', 3500, 4.7, 1983, 3);

INSERT INTO customer(email, password)
VALUES
       ('elvira@mail.ru','pomidor'),
       ('anuar@mail.ru', 'ogurets'),
       ('aldiyar@mail.ru', 'svekla');

INSERT INTO cart(customerId)
VALUES (1), (2), (3);

INSERT INTO cartItem(bookid, cartId)
VALUES (1, 1), (2, 2), (3, 3);

INSERT INTO orders(cartId, orderDate)
VALUES (1, '2022-02-27'), (2, '2022-02-26'), (3, '2021-10-12')
