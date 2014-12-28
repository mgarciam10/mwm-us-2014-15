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
    
    @PersistenceUnit
    EntityManagerFactory emf;
    EntityManager em;
    
    public static void main(String[] args) throws ParseException {
        List<CRLEmpleado> query1, query2, query3result;
        List<CRLProyecto> query4;
        int query3num;
        Startup startup = new Startup();
        
        System.out.println("Creando Tablas y Cargado Datos...");
        startup.createData();
        System.out.println(">> Query 1: findAllOrderBySalary \n \n");
        query1 = startup.findAllOrderBySalary();
        startup.printEmpleados(query1);
        System.out.println(">> Query 2:findEmplByName: Carlos \n \n");
        query2 = startup.findEmplByName("Carlos") ;
        startup.printEmpleados(query2);
        System.out.println(">> Query 3:Update Salary: 20% \n \n");
        query3num = startup.updateSalary(20);
        query3result = startup.findAll();
        startup.printEmpleados(query3result);
        System.out.println(">> Query 4: Native Query \n \n");
        query4 = startup.nativeQuery();
        startup.printProyectos(query4);
        
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
        Date date1, date2, date3;
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
        e1.setSalario((long)15000);
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
        e2.setSalario((long)25000000);
        /**Relaciones Empleados 2**/
        e2.setSeguroSanitario(s2);
        e2.addTelef(n2);
        e2.addProyecto(p1);
        e2.addProyecto(p2);
        e2.addProyecto(p3);
        em.persist(e2);
        /**Datos Empleados 3**/
        e3 = new CRLEmpleado();
        e3.setApellido("Gutierrez");
        e3.setNombre("Paco");
        date3 = formatter.parse("2010-09-05");
        e3.setFechaalta(date3);
        e3.setSalario((long)25000);
        e3.setSeguroSanitario(s1);
        em.persist(e3);
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
    
    private int updateSalary(int porc) {
        int rowsAffected;
        em.getTransaction().begin();
        Query q = em.createQuery("UPDATE CRLEmpleado e SET e.salario = (e.salario* 1."+Integer.toString(porc)+")");
        //Query q = em.createNamedQuery("CRLEmpleado.UpdateSalario");
        //q.setParameter(porc, porc);
        rowsAffected= q.executeUpdate();
        em.getTransaction().commit();
        return rowsAffected;
    }

    private List<CRLProyecto> nativeQuery() {
        List<CRLProyecto> result;
        result = (List<CRLProyecto>)em.createNativeQuery("SELECT * FROM CRLProyecto ORDER BY PROY_ID ASC", entity.CRLProyecto.class).getResultList();
        return result;
    }
    
    private void printEmpleados(List<CRLEmpleado> empleados) {
        for (CRLEmpleado e : empleados) {
            System.out.println("EMPLEADO*********************************************************************************");
            System.out.println("Id: " + e.getId() + " \n-- Nombre: " + e.getNombre() + "\n-- Apellido: " + e.getApellido() +
                               "\n-- Fecha Alta: " + e.getFechaalta() + "\n-- Salario: " + e.getSalario() +
                               "\n-- Seguro: " + e.getSeguroSanitario().getAseguradora());
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
    
    
    private void printProyectos(List<CRLProyecto> proyectos) {
        for (CRLProyecto p : proyectos) {
            System.out.println("PROYECTO**********************************************************************************");
            System.out.println("Id: " + p.getId() + "-- Nombre: " + p.getNombre());
            System.out.println("******************************************************************************************");
        }
    }
    
    private void cerrarConexiones() {
        em.close();
        emf.close();
    }
}
