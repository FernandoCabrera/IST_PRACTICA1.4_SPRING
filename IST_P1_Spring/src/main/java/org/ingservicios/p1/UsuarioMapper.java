package org.ingservicios.p1;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//Es una clase en el que el programador implementa qué ha de hacerse para 
//cada iteración (fila), típicamente el mapeo al DTO
public class UsuarioMapper implements RowMapper{
//este mapeo sólo hace faltaimplementarlo una vez y los métodos
//del DAO lo usan simplemente mediante una instancia de la clase
	
public DTOUsuarios mapRow(ResultSet rs, int rowNum) throws SQLException{
DTOUsuarios usuario = new DTOUsuarios();
usuario.setNombre(rs.getString("Nombre"));
usuario.setApellidos(rs.getString("Apellidos"));
usuario.setEmail(rs.getString("Email"));

return usuario;
}
}
