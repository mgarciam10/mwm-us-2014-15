package test;

import entity.CRLDepartamento;
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
    
    @PersistenceUnit
    EntityManagerFactory emf;
    EntityManager em;
    
    public static void main(String[] args) throws ParseException {
        List<CRLEmpleado> query1, query2;
        List<CRLDepartamento> query4;
        Startup startup = new Startup();
        
        System.out.println("Creando Tablas y Cargado Datos...");
        startup.createData();
        System.out.println(">> Query 1: findAllOrderBySalary \n \n");
        query1 = startup.findAllOrderBySalary();
        startup.printEmpleados(query1);
        System.out.println(">> Query 2:findEmplByName: Carlos \n \n");
        query2 = startup.findEmplByName("Carlos") ;
        startup.printEmpleados(query2);
        System.out.println(">> Query 3: Native Query \n \n");
        query4 = startup.nativeQuery();
        startup.printDepartamentos(query4);
        
        startup.cerrarConexiones();
    }
    
    public Startup() {
        super();
        emf = Persistence.createEntityManagerFactory("Empleado");
        em = emf.createEntityManager();
    }

    private void createData() throws ParseException {
        CRLEmpleado e1, e2, e3;
        CRLNumeroTelefono n1a, n1b, n2;
        CRLSeguroSanitario s1, s2;
        CRLProyecto p1, p2, p3;
        CRLDepartamento d1, d2;
        Date date1, date2, date3;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        em.getTransaction().begin();
        
        /***********************DEPARTAMENTOS*************************/
        d1 = new CRLDepartamento();
        d1.setNombre("Matematicas");
        d2 = new CRLDepartamento();
        d2.setNombre("Literatura");
        /***********************PROYECTOS*****************************/
        p1 = new CRLProyecto();
        p1.setNombre("Portal Web Junta de Andalucia");
        p2 = new CRLProyecto();
        p2.setNombre("SCADA - Cuenca Guadalquivir");
        p3 = new CRLProyecto();
        p3.setNombre("Sistemas Planta Solucar");
        /***********************SEGUROS*****************************/
        s1 =  new CRLSeguroSanitario();
        s1.setAseguradora("CatalanaOccidente");
        s2 =  new CRLSeguroSanitario();
        s2.setAseguradora("Mapfre");
        /***********************TELEFONOS*****************************/
        n1a = new CRLNumeroTelefono();
        n1a.setPrefijoInternacional("+34");
        n1a.setNumeroLocal("636899504");
        n1b = new CRLNumeroTelefono();
        n1b.setPrefijoInternacional("+35");
        n1b.setNumeroLocal("6360000000");
        n2 = new CRLNumeroTelefono();
        n2.setPrefijoInternacional("+38");
        n2.setNumeroLocal("636884554");
        /***********************EMPLEADO *****************************/
        /**Datos Empleados 1**/
        e1 = new CRLEmpleado();
        e1.setApellido("Rodriguez");
        e1.setNombre("Carlos");
        date1 = formatter.parse("2014-10-05");
        e1.setFechaalta(date1);
        e1.setSalario((long)15000);
        /**Relaciones Empleados 1**/
        e1.setSeguroSanitario(s1);
        e1.addTelef(n1a);
        e1.addTelef(n1b);
        e1.addProyecto(p2);
        /**Datos Empleados 2**/
        e2 = new CRLEmpleado();
        e2.setApellido("Ureña");
        e2.setNombre("Macarena");
        date2 = formatter.parse("2014-11-05");
        e2.setFechaalta(date2);
        e2.setSalario((long)25000000);
        /**Relaciones Empleados 2**/
        e2.setSeguroSanitario(s2);
        e2.addTelef(n2);
        e2.addProyecto(p1);
        e2.addProyecto(p2);
        e2.addProyecto(p3);
        /**Datos Empleados 3**/
        e3 = new CRLEmpleado();
        e3.setApellido("Gutierrez");
        e3.setNombre("Paco");
        date3 = formatter.parse("2010-09-05");
        e3.setFechaalta(date3);
        e3.setSalario((long)25000);
        e3.setSeguroSanitario(s1);
        /***********************Relac. DEPARTAMENTOS*************************/
        
        
        p1.addDepartamento(d1);
        p2.addDepartamento(d1);
        p3.addDepartamento(d2);
        d1.addEmpleado(e1);
        d1.addEmpleado(e3);
        d2.addEmpleado(e2);
        d1.addProyecto(p1);
        d1.addProyecto(p2);
        d2.addProyecto(p1);
        d2.addProyecto(p2);
        d2.addProyecto(p3);
        
        
       
        
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(s1);
        em.persist(s2);
        em.persist(n1a);
        em.persist(n1b);
        em.persist(n2);
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(d1);
        em.persist(d2);
        em.getTransaction().commit();

    }

    private List<CRLEmpleado> findAll() {
        Query q = em.createNamedQuery("CRLEmpleado.findAll");
        return q.getResultList();
    }
    
    private List<CRLEmpleado> findAllOrderBySalary() {
        Query q = em.createNamedQuery("CRLEmpleado.findAllOrderBySalary");
        return q.getResultList();
    }
    
    private List<CRLEmpleado> findEmplByName(String name) {
        Query q = em.createNamedQuery("CRLEmpleado.findEmplByName");
        q.setParameter("nombre", name);
        return q.getResultList();
    }
    
    private List<CRLDepartamento> nativeQuery() {
        List<CRLDepartamento> result;
        result = (List<CRLDepartamento>)em.createNativeQuery("SELECT * FROM CRLDepartamento ORDER BY DEP_ID ASC", entity.CRLDepartamento.class).getResultList();
        return result;
    }
    
    private void printEmpleados(List<CRLEmpleado> empleados) {
        for (CRLEmpleado e : empleados) {
            System.out.println("EMPLEADO*********************************************************************************");
            System.out.println("Id: " + e.getId() + " \n-- Nombre: " + e.getNombre() + "\n-- Apellido: " + e.getApellido() +
                               "\n-- Fecha Alta: " + e.getFechaalta() + "\n-- Salario: " + e.getSalario() +
                               "\n-- Seguro: " + e.getSeguroSanitario().getAseguradora()+ "\n-- Departamento: "+e.getDepartamento().getNombre());
            System.out.println("******************************************************************************************");
            HashSet<CRLNumeroTelefono> telfSet = (HashSet<CRLNumeroTelefono>) e.getSetTelefonos();
            HashSet<CRLProyecto> proySet = (HashSet<CRLProyecto>) e.getSetProyectos();
            if (!telfSet.isEmpty()) {
                Iterator iterator = telfSet.iterator();
                while (iterator.hasNext()) {
                    CRLNumeroTelefono telf = (CRLNumeroTelefono) iterator.next();
                    System.out.println("Id Emp: " + telf.getEmpleado().getId() + "-- Pref: " +
                                       telf.getPrefijoInternacional() + "-- Telf: " + telf.getNumeroLocal());
                }
            }
            if (!proySet.isEmpty()) {
                Iterator iterator = proySet.iterator();
                while (iterator.hasNext()) {
                    CRLProyecto proy = (CRLProyecto) iterator.next();
                    System.out.println("Id proy: " + proy.getId() + "-- Nombre Proy: " + proy.getNombre());
                }
            }
        }
    }
    
    private void printDepartamentos(List<CRLDepartamento> departamentos) {
        for (CRLDepartamento d : departamentos) {
            System.out.println("DEPARTAMENTO******************************************************************************");
            System.out.println("Id: " + d.getId() + "\n -- Nombre: " + d.getNombre());
            System.out.println("******************************************************************************************");
            HashSet<CRLEmpleado> empSet = (HashSet<CRLEmpleado>) d.getSetEmpleados();
            HashSet<CRLProyecto> proySet = (HashSet<CRLProyecto>) d.getSetProyectos();
            if (!empSet.isEmpty()) {
                Iterator iterator = empSet.iterator();
                while (iterator.hasNext()) {
                    CRLEmpleado emp = (CRLEmpleado) iterator.next();
                    System.out.println("Id Emp: " + emp.getId() + "-- Nombre: " + emp.getNombre() + "-- Apellido: " + emp.getApellido());
                }
            }
            if (!proySet.isEmpty()) {
                Iterator iterator = proySet.iterator();
                while (iterator.hasNext()) {
                    CRLProyecto proy = (CRLProyecto) iterator.next();
                    System.out.println("Id proy: " + proy.getId() + "-- Nombre Proy: " + proy.getNombre());
                }
            }
            
        }
    }
    
    private void cerrarConexiones() {
        em.close();
        emf.close();
    }
}
