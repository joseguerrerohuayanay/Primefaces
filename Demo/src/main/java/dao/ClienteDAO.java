package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ClienteModel;

public class ClienteDAO extends Conexion implements ICRUD<ClienteModel> {

    @Override
    public void Registrar(ClienteModel cliente) throws Exception {
        String sql = "INSERT INTO CLIENTE (nombre, apellido, dni)" + "VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDni());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar/DAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void Editar(ClienteModel cliente) throws Exception {
        String sql = "UPDATE CLIENTE SET nombre=?, apellido=?, dni=? WHERE id =?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDni());
            ps.setInt(4, cliente.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al edita/DAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void Eliminar(ClienteModel cliente) throws Exception {
        String sql = "DELETE FROM CLIENTE WHERE ID=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar/DAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void Estado(ClienteModel cliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteModel> Listar() throws Exception {
        List<ClienteModel> listado = new ArrayList<>();
        ClienteModel cliente;
        String sql = "SELECT * FROM CLIENTE";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new ClienteModel();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(rs.getString("dni"));
                listado.add(cliente);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al listar un cliente/DAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }

}
