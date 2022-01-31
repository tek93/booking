--liquibase formatted sql
--changeset tk:1



INSERT INTO `guest` ( `name`) VALUES ( 'Tomasz Kępa');
INSERT INTO `renter` ( `name`) VALUES ( 'Orlen');

INSERT INTO `room_type` (`description`, `name`, `price`, `room_area`) VALUES ( 'apartament na 4 pietrze', 'apartament', '20', '200');

INSERT INTO `reservation` (`id`, `end_date`, `guest`, `renter`, `room_type`, `cost`, `start_date`) VALUES ('1', '2022-01-28', 'Tomasz Kępa', 'Orlen', 'apartament', '40', '2022-01-26');
