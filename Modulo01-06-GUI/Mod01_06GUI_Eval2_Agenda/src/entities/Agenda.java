package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos = new ArrayList<Contacto>();

    public List<Contacto> getContactos() {
        return contactos;
    }

    public Agenda (){};
    
    public Contacto consultarDatosContactos (String nombre){
        Contacto contEncontrado=null;
        Contacto contact2Find = new Contacto();
        Iterator <Contacto> iterAgenda = contactos.iterator();
        contact2Find.setNombre(nombre);
        while (iterAgenda.hasNext() && contEncontrado==null){
            Contacto contactIter = iterAgenda.next();
            if (contactIter.equals(contact2Find)){
                contEncontrado=contactIter;
            }
        }
        return contEncontrado;
    };
    
    public  String insertar (Contacto newContact){
        contactos.add(newContact);
        return newContact.getNombre();
    };
}
