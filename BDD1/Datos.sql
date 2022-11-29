-- BORRAR TODO 
DROP VIEW IF EXISTS solicitudes_permisos,
                    personas_y_permisos;

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
    nombreapp varchar(20) NOT NULL
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
    menu_id int PRIMARY KEY,
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
    hashpwd varchar(256) NOT NULL
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

--INSERT INTO APLICATIVOS VALUES (1, 'Administrar');
INSERT INTO APLICATIVOS VALUES (1, 'Facturacion');
INSERT INTO APLICATIVOS VALUES (2, 'Inventario');
INSERT INTO APLICATIVOS VALUES (3, 'Menu');
INSERT INTO APLICATIVOS VALUES (4, 'Gestion de permisos');




-- ROLES NEGOCIO -----------------------
-- -------------------------------------
INSERT INTO ROLES_NEGOCIO VALUES (1,'administrador_de_seguridad'); -- Gestion de permisos
INSERT INTO ROLES_NEGOCIO VALUES (2, 'cocinero');  -- Ver Inventario, Ver Menu
INSERT INTO ROLES_NEGOCIO VALUES (3, 'chef');      -- Ver Inventario, Modificar Inventario, Ver Menu, Modificar Menu
INSERT INTO ROLES_NEGOCIO VALUES (4, 'mesero');    -- Crear Factura, Ver Menu, Ver Facturas

-- ROLES APLICATIVOS -----------------------
-- -----------------------------------------
--                                 rolId  AppId
INSERT INTO ROLES_APLICATIVOS VALUES (1, 1, 'Ver Facturas');           -- Facturacion
INSERT INTO ROLES_APLICATIVOS VALUES (2, 1, 'Crear Factura');          -- Facturacion
INSERT INTO ROLES_APLICATIVOS VALUES (3, 2, 'Ver Inventario');         -- Inventario
INSERT INTO ROLES_APLICATIVOS VALUES (4, 2, 'Modificar Inventario');   -- Inventario
INSERT INTO ROLES_APLICATIVOS VALUES (5, 3, 'Ver Menu');               -- Menu
INSERT INTO ROLES_APLICATIVOS VALUES (6, 3, 'Modificar Menu');         -- Menu
INSERT INTO ROLES_APLICATIVOS VALUES (7, 4, 'Administrar');            -- Gestion Permisos

-- ROLES NEGOCIOS APLICATIVOS --------------------
-- -----------------------------------------------
--                                  rol_neg_id rol_id,app_id
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (2, 3, 2); -- Cocinero, Inventario, Ver Inventario
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (2, 5, 3); -- Cocinero, Menu, Ver Menu
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (3, 3, 2); -- Chef, Inventario, Ver Inventario
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (3, 4, 2); -- Chef, Inventario, Modificar Inventario
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (3, 5, 3); -- Chef, Menu, Ver Menu
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (3, 6, 3); -- Chef, Menu, Modificar Menu
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (4, 2, 1); -- Mesero, Facturacion, Crear Factura
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (4, 5, 3); -- Mesero, Menu, Ver Menu
INSERT INTO ROLES_NEGOCIOS_APLICATIVOS VALUES (4, 1, 1); -- Mesero, Facturacion, Ver Facturas


-- APLICATIVOS MENU -----------------------
-- ----------------------------------------
                            --MenuID     AppId
INSERT INTO APLICATIVOS_MENU VALUES (1, 1, 'Listar Facturas');          -- Facturacion
INSERT INTO APLICATIVOS_MENU VALUES (2, 1, 'Crear Factura');            -- Facturacion
INSERT INTO APLICATIVOS_MENU VALUES (3, 2, 'Listar Inventario');        --Inventario
INSERT INTO APLICATIVOS_MENU VALUES (4, 2, 'Modificar Inventario');     --Inventario
INSERT INTO APLICATIVOS_MENU VALUES (5, 3, 'Listar Menu');              -- Menu
INSERT INTO APLICATIVOS_MENU VALUES (6, 3, 'Modificar Menu');           -- Menu





