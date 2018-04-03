package org.ingservicios.p1;



import org.ingservicios.p1.DTOUsuarios;
import org.ingservicios.p1.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.sql.DataSource;

//Indica que el bean es un dao
@Repository
public class DAOUsuariosJDBC implements DAOUsuariosInterface {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource; 
	
	/*El template normalmente se usará dentro del DAO y hay que
	configurarlo con un DataSource, que tendrá a su vez la configuración
	de la base de datos.
	Una forma común de hacerlo es especificando un método setter para el
	DataSource, que será usado por el framework con la técnica de
	inyección de dependencias*/
	//El template se instancia cuando el framework
	//inyecte el DataSource
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource; //Opcional
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	
	
	
	
    //Metodo que muestra los usuarios
	//Para leer una tabla, se dispone del método jdbcTemplate.query, que
	//devuelve una lista de objetos
	public List<DTOUsuarios> muestraUser() {
		String sql = "select * from usuarios";
		UsuarioMapper mapper = new UsuarioMapper();
		List<DTOUsuarios> usuarios = this.jdbcTemplate.query(sql,mapper);
		return usuarios;
		
		}
	
	//Devuelve el usuario buscado o null si no existe
		
	public DTOUsuarios buscaUsuario(String name){ 
		String sql = "select * from usuarios where Nombre = name";
		Object[ ] parametros = {name}; //Array de objetos
		UsuarioMapper mapper = new UsuarioMapper();
		List<DTOUsuarios> usuarios = this.jdbcTemplate.query(sql, parametros, mapper);
		if (usuarios.isEmpty()) return null;
		else return usuarios.get(0);
		}
	
	//Insertar usuarios
	//Para operaciones INSERT, UPDATE o DELETE se usa el método jdbcTemplate.update
	public void addUser(String name,String surname,String email) {
		String sql="INSERT INTO usuarios (Nombre, Apellidos, Email)"
				+ " VALUES ('"+name+"','"+surname+"','"+email+"');";
		//Los valores a sustituir  se pasan como un array de objetos.
		Object[ ] parametros = {name,surname,email};
		this.jdbcTemplate.update(sql, parametros);
}
	
}
