CREATE DATABASE IF NOT EXISTS bank_acc CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci;

CREATE TABLE IF NOT EXISTS address (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    street VARCHAR(45) NOT NULL,
    house_number VARCHAR(10) NOT NULL,
    flat_number VARCHAR(10),
    zip_code VARCHAR(10) NOT NULL,
    city VARCHAR(45) NOT NULL,
    address_type VARCHAR(14) NOT NULL
);

CREATE TABLE IF NOT EXISTS client (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(45),
    middle_name VARCHAR(45),
    name VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL UNIQUE,
    pesel VARCHAR(11),
    birth_date DATE,
    sex VARCHAR(6),
    document_type VARCHAR(9),
    document_number VARCHAR(15) UNIQUE,
    nip VARCHAR(10) UNIQUE,
    regon VARCHAR(9) UNIQUE,
    main_address_id INT NOT NULL,
    correspondence_address_id INT NOT NULL,
    client_type VARCHAR(10) NOT NULL,
    FOREIGN KEY (main_address_id) REFERENCES address (id),
    FOREIGN KEY (correspondence_address_id) REFERENCES address (id)
);

CREATE TABLE IF NOT EXISTS bank (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    address_id INT NOT NULL,
    swift VARCHAR(45) NOT NULL UNIQUE,
    website_url VARCHAR(100) NOT NULL,
    nip VARCHAR(10) NOT NULL UNIQUE,
    krs VARCHAR(14) NOT NULL UNIQUE,
    regon VARCHAR(9) NOT NULL UNIQUE,
    FOREIGN KEY (address_id) REFERENCES address (id)
);

CREATE TABLE IF NOT EXISTS account (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    account_number VARCHAR(26) NOT NULL UNIQUE,
    balance DECIMAL(11,2) NOT NULL,
    account_type VARCHAR(16) NOT NULL,
    bank_id INT NOT NULL,
    FOREIGN KEY (bank_id) REFERENCES bank (id)
);

CREATE TABLE IF NOT EXISTS client_account (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    account_id INT NOT NULL,
    client_id INT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES account (id),
    FOREIGN KEY (client_id) REFERENCES client (id)
);

CREATE TABLE IF NOT EXISTS card (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    card_number VARCHAR(45) NOT NULL UNIQUE,
    expire_date DATE NOT NULL,
    cvc VARCHAR(10) NOT NULL,
    card_type VARCHAR(8) NOT NULL,
    account_id INT NOT NULL UNIQUE,
    FOREIGN KEY (account_id) REFERENCES account (id)
);