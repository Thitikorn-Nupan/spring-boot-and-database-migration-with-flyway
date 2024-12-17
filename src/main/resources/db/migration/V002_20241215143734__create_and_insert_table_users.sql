CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB ;

INSERT INTO `users` (`id`, `fullname`, `email`, `password`, `authorities`) VALUES
	(3, 'alex ryder', 'alex@outlook.co.th', '$2a$12$xtlGEttOi57PlIVlr/9TVu76BSDcbRKKPZFBI78o6BU2NxB/QWgc.', 'admin'),
	(4, 'dony don', 'don@outlook.co.th', '$2a$10$KoLN51yY6kREUSPiJ8b3Je25cVN92TRP9U0MsXU6cMFy5WjsvKrTO', null);
