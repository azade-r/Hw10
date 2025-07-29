CREATE DATABASE employee_task_manager;
CREATE TABLE employee
( id   INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1001 INCREMENT BY 1),
  name VARCHAR(100) NOT NULL);
CREATE TABLE task (
                      id SERIAL PRIMARY KEY,
                      employee_id INT NOT NULL,
                      description TEXT NOT NULL,
                      estimated_hours INT NOT NULL,
                      CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES employee(id)
);