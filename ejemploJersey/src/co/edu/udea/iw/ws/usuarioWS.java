package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.udea.iw.bl.UsuarioBL;
import com.edu.udea.iw.exception.ExceptionController;
@Path("usuario")
@Component
public class usuarioWS {
	@Autowired
	UsuarioBL usuarioBL;
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String autenticar (@QueryParam("login")String login, @QueryParam("pws")String pws) {
		String retorno = "";
		
		try {
			usuarioBL.doLogin(login, pws);
			
		}catch(ExceptionController e) {
			return e.getMessage();
		}
		return retorno;
	}
}
