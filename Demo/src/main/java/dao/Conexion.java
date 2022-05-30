package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    protected static Connection cnx = null;

    public static Connection conectar() throws Exception {

        try {
            String user = "root";
            String pwd = "";
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/demo";
            Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            System.out.println("Error en la Conexion" + e.getMessage());
        }
        return cnx;
    }

    public static void cerrarCnx() throws Exception {
        if (Conexion.cnx != null) {
            cnx.close();
        }
    }

    public static void main(String[] args) {
        Conexion cones = new Conexion();
        try {

            cones.conectar();
            if (cones.cnx == null) {
                System.out.println("Apagado");
            } else {
                System.out.println("Encendido");
            }

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public Connection getCn() {
        return cnx;
    }

    public void setCn(Connection cnx) {
        this.cnx = cnx;
    }
}
