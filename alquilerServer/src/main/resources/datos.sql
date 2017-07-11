INSERT INTO `usuario` (`id`,`apellido1`,`apellido2`,`email`,`login`,`nombre`,`pass`,`rol`) VALUES (1,'admin','admin','admin','admin','admin','admin','ADMINISTRADOR');
INSERT INTO `usuario` (`id`,`apellido1`,`apellido2`,`email`,`login`,`nombre`,`pass`,`rol`) VALUES (4,'propietario','propietario','propietario','propietario','propietario','propietario','PROPIETARIO');
INSERT INTO `usuario` (`id`,`apellido1`,`apellido2`,`email`,`login`,`nombre`,`pass`,`rol`) VALUES (5,'inquilino','inquilino','inquilino','inquilino','inquilino','inquilino','INQUILINO');

INSERT INTO `vivienda` (`id`,`resumen`,`nombre`,`usuario_fk`,`creado_por`) VALUES (7,'chalet grande','chalet',1,1);
INSERT INTO `vivienda` (`id`,`resumen`,`nombre`,`usuario_fk`,`creado_por`) VALUES (8,'apartamento pequeño','carmina',4,4);
INSERT INTO `vivienda` (`id`,`resumen`,`nombre`,`usuario_fk`,`creado_por`) VALUES (9,'aparatmento pequeño','las lanzas',4,4);
INSERT INTO `vivienda` (`id`,`resumen`,`nombre`,`usuario_fk`,`creado_por`) VALUES (10,'apartamento pequeño','la mata',1,1);
