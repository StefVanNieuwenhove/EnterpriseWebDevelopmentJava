package main;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import domein.Docent;
import util.JPA;

public class Oef1 {

	public static void main(String[] args) {
		
		Docent d1 = new Docent(123, "Jan", "Baard", new BigDecimal(8000));
		Docent d2 = new Docent(456, "Piet", "Baard", new BigDecimal(10000));
		Docent d3 = new Docent(789, "Joris", "Zonderbaard", new BigDecimal(12000));
		
		// vraag entityManger aan factory
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		
		// start transactie
		entityManager.getTransaction().begin();
		
		
		// persisteer 3 objecten
		entityManager.persist(d1);
		entityManager.persist(d2);
		entityManager.persist(d3);
		
		// commit
		entityManager.getTransaction().commit();
		
		// sluit entityManager
		entityManager.close();
		
		// sluit factory
		JPA.getEntityManagerFactory().close();
	}
}
