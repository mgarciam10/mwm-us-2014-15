package test;

import entity.CRLEmpleado;
import entity.CRLNumeroTelefono;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

public class Startup {
    

    public static void main(String[] args) throws ParseException {
        Startup startup = new Startup();
        startup.createData();
        List<CRLEmpleado> empleados = startup.findAll();
        for (CRLEmpleado e : empleados) {
            System.out.println(e);
            System.out.println(e.getId() +"--"+ e.getNombre()+"--"+e.getApellido()+"--"+e.getFechaalta()+"--"+e.getSalario());
            HashSet <CRLNumeroTelefono> telfSet = (HashSet<CRLNumeroTelefono>) e.getCRLNumeroTelefono();
            if (!telfSet.isEmpty()){
                Iterator iterator = telfSet.iterator(); 
                while (iterator.hasNext()){
                    CRLNumeroTelefono telf = (CRLNumeroTelefono) iterator.next();
                    System.out.println(telf.getEmpleado().getId() + "---" +  telf.getPrefijoInternacional() + " " + telf.getNumeroLocal());  
                }
            }
        }
        startup.cerrarConexiones();
    }
    
    @PersistenceUnit
    EntityManagerFactory emf;
    EntityManager em;
    public Startup() {
        super();
        emf = Persistence.createEntityManagerFactory("Empleado");
        em = emf.createEntityManager();
    }

    private List<CRLEmpleado> findAll() {
        Query q = em.createNamedQuery("CRLEmpleado.findAll");
        return q.getResultList();
    }

    private void createData() throws ParseException {
        CRLEmpleado e1, e2;
        CRLNumeroTelefono n1a, n1b, n2;
        Date date1, date2;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        em.getTransaction().begin();
        e1 = new CRLEmpleado();
        e1.setApellido("Rodriguez");
        e1.setNombre("Carlos");
        date1 = formatter.parse("2014-10-05");
        e1.setFechaalta(date1);
        e1.setSalario((long)150000000);
        em.persist(e1);
        n1a = new CRLNumeroTelefono();
        n1a.setPrefijoInternacional("+34");
        n1a.setNumeroLocal("636899504");
        n1a.setEmpleado(e1);
        em.persist(n1a);
        n1b = new CRLNumeroTelefono();
        n1b.setPrefijoInternacional("+35");
        n1b.setNumeroLocal("6360000000");
        n1b.setEmpleado(e1);
        em.persist(n1b);
        e2 = new CRLEmpleado();
        e2.setApellido("Ureña");
        e2.setNombre("Macarena");
        date2 = formatter.parse("2014-11-05");
        e2.setFechaalta(date2);
        e2.setSalario((long)250000000);
        em.persist(e2);
        n2 = new CRLNumeroTelefono();
        n2.setPrefijoInternacional("+38");
        n2.setNumeroLocal("636884554");
        n2.setEmpleado(e2);
        em.persist(n2);
        em.getTransaction().commit();
    }

    private void cerrarConexiones() {
        em.close();
        emf.close();
    }
}
