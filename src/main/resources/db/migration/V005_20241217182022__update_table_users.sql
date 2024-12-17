TRUNCATE TABLE users;
INSERT INTO `users` ( `fullname`, `email`, `password`, `authorities`) VALUES
	( 'alex ryder', 'alex@outlook.co.th', '$2a$12$xtlGEttOi57PlIVlr/9TVu76BSDcbRKKPZFBI78o6BU2NxB/QWgc.', 'admin'),
	('dony don', 'don@outlook.co.th', '$2a$10$KoLN51yY6kREUSPiJ8b3Je25cVN92TRP9U0MsXU6cMFy5WjsvKrTO', 'user'),
    ('max holloway', 'max@outlook.co.th', '$2a$10$KoLN51yY6kREUSPiJ8b3Je25cVN92TRP9U0MsXU6cMFy5WjsvKrTO', 'user');
