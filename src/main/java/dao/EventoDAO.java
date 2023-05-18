package dao;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Concerto;
import entities.Concerto.GenereConcerto;
import entities.Evento;
import entities.GaraDiAtletica;
import entities.PartitaDiCalcio;
import entities.Persona;

public class EventoDAO {
	// QUA DENTRO AVREMO PURE BISOGNO DELL'ENTITY MANAGER OLTRE CHE AI METODI , LO
	// CREERO NEL MAIN E LO PASSERO AI MIEI DAO
	private final EntityManager em;
	static Connection conn = null;

	public EventoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Evento e) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(e);
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

	public void delete(long id) {
		Evento found = em.find(Evento.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("Evento " + id + " " + "è stato eliminato dal db");
		} else {
			System.out.println("non ho eliminato un bel  niente");
		}
	}

	public void refresh(long id) {
		Evento found = em.find(Evento.class, id);
		if (found != null) {

			found.setNumeroMassimoPartecipanti(120);
			System.out.println("Pre refresh");
			System.out.println(found);
			em.refresh(found);
			System.out.println("Post refresh");
			System.out.println(found);
		} else {
			System.out.println("non ho trovato niente e non ho refreshato");
		}
	}

	public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
		TypedQuery<Concerto> q = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming",
				Concerto.class);
		q.setParameter("inStreaming", inStreaming);
		return q.getResultList();
	}

	public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
		TypedQuery<Concerto> q = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
		q.setParameter("genere", genere);
		return q.getResultList();
	}

	public List<PartitaDiCalcio> getPartiteVinteInCasa(String sqCasa) {
		TypedQuery<PartitaDiCalcio> q = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa",
				PartitaDiCalcio.class);
		return q.getResultList();
	}

	public List<PartitaDiCalcio> getPartiteVinteInTrasferta(String sqOspite) {
		TypedQuery<PartitaDiCalcio> q = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta",
				PartitaDiCalcio.class);
		return q.getResultList();
	}

	public List<PartitaDiCalcio> getPartitePareggiate() {
		TypedQuery<PartitaDiCalcio> q = em.createNamedQuery("PartitaDiCalcio.getPartitePareggiate",
				PartitaDiCalcio.class);
		return q.getResultList();
	}

	public GaraDiAtletica getGareDiAtleticaPerVincitore(Persona vincitore) {
		TypedQuery<GaraDiAtletica> q = em.createNamedQuery("GaraDiAtletica.getGareDiAtleticaPerVincitore",
				GaraDiAtletica.class);
		q.setParameter("vincitore", vincitore);
		return q.getSingleResult();
	}

}
