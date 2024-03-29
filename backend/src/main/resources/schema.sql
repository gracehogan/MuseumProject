CREATE TABLE IF NOT EXISTS ARTIST (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    year_of_birth INT,
    year_of_death INT
    );

CREATE TABLE IF NOT EXISTS MUSEUM (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    curator VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS SCULPTURE (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    year_completed INT,
    medium VARCHAR(255),
    backstory VARCHAR(1000),
    artist_id BIGINT,
    museum_id BIGINT,
    foreign key (artist_id) references ARTIST(id),
    foreign key (museum_id) references MUSEUM(id),
    src VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS PAINTING (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    year_completed INT,
    medium VARCHAR(255),
    backstory VARCHAR(1000),
    style VARCHAR(255),
    artist_id BIGINT,
    museum_id BIGINT,
    foreign key (artist_id) references ARTIST(id),
    foreign key (museum_id) references MUSEUM(id),
    src VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS BOOKING(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    booked_museum VARCHAR(255) NOT NULL,
    booking_type VARCHAR(255) NOT NULL,
    booking_slot VARCHAR(255) NOT NULL,
    number_of_persons INT,
    booking_date DATETIME,
    cost double
    );

CREATE TABLE IF NOT EXISTS ENQUIRY(
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    enquiry VARCHAR(255),
    enquiry_date DATETIME
    );