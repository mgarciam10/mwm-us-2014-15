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

    private final String DATABASE_NAME = "orc1";
    private final String DATABASE_DRIVER = "thin";
    private final String DATABASE_URL = "150.214.142.20";
    private final int DATABASE_PORT = 1521;
    private final String DATABASE_USER = "scott";
    private final String DATABASE_PASS = "kepa";
    private final String TABLE = "AGENDA_CRL";

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

        con = fdo.getConnection(DATABASE_USER, DATABASE_PASS);
        // crea el objeto para enviar las sentencias SQL
        consultaSQL = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    /** Insertar un contacto en la agenda utilizando el ResultSet
     * @param agenda son los datos del contacto a insertar
     * @throws SQLException excepción SQL que se puede producir si hay algún problema en la conexión a la base de datos
     */
    public void insertar(Contacto agenda, ResultSet res) throws SQLException {
        if (res == null)
            res = consultaSQL.executeQuery("SELECT NOMBRE, TELEFONO,DIRECCION, CODPOSTAL, PROVINCIA FROM " + TABLE);
        res.moveToInsertRow();
        res.updateString(1, agenda.getNombre());
        res.updateString(2, agenda.getTelefono());
        res.updateString(3, agenda.getDireccion());
        res.updateInt(4, agenda.getCodigoPostal());
        res.updateString(5, agenda.getProvincia());
        res.insertRow();
    }

    /** Consultar los datos de los contactos que hay en la base de datos que tengan coincidencia con los datos que
     *  se indican en la cualquiera de los campos del formulario.
     * @param agenda patrón a buscar
     * @throws SQLException excepción SQL que se puede producir si hay algún problema en la conexión a la base de datos
     */
    public ResultSet consultar(Contacto agenda) throws SQLException {
        String query = "SELECT NOMBRE, TELEFONO, DIRECCION, CODPOSTAL, PROVINCIA FROM " + TABLE + " WHERE 1=1";
        if (!agenda.getNombre().equals(""))
            query += " and nombre like '%" + agenda.getNombre() + "%'";
        if (!agenda.getTelefono().equals(""))
            query += " and telefono like '%" + agenda.getTelefono() + "%'";
        if (!agenda.getDireccion().equals(""))
            query += " and direccion like '%" + agenda.getDireccion() +"%'";
        if (agenda.getCodigoPostal() != -1)
            query += " and codPostal =" + agenda.getCodigoPostal();
        if (!agenda.getProvincia().equals(""))
            query += " and provincia like '%" + agenda.getProvincia() + "%'";
        return consultaSQL.executeQuery(query);
    }
}
