package conecction;

import dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

public class ConexionDaoJDBC {

    private static final String SQL_SELECT = "SELECT * FROM clientes";

    private static final String SQL_SELECT_BY_ID = "SELECT * FROM clientes WHERE id_cliente =?";

    private static final String SQL_INSERT = "INSERT INTO clientes(nombre, apellido, email, saldo, telefono) "
            + "values(?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE clientes "
            + "SET nombre =?, apellido =?, email =?, saldo =?, telefono =? WHERE id_cliente =?";

    private static final String SQL_DELETE = "DELETE FROM clientes WHERE id_cliente =?";

    public List<Cliente> listar() {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; //RECUPERA INFORMACION

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idcliente = rs.getInt("id_clientes");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo");
                String telefono = rs.getString("telefono");

                Cliente c = new Cliente(idcliente, nombre, apellido, email, saldo, telefono);
                listaClientes.add(c);
            }

        } catch (SQLException ex) {
            System.out.println("aca ");
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.main(rs);
        }
        return listaClientes;
    }

    public Cliente buscarClientePorId(Cliente c) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente c1 = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, c.getIdCliente());
            rs = stmt.executeQuery();

            rs.absolute(1);

            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            double saldo = rs.getDouble("saldo");
            String telefono = rs.getString("telefono");
            
            c1.setNombre(nombre);
            c1.setApellido(apellido);
            c1.setEmail(email);
            c1.setSaldo(saldo);
            c1.setTelefono(telefono);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.main(rs);
        }

        return c1;
    }
    
    public int insertar(Cliente c) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, c.getIdCliente());
            
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            
        }

        return rows;
    }

     public int actualizar(Cliente c) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellido());
            stmt.setString(3, c.getEmail());
            stmt.setDouble(4, c.getSaldo());
            stmt.setString(5, c.getTelefono());
            stmt.setInt(6, c.getIdCliente());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);   
        }

        return rows;
    }
     
     public int eliminar(Cliente c) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellido());
            stmt.setString(3, c.getEmail());
            stmt.setDouble(4, c.getSaldo());
            stmt.setString(5, c.getTelefono());
            stmt.setInt(6, c.getIdCliente());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);   
        }

        return rows;
    }
 
    
}
