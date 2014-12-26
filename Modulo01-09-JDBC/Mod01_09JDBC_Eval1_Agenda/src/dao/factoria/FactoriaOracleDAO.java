package dao.factoria;

import dao.cliente.AgendaDAO;

import dao.cliente.AgendaOracleDAO;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class FactoriaOracleDAO extends FactoriaDAO {
    
    public static Connection creaConnection() throws SQLException {
        Connection con=null;
        final String DATABASE_NAME = "orc1";
        final String DATABASE_DRIVER = "thin";
        final String DATABASE_URL = "150.214.142.20";
        final int DATABASE_PORT = 1521;
        final String DATABASE_USER = "scott";
        final String DATABASE_PASS = "kepa";
        final String TABLE = "AGENDA_CRL";
        
        // crear una fuente de datos Oracle
        OracleDataSource fdo = new OracleDataSource();

        // inicializar las propiedades de la fuente de datos
        fdo.setDatabaseName(DATABASE_NAME);
        fdo.setDriverType(DATABASE_DRIVER);
        fdo.setServerName(DATABASE_URL);
        fdo.setPortNumber(DATABASE_PORT);

        con = fdo.getConnection(DATABASE_USER, DATABASE_PASS);
        return con;
    };
        
    @Override
    public AgendaDAO getAgendaDAO() throws SQLException {
        // TODO Implement this method
        return new AgendaOracleDAO();
    }
}
