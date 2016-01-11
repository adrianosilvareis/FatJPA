/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.entidade;

import br.entidade.sft.SftOutputGlos;
import br.entidade.sft.SftOutputInco;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adriano
 */
@Entity
@Table(name = "fat_convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convenio.findAll", query = "SELECT c FROM Convenio c"),
    @NamedQuery(name = "Convenio.findById", query = "SELECT c FROM Convenio c WHERE c.id = :id"),
    @NamedQuery(name = "Convenio.findByDescricao", query = "SELECT c FROM Convenio c WHERE c.descricao like :descricao"),
    @NamedQuery(name = "Convenio.findByCodigo", query = "SELECT c FROM Convenio c WHERE c.codigo like :codigo")})
public class Convenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "codigo")
    private Integer codigo;
    @JoinColumn(name = "mascara_convenio_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MascaraConvenio mascaraConvenioId;
    @OneToMany(mappedBy = "fkConv")
    private List<SftOutputInco> sftOutputIncoList;
    @OneToMany(mappedBy = "fkConv")
    private List<SftOutputGlos> sftOutputGlosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "convenioId")
    private List<Producao> producaoList;

    public Convenio() {
    }

    public Convenio(Integer id) {
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

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<SftOutputInco> getSftOutputIncoList() {
        return sftOutputIncoList;
    }

    public void setSftOutputIncoList(List<SftOutputInco> sftOutputIncoList) {
        this.sftOutputIncoList = sftOutputIncoList;
    }

    public List<SftOutputGlos> getSftOutputGlosList() {
        return sftOutputGlosList;
    }

    public void setSftOutputGlosList(List<SftOutputGlos> sftOutputGlosList) {
        this.sftOutputGlosList = sftOutputGlosList;
    }
    
    public MascaraConvenio getMascaraConvenioId() {
        return mascaraConvenioId;
    }

    public void setMascaraConvenioId(MascaraConvenio mascaraConvenioId) {
        this.mascaraConvenioId = mascaraConvenioId;
    }
    
    @XmlTransient
    public List<Producao> getProducaoList() {
        return producaoList;
    }

    public void setProducaoList(List<Producao> producaoList) {
        this.producaoList = producaoList;
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
        if (!(object instanceof Convenio)) {
            return false;
        }
        Convenio other = (Convenio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.tommasi.entidade.Convenio[ id=" + id + " ]";
    }
    
}
