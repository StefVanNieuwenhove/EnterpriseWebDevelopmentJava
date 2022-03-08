package main;

import java.util.List;

import javax.persistence.EntityManager;

import domein.Campus;
import domein.Docent;
import domein.Werkruimte;
import util.JPAUtil;

public class MAINoef6 {
	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Werkruimte werkruimte = entityManager.find(Werkruimte.class, "SCH555");
		
		Campus campusGent = entityManager.createNamedQuery("Campus.findByName", Campus.class).setParameter("naam", "Gent").getSingleResult();
		Campus campusAalst = entityManager.createNamedQuery("Campus.findByName", Campus.class).setParameter("naam", "Aalst").getSingleResult();
		
		if (werkruimte != null && campusAalst != null && campusGent != null) {
			List<Docent> docenten = entityManager.createNamedQuery("Docent.docentenInTweeCampussen", Docent.class)
					.setParameter("campusA", campusGent).setParameter("campusB", campusAalst).getResultList();
			
			docenten.forEach(x -> x.setWerkruimte(werkruimte));
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
		JPAUtil.getEntityManagerFactory().close();
	}
}
