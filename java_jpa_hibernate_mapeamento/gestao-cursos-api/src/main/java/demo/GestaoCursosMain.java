package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.util.Arrays;
import java.util.Date;

public class GestaoCursosMain {

    public static void main(String[] args) {

        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        Professor professor = new Professor();
        professor.setNomeCompleto("Carlos Silva");
        professor.setMatricula("PROF001");
        professor.setEmail("carlos@teste.com");

        Curso curso = new Curso();
        curso.setNome("Java com JPA");
        curso.setSigla("JPA01");
        curso.setProfessor(professor);

        MaterialCurso material = new MaterialCurso();
        material.setUrl("https://materialjava.com");
        material.setCurso(curso);
        curso.setMaterial(material);

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("João Pereira");
        aluno.setMatricula("ALU001");
        aluno.setEmail("joao@teste.com");
        aluno.setNascimento(new Date());

        Telefone tel = new Telefone();
        tel.setDDD("11");
        tel.setNumero("999999999");
        tel.setAluno(aluno);

        Endereco end = new Endereco();
        end.setLogradouro("Rua A");
        end.setEndereco("Centro");
        end.setNumero("100");
        end.setBairro("Centro");
        end.setCidade("São Paulo");
        end.setEstado("SP");
        end.setCep(12345678);
        end.setAluno(aluno);

        aluno.setTelefones(Arrays.asList(tel));
        aluno.setEnderecos(Arrays.asList(end));
        aluno.setCursos(Arrays.asList(curso));
        curso.setAlunos(Arrays.asList(aluno));

        cursoModel.create(curso);

        System.out.println("Alunos: " + alunoModel.findAll().size());
        System.out.println("Cursos: " + cursoModel.findAll().size());

        aluno.setNomeCompleto("João Pereira Atualizado");
        alunoModel.update(aluno);

        curso.setNome("Java Avançado");
        cursoModel.update(curso);

        System.out.println("Aluno buscado: " + alunoModel.findById(aluno.getId()).getNomeCompleto());
        System.out.println("Curso buscado: " + cursoModel.findById(curso.getId()).getNome());

        System.out.println("TESTE CRUD FINALIZADO!");
    }
}
