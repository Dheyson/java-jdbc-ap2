CREATE DATABASE club_bd_ap2
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE UTF8_GENERAL_CI;

USE club_bd_ap2;

CREATE TABLE times(
	cod_time BIGINT AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    camp_id INT NOT NULL,
    
    CONSTRAINT pk_times
    PRIMARY KEY(cod_time),
	
    CONSTRAINT fk_camp_times
    FOREIGN KEY(camp_id) 
    REFERENCES campeonato(cod_camp)
);

CREATE TABLE associado (
	id BIGINT NOT NULL AUTO_INCREMENT, 
    cpf VARCHAR(255) NOT NULL UNIQUE,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(50),
    data_nascimento DATE,
    sexo ENUM('M','F'),
    email VARCHAR(50),
    data_de_associacao TIMESTAMP,
    times_id INT NOT NULL,
    
    CONSTRAINT pk_cpf PRIMARY KEY(cpf),
    
    CONSTRAINT fk_times_asso
    FOREIGN KEY(times_id) 
    REFERENCES times(cod_time)
);
    
CREATE TABLE associado_telefone (
	id_associado BIGINT NOT NULL,
    telefone INT,
    
    CONSTRAINT pk_associado_telefone 
    PRIMARY KEY(id_associado, telefone),
    
    CONSTRAINT fk_associado_telefone 
    FOREIGN KEY(id_associado) 
    REFERENCES associado(id)
);

CREATE TABLE associado_endereco (
	id_endereco_associado BIGINT NOT NULL,
    cep VARCHAR(50),
    estado VARCHAR(50) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    rua VARCHAR(30) NOT NULL,
    numero SMALLINT NOT NULL,
    
    CONSTRAINT pk_end_associado
    PRIMARY KEY(id_endereco_associado),
    
    CONSTRAINT fk_end_associado
    FOREIGN KEY(id_endereco_associado) 
    REFERENCES associado(id)
    
);

CREATE TABLE tecnico (
	registro BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(15),
    sobrenome VARCHAR(30),
    epecializacao VARCHAR(50),
    
	CONSTRAINT pk_tec 
    PRIMARY KEY(registro)
);

CREATE TABLE tecnico_telefone (
	registro_tecnico_tel BIGINT NOT NULL,
    telefone BIGINT NOT NULL,
    
    CONSTRAINT pk_tecnico_telefone 
    PRIMARY KEY(registro_tecnico_tel, telefone),
    
    CONSTRAINT fk_tecnico_telefone 
    FOREIGN KEY(registro_tecnico_tel) 
    REFERENCES tecnico(registro)
);

CREATE TABLE tecnico_endereco (
	registro_tecnico_end BIGINT NOT NULL,
    cep VARCHAR(50),
    estado VARCHAR(50) NOT NULL,
    cidade VARCHAR(30) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    rua VARCHAR(30) NOT NULL,
    numero SMALLINT NOT NULL,
    
	CONSTRAINT pk_end_tecnico
    PRIMARY KEY(registro_tecnico_end),
    
    CONSTRAINT fk_end_tecnico
    FOREIGN KEY(registro_tecnico_end) 
    REFERENCES tecnico(registro)
);

CREATE TABLE esporte(
	esporte_cod BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    qtd_pessoas MEDIUMINT NOT NULL,
    
    CONSTRAINT pk_esp_id 
    PRIMARY KEY (esporte_cod)
    
);

CREATE TABLE treino (
	codigo BIGINT NOT NULL AUTO_INCREMENT,
    dia DATE,
    turno VARCHAR(50),
    tecnico_id INT NOT NULL,
    esporte_id INT NOT NULL,
    
    CONSTRAINT pk_codigo_treino 
    PRIMARY KEY(codigo),
    
    CONSTRAINT fk_tecnico_id 
    FOREIGN KEY(tecnico_id) 
    REFERENCES tecnico(registro),
    
    CONSTRAINT fk_esporte_id 
    FOREIGN KEY(esporte_id) 
    REFERENCES esporte(esporte_cod)

);

CREATE TABLE associado_matricula_treino (
	id_matricula_associado BIGINT NOT NULL,
    codigo_turma INT NOT NULL,
    data_matricula TIMESTAMP,
    
    CONSTRAINT pk_cpf_associado_matricula 
    PRIMARY KEY(id_matricula_associado, codigo_turma),
    
    CONSTRAINT fk_cod_turma 
    FOREIGN KEY(id_matricula_associado) 
    REFERENCES treino(codigo)

);

CREATE TABLE escala(
	esc_cod BIGINT NOT NULL AUTO_INCREMENT,
    horas TIME NOT NULL,
    
    CONSTRAINT pk_escala
    PRIMARY KEY (esc_cod)
);

CREATE TABLE escala_dias_ocupados(
	cod_esca INT NOT NULL,
    dias_ocup INT NOT NULL,
    
    CONSTRAINT pk_escala_ocup
    PRIMARY KEY (cod_esca, dias_ocup),
    
    CONSTRAINT fk_escala_ocp 
    FOREIGN KEY(cod_esca)
    REFERENCES escala(esc_cod)
);

CREATE TABLE escala_dias_livres(
	esc_cod_livres INT NOT NULL,
    dias_livres INT NOT NULL,
    
    CONSTRAINT pk_escala_liv
    PRIMARY KEY (esc_cod_livres, dias_livres), 
    
    CONSTRAINT fk_escala_li 
    FOREIGN KEY(esc_cod_livres)
    REFERENCES escala(esc_cod)
);

CREATE TABLE campeonato (
	cod_camp BIGINT NOT NULL AUTO_INCREMENT,
    edicao SMALLINT,
    data_camp DATE,
    
	CONSTRAINT pk_cod_camp 
    PRIMARY KEY(cod_camp)
);

CREATE TABLE associados_part_camp (
	id_associados BIGINT NOT NULL,
    codigo_camp INT NOT NULL,
    
    CONSTRAINT pk_asso_campe
    PRIMARY KEY(id_associados, codigo_camp),
    
    CONSTRAINT fk_asso_camp
    FOREIGN KEY(id_associados) 
    REFERENCES associado(id)

);

CREATE TABLE jogos (
	cod_camp_id BIGINT NOT NULL AUTO_INCREMENT,
    data_camp DATE NOT NULL,
    hora TIMESTAMP,
    
	CONSTRAINT pk_jogos
    PRIMARY KEY(cod_camp_id, hora),
    
    CONSTRAINT fk_camp
    FOREIGN KEY(cod_camp_id) 
    REFERENCES campeonato(cod_camp)
);



