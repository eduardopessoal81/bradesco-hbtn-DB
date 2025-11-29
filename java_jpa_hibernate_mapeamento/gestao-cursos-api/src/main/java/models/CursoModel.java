package models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entities.Curso;

public class CursoModel {

    private final String GESTAO = "gestao-cursos-jpa";

    public void create(Curso curso) {
        EntityManager em = Persistence.createEntityManagerFactory(GESTAO).createEntityManager();
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        em.close();
    }

    public Curso findById(Long id) {
        EntityManager em = Persistence.createEntityManagerFactory(GESTAO).createEntityManager();
        Curso curso = em.find(Curso.class, id);
        em.close();
        return curso;
    }

    public List<Curso> findAll() {
        EntityManager em = Persistence.createEntityManagerFactory(GESTAO).createEntityManager();
        List<Curso> lista = em.createQuery("FROM Curso", Curso.class).getResultList();
        em.close();
        return lista;
    }

    public void update(Curso curso) {
        EntityManager em = Persistence.createEntityManagerFactory(GESTAO).createEntityManager();
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Curso curso) {
        EntityManager em = Persistence.createEntityManagerFactory(GESTAO).createEntityManager();
        em.getTransaction().begin();
        Curso c = em.find(Curso.class, curso.getId());
        em.remove(c);
        em.getTransaction().commit();
        em.close();
    }
}