package entity;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PROY_ID")
    private Integer id;
    @Version
    private Integer version;
    @Column(name="nombre", length = 150)
    private String nombre;
    @ManyToMany(mappedBy = "setProyectos")
    private Set<CRLEmpleado> setEmpleados;
    @ManyToMany(mappedBy = "setProyectos")
    private Set<CRLDepartamento> setDepartamentos;


    public void setSetDepartamentos(Set<CRLDepartamento> setDepartamentos) {
        this.setDepartamentos = setDepartamentos;
    }

    public Set<CRLDepartamento> getSetDepartamentos() {
        return setDepartamentos;
    }

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
        this.setDepartamentos = new HashSet();
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
    
    public void addEmpleado(CRLEmpleado emple) {
            this.getSetEmpleados().add(emple);
            if (!emple.getSetProyectos().contains(this)) {
                 emple.getSetProyectos().add(this);
            }
    }
    public void addDepartamento(CRLDepartamento depart) {
            this.setDepartamentos.add(depart);
            if (!depart.getSetProyectos().contains(this)) {
                 depart.getSetProyectos().add(this);
            }
    }
}
