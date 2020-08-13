-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-08-2020 a las 06:02:15
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.3.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbclinica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_acceso`
--

CREATE TABLE `tap_acceso` (
  `idacceso` int(11) NOT NULL,
  `idtrabajador` int(11) NOT NULL,
  `acceso` varchar(13) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `estado` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_asistenciales`
--

CREATE TABLE `tap_asistenciales` (
  `idasistenciales` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `cargo_institucion` varchar(100) NOT NULL,
  `modalidad_contrato` varchar(45) NOT NULL,
  `colegiatura` varchar(45) NOT NULL,
  `num_colegiatura` varchar(45) NOT NULL,
  `profesion` varchar(45) NOT NULL,
  `tipo_documento` varchar(30) NOT NULL,
  `num_documento` varchar(10) NOT NULL,
  `celular` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_caja`
--

CREATE TABLE `tap_caja` (
  `idcaja` int(11) NOT NULL,
  `idconsultorio` int(11) NOT NULL,
  `idtrabajador` int(11) NOT NULL,
  `costo_consulta` varchar(45) DEFAULT NULL,
  `fecha_registro` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_certificadosalud`
--

CREATE TABLE `tap_certificadosalud` (
  `idcertificado_salud` int(11) NOT NULL,
  `idcerasistenciales` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `serelogia` varchar(45) NOT NULL,
  `examen_rx` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_consultorio`
--

CREATE TABLE `tap_consultorio` (
  `idconsultorio` int(11) NOT NULL,
  `idasistencial` int(11) NOT NULL,
  `nombre_consultorio` varchar(45) DEFAULT NULL,
  `numero_consultorio` varchar(45) DEFAULT NULL,
  `piso_consultorio` varchar(45) DEFAULT NULL,
  `fecha_registro` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_consumo`
--

CREATE TABLE `tap_consumo` (
  `idconsumo` int(11) NOT NULL,
  `idcaja` int(11) NOT NULL,
  `idfarmacia` int(11) NOT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `fecha_registro` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_farmacia`
--

CREATE TABLE `tap_farmacia` (
  `idfarmacia` int(11) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio_venta` varchar(45) NOT NULL,
  `stock` varchar(45) NOT NULL,
  `laboratorio` varchar(45) NOT NULL,
  `presentacion` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL,
  `fecha_vencimiento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_informemedico`
--

CREATE TABLE `tap_informemedico` (
  `idinforme_medico` int(11) NOT NULL,
  `idasistenciales` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `diagnostico` varchar(100) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_paciente`
--

CREATE TABLE `tap_paciente` (
  `idpaciente` int(11) NOT NULL,
  `historia_clinica` varchar(45) NOT NULL,
  `tipo_documento` varchar(45) NOT NULL,
  `numero_documento` varchar(45) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) NOT NULL,
  `tipo_seguro` varchar(45) NOT NULL,
  `direccion` varchar(350) NOT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` varchar(45) NOT NULL,
  `lugar_nac` varchar(45) DEFAULT NULL,
  `lugar_proc` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) NOT NULL,
  `edad` varchar(45) NOT NULL,
  `estado_civil` varchar(45) DEFAULT NULL,
  `fa_nombres` varchar(45) DEFAULT NULL,
  `fa_apellidos` varchar(45) DEFAULT NULL,
  `fa_edad` varchar(45) DEFAULT NULL,
  `fa_direccion` varchar(45) DEFAULT NULL,
  `digitador` varchar(45) DEFAULT NULL,
  `fecha_registro` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_pago`
--

CREATE TABLE `tap_pago` (
  `idpago` int(11) NOT NULL,
  `idcaja` int(11) NOT NULL,
  `tipo_comprobante` varchar(45) NOT NULL,
  `num_comprobante` varchar(45) NOT NULL,
  `igv` decimal(4,2) NOT NULL,
  `cantidad_pago` decimal(4,2) NOT NULL,
  `subtotal` decimal(4,2) NOT NULL,
  `total` decimal(4,2) NOT NULL,
  `vuelto` decimal(4,2) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_trabajador`
--

CREATE TABLE `tap_trabajador` (
  `idptrabajador` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apaterno` varchar(25) NOT NULL,
  `amaterno` varchar(25) NOT NULL,
  `profesion` varchar(45) NOT NULL,
  `cargo_institucion` varchar(100) NOT NULL,
  `modalidad_contrato` varchar(45) NOT NULL,
  `tipo_documento` varchar(4) NOT NULL,
  `num_documento` varchar(45) NOT NULL,
  `celular` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tap_acceso`
--
ALTER TABLE `tap_acceso`
  ADD PRIMARY KEY (`idacceso`),
  ADD UNIQUE KEY `login_UNIQUE` (`login`),
  ADD UNIQUE KEY `password_UNIQUE` (`password`),
  ADD KEY `fk_acceso_persona_trabajador1_idx` (`idtrabajador`);

--
-- Indices de la tabla `tap_asistenciales`
--
ALTER TABLE `tap_asistenciales`
  ADD PRIMARY KEY (`idasistenciales`),
  ADD UNIQUE KEY `num_documento_UNIQUE` (`num_documento`),
  ADD UNIQUE KEY `num_colegiatura_UNIQUE` (`num_colegiatura`);

--
-- Indices de la tabla `tap_caja`
--
ALTER TABLE `tap_caja`
  ADD PRIMARY KEY (`idcaja`),
  ADD KEY `fk_Tap_Caja_consultorio1_idx` (`idconsultorio`);

--
-- Indices de la tabla `tap_certificadosalud`
--
ALTER TABLE `tap_certificadosalud`
  ADD PRIMARY KEY (`idcertificado_salud`),
  ADD KEY `fk_asistenciales_certificado_salud_idx` (`idcerasistenciales`),
  ADD KEY `fk_Tap_CertificadoSalud_Tap_Paciente1_idx` (`idpaciente`);

--
-- Indices de la tabla `tap_consultorio`
--
ALTER TABLE `tap_consultorio`
  ADD PRIMARY KEY (`idconsultorio`),
  ADD KEY `fk_consultorio_asistenciales1_idx` (`idasistencial`);

--
-- Indices de la tabla `tap_consumo`
--
ALTER TABLE `tap_consumo`
  ADD PRIMARY KEY (`idconsumo`),
  ADD KEY `fk_Tap_Consumo_Tap_Farmacia1_idx` (`idfarmacia`),
  ADD KEY `fk_Tap_Consumo_Tap_Caja1_idx` (`idcaja`);

--
-- Indices de la tabla `tap_farmacia`
--
ALTER TABLE `tap_farmacia`
  ADD PRIMARY KEY (`idfarmacia`);

--
-- Indices de la tabla `tap_informemedico`
--
ALTER TABLE `tap_informemedico`
  ADD PRIMARY KEY (`idinforme_medico`),
  ADD KEY `fk_asistenciales_informa_medico_idx` (`idasistenciales`),
  ADD KEY `fk_Tap_IinformeMedico_Tap_Paciente1_idx` (`idpaciente`);

--
-- Indices de la tabla `tap_paciente`
--
ALTER TABLE `tap_paciente`
  ADD PRIMARY KEY (`idpaciente`);

--
-- Indices de la tabla `tap_pago`
--
ALTER TABLE `tap_pago`
  ADD PRIMARY KEY (`idpago`),
  ADD KEY `fk_Tap_Pago_Tap_Caja1_idx` (`idcaja`);

--
-- Indices de la tabla `tap_trabajador`
--
ALTER TABLE `tap_trabajador`
  ADD PRIMARY KEY (`idptrabajador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tap_acceso`
--
ALTER TABLE `tap_acceso`
  MODIFY `idacceso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tap_asistenciales`
--
ALTER TABLE `tap_asistenciales`
  MODIFY `idasistenciales` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tap_certificadosalud`
--
ALTER TABLE `tap_certificadosalud`
  MODIFY `idcertificado_salud` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tap_consumo`
--
ALTER TABLE `tap_consumo`
  MODIFY `idconsumo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tap_farmacia`
--
ALTER TABLE `tap_farmacia`
  MODIFY `idfarmacia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tap_informemedico`
--
ALTER TABLE `tap_informemedico`
  MODIFY `idinforme_medico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tap_paciente`
--
ALTER TABLE `tap_paciente`
  MODIFY `idpaciente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tap_pago`
--
ALTER TABLE `tap_pago`
  MODIFY `idpago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tap_trabajador`
--
ALTER TABLE `tap_trabajador`
  MODIFY `idptrabajador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tap_acceso`
--
ALTER TABLE `tap_acceso`
  ADD CONSTRAINT `fk_acceso_persona_trabajador1` FOREIGN KEY (`idtrabajador`) REFERENCES `tap_trabajador` (`idptrabajador`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tap_caja`
--
ALTER TABLE `tap_caja`
  ADD CONSTRAINT `fk_Tap_Caja_consultorio1` FOREIGN KEY (`idconsultorio`) REFERENCES `tap_consultorio` (`idconsultorio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tap_certificadosalud`
--
ALTER TABLE `tap_certificadosalud`
  ADD CONSTRAINT `fk_Tap_CertificadoSalud_Tap_Paciente1` FOREIGN KEY (`idpaciente`) REFERENCES `tap_paciente` (`idpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_asistenciales_certificado_salud` FOREIGN KEY (`idcerasistenciales`) REFERENCES `tap_asistenciales` (`idasistenciales`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tap_consultorio`
--
ALTER TABLE `tap_consultorio`
  ADD CONSTRAINT `fk_consultorio_asistenciales1` FOREIGN KEY (`idasistencial`) REFERENCES `tap_asistenciales` (`idasistenciales`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tap_consumo`
--
ALTER TABLE `tap_consumo`
  ADD CONSTRAINT `fk_Tap_Consumo_Tap_Caja1` FOREIGN KEY (`idcaja`) REFERENCES `tap_caja` (`idcaja`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Tap_Consumo_Tap_Farmacia1` FOREIGN KEY (`idfarmacia`) REFERENCES `tap_farmacia` (`idfarmacia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tap_informemedico`
--
ALTER TABLE `tap_informemedico`
  ADD CONSTRAINT `fk_Tap_IinformeMedico_Tap_Paciente1` FOREIGN KEY (`idpaciente`) REFERENCES `tap_paciente` (`idpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_asistenciales_informa_medico` FOREIGN KEY (`idasistenciales`) REFERENCES `tap_asistenciales` (`idasistenciales`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tap_pago`
--
ALTER TABLE `tap_pago`
  ADD CONSTRAINT `fk_Tap_Pago_Tap_Caja1` FOREIGN KEY (`idcaja`) REFERENCES `tap_caja` (`idcaja`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
