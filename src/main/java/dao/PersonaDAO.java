package dao;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Persona;

public class PersonaDAO {
	private final EntityManager em;
	static Connection conn = null;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Persona p) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
		transaction.commit();
	}

	public Persona getById(long id) {
		Persona found = em.find(Persona.class, id);

		if (found != null) {
			System.out.println("Evento" + " " + id + " " + "trovato");
		} else {
			System.out.println("Non abbiamo trovato niente");
		}
		return found;

	}

}
