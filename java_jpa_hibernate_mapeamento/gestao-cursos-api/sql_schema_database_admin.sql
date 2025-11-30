CREATE TABLE aluno (
       id  integer,
        nome varchar(255), dataNascimento date, email varchar(255), matricula varchar(255), nomeCompleto varchar(255),
        primary key (id)
    )
    
CREATE TABLE curso (
       id  integer,
        nome varchar(255),
        professor_id bigint, sigla varchar(255),
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
        aluno_id bigint, bairro varchar(255), cep integer, endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255),
        primary key (id)
    )
    
CREATE TABLE material_curso (
       id  integer,
        descricao varchar(255),
        curso_id bigint, url varchar(255),
        primary key (id)
    )
    
CREATE TABLE professor (
       id  integer,
        nome varchar(255), email varchar(255), matricula varchar(255), nomeCompleto varchar(255),
        primary key (id)
    )
    
CREATE TABLE telefone (
       id  integer,
        DDD varchar(255),
        numero varchar(255),
        aluno_id bigint,
        primary key (id)
    )