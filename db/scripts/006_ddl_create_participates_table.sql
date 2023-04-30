CREATE TABLE participates
(
    id      serial PRIMARY KEY,
    item_id int NOT NULL REFERENCES items (id),
    user_id int NOT NULL REFERENCES user_tracker (id)
);