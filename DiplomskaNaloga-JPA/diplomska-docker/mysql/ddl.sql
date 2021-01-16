-- diplomskanaloga.profesor definition

CREATE TABLE `profesor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `imePriimek` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `imePriimek` (`imePriimek`),
  FULLTEXT KEY `imePriimek_2` (`imePriimek`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- diplomskanaloga.program definition

CREATE TABLE `program` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(5) NOT NULL,
  `vrsta` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- diplomskanaloga.`role` definition

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- diplomskanaloga.uporabnik definition

CREATE TABLE `uporabnik` (
  `username` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- diplomskanaloga.vrstastudija definition

CREATE TABLE `vrstastudija` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(5) NOT NULL,
  `vrsta` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- diplomskanaloga.zavod definition

CREATE TABLE `zavod` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(5) NOT NULL,
  `zavod` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- diplomskanaloga.diplomskadela definition

CREATE TABLE `diplomskadela` (
  `id` int NOT NULL AUTO_INCREMENT,
  `priimekIme` varchar(30) NOT NULL,
  `naslov` varchar(255) NOT NULL,
  `datum` date NOT NULL,
  `id_profesor` int NOT NULL,
  `id_zavod` int NOT NULL,
  `id_vrstastudija` int NOT NULL,
  `id_program` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_profesor` (`id_profesor`),
  KEY `id_zavod` (`id_zavod`),
  KEY `id_vrstastudija` (`id_vrstastudija`),
  KEY `id_program` (`id_program`),
  FULLTEXT KEY `priimekIme` (`priimekIme`),
  FULLTEXT KEY `priimekIme_2` (`priimekIme`),
  CONSTRAINT `diplomskadela_ibfk_1` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id`),
  CONSTRAINT `diplomskadela_ibfk_2` FOREIGN KEY (`id_zavod`) REFERENCES `zavod` (`id`),
  CONSTRAINT `diplomskadela_ibfk_3` FOREIGN KEY (`id_vrstastudija`) REFERENCES `vrstastudija` (`id`),
  CONSTRAINT `diplomskadela_ibfk_4` FOREIGN KEY (`id_program`) REFERENCES `program` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2944 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- diplomskanaloga.uporabnik_role definition

CREATE TABLE `uporabnik_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `id_role` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`),
  KEY `id_role` (`id_role`),
  CONSTRAINT `uporabnik_role_ibfk_1` FOREIGN KEY (`username`) REFERENCES `uporabnik` (`username`),
  CONSTRAINT `uporabnik_role_ibfk_2` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;