package beerPackage.view;

import beerPackage.data.Dog;
import beerPackage.data.Owner;
import beerPackage.repositories.EMFactory;

import javax.persistence.EntityManager;

public class PetApp {
    public static void main(String[] args) {


        EntityManager em = EMFactory.getEMF().createEntityManager();

    //    Owner owner = new Owner("Jon");

       Dog dog = em.find(Dog.class, 2);
       em.getTransaction().begin();
        em.remove(dog);
        em.getTransaction().commit();





       // dog = em.find(Dog.class, 1);
     // Dog dog = new Dog(1, "Bobbie", owner);
//
//        em.getTransaction().begin();
//        em.persist(dog);
//        em.getTransaction().commit();

//       System.out.println(owner.getDog());
    }
}


