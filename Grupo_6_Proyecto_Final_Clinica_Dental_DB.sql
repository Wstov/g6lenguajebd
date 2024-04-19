--Base de Datos Clinica Dental

CREATE TABLE Paciente (
    ID_Paciente INT PRIMARY KEY,
    Num_Cedula  NUMBER ( 9),
    Nom_Paciente VARCHAR(100),
    Apellidos_Paciente VARCHAR(100),
    Direccion VARCHAR(255),
    Telefono_p NUMBER(8),
    Alergias VARCHAR(255),
    Enferm_Cronicas VARCHAR(255)
);

CREATE TABLE Medicos (
    ID_Medico INT PRIMARY KEY,
    Nom_Medico VARCHAR(100),
    Apellidos_Medico VARCHAR(100),
    Ced_Medico NUMBER(9),
    Telefono_m NUMBER(8),
    Turno VARCHAR(50),
    Especialidad VARCHAR(50)
);

CREATE TABLE Registro_Citas (
    ID_Cita NUMBER PRIMARY KEY,
    Hora TIMESTAMP,
    Fecha DATE,
    Consultorio VARCHAR2(255),
    ID_Paciente NUMBER,
    ID_Medico NUMBER,
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente(ID_Paciente),
    FOREIGN KEY (ID_Medico) REFERENCES Medicos(ID_Medico)
);

CREATE TABLE Insumos (
    ID_Insumos INT PRIMARY KEY,
    Nombre_Insu VARCHAR(100),
    Costo DECIMAL(10, 2),
    Ubicacion VARCHAR(255),
    Fecha_Vencimiento DATE
);


CREATE TABLE Pago (
    ID_Recibo INT PRIMARY KEY,
    Fecha DATE,
    Hora TIMESTAMP,
    ID_Paciente NUMBER,
    ID_Medico NUMBER,
    ID_Cita NUMBER,
    ID_Insumos NUMBER,
    Pago DECIMAL(10, 2),
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente(ID_Paciente),
    FOREIGN KEY (ID_Medico) REFERENCES Medicos(ID_Medico),
    FOREIGN KEY (ID_Cita) REFERENCES Registro_Citas(ID_Cita),
    FOREIGN KEY (ID_Insumos) REFERENCES Insumos(ID_Insumos)
);


CREATE TABLE Proveedores (
    ProveedorID INT PRIMARY KEY,
    Nombre VARCHAR2(255),
    Teléfono VARCHAR2(15),
    Dirección VARCHAR2(500),
    Email VARCHAR2(100)
);

CREATE TABLE Medicamentos (
    MedicamentoID INT PRIMARY KEY,
    Nombre VARCHAR2(255),
    Tipo VARCHAR2(100),
    Dosis VARCHAR2(100),
    Descripción VARCHAR2(500),
    ProveedorID INT,
    FOREIGN KEY (ProveedorID) REFERENCES Proveedores(ProveedorID)
);

CREATE TABLE Tratamientos (
    ID_Tratamiento NUMBER PRIMARY KEY,
    Nombre VARCHAR2(100),
    Descripcion VARCHAR2(255),
    Costo DECIMAL(10, 2),
    ID_Insumo INT,
    FOREIGN KEY (ID_Insumo) REFERENCES Insumos(ID_Insumos)
);

CREATE TABLE Registro_Examenes (
    ID_Examen NUMBER PRIMARY KEY,
    Tipo_Examen VARCHAR2(100),
    Resultados VARCHAR2(255),
    Fecha DATE,
    ID_Paciente NUMBER,
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente(ID_Paciente)
);

CREATE TABLE Comentarios_Cita (
    ID_Comentario INT PRIMARY KEY,
    ID_Cita INT,
    ID_Paciente INT,
    Fecha DATE,
    Comentario VARCHAR(500),
    FOREIGN KEY (ID_Cita) REFERENCES Registro_Citas(ID_Cita),
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente(ID_Paciente)
);

--------------------------------------------------------------------------------------------

--25 procedimientos

--1. Insertar nuevo paciente

CREATE OR REPLACE PROCEDURE Insertar_Paciente(
    p_ID_Paciente IN INT,
    p_Num_Cedula IN NUMBER,
    p_Nom_Paciente IN VARCHAR2,
    p_Apellidos_Paciente IN VARCHAR2,
    p_Direccion IN VARCHAR2,
    p_Telefono_p IN NUMBER,
    p_Alergias IN VARCHAR2,
    p_Enferm_Cronicas IN VARCHAR2
)
IS
BEGIN
    INSERT INTO Paciente(ID_Paciente, Num_Cedula, Nom_Paciente, Apellidos_Paciente, Direccion, Telefono_p, Alergias, Enferm_Cronicas)
    VALUES (p_ID_Paciente, p_Num_Cedula, p_Nom_Paciente, p_Apellidos_Paciente, p_Direccion, p_Telefono_p, p_Alergias, p_Enferm_Cronicas);
    COMMIT;
END Insertar_Paciente;
/

BEGIN
    Insertar_Paciente(
        p_ID_Paciente => 26,
        p_Num_Cedula => 112270854,
        p_Nom_Paciente => 'Juan',
        p_Apellidos_Paciente => 'Pérez',
        p_Direccion => 'Calle Principal, San-Jose',
        p_Telefono_p => 88664455,
        p_Alergias => 'Polen',
        p_Enferm_Cronicas => 'Hipertensión'
    );
END;
/

--2. Insertar Medico

CREATE OR REPLACE PROCEDURE Insertar_Medico(
    p_ID_Medico IN INT,
    p_Nom_Medico IN VARCHAR2,
    p_Apellidos_Medico IN VARCHAR2,
    p_Ced_Medico IN NUMBER,
    p_Telefono_m IN NUMBER,
    p_Turno IN VARCHAR2,
    p_Especialidad IN VARCHAR2
)
IS
BEGIN
    INSERT INTO Medicos(ID_Medico, Nom_Medico, Apellidos_Medico, Ced_Medico, Telefono_m, Turno, Especialidad)
    VALUES (p_ID_Medico, p_Nom_Medico, p_Apellidos_Medico, p_Ced_Medico, p_Telefono_m, p_Turno, p_Especialidad);
    COMMIT;
END;
/

BEGIN
    Insertar_Medico(
        p_ID_Medico => 26,
        p_Nom_Medico => 'Ana',
        p_Apellidos_Medico => 'González',
        p_Ced_Medico => 12570985,
        p_Telefono_m => 88765432,
        p_Turno => 'Mañana',
        p_Especialidad => 'Odontologa'
    );
END;
/

--3. Insertar registro de citas

CREATE OR REPLACE PROCEDURE Insertar_Registro_Citas(
    p_ID_Cita IN NUMBER,
    p_Hora IN TIMESTAMP,
    p_Fecha IN DATE,
    p_Consultorio IN VARCHAR2,
    p_ID_Paciente IN NUMBER,
    p_ID_Medico IN NUMBER
)
IS
BEGIN
    INSERT INTO Registro_Citas(ID_Cita, Hora, Fecha, Consultorio, ID_Paciente, ID_Medico)
    VALUES (p_ID_Cita, p_Hora, p_Fecha, p_Consultorio, p_ID_Paciente, p_ID_Medico);
    COMMIT;
END;
/


BEGIN
    Insertar_Registro_Citas(
        p_ID_Cita => 26,
        p_Hora => TO_TIMESTAMP('2024-03-06 13:15:00', 'YYYY-MM-DD HH24:MI:SS'),
        p_Fecha => TO_DATE('2024-03-06', 'YYYY-MM-DD'),
        p_Consultorio => 'P209',
        p_ID_Paciente => 26,
        p_ID_Medico => 4
    );
END;
/



--4. Insertar insumos--

CREATE OR REPLACE PROCEDURE Insertar_Insumos(
    p_ID_Insumos IN INT,
    p_Nombre_Insu IN VARCHAR2,
    p_Costo IN DECIMAL,
    p_Ubicacion IN VARCHAR2,
    p_Fecha_Vencimiento IN DATE
)
IS
BEGIN
    INSERT INTO Insumos(ID_Insumos, Nombre_Insu, Costo, Ubicacion, Fecha_Vencimiento)
    VALUES (p_ID_Insumos, p_Nombre_Insu, p_Costo, p_Ubicacion, p_Fecha_Vencimiento);
    COMMIT;
END;
/


BEGIN
    Insertar_Insumos(
        p_ID_Insumos => 26,
        p_Nombre_Insu => 'Vendaje',
        p_Costo => 10000,
        p_Ubicacion => 'BPB',
        p_Fecha_Vencimiento => TO_DATE('2024-12-31', 'YYYY-MM-DD')
    );
END;
/


--5. Actualizar Paciente

CREATE OR REPLACE PROCEDURE Actualizar_Informacion_Paciente(
    p_ID_Paciente IN INT,
    p_Nom_Paciente IN VARCHAR2,
    p_Apellidos_Paciente IN VARCHAR2,
    p_Direccion IN VARCHAR2,
    p_Telefono_p IN NUMBER,
    p_Alergias IN VARCHAR2,
    p_Enferm_Cronicas IN VARCHAR2
)
IS
BEGIN
    UPDATE Paciente
    SET Nom_Paciente = p_Nom_Paciente,
        Apellidos_Paciente = p_Apellidos_Paciente,
        Direccion = p_Direccion,
        Telefono_p = p_Telefono_p,
        Alergias = p_Alergias,
        Enferm_Cronicas = p_Enferm_Cronicas
    WHERE ID_Paciente = p_ID_Paciente;
    COMMIT;
