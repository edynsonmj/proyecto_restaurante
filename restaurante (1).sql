-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-10-2020 a las 05:41:06
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.3.22

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menuespecial`
--

CREATE TABLE `menuespecial` (
  `MESP_ID` int(10) NOT NULL,
  `RES_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platodia`
--

CREATE TABLE `platodia` (
  `PDIA_ID` int(10) NOT NULL,
  `MDIA_ID` int(10) NOT NULL,
  `PDIA_NOMBRE` int(40) NOT NULL,
  `PDIA_DESCRIPCION` char(100) NOT NULL,
  `PDIA_ENTRADA` varchar(100) NOT NULL,
  `PDIA_PRINCIPIO` varchar(100) NOT NULL,
  `PDIA_BEBIDA` varchar(100) NOT NULL,
  `PDIA_CARNE` varchar(100) NOT NULL,
  `PDIA_PRECIO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platoespecial`
--

CREATE TABLE `platoespecial` (
  `PESP_ID` int(10) NOT NULL,
  `MESP_ID` int(10) NOT NULL,
  `PESP_NOMBRE` char(20) NOT NULL,
  `PESP_DESCRIPCION` char(90) NOT NULL,
  `PESP_PRECIO` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

INSERT INTO `restaurante` (`RES_ID`, `RES_NOMBRE`) VALUES
(2, 'primero'),
(3, 'primero'),
(4, 'primero');

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
