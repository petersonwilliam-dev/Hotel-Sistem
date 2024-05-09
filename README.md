This is a personal study project
This java project simulates a hotel system.
Contains:
- Guests registration
- Make room reservation
- Delete reservation made
- Checks that reservation dates do not collide

SQL Database was used in the project, this database is hosted on localhost. Therefore, it is not possible to access it.

Here are the instructions for creating the database tables (adjust driver url in ConnectionDB class).

TABLE guest (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(255) NOT NULL,
  surname varchar(255) NOT NULL,
  date_of_birth date NOT NULL,
  itr varchar(15) NOT NULL UNIQUE,
  number_phone varchar(15) NOT NULL,
  identification_card varchar(10) NOT NULL,
  password_guest varchar(255) NOT NULL
);

TABLE rooms (
  number int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type varchar(255) NOT NULL,
  description varchar(500) NOT NULL,
  capacity int NOT NULL,
  price double NOT NULL
);

TABLE room_reservations (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  arrival_date date NOT NULL,
  departure_date date NOT NULL,
  total_value_of_stay double NOT NULL,
  id_room int NOT NULL,
  id_guest int NOT NULL
);

ALTER TABLE room_reservations 
ADD CONSTRAINT fk_room FOREIGN KEY id_room REFERENCES rooms (number);

ALTER TABLE room_reservations
ADD CONSTRAINT fk_guest FOREIGN KEY id_guest REFERENCES guests (id);

***** ROOM DATA WAS INSERTED INTO THE SQL ENVIRONMENT ITSELF *****



