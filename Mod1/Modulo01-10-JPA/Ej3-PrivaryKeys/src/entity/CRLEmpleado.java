package entity;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "CRLEmpleado.findAll", query = "select o from CRLEmpleado o") })
public class CRLEmpleado implements Serializable {
    private static final long serialVersionUID = -5835461408228475242L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="id_empleado_seq_generator")
    @SequenceGenerator(name="id_empleado_seq_generator", sequenceName="ID_EMPLEADO_SEQ")
    private Integer id;
    @Version
    private Integer version;
    @Column(name="apellido", nullable = false, length = 50)
    private String apellido;
    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;
    /*@Transient*/
    @Column(name="fechaalta", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaalta;
    @Column(name="salario", nullable = true)
    private Long salario;
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private Set<CRLNumeroTelefono> setCRLNumeroTelefono = new HashSet();
    @Transient
    private String sexo;
    
    public void addTelef(CRLNumeroTelefono telef) {
            this.setCRLNumeroTelefono.add(telef);
            if (telef.getEmpleado() != this) {
                telef.setEmpleado(this);
            }
    }
    
    public void setCRLNumeroTelefono(Set<CRLNumeroTelefono> setCRLNumeroTelefono) {
        this.setCRLNumeroTelefono = setCRLNumeroTelefono;
    }

    public Set<CRLNumeroTelefono> getCRLNumeroTelefono() {
            return setCRLNumeroTelefono;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setSalario(Long salario) {
        this.salario = salario;
    }

    public Long getSalario() {
        return salario;
    }
   
    public CRLEmpleado() {
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
