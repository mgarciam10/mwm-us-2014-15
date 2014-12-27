package entity;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "CRLProyecto.findAll", query = "select o from CRLProyecto o") })
public class CRLProyecto implements Serializable {
    private static final long serialVersionUID = -3881528019492249860L;
    @Id
    private Integer id;
    @Version
    private Integer version;
    @Column(name="nombre", length = 150)
    private String nombre;
    @ManyToMany(mappedBy = "setProyectos")
    private Set<CRLEmpleado> setEmpleados;
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSetEmpleados(Set<CRLEmpleado> setEmpleados) {
        this.setEmpleados = setEmpleados;
    }

    public Set<CRLEmpleado> getSetEmpleados() {
        return setEmpleados;
    }

    public String getNombre() {
        return nombre;
    }

    public CRLProyecto() {
        this.setEmpleados = new HashSet();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
