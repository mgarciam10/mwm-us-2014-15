package dao.cliente;

import dao.transferobjects.Contacto;

import java.sql.*;

public interface AgendaDAO {
    public void borrarContacto() throws SQLException;
    public ResultSet consultar (Contacto contacto) throws SQLException;
    public void insertarContacto(Contacto contacto) throws SQLException;
    public void modificarContacto(Contacto contacto) throws SQLException;
}
