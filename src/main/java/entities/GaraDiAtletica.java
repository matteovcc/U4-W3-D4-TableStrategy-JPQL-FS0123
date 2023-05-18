package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "gara_di_atletica")
@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedQuery(name = "GaraDiAtletica.getGareDiAtleticaPerVincitore", query = "SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :vincitore")
public class GaraDiAtletica extends Evento {
	private String setAtleti;

	@OneToOne
	private Persona vincitore;

	public GaraDiAtletica(String titolo, LocalDate date, String descrizione, String tipoEvento,
			int numeroMassimoPartecipanti, String setAtleti, Persona vincitore) {
		super(titolo, date, descrizione, tipoEvento, numeroMassimoPartecipanti);
		this.setAtleti = setAtleti;
		this.vincitore = vincitore;
	}

	public GaraDiAtletica(String titolo, LocalDate date, String descrizione, String tipoEvento,
			int numeroMassimoPartecipanti, String setAtleti) {
		super(titolo, date, descrizione, tipoEvento, numeroMassimoPartecipanti);
		this.setAtleti = setAtleti;
	}

}
