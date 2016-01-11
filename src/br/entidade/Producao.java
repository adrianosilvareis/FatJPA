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
@Table(name = "fat_producao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producao.findAll", query = "SELECT p FROM Producao p"),
    @NamedQuery(name = "Producao.findById", query = "SELECT p FROM Producao p WHERE p.id = :id"),
    @NamedQuery(name = "Producao.findByValor", query = "SELECT p FROM Producao p WHERE p.valor = :valor"),
    @NamedQuery(name = "Producao.findByInicial", query = "SELECT p FROM Producao p WHERE p.inicial = :inicial"),
    @NamedQuery(name = "Producao.findByFinal1", query = "SELECT p FROM Producao p WHERE p.final1 = :final1"),
    @NamedQuery(name = "Producao.findByEnviado", query = "SELECT p FROM Producao p WHERE p.enviado = :enviado")})
public class Producao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "inicial")
    @Temporal(TemporalType.DATE)
    private Date inicial;
    @Column(name = "final")
    @Temporal(TemporalType.DATE)
    private Date final1;
    @Column(name = "enviado")
    private Boolean enviado;
    @ManyToMany(mappedBy = "producaoList")
    private List<Historico> historicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producaoId")
    private List<Fatura> faturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producaoId")
    private List<Resto> restoList;
    @JoinColumn(name = "convenio_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Convenio convenioId;

    public Producao() {
    }

    public Producao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getInicial() {
        return inicial;
    }

    public void setInicial(Date inicial) {
        this.inicial = inicial;
    }

    public Date getFinal1() {
        return final1;
    }

    public void setFinal1(Date final1) {
        this.final1 = final1;
    }

    public Boolean getEnviado() {
        return enviado;
    }

    public void setEnviado(Boolean enviado) {
        this.enviado = enviado;
    }

    @XmlTransient
    public List<Historico> getHistoricoList() {
        return historicoList;
    }

    public void setHistoricoList(List<Historico> historicoList) {
        this.historicoList = historicoList;
    }

    @XmlTransient
    public List<Fatura> getFaturaList() {
        return faturaList;
    }

    public void setFaturaList(List<Fatura> faturaList) {
        this.faturaList = faturaList;
    }
    
    @XmlTransient
    public List<Resto> getRestoList() {
        return restoList;
    }

    public void setRestoList(List<Resto> restoList) {
        this.restoList = restoList;
    }
    
    public Convenio getConvenioId() {
        return convenioId;
    }

    public void setConvenioId(Convenio convenioId) {
        this.convenioId = convenioId;
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
        if (!(object instanceof Producao)) {
            return false;
        }
        Producao other = (Producao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.tommasi.entidade.Producao[ id=" + id + " ]";
    }
    
}
