CREATE TABLE aluno (
   	id  integer,
    nome varchar(255),
    primary key (id)
)
    
CREATE TABLE curso (
   	id  integer,
    nome varchar(255),
    professor_id bigint,
    primary key (id)
)

CREATE TABLE curso_aluno (
   	curso_id bigint not null,
    aluno_id bigint not null
)
    
CREATE TABLE endereco (
   	id  integer,
    cidade varchar(255),
    rua varchar(255),
    aluno_id bigint,
    primary key (id)
)
    
CREATE TABLE material_curso (
   	id  integer,
    descricao varchar(255),
    curso_id bigint,
    primary key (id)
)
    
CREATE TABLE professor (
   	id  integer,
    nome varchar(255),
    primary key (id)
)
    
CREATE TABLE telefones (
   	id  integer,
    numero varchar(255),
    aluno_id bigint,
    primary key (id)
)