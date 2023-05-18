package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Concerto;
import entities.Evento;

public class ConcertoDAO {
	private final EntityManager em;

	public ConcertoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Concerto c) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(c);
		transaction.commit();
	}

	public Evento getById(long id) {
		Evento found = em.find(Evento.class, id);

		if (found != null) {
			System.out.println("Evento" + " " + id + " " + "trovato");
		} else {
			System.out.println("Non abbiamo trovato niente");
		}
		return found;

	}
}
