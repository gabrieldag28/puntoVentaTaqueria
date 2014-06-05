-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-06-2014 a las 19:12:51
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `punto_venta`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen_entrada`
--

CREATE TABLE IF NOT EXISTS `almacen_entrada` (
  `id_almacen` int(10) NOT NULL,
  `id_producto` int(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `fecha_alta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_modicar` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `id_clientes` int(50) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_clientes`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_clientes`, `nombre`, `apellido_paterno`, `apellido_materno`, `telefono`, `email`, `status`) VALUES
(1, 'a', 'a', 'a', '5544', 'a', 2),
(2, 'Diego', 'Gomez', 'Gabriel', '9802564', 'diego_dag@hotmail.com', 1),
(3, 'a', 'a', 'a', 'a', 'a', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE IF NOT EXISTS `detalle_venta` (
  `id_detalle_venta` int(10) NOT NULL AUTO_INCREMENT,
  `id_venta` int(10) NOT NULL,
  `id_producto` int(10) NOT NULL,
  `precio` int(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `total` int(10) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `fecha_venta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_detalle_venta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`id_detalle_venta`, `id_venta`, `id_producto`, `precio`, `cantidad`, `total`, `status`, `fecha_venta`) VALUES
(1, 1, 2, 12, 2, 24, 1, '0000-00-00 00:00:00'),
(2, 2, 3, 27, 3, 81, 1, '0000-00-00 00:00:00'),
(3, 2, 3, 27, 2, 54, 1, '0000-00-00 00:00:00'),
(4, 2, 7, 10, 1, 10, 1, '0000-00-00 00:00:00'),
(5, 3, 2, 12, 3, 36, 1, '2014-05-29 07:36:29'),
(6, 4, 3, 27, 4, 108, 1, '2014-05-29 19:59:12'),
(7, 5, 7, 10, 2, 20, 1, '2014-05-29 20:00:48'),
(8, 6, 2, 12, 3, 36, 1, '2014-05-29 22:02:39'),
(9, 7, 6, 37, 5, 185, 1, '2014-05-30 15:13:42'),
(10, 8, 2, 12, 2, 24, 1, '2014-05-30 15:20:42'),
(11, 9, 3, 28, 5, 140, 1, '2014-05-30 15:30:16'),
(12, 10, 6, 37, 2, 74, 1, '2014-05-30 15:33:02'),
(13, 11, 2, 12, 2, 24, 1, '2014-06-04 04:15:39'),
(14, 11, 2, 12, 2, 24, 1, '2014-06-04 04:15:39'),
(15, 12, 3, 28, 1, 28, 1, '2014-06-04 04:37:44'),
(16, 12, 4, 25, 1, 25, 1, '2014-06-04 04:37:44'),
(17, 12, 3, 28, 1, 28, 1, '2014-06-04 04:37:44'),
(18, 13, 5, 27, 3, 81, 1, '2014-06-04 06:13:45');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` int(10) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `precio` int(50) NOT NULL,
  `existencia` varchar(50) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `descripcion`, `precio`, `existencia`, `status`) VALUES
(1, 'a', 5, '5', 2),
(2, 'Tacos', 12, '20', 1),
(3, 'Quesadillas', 28, '20', 1),
(4, 'Vampiros', 25, '20', 1),
(5, 'Chorreada', 27, '20', 1),
(6, 'Tortas', 37, '20', 1),
(7, 'Refresco', 10, '20', 1),
(8, 'Agua de cebada', 15, '13', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_almacen`
--

