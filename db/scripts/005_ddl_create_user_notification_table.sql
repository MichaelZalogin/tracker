CREATE TABLE user_notification
(
    id        serial PRIMARY KEY,
    messenger text,
    identify  text,
    user_tracker_id   int REFERENCES user_tracker (id)
);