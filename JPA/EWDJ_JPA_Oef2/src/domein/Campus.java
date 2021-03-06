package domein;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Campus.findAll", 
                query = "SELECT c FROM Campus c"),
    @NamedQuery(name = "Campus.findByName",
    			query = "SELECT c from Campus c WHERE c.campusNaam = :naam")
})
public class Campus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int campusID;
	   
    private String campusNaam;

    @ManyToMany( mappedBy = "campussen")
    private final  Set<Docent> docenten = new HashSet<>();

    public Campus(String campusNaam) {
        this.campusNaam = campusNaam;
    }
    
    protected Campus() {
    	
    }
    
    public String getCampusNaam() {
        return this.campusNaam;
    }

    public void setCampusNaam(String campusNaam) {
        this.campusNaam = campusNaam;
    }

    public Set<Docent> getDocenten() {
        return Collections.unmodifiableSet(docenten);
    }
    
    public void addDocent(Docent docent) {
        docenten.add(docent);
    }

    public void removeDocent(Docent docent) {
        docenten.remove(docent);
    }
    
    @Override
    public String toString() {
        return String.format("%d %s", campusID, campusNaam);
    }

	@Override
	public int hashCode() {
		return Objects.hash(campusNaam);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campus other = (Campus) obj;
		return campusNaam == other.campusNaam;
	}
}
