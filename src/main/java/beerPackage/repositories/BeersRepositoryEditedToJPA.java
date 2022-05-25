package beerPackage.repositories;

import beerPackage.data.Beers;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeersRepositoryEditedToJPA {



    public void createOne(Beers beers) {
        EntityManager em = EMFactory.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(beers);
        em.getTransaction().commit();

    }

    public Beers findOneById(int id) {
        EntityManager em = EMFactory.getEMF().createEntityManager();
        return em.find(Beers.class, id);
    }

    public List<Beers> findAll() {
        EntityManager em = EMFactory.getEMF().createEntityManager();
        Query query = em.createQuery("Select v from Beers v");
        return query.getResultList();
    }

    public void updateOne(Beers beers) {
        EntityManager em = EMFactory.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(beers);
        em.getTransaction().commit();

    }

    public  void deleteOne(int id) {
        EntityManager em = EMFactory.getEMF().createEntityManager();
        Beers beers = findOneById(id);
        em.getTransaction().begin();
        em.remove(beers);
        em.getTransaction().commit();

    }

}
