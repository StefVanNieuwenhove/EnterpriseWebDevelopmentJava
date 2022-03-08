package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {
	
	private static EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("school");
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return EntityManagerFactory;
	}
	
	private JPA() {
		
	}
}
