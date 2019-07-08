-- --------------------------------------------------------
-- Servidor:                     localdb
-- Versão do servidor:           8.0.16 - MySQL Community Server - GPL
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura para tabela loja.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTATO` varchar(25) DEFAULT NULL,
  `NOME` varchar(80) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela loja.clientes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`ID`, `CONTATO`, `NOME`) VALUES
	(1, '898989', 'jose'),
	(2, '898989', 'jose MARIA');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.enderecos
CREATE TABLE IF NOT EXISTS `enderecos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CEP` varchar(255) DEFAULT NULL,
  `CIDADE` varchar(255) DEFAULT NULL,
  `RUA` varchar(255) DEFAULT NULL,
  `CLIENTE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKaafji444q9vvxwvn16wd5iju1` (`CLIENTE_ID`),
  CONSTRAINT `FKaafji444q9vvxwvn16wd5iju1` FOREIGN KEY (`CLIENTE_ID`) REFERENCES `clientes` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela loja.enderecos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `enderecos` DISABLE KEYS */;
INSERT INTO `enderecos` (`ID`, `CEP`, `CIDADE`, `RUA`, `CLIENTE_ID`) VALUES
	(1, '123456555', 'nome cidade', 'nome rua2244', 1),
	(2, '123456555', 'nome cidade', 'nome rua FGT', 1),
	(3, '123456555', 'nome cidadeGGG', 'nome rua FGGGGGGT', 2);
/*!40000 ALTER TABLE `enderecos` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.itens
CREATE TABLE IF NOT EXISTS `itens` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `QUANTIDADE` int(10) NOT NULL,
  `VALOR_UNITARIO` decimal(10,2) NOT NULL DEFAULT '0.00',
  `VALOR_TOTAL` decimal(10,2) NOT NULL DEFAULT '0.00',
  `CATEGORIA` varchar(255) DEFAULT NULL,
  `NUM_PEDIDO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKob75ladtaaeebyb4py8v9g888` (`CATEGORIA`,`NUM_PEDIDO`),
  CONSTRAINT `FKob75ladtaaeebyb4py8v9g888` FOREIGN KEY (`CATEGORIA`, `NUM_PEDIDO`) REFERENCES `pedidos` (`CATEGORIA`, `NUM_PEDIDO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela loja.itens: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `itens` DISABLE KEYS */;
INSERT INTO `itens` (`ID`, `QUANTIDADE`, `VALOR_UNITARIO`, `VALOR_TOTAL`, `CATEGORIA`, `NUM_PEDIDO`) VALUES
	(1, 4, 25.69, 102.76, 'virtual Store', 353),
	(2, 4, 25.69, 102.76, 'virtual Store', 190),
	(3, 4, 25.69, 102.76, 'virtual Store', 331),
	(4, 4, 35.90, 143.60, 'virtual Store', 331);
