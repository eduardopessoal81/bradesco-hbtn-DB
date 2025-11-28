package models;

import javax.persistence.*;

import entities.Produto;

import java.util.List;

public class ProdutoModel {

    private static final String ADMIN = "admin-jpa";

    public void create(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ADMIN);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar produto: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void update(Produto p) {
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

    public void delete(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ADMIN);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, p.getId());
            em.remove(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    public Produto findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ADMIN);
        EntityManager em = emf.createEntityManager();

        Produto produto = em.find(Produto.class, id);

        em.close();
        emf.close();

        return produto;
    }

    public List<Produto> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ADMIN);
        EntityManager em = emf.createEntityManager();

        List<Produto> produtos = em.createQuery("FROM Produto", Produto.class).getResultList();

        em.close();
        emf.close();

        return produtos;
    }
}