END;
/

BEGIN
    Actualizar_Informacion_Paciente(
        p_ID_Paciente => 25,
        p_Nom_Paciente => 'Julieta',
        p_Apellidos_Paciente => 'Fallas',
        p_Direccion => 'Calle Segunda, San-Jose',
        p_Telefono_p => 98234567,
        p_Alergias => 'Polvo',
        p_Enferm_Cronicas => 'Hipertensión'
    );
END;
/


--6. Actualizar Medico

CREATE OR REPLACE PROCEDURE Actualizar_Informacion_Medico(
    p_ID_Medico IN INT,
    p_Nom_Medico IN VARCHAR2,
    p_Apellidos_Medico IN VARCHAR2,
    p_Ced_Medico IN NUMBER,
    p_Telefono_m IN NUMBER,
    p_Turno IN VARCHAR2,
    p_Especialidad IN VARCHAR2
)
IS
BEGIN
    UPDATE Medicos
    SET Nom_Medico = p_Nom_Medico,
        Apellidos_Medico = p_Apellidos_Medico,
        Ced_Medico = p_Ced_Medico,
        Telefono_m = p_Telefono_m,
        Turno = p_Turno,
        Especialidad = p_Especialidad
    WHERE ID_Medico = p_ID_Medico;
    COMMIT;
END;
/

BEGIN
    Actualizar_Informacion_Medico(
        p_ID_Medico => 25,
        p_Nom_Medico => 'Jorge',
        p_Apellidos_Medico => 'Chávez López',
        p_Ced_Medico => 667890234,
        p_Telefono_m => 57234567,
        p_Turno => 'Tarde',
        p_Especialidad => 'Dentistageneral'
    );
END;
/


--7. Actualizar Registro de citas

CREATE OR REPLACE PROCEDURE Actualizar_Registro_Citas(
    p_ID_Cita IN NUMBER,
    p_Hora IN TIMESTAMP,
    p_Fecha IN DATE,
    p_Consultorio IN VARCHAR2,
    p_ID_Paciente IN NUMBER,
    p_ID_Medico IN NUMBER
)
IS
BEGIN
    UPDATE Registro_Citas
    SET Hora = p_Hora,
        Fecha = p_Fecha,
        Consultorio = p_Consultorio,
        ID_Paciente = p_ID_Paciente,
        ID_Medico = p_ID_Medico
    WHERE ID_Cita = p_ID_Cita;
    COMMIT;
END;
/

BEGIN
    Actualizar_Registro_Citas(
        p_ID_Cita => 25,
        p_Hora => TO_TIMESTAMP('2024-03-21 14:30:00', 'YYYY-MM-DD HH24:MI:SS'),
        p_Fecha => TO_DATE('2024-03-21', 'YYYY-MM-DD'),
        p_Consultorio => 'P124',
        p_ID_Paciente => 25,
        p_ID_Medico => 3
    );
END;
/


--8. Actualizar insumos

CREATE OR REPLACE PROCEDURE Actualizar_Informacion_Insumos(
    p_ID_Insumos IN INT,
    p_Nombre_Insu IN VARCHAR2,
    p_Costo IN DECIMAL,
    p_Ubicacion IN VARCHAR2,
    p_Fecha_Vencimiento IN DATE
)
IS
BEGIN
    UPDATE Insumos
    SET Nombre_Insu = p_Nombre_Insu,
        Costo = p_Costo,
        Ubicacion = p_Ubicacion,
        Fecha_Vencimiento = p_Fecha_Vencimiento
    WHERE ID_Insumos = p_ID_Insumos;
    COMMIT;
END;
/

BEGIN
    Actualizar_Informacion_Insumos(
        p_ID_Insumos => 25,
        p_Nombre_Insu => 'Gasas estériles',
        p_Costo => 5000,
        p_Ubicacion => 'BP1',
        p_Fecha_Vencimiento => TO_DATE('15/04/24')
    );
END;
/



--9. Listado de Insumos

CREATE OR REPLACE PROCEDURE Listar_Insumos
IS
BEGIN
    FOR rec IN (SELECT ID_Insumos, Nombre_Insu, Costo, Ubicacion, Fecha_Vencimiento FROM Insumos)
    LOOP
        DBMS_OUTPUT.PUT_LINE('ID Insumo: ' || rec.ID_Insumos || ', Nombre: ' || rec.Nombre_Insu || ', Costo: ' || rec.Costo || ', Ubicacion: ' || rec.Ubicacion || ', Fecha de Vencimiento: ' || TO_CHAR(rec.Fecha_Vencimiento, 'YYYY-MM-DD'));
    END LOOP;
END;
/
--10. listado de Citas

PROCEDURE Listar_Citas AS
    CURSOR c_citas IS
        SELECT * FROM Registro_Citas;
    -- Variables para almacenar los datos de cada fila
    v_id_cita Registro_Citas.ID_Cita%TYPE;
    v_hora_cita Registro_Citas.Hora%TYPE;
    v_fecha_cita Registro_Citas.Fecha%TYPE;
    v_consultorio Registro_Citas.Consultorio%TYPE;
    v_id_paciente Registro_Citas.ID_Paciente%TYPE;
    v_id_medico Registro_Citas.ID_Medico%TYPE;
BEGIN
    OPEN c_citas;
    LOOP
        FETCH c_citas INTO v_id_cita, v_hora_cita, v_fecha_cita, v_consultorio, v_id_paciente, v_id_medico;
        EXIT WHEN c_citas%NOTFOUND;
        -- Operaciones con los datos obtenidos
        DBMS_OUTPUT.PUT_LINE('ID Cita: ' || v_id_cita || ', Hora: ' || v_hora_cita || ', Fecha: ' || v_fecha_cita || ', Consultorio: ' || v_consultorio || ', ID Paciente: ' || v_id_paciente || ', ID Medico: ' || v_id_medico);
    END LOOP;
    CLOSE c_citas;
END Listar_Citas;


--11. Listado de medicos

PROCEDURE Listar_Medicos AS
    CURSOR c_medicos IS
        SELECT ID_Medico, Nom_Medico FROM Medicos;
    -- Variables para almacenar los datos de cada fila
    v_id_medico Medicos.ID_Medico%TYPE;
    v_nom_medico Medicos.Nom_Medico%TYPE;
BEGIN
    OPEN c_medicos;
    LOOP
        FETCH c_medicos INTO v_id_medico, v_nom_medico;
        EXIT WHEN c_medicos%NOTFOUND;
        -- Operaciones con los datos obtenidos
        DBMS_OUTPUT.PUT_LINE('ID Medico: ' || v_id_medico || ', Nombre: ' || v_nom_medico);
    END LOOP;
    CLOSE c_medicos;
END Listar_Medicos;

--12. Listado de Paciente

PROCEDURE Listar_Pacientes AS
    CURSOR c_pacientes IS
        SELECT * FROM Paciente;
    v_id_paciente Paciente.ID_Paciente%TYPE;
    v_num_cedula Paciente.Num_Cedula%TYPE;
    v_nom_paciente Paciente.Nom_Paciente%TYPE;
    v_apellidos_paciente Paciente.Apellidos_Paciente%TYPE;
    v_direccion Paciente.Direccion%TYPE;
    v_telefono_p Paciente.Telefono_p%TYPE;
    v_alergias Paciente.Alergias%TYPE;
    v_enferm_cronicas Paciente.Enferm_Cronicas%TYPE;
BEGIN

    DBMS_OUTPUT.PUT_LINE('Listado de Pacientes:');
    DBMS_OUTPUT.PUT_LINE('ID_PACIENTE | NUM_CEDULA | NOM_PACIENTE | APELLIDOS_PACIENTE | DIRECCION | TELEFONO_P | ALERGIAS | ENFERM_CRONICAS');
    DBMS_OUTPUT.PUT_LINE('-------------------------------------------------------------------------------------------------');

    OPEN c_pacientes;

    LOOP
        FETCH c_pacientes INTO v_id_paciente, v_num_cedula, v_nom_paciente, v_apellidos_paciente, v_direccion, v_telefono_p, v_alergias, v_enferm_cronicas;
        EXIT WHEN c_pacientes%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(v_id_paciente || ' | ' || v_num_cedula || ' | ' || v_nom_paciente || ' | ' || v_apellidos_paciente || ' | ' || v_direccion || ' | ' || v_telefono_p || ' | ' || v_alergias || ' | ' || v_enferm_cronicas);
    END LOOP;

    CLOSE c_pacientes;
END;

--13. Registrar un pago

CREATE OR REPLACE PROCEDURE Registrar_Pago(
    p_ID_Recibo IN INT,
    p_Fecha IN DATE,
    p_Hora IN TIMESTAMP,
    p_ID_Paciente IN NUMBER,
    p_ID_Medico IN NUMBER,
    p_ID_Cita IN NUMBER,
    p_ID_Insumos IN NUMBER,
    p_Pago IN DECIMAL
)
IS
BEGIN
    INSERT INTO Pago(ID_Recibo, Fecha, Hora, ID_Paciente, ID_Medico, ID_Cita, ID_Insumos, Pago)
    VALUES (p_ID_Recibo, p_Fecha, p_Hora, p_ID_Paciente, p_ID_Medico, p_ID_Cita, p_ID_Insumos, p_Pago);
    COMMIT;
END;
/


--14. Actualizar un pago

