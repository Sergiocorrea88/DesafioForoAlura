CREATE TABLE cursos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    activo BIT(1) NOT NULL,
    categoria ENUM('FRONTEND','BACKEND','DEVOPS','ROBOTICS','IA'),
    nombre VARCHAR(255) NOT NULL
    );