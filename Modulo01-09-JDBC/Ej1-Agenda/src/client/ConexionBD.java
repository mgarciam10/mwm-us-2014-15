package client;

import entities.Contacto;
import java.sql.*;
import oracle.jdbc.pool.*;

/** Clase Conexión. Sirve para establecer la conexión con la base de
datos y para insertar y consultar datos
 */
public class ConexionBD {

    private Connection con = null;
    private Statement consultaSQL = null;
    private PreparedStatement insertaSQL = null;
    
    private final String DATABASE_NAME="orc1";
    private final String DATABASE_DRIVER="thin";
    private final String DATABASE_URL="150.214.142.20";
    private final int DATABASE_PORT=1521;
    private final String DATABASE_USER="scott";
    private final String DATABASE_PASS="kepa";
    
    /**
     * Crea la conexión con la base de datos Oracle
     * @throws Exception excepción que se puede producir si hay algún problema en la conexión a la base de datos
     */
     public ConexionBD() throws Exception {

        // crear una fuente de datos Oracle
        OracleDataSource fdo = new OracleDataSource();

        // inicializar las propiedades de la fuente de datos
        fdo.setDatabaseName(DATABASE_NAME);
        fdo.setDriverType(DATABASE_DRIVER);
        fdo.setServerName(DATABASE_URL);
        fdo.setPortNumber(DATABASE_PORT);
        
        con = fdo.getConnection(DATABASE_USER,DATABASE_PASS);
        // crea los objetos para enviar las sentencias SQL
        consultaSQL = con.createStatement();
        insertaSQL = con.prepareStatement("INSERT INTO AGENDA_CRL VALUES(?,?,?,?,?)");
    }

    /** Insertar un contacto en la agenda
     * @param agenda son los datos del contacto a insertar
     * @throws SQLException excepción SQL que se puede producir si hay algún problema en la conexión a la base de datos
     */
    public void insertar(Contacto agenda) throws SQLException {
        insertaSQL.setString(1, agenda.getNombre());
        insertaSQL.setString(2, agenda.getTelefono());
        insertaSQL.setString(3, agenda.getDireccion());
        insertaSQL.setInt(4, agenda.getCodigoPostal());
        insertaSQL.setString(5, agenda.getProvincia());
        insertaSQL.executeUpdate();
    }

    /** Consultar los datos de los contactos que hay en la base de datos que tengan el nombre que se indique en la consulta
     * @param nombre patrón a buscar
     * @throws SQLException excepción SQL que se puede producir si hay algún problema en la conexión a la base de datos
     */
    public ResultSet consultarPorNombre(String nombre) throws SQLException {
        String query = "SELECT NOMBRE AS NOMBRE, CODPOSTAL AS CODPOSTAL, TELEFONO As TELEFONO, DIRECCION as DIRECCION, PROVINCIA as PROVINCIA FROM AGENDA_CRL";
        if (!nombre.equals(""))
            query += " WHERE nombre LIKE '%" + nombre + "%'";
        return consultaSQL.executeQuery(query);
    }
}
