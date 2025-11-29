package models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import entities.Aluno;

public class AlunoModel {

    private final String GESTAO = "gestao-cursos-jpa";

    public void create(Aluno aluno) {
        EntityManager em = Persistence.createEntityManagerFactory(GESTAO).createEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
    }

    public Aluno findById(Long id) {
        EntityManager em = Persistence.createEntityManagerFactory(GESTAO).createEntityManager();
        Aluno aluno = em.find(Aluno.class, id);
        em.close();
        return aluno;
    }

    public List<Aluno> findAll() {
        EntityManager em = Persistence.createEntityManagerFactory(GESTAO).createEntityManager();
        List<Aluno> lista = em.createQuery("FROM Aluno", Aluno.class).getResultList();
        em.close();
        return lista;
    }

    public void update(Aluno aluno) {
        EntityManager em = Persistence.createEntityManagerFactory(GESTAO).createEntityManager();
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Aluno aluno) {
        EntityManager em = Persistence.createEntityManagerFactory(GESTAO).createEntityManager();
        em.getTransaction().begin();
        Aluno a = em.find(Aluno.class, aluno.getId());
        em.remove(a);
        em.getTransaction().commit();
        em.close();
    }
}