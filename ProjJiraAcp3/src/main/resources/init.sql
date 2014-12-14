CREATE DATABASE IF NOT EXISTS simple_jira;

USE simple_jira;

DROP TABLE IF EXISTS users;

CREATE TABLE users(
  id int AUTO_INCREMENT NOT NULL,
  name VARCHAR(255),
  PRIMARY KEY (id)
);

INSERT INTO users (name) VALUES ('Kolia');
INSERT INTO users (name) VALUES ('Vasi');
INSERT INTO users (name) VALUES ('Andrey');
INSERT INTO users (name) VALUES ('Oleg');
