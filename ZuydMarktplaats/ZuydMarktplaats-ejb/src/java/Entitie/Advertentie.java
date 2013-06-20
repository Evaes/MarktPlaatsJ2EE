/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Erwin
 */
@Entity
@Table(name = "advertentie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertentie.findAll", query = "SELECT a FROM Advertentie a"),
    @NamedQuery(name = "Advertentie.findById", query = "SELECT a FROM Advertentie a WHERE a.id = :id"),
    @NamedQuery(name = "Advertentie.findByNaam", query = "SELECT a FROM Advertentie a WHERE a.naam = :naam"),
    @NamedQuery(name = "Advertentie.findByBeschrijving", query = "SELECT a FROM Advertentie a WHERE a.beschrijving = :beschrijving"),
    @NamedQuery(name = "Advertentie.findByVraagprijs", query = "SELECT a FROM Advertentie a WHERE a.vraagprijs = :vraagprijs")})
public class Advertentie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Naam")
    private String naam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Beschrijving")
    private String beschrijving;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vraagprijs")
    private BigDecimal vraagprijs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advertentieid")
    private Collection<Bieding> biedingCollection;
    @JoinColumn(name = "Gebruiker_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Gebruiker gebruikerid;

    public Advertentie() {
    }

    public Advertentie(Integer id) {
        this.id = id;
    }

    public Advertentie(Integer id, String naam, String beschrijving, BigDecimal vraagprijs) {
        this.id = id;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.vraagprijs = vraagprijs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public BigDecimal getVraagprijs() {
        return vraagprijs;
    }

    public void setVraagprijs(BigDecimal vraagprijs) {
        this.vraagprijs = vraagprijs;
    }

    @XmlTransient
    public Collection<Bieding> getBiedingCollection() {
        return biedingCollection;
    }

    public void setBiedingCollection(Collection<Bieding> biedingCollection) {
        this.biedingCollection = biedingCollection;
    }

    public Gebruiker getGebruikerid() {
        return gebruikerid;
    }

    public void setGebruikerid(Gebruiker gebruikerid) {
        this.gebruikerid = gebruikerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertentie)) {
            return false;
        }
        Advertentie other = (Advertentie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitie.Advertentie[ id=" + id + " ]";
    }
    
}
