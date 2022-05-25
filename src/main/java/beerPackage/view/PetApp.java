package beerPackage.view;

import beerPackage.data.Dog;
import beerPackage.data.Owner;
import beerPackage.repositories.EMFactory;

import javax.persistence.EntityManager;

public class PetApp {
    public static void main(String[] args) {


        //Owner owner = new Owner("Tintin");


        EntityManager em = EMFactory.getEMF().createEntityManager();

        //owner1 = em.find(Owner.class, 1);

        //Dog dog = new Dog(1, "Odie", owner1);

        em.getTransaction().begin();
        //em.persist(dog);
        em.getTransaction().commit();


    }
}
