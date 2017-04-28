/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import reservation.entity.Adresse;
import reservation.entity.Chambre;
import reservation.entity.Hotel;

/**
 *
 * @author formation
 */
public class JPATest {

    @Test
    public void demarrerJPA(){
        Persistence.createEntityManagerFactory("PU");
    }
    
//    @Test
//    public void recupChambreId() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
//        EntityManager em = factory.createEntityManager();
//
//        Chambre chambre = em.find(Chambre.class, 251L);
//
//        System.out.println(String.format("Chambre: id=%d nom=%s prix=%9.2f hotel=%s", chambre.getId(), chambre.getNom(), chambre.getPrix(), chambre.getHotel().getNom()));
//
//    }

//    @Test
    public void ajouterHotel() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Adresse adr = new Adresse();
        Hotel htl = new Hotel("Hotel de la Gare", adr);

        htl.setNom("Bozqurtlar");
        adr.setLocalite("Orkhon");
        adr.setPays("Altay");
        adr.setRue("Ashina");
        adr.setCodePostal(10000L);

        em.getTransaction().begin();
        em.persist(htl);
        em.getTransaction().commit();
    }

//    @Test
    public void ajouterChambre() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();

        Chambre c = new Chambre();
        c.setNom("Suite ");
        c.setPrix(20000.0);
        c.setDescrption("C'est pas cher");
        //L'Objet EntityManager permet de lire et écrire en base
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

}
