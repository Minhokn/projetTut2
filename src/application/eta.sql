-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 22 Juin 2017 à 13:49
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `eta`
--

-- --------------------------------------------------------

--
-- Structure de la table `agriculteur`
--

CREATE TABLE `agriculteur` (
  `ID_CL` int(6) NOT NULL,
  `Nom_Cl` varchar(50) NOT NULL,
  `Prénom_CL` varchar(50) NOT NULL,
  `Tel_Cl` varchar(11) NOT NULL,
  `Adr_Cl` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `agriculteur`
--

INSERT INTO `agriculteur` (`ID_CL`, `Nom_Cl`, `Prénom_CL`, `Tel_Cl`, `Adr_Cl`) VALUES
(1, 'Dujardin', 'Jean', '278421952', 'La Couesnerie, Esse'),
(2, 'Dutronc', 'Thomas', '285426985', 'La Berhaudière, Brie'),
(3, 'Mathy', 'Mimie', '250481268', 'La Tremblais, La Couyère');

-- --------------------------------------------------------

--
-- Structure de la table `botteleuse`
--

CREATE TABLE `botteleuse` (
  `ID_Bot` int(6) NOT NULL,
  `ID_Mach` smallint(6) NOT NULL,
  `Type_Bot` varchar(50) NOT NULL,
  `Atr` smallint(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `botteleuse`
--

INSERT INTO `botteleuse` (`ID_Bot`, `ID_Mach`, `Type_Bot`, `Atr`) VALUES
(1, 27, 'Ronde', NULL),
(2, 28, 'Ronde', NULL),
(3, 29, 'Carré', NULL),
(4, 30, 'Carré', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `champs`
--

CREATE TABLE `champs` (
  `ID_Ch` int(6) NOT NULL,
  `ID_CL` smallint(6) DEFAULT NULL,
  `Surf_Ch` int(11) NOT NULL,
  `Cdn_Ch` varchar(100) NOT NULL,
  `Adr_Ch` varchar(100) NOT NULL,
  `Cult_Ch` varchar(50) NOT NULL,
  `Etat` int(11) NOT NULL,
  `GPS_Ch` varchar(1000) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `champs`
--

INSERT INTO `champs` (`ID_Ch`, `ID_CL`, `Surf_Ch`, `Cdn_Ch`, `Adr_Ch`, `Cult_Ch`, `Etat`, `GPS_Ch`) VALUES
(1, 3, 56800, '47.980005 , -1.4934', 'Le Paveil, Amanlis', 'Blé', 0, '[[47.9792325,-1.4950258],[47.9789237,-1.4936632],[47.9791607,-1.4934593],[47.9791284,-1.4922577],[47.9791859,-1.4919573],[47.9815666,-1.4923677],[47.9815684,-1.4928934],[47.9816079,-1.4930624],[47.9816348,-1.4933681],[47.9815989,-1.4938188],[47.9815989,-1.4942721],[47.9816312,-1.4946851],[47.9805684,-1.4949238]]'),
(2, 2, 84600, '47.937 , -1.516623', '277 La Lanceule, Janzé', 'Orge', 0, '[[47.9373919,-1.518538],[47.9372733,-1.5181518],[47.937356,-1.518082],[47.9371763,-1.5174329],[47.9363856,-1.5180016],[47.9361376,-1.5180284],[47.9362383,-1.5170467],[47.9371619,-1.5118217],[47.9373164,-1.5110278],[47.9382221,-1.5115374],[47.9381179,-1.5123636],[47.9382401,-1.5179425],[47.9381861,-1.5181142]]'),
(3, 1, 52000, '47.921181 , -1.51282', 'Garmeaux, Janzé', 'Colza', 0, '[[47.9219289,-1.5161884],[47.9206383,-1.51658],[47.920854,-1.5113872],[47.9221086,-1.5114999]]'),
(4, 4, 63000, '47.962952 , -1.581098', 'Voie de la Liberté, Corps-Nuds', 'Triticale', 0, '[[47.9632612,-1.5836191],[47.9629522,-1.5835494],[47.9628409,-1.5833455],[47.962963,-1.582852],[47.9626828,-1.5827394],[47.9626002,-1.5830237],[47.9626936,-1.5831363],[47.9624781,-1.5836459],[47.9619931,-1.5833884],[47.962047,-1.5831685],[47.9619249,-1.5829164],[47.9617166,-1.5828359],[47.9611921,-1.5818971],[47.9611023,-1.581232],[47.9607574,-1.5801859],[47.9605958,-1.579805],[47.961052,-1.5797782],[47.9609873,-1.5794349],[47.9627295,-1.5794188],[47.9630923,-1.5795475],[47.963042,-1.5822136],[47.9634264,-1.5822512]]'),
(5, 3, 74000, '47.898096 , -1.515888', 'Le Plessy, La Couyère', 'Colza', 0, '[[47.8989378,-1.5168804],[47.8982688,-1.5170681],[47.8978768,-1.5174222],[47.8976125,-1.5179265],[47.897233,-1.5185755],[47.897064,-1.5186185],[47.8962979,-1.5187311],[47.896208,-1.5181679],[47.8970028,-1.5178782],[47.8969525,-1.5175617],[47.8962224,-1.5162474],[47.8964274,-1.5157914],[47.8964561,-1.5155447],[47.8963267,-1.5147722],[47.8965784,-1.514622],[47.8965065,-1.5142733],[47.8979631,-1.5135866],[47.8983084,-1.5138012],[47.8985062,-1.5142035],[47.8986285,-1.5146327]]'),
(6, 4, 100000, '47.888672,-1.574167', 'La Chesnais, Tresboeuf', 'Blé', 0, '[[47.8879529,-1.5751112],[47.8881471,-1.574285],[47.8884493,-1.573813],[47.8896507,-1.5728366],[47.8903414,-1.5725362],[47.8904709,-1.5726864],[47.8926651,-1.5717101],[47.8929241,-1.5724826],[47.8929025,-1.5731692],[47.8922406,-1.5732658],[47.8923485,-1.5740061],[47.8907515,-1.5743279],[47.8908738,-1.5763986],[47.8884421,-1.5765274]]'),
(7, 2, 21200, '47.89869, -1.49919', 'La Tremblias, Tresboeuf', 'Colza', 0, '[[47.899168,-1.5000737],[47.8988641,-1.5002078],[47.8987957,-1.5001327],[47.8983372,-1.4985931],[47.8983444,-1.4984187],[47.898267,-1.4983812],[47.8980297,-1.4978287],[47.8977437,-1.4971796],[47.8975387,-1.4961818],[47.8976215,-1.4961469],[47.8974236,-1.4951304],[47.8974362,-1.4950392],[47.8978157,-1.4948514],[47.8979631,-1.4953128],[47.8980387,-1.4956453],[47.8981951,-1.4966512],[47.8983246,-1.4973995],[47.8984469,-1.4978367],[47.8986717,-1.4983195],[47.8988874,-1.4987594],[47.8990457,-1.4992234],[47.8991716,-1.4998752]]'),
(8, 1, 8000, '48.005418 , -1.484748', 'Le Béziers, Amanlis', 'Orge', 0, '[[48.0058023,-1.4857882],[48.0050521,-1.4850157],[48.005411,-1.4839643],[48.0061109,-1.4845383],[48.0059351,-1.4850211],[48.0059745,-1.4851928],[48.0059674,-1.4853376],[48.0059458,-1.4854556]]'),
(9, 4, 255000, '47.895899 , -1.54381', 'La Peltrie, Tresboeuf', 'Triticale', 0, '[[47.8940823,-1.5431499],[47.8948304,-1.5429997],[47.8956792,-1.5426028],[47.8964346,-1.5422058],[47.8970388,-1.5419161],[47.8975711,-1.5414977],[47.897938,-1.5413582],[47.8982113,-1.5426564],[47.8989018,-1.5423131],[47.8985997,-1.5411007],[47.8995276,-1.5408969],[47.9001894,-1.5405214],[47.9005059,-1.5403497],[47.9007792,-1.5415192],[47.900995,-1.5426135],[47.9011172,-1.5432358],[47.901405,-1.5437293],[47.9013402,-1.5438581],[47.9012683,-1.5442657],[47.9014697,-1.5447056],[47.9008871,-1.545006],[47.8998873,-1.5455317],[47.8991824,-1.545639],[47.8981897,-1.546433],[47.89701,-1.5469694],[47.8965568,-1.5469909],[47.895298,-1.5472591],[47.8950606,-1.5472054],[47.8945499,-1.5462399],[47.8943916,-1.5461433]]'),
(10, 1, 69000, '48.029139 , -1.482889', '16 Les Réhardières, Amanlis', 'Orge', 0, '[[48.0300875,-1.4802146],[48.0303655,-1.4819634],[48.0296086,-1.4824918],[48.0297108,-1.4828995],[48.0296319,-1.4829478],[48.0296337,-1.4830282],[48.0295512,-1.4830765],[48.0296265,-1.4834198],[48.029562,-1.4834896],[48.0292355,-1.4836934],[48.0292624,-1.483798],[48.0274399,-1.4849675],[48.0276408,-1.4856219],[48.0264928,-1.4865339],[48.026134,-1.4853001],[48.028301,-1.4838302],[48.0278274,-1.4816523]]'),
(11, 4, 36000, '48.015761 , -1.381901', 'Les Clos Neuf, Moulins', 'Blé', 0, '[[48.0158184,-1.3825661],[48.0153591,-1.3824937],[48.0154901,-1.3812974],[48.0156121,-1.3801977],[48.0164733,-1.3803157],[48.0166581,-1.3794842],[48.0156767,-1.3791865],[48.0157556,-1.3783041],[48.0166061,-1.3782316],[48.0172251,-1.3783041],[48.0161486,-1.3822281]]'),
(12, 2, 38000, '47.958099 , -1.373017', 'Les Prés, Marcillé-robert', 'Blé', 0, '[[47.958329,-1.3698739],[47.9586524,-1.3704962],[47.9589002,-1.3714135],[47.958929,-1.3726419],[47.958717,-1.373409],[47.9577758,-1.373747],[47.9573124,-1.3736182],[47.9572765,-1.3734788],[47.9574417,-1.3730067],[47.9574848,-1.3726795],[47.9574094,-1.3722503],[47.957298,-1.3718748],[47.957201,-1.3716227],[47.9572154,-1.3713008],[47.9572944,-1.3711077]]'),
(13, 3, 156000, '48.009036 , -1.365378', '1 Fougeray, Moulins', 'Triticale', 0, '[[48.0114296,-1.3632488],[48.0109811,-1.3640052],[48.009908,-1.3650084],[48.009969,-1.3653088],[48.0083935,-1.3663065],[48.0083863,-1.3666713],[48.0062545,-1.3674223],[48.0059315,-1.3671434],[48.0056659,-1.3668108],[48.0052998,-1.3652551],[48.0051634,-1.3628411],[48.0052352,-1.36253],[48.0059817,-1.3627553]]'),
(14, 1, 45000, '47.974302 , -1.60762', 'Velobert, Corps-Nuds', 'Blé', 0, '[[47.9746934,-1.6116643],[47.9744815,-1.6116536],[47.9741942,-1.6116214],[47.973871,-1.6115087],[47.9735514,-1.6114336],[47.9734544,-1.6114336],[47.9734257,-1.6112834],[47.9734867,-1.610806],[47.9739069,-1.6086656],[47.9741332,-1.6076785],[47.9743594,-1.6067988],[47.9745533,-1.6071689],[47.9748981,-1.607582],[47.975268,-1.6076571],[47.975171,-1.6081399],[47.975171,-1.6083759],[47.9752608,-1.6088158]]');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `ID_Com` int(6) NOT NULL,
  `Date_Com` date DEFAULT NULL,
  `Bott_Com` varchar(50) DEFAULT NULL,
  `Trans_Rec` varchar(50) NOT NULL,
  `Taille_Max` float DEFAULT NULL,
  `Tonnes_Rec` float DEFAULT NULL,
  `Cout_Com` float DEFAULT NULL,
  `rav_Com` varchar(50) DEFAULT NULL,
  `esc_Com` varchar(50) DEFAULT NULL,
  `ID_Ch` smallint(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`ID_Com`, `Date_Com`, `Bott_Com`, `Trans_Rec`, `Taille_Max`, `Tonnes_Rec`, `Cout_Com`, `ID_Ch`) VALUES
(1, '2018-01-01', 'New-holland', 'Lui', NULL, NULL, NULL, 1),
(2, '2018-01-01', NULL, 'ETA', NULL, NULL, NULL, 2),
(3, '2018-01-02', 'New-holland', 'Lui', 5.36, NULL, NULL, 3),
(4, '2018-01-03', NULL, 'Négociant', NULL, NULL, NULL, 4),
(5, '2018-01-04', 'New-holland', 'ETA', 6, NULL, NULL, 5),
(6, '2018-01-01', 'New-holland', 'Négociant', NULL, NULL, NULL, 6),
(7, '2018-01-02', NULL, 'ETA', 14, NULL, NULL, 7),
(8, '2018-01-04', 'New-holland', 'ETA', NULL, NULL, NULL, 8),
(9, '2018-01-03', NULL, 'Lui', NULL, NULL, NULL, 9),
(10, '2018-01-04', NULL, 'Négociant', 9.1, NULL, NULL, 10),
(11, '2018-01-01', 'New-holland', 'ETA', NULL, NULL, NULL, 11),
(12, '2018-01-03', 'New-holland', 'Négociant', 3.7, NULL, NULL, 12),
(13, '2018-01-02', NULL, 'Lui', NULL, NULL, NULL, 13),
(14, '2018-01-03', 'New-holland', 'ETA', 9, NULL, NULL, 14);

-- --------------------------------------------------------

--
-- Structure de la table `contenir`
--

CREATE TABLE `contenir` (
  `ID_Cont` int(6) NOT NULL,
  `N_Ordre` smallint(6) DEFAULT NULL,
  `H_A` varchar(50) DEFAULT NULL,
  `Duree` int(11) DEFAULT NULL,
  `Dist` int(11) DEFAULT NULL,
  `ID_Mach` smallint(6) NOT NULL,
  `ID_Com` smallint(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contenir`
--

INSERT INTO `contenir` (`ID_Cont`, `N_Ordre`, `H_A`, `Duree`, `Dist`, `ID_Mach`, `ID_Com`) VALUES
(1, 1, NULL, NULL, NULL, 1, 1),
(2, 1, NULL, NULL, NULL, 10, 1),
(3, 1, NULL, NULL, NULL, 11, 1),
(4, 1, NULL, NULL, NULL, 29, 1),
(5, 2, NULL, NULL, NULL, 7, 2),
(6, 3, NULL, NULL, NULL, 2, 3),
(7, 3, NULL, NULL, NULL, 12, 3),
(8, 3, NULL, NULL, NULL, 13, 3),
(9, 3, NULL, NULL, NULL, 17, 3),
(10, 4, NULL, NULL, NULL, 4, 4),
(11, 5, NULL, NULL, NULL, 6, 5),
(12, 5, NULL, NULL, NULL, 2, 5),
(13, 5, NULL, NULL, NULL, 14, 5),
(14, 5, NULL, NULL, NULL, 15, 5),
(15, 5, NULL, NULL, NULL, 16, 5),
(16, 5, NULL, NULL, NULL, 29, 5),
(17, 6, NULL, NULL, NULL, 9, 6),
(18, 6, NULL, NULL, NULL, 17, 6),
(19, 6, NULL, NULL, NULL, 18, 6),
(20, 6, NULL, NULL, NULL, 30, 6),
(21, 7, NULL, NULL, NULL, 1, 7),
(22, 8, NULL, NULL, NULL, 8, 8),
(23, 8, NULL, NULL, NULL, 19, 8),
(24, 8, NULL, NULL, NULL, 20, 8),
(25, 8, NULL, NULL, NULL, 27, 8),
(26, 9, NULL, NULL, NULL, 6, 9),
(27, 10, NULL, NULL, NULL, 5, 10),
(28, 11, NULL, NULL, NULL, 3, 11),
(29, 11, NULL, NULL, NULL, 21, 11),
(30, 11, NULL, NULL, NULL, 22, 11),
(31, 11, NULL, NULL, NULL, 28, 11),
(32, 12, NULL, NULL, NULL, 7, 12),
(33, 12, NULL, NULL, NULL, 23, 12),
(34, 12, NULL, NULL, NULL, 24, 12),
(35, 12, NULL, NULL, NULL, 28, 12),
(36, 13, NULL, NULL, NULL, 2, 13),
(37, 13, NULL, NULL, NULL, 5, 13),
(38, 14, NULL, NULL, NULL, 4, 14),
(39, 14, NULL, NULL, NULL, 25, 14),
(40, 14, NULL, NULL, NULL, 26, 14),
(41, 14, NULL, NULL, NULL, 30, 14);

-- --------------------------------------------------------

--
-- Structure de la table `coop`
--

CREATE TABLE `coop` (
  `ID_Co` int(6) NOT NULL,
  `Nom_Co` varchar(50) NOT NULL,
  `Adr_CO` varchar(100) NOT NULL,
  `Tel_Co` varchar(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `coop`
--

INSERT INTO `coop` (`ID_Co`, `Nom_Co`, `Adr_CO`, `Tel_Co`) VALUES
(1, 'Terdici', '1750 Rue Louis Blériot, Janzé', '299445381'),
(2, '', '0707070707', 'bidule'),
(3, '', '07', '4');

-- --------------------------------------------------------

--
-- Structure de la table `culture`
--

CREATE TABLE `culture` (
  `ID_Cult` int(6) NOT NULL,
  `Type_Cult` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `culture`
--

INSERT INTO `culture` (`ID_Cult`, `Type_Cult`) VALUES
(1, 'Orge'),
(2, 'Blé'),
(3, 'Colza'),
(4, 'Triticale');

-- --------------------------------------------------------

--
-- Structure de la table `moissonner`
--

CREATE TABLE `moissonner` (
  `ID_M` int(6) NOT NULL,
  `ID_Moi` smallint(6) DEFAULT NULL,
  `Vitesse_Moi` float DEFAULT NULL,
  `ID_Cult` smallint(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `moissonner`
--

INSERT INTO `moissonner` (`ID_M`, `ID_Moi`, `Vitesse_Moi`, `ID_Cult`) VALUES
(1, 1, 3.5, 1),
(2, 2, 3, 1),
(3, 3, 2.9, 1),
(4, 4, 3.1, 1),
(5, 5, 3, 1),
(6, 6, 2.9, 1),
(7, 7, 2.8, 1),
(8, 8, 3.4, 1),
(9, 9, 3.3, 1),
(10, 1, 4, 2),
(11, 2, 3, 2),
(12, 3, 3.5, 2),
(13, 4, 3, 2),
(14, 5, 3.2, 2),
(15, 6, 3, 2),
(16, 7, 3, 2),
(17, 8, 3.8, 2),
(18, 9, 3.7, 2),
(19, 1, 3.5, 3),
(20, 2, 2, 3),
(21, 3, 4, 3),
(22, 4, 2.6, 3),
(23, 5, 3.5, 3),
(24, 6, 2.2, 3),
(25, 7, 3.5, 3),
(26, 8, 2, 3),
(27, 9, 3.4, 3),
(28, 1, 4, 4),
(29, 2, 3, 4),
(30, 3, 2.9, 4),
(31, 4, 3.1, 4),
(32, 5, 2.9, 4),
(33, 6, 2, 4),
(34, 7, 4, 4),
(35, 8, 3, 4),
(36, 9, 3.5, 4);

-- --------------------------------------------------------

--
-- Structure de la table `moissonneuses`
--

CREATE TABLE `moissonneuses` (
  `ID_Moi` int(6) NOT NULL,
  `ID_Mach` smallint(6) NOT NULL,
  `Taille_T_Moi` int(11) NOT NULL,
  `Taille_R_Moi` int(11) NOT NULL,
  `Large_Moi` varchar(50) NOT NULL,
  `Hauteur_Moi` varchar(1000) NOT NULL,
  `Large_C_Moi` float NOT NULL,
  `Cons_F_Moi` int(11) NOT NULL,
  `Cons_R_Moi` int(11) NOT NULL,
  `Poids_Moi` float NOT NULL,
  `Etat_Moi` smallint(6) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `moissonneuses`
--

INSERT INTO `moissonneuses` (`ID_Moi`, `ID_Mach`, `Taille_T_Moi`, `Taille_R_Moi`, `Large_Moi`, `Hauteur_Moi`, `Large_C_Moi`, `Cons_F_Moi`, `Cons_R_Moi`, `Poids_Moi`, `Etat_Moi`) VALUES
(1, 1, 11500, 1000, '3.84', '3.96', 9.15, 45, 10, 19.4, 1),
(2, 2, 7500, 580, '3.44', '3.98', 5.18, 25, 8, 15.9, 1),
(3, 3, 7600, 500, '3.48', '3.92', 5.18, 30, 8, 14.4, 1),
(4, 4, 9000, 750, '3.44', '3.92', 6.1, 22, 9, 14.7, 1),
(5, 5, 9000, 750, '3.67', '3.92', 6.1, 25, 9, 15.4, 0),
(6, 6, 8000, 450, '3.44', '3.98', 5.49, 26, 8, 16, 1),
(7, 7, 4000, 300, '2.96', '3.85', 3.66, 29, 9, 17.5, 1),
(8, 8, 9500, 600, '3.95', '3.45', 5.18, 20, 8, 15, 0),
(9, 9, 7200, 450, '3.92', '3.9', 5.18, 30, 8, 18.5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `tracteurs`
--

CREATE TABLE `tracteurs` (
  `ID_Trac` int(6) NOT NULL,
  `ID_Mach` smallint(6) NOT NULL,
  `Capacité_Trac` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tracteurs`
--

INSERT INTO `tracteurs` (`ID_Trac`, `ID_Mach`, `Capacité_Trac`) VALUES
(1, 10, 11000),
(2, 11, 13000),
(3, 12, 11000),
(4, 13, 14000),
(5, 14, 12000),
(6, 15, 12000),
(7, 16, 14000),
(8, 17, 18000),
(9, 18, 20000),
(10, 19, 21000),
(11, 20, 15000),
(12, 21, 17000),
(13, 22, 18000),
(14, 23, 20000),
(15, 24, 23000),
(16, 25, 24000),
(17, 26, 30000);

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `ID_Mach` int(6) NOT NULL,
  `Marque` varchar(50) NOT NULL,
  `Modèle` varchar(50) NOT NULL,
  `Etat` int(11) NOT NULL,
  `Atr` smallint(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `vehicule`
--

INSERT INTO `vehicule` (`ID_Mach`, `Marque`, `Modèle`, `Etat`, `Atr`) VALUES
(1, 'New-holland', 'CR 9080', 1, NULL),
(2, 'New-holland', 'CSX 7060', 1, NULL),
(3, 'New-holland', 'CX 720', 1, NULL),
(4, 'New-holland', 'CX 8050', 1, NULL),
(5, 'New-holland', 'CX 8070', 0, NULL),
(6, 'New-holland', 'CX 5090', 1, NULL),
(7, 'New-holland', 'TC 5050', 1, NULL),
(8, 'New-holland', 'TX 68 SL', 0, NULL),
(9, 'New-holland', 'TX 64 SL', 1, NULL),
(10, 'FENDT', '311', 1, NULL),
(11, 'FENDT', '313', 1, NULL),
(12, 'FENDT', '411', 1, NULL),
(13, 'FENDT', '414', 1, NULL),
(14, 'FENDT', '512', 1, NULL),
(15, 'FENDT', '712', 1, NULL),
(16, 'FENDT', '714', 1, NULL),
(17, 'FENDT', '718', 1, NULL),
(18, 'FENDT', '720', 1, NULL),
(19, 'FENDT', '722', 1, NULL),
(20, 'FENDT', '815', 1, NULL),
(21, 'FENDT', '817', 0, NULL),
(22, 'FENDT', '818', 1, NULL),
(23, 'FENDT', '820', 1, NULL),
(24, 'FENDT', '826', 1, NULL),
(25, 'FENDT', '927', 1, NULL),
(26, 'FENDT', '939', 1, NULL),
(27, 'New-holland', 'BR 750 A', 1, NULL),
(28, 'New-holland', 'ROLL BELT 180 ELITE', 1, NULL),
(29, 'New-holland', 'BB 960 S', 1, NULL),
(30, 'New-holland', 'BB 1270', 1, NULL);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agriculteur`
--
ALTER TABLE `agriculteur`
  ADD PRIMARY KEY (`ID_CL`),
  ADD UNIQUE KEY `ID_CL` (`ID_CL`);

--
-- Index pour la table `botteleuse`
--
ALTER TABLE `botteleuse`
  ADD PRIMARY KEY (`ID_Bot`),
  ADD KEY `cle_etrangere_bot` (`Atr`);

--
-- Index pour la table `champs`
--
ALTER TABLE `champs`
  ADD PRIMARY KEY (`ID_Ch`),
  ADD UNIQUE KEY `ID_Ch` (`ID_Ch`),
  ADD KEY `cle_etrangere_champs` (`ID_CL`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`ID_Com`),
  ADD UNIQUE KEY `ID_Ch` (`ID_Ch`);

--
-- Index pour la table `contenir`
--
ALTER TABLE `contenir`
  ADD PRIMARY KEY (`ID_Cont`),
  ADD KEY `cle_etrangere_contenir2` (`ID_Com`);

--
-- Index pour la table `coop`
--
ALTER TABLE `coop`
  ADD PRIMARY KEY (`ID_Co`);

--
-- Index pour la table `culture`
--
ALTER TABLE `culture`
  ADD PRIMARY KEY (`ID_Cult`),
  ADD UNIQUE KEY `ID_Cult` (`ID_Cult`);

--
-- Index pour la table `moissonner`
--
ALTER TABLE `moissonner`
  ADD PRIMARY KEY (`ID_M`),
  ADD KEY `cle_etrangere_moissonner` (`ID_Cult`);

--
-- Index pour la table `moissonneuses`
--
ALTER TABLE `moissonneuses`
  ADD PRIMARY KEY (`ID_Moi`);

--
-- Index pour la table `tracteurs`
--
ALTER TABLE `tracteurs`
  ADD PRIMARY KEY (`ID_Trac`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`ID_Mach`),
  ADD KEY `cle_etrangere_vehicule` (`Atr`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `agriculteur`
--
ALTER TABLE `agriculteur`
  MODIFY `ID_CL` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `botteleuse`
--
ALTER TABLE `botteleuse`
  MODIFY `ID_Bot` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `champs`
--
ALTER TABLE `champs`
  MODIFY `ID_Ch` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `ID_Com` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `contenir`
--
ALTER TABLE `contenir`
  MODIFY `ID_Cont` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT pour la table `coop`
--
ALTER TABLE `coop`
  MODIFY `ID_Co` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `culture`
--
ALTER TABLE `culture`
  MODIFY `ID_Cult` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `moissonner`
--
ALTER TABLE `moissonner`
  MODIFY `ID_M` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT pour la table `moissonneuses`
--
ALTER TABLE `moissonneuses`
  MODIFY `ID_Moi` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `tracteurs`
--
ALTER TABLE `tracteurs`
  MODIFY `ID_Trac` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `ID_Mach` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
