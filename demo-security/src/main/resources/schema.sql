DROP DATABASE IF EXISTS demo_security;
CREATE DATABASE demo_security;
USE demo_security;

CREATE TABLE IF NOT EXISTS user(id bigint(20) NOT NULL auto_increment,
  username varchar(255),
  password varchar(255),
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB;