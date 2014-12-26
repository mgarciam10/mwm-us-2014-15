package main;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "CRLEmpleado.findAll", query = "select o from CRLEmpleado o") })
public class CRLEmpleado implements Serializable {
    private static final long serialVersionUID = 8309206441728834561L;
    @Id
    private Integer id;
    @Version
    private Integer version;

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
