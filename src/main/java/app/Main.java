package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.ConcertoDAO;
import dao.EventoDAO;
import dao.GaraDiAtleticaDAO;
import dao.PartitaDiCalcioDAO;
import dao.PersonaDAO;
import entities.Concerto;
import entities.Concerto.GenereConcerto;
import entities.GaraDiAtletica;
import entities.PartitaDiCalcio;
import entities.Persona;
import lombok.extern.slf4j.Slf4j;
import util.JpaUtil;

@Slf4j
public class Main {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EventoDAO ed = new EventoDAO(em);
		ConcertoDAO cd = new ConcertoDAO(em);
		PartitaDiCalcioDAO pd = new PartitaDiCalcioDAO(em);
		PersonaDAO personad = new PersonaDAO(em);
		GaraDiAtleticaDAO gd = new GaraDiAtleticaDAO(em);

		Concerto c1 = new Concerto("Queen", LocalDate.now(), "Concerto dei queen", "Pubblico", 2240,
				GenereConcerto.ROCK, true);
		Concerto c2 = new Concerto("Black eyed peas", LocalDate.now(), "Concerto Bep", "Pubblico", 20000,
				GenereConcerto.POP, false);
		Concerto c3 = new Concerto("Beethoven", LocalDate.now(), "Concerto Beethoven", "Pubblico", 232321,
				GenereConcerto.CLASSICO, true);

//		cd.save(c3);
//		cd.save(c2);
//		cd.save(c1);

		System.out.println("-----------Concerti in streaming------------");
		ed.getConcertiInStreaming(true).stream().forEach(concerti -> log.info(concerti.toString()));

		System.out.println("---------------Concerti non in streaming-----------------");
		ed.getConcertiInStreaming(false).stream().forEach(concerti -> log.info(concerti.toString()));

		System.out.println("------Concerti rock");
		ed.getConcertiPerGenere(GenereConcerto.ROCK).stream().forEach(concerti -> log.info(concerti.toString()));

		// ESERCIZIO 2
		PartitaDiCalcio pdc1 = new PartitaDiCalcio("Inter vs Milan", LocalDate.now(), "Semifinale CL Andata",
				"Pubblico", 80000, "Inter", "Milan", "Inter", 2, 0);
		PartitaDiCalcio pdc2 = new PartitaDiCalcio("Milan vs Inter", LocalDate.now(), "Semifinale CL Ritorno",
				"Pubblico", 80000, "Milan", "Inter", "Inter", 0, 1);
//		pd.savePartita(pdc1);
//		pd.savePartita(pdc2);
		System.out.println("----------PARTITE VINTE DALLA SQUADRA IN CASA-------");
		ed.getPartiteVinteInCasa("Inter").stream().forEach(partite -> log.info(partite.toString()));
		System.out.println("--------PARTITE VINTE DALLA SQUADRA IN TRASFERTA");
		ed.getPartiteVinteInTrasferta("Inter").stream().forEach(partite -> log.info(partite.toString()));

		PartitaDiCalcio pdc3 = new PartitaDiCalcio("Real Madrid vs Manchester City", LocalDate.now(),
				"Semifinale CL Andata", "Pubblico", 60000, "Real Madrid", "Manchester City", null, 1, 1);
//		pd.savePartita(pdc3);

		System.out.println("----PARTITE PAREGGIATE--------");
		ed.getPartitePareggiate().stream().forEach(partite -> log.info(partite.toString()));

		Persona p1 = new Persona("Matteo", "Vacca", LocalDate.now(), "mtvc@gmail.com");
//		personad.save(p1);

		Persona found = personad.getById(7);

		if (found != null) {
			log.info(found.toString());
		}

//		GaraDiAtletica gara1 = new GaraDiAtletica("Maratona D'europa", LocalDate.now(), "Staffetta", "Pubblico", 2000,
//				"default", p1);

		GaraDiAtletica gara2 = new GaraDiAtletica("Maratona D'europa", LocalDate.now(), "Staffetta", "Pubblico", 2000,
				"default", found);
		gara2.setVincitore(found);
		log.info("" + gara2.getVincitore());
//		gd.saveGara(gara2);

		log.info(ed.getGareDiAtleticaPerVincitore(found).toString());

		em.close();
		emf.close();
	}

}
