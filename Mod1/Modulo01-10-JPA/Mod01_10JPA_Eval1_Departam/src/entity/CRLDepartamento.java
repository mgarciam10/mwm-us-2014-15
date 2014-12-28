package entity;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "CRLDepartamento.findAll", query = "select o from CRLDepartamento o") })
public class CRLDepartamento implements Serializable {
    private static final long serialVersionUID = -8003198786690446120L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="DEP_ID")
    private Integer id;
    @Version
    private Integer version;
    @Column(name="nombre",length = 50)
    private String nombre;
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private Set<CRLEmpleado> setEmpleados;
    @JoinTable(
    name="CRLDEP_PROY",
        joinColumns={
            @JoinColumn(name="DEP_ID", referencedColumnName="DEP_ID")},
            inverseJoinColumns={
                @JoinColumn(name="PROY_ID", referencedColumnName="PROY_ID")})
    private Set<CRLProyecto> setProyectos;

    public void addProyecto(CRLProyecto proy) {
            this.setProyectos.add(proy);
            if (!proy.getSetDepartamentos().contains(this)) {
                 proy.getSetDepartamentos().add(this);
            }
    }

    public void setSetProyectos(Set<CRLProyecto> setProyectos) {
        this.setProyectos = setProyectos;
    }

    public Set<CRLProyecto> getSetProyectos() {
        return setProyectos;
    }


    public CRLDepartamento() {
        setEmpleados = new HashSet();
        setProyectos= new HashSet();
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSetEmpleados(Set<CRLEmpleado> setEmpleados) {
        this.setEmpleados = setEmpleados;
    }

    public Set<CRLEmpleado> getSetEmpleados() {
        return setEmpleados;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public void addEmpleado(CRLEmpleado empleado) {
            this.setEmpleados.add(empleado);
            if (empleado.getDepartamento() != this) {
                empleado.setDepartamento(this);
            }
    }
}
