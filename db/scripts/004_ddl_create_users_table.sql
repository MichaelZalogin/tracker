CREATE TABLE user_tracker
(
    id      serial PRIMARY KEY,
    name    varchar(2000),
    role_id int NOT NULL REFERENCES role(id)
);