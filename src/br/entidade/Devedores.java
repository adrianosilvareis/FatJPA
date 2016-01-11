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
@Table(name = "fat_devedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devedores.findAll", query = "SELECT d FROM Devedores d"),
    @NamedQuery(name = "Devedores.findById", query = "SELECT d FROM Devedores d WHERE d.id = :id"),
    @NamedQuery(name = "Devedores.findByDescricao", query = "SELECT d FROM Devedores d WHERE d.descricao = :descricao"),
    @NamedQuery(name = "Devedores.findByData", query = "SELECT d FROM Devedores d WHERE d.data = :data"),
    @NamedQuery(name = "Devedores.findByPago", query = "SELECT d FROM Devedores d WHERE d.pago = :pago"),
    @NamedQuery(name = "Devedores.findByValor", query = "SELECT d FROM Devedores d WHERE d.valor = :valor")})
public class Devedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "pago")
    private Boolean pago;
    @Column(name = "valor")
    private String valor;
    @JoinColumn(name = "nota_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nota notaId;

    public Devedores() {
    }

    public Devedores(Integer id) {
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

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Nota getNotaId() {
        return notaId;
    }

    public void setNotaId(Nota notaId) {
        this.notaId = notaId;
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
        if (!(object instanceof Devedores)) {
            return false;
        }
        Devedores other = (Devedores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.tommasi.entidade.Devedores[ id=" + id + " ]";
    }
    
}
