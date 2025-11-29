package demo;

import java.util.List;

import entities.Aluno;
import entities.Curso;
import entities.Endereco;
import entities.MaterialCurso;
import entities.Professor;
import entities.Telefone;
import models.CursoModel;

public class GestaoCursosMain {

    public static void main(String[] args) {

        CursoModel cursoModel = new CursoModel();

        Professor professor = new Professor();
        professor.setNome("Professor Carlos");

        Aluno aluno = new Aluno();
        aluno.setNome("João");

        Endereco end = new Endereco();
        end.setRua("Rua A");
        end.setCidade("São Paulo");
        end.setAluno(aluno);

        Telefone tel = new Telefone();
        tel.setNumero("11999999999");
        tel.setAluno(aluno);

        aluno.setEnderecos(List.of(end));
        aluno.setTelefones(List.of(tel));

        Curso curso = new Curso();
        curso.setNome("Java Avançado");
        curso.setProfessor(professor);
        curso.setAlunos(List.of(aluno));

        MaterialCurso material = new MaterialCurso();
        material.setDescricao("Apostila Java");
        material.setCurso(curso);

        curso.setMaterial(material);

        cursoModel.create(curso);

        System.out.println("Todas as tabelas populadas com sucesso!");
    }
}