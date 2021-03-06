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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@NamedQueries({
    @NamedQuery(name="CRLEmpleado.findAll",
                query="SELECT o FROM CRLEmpleado o"),
    @NamedQuery(name="CRLEmpleado.findAllOrderBySalary",
                query="SELECT o FROM CRLEmpleado o ORDER BY o.salario"),
    @NamedQuery(name="CRLEmpleado.findEmplByName",
                query="SELECT o FROM CRLEmpleado o WHERE o.nombre LIKE :nombre")
})
//@NamedQuery(name="CRLEmpleado.UpdateSalario", query="UPDATE CRLEmpleado e SET e.salary = (e.salary*1.:porc)"
public class CRLEmpleado implements Serializable {
    private static final long serialVersionUID = -5835461408228475242L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EMP_ID")
    private Integer id;
    @Version
    private Integer version;
    @Column(name="apellido", nullable = false, length = 50)
    private String apellido;
    @Column(name="nombre", nullable = false, length = 50)
    private String nombre;
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
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
    name="CRLEMP_PROY",
        joinColumns={
            @JoinColumn(name="EMP_ID", referencedColumnName="EMP_ID")},
            inverseJoinColumns={
                @JoinColumn(name="PROY_ID", referencedColumnName="PROY_ID")})
    private Set<CRLProyecto> setProyectos;
    @ManyToOne (fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="departamento_id")
    private CRLDepartamento departamento;

    public void setDepartamento(CRLDepartamento departamento) {
        this.departamento = departamento;
    }

    public CRLDepartamento getDepartamento() {
        return departamento;
    }

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
    
    public void addProyecto(CRLProyecto proy) {
            this.getSetProyectos().add(proy);
            if (!proy.getSetEmpleados().contains(this)) {
                 proy.getSetEmpleados().add(this);
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
