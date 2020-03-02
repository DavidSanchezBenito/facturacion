CREATE DATABASE facturacion;

CREATE TABLE `facturacion`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nif` CHAR(9) NULL,
  `nombre` VARCHAR(20) NULL,
  `direccion` VARCHAR(90) NULL,
  `tipo` CHAR(1) NULL,
  `email` VARCHAR(90) NULL,
  `telefono` VARCHAR(20) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `facturacion`.`servicios` (
  `id_servicio` INT NOT NULL AUTO_INCREMENT,
  `coste` DOUBLE NULL,
  `iva` DOUBLE NULL,
  `descrip` VARCHAR(150) NULL,
  `id` INT NULL,
  PRIMARY KEY (`id_servicio`),
  INDEX `pk_cliente_idx` (`id` ASC) VISIBLE,
  CONSTRAINT `pf_cliente` FOREIGN KEY (`id`) REFERENCES `facturacion`.`clientes` (`id`)
   ON DELETE NO ACTION ON UPDATE NO ACTION);

CREATE TABLE `formadepago` (
  `id_formadepago` int(11) NOT NULL AUTO_INCREMENT,
  `valor` double DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id_formadepago`));

CREATE TABLE `facturacion`.`contratos` (
  `id_contrato` INT NOT NULL AUTO_INCREMENT,
  `comision` DOUBLE NULL,
  `encargado` CHAR(1) NULL,
  `id` INT NULL,
  PRIMARY KEY (`id_contrato`),
  INDEX `pk_prov_idx` (`id` ASC) VISIBLE,
  CONSTRAINT `pf_prov` FOREIGN KEY (`id`) REFERENCES `facturacion`.`clientes` (`id`)
   ON DELETE NO ACTION ON UPDATE NO ACTION);

CREATE TABLE `facturacion`.`pedidos` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` double NOT NULL,
  `importe_facturado` double NOT NULL,
  `descrip` varchar(150) DEFAULT NULL,
  `id` INT NULL,
  `id_contrato` int(11) DEFAULT NULL,
  `id_servicio` int(11) DEFAULT NULL,
  `id_forma_pago` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  INDEX `pk_idp1_idx` (`id` ASC) VISIBLE,
  CONSTRAINT `pf_cpr` FOREIGN KEY (`id`) REFERENCES `facturacion`.`clientes` (`id`)
   ON DELETE NO ACTION ON UPDATE NO ACTION,
  INDEX `pk_idp2_idx` (`id_contrato` ASC) VISIBLE,
  CONSTRAINT `pf_pecon` FOREIGN KEY (`id_contrato`) REFERENCES `facturacion`.`contratos` (`id_contrato`)
   ON DELETE NO ACTION ON UPDATE NO ACTION,
  INDEX `pk_idp3_idx` (`id_servicio` ASC) VISIBLE,
  CONSTRAINT `pf_peserv` FOREIGN KEY (`id_servicio`) REFERENCES `facturacion`.`servicios` (`id_servicio`)
   ON DELETE NO ACTION ON UPDATE NO ACTION,
  INDEX `pk_idp4_idx` (`id_forma_pago` ASC) VISIBLE,
  CONSTRAINT `pf_pefp` FOREIGN KEY (`id_forma_pago`) REFERENCES `facturacion`.`formadepago` (`id_formadepago`)
   ON DELETE NO ACTION ON UPDATE NO ACTION
  );

CREATE TABLE `facturacion`.`facturas` (
  `id_factura` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `importe` DOUBLE NOT NULL,
  `iva` DOUBLE NOT NULL,
  `comcepto` VARCHAR(150) NOT NULL,
  `id` INT NULL,
  `id_contrato` INT NULL,
  `id_pedido` INT NULL,
  `id_servicio` INT NULL,
  `id_forma_pago` INT NULL,
  PRIMARY KEY (`id_factura`),
   INDEX `pk_idf1_idx` (`id` ASC) VISIBLE,
  CONSTRAINT `pf_cfr` FOREIGN KEY (`id`) REFERENCES `facturacion`.`clientes` (`id`)
   ON DELETE NO ACTION ON UPDATE NO ACTION,
  INDEX `pk_idf2_idx` (`id_contrato` ASC) VISIBLE,
  CONSTRAINT `pf_facon` FOREIGN KEY (`id_contrato`) REFERENCES `facturacion`.`contratos` (`id_contrato`)
   ON DELETE NO ACTION ON UPDATE NO ACTION,
  INDEX `pk_idf3_idx` (`id_servicio` ASC) VISIBLE,
  CONSTRAINT `pf_faserv` FOREIGN KEY (`id_servicio`) REFERENCES `facturacion`.`servicios` (`id_servicio`)
   ON DELETE NO ACTION ON UPDATE NO ACTION,
  INDEX `pk_idf4_idx` (`id_forma_pago` ASC) VISIBLE,
  CONSTRAINT `pf_fafp` FOREIGN KEY (`id_forma_pago`) REFERENCES `facturacion`.`formadepago` (`id_formadepago`)
   ON DELETE NO ACTION ON UPDATE NO ACTION
  );
  
  CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ususario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `facturacion`.`usuarios` (`ususario`, `password`) VALUES ('david', '1');
INSERT INTO `facturacion`.`usuarios` (`ususario`, `password`) VALUES ('hugo', '1');
INSERT INTO `facturacion`.`usuarios` (`ususario`, `password`) VALUES ('eduardo', '1');
INSERT INTO `facturacion`.`usuarios` (`ususario`, `password`) VALUES ('miguela', '1');


