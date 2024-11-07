DROP database if exists searoutesapi ;
create database searoutesapi;
use searoutesapi;

drop table if exists Port;
drop table if exists Cargo;
drop table if exists Vessel;
drop table if exists Estimate;

CREATE TABLE Port (
    port_id    INT AUTO_INCREMENT PRIMARY KEY,
    Name       VARCHAR(255) NOT NULL,
    latitude	DOUBLE NOT NULL,
    longitude  DOUBLE NOT NULL
);


CREATE TABLE Cargo (
    cargo_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    loading_port_id INT NOT NULL,
    discharge_port_id INT NOT NULL,
    quantity INT,
    unit VARCHAR(50),
    weight DOUBLE,

    FOREIGN KEY (loading_port_id) REFERENCES Port(port_id) ON DELETE CASCADE,
    FOREIGN KEY (discharge_port_id) REFERENCES Port(port_id) ON DELETE CASCADE
);


CREATE TABLE Vessel (
    imo BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    length DOUBLE,
    width DOUBLE,
    max_draft DOUBLE
);


CREATE TABLE Estimate (
    estimate_id INT AUTO_INCREMENT PRIMARY KEY,
    cargo_id INT NOT NULL,
    vessel_id BIGINT NOT NULL,
    weight DOUBLE NOT NULL,

    FOREIGN KEY (cargo_id) REFERENCES cargo(cargo_id) ON DELETE CASCADE,
    FOREIGN KEY (vessel_id) REFERENCES vessel(imo) ON DELETE CASCADE
);

