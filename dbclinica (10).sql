-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2020 a las 19:23:38
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.33

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
  `fecha_registro` varchar(45) NOT NULL,
  `fecha_system` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tap_asistenciales`
--

INSERT INTO `tap_asistenciales` (`idasistenciales`, `nombre`, `apellidos`, `cargo_institucion`, `modalidad_contrato`, `colegiatura`, `num_colegiatura`, `profesion`, `tipo_documento`, `num_documento`, `celular`, `email`, `fecha_registro`, `fecha_system`) VALUES
(5, 'YOSSHI', 'CONDORI MENDIETA', 'JEFE DE CONSULTORIO ', 'CONTRATADO', 'CMP', '12356454', 'Medico ', 'D.N.I.', '76244566', '917023454', 'yosshi@gmail.com', '15 de Agosto del 2020', '15-08-2020'),
(6, 'JUAN', 'PEREZ DE LA TORRE', 'MEDICO', 'CONTRATADO', 'CMP', '58523', 'Medico ', 'D.N.I.', '76245896', '917023454', 'juanperez@gmail.com', '23 de Agosto del 2020', '23-08-2020'),
(7, 'NOMBRE PRUEBA', 'PRUEBA', 'PRUEBA', 'PRUEBA', 'CMP', '236955', 'Medico ', 'D.N.I.', '76248512', '917023454', 'prueba@gmail.com', '19 de Octubre del 2020', '19-10-2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_caja`
--

