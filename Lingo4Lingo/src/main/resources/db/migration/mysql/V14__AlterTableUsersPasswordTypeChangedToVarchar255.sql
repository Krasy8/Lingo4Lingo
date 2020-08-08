ALTER TABLE users
    CHANGE password password varchar(255) COLLATE 'utf8mb4_0900_ai_ci' NULL AFTER login;
