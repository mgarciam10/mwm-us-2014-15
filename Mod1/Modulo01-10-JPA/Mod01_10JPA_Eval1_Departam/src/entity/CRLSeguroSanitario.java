package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "CRLSeguroSanitario.findAll", query = "select o from CRLSeguroSanitario o") })
public class CRLSeguroSanitario implements Serializable {
    private static final long serialVersionUID = 6836998845468876156L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private Integer version;
    @Column(name="nombre", length = 150)
    private String nombre;
    @OneToOne(fetch=FetchType.LAZY, mappedBy="seguroSanitario")
    private CRLEmpleado empleado;

    public void setEmpleado(CRLEmpleado empleado) {
        this.empleado = empleado;
    }

    public CRLEmpleado getEmpleado() {
        return empleado;
    }

    public void setAseguradora(String aseguradora) {
        this.nombre = aseguradora;
    }

    public String getAseguradora() {
        return nombre;
    }

    public CRLSeguroSanitario() {
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
