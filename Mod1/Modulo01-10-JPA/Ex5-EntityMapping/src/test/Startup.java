package test;

import entity.CRLEmpleado;
import entity.CRLNumeroTelefono;
import entity.CRLProyecto;
import entity.CRLSeguroSanitario;

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
            System.out.println("******************************************************************************************");
            System.out.println("Id: "+e.getId() +"-- Nombre: "+ e.getNombre()+"-- Apellido: "+e.getApellido()+"-- Fecha Alta: "+e.getFechaalta()+" -- Salario: "+e.getSalario() +" -- Seguro: "+e.getSeguroSanitario().getAseguradora());
            System.out.println("******************************************************************************************");
            HashSet <CRLNumeroTelefono> telfSet = (HashSet<CRLNumeroTelefono>) e.getSetTelefonos();
            HashSet <CRLProyecto> proySet = (HashSet<CRLProyecto>) e.getSetProyectos();
            if (!telfSet.isEmpty()){
                Iterator iterator = telfSet.iterator(); 
                while (iterator.hasNext()){
                    CRLNumeroTelefono telf = (CRLNumeroTelefono) iterator.next();
                    System.out.println("Id Emp: "+telf.getEmpleado().getId() + "-- Pref: " +  telf.getPrefijoInternacional() + "-- Telf: " + telf.getNumeroLocal());  
                }
            }
            if (!proySet.isEmpty()){
                Iterator iterator = proySet.iterator(); 
                while (iterator.hasNext()){
                    CRLProyecto proy = (CRLProyecto) iterator.next();
                    System.out.println("Id proy: " + proy.getId() + "-- Nombre Proy: " + proy.getNombre());  
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
        CRLSeguroSanitario s1, s2;
        CRLProyecto p1, p2, p3;
        Date date1, date2;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        em.getTransaction().begin();
        /***********************PROYECTOS*****************************/
        p1 = new CRLProyecto();
        p1.setNombre("Portal Web Junta de Andalucia");
        em.persist(p1);
        p2 = new CRLProyecto();
        p2.setNombre("SCADA - Cuenca Guadalquivir");
        em.persist(p1);
        p3 = new CRLProyecto();
        p3.setNombre("Sistemas Planta Solucar");
        em.persist(p1);
        /***********************SEGUROS*****************************/
        s1 =  new CRLSeguroSanitario();
        s1.setAseguradora("CatalanaOccidente");
        em.persist(s1);
        s2 =  new CRLSeguroSanitario();
        s2.setAseguradora("Mapfre");
        em.persist(s2);
        /***********************TELEFONOS*****************************/
        n1a = new CRLNumeroTelefono();
        n1a.setPrefijoInternacional("+34");
        n1a.setNumeroLocal("636899504");
        em.persist(n1a);
        n1b = new CRLNumeroTelefono();
        n1b.setPrefijoInternacional("+35");
        n1b.setNumeroLocal("6360000000");
        em.persist(n1b);
        n2 = new CRLNumeroTelefono();
        n2.setPrefijoInternacional("+38");
        n2.setNumeroLocal("636884554");
        em.persist(n2);
        /***********************EMPLEADO *****************************/
        /**Datos Empleados 1**/
        e1 = new CRLEmpleado();
        e1.setApellido("Rodriguez");
        e1.setNombre("Carlos");
        date1 = formatter.parse("2014-10-05");
        e1.setFechaalta(date1);
        e1.setSalario((long)150000000);
        /**Relaciones Empleados 1**/
        e1.setSeguroSanitario(s1);
        e1.addTelef(n1a);
        e1.addTelef(n1b);
        e1.addProyecto(p2);
        em.persist(e1);
        /**Datos Empleados 2**/
        e2 = new CRLEmpleado();
        e2.setApellido("Ureña");
        e2.setNombre("Macarena");
        date2 = formatter.parse("2014-11-05");
        e2.setFechaalta(date2);
        e2.setSalario((long)250000000);
        /**Relaciones Empleados 2**/
        e2.setSeguroSanitario(s2);
        e2.addTelef(n2);
        e2.addProyecto(p1);
        e2.addProyecto(p2);
        e2.addProyecto(p3);
        em.persist(e2);
        em.getTransaction().commit();
    }

    private void cerrarConexiones() {
        em.close();
        emf.close();
    }
}
