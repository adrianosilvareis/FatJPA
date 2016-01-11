/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "fat_glosa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Glosa.findAll", query = "SELECT g FROM Glosa g"),
    @NamedQuery(name = "Glosa.findById", query = "SELECT g FROM Glosa g WHERE g.id = :id"),
    @NamedQuery(name = "Glosa.findByData", query = "SELECT g FROM Glosa g WHERE g.data = :data"),
    @NamedQuery(name = "Glosa.findByValor", query = "SELECT g FROM Glosa g WHERE g.valor = :valor"),
    @NamedQuery(name = "Glosa.findByFechado", query = "SELECT g FROM Glosa g WHERE g.fechado = :fechado")})
public class Glosa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "fechado")
    private Boolean fechado;
    @JoinTable(name = "fat_glosa_has_historico", joinColumns = {
        @JoinColumn(name = "glosa_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "historico_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Historico> historicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "glosaId")
    private List<Recurso> recursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "glosaId")
    private List<Perda> perdaList;
    @JoinColumn(name = "fatura_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Fatura faturaId;

    public Glosa() {
    }

    public Glosa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getFechado() {
        return fechado;
    }

    public void setFechado(Boolean fechado) {
        this.fechado = fechado;
    }    

    @XmlTransient
    public List<Recurso> getRecursoList() {
        return recursoList;
    }
    
    public void setRecursoList(List<Recurso> recursoList) {
        this.recursoList = recursoList;
    }
    
    @XmlTransient
    public List<Historico> getHistoricoList() {
        return historicoList;
    }

    public void setHistoricoList(List<Historico> historicoList) {
        this.historicoList = historicoList;
    }    

    @XmlTransient
    public List<Perda> getPerdaList() {
        return perdaList;
    }

    public void setPerdaList(List<Perda> perdaList) {
        this.perdaList = perdaList;
    }

    public Fatura getFaturaId() {
        return faturaId;
    }

    public void setFaturaId(Fatura faturaId) {
        this.faturaId = faturaId;
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
        if (!(object instanceof Glosa)) {
            return false;
        }
        Glosa other = (Glosa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.tommasi.entidade.Glosa[ id=" + id + " ]";
    }
    
}
