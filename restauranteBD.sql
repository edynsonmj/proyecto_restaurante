-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-10-2020 a las 11:30:29
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `restaurante`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menudia`
--

CREATE TABLE `menudia` (
  `MDIA_ID` int(10) NOT NULL,
  `RES_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `menudia`
--

INSERT INTO `menudia` (`MDIA_ID`, `RES_ID`) VALUES (1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menuespecial`
--

CREATE TABLE `menuespecial` (
  `MESP_ID` int(10) NOT NULL,
  `RES_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `menuespecial`
--

INSERT INTO `menuespecial` (`MESP_ID`, `RES_ID`) VALUES (1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platodia`
--

CREATE TABLE `platodia` (
  `PDIA_ID` int(10) NOT NULL,
  `MDIA_ID` int(10) NOT NULL,
  `PDIA_NOMBRE` varchar(100) NOT NULL,
  `PDIA_DESCRIPCION` varchar(100) NOT NULL,
  `PDIA_DIA` varchar(100) NOT NULL,
  `PDIA_ENTRADA` varchar(100) NOT NULL,
  `PDIA_PRINCIPIO` varchar(100) NOT NULL,
  `PDIA_BEBIDA` varchar(100) NOT NULL,
  `PDIA_CARNE` varchar(100) NOT NULL,
  `PDIA_PRECIO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `platodia`
--

INSERT INTO `platodia` (`PDIA_ID`, `MDIA_ID`, `PDIA_NOMBRE`, `PDIA_DESCRIPCION`, `PDIA_DIA`, `PDIA_ENTRADA`, `PDIA_PRINCIPIO`, `PDIA_BEBIDA`, `PDIA_CARNE`, `PDIA_PRECIO`) VALUES
(98, 1, 'jdfkdf', 'kfkfd', 'Lunes', 'jgj', 'kyiy', 'iyiyt', 'kgg', 69),
(100, 1, 'kjdfjkdf', 'jgfjfd', 'Lunes', 'jgjf', 'jgfjgfjgf', 'kkdf', 'kgkg', 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platoespecial`
--

CREATE TABLE `platoespecial` (
  `PESP_ID` int(10) NOT NULL,
  `MESP_ID` int(10) NOT NULL,
  `PESP_NOMBRE` char(20) NOT NULL,
  `PESP_DESCRIPCION` varchar(90) NOT NULL,
  `PESP_PRECIO` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `platoespecial`
--

INSERT INTO `platoespecial` (`PESP_ID`, `MESP_ID`, `PESP_NOMBRE`, `PESP_DESCRIPCION`, `PESP_PRECIO`) VALUES
(69, 1, 'kgktgl', 'khkh', 5000),
(101, 1, 'jhonfer', 'fdjjdk', 8000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurante`
--

CREATE TABLE `restaurante` (
  `RES_ID` int(10) NOT NULL,
  `RES_NOMBRE` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `restaurante`
--

INSERT INTO `restaurante` (`RES_ID`, `RES_NOMBRE`) VALUES (1, 'theGalactics');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `menudia`
--
ALTER TABLE `menudia`
  ADD PRIMARY KEY (`MDIA_ID`),
  ADD KEY `MDIA_REL_RES_FK` (`RES_ID`);

--
-- Indices de la tabla `menuespecial`
--
ALTER TABLE `menuespecial`
  ADD PRIMARY KEY (`MESP_ID`),
  ADD KEY `MESP_REL_RES_FK` (`RES_ID`);

--
-- Indices de la tabla `platodia`
--
ALTER TABLE `platodia`
  ADD PRIMARY KEY (`PDIA_ID`),
  ADD KEY `MDIA_REL_PDIA_FK` (`MDIA_ID`);

--
-- Indices de la tabla `platoespecial`
--
ALTER TABLE `platoespecial`
  ADD PRIMARY KEY (`PESP_ID`),
  ADD KEY `MESP_REL_PESP_FK` (`MESP_ID`);

--
-- Indices de la tabla `restaurante`
--
ALTER TABLE `restaurante`
  ADD PRIMARY KEY (`RES_ID`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `menudia`
--
ALTER TABLE `menudia`
  ADD CONSTRAINT `FK_MENUDIA_MDIA_REL__RESTAURA` FOREIGN KEY (`RES_ID`) REFERENCES `restaurante` (`RES_ID`);

--
-- Filtros para la tabla `menuespecial`
--
ALTER TABLE `menuespecial`
  ADD CONSTRAINT `FK_MENUESPE_MESP_REL__RESTAURA` FOREIGN KEY (`RES_ID`) REFERENCES `restaurante` (`RES_ID`);

--
-- Filtros para la tabla `platodia`
--
ALTER TABLE `platodia`
  ADD CONSTRAINT `FK_PLATODIA_MDIA_REL__MENUDIA` FOREIGN KEY (`MDIA_ID`) REFERENCES `menudia` (`MDIA_ID`);

--
-- Filtros para la tabla `platoespecial`
--
ALTER TABLE `platoespecial`
  ADD CONSTRAINT `FK_PLATOESP_MESP_REL__MENUESPE` FOREIGN KEY (`MESP_ID`) REFERENCES `menuespecial` (`MESP_ID`);
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