CREATE TABLE IF NOT EXISTS `producto_almacen` (
  `id_producto_almacen` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `precio` varchar(30) NOT NULL,
  `cantidad` int(30) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_producto_almacen`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `producto_almacen`
--

INSERT INTO `producto_almacen` (`id_producto_almacen`, `nombre`, `precio`, `cantidad`, `status`) VALUES
(1, 'Tomates', '10 ', 10, 2),
(2, 'a', 'a', 0, 2),
(3, 'a', 'a', 16, 2),
(4, 'Cebolla', '15', 5, 2),
(5, 'Pepinos', '13', 0, 1),
(6, 'Tomates', '10', 0, 1),
(7, 'Cebolla', '14', 0, 1),
(8, 'Rabano', '9', 0, 1),
(9, 'Chile Cerrano', '7', 0, 2),
(10, 'Chile Cerrano', '4', 0, 1),
(11, 'Aguacate', '35', 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provedores`
--

CREATE TABLE IF NOT EXISTS `provedores` (
  `id_provedor` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `a_paterno` varchar(30) NOT NULL,
  `a_materno` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `empresa` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `fecha_de_alta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_provedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `provedores`
--

INSERT INTO `provedores` (`id_provedor`, `nombre`, `a_paterno`, `a_materno`, `email`, `empresa`, `telefono`, `fecha_de_alta`, `status`) VALUES
(1, 's', 's', 's', 's', 'jTextField1s', '45', '2014-05-29 20:39:37', 2),
(2, 'Pedro', 'Garcia', 'Gonzalez', 'pedro_glez', 'Fruteria Alicia', '9504613', '2014-05-29 20:43:40', 1),
(3, 'b', 'b', 'b', 'b', 'a', 'a', '2014-05-29 20:44:00', 2),
(4, 'Perla', 'Corona', 'Campillo', 'Perla_87@hotmail.com', 'Frutic', '6691027151', '2014-06-04 04:49:52', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int(50) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `contrasena` varchar(20) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  `fecha_alta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_modificado` datetime NOT NULL,
  PRIMARY KEY (`id_usuario`),
  FULLTEXT KEY `nombre_completo` (`nombre`,`apellido_paterno`,`apellido_materno`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `apellido_paterno`, `apellido_materno`, `email`, `usuario`, `contrasena`, `status`, `fecha_alta`, `fecha_modificado`) VALUES
(1, 'Martin  Alejandro', 'Corona', 'Campillo', 'martin_korona@hotmail.com', 'mcorona92', 'corona', 1, '2014-02-18 17:13:07', '0000-00-00 00:00:00'),
(2, 'dfdf', 'jhjh', 'jhjh', 'hjh', 'a', 'q', 2, '2014-03-20 17:05:51', '0000-00-00 00:00:00'),
(3, 'Alejandro', 'Corona', 'Campillo', 'ale_lo@hotmail.com', 'alex', 'alex', 2, '2014-03-20 17:16:20', '0000-00-00 00:00:00'),
(4, 'Martin  ', 'Corona', 'Campillo', 'martin_korona@hotmail.com', 'mcorona', 'corona', 2, '2014-03-20 17:29:33', '0000-00-00 00:00:00'),
(5, 'Alejandrfo', 'Corona', 'Campillo', 'alex_lok@hotmail.com', 'alex', 'alex', 2, '2014-03-24 17:14:34', '0000-00-00 00:00:00'),
(6, 'Alejandro', 'corona', 'cqampillo', 'jsjj', 'a', 'a', 2, '2014-03-24 17:19:20', '0000-00-00 00:00:00'),
(7, 'Alejandro', 'Corona', 'Campillo', 'AJSJAJ', 'a', 'a', 2, '2014-03-24 17:28:13', '0000-00-00 00:00:00'),
(8, 'alejandro', 'corona', 'campillo', 'alex_lol@hotmail.com', 'alex', 'alex', 2, '2014-03-24 21:23:12', '0000-00-00 00:00:00'),
(9, 'alejandro', 'corona', 'campillo', 'mamam', 'ma', 'ma', 2, '2014-03-24 21:25:57', '0000-00-00 00:00:00'),
(10, 'alex', 'corona', 'corona', 'alex', 'alex', 'alex', 2, '2014-03-24 21:27:09', '0000-00-00 00:00:00'),
(11, 'a', 'a', 'a', 'a', 'a', 'a', 2, '2014-03-24 21:27:27', '0000-00-00 00:00:00'),
(12, 'a', 'a', 'a', 'a', 'a', 'a', 2, '2014-03-24 21:27:41', '0000-00-00 00:00:00'),
(13, 'a', 'a', 'a', 'a', 'a', 'a', 2, '2014-03-24 21:28:43', '0000-00-00 00:00:00'),
(14, 'ab', 'ab', 'aab', 'aba', 'aba', 'a', 2, '2014-03-24 21:49:26', '0000-00-00 00:00:00'),
(15, 'bb', 'ab', 'ab', 'ab', 'ab', 'a', 2, '2014-03-24 21:49:40', '0000-00-00 00:00:00'),
(16, '', '', '', '', '', '', 2, '2014-03-24 21:50:11', '0000-00-00 00:00:00'),
(17, 'Sergioa', 'Reya', 'Avilas', 'jikilla@hotmail.com', '55', '123', 2, '2014-03-24 21:51:05', '0000-00-00 00:00:00'),
(18, 'Sergio', 'Reyes', 'Avila', 'jikilla@hotmail.com', '5', '123', 2, '2014-03-24 21:58:34', '0000-00-00 00:00:00'),
(19, 'ab', 'ba', 'ab', 'ab', 'ab', 'a', 2, '2014-03-24 22:03:07', '0000-00-00 00:00:00'),
(20, 'acd', 'cad', 'acad', 'cada', 'cada', 'c', 2, '2014-03-24 22:05:08', '0000-00-00 00:00:00'),
(21, 'a', 'ab', 'ab', 'ab', 'a', 'ab', 2, '2014-03-24 22:08:42', '0000-00-00 00:00:00'),
(22, 'c', 'c', 'c', 'c', 'c', 'c', 2, '2014-03-24 22:20:38', '0000-00-00 00:00:00'),
(23, 'csdfs', 'cdfdf', 'cdfd', 'cdfd', 'cfdf', 'c', 2, '2014-03-24 22:23:46', '0000-00-00 00:00:00'),
(24, 'Javier', 'coronaEE', 'campilloEE', 'snsnE', 'NWE', 'N', 2, '2014-03-24 23:03:09', '0000-00-00 00:00:00'),
(25, 'acccc', 'accccc', 'acccccccc', 'accccc', 'accccc', 'a', 2, '2014-03-25 16:58:21', '0000-00-00 00:00:00'),
(26, 'aaa', 'aaa', 'aaa', 'aaa', 'aaa', 'a', 2, '2014-03-25 17:02:48', '0000-00-00 00:00:00'),
(27, 'alejandro', 'Corona', 'Campillo', 'alex_@hotmail.com', 'alex_92', 'aa', 2, '2014-03-25 17:06:25', '0000-00-00 00:00:00'),
(28, 'p', 'p', 'p', 'p', 'p', 'p', 2, '2014-03-25 17:38:10', '0000-00-00 00:00:00'),
(29, 'Sergio', 'Reyes', 'avila', 'sergio@hotmail.com', 'sergio', '123', 1, '2014-05-28 23:00:45', '0000-00-00 00:00:00'),
(30, 'zzz', 'zzz', 'zzz', 'zzz', 'zzz', 'zzz', 2, '2014-05-30 15:19:10', '0000-00-00 00:00:00'),
(31, 'Diego Alonso', 'Gomez', 'Gabriel', 'diego_dag@hotmail.com', 'diego28', '123', 1, '2014-06-04 04:46:40', '0000-00-00 00:00:00'),
(32, 'martin', 'corona', 'corona', 'aaa', 'aaaaaaa', 'aa', 2, '2014-06-04 06:12:59', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
  `id_venta` int(20) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(20) NOT NULL,
  `fecha_venta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(20) NOT NULL DEFAULT '1',
  `total` int(20) NOT NULL,
  PRIMARY KEY (`id_venta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_venta`, `id_usuario`, `fecha_venta`, `status`, `total`) VALUES
(1, 0, '2014-05-29 07:15:49', 1, 0),
(2, 0, '2014-05-29 07:17:49', 1, 0),
(3, 0, '2014-05-29 07:36:29', 1, 0),
(4, 0, '2014-05-29 19:59:12', 1, 0),
(5, 0, '2014-05-29 20:00:48', 1, 0),
(6, 0, '2014-05-29 22:02:39', 1, 0),
(7, 0, '2014-05-30 15:13:42', 1, 0),
(8, 0, '2014-05-30 15:20:42', 1, 0),
(9, 0, '2014-05-30 15:30:16', 1, 0),
(10, 0, '2014-05-30 15:33:02', 1, 0),
(11, 0, '2014-06-04 04:15:39', 1, 0),
(12, 0, '2014-06-04 04:37:44', 1, 0),
(13, 0, '2014-06-04 06:13:45', 1, 0),
(14, 0, '2014-06-04 16:35:18', 1, 0),
(15, 0, '2014-06-04 16:36:54', 1, 0),
(16, 0, '2014-06-04 16:36:55', 1, 0),
(17, 0, '2014-06-04 16:41:35', 1, 0),
(18, 0, '2014-06-04 17:10:48', 1, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
