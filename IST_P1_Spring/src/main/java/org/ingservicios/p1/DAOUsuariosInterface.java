package org.ingservicios.p1;

import java.util.List;

import org.ingservicios.p1.DTOUsuarios;

//se recomienda organizar el acceso a una base de datos en
//componentes llamados DAOs (Objeto de Acceso a Datos)
public interface DAOUsuariosInterface {
	public DTOUsuarios buscaUsuario(String name); 
	public List<DTOUsuarios> muestraUser();
	public void addUser(String name,String surname,String email);
}
