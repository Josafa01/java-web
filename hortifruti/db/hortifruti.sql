CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `addCookie` varchar(50) NOT NULL,
  `count_log` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `login` (`id`, `email`, `senha`, `addCookie`, `count_log`) VALUES
(1, 'admin@email.com', '123', '0', 0),
(2, 'user@email.com', '123', '0', 0);


