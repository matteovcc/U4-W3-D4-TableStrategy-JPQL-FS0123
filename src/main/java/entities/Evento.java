package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@ToString
public abstract class Evento {
	@Id
	@GeneratedValue
	private long id;
	private String titolo;
	private LocalDate date;
	private String descrizione;
	private String tipoEvento;
	private int numeroMassimoPartecipanti;

	public Evento(String titolo, LocalDate date, String descrizione, String tipoEvento, int numeroMassimoPartecipanti) {
		super();
		this.titolo = titolo;
		this.date = date;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
	}

	public Evento() {

	}

}
