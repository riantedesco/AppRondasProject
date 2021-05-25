package Projetos.proj1.jpa;

import javax.persistence.*;

import Projetos.proj1.domain.Usuario;

public class InserirUsuario {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(new Usuario(1,"user1", "user1@admin", "123"));
		em.merge(new Usuario(2,"user2", "user2@admin", "123"));
		em.getTransaction().commit();
	}
}
