package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "CRLNumeroTelefono.findAll", query = "select o from CRLNumeroTelefono o") })
public class CRLNumeroTelefono implements Serializable {
    private static final long serialVersionUID = 7058414624314237005L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="id_telefono_seq_generator")
    @SequenceGenerator(name="d_telefono_seq_generator", sequenceName="ID_TELEFONO_SEQ")
    private Integer id;
    @Version
    private Integer version;
    @Column(name="prefijoInternacional", nullable = true)
    private String prefijoInternacional;
    @Column(name="numeroLocal", nullable = true)
    private String numeroLocal;
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="empleado_id")
    private CRLEmpleado empleado;

    public void setEmpleado(CRLEmpleado empleado) {
        this.empleado = empleado;
        if (!empleado.getCRLNumeroTelefono().contains(this)) {
            empleado.getCRLNumeroTelefono().add(this);
        }
    }

    public CRLEmpleado getEmpleado() {
        return empleado;
    }

    public void setPrefijoInternacional(String prefijoInternacional) {
        this.prefijoInternacional = prefijoInternacional;
    }

    public String getPrefijoInternacional() {
        return prefijoInternacional;
    }

    public void setNumeroLocal(String numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public String getNumeroLocal() {
        return numeroLocal;
    }
    
    public CRLNumeroTelefono() {
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
