create database angl default character set utf8 DEFAULT COLLATE utf8_general_ci;

use angl;

CREATE TABLE `users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) not NULL,
  `age` int(2) not NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = innoDB
  DEFAULT CHAR SET = utf8;

ALTER TABLE `users` ADD `email` VARCHAR(30) not NULL UNIQUE ;
ALTER TABLE `users` ADD `password` VARCHAR(30) not NULL;

# insert test values
INSERT INTO `users` (`id`, `name`, `age`, `email`, `password`)
VALUES
(1, 'test1', 10, 'test1@test.com', '1234');
INSERT INTO `users` (`id`, `name`, `age`, `email`, `password`)
VALUES
  (2, 'test2', 22, 'test2@test.com', '2345');