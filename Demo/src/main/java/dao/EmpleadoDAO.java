package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.EmpleadoModel;

public class EmpleadoDAO extends Conexion implements ICRUD<EmpleadoModel> {

    @Override
    public void Registrar(EmpleadoModel empleado) throws Exception {
        String sql = "INSERT INTO EMPLEADO (nombre, apellido, dni)" + "VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getDni());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al registrar/DAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void Editar(EmpleadoModel empleado) throws Exception {
        String sql = "UPDATE EMPLEADO SET nombre=?, apellido=?, dni=? WHERE id =?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getDni());
            ps.setInt(4, empleado.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al edita/DAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void Eliminar(EmpleadoModel empleado) throws Exception {
        String sql = "DELETE FROM EMPLEADO WHERE ID=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, empleado.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar/DAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void Estado(EmpleadoModel empleado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmpleadoModel> Listar() throws Exception {
        List<EmpleadoModel> listado = new ArrayList<>();
        EmpleadoModel empleado;
        String sql = "SELECT * FROM EMPLEADO";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                empleado = new EmpleadoModel();
                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setDni(rs.getString("dni"));
                listado.add(empleado);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al listar un empleado/DAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }

}