CREATE TABLE `tap_caja` (
  `idcaja` int(11) NOT NULL,
  `idconsultorio` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `trabajador` varchar(45) NOT NULL,
  `costo_consulta` decimal(6,2) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tap_caja`
--

INSERT INTO `tap_caja` (`idcaja`, `idconsultorio`, `idpaciente`, `trabajador`, `costo_consulta`, `fecha_registro`) VALUES
(1, 2, 1, 'Administrador', '36.50', '10-10-2020'),
(2, 2, 1, 'Administrador', '50.36', '10-10-2020'),
(4, 2, 2, 'Administrador', '69.35', '10-10-2020'),
(7, 2, 2, 'Administrador', '36.23', '10-10-2020'),
(8, 2, 1, 'Administrador', '10.00', '27-08-2020'),
(9, 2, 2, 'Administrador', '10.50', '27-08-2020'),
(10, 2, 1, 'Administrador', '69.30', '28-08-2020'),
(11, 2, 1, 'Administrador', '50.00', '30-08-2020'),
(12, 2, 1, 'Administrador', '100.00', '13-09-2020'),
(13, 2, 2, 'Administrador', '50.00', '13-09-2020'),
(14, 2, 2, 'Administrador', '56.00', '13-09-2020'),
(15, 2, 1, 'Administrador', '100.00', '13-09-2020'),
(16, 2, 3, 'Administrador', '56.00', '20-09-2020'),
(17, 2, 2, 'Administrador', '56.00', '10-10-2020'),
(18, 2, 3, 'Administrador', '35.00', '28-10-2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_certificadosalud`
--

CREATE TABLE `tap_certificadosalud` (
  `idcertificado_salud` int(11) NOT NULL,
  `idasistenciales` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `serelogia` varchar(100) NOT NULL,
  `examen_rx` varchar(100) NOT NULL,
  `hemoglobina` varchar(45) NOT NULL,
  `imp_diagnostica` varchar(350) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tap_certificadosalud`
--

INSERT INTO `tap_certificadosalud` (`idcertificado_salud`, `idasistenciales`, `idpaciente`, `serelogia`, `examen_rx`, `hemoglobina`, `imp_diagnostica`, `fecha_registro`) VALUES
(9, 5, 1, 'Pruebaasas', 'Pruebaasas', '13.6', '', '13-08-2020'),
(10, 5, 1, 'PRUEBAas', 'PRUEBAas', '13.6', '', '14-08-2020'),
(11, 6, 3, 'NO REACTIVO', 'SI ', '13.6', '', '17-10-2020'),
(12, 6, 1, 'Se observa varias pruebas realizadas dentro de este certificado', 'Todo normal dentro de los cuadros de ejemplo que se obteiene.', '13.6', '', '24-10-2020'),
(13, 5, 1, 'ESTO ES UNA PRUEBA', 'NO REACTIVO', '16.32', 'PRUEBA PRUEBA PRUEBA PRUEBAPRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBAPRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA', '25-10-2020'),
(14, 7, 3, 'PRUEBA', 'PRUEBA', '16.32', '- TODO NORMAL\n- TODO NORMAL', '28-10-2020');

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
(2, 6, 'DENTAL', '2', '3', '23-08-2020'),
(4, 7, 'LABORATORIO', '3', '2', '19-10-2020');

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
(4, 4, 8, 1, '123.00', 'Aceptado', '27-08-2020'),
(5, 4, 10, 3, '6.25', 'Aceptado', '27-08-2020'),
(7, 2, 9, 2, '36.00', 'Aceptado', '27-08-2020'),
(11, 1, 10, 4, '6.25', 'Aceptado', '29-08-2020'),
(13, 4, 9, 12, '36.00', 'Aceptado', '29-08-2020'),
(14, 10, 8, 7, '123.00', 'Aceptado', '30-08-2020'),
(15, 11, 9, 2, '36.00', 'Aceptado', '30-08-2020'),
(16, 14, 11, 2, '12.50', 'Aceptado', '13-09-2020'),
(17, 9, 11, 50, '12.50', 'Aceptado', '20-09-2020'),
(18, 1, 10, 2, '6.25', 'Aceptado', '10-10-2020'),
(19, 18, 12, 2, '1.30', 'Aceptado', '28-10-2020');

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
(8, 'SOLUCION', 'MAGNESOL', 123.00, 1, 'FUXION', 'PASTILLAS', '22-08-2020', '2020-11-24'),
(9, 'SOLUCION', 'AZITROMICINA', 36.00, 0, 'BAYER', 'PASTILLAS', '22-08-2020', '2020-08-31'),
(10, 'SOLUCION', 'PARACETAMOL', 6.25, 2, 'BAYER', 'JARABE', '23-08-2020', '2020-08-31'),
(11, 'TABLETA', 'PARACEMOL', 12.50, 10, 'BAYER', 'PASTILLAS', '17-10-2020', '2023-10-27'),
(12, 'TABLETA', 'PARACETAMOLII', 1.30, 8, 'BAYER', 'PASTILLAS', '28-10-2020', '2020-11-29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_informemedico`
--

CREATE TABLE `tap_informemedico` (
  `idinforme_medico` int(11) NOT NULL,
  `idasistenciales` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `diagnostico` varchar(500) NOT NULL,
  `dias_descanso` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL,
  `fecha_system` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tap_informemedico`
--

INSERT INTO `tap_informemedico` (`idinforme_medico`, `idasistenciales`, `idpaciente`, `diagnostico`, `dias_descanso`, `fecha_registro`, `fecha_system`) VALUES
(4, 5, 2, 'El Señor presenta problemas con la cabeza, puesto que sufrio un desmayo el dia tal en su oficina y por esa razon fal fla fla fla esto es una prueba.', '', '23 de Agosto del 2020', '16-09-2020'),
(5, 6, 1, 'Esto es una pruba de la informacion brindada por el usuario, asi mismo, no se puede determinar que enfermedad tiene. Se recomienda que el paciente tenga por conveniente ir al hospital maria auxiliadora en calidad de urgente para que puedad atenderse,', '', '17 de Octubre del 2020', '16-10-2020'),
(6, 6, 1, 'se implementara un software en el cerebro, el cual permitira mejorar el funcionamiento de todo el sistema nervisoso.', '', '17 de Octubre del 2020', '17-10-2020'),
(7, 7, 3, 'PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA PRUEBA', '90', '25 de Octubre del 2020', '25-10-2020'),
(8, 6, 1, '- INFECCION URINARIA\n- ANTECEDENTE DE LUPUS ERITEMATOSO SISTEMICO', '90', '25 de Octubre del 2020', '25-10-2020');

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
  `direccion` varchar(350) NOT NULL,
  `celular` varchar(45) NOT NULL,
  `fecha_nacimiento` varchar(45) NOT NULL,
  `lugar_proc` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) NOT NULL,
  `edad` varchar(45) NOT NULL,
  `estado_civil` varchar(45) NOT NULL,
  `ocupacion` varchar(45) NOT NULL,
  `antecedente_enfermedad` varchar(45) NOT NULL,
  `antec_operacion` varchar(45) NOT NULL,
  `reacc_medicamento` varchar(45) NOT NULL,
  `digitador` varchar(45) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tap_paciente`
--

INSERT INTO `tap_paciente` (`idpaciente`, `historia_clinica`, `tipo_documento`, `numero_documento`, `nombres`, `apellido_paterno`, `apellido_materno`, `direccion`, `celular`, `fecha_nacimiento`, `lugar_proc`, `sexo`, `edad`, `estado_civil`, `ocupacion`, `antecedente_enfermedad`, `antec_operacion`, `reacc_medicamento`, `digitador`, `fecha_registro`) VALUES
(1, '1013', 'PASAPORTE', '7624456999', 'YOSSHI SALVADOR', 'CONDOR', 'MENDIETE', 'PEDANDKJNKASNDA VQD9012312 SADASD', '917023453', '02/10/1994', 'CAÑETE', 'FEMENINO', '25 Años 10 Meses y 13 Dias', 'CASADO', 'DESARROLLADOR DE SOFTWARE', 'GRANULOMA TBC', 'NINGUNA', 'DEXAMETASONA', 'Administrador', '15-08-2020'),
(2, '1014', 'DNI', '76244566', 'KARLA', 'LIMA ', 'CCOROPUNA', 'PEDADAKJMKL123123AD.-{.-{Ñ´Ñ´Ñ', '917023454', '02/10/2020', 'LIMA', 'FEMENINO', '0 Años -1 Meses y -18 Dias', 'CASADO', 'DESARROLLADOR DE SOFTWARE', 'GRANULOMA TBC', 'NINGUNA', 'DEXAMETASONA', 'Administrador', '15-08-2020'),
(3, '1015', 'DNI', '76244568', 'MARTIN', 'VIZCARRA', 'TOLEDO', 'AV PAGAME MI ONP', '917023453', '29/03/1994', 'LIMA', 'MASCULINO', '26 Años 5 Meses y 1 Dias', 'CASADO', 'PRESIDENTE', 'NO GOBERNAR', 'NINGUNA', 'NINGUNA', 'Administrador', '30-08-2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tap_pago`
--

CREATE TABLE `tap_pago` (
  `idpago` int(11) NOT NULL,
  `idcaja` int(11) NOT NULL,
  `tipo_comprobante` varchar(45) NOT NULL,
  `num_comprobante` varchar(45) NOT NULL,
  `igv` decimal(6,2) NOT NULL,
  `cantidad_pago` decimal(8,2) NOT NULL,
  `subtotal` decimal(8,2) NOT NULL,
  `total` decimal(8,2) NOT NULL,
  `vuelto` decimal(8,2) NOT NULL,
  `fecha_registro` varchar(45) NOT NULL,
  `hora` varchar(45) NOT NULL,
  `trabajador` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tap_pago`
--

INSERT INTO `tap_pago` (`idpago`, `idcaja`, `tipo_comprobante`, `num_comprobante`, `igv`, `cantidad_pago`, `subtotal`, `total`, `vuelto`, `fecha_registro`, `hora`, `trabajador`) VALUES
(18, 9, 'Boleta', '00001', '1.89', '500.00', '10.50', '12.39', '487.61', '30-08-2020', '12: 57: 48 AM', 'admin'),
(19, 11, 'Boleta', '00002', '21.96', '150.00', '143.96', '143.96', '6.04', '30-08-2020', '12: 49: 24 PM', 'admin'),
(20, 1, 'Boleta', '00003', '13.32', '100.00', '87.32', '87.32', '12.68', '10-10-2020', '09: 35: 44 PM', 'admin'),
(21, 18, 'Boleta', '00004', '6.77', '100.00', '44.37', '44.37', '55.63', '28-10-2020', '02: 46: 48 PM', 'admin');

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
(4, 'YOSSHIS', 'CONDORIS', 'MENDIETAS', 'ING DE SISTEMASS', 'JEFES', 'CONTRATADOS', 'DNI', '76244563', '917023454', 'yosshimendiewta@gmail.com', '15-08-2020'),
(6, 'PRUEBA NOMBRE', 'APELLIDO', 'MATERNO', 'ING DE SISTEMAS', 'PRUEBA CARGO', 'MODALIDAD PRUEBA', 'DNI', '75625896', '917256955', 'PRUEBA@GMAIL.COM', '19-10-2020');

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
  MODIFY `idasistenciales` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tap_caja`
--
ALTER TABLE `tap_caja`
  MODIFY `idcaja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `tap_certificadosalud`
--
ALTER TABLE `tap_certificadosalud`
  MODIFY `idcertificado_salud` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `tap_consultorio`
--
ALTER TABLE `tap_consultorio`
  MODIFY `idconsultorio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tap_consumo`
--
ALTER TABLE `tap_consumo`
  MODIFY `idconsumo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `tap_farmacia`
--
ALTER TABLE `tap_farmacia`
  MODIFY `idfarmacia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `tap_informemedico`
--
ALTER TABLE `tap_informemedico`
  MODIFY `idinforme_medico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tap_paciente`
--
ALTER TABLE `tap_paciente`
  MODIFY `idpaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tap_pago`
--
ALTER TABLE `tap_pago`
  MODIFY `idpago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `tap_trabajador`
--
ALTER TABLE `tap_trabajador`
  MODIFY `idptrabajador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