/*!40000 ALTER TABLE `itens` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.pedidos
CREATE TABLE IF NOT EXISTS `pedidos` (
  `CATEGORIA` varchar(255) NOT NULL,
  `NUM_PEDIDO` int(11) NOT NULL,
  `DATA_PEDIDO` datetime DEFAULT NULL,
  `CLIENTE_ID` int(11) NOT NULL,
  PRIMARY KEY (`CATEGORIA`,`NUM_PEDIDO`),
  KEY `FKgbxwxdahujbfjn2g7ev19nw8a` (`CLIENTE_ID`),
  CONSTRAINT `FKgbxwxdahujbfjn2g7ev19nw8a` FOREIGN KEY (`CLIENTE_ID`) REFERENCES `clientes` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela loja.pedidos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` (`CATEGORIA`, `NUM_PEDIDO`, `DATA_PEDIDO`, `CLIENTE_ID`) VALUES
	('GH', 0, '2019-07-07 18:27:06', 2),
	('H6', 0, NULL, 1),
	('virtual Store', 190, '2019-07-07 22:04:20', 1),
	('virtual Store', 331, '2019-07-07 22:39:37', 1),
	('virtual Store', 353, '2019-07-07 21:50:39', 1);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;

-- Copiando estrutura para tabela loja.produtos
CREATE TABLE IF NOT EXISTS `produtos` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(120) DEFAULT NULL,
  `QUANTIDADE` int(10) NOT NULL DEFAULT '0',
  `VALOR` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela loja.produtos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` (`ID`, `NOME`, `QUANTIDADE`, `VALOR`) VALUES
	(1, 'livro', 25, 25.69),
	(2, 'mesa', 25, 35.90),
	(3, '007 Golden Eye Reloaded', 54, 152.90),
	(4, '007 James Bond - Blood Stone', 82, 114.90),
	(5, '007 Legends', 40, 171.90),
	(6, '007 Quantum of Solace', 76, 192.90),
	(7, '11 Eyes - Cross Over (JPN)', 90, 134.90),
	(8, '50 Cent: Blood on the Sands', 77, 140.90),
	(9, 'A-Train HX', 43, 187.90),
	(10, 'A grande aventura de Snoopy', 61, 171.90),
	(11, 'Absolute - Blazing Infinity (JPN)', 26, 176.90),
	(12, 'Ace Combat - Assault Horizon', 30, 117.90),
	(13, 'Ace Combat 6 - Fires of Liberation', 56, 118.90),
	(14, 'Adidas MiCoach (2 DVDs) (Kinect)', 36, 155.90),
	(15, 'Adrenalin Misfits (Kinect)', 74, 196.90),
	(16, 'Adventure Time - As investigações de Finn e Jake (Hora de Aventura)', 14, 125.90),
	(17, 'Adventure Time - Explore the Dungeon Because I don`t Know (Hora de Aventura)', 30, 166.90),
	(18, 'Adventure Time - The Secret of the Nameless Kingdom (Hora de Aventura)', 76, 169.90),
	(19, 'AFL Live', 67, 124.90),
	(20, 'AFL Live 2', 31, 147.90),
	(21, 'Afro Samurai', 16, 173.90),
	(22, 'Air Conflicts: Pacific Carrier', 55, 176.90),
	(23, 'Air Conflicts: Secret Wars', 31, 173.90),
	(24, 'Air Conflicts: Vietnam', 64, 181.90),
	(25, 'Akai Katana', 66, 192.90),
	(26, 'Akatsuki-no Amaneka to Aoi Kyojin', 74, 162.90),
	(27, 'Alan Wake', 99, 173.90),
	(28, 'Alarm für Cobra 11 - Burning Wheels', 76, 154.90),
	(29, 'Alarm für Cobra 11 - Crash Time', 48, 124.90),
	(30, 'Alarm für Cobra 11 - Highway Nights', 33, 177.90),
	(31, 'Alice: Madness Returns', 41, 198.90),
	(32, 'Alien Isolation (Dublado)', 57, 138.90),
	(33, 'Alien Vs Predator', 72, 198.90),
	(34, 'Aliens: Colonial Marines', 22, 199.90),
	(35, 'All-Pro Football 2K8', 53, 146.90),
	(36, 'Alone in the Dark', 66, 110.90),
	(37, 'Alpha Protocol', 58, 112.90),
	(38, 'Alvin and the Chipmunks – Chipwrecked (Kinect)', 98, 128.90),
	(39, 'Americas Army - True Soldiers', 31, 103.90),
	(40, 'Amped 3', 90, 103.90),
	(41, 'Anarchy Reigns (Max Anarchy)', 69, 179.90),
	(42, 'Angry Birds Star Wars (Controle ou Kinect)', 40, 161.90),
	(43, 'Angry Birds Trilogy (Controle ou Kinect)', 54, 198.90),
	(44, 'Apache: Air Assault', 45, 154.90),
	(45, 'AquaZone - Life Simulator', 94, 173.90),
	(46, 'Arcana Heart 3', 41, 178.90),
	(47, 'Arcania - The Complete Tale', 61, 107.90),
	(48, 'Armored Core - For Answer', 82, 161.90),
	(49, 'Armored Core 4', 55, 176.90),
	(50, 'Armored Core V', 93, 187.90),
	(51, 'Armored Core Verdict Day', 58, 187.90),
	(52, 'Army of Two', 55, 101.90),
	(53, 'Army of Two The 40th Day', 41, 166.90),
	(54, 'Army of Two: Devil`s Cartel', 79, 179.90),
	(55, 'As Aventuras de Tintin', 54, 158.90),
	(56, 'Ashes Cricket 2009', 20, 151.90),
	(57, 'Assassin`s Creed', 24, 107.90),
	(58, 'Assassin`s Creed II', 74, 176.90),
	(59, 'Assassin`s Creed III (Dublado)', 12, 110.90),
	(60, 'Assassin`s Creed 4 Black Flag (Dublado) (2 DVDs)', 47, 136.90),
	(61, 'Assassin`s Creed Brotherhood', 22, 128.90),
	(62, 'Assassin`s Creed Revelations', 21, 182.90),
	(63, 'Assassin`s Creed Rogue (Dublado)', 35, 195.90),
	(64, 'Asterix at the Olympic Games', 13, 130.90),
	(65, 'Asura’s Wrath', 62, 164.90),
	(66, 'Attack of the Movie 3D', 37, 128.90),
	(67, 'Autobahn Polizei', 33, 147.90),
	(68, 'Avatar - The Last Airbender - The Burning Earth', 50, 102.90),
	(69, 'Avatar The Game', 46, 102.90),
	(70, 'Back to the Future: The Game 30th Anniversary Ed. (De volta para o Futuro)', 91, 137.90),
	(71, 'Backyard Football `10', 77, 147.90),
	(72, 'Backyard Sports - Rookie Rush', 20, 120.90),
	(73, 'Backyard Sports - Sandlot Sluggers', 43, 114.90),
	(74, 'Baja - Edge of Control', 47, 152.90),
	(75, 'Bakugan - Battle Brawlers', 96, 114.90),
	(76, 'Bakugan - Defender of the Core', 81, 140.90),
	(77, 'BandFuse - Rock Legends (Precisa de controle especial)', 61, 134.90),
	(78, 'Banjo-Kazooie - Nuts & Bolts', 15, 110.90),
	(79, 'Barbie e suas irmãs - Resgate de Cachorrinhos', 94, 173.90),
	(80, 'Bass Pro Shops - The Hunt', 44, 180.90),
	(81, 'Bass Pro Shops - The Strike', 70, 190.90),
	(82, 'Batman: Arkham Asilum', 23, 152.90),
	(83, 'Batman: Arkham City', 47, 127.90),
	(84, 'Batman: Arkham Origins (Dublado)', 39, 130.90),
	(85, 'Battle Fantasia', 88, 126.90),
	(86, 'Battle vs Chess', 35, 119.90),
	(87, 'Battlefield - Bad Company', 65, 107.90),
	(88, 'Battlefield - Bad Company 2', 60, 153.90),
	(89, 'Battlefield 2 - Modern Combat', 61, 143.90),
	(90, 'Battlefield 3', 61, 144.90),
	(91, 'Battlefield 4 (Dublado)', 92, 131.90),
	(92, 'Battlefield Hardline (Dublado) (10,8GB)', 10, 164.90),
	(93, 'Battleship', 97, 188.90),
	(94, 'Battlestations - Midway', 16, 137.90),
	(95, 'Battlestations - Pacific', 58, 179.90),
	(96, 'Bayonetta', 79, 181.90),
	(97, 'Beautiful Katamari', 22, 188.90),
	(98, 'Bee Movie Game (A História de uma Abelha)', 38, 186.90),
	(99, 'Beijing 2008 - The Official Video Game of the Olympic Games', 17, 125.90),
	(100, 'Ben 10 - Alien Force - Vilgax Attacks', 29, 135.90),
	(101, 'Ben 10 - Galactic Racing', 68, 146.90),
	(102, 'Ben 10 - Omniverse', 35, 119.90);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
