/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entidade;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "fat_perda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perda.findAll", query = "SELECT p FROM Perda p"),
    @NamedQuery(name = "Perda.findById", query = "SELECT p FROM Perda p WHERE p.id = :id"),
    @NamedQuery(name = "Perda.findByValor", query = "SELECT p FROM Perda p WHERE p.valor = :valor"),
    @NamedQuery(name = "Perda.findByDescricao", query = "SELECT p FROM Perda p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Perda.findByData", query = "SELECT p FROM Perda p WHERE p.data = :data")})
public class Perda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "glosa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Glosa glosaId;

    public Perda() {
    }

    public Perda(Integer id) {
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

    public Glosa getGlosaId() {
        return glosaId;
    }

    public void setGlosaId(Glosa glosaId) {
        this.glosaId = glosaId;
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
        if (!(object instanceof Perda)) {
            return false;
        }
        Perda other = (Perda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.tommasi.entidade.Perda[ id=" + id + " ]";
    }
    
}