CREATE OR REPLACE PROCEDURE Actualizar_Pago(
    p_ID_Recibo IN INT,
    p_Fecha IN DATE,
    p_Hora IN TIMESTAMP,
    p_ID_Paciente IN NUMBER,
    p_ID_Medico IN NUMBER,
    p_ID_Cita IN NUMBER,
    p_ID_Insumos IN NUMBER,
    p_Pago IN DECIMAL
)
IS
BEGIN
    UPDATE Pago
    SET Fecha = p_Fecha,
        Hora = p_Hora,
        ID_Paciente = p_ID_Paciente,
        ID_Medico = p_ID_Medico,
        ID_Cita = p_ID_Cita,
        ID_Insumos = p_ID_Insumos,
        Pago = p_Pago
    WHERE ID_Recibo = p_ID_Recibo;
    COMMIT;
END;
/

--15. Eliminar un pago

CREATE OR REPLACE PROCEDURE Eliminar_Pago(
    p_ID_Recibo IN INT
)
IS
BEGIN
    DELETE FROM Pago
    WHERE ID_Recibo = p_ID_Recibo;
    COMMIT;
END;
/

--16. Registrar un nuevo proveedor

CREATE OR REPLACE PROCEDURE Registrar_Proveedor(
    p_ProveedorID IN INT,
    p_Nombre IN VARCHAR2,
    p_Teléfono IN VARCHAR2,
    p_Dirección IN VARCHAR2,
    p_Email IN VARCHAR2
)
IS
BEGIN
    INSERT INTO Proveedores(ProveedorID, Nombre, Teléfono, Dirección, Email)
    VALUES (p_ProveedorID, p_Nombre, p_Teléfono, p_Dirección, p_Email);
    COMMIT;
END;
/

--17. Actualizar información de proveedor

CREATE OR REPLACE PROCEDURE Actualizar_Proveedor(
    p_ProveedorID IN INT,
    p_Nombre IN VARCHAR2,
    p_Teléfono IN VARCHAR2,
    p_Dirección IN VARCHAR2,
    p_Email IN VARCHAR2
)
IS
BEGIN
    UPDATE Proveedores
    SET Nombre = p_Nombre,
        Teléfono = p_Teléfono,
        Dirección = p_Dirección,
        Email = p_Email
    WHERE ProveedorID = p_ProveedorID;
    COMMIT;
END;
/

--18. Eliminar un proveedor

CREATE OR REPLACE PROCEDURE Eliminar_Proveedor(
    p_ProveedorID IN INT
)
IS
BEGIN
    DELETE FROM Proveedores
    WHERE ProveedorID = p_ProveedorID;
    COMMIT;
END;
/

--19. Registrar Medicamento

CREATE OR REPLACE PROCEDURE Registrar_Medicamento(
    p_MedicamentoID IN INT,
    p_Nombre IN VARCHAR2,
    p_Tipo IN VARCHAR2,
    p_Dosis IN VARCHAR2,
    p_Descripción IN VARCHAR2,
    p_ProveedorID IN INT
)
IS
BEGIN
    INSERT INTO Medicamentos(MedicamentoID, Nombre, Tipo, Dosis, Descripción, ProveedorID)
    VALUES (p_MedicamentoID, p_Nombre, p_Tipo, p_Dosis, p_Descripción, p_ProveedorID);
    COMMIT;
END;
/

--20. Actualizar Medicamento

CREATE OR REPLACE PROCEDURE Actualizar_Medicamento(
    p_MedicamentoID IN INT,
    p_Nombre IN VARCHAR2,
    p_Tipo IN VARCHAR2,
    p_Dosis IN VARCHAR2,
    p_Descripción IN VARCHAR2,
    p_ProveedorID IN INT
)
IS
BEGIN
    UPDATE Medicamentos
    SET Nombre = p_Nombre,
        Tipo = p_Tipo,
        Dosis = p_Dosis,
        Descripción = p_Descripción,
        ProveedorID = p_ProveedorID
    WHERE MedicamentoID = p_MedicamentoID;
    COMMIT;
END;
/

--21. Eliminar Medicamento

CREATE OR REPLACE PROCEDURE Eliminar_Medicamento(
    p_MedicamentoID IN INT
)
IS
BEGIN
    DELETE FROM Medicamentos
    WHERE MedicamentoID = p_MedicamentoID;
    COMMIT;
END;
/

--22. Registrar Tratamiento

CREATE OR REPLACE PROCEDURE Registrar_Tratamiento(
    p_ID_Tratamiento IN NUMBER,
    p_Nombre IN VARCHAR2,
    p_Descripcion IN VARCHAR2,
    p_Costo IN DECIMAL,
    p_ID_Insumo IN INT
)
IS
BEGIN
    INSERT INTO Tratamientos(ID_Tratamiento, Nombre, Descripcion, Costo, ID_Insumo)
    VALUES (p_ID_Tratamiento, p_Nombre, p_Descripcion, p_Costo, p_ID_Insumo);
    COMMIT;
END;
/

--23. Actualizar Tratamiento

CREATE OR REPLACE PROCEDURE Actualizar_Tratamiento(
    p_ID_Tratamiento IN NUMBER,
    p_Nombre IN VARCHAR2,
    p_Descripcion IN VARCHAR2,
    p_Costo IN DECIMAL,
    p_ID_Insumo IN INT
)
IS
BEGIN
    UPDATE Tratamientos
    SET Nombre = p_Nombre,
        Descripcion = p_Descripcion,
        Costo = p_Costo,
        ID_Insumo = p_ID_Insumo
    WHERE ID_Tratamiento = p_ID_Tratamiento;
    COMMIT;
END;
/

--24. Eliminar Tratamiento

CREATE OR REPLACE PROCEDURE Eliminar_Tratamiento(
    p_ID_Tratamiento IN NUMBER
)
IS
BEGIN
    DELETE FROM Tratamientos
    WHERE ID_Tratamiento = p_ID_Tratamiento;
    COMMIT;
END;
/

--25. Registrar Examen Médico

CREATE OR REPLACE PROCEDURE Registrar_Examen(
    p_ID_Examen IN NUMBER,
    p_Tipo_Examen IN VARCHAR2,
    p_Resultados IN VARCHAR2,
    p_Fecha IN DATE,
    p_ID_Paciente IN NUMBER
)
IS
BEGIN
    INSERT INTO Registro_Examenes(ID_Examen, Tipo_Examen, Resultados, Fecha, ID_Paciente)
    VALUES (p_ID_Examen, p_Tipo_Examen, p_Resultados, p_Fecha, p_ID_Paciente);
    COMMIT;
END;
/



-------------------------------------------------------------------------------------------

-- Genmeracion de 5 VISTAS

--1. Vista Detalles de Citas

CREATE VIEW Vista_Detalles_Citas AS
SELECT RC.ID_Cita, P.Nom_Paciente, P.Apellidos_Paciente, M.Nom_Medico, M.Apellidos_Medico, RC.Consultorio, RC.Hora, RC.Fecha
FROM Registro_Citas RC
INNER JOIN Paciente P ON RC.ID_Paciente = P.ID_Paciente
INNER JOIN Medicos M ON RC.ID_Medico = M.ID_Medico;

--2. Vista Medicos y Activos

CREATE VIEW Vista_Medicos_Activos AS
SELECT ID_Medico, Nom_Medico, Apellidos_Medico
FROM Medicos
WHERE Especialidad = 'Ortodoncista';

--3. Vista para pacientes que pagaron mas de 60000
CREATE VIEW Vista_Pacientes_Pago_Mayor_60000 AS
SELECT DISTINCT P.ID_Paciente, P.Nom_Paciente, P.Apellidos_Paciente
FROM Pago PA
JOIN Paciente P ON PA.ID_Paciente = P.ID_Paciente
GROUP BY P.ID_Paciente, P.Nom_Paciente, P.Apellidos_Paciente
HAVING SUM(PA.Pago) > 60000;

--4. Vista para ver la cantidad de citas de un dentista general
CREATE VIEW Vista_Cantidad_Citas_Dentista_General AS
SELECT M.ID_Medico, M.Nom_Medico, M.Apellidos_Medico, COUNT(RC.ID_Cita) AS Cantidad_Citas
FROM Medicos M
LEFT JOIN Registro_Citas RC ON M.ID_Medico = RC.ID_Medico
WHERE M.Especialidad = 'Dentistageneral'
GROUP BY M.ID_Medico, M.Nom_Medico, M.Apellidos_Medico;


--5. Vista Medicos de turno en la mañana
CREATE VIEW Vista_Medicos_Turno_Mañana AS
SELECT ID_Medico, Nom_Medico, Apellidos_Medico, Especialidad
FROM Medicos
WHERE Turno = 'Mañana';

--6. Vista Pacientes Con Alergia Polen
CREATE VIEW Vista_Pacientes_Con_Alergia_Polen AS
SELECT *
FROM Paciente
WHERE Alergias LIKE '%Polen%';

--7. Vista Pacientes Enferm Cronicas Con Asma 
CREATE VIEW Vista_Pacientes_Enferm_Cronicas_Con_Asma AS
SELECT *
FROM Paciente
WHERE Enferm_Cronicas LIKE '%Asma%';

--8. Vista Medicos Endodoncistas
CREATE VIEW Vista_Medicos_Endodoncistas AS
SELECT Nom_Medico, Apellidos_Medico
FROM Medicos
WHERE Especialidad = 'Endodoncista';

--9. Vista Medicos Periodoncista
CREATE VIEW Vista_Medicos_Periodoncista AS
SELECT Nom_Medico, Apellidos_Medico
FROM Medicos
WHERE Especialidad = 'Periodoncista';

--10. Vista Insumos En Ubicacion BP1
CREATE VIEW Vista_Insumos_En_Ubicacion_BP1 AS
SELECT *
FROM Insumos
WHERE Ubicacion = 'BP1';

SELECT * FROM Vista_Insumos_En_Ubicacion_BP1;



---------------------------------------------------------------------------------------

-- Elaboracion de 15 funciones
--1. Secuencia pacientes
CREATE SEQUENCE SecuenciaPacientes
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;


--2. Funcion pacientes Nuevo

CREATE OR REPLACE FUNCTION RegistrarNuevoPaciente(
    p_Nombre VARCHAR2,
    p_Apellido VARCHAR2,
    p_Telefono VARCHAR2,
    p_CorreoElectronico VARCHAR2
)
RETURN NUMBER
AS
    v_NuevoIdPaciente NUMBER;
BEGIN
    -- Obtener el próximo valor de la secuencia para IdPaciente
    SELECT SecuenciaPacientes.NEXTVAL INTO v_NuevoIdPaciente FROM DUAL;

    -- Insertar el nuevo paciente
    INSERT INTO Pacientes (IdPaciente, Nombre, Apellido, Telefono, CorreoElectronico)
    VALUES (v_NuevoIdPaciente, p_Nombre, p_Apellido, p_Telefono, p_CorreoElectronico);

    RETURN v_NuevoIdPaciente;
END;
/


DECLARE
    nuevoId NUMBER;
BEGIN
    nuevoId := RegistrarNuevoPaciente('NombreEjemplo', 'ApellidoEjemplo', '123456789', 'ejemplo@correo.com');
    DBMS_OUTPUT.PUT_LINE('Nuevo IdPaciente: ' || nuevoId);
END;
/


--3. Listar pacintes
CREATE OR REPLACE FUNCTION ListarTodosLosPacientes
RETURN SYS_REFCURSOR
AS
   v_Cursor SYS_REFCURSOR;
BEGIN
   OPEN v_Cursor FOR
      SELECT * FROM Paciente;
   RETURN v_Cursor;
END;
/


--4. Buscar pacinete por ID
CREATE OR REPLACE FUNCTION BuscarPacientePorId(
   p_IdPaciente NUMBER
)
RETURN SYS_REFCURSOR
AS
   v_Cursor SYS_REFCURSOR;
BEGIN
   OPEN v_Cursor FOR
      SELECT * FROM Paciente WHERE IdPaciente = p_IdPaciente;
   RETURN v_Cursor;
END;
/


--5. Modificar Informacion Paciente
CREATE OR REPLACE PROCEDURE ModificarInformacionPaciente(
   p_IdPaciente NUMBER,
   p_NuevoNombre VARCHAR2,
   p_NuevoApellido VARCHAR2,
   p_NuevoTelefono VARCHAR2,
   p_NuevoCorreoElectronico VARCHAR2
)
AS
BEGIN
   UPDATE Pacientes
   SET Nombre = p_NuevoNombre,
       Apellido = p_NuevoApellido,
       Telefono = p_NuevoTelefono,
       CorreoElectronico = p_NuevoCorreoElectronico
   WHERE IdPaciente = p_IdPaciente;
END;
/

--6. Listar Citas Por Medico
CREATE OR REPLACE FUNCTION ListarCitasPorMedico(
   p_IdMedico NUMBER
)
RETURN SYS_REFCURSOR
AS
   v_Cursor SYS_REFCURSOR;
BEGIN
   OPEN v_Cursor FOR
      SELECT * FROM REGISTRO_CITAS WHERE IdMedico = p_IdMedico;
   RETURN v_Cursor;
END;
/


--7. Calcular Duracion Cita
CREATE OR REPLACE FUNCTION CalcularDuracionCita(
   p_IdCita NUMBER
)
RETURN NUMBER
AS
   v_Duracion NUMBER;
BEGIN
   SELECT EXTRACT(MINUTE FROM (FechaHoraFin - FechaHoraCita)) INTO v_Duracion
   FROM (
      SELECT FechaHoraCita, LEAD(FechaHoraCita) OVER (ORDER BY FechaHoraCita) AS FechaHoraFin
      FROM REGISTRO_CITAS
      WHERE IdCita = p_IdCita
   );
   RETURN v_Duracion;
END;
/


--8. Listar Citas Por Rango Fechas
CREATE OR REPLACE FUNCTION ListarCitasPorRangoFechas(
   p_FechaInicio TIMESTAMP,
   p_FechaFin TIMESTAMP
)
RETURN SYS_REFCURSOR
AS
   v_Cursor SYS_REFCURSOR;
BEGIN
   OPEN v_Cursor FOR
      SELECT * FROM REGISTRO_CITAS
      WHERE FechaHoraCita BETWEEN p_FechaInicio AND p_FechaFin;
   RETURN v_Cursor;
END;
/

--10. Contar Citas Por Estado
CREATE OR REPLACE FUNCTION ContarCitasPorEstado(
   p_Estado VARCHAR2
)
RETURN NUMBER
AS
   v_Contador NUMBER;
BEGIN
   SELECT COUNT(*) INTO v_Contador
   FROM REGISTRO_CITAS
   WHERE Estado = p_Estado;
   RETURN v_Contador;
END;
/


--11. Listar Citas Pendientes Por Medico
CREATE OR REPLACE FUNCTION ListarCitasPendientesPorMedico(
   p_IdMedico NUMBER
)
RETURN SYS_REFCURSOR
AS
   v_Cursor SYS_REFCURSOR;
BEGIN
   OPEN v_Cursor FOR
      SELECT * FROM REGISTRO_CITAS
      WHERE IdMedico = p_IdMedico
      AND Estado = 'Pendiente';
   RETURN v_Cursor;
END;
/

--12. Listar Citas Por Recurso
CREATE OR REPLACE FUNCTION ListarCitasPorRecurso(
   p_IdRecurso NUMBER
)
RETURN SYS_REFCURSOR
AS
   v_Cursor SYS_REFCURSOR;
BEGIN
   OPEN v_Cursor FOR
      SELECT * FROM REGISTRO_CITAS
      WHERE IdRecurso = p_IdRecurso;
   RETURN v_Cursor;
END;
/


--13. Eliminar Citas Pasadas
CREATE OR REPLACE PROCEDURE EliminarCitasPasadas
AS
BEGIN
   DELETE FROM Citas
   WHERE FechaHoraCita < SYSTIMESTAMP;
END;
/


--14. Listar Citas Pendientes
CREATE OR REPLACE FUNCTION ListarCitasPendientes
RETURN SYS_REFCURSOR
AS
   v_Cursor SYS_REFCURSOR;
BEGIN
   OPEN v_Cursor FOR
      SELECT * FROM REGISTRO_CITAS WHERE Estado = 'Pendiente';
   RETURN v_Cursor;
END;
/

----------------------------------------------------------------------------------------
--Realizar 10 paquetes

--1. Paquete de Gestión de Pacientes

CREATE OR REPLACE PACKAGE pkg_gestion_pacientes AS
    PROCEDURE insertar_paciente(p_id INT, p_cedula NUMBER, p_nombre VARCHAR2, p_apellidos VARCHAR2, p_direccion VARCHAR2, p_telefono NUMBER, p_alergias VARCHAR2, p_enfermedades VARCHAR2);
    PROCEDURE actualizar_paciente(p_id INT, p_nombre VARCHAR2, p_apellidos VARCHAR2, p_direccion VARCHAR2, p_telefono NUMBER, p_alergias VARCHAR2, p_enfermedades VARCHAR2);
    PROCEDURE eliminar_paciente(p_id INT);
END pkg_gestion_pacientes;
/

CREATE OR REPLACE PACKAGE BODY pkg_gestion_pacientes AS
    PROCEDURE insertar_paciente(p_id INT, p_cedula NUMBER, p_nombre VARCHAR2, p_apellidos VARCHAR2, p_direccion VARCHAR2, p_telefono NUMBER, p_alergias VARCHAR2, p_enfermedades VARCHAR2) IS
    BEGIN
        INSERT INTO Paciente VALUES (p_id, p_cedula, p_nombre, p_apellidos, p_direccion, p_telefono, p_alergias, p_enfermedades);
        COMMIT;
    END insertar_paciente;

    PROCEDURE actualizar_paciente(p_id INT, p_nombre VARCHAR2, p_apellidos VARCHAR2, p_direccion VARCHAR2, p_telefono NUMBER, p_alergias VARCHAR2, p_enfermedades VARCHAR2) IS
    BEGIN
        UPDATE Paciente SET Nom_Paciente = p_nombre, Apellidos_Paciente = p_apellidos, Direccion = p_direccion, Telefono_p = p_telefono, Alergias = p_alergias, Enferm_Cronicas = p_enfermedades WHERE ID_Paciente = p_id;
        COMMIT;
    END actualizar_paciente;

    PROCEDURE eliminar_paciente(p_id INT) IS
    BEGIN
        DELETE FROM Paciente WHERE ID_Paciente = p_id;
        COMMIT;
    END eliminar_paciente;
END pkg_gestion_pacientes;
/


--2. Paquete de Gestión de Citas

CREATE OR REPLACE PACKAGE pkg_gestion_citas AS
    PROCEDURE agendar_cita(p_id_cita NUMBER, p_hora TIMESTAMP, p_fecha DATE, p_consultorio VARCHAR2, p_id_paciente NUMBER, p_id_medico NUMBER);
    PROCEDURE actualizar_cita(p_id_cita NUMBER, p_hora TIMESTAMP, p_fecha DATE, p_consultorio VARCHAR2, p_id_paciente NUMBER, p_id_medico NUMBER);
    PROCEDURE cancelar_cita(p_id_cita NUMBER);
END pkg_gestion_citas;
/

CREATE OR REPLACE PACKAGE BODY pkg_gestion_citas AS
    PROCEDURE agendar_cita(p_id_cita NUMBER, p_hora TIMESTAMP, p_fecha DATE, p_consultorio VARCHAR2, p_id_paciente NUMBER, p_id_medico NUMBER) IS
    BEGIN
        INSERT INTO Registro_Citas VALUES (p_id_cita, p_hora, p_fecha, p_consultorio, p_id_paciente, p_id_medico);
        COMMIT;
    END agendar_cita;

    PROCEDURE actualizar_cita(p_id_cita NUMBER, p_hora TIMESTAMP, p_fecha DATE, p_consultorio VARCHAR2, p_id_paciente NUMBER, p_id_medico NUMBER) IS
    BEGIN
        UPDATE Registro_Citas SET Hora = p_hora, Fecha = p_fecha, Consultorio = p_consultorio, ID_Paciente = p_id_paciente, ID_Medico = p_id_medico WHERE ID_Cita = p_id_cita;
        COMMIT;
    END actualizar_cita;

    PROCEDURE cancelar_cita(p_id_cita NUMBER) IS
    BEGIN
        DELETE FROM Registro_Citas WHERE ID_Cita = p_id_cita;
        COMMIT;
    END cancelar_cita;
END pkg_gestion_citas;
/

--3. Paquete de Gestión de Médicos

CREATE OR REPLACE PACKAGE pkg_gestion_medicos AS
    PROCEDURE agregar_medico(p_id_medico INT, p_nombre VARCHAR2, p_apellidos VARCHAR2, p_cedula NUMBER, p_telefono NUMBER, p_turno VARCHAR2, p_especialidad VARCHAR2);
    PROCEDURE actualizar_medico(p_id_medico INT, p_nombre VARCHAR2, p_apellidos VARCHAR2, p_cedula NUMBER, p_telefono NUMBER, p_turno VARCHAR2, p_especialidad VARCHAR2);
    PROCEDURE eliminar_medico(p_id_medico INT);
END pkg_gestion_medicos;
/

CREATE OR REPLACE PACKAGE BODY pkg_gestion_medicos AS
    PROCEDURE agregar_medico(p_id_medico INT, p_nombre VARCHAR2, p_apellidos VARCHAR2, p_cedula NUMBER, p_telefono NUMBER, p_turno VARCHAR2, p_especialidad VARCHAR2) IS
    BEGIN
        INSERT INTO Medicos VALUES (p_id_medico, p_nombre, p_apellidos, p_cedula, p_telefono, p_turno, p_especialidad);
        COMMIT;
    END agregar_medico;

    PROCEDURE actualizar_medico(p_id_medico INT, p_nombre VARCHAR2, p_apellidos VARCHAR2, p_cedula NUMBER, p_telefono NUMBER, p_turno VARCHAR2, p_especialidad VARCHAR2) IS
    BEGIN
        UPDATE Medicos SET Nom_Medico = p_nombre, Apellidos_Medico = p_apellidos, Ced_Medico = p_cedula, Telefono_m = p_telefono, Turno = p_turno, Especialidad = p_especialidad WHERE ID_Medico = p_id_medico;
        COMMIT;
    END actualizar_medico;

    PROCEDURE eliminar_medico(p_id_medico INT) IS
    BEGIN
        DELETE FROM Medicos WHERE ID_Medico = p_id_medico;
        COMMIT;
    END eliminar_medico;
END pkg_gestion_medicos;
/

--4. Paquete de Gestión de Pagos

CREATE OR REPLACE PACKAGE pkg_gestion_pagos AS
    PROCEDURE registrar_pago(p_id_recibo INT, p_fecha DATE, p_hora TIMESTAMP, p_id_paciente NUMBER, p_id_medico NUMBER, p_id_cita NUMBER, p_id_insumos NUMBER, p_monto DECIMAL);
    PROCEDURE actualizar_pago(p_id_recibo INT, p_fecha DATE, p_hora TIMESTAMP, p_id_paciente NUMBER, p_id_medico NUMBER, p_id_cita NUMBER, p_id_insumos NUMBER, p_monto DECIMAL);
    PROCEDURE eliminar_pago(p_id_recibo INT);
END pkg_gestion_pagos;
/

CREATE OR REPLACE PACKAGE BODY pkg_gestion_pagos AS
    PROCEDURE registrar_pago(p_id_recibo INT, p_fecha DATE, p_hora TIMESTAMP, p_id_paciente NUMBER, p_id_medico NUMBER, p_id_cita NUMBER, p_id_insumos NUMBER, p_monto DECIMAL) IS
    BEGIN
        INSERT INTO Pago(ID_Recibo, Fecha, Hora, ID_Paciente, ID_Medico, ID_Cita, ID_Insumos, Pago)
        VALUES (p_id_recibo, p_fecha, p_hora, p_id_paciente, p_id_medico, p_id_cita, p_id_insumos, p_monto);
        COMMIT;
    END registrar_pago;

    PROCEDURE actualizar_pago(p_id_recibo INT, p_fecha DATE, p_hora TIMESTAMP, p_id_paciente NUMBER, p_id_medico NUMBER, p_id_cita NUMBER, p_id_insumos NUMBER, p_monto DECIMAL) IS
    BEGIN
        UPDATE Pago
        SET Fecha = p_fecha, Hora = p_hora, ID_Paciente = p_id_paciente, ID_Medico = p_id_medico, ID_Cita = p_id_cita, ID_Insumos = p_id_insumos, Pago = p_monto
        WHERE ID_Recibo = p_id_recibo;
        COMMIT;
    END actualizar_pago;

    PROCEDURE eliminar_pago(p_id_recibo INT) IS
    BEGIN
        DELETE FROM Pago WHERE ID_Recibo = p_id_recibo;
        COMMIT;
    END eliminar_pago;
END pkg_gestion_pagos;
/

--5. Paquete de Gestión de Insumos

CREATE OR REPLACE PACKAGE pkg_gestion_insumos AS
    PROCEDURE agregar_insumo(p_id_insumos INT, p_nombre VARCHAR2, p_costo DECIMAL, p_ubicacion VARCHAR2, p_fecha_vencimiento DATE);
    PROCEDURE actualizar_insumo(p_id_insumos INT, p_nombre VARCHAR2, p_costo DECIMAL, p_ubicacion VARCHAR2, p_fecha_vencimiento DATE);
    PROCEDURE eliminar_insumo(p_id_insumos INT);
END pkg_gestion_insumos;
/

CREATE OR REPLACE PACKAGE BODY pkg_gestion_insumos AS
    PROCEDURE agregar_insumo(p_id_insumos INT, p_nombre VARCHAR2, p_costo DECIMAL, p_ubicacion VARCHAR2, p_fecha_vencimiento DATE) IS
    BEGIN
        INSERT INTO Insumos(ID_Insumos, Nombre_Insu, Costo, Ubicacion, Fecha_Vencimiento)
        VALUES (p_id_insumos, p_nombre, p_costo, p_ubicacion, p_fecha_vencimiento);
        COMMIT;
    END agregar_insumo;

    PROCEDURE actualizar_insumo(p_id_insumos INT, p_nombre VARCHAR2, p_costo DECIMAL, p_ubicacion VARCHAR2, p_fecha_vencimiento DATE) IS
    BEGIN
        UPDATE Insumos
        SET Nombre_Insu = p_nombre, Costo = p_costo, Ubicacion = p_ubicacion, Fecha_Vencimiento = p_fecha_vencimiento
        WHERE ID_Insumos = p_id_insumos;
        COMMIT;
    END actualizar_insumo;

    PROCEDURE eliminar_insumo(p_id_insumos INT) IS
    BEGIN
        DELETE FROM Insumos WHERE ID_Insumos = p_id_insumos;
        COMMIT;
    END eliminar_insumo;
END pkg_gestion_insumos;
/

--6. Paquete de Gestión de Proveedores

CREATE OR REPLACE PACKAGE pkg_gestion_proveedores AS
    PROCEDURE agregar_proveedor(p_id_proveedor INT, p_nombre VARCHAR2, p_telefono VARCHAR2, p_direccion VARCHAR2, p_email VARCHAR2);
    PROCEDURE actualizar_proveedor(p_id_proveedor INT, p_nombre VARCHAR2, p_telefono VARCHAR2, p_direccion VARCHAR2, p_email VARCHAR2);
    PROCEDURE eliminar_proveedor(p_id_proveedor INT);
END pkg_gestion_proveedores;
/

CREATE OR REPLACE PACKAGE BODY pkg_gestion_proveedores AS
    PROCEDURE agregar_proveedor(p_id_proveedor INT, p_nombre VARCHAR2, p_telefono VARCHAR2, p_direccion VARCHAR2, p_email VARCHAR2) IS
    BEGIN
        INSERT INTO Proveedores(ProveedorID, Nombre, Teléfono, Dirección, Email)
        VALUES (p_id_proveedor, p_nombre, p_telefono, p_direccion, p_email);
        COMMIT;
    END agregar_proveedor;

    PROCEDURE actualizar_proveedor(p_id_proveedor INT, p_nombre VARCHAR2, p_telefono VARCHAR2, p_direccion VARCHAR2, p_email VARCHAR2) IS
    BEGIN
        UPDATE Proveedores
        SET Nombre = p_nombre, Teléfono = p_telefono, Dirección = p_direccion, Email = p_email
        WHERE ProveedorID = p_id_proveedor;
        COMMIT;
    END actualizar_proveedor;

    PROCEDURE eliminar_proveedor(p_id_proveedor INT) IS
    BEGIN
        DELETE FROM Proveedores WHERE ProveedorID = p_id_proveedor;
        COMMIT;
    END eliminar_proveedor;
END pkg_gestion_proveedores;
/

--7. Paquete de Gestión de Tratamientos

CREATE OR REPLACE PACKAGE pkg_gestion_tratamientos AS
    PROCEDURE agregar_tratamiento(p_id_tratamiento NUMBER, p_nombre VARCHAR2, p_descripcion VARCHAR2, p_costo DECIMAL, p_id_insumo INT);
    PROCEDURE actualizar_tratamiento(p_id_tratamiento NUMBER, p_nombre VARCHAR2, p_descripcion VARCHAR2, p_costo DECIMAL, p_id_insumo INT);
    PROCEDURE eliminar_tratamiento(p_id_tratamiento NUMBER);
END pkg_gestion_tratamientos;
/

CREATE OR REPLACE PACKAGE BODY pkg_gestion_tratamientos AS
    PROCEDURE agregar_tratamiento(p_id_tratamiento NUMBER, p_nombre VARCHAR2, p_descripcion VARCHAR2, p_costo DECIMAL, p_id_insumo INT) IS
    BEGIN
        INSERT INTO Tratamientos(ID_Tratamiento, Nombre, Descripcion, Costo, ID_Insumo)
        VALUES (p_id_tratamiento, p_nombre, p_descripcion, p_costo, p_id_insumo);
        COMMIT;
    END agregar_tratamiento;

    PROCEDURE actualizar_tratamiento(p_id_tratamiento NUMBER, p_nombre VARCHAR2, p_descripcion VARCHAR2, p_costo DECIMAL, p_id_insumo INT) IS
    BEGIN
        UPDATE Tratamientos
        SET Nombre = p_nombre, Descripcion = p_descripcion, Costo = p_costo, ID_Insumo = p_id_insumo
        WHERE ID_Tratamiento = p_id_tratamiento;
        COMMIT;
    END actualizar_tratamiento;

    PROCEDURE eliminar_tratamiento(p_id_tratamiento NUMBER) IS
    BEGIN
        DELETE FROM Tratamientos WHERE ID_Tratamiento = p_id_tratamiento;
        COMMIT;
    END eliminar_tratamiento;
END pkg_gestion_tratamientos;
/

--8. Paquete de Gestión de Medicamentos

CREATE OR REPLACE PACKAGE pkg_gestion_medicamentos AS
    PROCEDURE agregar_medicamento(p_medicamento_id INT, p_nombre VARCHAR2, p_tipo VARCHAR2, p_dosis VARCHAR2, p_descripcion VARCHAR2, p_proveedor_id INT);
    PROCEDURE actualizar_medicamento(p_medicamento_id INT, p_nombre VARCHAR2, p_tipo VARCHAR2, p_dosis VARCHAR2, p_descripcion VARCHAR2, p_proveedor_id INT);
    PROCEDURE eliminar_medicamento(p_medicamento_id INT);
END pkg_gestion_medicamentos;
/

CREATE OR REPLACE PACKAGE BODY pkg_gestion_medicamentos AS
    PROCEDURE agregar_medicamento(p_medicamento_id INT, p_nombre VARCHAR2, p_tipo VARCHAR2, p_dosis VARCHAR2, p_descripcion VARCHAR2, p_proveedor_id INT) IS
    BEGIN
        INSERT INTO Medicamentos(MedicamentoID, Nombre, Tipo, Dosis, Descripción, ProveedorID)
        VALUES (p_medicamento_id, p_nombre, p_tipo, p_dosis, p_descripcion, p_proveedor_id);
        COMMIT;
    END agregar_medicamento;

    PROCEDURE actualizar_medicamento(p_medicamento_id INT, p_nombre VARCHAR2, p_tipo VARCHAR2, p_dosis VARCHAR2, p_descripcion VARCHAR2, p_proveedor_id INT) IS
    BEGIN
        UPDATE Medicamentos
        SET Nombre = p_nombre, Tipo = p_tipo, Dosis = p_dosis, Descripción = p_descripcion, ProveedorID = p_proveedor_id
        WHERE MedicamentoID = p_medicamento_id;
        COMMIT;
    END actualizar_medicamento;

    PROCEDURE eliminar_medicamento(p_medicamento_id INT) IS
    BEGIN
        DELETE FROM Medicamentos WHERE MedicamentoID = p_medicamento_id;
        COMMIT;
    END eliminar_medicamento;
END pkg_gestion_medicamentos;
/

--9. Paquete de Reportes

CREATE OR REPLACE PACKAGE pkg_reportes AS
    FUNCTION citas_por_fecha(p_fecha DATE) RETURN SYS_REFCURSOR;
    FUNCTION pagos_por_mes(p_mes NUMBER, p_ano NUMBER) RETURN SYS_REFCURSOR;
END pkg_reportes;
/

CREATE OR REPLACE PACKAGE BODY pkg_reportes AS
    FUNCTION citas_por_fecha(p_fecha DATE) RETURN SYS_REFCURSOR IS
        r_cursor SYS_REFCURSOR;
    BEGIN
        OPEN r_cursor FOR
            SELECT * FROM Registro_Citas WHERE Fecha = p_fecha;
        RETURN r_cursor;
    END citas_por_fecha;

    FUNCTION pagos_por_mes(p_mes NUMBER, p_ano NUMBER) RETURN SYS_REFCURSOR IS
        r_cursor SYS_REFCURSOR;
    BEGIN
        OPEN r_cursor FOR
            SELECT * FROM Pago WHERE EXTRACT(MONTH FROM Fecha) = p_mes AND EXTRACT(YEAR FROM Fecha) = p_ano;
        RETURN r_cursor;
    END pagos_por_mes;
END pkg_reportes;
/

--10.  Paquete de Gestión de Exámenes Médicos

CREATE OR REPLACE PACKAGE pkg_gestion_examenes AS
    PROCEDURE agregar_examen(p_id_examen NUMBER, p_tipo VARCHAR2, p_resultados VARCHAR2, p_fecha DATE, p_id_paciente NUMBER);
    PROCEDURE actualizar_examen(p_id_examen NUMBER, p_tipo VARCHAR2, p_resultados VARCHAR2, p_fecha DATE, p_id_paciente NUMBER);
    PROCEDURE eliminar_examen(p_id_examen NUMBER);
END pkg_gestion_examenes;
/

CREATE OR REPLACE PACKAGE BODY pkg_gestion_examenes AS
    PROCEDURE agregar_examen(p_id_examen NUMBER, p_tipo VARCHAR2, p_resultados VARCHAR2, p_fecha DATE, p_id_paciente NUMBER) IS
    BEGIN
        INSERT INTO Registro_Examenes(ID_Examen, Tipo_Examen, Resultados, Fecha, ID_Paciente)
        VALUES (p_id_examen, p_tipo, p_resultados, p_fecha, p_id_paciente);
        COMMIT;
    END agregar_examen;

    PROCEDURE actualizar_examen(p_id_examen NUMBER, p_tipo VARCHAR2, p_resultados VARCHAR2, p_fecha DATE, p_id_paciente NUMBER) IS
    BEGIN
        UPDATE Registro_Examenes
        SET Tipo_Examen = p_tipo, Resultados = p_resultados, Fecha = p_fecha, ID_Paciente = p_id_paciente
        WHERE ID_Examen = p_id_examen;
        COMMIT;
    END actualizar_examen;

    PROCEDURE eliminar_examen(p_id_examen NUMBER) IS
    BEGIN
        DELETE FROM Registro_Examenes WHERE ID_Examen = p_id_examen;
        COMMIT;
    END eliminar_examen;
END pkg_gestion_examenes;
/

----------------------------------------------------------------------------------------

--Desarrollar 5 TRIGGERS

--1. Insetar paciente
CREATE OR REPLACE TRIGGER trg_after_insert_paciente
AFTER INSERT ON Paciente
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Se ha insertado un nuevo paciente con ID: ' || :NEW.ID_Paciente);
END;
/


--2. Insertar cita
CREATE OR REPLACE TRIGGER Trig_Insertar_Cita
BEFORE INSERT ON Registro_Citas
FOR EACH ROW
BEGIN
    IF :NEW.Fecha < SYSDATE THEN
        RAISE_APPLICATION_ERROR(-20001, 'No se puede programar una cita en una fecha pasada.');
    END IF;
END;
/

--3. Notificar Nuevo Pago
CREATE OR REPLACE TRIGGER Trig_Notificar_Nuevo_Pago
AFTER INSERT ON Pago
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Se ha registrado un nuevo pago con ID de recibo: ' || :NEW.ID_Recibo);
END;
/

SET SERVEROUTPUT ON;


--4. Restriccion Eliminacion de Medico
CREATE OR REPLACE TRIGGER Trig_Restriccion_Eliminacion_Medico
BEFORE DELETE ON Medicos
FOR EACH ROW
DECLARE
    v_cantidad NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_cantidad
    FROM Registro_Citas
    WHERE ID_Medico = :OLD.ID_Medico;

    IF v_cantidad > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'No se puede eliminar el médico porque tiene citas asociadas.');
    END IF;
END;
/

--5. Actulizacion Ubicacion de Insumo
CREATE OR REPLACE TRIGGER Trig_Actualizar_Ubicacion_Insumo
BEFORE INSERT OR UPDATE ON Insumos
FOR EACH ROW
BEGIN
    IF :NEW.Fecha_Vencimiento < ADD_MONTHS(TRUNC(SYSDATE), 12) THEN
        :NEW.Ubicacion := 'Almacén 2';
    END IF;
END;
/



----------------------------------------------------------------------------------------

-- 15 Cursores 
SET SERVEROUTPUT ON;
--1. Cursor Listado de Pacientes

CREATE OR REPLACE PROCEDURE Listar_Pacientes AS
    CURSOR c_pacientes IS
        SELECT * FROM Paciente;
    v_id_paciente Paciente.ID_Paciente%TYPE;
    v_num_cedula Paciente.Num_Cedula%TYPE;
    v_nom_paciente Paciente.Nom_Paciente%TYPE;
    v_apellidos_paciente Paciente.Apellidos_Paciente%TYPE;
    v_direccion Paciente.Direccion%TYPE;
    v_telefono_p Paciente.Telefono_p%TYPE;
    v_alergias Paciente.Alergias%TYPE;
    v_enferm_cronicas Paciente.Enferm_Cronicas%TYPE;
BEGIN

    DBMS_OUTPUT.PUT_LINE('Listado de Pacientes:');
    DBMS_OUTPUT.PUT_LINE('ID_PACIENTE | NUM_CEDULA | NOM_PACIENTE | APELLIDOS_PACIENTE | DIRECCION | TELEFONO_P | ALERGIAS | ENFERM_CRONICAS');
    DBMS_OUTPUT.PUT_LINE('-------------------------------------------------------------------------------------------------');

    OPEN c_pacientes;

    LOOP
        FETCH c_pacientes INTO v_id_paciente, v_num_cedula, v_nom_paciente, v_apellidos_paciente, v_direccion, v_telefono_p, v_alergias, v_enferm_cronicas;
        EXIT WHEN c_pacientes%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(v_id_paciente || ' | ' || v_num_cedula || ' | ' || v_nom_paciente || ' | ' || v_apellidos_paciente || ' | ' || v_direccion || ' | ' || v_telefono_p || ' | ' || v_alergias || ' | ' || v_enferm_cronicas);
    END LOOP;

    CLOSE c_pacientes;
END;
/

BEGIN
    Listar_Pacientes;
END;
/


--2. Cursor Listado de Medicos

CREATE OR REPLACE PROCEDURE Listar_Medicos AS
    CURSOR c_medicos IS
        SELECT ID_Medico, Nom_Medico FROM Medicos;
    v_id_medico Medicos.ID_Medico%TYPE;
    v_nom_medico Medicos.Nom_Medico%TYPE;
BEGIN
    OPEN c_medicos;
    LOOP
        FETCH c_medicos INTO v_id_medico, v_nom_medico;
        EXIT WHEN c_medicos%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('ID Medico: ' || v_id_medico || ', Nombre: ' || v_nom_medico);
    END LOOP;
    CLOSE c_medicos;
END Listar_Medicos;
/

BEGIN
    Listar_Medicos;
END;
/

--3. Cursor Listado de Citas

CREATE OR REPLACE PROCEDURE Listar_Citas AS
    CURSOR c_citas IS
        SELECT * FROM Registro_Citas;

    v_id_cita Registro_Citas.ID_Cita%TYPE;
    v_hora_cita Registro_Citas.Hora%TYPE;
    v_fecha_cita Registro_Citas.Fecha%TYPE;
    v_consultorio Registro_Citas.Consultorio%TYPE;
    v_id_paciente Registro_Citas.ID_Paciente%TYPE;
    v_id_medico Registro_Citas.ID_Medico%TYPE;
BEGIN
    OPEN c_citas;
    LOOP
        FETCH c_citas INTO v_id_cita, v_hora_cita, v_fecha_cita, v_consultorio, v_id_paciente, v_id_medico;
        EXIT WHEN c_citas%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('ID Cita: ' || v_id_cita || ', Hora: ' || v_hora_cita || ', Fecha: ' || v_fecha_cita || ', Consultorio: ' || v_consultorio || ', ID Paciente: ' || v_id_paciente || ', ID Medico: ' || v_id_medico);
    END LOOP;
    CLOSE c_citas;
END Listar_Citas;
/

BEGIN
    Listar_Citas;
END;
/

-- 4. Listado de Proveedores de Medicamentos

CREATE OR REPLACE PROCEDURE Listar_Proveedores_Medicamentos AS
    CURSOR c_proveedores IS
        SELECT DISTINCT Proveedores.Nombre, Proveedores.Teléfono, Proveedores.Dirección, Proveedores.Email
        FROM Proveedores
        JOIN Medicamentos ON Proveedores.ProveedorID = Medicamentos.ProveedorID;
    v_nombre Proveedores.Nombre%TYPE;
    v_telefono Proveedores.Teléfono%TYPE;
    v_direccion Proveedores.Dirección%TYPE;
    v_email Proveedores.Email%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Listado de Proveedores de Medicamentos:');
    DBMS_OUTPUT.PUT_LINE('NOMBRE | TELÉFONO | DIRECCIÓN | EMAIL');
    DBMS_OUTPUT.PUT_LINE('----------------------------------------------------');

    OPEN c_proveedores;
    LOOP
        FETCH c_proveedores INTO v_nombre, v_telefono, v_direccion, v_email;
        EXIT WHEN c_proveedores%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(v_nombre || ' | ' || v_telefono || ' | ' || v_direccion || ' | ' || v_email);
    END LOOP;

    CLOSE c_proveedores;
END;
/


-- 5. Detalles del Tratamiento por Tipo de Tratamiento

CREATE OR REPLACE PROCEDURE Listar_Tratamientos_Por_Tipo(p_tipo_tratamiento VARCHAR2) AS
    CURSOR c_tratamientos_tipo IS
        SELECT ID_Tratamiento, Nombre, Descripcion, Costo
        FROM Tratamientos
        WHERE Nombre LIKE '%' || p_tipo_tratamiento || '%';
    v_id_tratamiento Tratamientos.ID_Tratamiento%TYPE;
    v_nombre Tratamientos.Nombre%TYPE;
    v_descripcion Tratamientos.Descripcion%TYPE;
    v_costo Tratamientos.Costo%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Listado de Tratamientos por Tipo:');
    DBMS_OUTPUT.PUT_LINE('ID_TRATAMIENTO | NOMBRE | DESCRIPCIÓN | COSTO');
    DBMS_OUTPUT.PUT_LINE('---------------------------------------------------------');

    OPEN c_tratamientos_tipo;
    LOOP
        FETCH c_tratamientos_tipo INTO v_id_tratamiento, v_nombre, v_descripcion, v_costo;
        EXIT WHEN c_tratamientos_tipo%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(v_id_tratamiento || ' | ' || v_nombre || ' | ' || v_descripcion || ' | ' || v_costo);
    END LOOP;

    CLOSE c_tratamientos_tipo;
END;
/


-- 6. Listado de Exámenes por Paciente

CREATE OR REPLACE PROCEDURE Listar_Examenes_Por_Paciente(p_ID_Paciente NUMBER) AS
    CURSOR c_examenes IS
        SELECT ID_Examen, Tipo_Examen, Resultados, Fecha
        FROM Registro_Examenes
        WHERE ID_Paciente = p_ID_Paciente
        ORDER BY Fecha DESC;
    v_id_examen Registro_Examenes.ID_Examen%TYPE;
    v_tipo_examen Registro_Examenes.Tipo_Examen%TYPE;
    v_resultados Registro_Examenes.Resultados%TYPE;
    v_fecha Registro_Examenes.Fecha%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Listado de Examenes por Paciente:');
    DBMS_OUTPUT.PUT_LINE('ID_EXAMEN | TIPO_EXAMEN | RESULTADOS | FECHA');
    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------------');

    OPEN c_examenes;
    LOOP
        FETCH c_examenes INTO v_id_examen, v_tipo_examen, v_resultados, v_fecha;
        EXIT WHEN c_examenes%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(v_id_examen || ' | ' || v_tipo_examen || ' | ' || v_resultados || ' | ' || TO_CHAR(v_fecha, 'DD/MM/YYYY'));
    END LOOP;

    CLOSE c_examenes;
END;
/




-- 7. Cursor Listado de tratamientos
CREATE OR REPLACE PROCEDURE Listar_Tratamientos AS
    CURSOR c_tratamientos IS
        SELECT * FROM Tratamientos;
    v_id_tratamiento Tratamientos.ID_Tratamiento%TYPE;
    v_nombre_tratamiento Tratamientos.Nombre%TYPE;
    v_descripcion_tratamiento Tratamientos.Descripcion%TYPE;
    v_costo_tratamiento Tratamientos.Costo%TYPE;
    v_id_insumo_tratamiento Tratamientos.ID_Insumo%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Listado de Tratamientos:');
    DBMS_OUTPUT.PUT_LINE('ID_TRATAMIENTO | NOMBRE | DESCRIPCION | COSTO | ID_INSUMO');
    DBMS_OUTPUT.PUT_LINE('----------------------------------------------------------');

    OPEN c_tratamientos;
    LOOP
        FETCH c_tratamientos INTO v_id_tratamiento, v_nombre_tratamiento, v_descripcion_tratamiento, v_costo_tratamiento, v_id_insumo_tratamiento;
        EXIT WHEN c_tratamientos%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(v_id_tratamiento || ' | ' || v_nombre_tratamiento || ' | ' || v_descripcion_tratamiento || ' | ' || v_costo_tratamiento || ' | ' || v_id_insumo_tratamiento);
    END LOOP;

    CLOSE c_tratamientos;
END;
/


-- 8. Cursor Listado de Insumos
CREATE OR REPLACE PROCEDURE Listar_Insumos AS
    CURSOR c_insumos IS
        SELECT * FROM Insumos;
    v_id_insumo Insumos.ID_Insumos%TYPE;
    v_nombre_insumo Insumos.Nombre_Insu%TYPE;
    v_costo_insumo Insumos.Costo%TYPE;
    v_ubicacion_insumo Insumos.Ubicacion%TYPE;
    v_fecha_vencimiento_insumo Insumos.Fecha_Vencimiento%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Listado de Insumos:');
    DBMS_OUTPUT.PUT_LINE('ID_INSUMO | NOMBRE | COSTO | UBICACION | FECHA_VENCIMIENTO');
    DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------------------');

    OPEN c_insumos;
    LOOP
        FETCH c_insumos INTO v_id_insumo, v_nombre_insumo, v_costo_insumo, v_ubicacion_insumo, v_fecha_vencimiento_insumo;
        EXIT WHEN c_insumos%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(v_id_insumo || ' | ' || v_nombre_insumo || ' | ' || v_costo_insumo || ' | ' || v_ubicacion_insumo || ' | ' || v_fecha_vencimiento_insumo);
    END LOOP;

    CLOSE c_insumos;
END;
/

--9. Obtener Comentarios Por Cita
CREATE OR REPLACE PROCEDURE ObtenerComentariosPorCita(p_ID_Cita NUMBER) AS
  CURSOR comentarios_cur IS
    SELECT * FROM Comentarios_Cita WHERE ID_Cita = p_ID_Cita;
BEGIN
  FOR comentario IN comentarios_cur LOOP
    DBMS_OUTPUT.PUT_LINE('ID Comentario: ' || comentario.ID_Comentario || ', Comentario: ' || comentario.Comentario);
  END LOOP;
END;

--10. Listado de Tratamientos por Paciente

CREATE OR REPLACE PROCEDURE Listar_Tratamientos_Por_Paciente(p_ID_Paciente NUMBER) AS
    CURSOR c_tratamientos IS
        SELECT Tratamientos.Nombre, Tratamientos.Descripcion, Tratamientos.Costo, Registro_Citas.Fecha
        FROM Tratamientos
        JOIN Registro_Citas ON Registro_Citas.ID_Cita = Tratamientos.ID_Tratamiento
        WHERE Registro_Citas.ID_Paciente = p_ID_Paciente;
    v_nombre_tratamiento Tratamientos.Nombre%TYPE;
    v_descripcion_tratamiento Tratamientos.Descripcion%TYPE;
    v_costo_tratamiento Tratamientos.Costo%TYPE;
    v_fecha_tratamiento Registro_Citas.Fecha%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Listado de Tratamientos por Paciente:');
    DBMS_OUTPUT.PUT_LINE('NOMBRE | DESCRIPCION | COSTO | FECHA_TRATAMIENTO');
    DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------');

    OPEN c_tratamientos;
    LOOP
        FETCH c_tratamientos INTO v_nombre_tratamiento, v_descripcion_tratamiento, v_costo_tratamiento, v_fecha_tratamiento;
        EXIT WHEN c_tratamientos%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(v_nombre_tratamiento || ' | ' || v_descripcion_tratamiento || ' | ' ||
                             v_costo_tratamiento || ' | ' || TO_CHAR(v_fecha_tratamiento, 'DD/MM/YYYY'));
    END LOOP;

    CLOSE c_tratamientos;
END;
/

--11. Listado de Insumos Próximos a Vencer
CREATE OR REPLACE PROCEDURE Listar_Insumos_Proximos_Vencer AS
    CURSOR c_insumos_proximos IS
        SELECT ID_Insumos, Nombre_Insu, Fecha_Vencimiento
        FROM Insumos
        WHERE Fecha_Vencimiento BETWEEN SYSDATE AND SYSDATE + 30;
    v_id_insumo Insumos.ID_Insumos%TYPE;
    v_nombre_insumo Insumos.Nombre_Insu%TYPE;
    v_fecha_vencimiento Insumos.Fecha_Vencimiento%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Listado de Insumos Próximos a Vencer:');
    DBMS_OUTPUT.PUT_LINE('ID_INSUMO | NOMBRE_INSUMO | FECHA_VENCIMIENTO');
    DBMS_OUTPUT.PUT_LINE('-------------------------------------------------');

    OPEN c_insumos_proximos;
    LOOP
        FETCH c_insumos_proximos INTO v_id_insumo, v_nombre_insumo, v_fecha_vencimiento;
        EXIT WHEN c_insumos_proximos%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(v_id_insumo || ' | ' || v_nombre_insumo || ' | ' || TO_CHAR(v_fecha_vencimiento, 'DD/MM/YYYY'));
    END LOOP;

    CLOSE c_insumos_proximos;
END;
/

--12. Calcular Ingresos Mensuales

CREATE OR REPLACE FUNCTION CalcularIngresosMensuales(mes VARCHAR) RETURN DECIMAL IS
    total_ingresos DECIMAL(10, 2);
BEGIN
    SELECT SUM(P.Pago) INTO total_ingresos
    FROM Pago P
    JOIN Registro_Citas RC ON P.ID_Cita = RC.ID_Cita
    WHERE TO_CHAR(RC.Fecha, 'MON') = mes;

    RETURN total_ingresos;
END;
/

--13. Pacientes Atendidos Por Dia

CREATE OR REPLACE PROCEDURE Pacientes_Atendidos_Por_Dia AS
    CURSOR c_pacientes_por_dia IS
        SELECT TO_CHAR(Fecha, 'DD-MM-YYYY') AS Dia, COUNT(*) AS Total_Pacientes
        FROM Registro_Citas
        GROUP BY TO_CHAR(Fecha, 'DD-MM-YYYY')
        ORDER BY TO_DATE(TO_CHAR(Fecha, 'DD-MM-YYYY'), 'DD-MM-YYYY');
    v_dia Registro_Citas.Fecha%TYPE;
    v_total_pacientes NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Pacientes Atendidos por Día:');
    DBMS_OUTPUT.PUT_LINE('------------------------------');
    OPEN c_pacientes_por_dia;
    LOOP
        FETCH c_pacientes_por_dia INTO v_dia, v_total_pacientes;
        EXIT WHEN c_pacientes_por_dia%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Fecha: ' || v_dia || ' - Total de Pacientes: ' || v_total_pacientes);
    END LOOP;
    CLOSE c_pacientes_por_dia;
END;
/

--14. Pacientes Atendidos Por Medico

CREATE OR REPLACE PROCEDURE Pacientes_Atendidos_Por_Medico AS
    CURSOR c_pacientes_por_medico IS
        SELECT m.ID_Medico, m.Nom_Medico, m.Apellidos_Medico, COUNT(rc.ID_Paciente) AS Total_Pacientes_Atendidos
        FROM Medicos m
        LEFT JOIN Registro_Citas rc ON m.ID_Medico = rc.ID_Medico
        GROUP BY m.ID_Medico, m.Nom_Medico, m.Apellidos_Medico
        ORDER BY m.ID_Medico;
    v_id_medico Medicos.ID_Medico%TYPE;
    v_nombre_medico Medicos.Nom_Medico%TYPE;
    v_apellidos_medico Medicos.Apellidos_Medico%TYPE;
    v_total_pacientes NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Pacientes Atendidos por Médico:');
    DBMS_OUTPUT.PUT_LINE('----------------------------------');
    OPEN c_pacientes_por_medico;
    LOOP
        FETCH c_pacientes_por_medico INTO v_id_medico, v_nombre_medico, v_apellidos_medico, v_total_pacientes;
        EXIT WHEN c_pacientes_por_medico%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Médico: ' || v_nombre_medico || ' ' || v_apellidos_medico || ' (ID: ' || v_id_medico || ')' || ' - Total de Pacientes Atendidos: ' || v_total_pacientes);
    END LOOP;
    CLOSE c_pacientes_por_medico;
END;
/


--15. Listar Pacientes Enfermedades Cronicas
CREATE OR REPLACE PROCEDURE ListarPacientesEnfermedadesCronicas
IS
    CURSOR PacientesEnfermedadesCursor IS
        SELECT ID_Paciente, Nom_Paciente, Apellidos_Paciente, Enferm_Cronicas
        FROM Paciente
        WHERE Enferm_Cronicas IS NOT NULL;
    PacienteRec PacientesEnfermedadesCursor%ROWTYPE;
BEGIN
    OPEN PacientesEnfermedadesCursor;
    LOOP
        FETCH PacientesEnfermedadesCursor INTO PacienteRec;
        EXIT WHEN PacientesEnfermedadesCursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('ID: ' || PacienteRec.ID_Paciente || ', Nombre: ' || PacienteRec.Nom_Paciente || ' ' || PacienteRec.Apellidos_Paciente || ', Enfermedades Crónicas: ' || PacienteRec.Enferm_Cronicas);
    END LOOP;
    CLOSE PacientesEnfermedadesCursor;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
----------------------------------------------------------------------------------------


