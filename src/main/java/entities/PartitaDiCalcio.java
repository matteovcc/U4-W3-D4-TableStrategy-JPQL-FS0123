package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "partite_di_calcio")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PartitaDiCalcio extends Evento {
	private String sqCasa;
	private String sqOspite;
	private String sqVincente;
	private int golSqCasa;
	private int golSqOspite;

	public PartitaDiCalcio(String titolo, LocalDate date, String descrizione, String tipoEvento,
			int numeroMassimoPartecipanti, String sqCasa, String sqOspite, String sqVincente, int golSqCasa,
			int golSqOspite) {
		super(titolo, date, descrizione, tipoEvento, numeroMassimoPartecipanti);
		this.sqCasa = sqCasa;
		this.sqOspite = sqOspite;
		this.sqVincente = sqVincente;
		this.golSqCasa = golSqCasa;
		this.golSqOspite = golSqOspite;
	}

}
