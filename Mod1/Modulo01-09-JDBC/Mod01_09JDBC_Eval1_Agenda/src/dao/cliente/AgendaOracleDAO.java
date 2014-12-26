package dao.cliente;


import dao.factoria.FactoriaOracleDAO;


import dao.transferobjects.Contacto;
import java.sql.*;

public class AgendaOracleDAO implements AgendaDAO {
    private Connection con=null;
    private ResultSet res;
    private Statement sen;
    private final String TABLE = "AGENDA_CRL";
    
    public AgendaOracleDAO () throws SQLException {
        this.con = FactoriaOracleDAO.creaConnection();
        // crea el objeto para enviar las sentencias SQL
        this.sen= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    
    @Override
    public void borrarContacto() {
        // TODO Implement this method
    }

    @Override
    public ResultSet consultar(Contacto contacto) throws SQLException {
        // TODO Implement this method
        String query = "SELECT NOMBRE, TELEFONO, DIRECCION, CODPOSTAL, PROVINCIA FROM " + TABLE + " WHERE 1=1";
        if (!contacto.getNombre().equals(""))
            query += " and nombre like '%" + contacto.getNombre() + "%'";
        if (!contacto.getTelefono().equals(""))
            query += " and telefono like '%" + contacto.getTelefono() + "%'";
        if (!contacto.getDireccion().equals(""))
            query += " and direccion like '%" + contacto.getDireccion() +"%'";
        if (contacto.getCodigoPostal() != -1)
            query += " and codPostal =" + contacto.getCodigoPostal();
        if (!contacto.getProvincia().equals(""))
            query += " and provincia like '%" + contacto.getProvincia() + "%'";
        return sen.executeQuery(query);
    }

    @Override
    public void insertarContacto(Contacto contacto) throws SQLException {
        if (res == null)
            res = sen.executeQuery("SELECT NOMBRE, TELEFONO,DIRECCION, CODPOSTAL, PROVINCIA FROM " + TABLE);
        res.moveToInsertRow();
        res.updateString(1, contacto.getNombre());
        res.updateString(2, contacto.getTelefono());
        res.updateString(3, contacto.getDireccion());
        res.updateInt(4, contacto.getCodigoPostal());
        res.updateString(5, contacto.getProvincia());
        res.insertRow();
    }

    @Override
    public void modificarContacto(Contacto contacto) {
        // TODO Implement this method
    }
}
