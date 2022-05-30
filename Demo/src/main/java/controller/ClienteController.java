package controller;

import dao.ClienteDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.ClienteModel;

@Named(value = "clienteController")
@SessionScoped
@Data
public class ClienteController implements Serializable {

    private ClienteModel cliente;
    private ClienteDAO clienteDAO;
    private List<ClienteModel> listarcliente;

    public ClienteController() {

        cliente = new ClienteModel();
        clienteDAO = new ClienteDAO();
    }

    public void registrar() throws Exception {
        try {

            clienteDAO.Registrar(cliente);
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
            clienteDAO.Editar(cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Editado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "No editado con éxito"));
        }
    }

    public void eliminar(ClienteModel cli) throws Exception {
        try {
            clienteDAO.Eliminar(cli);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "No Eliminado con exito"));
        }
    }

    public void limpiar() {
        cliente = new ClienteModel();
    }

    public void listar() throws Exception {
        listarcliente = clienteDAO.Listar();
    }


}