-- ROLES APLICATIVOS MENU -----------------------
-- ----------------------------------------------
--                                    AppId RolId MenuId
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (1, 1, 1);  
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (1, 2, 2); 
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (2, 3, 3);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (2, 4, 4);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (3, 5, 5);
INSERT INTO ROLES_APLICATIVOS_MENU VALUES (3, 6, 6);


-- PERSONAS --------------------------------------
-- -----------------------------------------------
-- contraseña sin hashear es "1234"
INSERT INTO PERSONAS VALUES (1, 'Juan', 'Cabrera', '8 de octubre', 'Montevideo', 'Montevideo', '$2a$10$fjLgD0GO7.pcJuzWY7m4Yensnq3e8hoUoKSCmdXIvxEmm0DRW7ENK');
INSERT INTO PERSONAS VALUES (2, 'Nicolas Mazzey', 'Cabrera', '8 de octubre', 'Montevideo', 'Montevideo',  '$2a$10$fjLgD0GO7.pcJuzWY7m4Yensnq3e8hoUoKSCmdXIvxEmm0DRW7ENK');
-- INSERT INTO PERSONAS VALUES (3, 'Federico', 'Ferreira', '8 de octubre', 'Montevideo', 'Montevideo', '4d186321c1a7f0f354b297e8914ab240');

--PERSONAS_PREGUNTAS------------------------------
-- -----------------------------------------------
INSERT INTO PERSONAS_PREGUNTAS VALUES (1, 1, 'mascota');
INSERT INTO PERSONAS_PREGUNTAS VALUES (2, 1, 'mascota');


-- PERMISOS ---------------------------------------
-- ------------------------------------------------

-- INSERT INTO PERMISOS VALUES (1, 1, 1, '2022/12/10', '2022/12/11', 'autorizado');
-- INSERT INTO PERMISOS VALUES (2, 2, 2, '2022/12/10', '2022/12/11', 'autorizado');
-- INSERT INTO PERMISOS VALUES (3, 3, 3, '2022/12/10', '2022/12/11', 'autorizado');

CREATE VIEW solicitudes_permisos
AS
    SELECT permisos.user_id, 
           permisos.rol_neg_id,
           permisos.app_id,
           nombres, 
           apellidos, 
           descripcion_rol_neg, 
           aplicativos.nombreapp, 
           fecha_solicitud, 
           fecha_autorizacion, 
           estado 
    FROM permisos, personas, roles_negocio, aplicativos 
    WHERE permisos.user_id = personas.user_id 
      AND permisos.rol_neg_id = roles_negocio.rol_neg_id 
      AND permisos.app_id = aplicativos.app_id; 

CREATE VIEW personas_y_permisos
AS
    SELECT personas.*,
           aplicativos.*,
           aplicativos_menu.menu_id,
           aplicativos_menu.descripcion_menu
    FROM permisos, 
         personas, 
         roles_negocio, 
         aplicativos,
         roles_negocios_aplicativos,
         roles_aplicativos_menu,
         aplicativos_menu
    WHERE permisos.user_id = personas.user_id 
      AND permisos.rol_neg_id = roles_negocio.rol_neg_id 
      AND permisos.app_id = aplicativos.app_id
      AND permisos.app_id = roles_negocios_aplicativos.app_id
      AND permisos.rol_neg_id = roles_negocios_aplicativos.rol_neg_id
      AND permisos.app_id = roles_aplicativos_menu.app_id
      AND roles_negocios_aplicativos.rol_id = roles_aplicativos_menu.rol_id
      AND aplicativos_menu.menu_id = roles_aplicativos_menu.menu_id
      AND aplicativos_menu.app_id = permisos.app_id
      AND permisos.estado = 'Autorizado'
    ;
