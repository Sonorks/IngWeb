package co.edu.udea.iw.ws;


/**
 * @author Julián Vásquez Giraldo - Julivas96@gmail.com
 * @version 1.0
 * 
 */
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("saludo") //define la ruta de acceso al servicio
public class EjemploHolaMundo {
	
	@GET //define el tipo de metodo para la peticion
	@Produces(MediaType.TEXT_HTML) // el tipo de dato que retorna el servicio
	public String saludar() {
		return "Hola mundo.";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("2")
	public String saludar2() {
		return "Buenas tardes, ome";
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("3")
	public String saludarNombre(@QueryParam("a")String nombre) {
		return "Buenas tardes, ome "+nombre;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("4/{a}")
	public String saludarNombre2(@PathParam("a")String nombre) {
		return "Buenas tardes, ome "+nombre;
	}
}
