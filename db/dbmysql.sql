--creando la tabla
CREATE TABLE IF NOT EXISTS employee (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  fullname VARCHAR(100) NOT NULL,
  functions VARCHAR(100) NOT NULL,
  boss INT  
) ;

--insertando los datos
INSERT INTO employee (fullname,functions,boss) VALUES ('Elizabeth Olsen','Administrative Assistant',3);
INSERT INTO employee (fullname,functions,boss) VALUES ('Jennifer Lawrence','Executive Assistant',3);
INSERT INTO employee (fullname,functions) VALUES ('Winston Duke','Senior Manager');
INSERT INTO employee (fullname,functions,boss) VALUES ('Daniel Kaluuya','Customer Service Representative',1);
INSERT INTO employee (fullname,functions,boss) VALUES ('Michelle Yeoh','Intern',2);