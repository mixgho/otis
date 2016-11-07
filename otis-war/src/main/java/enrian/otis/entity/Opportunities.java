/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrian.otis.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mixgho
 */
@Entity
@Table(name = "OPPORTUNITIES")
@NamedQueries({
    @NamedQuery(name = "Opportunities.findAll", query = "SELECT o FROM Opportunities o")
    , @NamedQuery(name = "Opportunities.findById", query = "SELECT o FROM Opportunities o WHERE o.id = :id")
    , @NamedQuery(name = "Opportunities.findByCompany", query = "SELECT o FROM Opportunities o WHERE o.company = :company")
    , @NamedQuery(name = "Opportunities.findByDescription", query = "SELECT o FROM Opportunities o WHERE o.description = :description")})
public class Opportunities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Lob
    @Column(name = "PICTURE")
    private Serializable picture;
    @JoinColumn(name = "ACTIONID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Actions actionid;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Users userid;

    public Opportunities() {
    }

    public Opportunities(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Serializable getPicture() {
        return picture;
    }

    public void setPicture(Serializable picture) {
        this.picture = picture;
    }

    public Actions getActionid() {
        return actionid;
    }

    public void setActionid(Actions actionid) {
        this.actionid = actionid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
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
        if (!(object instanceof Opportunities)) {
            return false;
        }
        Opportunities other = (Opportunities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enrian.otis.entity.Opportunities[ id=" + id + " ]";
    }
    
}
