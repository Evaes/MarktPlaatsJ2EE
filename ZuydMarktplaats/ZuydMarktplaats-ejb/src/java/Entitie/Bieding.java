/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Erwin
 */
@Entity
@Table(name = "bieding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bieding.findAll", query = "SELECT b FROM Bieding b"),
    @NamedQuery(name = "Bieding.findByIdBieding", query = "SELECT b FROM Bieding b WHERE b.idBieding = :idBieding"),
    @NamedQuery(name = "Bieding.findByBodWaarde", query = "SELECT b FROM Bieding b WHERE b.bodWaarde = :bodWaarde")})
public class Bieding implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBieding")
    private Integer idBieding;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "BodWaarde")
    private BigDecimal bodWaarde;
    @JoinColumn(name = "Gebruiker_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Gebruiker gebruikerid;
    @JoinColumn(name = "Advertentie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Advertentie advertentieid;

    public Bieding() {
    }

    public Bieding(Integer idBieding) {
        this.idBieding = idBieding;
    }

    public Bieding(Integer idBieding, BigDecimal bodWaarde) {
        this.idBieding = idBieding;
        this.bodWaarde = bodWaarde;
    }

    public Integer getIdBieding() {
        return idBieding;
    }

    public void setIdBieding(Integer idBieding) {
        this.idBieding = idBieding;
    }

    public BigDecimal getBodWaarde() {
        return bodWaarde;
    }

    public void setBodWaarde(BigDecimal bodWaarde) {
        this.bodWaarde = bodWaarde;
    }

    public Gebruiker getGebruikerid() {
        return gebruikerid;
    }

    public void setGebruikerid(Gebruiker gebruikerid) {
        this.gebruikerid = gebruikerid;
    }

    public Advertentie getAdvertentieid() {
        return advertentieid;
    }

    public void setAdvertentieid(Advertentie advertentieid) {
        this.advertentieid = advertentieid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBieding != null ? idBieding.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bieding)) {
            return false;
        }
        Bieding other = (Bieding) object;
        if ((this.idBieding == null && other.idBieding != null) || (this.idBieding != null && !this.idBieding.equals(other.idBieding))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitie.Bieding[ idBieding=" + idBieding + " ]";
    }
    
}
