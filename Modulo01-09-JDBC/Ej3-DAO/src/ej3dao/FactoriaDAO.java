package ej3dao;

public abstract class FactoriaDAO {
    // Lista de tipos DAO permitidos por la factoría
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    /* Habrá un método por cada DAO que pueda crearse. Las factorías
    concretas tendrán que implementar esos métodos.*/ 
    public abstract AgendaDAO getAgendaDAO();
    
    public static FactoriaDAO getFactoriaDAO(int factoria) {
        switch (factoria) {
            case ORACLE:
                return new FactoriaOracleDAO();
            case MYSQL:
                return new FactoriaAccessDAO();
            default:
                return null;
        }
    }
}
