package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.ConcertoDAO;
import dao.EventoDAO;
import entities.Concerto;
import entities.Concerto.GenereConcerto;
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
	}

}
