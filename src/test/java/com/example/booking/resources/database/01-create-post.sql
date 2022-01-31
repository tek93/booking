--liquibase formatted sql
--changeset tk:1

   drop table if exists guest CASCADE;


    drop table if exists reservation CASCADE;


    drop table if exists room_type CASCADE;


    create table guest (

        name varchar(255) NOT NULL ,
        primary key (name)
    ) ;
    create table renter (

        name varchar(255) NOT NULL ,
        primary key (name)
    ) ;


    create table reservation (
       id integer  NOT NULL ,
        end_date date,
        guest VARCHAR(255),
        renter VARCHAR(255),


        room_type VARCHAR(255),

        start_date date,
           cost decimal(19,2),
        primary key (id)
    ) ;


    create table room_type (

        description varchar(255),
        name varchar(255) NOT NULL ,
        price decimal(19,2),
        room_area integer,
        primary key (name)
    ) ;




       alter table reservation
       add constraint reservation_guest
       foreign key (guest)
       references guest(name) ;

       alter table reservation
       add constraint reservation_renter
       foreign key (renter)
       references renter(name) ;


    alter table reservation
       add constraint reservation_room_type
       foreign key (room_type)
       references room_type(name);


