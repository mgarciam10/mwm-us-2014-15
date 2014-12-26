package ej3dao;

import java.sql.*;

public interface AgendaDAO {
    public void borrarContacto();
    public ResultSet consultar(Contacto contacto);
    public void insertarContacto(Contacto contacto);
    public void modificarContacto(Contacto contacto);
}
