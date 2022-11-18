-- BORRAR TODO 
DROP TABLE APLICATIVOS,
           APLICATIVOS_MENU,
           PERMISOS,
           PERSONAS,
           PERSONAS_PREGUNTAS,
           PREGUNTAS ,
           ROLES_APLICATIVOS,
           ROLES_APLICATIVOS_MENU,
           ROLES_NEGOCIO,
           ROLES_NEGOCIOS_APLICATIVOS;

-- OK
CREATE TABLE IF NOT EXISTS PREGUNTAS (
    preg_id serial PRIMARY KEY,
    pregunta varchar(256) NOT NULL
);

-- OK
CREATE TABLE IF NOT EXISTS ROLES_NEGOCIO (
    rol_neg_id serial PRIMARY KEY,
    descripcion_rol_neg varchar(100) NOT NULL
);

-- OK
CREATE TABLE IF NOT EXISTS APLICATIVOS (
    app_id serial PRIMARY KEY,
    nobreapp varchar(20) NOT NULL
);

-- OK
CREATE TABLE IF NOT EXISTS ROLES_APLICATIVOS (
    rol_id serial PRIMARY KEY,
    app_id int NOT NULL,
    descripcion_rol varchar(100) NOT NULL,

    FOREIGN KEY (app_id) REFERENCES APLICATIVOS(app_id)
);

-- OK
CREATE TABLE IF NOT EXISTS ROLES_NEGOCIOS_APLICATIVOS (
    rol_neg_id int NOT NULL,
    rol_id int NOT NULL,
    app_id int NOT NULL,

    FOREIGN KEY (rol_neg_id) REFERENCES ROLES_NEGOCIO(rol_neg_id),
    FOREIGN KEY (rol_id) REFERENCES ROLES_APLICATIVOS(rol_id),
    FOREIGN KEY (app_id) REFERENCES APLICATIVOS(app_id)
);

-- OK
CREATE TABLE IF NOT EXISTS APLICATIVOS_MENU (
    menu_id serial PRIMARY KEY,
    app_id int NOT NULL,
    descripcion_menu varchar(100) NOT NULL,

    FOREIGN KEY (app_id) REFERENCES APLICATIVOS(app_id)
);

-- OK
CREATE TABLE IF NOT EXISTS ROLES_APLICATIVOS_MENU (
    app_id int NOT NULL,
    rol_id int NOT NULL,
    menu_id int NOT NULL,

    FOREIGN KEY (app_id) REFERENCES APLICATIVOS(app_id),
    FOREIGN KEY (rol_id) REFERENCES ROLES_APLICATIVOS(rol_id),
    FOREIGN KEY (menu_id) REFERENCES APLICATIVOS_MENU(menu_id)
);

