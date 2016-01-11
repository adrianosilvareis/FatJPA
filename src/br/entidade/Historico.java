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
@Table(name = "fat_historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historico.findAll", query = "SELECT h FROM Historico h"),
    @NamedQuery(name = "Historico.findById", query = "SELECT h FROM Historico h WHERE h.id = :id"),
    @NamedQuery(name = "Historico.findByDescricao", query = "SELECT h FROM Historico h WHERE h.descricao = :descricao"),
    @NamedQuery(name = "Historico.findByData", query = "SELECT h FROM Historico h WHERE h.data = :data")})
public class Historico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @ManyToMany(mappedBy = "historicoList")
    private List<Caixa> caixaList;
    @JoinTable(name = "fat_producao_has_historico", joinColumns = {
        @JoinColumn(name = "historico_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "producao_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Producao> producaoList;
    @ManyToMany(mappedBy = "historicoList")
    private List<Glosa> glosaList;
    @ManyToMany(mappedBy = "historicoList")
    private List<Fatura> faturaList;
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuariosId;

    public Historico() {
    }

    public Historico(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @XmlTransient
    public List<Caixa> getCaixaList() {
        return caixaList;
    }

    public void setCaixaList(List<Caixa> caixaList) {
        this.caixaList = caixaList;
    }

    @XmlTransient
    public List<Producao> getProducaoList() {
        return producaoList;
    }

    public void setProducaoList(List<Producao> producaoList) {
        this.producaoList = producaoList;
    }
    
    @XmlTransient
    public List<Glosa> getGlosaList() {
        return glosaList;
    }

    public void setGlosaList(List<Glosa> glosaList) {
        this.glosaList = glosaList;
    }
    @XmlTransient
    public List<Fatura> getFaturaList() {
        return faturaList;
    }

    public void setFaturaList(List<Fatura> faturaList) {
        this.faturaList = faturaList;
    }

    public Usuarios getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Usuarios usuariosId) {
        this.usuariosId = usuariosId;
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
        if (!(object instanceof Historico)) {
            return false;
        }
        Historico other = (Historico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.tommasi.entidade.Historico[ id=" + id + " ]";
    }
    
}
