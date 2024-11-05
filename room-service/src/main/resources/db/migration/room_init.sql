-- Create the room table
CREATE TABLE room (
                      id SERIAL PRIMARY KEY,
                      room_name VARCHAR(100) NOT NULL,
                      capacity INT NOT NULL,
                      location VARCHAR(100)
);