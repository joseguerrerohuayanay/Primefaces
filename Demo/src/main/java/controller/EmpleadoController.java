package controller;

import dao.EmpleadoDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.EmpleadoModel;

@Named(value = "empleadoController")
@SessionScoped
@Data
public class EmpleadoController implements Serializable {

    private EmpleadoModel empleado;
    private EmpleadoDAO empleadoDAO;
    private List<EmpleadoModel> listarempleado;

    public EmpleadoController() {

        empleado = new EmpleadoModel();
        empleadoDAO = new EmpleadoDAO();

    }

    public void registrar() throws Exception {
        try {

            empleadoDAO.Registrar(empleado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Registrado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "No registrado con éxito"));
        }

    }

    public void editar() throws Exception {
        try {
            empleadoDAO.Eliminar(empleado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "No modificado con éxito"));
        }
    }

    public void eliminar(EmpleadoModel emp) throws Exception {
        try {
            empleadoDAO.Eliminar(emp);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "No eliminado con éxito"));
        }
    }

    public void limpiar() {
        empleado = new EmpleadoModel();
    }

    public void listar() throws Exception {
        listarempleado = empleadoDAO.Listar();
    }

}
