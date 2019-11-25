CREATE DATABASE wildlife_tracker;
\c wildlife_tracker;

CREATE TABLE IF NOT EXISTS animals (
id int PRIMARY KEY auto_increment,
	name VARCHAR,
	health VARCHAR,
	age VARCHAR
);

CREATE TABLE IF NOT EXISTS sightings (
	id INTEGER PRIMARY KEY auto_increment,
    animal_id INTEGER,
    ranger VARCHAR,
    location VARCHAR,
    FOREIGN KEY(animal_id) REFERENCES public.animals(id)
);

CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
