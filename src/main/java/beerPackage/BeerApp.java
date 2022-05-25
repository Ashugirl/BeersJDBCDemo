package beerPackage;

import beerPackage.data.SuperVillain;
import beerPackage.data.Superhero;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BeerApp {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AvivaDatabase");
        EntityManager em = emf.createEntityManager();

        Superhero superman = new Superhero("Superman", "Everything");
        SuperVillain boris = new SuperVillain("Boris", "Russian accent");
       // Superhero theTick = new Superhero("The Tick", "obtuseness");

        //create
        em.getTransaction().begin();
        em.persist(boris);
        em.getTransaction().commit();


        //find
       /* SuperVillain superVillain = em.find(SuperVillain.class, 102);

        //update
       em.getTransaction().begin();
        superVillain.setSuperPower("Money AND Robots");
        em.persist(superVillain);
        em.getTransaction().commit();

        //remove
        em.getTransaction().begin();
        em.remove(superVillain);
        em.getTransaction().commit();



        //findAll
        Query query = em.createQuery("Select v from SuperVillain v");
        List<SuperVillain> list = query.getResultList();

        for(SuperVillain sv : list){
            System.out.println(sv);


        }

        */
    }
}
