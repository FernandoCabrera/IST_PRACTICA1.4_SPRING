package org.ingservicios.p1;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	//Inyectará, como una instancia de dao, un bean de una clase que implemente el interfaz DAOUsuariosInterfaz
		@Autowired
		private DAOUsuariosInterface dao;
	
	//Anotación para asignar solicitudes web a métodos en clases de manejo de solicitudes con firmas de métodos flexibles.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	//Añadimos los servlets
	
	//Anotación para asignar solicitudes web a métodos en clases de manejo de solicitudes con firmas de métodos flexibles.
	@RequestMapping(value = "/Servlet1", method = {RequestMethod.GET,RequestMethod.POST})
	public String Servlet1  (HttpServletRequest request, Model model) {
		
		 String user="admin";
		 String pass="admin";
		
//url
			String url="home";
			String usu, password;
			
	        usu = request.getParameter("user");
	        password = request.getParameter("pass");
	        
	        
	        List <DTOUsuarios> lista = dao.muestraUser();
			
		//comprobamos que  usuario y pass sean correctos
	        if(usu.equals(user) && password.equals(pass)  ){
	        	
	            //si coincide usuario y password 
	            //Muestro el jsp con la info de bddd
	        	//Por tanto hay que recorrer la lista
	        	for(int i=0;i<lista.size();i++) {
	        		//Empleamos model.addAttribute en vez de req.setAttribute para  agregar el atributo 
	        			model.addAttribute("Nombre", lista.get(i).getNombre());
	        			model.addAttribute("Apellidos", lista.get(i).getApellidos());
	        			model.addAttribute("Email", lista.get(i).getEmail());
	        			url="usuarios";
	        			//Hay que ponerlo asi porque el servlet.context esta puesto prefix /WEB-INF/views/
			        	//Sufifix .jsp
	        			
	        			model.addAttribute("lista", lista);
	    		
	        	}	
	 }else{
	        	//Caso que no coincidan pasamos a FormRegistro jsp
	        	//Aqui es donde se hace registro
		 for(int i=0;i<lista.size();i++) {
	 		
			 model.addAttribute("Nombre", lista.get(i).getNombre());
			 model.addAttribute("Apellidos", lista.get(i).getApellidos());
			 model.addAttribute("Email", lista.get(i).getEmail());
			 url="FormRegistro";
			//Hay que ponerlo asi porque el servlet.context esta puesto prefix /WEB-INF/views/
	        	//Sufifix .jsp
				
			 model.addAttribute("lista", lista);
		
		}	
	        	
	        	 
	        }
	        
	        return url;
	        
		
	
}
	
//Anotación para asignar solicitudes web a métodos en clases de manejo de solicitudes con firmas de métodos flexibles.	
@RequestMapping(value = "/Servlet2", method = {RequestMethod.GET,RequestMethod.POST})
	public String Servlet2  (HttpServletRequest request, Model model) {
			
			String nombre = request.getParameter("Nombre");//JSP parametro
			String apellido = request.getParameter("Apellidos");
			String email = request.getParameter("Email");
			
			
			model.addAttribute("nombre", nombre);
			model.addAttribute("apellido", apellido);
			model.addAttribute("email",email);
			
			String url="";
			 //Creamos objeto Usuarios jdbc, dtusuario
			
			DAOUsuariosJDBC jdbc = new DAOUsuariosJDBC();		 
			jdbc.addUser(nombre, apellido, email);
		        	url="DatosRegistro";
		        	//Hay que ponerlo asi porque el servlet.context esta puesto prefix /WEB-INF/views/
		        	//Sufifix .jsp
	     			
	     	
	 		
	     	

				
		
		        	return url;
			
					
					
		}
}
