-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-08-2020 a las 07:23:14
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

--
-- Volcado de datos para la tabla `tap_acceso`
--

INSERT INTO `tap_acceso` (`idacceso`, `idtrabajador`, `acceso`, `login`, `password`, `estado`) VALUES
(4, 4, 'Administrador', 'admin', 'admin', 'A');

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

--
-- Volcado de datos para la tabla `tap_asistenciales`
--

INSERT INTO `tap_asistenciales` (`idasistenciales`, `nombre`, `apellidos`, `cargo_institucion`, `modalidad_contrato`, `colegiatura`, `num_colegiatura`, `profesion`, `tipo_documento`, `num_documento`, `celular`, `email`, `fecha_registro`) VALUES
(5, 'YOSSHI', 'CONDORI MENDIETA', 'JEFE DE CONSULTORIO ', 'CONTRATADO', 'CMP', '12356454', 'Medico ', 'D.N.I.', '76244566', '917023454', 'yosshi@gmail.com', '15 de Agosto del 2020'),
(6, 'JUAN', 'PEREZ DE LA TORRE', 'MEDICO', 'CONTRATADO', 'CMP', '58523', 'Medico ', 'D.N.I.', '76245896', '917023454', 'juanperez@gmail.com', '23 de Agosto del 2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_caja`
--

CREATE TABLE `tap_caja` (
  `idcaja` int(11) NOT NULL,
  `idconsultorio` int(11) NOT NULL,
  `trabajador` varchar(45) NOT NULL,
  `costo_consulta` decimal(6,2) DEFAULT NULL,
  `fecha_registro` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tap_caja`
--

INSERT INTO `tap_caja` (`idcaja`, `idconsultorio`, `trabajador`, `costo_consulta`, `fecha_registro`) VALUES
(1, 2, 'Administrador', '36.50', '23-08-2020'),
(2, 2, 'Administrador', '50.36', '22-08-2020'),
(4, 2, 'Administrador', '69.35', '23-08-2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_certificadosalud`
--

CREATE TABLE `tap_certificadosalud` (
  `idcertificado_salud` int(11) NOT NULL,
  `idasistenciales` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `serelogia` varchar(45) NOT NULL,
  `examen_rx` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tap_certificadosalud`
--

INSERT INTO `tap_certificadosalud` (`idcertificado_salud`, `idasistenciales`, `idpaciente`, `serelogia`, `examen_rx`, `fecha_registro`) VALUES
(9, 5, 1, 'Pruebaasas', 'Pruebaasas', '8 de Agosto del 2020'),
(10, 5, 1, 'PRUEBAas', 'PRUEBAas', '17 de Agosto del 2020');

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

--
-- Volcado de datos para la tabla `tap_consultorio`
--

INSERT INTO `tap_consultorio` (`idconsultorio`, `idasistencial`, `nombre_consultorio`, `numero_consultorio`, `piso_consultorio`, `fecha_registro`) VALUES
(2, 6, 'DENTAL', '2', '3', '23-08-2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_consumo`
--

CREATE TABLE `tap_consumo` (
  `idconsumo` int(11) NOT NULL,
  `idcaja` int(11) NOT NULL,
  `idfarmacia` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_venta` decimal(6,2) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tap_consumo`
--

INSERT INTO `tap_consumo` (`idconsumo`, `idcaja`, `idfarmacia`, `cantidad`, `precio_venta`, `estado`, `fecha_registro`) VALUES
(1, 1, 8, 2, '123.00', 'Aceptado', '23-08-2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_farmacia`
--

CREATE TABLE `tap_farmacia` (
  `idfarmacia` int(11) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio_venta` double(6,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `laboratorio` varchar(45) NOT NULL,
  `presentacion` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL,
  `fecha_vencimiento` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tap_farmacia`
--

INSERT INTO `tap_farmacia` (`idfarmacia`, `categoria`, `nombre`, `precio_venta`, `stock`, `laboratorio`, `presentacion`, `fecha_registro`, `fecha_vencimiento`) VALUES
(8, 'SOLUCION', 'MAGNESOL', 123.00, 6, 'FUXION', 'PASTILLAS', '22-08-2020', '2020-11-24'),
(9, 'SOLUCION', 'AZITROMICINA', 36.00, 7, 'BAYER', 'PASTILLAS', '22-08-2020', '2020-08-31'),
(10, 'SOLUCION', 'PARACETAMOL', 6.25, 8, 'BAYER', 'JARABE', '23-08-2020', '2020-08-31');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_informemedico`
--

CREATE TABLE `tap_informemedico` (
  `idinforme_medico` int(11) NOT NULL,
  `idasistenciales` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `diagnostico` varchar(500) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tap_informemedico`
--

INSERT INTO `tap_informemedico` (`idinforme_medico`, `idasistenciales`, `idpaciente`, `diagnostico`, `fecha_registro`) VALUES
(4, 5, 2, 'El Señor presenta problemas con la cabeza, puesto que sufrio un desmayo el dia tal en su oficina y por esa razon fal fla fla fla esto es una prueba.', '23 de Agosto del 2020');

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

--
-- Volcado de datos para la tabla `tap_paciente`
--

INSERT INTO `tap_paciente` (`idpaciente`, `historia_clinica`, `tipo_documento`, `numero_documento`, `nombres`, `apellido_paterno`, `apellido_materno`, `tipo_seguro`, `direccion`, `celular`, `email`, `fecha_nacimiento`, `lugar_nac`, `lugar_proc`, `sexo`, `edad`, `estado_civil`, `fa_nombres`, `fa_apellidos`, `fa_edad`, `fa_direccion`, `digitador`, `fecha_registro`) VALUES
(1, '1013', 'DNI', '76244567', 'YOSSHI SALVADOR', 'CONDOR', 'MENDIETE', 'SIS', 'PEDANDKJNKASNDA VQD9012312 SADASD', '917023453', 'yosshimendietsas12a@gmail.com', '02/10/1994', 'CAÑETE', 'CAÑETE', 'FEMENINO', '25 Años 10 Meses y 13 Dias', 'CASADO', '', '', '', '', 'Administrador', '15-08-2020'),
(2, '1014', 'DNI', '76244566', 'KARLA', 'LIMA ', 'CCOROPUNA', 'SIS', 'PEDADAKJMKL123123AD.-{.-{Ñ´Ñ´Ñ', '917023454', 'karla@gmail.com', '02/10/2020', 'LIMA', 'LIMA', 'FEMENINO', '0 Años -1 Meses y -18 Dias', 'CASADO', '', '', '', '', 'Administrador', '15-08-2020');

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
-- Volcado de datos para la tabla `tap_trabajador`
--

INSERT INTO `tap_trabajador` (`idptrabajador`, `nombre`, `apaterno`, `amaterno`, `profesion`, `cargo_institucion`, `modalidad_contrato`, `tipo_documento`, `num_documento`, `celular`, `email`, `fecha_registro`) VALUES
(4, 'YOSSHIS', 'CONDORIS', 'MENDIETAS', 'ING DE SISTEMASS', 'JEFES', 'CONTRATADOS', 'DNI', '76244563', '917023454', 'yosshimendiewta@gmail.com', '15/8/2020');

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
  ADD KEY `fk_asistenciales_certificado_salud_idx` (`idasistenciales`),
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
  MODIFY `idacceso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tap_asistenciales`
--
ALTER TABLE `tap_asistenciales`
  MODIFY `idasistenciales` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tap_caja`
--
ALTER TABLE `tap_caja`
  MODIFY `idcaja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tap_certificadosalud`
--
ALTER TABLE `tap_certificadosalud`
  MODIFY `idcertificado_salud` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tap_consultorio`
--
ALTER TABLE `tap_consultorio`
  MODIFY `idconsultorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tap_consumo`
--
ALTER TABLE `tap_consumo`
  MODIFY `idconsumo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tap_farmacia`
--
ALTER TABLE `tap_farmacia`
  MODIFY `idfarmacia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tap_informemedico`
--
ALTER TABLE `tap_informemedico`
  MODIFY `idinforme_medico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tap_paciente`
--
ALTER TABLE `tap_paciente`
  MODIFY `idpaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tap_pago`
--
ALTER TABLE `tap_pago`
  MODIFY `idpago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tap_trabajador`
--
ALTER TABLE `tap_trabajador`
  MODIFY `idptrabajador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
  ADD CONSTRAINT `fk_asistenciales_certificado_salud` FOREIGN KEY (`idasistenciales`) REFERENCES `tap_asistenciales` (`idasistenciales`) ON DELETE NO ACTION ON UPDATE NO ACTION;

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
