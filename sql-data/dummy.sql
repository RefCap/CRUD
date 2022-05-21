DROP TABLE IF EXISTS `estudiante`;

CREATE TABLE estudiante (
    id int,
    nombre varchar(255),
    apellido varchar(255),
    email varchar(255),
    carrera varchar(255)
);

INSERT INTO estudiante
VALUES 
(id="1", nombre="Abril", apellido="Guzman", email="uno@gmail.com", carrera="uno"),
(id="2", nombre="Abril", apellido="Guzman", email="uno@gmail.com", carrera="uno"),
(id="3", nombre="Abril", apellido="Guzman", email="uno@gmail.com", carrera="uno");
