create database angl default character set utf8 DEFAULT COLLATE utf8_general_ci;

use angl;

CREATE TABLE `users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) not NULL ,
  `age` int(2) not NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = innoDB
  DEFAULT CHAR SET = utf8;
