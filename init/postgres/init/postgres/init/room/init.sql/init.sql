CREATE TABLE IF NOT EXISTS "room" (
      id SERIAL PRIMARY KEY,
      room_name VARCHAR(50) NOT NULL,
    capacity INT NOT NULL,
    location VARCHAR(100),
    is_available BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
