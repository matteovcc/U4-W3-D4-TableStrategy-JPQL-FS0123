package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "concerti")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Concerto extends Evento {
	public enum GenereConcerto {
		CLASSICO, ROCK, POP
	}

	private GenereConcerto genere;
	private boolean inStreaming;

	public Concerto(String titolo, LocalDate date, String descrizione, String tipoEvento, int numeroMassimoPartecipanti,
			GenereConcerto genere, boolean inStreaming) {
		super(titolo, date, descrizione, tipoEvento, numeroMassimoPartecipanti);
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

}
