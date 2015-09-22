DROP DATABASE IF EXISTS demo;
CREATE DATABASE demo;
USE demo;

CREATE TABLE IF NOT EXISTS product(id bigint(20) NOT NULL auto_increment,
  name varchar(255),
  price bigint(20),
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB;