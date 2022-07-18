/****** Crear la base de datos ******/
CREATE DATABASE db_prueba
GO

USE db_prueba
GO

/****** Crear la tabla ******/
CREATE TABLE users(
id INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
username VARCHAR(25) NOT NULL
)
GO

/****** Crear Procedimientos Almacenados ******/
CREATE PROCEDURE sp_save(
@username varchar(25)
)
AS
BEGIN
INSERT INTO users(username) values(@username)
END
GO

CREATE PROCEDURE sp_findall
AS
BEGIN
SELECT * FROM users
END
GO

CREATE PROCEDURE sp_findbyid(
@id	INT
)
AS
BEGIN
SELECT * FROM users WHERE id = @id
END
GO

CREATE PROCEDURE sp_edit(
@id INT,
@username VARCHAR(25)
)
AS BEGIN
UPDATE users
SET username = @username
WHERE id = @id
END
GO

/****** Eliminar base de datos ******/
USE master
GO

ALTER DATABASE [db_prueba] SET SINGLE_USER WITH ROLLBACK IMMEDIATE
GO

DROP DATABASE [db_prueba] 
GO
