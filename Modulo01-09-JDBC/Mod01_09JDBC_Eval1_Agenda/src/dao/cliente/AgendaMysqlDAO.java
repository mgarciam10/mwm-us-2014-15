package dao.cliente;


import dao.transferobjects.Contacto;

import java.sql.*;

public class AgendaMysqlDAO implements AgendaDAO {
    private Connection con;
    private ResultSet res;
    private Statement sen;

    @Override
    public void borrarContacto() {
        // TODO Implement this method
    }

    @Override
    public ResultSet consultar(Contacto contacto) {
        // TODO Implement this method
        return null;
    }

    @Override
    public void insertarContacto(Contacto contacto) {
        // TODO Implement this method
    }

    @Override
    public void modificarContacto(Contacto contacto) {
        // TODO Implement this method
    }
}
