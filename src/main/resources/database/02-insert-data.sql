--liquibase formatted sql
--changeset tk:1



INSERT INTO `guest` ( `name`) VALUES ( 'Tomasz Kępa');
INSERT INTO `guest` ( `name`) VALUES ( 'Jan Nowak');
INSERT INTO `guest` ( `name`) VALUES ( 'Adam Nowak');
INSERT INTO `guest` ( `name`) VALUES ( 'Andrzej Kowalski');
INSERT INTO `renter` ( `name`) VALUES ( 'Orlen');
INSERT INTO `renter` ( `name`) VALUES ( 'Shell');
INSERT INTO `renter` ( `name`) VALUES ( 'Lidl');
INSERT INTO `renter` ( `name`) VALUES ( 'KLG Solusions');
INSERT INTO `renter` ( `name`) VALUES ( 'Jan Nowak');


INSERT INTO `room_type` (`description`, `name`, `price`, `room_area`) VALUES ( 'apartament na 4 pietrze', 'apartament', '120', '200');
INSERT INTO `room_type` (`description`, `name`, `price`, `room_area`) VALUES ( 'pokój jednoosobowy ze wspólną łazienką', 'pokój 1os', '30', '20');
INSERT INTO `room_type` (`description`, `name`, `price`, `room_area`) VALUES ( 'pokój dwuosobowy z wspólną łazienką', 'pokój 2os', '50', '30');
INSERT INTO `room_type` (`description`, `name`, `price`, `room_area`) VALUES ( 'pokój dwuosobowy z własną  łazienką', 'pokój 2os.łazienka', '580', '30');

INSERT INTO `reservation` (`id`, `end_date`, `guest`, `renter`, `room_type`, `cost`, `start_date`) VALUES ('1', '2022-01-28', 'Tomasz Kępa', 'Orlen', 'apartament', '40', '2022-01-26');
INSERT INTO `reservation` (`id`, `end_date`, `guest`, `renter`, `room_type`, `cost`, `start_date`) VALUES ('2', '2022-01-28', 'Andrzej Kowalski', 'KLG Solusions', 'pokój 2os.łazienka', '40', '2022-01-26');
