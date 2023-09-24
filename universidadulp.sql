-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-09-2023 a las 19:08:45
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universidadulp`
--
CREATE DATABASE IF NOT EXISTS `universidadulp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `universidadulp`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) VALUES
(1, 44444443, 'Martinez', 'Ana', '2000-11-23', 1),
(2, 66666666, 'Mendez', 'Juan', '2002-01-23', 1),
(3, 77777777, 'Aguirre', 'Carlos', '2004-12-23', 1),
(4, 88888888, 'Gomez', 'Diego', '2000-09-12', 1),
(5, 12365478, 'Soria', 'Eva', '1996-05-25', 1),
(6, 33333333, 'Paso', 'Julian', '1997-09-30', 1),
(8, 99999999, 'Funes', 'Aldo', '2011-07-06', 1),
(9, 11223344, 'Santos', 'Nahuel', '1996-05-25', 0),
(12, 22222222, 'Martines', 'Viviana', '2001-12-10', 1),
(13, 33445566, 'Varela', 'Carlos', '1990-11-23', 1),
(14, 44556677, 'Paez', 'Diego', '1999-09-06', 1),
(15, 55667778, 'Salas', 'Benito', '2000-05-16', 1),
(16, 99887744, 'Coma', 'Victor', '2000-09-02', 1),
(17, 99999, 'z', 'x', '2023-09-06', 1),
(18, 87888990, 'Alvarez', 'Valeria', '2023-09-15', 1),
(19, 55555555, 'Palacios', 'Juliana', '1991-01-16', 1),
(20, 12131415, 'Diego', 'Fernande', '2012-05-15', 1),
(21, 14, 'Samuel', 'Rios', '2023-09-12', 1),
(22, 13141516, 'Sala', 'Hector', '2023-09-05', 1),
(23, 45464749, 'Ruben', 'Marco', '2023-09-12', 1),
(24, 47484950, 'Sosa', 'Valeria', '2023-09-20', 1),
(29, 45678911, 'Salva', 'Tore', '2023-09-13', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `idInscripto` int(11) NOT NULL,
  `nota` double NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`idInscripto`, `nota`, `idAlumno`, `idMateria`) VALUES
(1, 7.5, 3, 1),
(2, 5.25, 3, 11),
(3, 9.25, 3, 3),
(4, 8.75, 2, 3),
(5, 5.5, 2, 7),
(6, 7.75, 2, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `anio` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`idMateria`, `nombre`, `anio`, `estado`) VALUES
(1, 'Matematicas', 1, 1),
(2, 'Progamacion 1', 1, 1),
(3, 'Base de Datos 1', 1, 1),
(4, 'Idioma 2.2', 2, 1),
(5, 'Desarrollo Productivo', 3, 1),
(6, 'Programacion lll', 3, 1),
(7, 'Paracaidismo', 5, 1),
(8, 'Corte y Confeccion', 2, 1),
(9, 'Laboratorio Prog. 1', 1, 1),
(10, 'Ingles Tecnico', 1, 1),
(11, 'Ingles Tecnico 2', 2, 1),
(14, 'Control de Ansiedad', 3, 1),
(17, 'Quimica', 1, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`idInscripto`),
  ADD KEY `idAlumno` (`idAlumno`),
  ADD KEY `idMateria` (`idMateria`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `idInscripto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
