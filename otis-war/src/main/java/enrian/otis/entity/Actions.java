/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrian.otis.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author mixgho
 */
@Entity
@Table(name = "ACTIONS")
@NamedQueries({
    @NamedQuery(name = "Actions.findAll", query = "SELECT a FROM Actions a")
    , @NamedQuery(name = "Actions.findByClockin", query = "SELECT a FROM Actions a WHERE a.clockin = :clockin")
    , @NamedQuery(name = "Actions.findByClockout", query = "SELECT a FROM Actions a WHERE a.clockout = :clockout")
    , @NamedQuery(name = "Actions.findByDescription", query = "SELECT a FROM Actions a WHERE a.description = :description")
    , @NamedQuery(name = "Actions.findById", query = "SELECT a FROM Actions a WHERE a.id = :id")})
public class Actions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CLOCKIN")
    @Temporal(TemporalType.DATE)
    private Date clockin;
    @Column(name = "CLOCKOUT")
    @Temporal(TemporalType.DATE)
    private Date clockout;
    @Lob
    @Column(name = "PICTURE")
    private Serializable picture;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Users userid;
    @OneToMany(mappedBy = "actionid", fetch = FetchType.EAGER)
    private List<Opportunities> opportunitiesList;

    public Actions() {
    }

    public Actions(Integer id) {
        this.id = id;
    }

    public Date getClockin() {
        return clockin;
    }

    public void setClockin(Date clockin) {
        this.clockin = clockin;
    }

    public Date getClockout() {
        return clockout;
    }

    public void setClockout(Date clockout) {
        this.clockout = clockout;
    }

    public Serializable getPicture() {
        return picture;
    }

    public void setPicture(Serializable picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    public List<Opportunities> getOpportunitiesList() {
        return opportunitiesList;
    }

    public void setOpportunitiesList(List<Opportunities> opportunitiesList) {
        this.opportunitiesList = opportunitiesList;
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
        if (!(object instanceof Actions)) {
            return false;
        }
        Actions other = (Actions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enrian.otis.entity.Actions[ id=" + id + " ]";
    }
    
}
