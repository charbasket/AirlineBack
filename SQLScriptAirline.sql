INSERT INTO `flights`.`Flight` (`airline`, `departureDate`, `destiny`, `flightNumber`, `luggage`, `origin`, `passengers`, `price`, `scales`, `transitTime`) 
VALUES ('Iberia', '2022-12-01 12:00:00', 'Madrid', '123456', false, 'Barcelona', 0, 100, 0, 1.5),
('Iberia', '2022-12-01 14:00:00', 'Barcelona', '654321', false, 'Madrid', 0, 80, 0, 1.5),
('Ryaner', '2022-12-02 12:00:00', 'Berlin', '666666', false, 'Paris', 0, 150, 0, 2.5),
('Air Europa', '2022-12-03 11:30:00', 'Paris', '111111', true, 'Berlin', 0, 200, 1, 1.5),
('Air Europa', '2022-12-02 14:00:00', 'Roma', '654321', true, 'Madrid', 0, 50, 0, 2),
('Emirates', '2022-12-01 14:00:00', 'Berlin', '654321', false, 'Roma', 0, 80, 0, 1.5);



INSERT INTO `users`.`User` (`age`, `identification`, `name`, `nationality`, `surname`)
 VALUES ('20', '11111111', 'Carlos', 'Spain', 'Fuentes'),
('25', '22222222', 'Dani', 'Germany', 'Perez'),
('67', '33333333', 'Sara', 'England', 'McDonald'),
('2', '44444444', 'David', 'France', 'Baguette'),
('86', '55555555', 'Carlo', 'Itali', 'Vincenzo');

INSERT INTO `reservations`.`Reservation` (`flightId`, `userId`) VALUES ('1', '1'),
('1', '2'),
('2', '1'),
('2', '5'),
('3', '4'),
('4', '4');

