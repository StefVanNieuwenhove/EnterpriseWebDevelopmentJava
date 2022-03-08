package domein;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Docent")
public class Docent implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "PersoneelsNr")
	private int docentNr;
	private String voornaam;
	private String familienaam;
	private BigDecimal wedde;
	
	public Docent(int docentNr, String voornaam, String familienaam, BigDecimal wedde) {
		setDocentNr(docentNr);
		setVoornaam(voornaam);
		setFamilienaam(familienaam);
		setWedde(wedde);
	}

	protected Docent() {
		
	}
	
	public void opslag(BigDecimal opslag) {
		this.wedde.add(opslag);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDocentNr() {
		return docentNr;
	}

	public void setDocentNr(int docentNr) {
		this.docentNr = docentNr;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

	public BigDecimal getWedde() {
		return wedde;
	}

	public void setWedde(BigDecimal wedde) {
		this.wedde = wedde;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s", docentNr, voornaam, familienaam, wedde);
	}

	@Override
	public int hashCode() {
		return Objects.hash(docentNr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Docent other = (Docent) obj;
		return docentNr == other.docentNr;
	}
}
