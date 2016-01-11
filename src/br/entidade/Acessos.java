/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "fat_acessos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acessos.findAll", query = "SELECT a FROM Acessos a"),
    @NamedQuery(name = "Acessos.findById", query = "SELECT a FROM Acessos a WHERE a.id = :id"),
    @NamedQuery(name = "Acessos.findByDescricao", query = "SELECT a FROM Acessos a WHERE a.descricao = :descricao"),
    @NamedQuery(name = "Acessos.findByCodigo", query = "SELECT a FROM Acessos a WHERE a.codigo = :codigo")})
public class Acessos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "codigo")
    private String codigo;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "acessosList")
    private List<GrupoUsuarios> grupoUsuariosList;

    public Acessos() {
    }

    public Acessos(String descricao, String codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }
    
    public Acessos(Integer id) {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public List<GrupoUsuarios> getGrupoUsuariosList() {
        return grupoUsuariosList;
    }

    public void setGrupoUsuariosList(List<GrupoUsuarios> grupoUsuariosList) {
        this.grupoUsuariosList = grupoUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acessos)) {
            return false;
        }
        Acessos other = (Acessos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.tommasi.entidade.Acessos[ id=" + id + " ]";
    }
    
}
