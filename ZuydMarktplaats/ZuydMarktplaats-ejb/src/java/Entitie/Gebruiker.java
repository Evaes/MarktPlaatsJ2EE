/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "gebruiker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gebruiker.findAll", query = "SELECT g FROM Gebruiker g"),
    @NamedQuery(name = "Gebruiker.findById", query = "SELECT g FROM Gebruiker g WHERE g.id = :id"),
    @NamedQuery(name = "Gebruiker.findByVoornaam", query = "SELECT g FROM Gebruiker g WHERE g.voornaam = :voornaam"),
    @NamedQuery(name = "Gebruiker.findByAchternaam", query = "SELECT g FROM Gebruiker g WHERE g.achternaam = :achternaam"),
    @NamedQuery(name = "Gebruiker.findByEmail", query = "SELECT g FROM Gebruiker g WHERE g.email = :email"),
    @NamedQuery(name = "Gebruiker.findByTelefoonnummer", query = "SELECT g FROM Gebruiker g WHERE g.telefoonnummer = :telefoonnummer"),
    @NamedQuery(name = "Gebruiker.findByUsername", query = "SELECT g FROM Gebruiker g WHERE g.username = :username"),
    @NamedQuery(name = "Gebruiker.findByPassword", query = "SELECT g FROM Gebruiker g WHERE g.password = :password"),
    @NamedQuery(name = "Gebruiker.findByAccounttype", query = "SELECT g FROM Gebruiker g WHERE g.accounttype = :accounttype")})
public class Gebruiker implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "voornaam")
    private String voornaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "achternaam")
    private String achternaam;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefoonnummer")
    private String telefoonnummer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accounttype")
    private int accounttype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gebruikerid")
    private Collection<Bieding> biedingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gebruikerid")
    private Collection<Advertentie> advertentieCollection;

    public Gebruiker() {
    }

    public Gebruiker(Integer id) {
        this.id = id;
    }

    public Gebruiker(Integer id, String voornaam, String achternaam, String email, String telefoonnummer, String username, String password, int accounttype) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.telefoonnummer = telefoonnummer;
        this.username = username;
        this.password = password;
        this.accounttype = accounttype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(int accounttype) {
        this.accounttype = accounttype;
    }

    @XmlTransient
    public Collection<Bieding> getBiedingCollection() {
        return biedingCollection;
    }

    public void setBiedingCollection(Collection<Bieding> biedingCollection) {
        this.biedingCollection = biedingCollection;
    }

    @XmlTransient
    public Collection<Advertentie> getAdvertentieCollection() {
        return advertentieCollection;
    }

    public void setAdvertentieCollection(Collection<Advertentie> advertentieCollection) {
        this.advertentieCollection = advertentieCollection;
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
        if (!(object instanceof Gebruiker)) {
            return false;
        }
        Gebruiker other = (Gebruiker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitie.Gebruiker[ id=" + id + " ]";
    }
    
}
