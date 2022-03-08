package main;
import java.math.BigDecimal;

import javax.persistence.EntityManager;

import domein.Docent;
import util.JPA;

public class Oef2 {

	public static void main(String[] args) {
		
		EntityManager entityManager = JPA.getEntityManagerFactory().createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Docent docent = entityManager.find(Docent.class, 2L);
		if (docent != null)	{
			System.out.println(docent.toString());
			docent.opslag(new BigDecimal(200));
		} else System.out.println("Docent met id nummer 2 is niet gevonden");
		
		entityManager.getTransaction().commit();
		
		System.out.println("opslag van €200");
		System.out.println(docent.toString());
		
		entityManager.close();
		JPA.getEntityManagerFactory().close();
	}
}
