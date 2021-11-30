/*
Prestar atenção no nome das colunas das tabelas 
*/
CREATE TABLE departamento (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);
/*
Prestar atenção no nome das colunas das tabelas 
*/
CREATE TABLE vendedor (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  dtNasc datetime NOT NULL,
  salarioBase double NOT NULL,
  DepartamentoId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartamentoId) REFERENCES departamento (id)
);

INSERT INTO departamento (Nome) VALUES 
  ('Computador'),
  ('Eletrônicos'),
  ('Geek'),
  ('Livros');

INSERT INTO vendedor (Nome, Email, dtNasc, salarioBase, DepartamentoId) VALUES 
  ('Bob Marley','bob@gmail.com','1998-04-21 00:00:00',1000,1),
  ('Maria Silva','maria@gmail.com','1979-12-31 00:00:00',3500,2),
  ('Alex Santos','alex@gmail.com','1988-01-15 00:00:00',2200,1),
  ('Martha Suplicy','martha@gmail.com','1993-11-30 00:00:00',3000,4),
  ('Donald Trump','donald@gmail.com','2000-01-09 00:00:00',4000,3),
  ('Alex Fedder','alex@gmail.com','1997-03-04 00:00:00',3000,2);
