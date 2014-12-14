CREATE DATABASE IF NOT EXISTS simple_jira;

USE simple_jira;

DROP TABLE IF EXISTS users;

CREATE TABLE users(
  id int AUTO_INCREMENT NOT NULL,
  name VARCHAR(255),
  PRIMARY KEY (id)
);

INSERT INTO users (name) VALUES ('Kolya');
INSERT INTO users (name) VALUES ('Vasya');
INSERT INTO users (name) VALUES ('Andriy');
INSERT INTO users (name) VALUES ('Oleh');