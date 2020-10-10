-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 10-10-2020 a las 18:43:42
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
-- Base de datos: `Proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `MENUDIA`
--

CREATE TABLE `MENUDIA` (
  `MDIA_ID` int(10) NOT NULL,
  `RES_ID` int(10) NOT NULL,
  `MDIA_DIASEMANA` varchar(9) NOT NULL CHECK (`MDIA_DIASEMANA` in ('Lunes','Martes','Miercoles','Jueves','Viernes','Sabado','Domingo'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `MENUESPECIAL`
--

CREATE TABLE `MENUESPECIAL` (
  `MESP_ID` int(10) NOT NULL,
  `RES_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PLATODIA`
--

CREATE TABLE `PLATODIA` (
  `PDIA_ID` int(10) NOT NULL,
  `MDIA_ID` int(10) NOT NULL,
  `PDIA_NOMBRE` int(40) NOT NULL,
  `PDIA_DESCRIPCION` char(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PLATOESPECIAL`
--

CREATE TABLE `PLATOESPECIAL` (
  `PESP_ID` int(10) NOT NULL,
  `MESP_ID` int(10) NOT NULL,
  `PESP_NOMBRE` char(20) NOT NULL,
  `PESP_DESCRIPCION` char(90) NOT NULL,
  `PESP_PRECIO` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `RACION`
--

CREATE TABLE `RACION` (
  `RAC_ID` int(10) NOT NULL,
  `PDIA_ID` int(10) NOT NULL,
  `RAC_NOMBRE` varchar(40) NOT NULL,
  `RAC_PRECIO` int(20) NOT NULL,
  `RAC_TIPO` char(9) NOT NULL CHECK (`RAC_TIPO` in ('Entrada','Principio','Carne','Bebida'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `RESTAURANTE`
--

CREATE TABLE `RESTAURANTE` (
  `RES_ID` int(10) NOT NULL,
  `RES_NOMBRE` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `MENUDIA`
--
ALTER TABLE `MENUDIA`
  ADD PRIMARY KEY (`MDIA_ID`),
  ADD KEY `MDIA_REL_RES_FK` (`RES_ID`);

--
-- Indices de la tabla `MENUESPECIAL`
--
ALTER TABLE `MENUESPECIAL`
  ADD PRIMARY KEY (`MESP_ID`),
  ADD KEY `MESP_REL_RES_FK` (`RES_ID`);

--
-- Indices de la tabla `PLATODIA`
--
ALTER TABLE `PLATODIA`
  ADD PRIMARY KEY (`PDIA_ID`),
  ADD KEY `MDIA_REL_PDIA_FK` (`MDIA_ID`);

--
-- Indices de la tabla `PLATOESPECIAL`
--
ALTER TABLE `PLATOESPECIAL`
  ADD PRIMARY KEY (`PESP_ID`),
  ADD KEY `MESP_REL_PESP_FK` (`MESP_ID`);

--
-- Indices de la tabla `RACION`
--
ALTER TABLE `RACION`
  ADD PRIMARY KEY (`RAC_ID`),
  ADD KEY `PDIA_REL_RAC_FK` (`PDIA_ID`);

--
-- Indices de la tabla `RESTAURANTE`
--
ALTER TABLE `RESTAURANTE`
  ADD PRIMARY KEY (`RES_ID`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `MENUDIA`
--
ALTER TABLE `MENUDIA`
  ADD CONSTRAINT `FK_MENUDIA_MDIA_REL__RESTAURA` FOREIGN KEY (`RES_ID`) REFERENCES `RESTAURANTE` (`RES_ID`);

--
-- Filtros para la tabla `MENUESPECIAL`
--
ALTER TABLE `MENUESPECIAL`
  ADD CONSTRAINT `FK_MENUESPE_MESP_REL__RESTAURA` FOREIGN KEY (`RES_ID`) REFERENCES `RESTAURANTE` (`RES_ID`);

--
-- Filtros para la tabla `PLATODIA`
--
ALTER TABLE `PLATODIA`
  ADD CONSTRAINT `FK_PLATODIA_MDIA_REL__MENUDIA` FOREIGN KEY (`MDIA_ID`) REFERENCES `MENUDIA` (`MDIA_ID`);

--
-- Filtros para la tabla `PLATOESPECIAL`
--
ALTER TABLE `PLATOESPECIAL`
  ADD CONSTRAINT `FK_PLATOESP_MESP_REL__MENUESPE` FOREIGN KEY (`MESP_ID`) REFERENCES `MENUESPECIAL` (`MESP_ID`);

--
-- Filtros para la tabla `RACION`
--
ALTER TABLE `RACION`
  ADD CONSTRAINT `FK_RACION_PDIA_REL__PLATODIA` FOREIGN KEY (`PDIA_ID`) REFERENCES `PLATODIA` (`PDIA_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
