package dao.factoria;

import dao.cliente.AgendaDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class FactoriaMysqlDAO extends FactoriaDAO {
    
    public static Connection creaConnection() throws SQLException{
            Connection con=null;
            return con;
    };
    @Override
    public AgendaDAO getAgendaDAO() {
        // TODO Implement this method
        return null;
    }
}
