-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 09 juin 2021 à 08:36
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gostyle_bdd`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prix` int(11) NOT NULL,
  `qrcode_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `t_article_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id`, `name`, `prix`, `qrcode_id`, `t_article_id`) VALUES
(1, 'gg', 14000, NULL, 2),
(2, 'Mini Shirt', 10, NULL, NULL),
(4, 'Minisy Shirt', 10000, 'A15CFGH', NULL),
(5, 'Hello', 20000, '5ASDX', 1),
(6, 'HI', 20000, NULL, 2),
(7, 'GG', 20000, NULL, 1),
(8, 'GGWP', 20000, NULL, 2),
(9, 'HELK', 20000, NULL, 2),
(10, 'Testbdd', 14500, NULL, 2);

-- --------------------------------------------------------

--
-- Structure de la table `qrcode`
--

CREATE TABLE `qrcode` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `reduction` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `qrcode`
--

INSERT INTO `qrcode` (`id`, `reduction`) VALUES
('5', 26),
('5ASDX', 26),
('A15CFGH', 25);

-- --------------------------------------------------------

--
-- Structure de la table `type_article`
--

CREATE TABLE `type_article` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `type_article`
--

INSERT INTO `type_article` (`id`, `libelle`) VALUES
(1, 'Jean'),
(2, 'Short');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `login` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`login`, `password`) VALUES
('kanty', 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK30ht8orfcjhpx2h6k6intshrc` (`qrcode_id`),
  ADD KEY `FKbfyx5yhbm2k64sxucgvleaf85` (`t_article_id`);

--
-- Index pour la table `qrcode`
--
ALTER TABLE `qrcode`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `type_article`
--
ALTER TABLE `type_article`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`login`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `FK30ht8orfcjhpx2h6k6intshrc` FOREIGN KEY (`qrcode_id`) REFERENCES `qrcode` (`id`),
  ADD CONSTRAINT `FKbfyx5yhbm2k64sxucgvleaf85` FOREIGN KEY (`t_article_id`) REFERENCES `type_article` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
