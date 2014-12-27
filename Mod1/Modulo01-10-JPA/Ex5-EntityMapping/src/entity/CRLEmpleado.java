package entity;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "CRLEmpleado.findAll", query = "select o from CRLEmpleado o") })
public class CRLEmpleado implements Serializable {
    private static final long serialVersionUID = -5835461408228475242L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Set<CRLNumeroTelefono> setTelefonos;
    @Transient
    private String sexo;
    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="id_seguro")
    private CRLSeguroSanitario seguroSanitario;
    @ManyToMany
    @JoinTable(
    name="CRLEMP_PROY",
        joinColumns={
            @JoinColumn(name="EMP_ID", referencedColumnName="EMP_ID")},
            inverseJoinColumns={
                @JoinColumn(name="PROY_ID", referencedColumnName="PROY_ID")})
    private Set<CRLProyecto> setProyectos;
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSeguroSanitario(CRLSeguroSanitario seguroSanitario) {
        this.seguroSanitario = seguroSanitario;
    }

    public CRLSeguroSanitario getSeguroSanitario() {
        return seguroSanitario;
    }

    public void setSetProyectos(Set<CRLProyecto> setProyectos) {
        this.setProyectos = setProyectos;
    }

    public Set<CRLProyecto> getSetProyectos() {
        return setProyectos;
    }
    
    public void addTelef(CRLNumeroTelefono telef) {
            this.setTelefonos.add(telef);
            if (telef.getEmpleado() != this) {
                telef.setEmpleado(this);
            }
    }
    
    public void setSetTelefonos(Set<CRLNumeroTelefono> setTelefono) {
        this.setTelefonos = setTelefono;
    }

    public Set<CRLNumeroTelefono> getSetTelefonos() {
            return setTelefonos;
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
        this.setTelefonos = new HashSet();
        this.setProyectos = new HashSet(); 
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
