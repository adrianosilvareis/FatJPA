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
@Table(name = "fat_fatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fatura.findAll", query = "SELECT f FROM Fatura f"),
    @NamedQuery(name = "Fatura.findById", query = "SELECT f FROM Fatura f WHERE f.id = :id"),
    @NamedQuery(name = "Fatura.findByData", query = "SELECT f FROM Fatura f WHERE f.data = :data"),
    @NamedQuery(name = "Fatura.findByValor", query = "SELECT f FROM Fatura f WHERE f.valor = :valor"),
    @NamedQuery(name = "Fatura.findByFechamento", query = "SELECT f FROM Fatura f WHERE f.fechamento = :fechamento")})
public class Fatura implements Serializable {
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
    @Column(name = "fechamento")
    private Boolean fechamento;
    @JoinTable(name = "fat_fatura_has_historico", joinColumns = {
        @JoinColumn(name = "fatura_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "historico_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Historico> historicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faturaId")
    private List<Glosa> glosaList;
    @JoinColumn(name = "imposto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Imposto impostoId;
    @JoinColumn(name = "producao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producao producaoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faturaId")
    private List<Nota> notaList;

    public Fatura() {
    }

    public Fatura(Integer id) {
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

    public Boolean getFechamento() {
        return fechamento;
    }

    public void setFechamento(Boolean fechamento) {
        this.fechamento = fechamento;
    }

    @XmlTransient
    public List<Historico> getHistoricoList() {
        return historicoList;
    }

    public void setHistoricoList(List<Historico> historicoList) {
        this.historicoList = historicoList;
    }

    @XmlTransient
    public List<Glosa> getGlosaList() {
        return glosaList;
    }

    public void setGlosaList(List<Glosa> glosaList) {
        this.glosaList = glosaList;
    }

    public Imposto getImpostoId() {
        return impostoId;
    }

    public void setImpostoId(Imposto impostoId) {
        this.impostoId = impostoId;
    }

    public Producao getProducaoId() {
        return producaoId;
    }

    public void setProducaoId(Producao producaoId) {
        this.producaoId = producaoId;
    }

    @XmlTransient
    public List<Nota> getNotaList() {
        return notaList;
    }

    public void setNotaList(List<Nota> notaList) {
        this.notaList = notaList;
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
        if (!(object instanceof Fatura)) {
            return false;
        }
        Fatura other = (Fatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.tommasi.entidade.Fatura[ id=" + id + " ]";
    }
    
}
