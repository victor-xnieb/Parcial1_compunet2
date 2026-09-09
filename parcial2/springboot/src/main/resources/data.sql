
INSERT INTO Estudiante (name, apellido,email, active) VALUES ('Alejandro','Penaranda','alejandro@icesi.edu.co', TRUE);
INSERT INTO Estudiante (name, apellido,email, active) VALUES ('Juan','Ramirez','juan@icesi.edu.co', TRUE);
INSERT INTO Estudiante (name, apellido,email, active) VALUES ('Catalina','Marquez','catalina@icesi.edu.co', TRUE);

INSERT INTO Departamento (name,edificio) VALUES ('Computacion','M');

INSERT INTO Profesor (name, apellido, email,departamento_id, active) VALUES ('Domiciano','Rincon','dRincon@icesi.edu.co',1, TRUE);
INSERT INTO Profesor (name, apellido, email,departamento_id, active) VALUES ('Alejdnro','Munoz','aMunoz@icesi.edu.co',1, TRUE);
INSERT INTO Profesor (name, apellido, email,departamento_id, active) VALUES ('Kevin','Rodriguez','kRodriguez@icesi.edu.co',1, TRUE);


INSERT INTO Curso (name, creditos, departamento, profesor_id) VALUES ('APO1', 3, 'Computacion y Sistemas', 1 );
INSERT INTO Curso (name, creditos, departamento, profesor_id) VALUES ('APO2', 3, 'Computacion y Sistemas', 1 );
INSERT INTO Curso (name, creditos, departamento, profesor_id) VALUES ('APO3', 3, 'Computacion y Sistemas', 1);



