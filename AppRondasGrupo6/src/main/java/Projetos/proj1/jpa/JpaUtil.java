package Projetos.proj1.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	static EntityManagerFactory emf = null;
	
	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("Proj1");
		}
		return emf.createEntityManager();
	}
}
