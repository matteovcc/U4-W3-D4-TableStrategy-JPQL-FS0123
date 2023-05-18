package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Evento;
import entities.PartitaDiCalcio;

public class PartitaDiCalcioDAO {
	private final EntityManager em;

	public PartitaDiCalcioDAO(EntityManager em) {
		this.em = em;
	}

	public void savePartita(PartitaDiCalcio p) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
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
