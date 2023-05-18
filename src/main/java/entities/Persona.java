package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "persone")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Persona {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String cognome;
	private LocalDate dataDiNascita;
	private String email;

	public Persona(String nome, String cognome, LocalDate dataDiNascita, String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.email = email;
	}

}
