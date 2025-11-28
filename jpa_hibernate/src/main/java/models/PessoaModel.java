package models;

import javax.persistence.*;

import entities.Pessoa;

import java.util.List;

public class PessoaModel {

    private static final String ADMIN = "admin-jpa";

    public void create(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ADMIN);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void update(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ADMIN);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    public void delete(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ADMIN);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Pessoa pessoa = em.find(Pessoa.class, p.getId());
            em.remove(pessoa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    public Pessoa findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ADMIN);
        EntityManager em = emf.createEntityManager();

        Pessoa pessoa = em.find(Pessoa.class, id);

        em.close();
        emf.close();

        return pessoa;
    }

    public List<Pessoa> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ADMIN);
        EntityManager em = emf.createEntityManager();

        List<Pessoa> pessoas = em.createQuery("FROM Pessoa", Pessoa.class).getResultList();

        em.close();
        emf.close();

        return pessoas;
    }
}