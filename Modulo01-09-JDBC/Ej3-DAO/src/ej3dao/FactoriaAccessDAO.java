package ej3dao;

import java.sql.Connection;

public class FactoriaAccessDAO extends FactoriaDAO {
    
    public static Connection creaConnection(){
            Connection con=null;
            return con;
    };
    @Override
    public AgendaDAO getAgendaDAO() {
        // TODO Implement this method
        return null;
    }
}