CREATE TABLE IF NOT EXISTS PERSONAS (
    user_id serial PRIMARY KEY,
    nombres varchar(20) NOT NULL,
    apellidos varchar(20) NOT NULL,
    direccion varchar(50) NOT NULL,
    ciudad varchar(20) NOT NULL,
    departamento varchar(20) NOT NULL,
    hashpwd varchar(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS PERSONAS_PREGUNTAS (
    user_id int NOT NULL,
    preg_id int NOT NULL,
    respuesta varchar(40) NOT NULL,

    UNIQUE (user_id, preg_id),
    FOREIGN KEY (user_id) REFERENCES PERSONAS(user_id),
    FOREIGN KEY (preg_id) REFERENCES PREGUNTAS(preg_id)
);

CREATE TABLE IF NOT EXISTS PERMISOS (
    user_id int NOT NULL,
    rol_neg_id int NOT NULL,
    app_id int NOT NULL,
    fecha_solicitud date NOT NULL,
    fecha_autorizacion date,
    estado varchar(20) NOT NULL,

    FOREIGN KEY (user_id) REFERENCES PERSONAS(user_id),
    FOREIGN KEY (rol_neg_id) REFERENCES ROLES_NEGOCIO(rol_neg_id),
    FOREIGN KEY (app_id) REFERENCES APLICATIVOS(app_id)
);



-- PREGUNTAS -------------------------
-- -----------------------------------

INSERT INTO PREGUNTAS VALUES (1, '¿Cuál es el nombre de su mascota?');
INSERT INTO PREGUNTAS VALUES (2, '¿Cuál es el nombre de su restaurante favorito?');
INSERT INTO PREGUNTAS VALUES (3, '¿Cuántos hermanos tiene?');
INSERT INTO PREGUNTAS VALUES (4, '¿Cómo se llama su hermano menor?');
INSERT INTO PREGUNTAS VALUES (5, '¿Cuál es el nombre de su abuela?');


-- APLICATIVOS -------------------------
-- -------------------------------------

INSERT INTO APLICATIVOS VALUES (1, 'fritar');
INSERT INTO APLICATIVOS VALUES (2, 'hervir');
INSERT INTO APLICATIVOS VALUES (3, 'hornear');
INSERT INTO APLICATIVOS VALUES (4, 'servir');
INSERT INTO APLICATIVOS VALUES (5, 'cobrar');
INSERT INTO APLICATIVOS VALUES (6, 'reponer');
INSERT INTO APLICATIVOS VALUES (7, 'batir');
INSERT INTO APLICATIVOS VALUES (8, 'echar');
INSERT INTO APLICATIVOS VALUES (9, 'lavar');
INSERT INTO APLICATIVOS VALUES (10, 'vigilar');
INSERT INTO APLICATIVOS VALUES (11, 'putear');



-- ROLES NEGOCIO -----------------------
-- -------------------------------------

INSERT INTO ROLES_NEGOCIO VALUES (1, 'auxiliar_de_cocina');
INSERT INTO ROLES_NEGOCIO VALUES (2, 'chef');
INSERT INTO ROLES_NEGOCIO VALUES (3, 'mesero');
INSERT INTO ROLES_NEGOCIO VALUES (4, 'cajero');
INSERT INTO ROLES_NEGOCIO VALUES (5, 'personal_del_mostrador');
INSERT INTO ROLES_NEGOCIO VALUES (6, 'conserje');
INSERT INTO ROLES_NEGOCIO VALUES (7, 'repartidor');
INSERT INTO ROLES_NEGOCIO VALUES (8, 'barista');
INSERT INTO ROLES_NEGOCIO VALUES (9, 'manager');
INSERT INTO ROLES_NEGOCIO VALUES (10, 'host');
INSERT INTO ROLES_NEGOCIO VALUES (11, 'ratatuille');



-- ROLES APLICATIVOS -----------------------
-- -----------------------------------------

INSERT INTO ROLES_APLICATIVOS VALUES (1, 1, 'ayuda_al_chef');
INSERT INTO ROLES_APLICATIVOS VALUES (2, 2, 'putea_a_los_ayudantes');
INSERT INTO ROLES_APLICATIVOS VALUES (3, 3, 'toman_pedidos');
INSERT INTO ROLES_APLICATIVOS VALUES (4, 4, 'cobran');
INSERT INTO ROLES_APLICATIVOS VALUES (5, 5, 'sirven_cosas_del_mostrador');
INSERT INTO ROLES_APLICATIVOS VALUES (6, 6, 'limpia');
INSERT INTO ROLES_APLICATIVOS VALUES (7, 7, 'reparte_pedidos');
INSERT INTO ROLES_APLICATIVOS VALUES (8, 8, 'prepara_tragos');
INSERT INTO ROLES_APLICATIVOS VALUES (9, 9, 'cuida_que_no_haya_quilombo');
INSERT INTO ROLES_APLICATIVOS VALUES (10, 10, 'recibe_a_la_gente');
INSERT INTO ROLES_APLICATIVOS VALUES (11, 11, 'ratita');
INSERT INTO ROLES_APLICATIVOS VALUES (12, 12, 'administrador_de_seguridad');


-- APLICATIVOS MENU -----------------------
-- ----------------------------------------

INSERT INTO APLICATIVOS_MENU VALUES (1, 1, 'opciones_sarten');
INSERT INTO APLICATIVOS_MENU VALUES (2, 2, 'opciones_hornalla');
INSERT INTO APLICATIVOS_MENU VALUES (3, 3, 'opciones_horno');
INSERT INTO APLICATIVOS_MENU VALUES (4, 4, 'opciones_servir');
INSERT INTO APLICATIVOS_MENU VALUES (5, 5, 'opciones_caja');
INSERT INTO APLICATIVOS_MENU VALUES (6, 6, 'opciones_supermercado');
INSERT INTO APLICATIVOS_MENU VALUES (7, 7, 'opciones_batidora');
INSERT INTO APLICATIVOS_MENU VALUES (8, 8, 'opciones_despido');
INSERT INTO APLICATIVOS_MENU VALUES (9, 9, 'opciones_lavavajillas');
INSERT INTO APLICATIVOS_MENU VALUES (10, 10, 'opciones_camaras');
INSERT INTO APLICATIVOS_MENU VALUES (11, 11, 'opciones_cordobes');



-- ROLES APLICATIVOS MENU -----------------------
-- ----------------------------------------------

INSERT INTO ROLES_APLICATIVOS_MENU VALUES (1, 1, 1);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (2, 2, 2);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (3, 3, 3);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (4, 4, 4);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (5, 5, 5);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (6, 6, 6);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (7, 7, 7);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (8, 8, 8);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (9, 9, 9);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (10, 10, 10);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (11, 11, 11);


-- ROLES NEGOCIOS APLICATIVOS --------------------
-- -----------------------------------------------

INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (1, 1, 1);
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (2, 2, 2);
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (3, 3, 3);
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (4, 4, 4);
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (5, 5, 5);
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (6, 6, 6);
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (7, 7, 7);
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (8, 8, 8);
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (9, 9, 9);
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (10, 10, 10);
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (11, 11, 11);


-- PERSONAS --------------------------------------
-- -----------------------------------------------

-- INSERT INTO PERSONAS VALUES (1, 'Juan', 'Cabrera', '8 de octubre', 'Montevideo', 'Montevideo', '4d186321c1a7f0f354b297e8914ab240');
-- INSERT INTO PERSONAS VALUES (2, 'Nicolas Mazzey', 'Cabrera', '8 de octubre', 'Montevideo', 'Montevideo',  '4d186321c1a7f0f354b297e8914ab240');
-- INSERT INTO PERSONAS VALUES (3, 'Federico', 'Ferreira', '8 de octubre', 'Montevideo', 'Montevideo', '4d186321c1a7f0f354b297e8914ab240');


-- PERMISOS ---------------------------------------
-- ------------------------------------------------

-- INSERT INTO PERMISOS VALUES (1, 1, 1, '2022/12/10', '2022/12/11', 'autorizado');
-- INSERT INTO PERMISOS VALUES (2, 2, 2, '2022/12/10', '2022/12/11', 'autorizado');
-- INSERT INTO PERMISOS VALUES (3, 3, 3, '2022/12/10', '2022/12/11', 'autorizado');
