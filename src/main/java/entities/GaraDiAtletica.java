package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
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
public class GaraDiAtletica extends Evento {
	private String setAtleti;
	private String vincitore;

	public GaraDiAtletica(String titolo, LocalDate date, String descrizione, String tipoEvento,
			int numeroMassimoPartecipanti, String setAtleti, String vincitore) {
		super(titolo, date, descrizione, tipoEvento, numeroMassimoPartecipanti);
		this.setAtleti = setAtleti;
		this.vincitore = vincitore;
	}

}
