
package dao;

import java.util.List;

public interface ICRUD<Generate> {
    
    public void Registrar(Generate method) throws Exception;
    public void Editar(Generate method) throws Exception;
    public void Eliminar(Generate method) throws Exception;
    public void Estado(Generate method) throws Exception;
    public List<Generate> Listar() throws Exception;
}
